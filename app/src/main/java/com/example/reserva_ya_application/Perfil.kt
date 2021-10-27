package com.example.reserva_ya_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val salir : Button = findViewById(R.id.logout)
        val nombre1 : String? = intent.getStringExtra("nombre")
        val correo1 : String? = intent.getStringExtra("correo")
        val pass1 : String? = intent.getStringExtra("password")
        val nombre : EditText = findViewById(R.id.name1)
        val correo :EditText = findViewById(R.id.correo1)
        val pass : EditText = findViewById(R.id.contra1)
        val verhot : Button = findViewById(R.id.main)

        salir.setOnClickListener()
        {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

        verhot.setOnClickListener()
        {
            val intent = Intent(this,Ver_Hoteles :: class.java)
            startActivity(intent)
        }

        nombre.setText(nombre1)
        correo.setText(correo1)
        pass.setText(pass1)
    }
}