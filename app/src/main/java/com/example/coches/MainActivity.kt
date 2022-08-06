package com.example.coches

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private fun toast(){
        val text = "Usuario y/o contraseña invalidos"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
    private fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://192.168.100.104:8000/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user = findViewById<EditText>(R.id.user).text;
        val password = findViewById<EditText>(R.id.password).text;
        val submitForm = findViewById<Button>(R.id.loginBtn);



        submitForm.setOnClickListener{

            if(user.toString() == "" || password.toString() == ""){
                toast()
            }else{
                val upsertCarView = Intent(this,createOrUpdateCar::class.java)
                CoroutineScope(Dispatchers.IO).launch {
                    Log.d("user", "enviando request...")
                    val call = getRetrofit().create(APIService::class.java).getUser("usuarios/$user/$password").execute()
                    Log.d("user", "conviertiendo response...")
                    val response = call.body() as getUserRes
                    runOnUiThread {
                        if(response.status != "200" ){
                            startActivity(upsertCarView)
                        }else{
                            toast()
                        }
                    }
                }
            }



        }
    }
    private fun createJsonRequestBody(vararg params: Pair<String, Editable>) =
        RequestBody.create(
            okhttp3.MediaType.parse("application/json; charset=utf-8"),
            JSONObject(mapOf(*params)).toString())
}