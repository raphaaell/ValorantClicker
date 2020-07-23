package fr.raphew.valorantclicker.dialog


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import fr.raphew.valorantclicker.R


class SettingsDialog : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View? = inflater.inflate(R.layout.settings_dialog, container, false)

        return v
    }
}