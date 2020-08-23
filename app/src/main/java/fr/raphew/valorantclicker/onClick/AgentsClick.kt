package fr.raphew.valorantclicker.onClick

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.util.Log
import android.view.View
import fr.raphew.valorantclicker.R
import fr.raphew.valorantclicker.activity.MainActivity
import java.text.DecimalFormat

class AgentsClick(
    mainActivity: MainActivity
) {

    val items: Array<String> = arrayOf("Sova", "Jett", "Raze", "Reyna", "Breach", "Brimstone", "Sage", "Phoenix", "Cypher", "Viper", "Omen", "Killjoy")
    val mainActivity: MainActivity = mainActivity

    fun click(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(mainActivity)
        builder.setTitle(R.string.choose_agents)
        builder.setIcon(R.drawable.ic_agents)
        builder.setSingleChoiceItems(items, -1, DialogInterface.OnClickListener { dialogInterface, i ->
            mainActivity.displayAgents(i)
            dialogInterface.dismiss()
        })
        builder.setNeutralButton(R.string.cancel_button, DialogInterface.OnClickListener { dialogInterface, _ -> dialogInterface.dismiss() })
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    var click = 0
    var coins = 0F
    var clickAgents = 0

    fun onClick(agents: String){
        val sharedPreferences: SharedPreferences = mainActivity.getPreferences(Context.MODE_PRIVATE)

        click = sharedPreferences.getInt("click", 0)
        coins = sharedPreferences.getFloat("coins", 0F)
        clickAgents = sharedPreferences.getInt("click$agents", 0)

        var shop = sharedPreferences.getInt("achat", 0)
        var valeur = ((shop * 0.1) + 1).toFloat()

        this.click++
        this.coins += valeur
        this.clickAgents++

        val df: DecimalFormat = DecimalFormat("#.#")
        var format: String = df.format(coins)
        format += " "

        mainActivity.textCoins.text = format
        save(agents)
    }

    private fun save(agents: String){
        val click = this.click
        val coins = this.coins
        val clickAgents = this.clickAgents
        val sharedPreferences: SharedPreferences = mainActivity.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("click", click)
        editor.putFloat("coins", coins)
        editor.putInt("click$agents", clickAgents)
        editor.apply()
    }


}