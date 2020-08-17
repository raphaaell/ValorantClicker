package fr.raphew.valorantclicker.onClick

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.view.View
import fr.raphew.valorantclicker.R
import fr.raphew.valorantclicker.activity.MainActivity

class SageClick(mainActivity: MainActivity) : View.OnClickListener {

    val mainActivity: MainActivity = mainActivity
    var click: Float = 0F
    var coins: Float = 0F
    var clickAgents: Float = 0F

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.img_sage -> {
                val sharedPreferences: SharedPreferences = mainActivity.getPreferences(MODE_PRIVATE)
                click = sharedPreferences.getFloat("click", 0F)
                coins = sharedPreferences.getFloat("coins", 0F)
                clickAgents = sharedPreferences.getFloat("clickSage", 0F)
                pp()
                save()
                val a = "$click "
                mainActivity.textCoins.text = a
            }
        }
    }

    private fun save(){
        val click: Float = this.click
        val coins: Float = this.coins
        val clickAgents: Float = this.clickAgents
        val sharedPreferences: SharedPreferences = mainActivity.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat("click", click)
        editor.putFloat("coins", coins)
        editor.putFloat("clickSage", clickAgents)
        editor.apply()
    }

    fun pp(){
        this.click++
        this.coins++
        this.clickAgents++
    }
}