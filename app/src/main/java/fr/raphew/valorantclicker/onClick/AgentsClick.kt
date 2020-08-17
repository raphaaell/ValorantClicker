package fr.raphew.valorantclicker.onClick

import android.app.AlertDialog
import android.content.DialogInterface
import fr.raphew.valorantclicker.R
import fr.raphew.valorantclicker.activity.MainActivity

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
            mainActivity.agentsToShow(i)
            dialogInterface.dismiss()
        })
        builder.setNeutralButton(R.string.cancel_button, DialogInterface.OnClickListener { dialogInterface, _ -> dialogInterface.dismiss() })
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


}