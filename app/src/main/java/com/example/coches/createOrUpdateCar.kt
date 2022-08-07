package com.example.coches

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class createOrUpdateCar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_or_update_car)
        getSupportActionBar()?.setTitle("Creación o modificación de reporte");
        val updateBtn = findViewById<Button>(R.id.updateBtn)
        val createBtn = findViewById<Button>(R.id.createBtn)

        updateBtn.setOnClickListener {
            val createOrUpdateCar = Intent(this, findCar::class.java )
            startActivity(createOrUpdateCar)
        }
        createBtn.setOnClickListener {
            val generalesMotor = Intent(this, generales_motor::class.java)
            generalesMotor.putExtra("evaluacionId", "")
            startActivity(generalesMotor)
        }
    }
}