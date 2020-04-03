package com.example.q_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_ticket.textViewImportedTR
import kotlinx.android.synthetic.main.activity_ticket.textViewImportedSN
import kotlinx.android.synthetic.main.activity_ticket.textViewImportedCode
import kotlinx.android.synthetic.main.activity_ticket.textViewImportedDay

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonTicket.setOnClickListener {
            val intent = Intent(this, TicketActivity::class.java)
            startActivity(intent)
        }
    }
}
