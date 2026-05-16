package com.example.activitycalculator
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinnerWeather: Spinner = findViewById(R.id.spinnerWeather)
        val spinnerMood: Spinner = findViewById(R.id.spinnerMood)
        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val tvResult: TextView = findViewById(R.id.tvResult)
        val btnInfo: Button = findViewById(R.id.btnInfo)

        val weatherOptions = arrayOf("Choose Weather", "Sunny", "Rainy", "Cloudy")
        val moodOptions = arrayOf("Choose Mood", "Energetic", "Focused", "Calm")

        val weatherAdapter = ArrayAdapter(this, R.layout.spinner_item, weatherOptions)
        val moodAdapter = ArrayAdapter(this, R.layout.spinner_item, moodOptions)

        spinnerWeather.adapter = weatherAdapter
        spinnerMood.adapter = moodAdapter

        btnCalculate.setOnClickListener {
            val selectedWeather = spinnerWeather.selectedItem.toString()
            val selectedMood = spinnerMood.selectedItem.toString()

            if (selectedWeather == "Choose Weather" || selectedMood == "Choose Mood") {
                tvResult.text = "Please select both a weather and a mood!"
            } else {
                val resultActivity = calculateActivity(selectedWeather, selectedMood)
                tvResult.text = resultActivity
            }
        }

        btnInfo.setOnClickListener {
            showInfoDialog()
        }
    }

    private fun calculateActivity(weather: String, mood: String): String {
        return if (weather == "Rainy" && mood == "Focused") {
            "Grab your coffee, sit at your computer, and advance the level designs of your 2D pixel art game project in Unity."
        } else if (weather == "Cloudy" && mood == "Calm") {
            "A great day to open the markets and analyze the latest charts of NVIDIA or tech ETFs in detail."
        } else if (weather == "Sunny" && mood == "Calm") {
            "Log into your eBay store, organize orders, and reply to pending customer messages with a relaxed mind."
        } else if (weather == "Sunny" && mood == "Energetic") {
            "Get up from the screen, put on your shoes, and go for a brisk walk outside."
        } else {
            "The best thing for your current mood and weather: Put on your favorite music and just enjoy the moment!"
        }
    }

    private fun showInfoDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("How it works?")
        builder.setMessage("This app 'calculates' the best activity for you by combining the weather outside with your current mood. Instead of numbers, make your choices to find out how to spend your day and click 'Calculate'")
        builder.setPositiveButton("Got it") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}