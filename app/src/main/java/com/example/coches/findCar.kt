package com.example.coches

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class findCar : AppCompatActivity() {
    private fun toast(){
        val text = "Folio no encontrado"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_car)
        getSupportActionBar()?.setTitle("Modificación de reporte");

        val folio = findViewById<EditText>(R.id.noSerie).text;
        val continueBtn = findViewById<Button>(R.id.continueBtn);
        val collectData = Intent(this, generales_motor::class.java)

        continueBtn.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                val call = getRetrofit().create(APIService::class.java).searchFolio("evaluacion/folio/$folio").execute()
                val resBody = call.body() as searchFolioRes
                runOnUiThread {
                    if (resBody?.status == "200") {
                        collectData.putExtra("evaluacionId", resBody.evaluation.id)
                        startActivity(collectData)
                    }else{
                        toast()
                    }
                }
            }
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
            .baseUrl("http://192.168.100.104:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}