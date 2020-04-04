package com.example.q_you

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_transaction.*

class TransactionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)
        btnPay.setOnClickListener {
            if (editCardNo.length() == 0 || editDate.length() == 0 || editCvv.length() == 0){
                Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, TicketListActivity::class.java)
                startActivity(intent)
            }
        }

        btnBack.setOnClickListener {
            val intent = Intent(this, CalendarActivity::class.java)
            startActivity(intent)
        }
    }
}
