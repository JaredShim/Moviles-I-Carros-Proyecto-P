package com.example.coches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class upsertCar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upsert_car)
        getSupportActionBar()?.setTitle("Modifica o crea un nuevo reporte");

        val noSerie = findViewById<EditText>(R.id.noSerie).text;
        val continueBtn = findViewById<Button>(R.id.continueBtn);

        continueBtn.setOnClickListener{
            val call = getRetrofit().create(APIService::class.java).searchSerie("serie/$noSerie").execute()
            val resBody = call.body()

//            Si regresa un carro entonces evanzamos a la primer pantalla de captura de datos y le mandamos el id para que lo pueda consultar y cargar los datos
//            Si no regresa un carro entonces avanzamos a la primer pantalla de captura de datos y no le mandamos el id para que sepa que se debe de crear el carro
        }

    }

    private fun createJsonRequestBody(vararg params: Pair<String, Editable>) =
        RequestBody.create(
            okhttp3.MediaType.parse("application/json; charset=utf-8"),
            JSONObject(mapOf(*params)).toString())

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://127.0.0.1:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}