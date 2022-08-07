package com.example.coches

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
//import com.example.coches.databinding.ActivityGeneralesMotorBinding
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class generales_motor : AppCompatActivity() {

//    private lateinit var binding: ActivityGeneralesMotorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding =ActivityGeneralesMotorBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_generales_motor)
        getSupportActionBar()?.setTitle("Generales Motor");
//        binding.next.setOnClickListener {
//
//        }
        val nextBtn = findViewById<Button>(R.id.next);

        nextBtn.setOnClickListener {
            val nextView = Intent(this, automotrices::class.java)
            startActivity(nextView)
        }
    }
    private fun createJsonRequestBody(vararg params: Pair<String, Editable>) =
        RequestBody.create(
            okhttp3.MediaType.parse("application/json; charset=utf-8"),
            JSONObject(mapOf(*params)).toString())

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.100.104:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}