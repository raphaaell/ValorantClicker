package fr.raphew.valorantclicker.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import fr.raphew.valorantclicker.R
import fr.raphew.valorantclicker.activity.MainActivity

class ShopFragment(mainActivity: MainActivity) : Fragment() {

    val mainActivity: MainActivity = mainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.shop_fragment, container, false)

        val sharedPreferences = mainActivity.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val shopButton: Button = v.findViewById(R.id.button_shop)
        shopButton.setOnClickListener {
            var shop = sharedPreferences.getInt("achat", 0)
            shop++
            Log.d("SD", "shop : $shop")
            editor.putInt("achat", shop)
                .apply()
        }

        return v
    }
}