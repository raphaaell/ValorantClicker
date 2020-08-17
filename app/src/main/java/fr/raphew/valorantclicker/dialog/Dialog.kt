package fr.raphew.valorantclicker.dialog

import android.annotation.SuppressLint
import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import fr.raphew.valorantclicker.R
import fr.raphew.valorantclicker.activity.MainActivity
import fr.raphew.valorantclicker.activity.SplashActivity

@SuppressLint("ValidFragment")
class Dialog(splashActivity: SplashActivity) : DialogFragment() {

    lateinit var mActionOk: TextView

    var main: SplashActivity = splashActivity

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View? = inflater?.inflate(R.layout.dialog, container, false)

        mActionOk = v!!.findViewById(R.id.action_ok)

        mActionOk.setOnClickListener {
            main.finish()
            System.exit(0)
        }

        return v
    }
}