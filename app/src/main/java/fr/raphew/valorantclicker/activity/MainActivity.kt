package fr.raphew.valorantclicker.activity

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import fr.raphew.valorantclicker.R
import fr.raphew.valorantclicker.dialog.SettingsDialog
import fr.raphew.valorantclicker.fragment.AboutFragment
import fr.raphew.valorantclicker.fragment.ShopFragment
import fr.raphew.valorantclicker.fragment.StatsFragment
import fr.raphew.valorantclicker.onClick.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawer: DrawerLayout
    lateinit var navigationView: NavigationView

    val items: Array<String> = arrayOf("Sova", "Jett", "Raze", "Reyna", "Breach", "Brimstone", "Sage", "Phoenix", "Cypher", "Viper", "Omen", "Killjoy")

    lateinit var imgSova: ImageView
    lateinit var imgRaze: ImageView
    lateinit var imgSage: ImageView
    lateinit var imgOmen: ImageView
    lateinit var imgPhoenix: ImageView
    lateinit var imgBreach: ImageView
    lateinit var imgBrimstone: ImageView
    lateinit var imgReyna: ImageView
    lateinit var imgJett: ImageView
    lateinit var imgViper: ImageView
    lateinit var imgCypher: ImageView
    lateinit var imgKilljoy: ImageView

    lateinit var textCoins: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setTitle(R.string.menu)

        textCoins = findViewById(R.id.textCoins)

        imgSova = findViewById(R.id.img_sova)
        imgRaze = findViewById(R.id.img_raze)
        imgSage = findViewById(R.id.img_sage)
        imgOmen = findViewById(R.id.img_omen)
        imgPhoenix = findViewById(R.id.img_phoenix)
        imgBreach = findViewById(R.id.img_breach)
        imgBrimstone = findViewById(R.id.img_brimstone)
        imgReyna = findViewById(R.id.img_reyna)
        imgJett = findViewById(R.id.img_jett)
        imgViper = findViewById(R.id.img_viper)
        imgCypher = findViewById(R.id.img_cypher)
        imgKilljoy = findViewById(R.id.img_killjoy)

        imgSova.setOnClickListener(SovaClick(this))
        imgRaze.setOnClickListener(RazeClick(this))
        imgSage.setOnClickListener(SageClick(this))
        imgOmen.setOnClickListener(OmenClick(this))
        imgPhoenix.setOnClickListener(PhoenixClick(this))
        imgBreach.setOnClickListener(BreachClick(this))
        imgBrimstone.setOnClickListener(BrimstoneClick(this))
        imgReyna.setOnClickListener(ReynaClick(this))
        imgJett.setOnClickListener(JettClick(this))
        imgViper.setOnClickListener(ViperClick(this))
        imgCypher.setOnClickListener(CypherClick(this))
        imgKilljoy.setOnClickListener(KilljoyClick(this))


        val agentsButton: ImageView = findViewById(R.id.agents_button_clicker)
        val shopButton: ImageView = findViewById(R.id.shop_button_clicker)
        agentsButton.setOnClickListener { AgentsClick(this).click() }
        shopButton.setOnClickListener {
            saveCurrentAgents()
            goneAll()
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ShopFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_shop)
        }

        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val click = sharedPreferences.getFloat("click", 0F)
        val a: String = "$click "
        textCoins.text = a

        displayOldAgents()

        if(savedInstanceState == null){
            navigationView.setCheckedItem(R.id.nav_home)
        }

        val patch01: Boolean = sharedPreferences.getBoolean("patch01", false)
        if(!patch01){
            reset()
            editor.putBoolean("patch01", true)
            editor.apply()
        }

        val firstTime: Boolean = sharedPreferences.getBoolean("firstTime", true)
        if(firstTime){
            AgentsClick(this).click()
            editor.putBoolean("firstTime", false)
            editor.apply()
        }

        val patch02: Boolean = sharedPreferences.getBoolean("patch02", false)
        if(!patch02){
            reset()
            editor.putBoolean("patch02", true)
            editor.apply()
        }

    }

    override fun onUserLeaveHint() {
        saveCurrentAgents()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            // home
            R.id.nav_home -> {
                try {
                    displayOldAgents()
                    supportFragmentManager.beginTransaction().hide(supportFragmentManager.fragments.last()).commit()
                }catch (e: Exception){ }
            }

            // agents
            R.id.nav_agents -> AgentsClick(this).click()

            // shop
            R.id.nav_shop -> {
                saveCurrentAgents()
                goneAll()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ShopFragment()).commit()
            }

            // stats
            R.id.nav_stats -> {
                saveCurrentAgents()
                goneAll()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, StatsFragment(this)).commit()
            }

            // settings
            R.id.nav_settings -> {
                /* val dialog = SettingsDialog()
                dialog.show(supportFragmentManager, "dialog")
                */

                Toast.makeText(this, getString(R.string.soon), Toast.LENGTH_LONG).show()
            }

            // about
            R.id.nav_about -> {
                saveCurrentAgents()
                goneAll()
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, AboutFragment()).commit()
            }
        }

        drawer.closeDrawer(GravityCompat.START)

        return true
    }

    private fun goneAll(){
        imgSova.visibility = View.GONE
        imgRaze.visibility = View.GONE
        imgSage.visibility = View.GONE
        imgOmen.visibility = View.GONE
        imgPhoenix.visibility = View.GONE
        imgBreach.visibility = View.GONE
        imgBrimstone.visibility = View.GONE
        imgReyna.visibility = View.GONE
        imgJett.visibility = View.GONE
        imgViper.visibility = View.GONE
        imgCypher.visibility = View.GONE
        imgKilljoy.visibility = View.GONE
    }

    fun agentsToShow(index: Int){
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val choice: String = items[index]
        goneAll()
        when (choice) {
            "Sova" -> {
                editor.putString("agents", "Sova")
                imgSova.visibility = View.VISIBLE
            }
            "Raze" -> {
                editor.putString("agents", "Raze")
                imgRaze.visibility = View.VISIBLE
            }
            "Sage" -> {
                editor.putString("agents", "Sage")
                imgSage.visibility = View.VISIBLE
            }
            "Omen" -> {
                editor.putString("agents", "Omen")
                imgOmen.visibility = View.VISIBLE
            }
            "Phoenix" -> {
                editor.putString("agents", "Phoenix")
                imgPhoenix.visibility = View.VISIBLE
            }
            "Breach" -> {
                editor.putString("agents", "Breach")
                imgBreach.visibility = View.VISIBLE
            }
            "Brimstone" -> {
                editor.putString("agents", "Brimstone")
                imgBrimstone.visibility = View.VISIBLE
            }
            "Reyna" -> {
                editor.putString("agents", "Reyna")
                imgReyna.visibility = View.VISIBLE
            }
            "Jett" -> {
                editor.putString("agents", "Jett")
                imgJett.visibility = View.VISIBLE
            }
            "Viper" -> {
                editor.putString("agents", "Viper")
                imgViper.visibility = View.VISIBLE
            }
            "Cypher" -> {
                editor.putString("agents", "Cypher")
                imgCypher.visibility = View.VISIBLE
            }
            "Killjoy" -> {
                editor.putString("agents", "Killjoy")
                imgKilljoy.visibility = View.VISIBLE
            }
        }

        editor.apply()
    }

    fun agentsToShow(index: String){
        goneAll()
        when (index) {
            "Sova" -> imgSova.visibility = View.VISIBLE
            "Raze" -> imgRaze.visibility = View.VISIBLE
            "Sage" -> imgSage.visibility = View.VISIBLE
            "Omen" -> imgOmen.visibility = View.VISIBLE
            "Phoenix" -> imgPhoenix.visibility = View.VISIBLE
            "Breach" -> imgBreach.visibility = View.VISIBLE
            "Brimstone" -> imgBrimstone.visibility = View.VISIBLE
            "Reyna" -> imgReyna.visibility = View.VISIBLE
            "Jett" -> imgJett.visibility = View.VISIBLE
            "Viper" -> imgViper.visibility = View.VISIBLE
            "Cypher" -> imgCypher.visibility = View.VISIBLE
            "Killjoy" -> imgKilljoy.visibility = View.VISIBLE
        }
    }

    fun saveCurrentAgents(){
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        if(imgSova.visibility == View.VISIBLE)
            editor.putString("agents", "Sova")
        else if(imgRaze.visibility == View.VISIBLE)
            editor.putString("agents", "Raze")
        else if(imgSage.visibility == View.VISIBLE)
            editor.putString("agents", "Sage")
        else if(imgOmen.visibility == View.VISIBLE)
            editor.putString("agents", "Omen")
        else if(imgPhoenix.visibility == View.VISIBLE)
            editor.putString("agents", "Phoenix")
        else if(imgBreach.visibility == View.VISIBLE)
            editor.putString("agents", "Breach")
        else if(imgBrimstone.visibility == View.VISIBLE)
            editor.putString("agents", "Brimstone")
        else if(imgReyna.visibility == View.VISIBLE)
            editor.putString("agents", "Reyna")
        else if(imgJett.visibility == View.VISIBLE)
            editor.putString("agents", "Jett")
        else if(imgViper.visibility == View.VISIBLE)
            editor.putString("agents", "Viper")
        else if(imgCypher.visibility == View.VISIBLE)
            editor.putString("agents", "Cypher")
        else if (imgKilljoy.visibility == View.VISIBLE)
            editor.putString("agents", "Killjoy")

        editor.apply()
    }

    fun displayOldAgents(){
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val agents: String? = sharedPreferences.getString("agents", "Sova")
        if (agents != null)
            agentsToShow(agents)
        else
            imgSova.visibility = View.VISIBLE
    }

    fun reset(){
        val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor
            .remove("click")
            .remove("coins")
            .remove("clickSova")
            .remove("clickRaze")
            .remove("clickJett")
            .remove("clickReyna")
            .remove("clickBreach")
            .remove("clickBrimstone")
            .remove("clickSage")
            .remove("clickPhoenix")
            .remove("clickCypher")
            .remove("clickViper")
            .remove("clickOmen")
            .remove("clickKilljoy")
            .remove("agents")
            .apply()
    }

}

