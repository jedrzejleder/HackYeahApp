package com.example.q_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ticket.*

class TicketActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)
        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonKlepnijTicket.setOnClickListener {
            textViewImportedDay.text = "Monday"
            textViewImportedSN.text = "Biedra"
            textViewImportedTR.text = "4:20 PM"
            textViewImportedCode.text = "696969"

        }
    }


}
