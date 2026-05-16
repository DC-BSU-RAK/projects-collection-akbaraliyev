package com.example.ekotechportfolio
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetailTitle: TextView = findViewById(R.id.tvDetailTitle)
        val tvDetailDesc: TextView = findViewById(R.id.tvDetailDesc)
        val ivDetailChart: ImageView = findViewById(R.id.ivDetailChart)
        val btnBack: Button = findViewById(R.id.btnBack)

        val assetName = intent.getStringExtra("ASSET_NAME") ?: "Unknown Asset"
        tvDetailTitle.text = assetName

        when (assetName) {
            "NVIDIA (NVDA)" -> {
                ivDetailChart.setImageResource(R.drawable.nvda_chart)
                tvDetailDesc.text = "NVIDIA continues to lead the AI and semiconductor sector with strong market momentum. Review the latest technical analysis charts below."
            }
            "Apple Inc. (AAPL)" -> {
                ivDetailChart.setImageResource(R.drawable.aapl_chart)
                tvDetailDesc.text = "Apple's hardware ecosystem and growing services segment drive stable revenues. Check the current stock performance metrics."
            }
            "Eos Energy Enterprises Inc (EOSE)" -> {
                ivDetailChart.setImageResource(R.drawable.eose_chart)
                tvDetailDesc.text = "Eos Energy focuses on innovative clean energy storage solutions. Monitor the latest project updates and financial charts below."
            }
            "Innoviz Technologies Ltd. (INVZ)" -> {
                ivDetailChart.setImageResource(R.drawable.invz_chart)
                tvDetailDesc.text = "Innoviz Technologies provides advanced LiDAR sensors and perception software for autonomous vehicles. Review the recent market charts."
            }
            "Palantir Technologies Inc. (PLTR)" -> {
                ivDetailChart.setImageResource(R.drawable.pltr_chart)
                tvDetailDesc.text = "Palantir's enterprise data platforms and AI solutions are expanding rapidly across industries. Inspect the quarterly performance trends."
            }
            "SoFi Technologies, Inc. (SOFI)" -> {
                ivDetailChart.setImageResource(R.drawable.sofi_chart)
                tvDetailDesc.text = "SoFi Technologies delivers comprehensive digital financial services and fintech platforms. Check the current price action and analysis."
            }
            else -> {
                tvDetailDesc.text = "Asset market details and analysis will appear here."
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}