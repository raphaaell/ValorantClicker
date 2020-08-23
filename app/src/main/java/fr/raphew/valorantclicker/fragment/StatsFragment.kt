package fr.raphew.valorantclicker.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import fr.raphew.valorantclicker.R
import fr.raphew.valorantclicker.activity.MainActivity
import java.text.DecimalFormat

class StatsFragment(mainActivity: MainActivity) : Fragment() {

    val mainActivity: MainActivity = mainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.stats_fragment, container, false)
        val df = DecimalFormat("#.#")

        val sharedPreferences = mainActivity.getPreferences(Context.MODE_PRIVATE)

        val textStatsTotalClicks: TextView = v.findViewById(R.id.stats_total_clicks)
        val totalClicks = sharedPreferences.getInt("click", 0)
        val valueTotalClicks: String = getString(R.string.stats_total_clicks) + " " + totalClicks.toString() + " " +  getString(R.string.stats_name_clicks)
        textStatsTotalClicks.text = valueTotalClicks

        val textStatsSovaClicks: TextView = v.findViewById(R.id.stats_sova_clicks)
        val sovaClicks = sharedPreferences.getInt("clickSova", 0)
        val valueSovaClicks: String = getString(R.string.stats_sova_clicks) + " " + sovaClicks.toString() + " " + getString(R.string.stats_name_clicks)
        textStatsSovaClicks.text = valueSovaClicks

        val textStatsRazeClicks: TextView = v.findViewById(R.id.stats_raze_clicks)
        val razeClicks = sharedPreferences.getInt("clickRaze", 0)
        val valueRazeClicks: String = getString(R.string.stats_raze_clicks) + " " + razeClicks.toString() + " " + getString(R.string.stats_name_clicks)
        textStatsRazeClicks.text = valueRazeClicks

        val textStatsSageClicks: TextView = v.findViewById(R.id.stats_sage_clicks)
        val sageClicks = sharedPreferences.getInt("clickSage", 0)
        val valueSageClicks: String = getString(R.string.stats_sage_clicks) + " " + sageClicks.toString() + " " + getString(R.string.stats_name_clicks)
        textStatsSageClicks.text = valueSageClicks

        val textStatsReynaClicks: TextView = v.findViewById(R.id.stats_reyna_clicks)
        val reynaClicks = sharedPreferences.getInt("clickReyna", 0)
        val valueReynaClicks: String = getString(R.string.stats_reyna_clicks) + " " + reynaClicks.toString() + " " + getString(R.string.stats_name_clicks)
        textStatsReynaClicks.text = valueReynaClicks

        val textStatsPhoenixClicks: TextView = v.findViewById(R.id.stats_phoenix_clicks)
        val phoenixClicks = sharedPreferences.getInt("clickPhoenix", 0)
        val valuePhoenixClicks: String = getString(R.string.stats_phoenix_clicks) + " " + phoenixClicks.toString() + " " + getString(R.string.stats_name_clicks)
        textStatsPhoenixClicks.text = valuePhoenixClicks

        val textStatsBreachClicks: TextView = v.findViewById(R.id.stats_breach_clicks)
        val breachClicks = sharedPreferences.getInt("clickBreach", 0)
        val valueBreachClicks: String = getString(R.string.stats_breach_clicks) + " " + breachClicks.toString() + " " + getString(R.string.stats_name_clicks)
        textStatsBreachClicks.text = valueBreachClicks

        val textStatsBrimstoneClicks: TextView = v.findViewById(R.id.stats_brimstone_clicks)
        val brimstoneClicks = sharedPreferences.getInt("clickBrimstone", 0)
        val valueBrimstoneClicks: String = getString(R.string.stats_brimstone_clicks) + " " + brimstoneClicks.toString() + " " + getString(R.string.stats_name_clicks)
        textStatsBrimstoneClicks.text = valueBrimstoneClicks

        val textStatsJettClicks: TextView = v.findViewById(R.id.stats_jett_clicks)
        val jettClicks = sharedPreferences.getInt("clickJett", 0)
        val valueJettClicks: String = getString(R.string.stats_jett_clicks) + " " + jettClicks.toString() + " " + getString(R.string.stats_name_clicks)
        textStatsJettClicks.text = valueJettClicks

        val textStatsViperClicks: TextView = v.findViewById(R.id.stats_viper_clicks)
        val viperClicks = sharedPreferences.getInt("clickViper", 0)
        val valueViperClicks: String = getString(R.string.stats_viper_clicks) + " " + viperClicks.toString() + " " + getString(R.string.stats_name_clicks)
        textStatsViperClicks.text = valueViperClicks

        val textStatsCypherClicks: TextView = v.findViewById(R.id.stats_cypher_clicks)
        val cypherClicks = sharedPreferences.getInt("clickCypher", 0)
        val valueCypherClicks: String = getString(R.string.stats_cypher_clicks) + " " + cypherClicks.toString() + " " + getString(R.string.stats_name_clicks)
        textStatsCypherClicks.text = valueCypherClicks

        val textStatsOmenClicks: TextView = v.findViewById(R.id.stats_omen_clicks)
        val omenClicks = sharedPreferences.getInt("clickOmen", 0)
        val valueOmenClicks: String = getString(R.string.stats_omen_clicks) + " " + omenClicks.toString() + " " + getString(R.string.stats_name_clicks)
        textStatsOmenClicks.text = valueOmenClicks

        val textStatsKilljoyClicks: TextView = v.findViewById(R.id.stats_killjoy_clicks)
        val killjoyClicks = sharedPreferences.getInt("clickKilljoy", 0)
        val valueKilljoyClicks: String = getString(R.string.stats_killjoy_clicks) + " " + killjoyClicks.toString() + " " + getString(R.string.stats_name_clicks)
        textStatsKilljoyClicks.text = valueKilljoyClicks

        val textStatsCurrentCoins: TextView = v.findViewById(R.id.stats_current_money)
        val currentCoins = sharedPreferences.getFloat("coins", 0F)
        val valueCurrentCoins: String = getString(R.string.stats_current_coins) + " " + df.format(currentCoins) + " "
        textStatsCurrentCoins.text = valueCurrentCoins

        return v
    }
}