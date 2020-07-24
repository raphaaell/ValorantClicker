package fr.raphew.valorantclicker.onClick

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.view.View
import fr.raphew.valorantclicker.R
import fr.raphew.valorantclicker.activity.MainActivity

class SageClick(mainActivity: MainActivity) : View.OnClickListener {

    val mainActivity: MainActivity = mainActivity
    var click: Int = 0
    var coins: Int = 0
    var clickAgents: Int = 0

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.img_sage -> {
                val sharedPreferences: SharedPreferences = mainActivity.getPreferences(MODE_PRIVATE)
                click = sharedPreferences.getInt("click", 0)
                coins = sharedPreferences.getInt("coins", 0)
                clickAgents = sharedPreferences.getInt("clickSage", 0)
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
        editor.putInt("clickSage", clickAgents)
        editor.apply()
    }

    fun pp(){
        this.click++
        this.coins++
        this.clickAgents++
    }
}