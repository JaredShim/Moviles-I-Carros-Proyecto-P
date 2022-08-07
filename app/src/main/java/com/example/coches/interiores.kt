package com.example.coches

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class interiores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interiores)
        getSupportActionBar()?.setTitle("Interiores");

        val next = findViewById<Button>(R.id.interiores_next);
        val prev = findViewById<Button>(R.id.interiores_back);

//        next.setOnClickListener {
//            val nextActivity = Intent(this, carroceria::class.java)
//            startActivity(nextActivity)
//        }

        prev.setOnClickListener {
            val prevActivity = Intent(this, carroceria::class.java)
            startActivity(prevActivity);
        }

    }
}