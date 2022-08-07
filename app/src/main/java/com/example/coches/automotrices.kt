package com.example.coches

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class automotrices : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.automotrices)
        getSupportActionBar()?.setTitle("Automotrices");

        val next = findViewById<Button>(R.id.next);
        val prev = findViewById<Button>(R.id.back);

        next.setOnClickListener {
            val nextActivity = Intent(this, carroceria::class.java)
            startActivity(nextActivity)
        }

        prev.setOnClickListener {
            val prevActivity = Intent(this, generales_motor::class.java)
            startActivity(prevActivity);
        }
    }
}