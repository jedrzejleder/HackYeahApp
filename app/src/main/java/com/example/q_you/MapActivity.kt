package com.example.q_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.q_you.models.FavShops
import com.example.q_you.models.Place
import kotlinx.android.synthetic.main.activity_map.*
private const val TAG = "Main Activity"
const val EXTRA_USER_MAP = "EXTRA USER MAP"
class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        val favShops = generateSampleData()
        rvMaps.layoutManager=LinearLayoutManager(this)

        rvMaps.adapter = MapsAdapter(this, favShops, object : MapsAdapter.OnClickListener{
            override fun onItemClick(position: Int) {
               Log.i(TAG, "onItemClick $position")
               val intent = Intent(this@MapActivity,DisplayMap::class.java)
                intent.putExtra(EXTRA_USER_MAP, favShops[position])
               startActivity(intent)
            }

        })


    }

    private fun generateSampleData(): List<FavShops> {
        return listOf(
            FavShops(
                "Interbarszcze",
                listOf(
                    Place("Aleksandrów", "Senatorska 4", 51.8064852,19.0557286)
                )
            ),
            FavShops("Libl",
                listOf(
                    Place("Aleksandrów", "Wojska Polskiego 95", 51.8152441,19.3209986)
                )),
            FavShops("SOLOmarket",
                listOf(
                    Place("Aleksandrów", "Piłsudskiego 2/4", 51.812665,19.313972)

                )
            ),
            FavShops("PESCO",
                listOf(
                    Place("Aleksandrów", "Południowa 1/3", 51.8164371,19.2932598)
                )
            )
        )
    }
}
