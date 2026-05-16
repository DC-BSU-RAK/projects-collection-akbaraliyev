package com.example.ekotechportfolio
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvCurrency: TextView
    private val PREFS_NAME = "PortfolioPrefs"
    private val KEY_CURRENCY = "currency"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCurrency = findViewById(R.id.tvCurrency)
        val portfolioList: ListView = findViewById(R.id.portfolioList)
        val btnSettings: Button = findViewById(R.id.btnSettings)

        loadCurrencyPreference()

        val assets = arrayOf("NVIDIA (NVDA)", "Apple Inc. (AAPL)", "Eos Energy Enterprises Inc (EOSE)", "Innoviz Technologies Ltd. (INVZ)", "Palantir Technologies Inc. (PLTR)", "SoFi Technologies, Inc. (SOFI)")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, assets)
        portfolioList.adapter = adapter

        portfolioList.setOnItemClickListener { _, _, position, _ ->
            val selectedAsset = assets[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("ASSET_NAME", selectedAsset)
            startActivity(intent)
        }

        btnSettings.setOnClickListener {
            showPreferenceDialog()
        }
    }

    private fun loadCurrencyPreference() {
        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val savedCurrency = prefs.getString(KEY_CURRENCY, "Not Selected")
        tvCurrency.text = "Preferred Currency: $savedCurrency"
    }

    private fun showPreferenceDialog() {
        val options = arrayOf("USD ($)", "EUR (€)", "AZN (₼)")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Select Preferred Currency")
        builder.setItems(options) { dialog, which ->
            val selected = options[which]
            saveCurrencyPreference(selected)
            dialog.dismiss()
        }
        builder.show()
    }

    private fun saveCurrencyPreference(currency: String) {
        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().putString(KEY_CURRENCY, currency).apply()
        loadCurrencyPreference()
    }
}