package com.example.reserva_ya_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email : EditText = findViewById(R.id.email1)
        val password : EditText = findViewById(R.id.pass)
        val iniciar : Button = findViewById(R.id.login)
        val registrar : Button = findViewById(R.id.registrar)


        iniciar.setOnClickListener()
        {
            if (email.text.toString() == "brayan" && password.text.toString() == "12345")
            {
                val intent = Intent (this, Ver_Hoteles :: class.java)
                startActivity(intent)
            }
            else if   (email.text.isEmpty() || password.text.isEmpty() )
            {
                Toast.makeText(this,"Los campos deben ser llenados", Toast.LENGTH_LONG).show()
            }
            else
            {
                Toast.makeText(this,"Los datos son invalidos", Toast.LENGTH_LONG).show()
            }


        }

        registrar.setOnClickListener()
        {
            val intent = Intent (this,Registrar::class.java)
            startActivity(intent)
        }
    }
}