package fr.raphew.valorantclicker.onClick

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import fr.raphew.valorantclicker.R
import fr.raphew.valorantclicker.activity.MainActivity

class CypherClick(mainActivity: MainActivity) : View.OnClickListener {

    val mainActivity: MainActivity = mainActivity
    var click: Int = 0
    var coins: Int = 0
    var clickAgents: Int = 0

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.img_cypher -> {
                val sharedPreferences: SharedPreferences = mainActivity.getPreferences(Context.MODE_PRIVATE)
                click = sharedPreferences.getInt("click", 0)
                coins = sharedPreferences.getInt("coins", 0)
                clickAgents = sharedPreferences.getInt("clickCypher", 0)
                pp()
                save()
                val a = "$click "
                mainActivity.textCoins.text = a
            }
        }
    }

    private fun save(){
        val click: Int = this.click
        val coins: Int = this.coins
        val clickAgents: Int = this.clickAgents
        val sharedPreferences: SharedPreferences = mainActivity.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("click", click)
        editor.putInt("coins", coins)
        editor.putInt("clickCypher", clickAgents)
        editor.apply()
    }

    fun pp(){
        this.click++
        this.coins++
        this.clickAgents++
    }
}