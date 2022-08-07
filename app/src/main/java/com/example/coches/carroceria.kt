package com.example.coches

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class carroceria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carroceria)
        getSupportActionBar()?.setTitle("Carrocería");

        val next = findViewById<Button>(R.id.next);
        val prev = findViewById<Button>(R.id.back);

        next.setOnClickListener {
            val nextActivity = Intent(this, interiores::class.java)
            startActivity(nextActivity)
        }

        prev.setOnClickListener {
            val prevActivity = Intent(this, automotrices::class.java)
            startActivity(prevActivity);
        }
    }
}