package fr.raphew.valorantclicker.onClick

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.view.View
import fr.raphew.valorantclicker.R
import fr.raphew.valorantclicker.activity.MainActivity

class SageClick(mainActivity: MainActivity) : View.OnClickListener {

    val mainActivity: MainActivity = mainActivity
    var click: Int = 0
    var clickAgents: Int = 0

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.img_sage -> {
                val sharedPreferences: SharedPreferences = mainActivity.getPreferences(MODE_PRIVATE)
                click = sharedPreferences.getInt("click", 0)
                clickAgents = sharedPreferences.getInt("clickSage", 0)
                click++
                clickAgents++
                save()
                val a = "$click "
                mainActivity.textCoins.text = a
            }
        }
    }

    private fun save(){
        val click: Int = this.click
        val clickAgents: Int = this.clickAgents
        val sharedPreferences: SharedPreferences = mainActivity.getPreferences(MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("click", click)
        editor.putInt("clickSage", clickAgents)
        editor.apply()
    }
}