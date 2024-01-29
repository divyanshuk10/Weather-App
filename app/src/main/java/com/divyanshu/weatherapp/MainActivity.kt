package com.divyanshu.weatherapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.divyanshu.weatherapp.databinding.ActivityMainScreenBinding
import com.divyanshu.weatherapp.utils.toWeekDay
import com.divyanshu.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainScreenBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherData.observe(this) {
            binding.apply {
                txtCity.text = buildString {
                    append("Ghaziabad")
                }
                txtTemperature.text = it.temperature
                txtDescription.text = it.description
                txtWind.text = it.wind
                txtForecastTemperatureDay1.text = it.forecast.first().day.toWeekDay()
                txtForecastDescriptionDay1.text = buildString {
                    append(it.forecast.first().temperature)
                    append(" ")
                    append(it.forecast.first().wind)
                }
                txtForecastTemperatureDay2.text = it.forecast[1].day.toWeekDay()
                txtForecastDescriptionDay2.text = buildString {
                    append(it.forecast[1].temperature)
                    append(" ")
                    append(it.forecast[1].wind)
                }

                txtForecastTemperatureDay3.text = it.forecast[2].day.toWeekDay()
                txtForecastDescriptionDay3.text = buildString {
                    append(it.forecast[2].temperature)
                    append(" ")
                    append(it.forecast[2].wind)
                }
            }
        }


//        setSupportActionBar(binding.toolbar)
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        binding.fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }
//
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}