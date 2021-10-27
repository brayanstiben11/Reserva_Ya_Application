package com.example.reserva_ya_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Registrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        val login : Button = findViewById(R.id.gologin)
        val new : Button = findViewById(R.id.signup)
        val nombre : EditText = findViewById(R.id.Nombre)
        val email : EditText = findViewById(R.id.email)
        val pass : EditText = findViewById(R.id.Password)

        login.setOnClickListener()
        {
            val intent = Intent (this, MainActivity ::class.java)
            startActivity(intent)
        }

        new.setOnClickListener()
        {
            if(nombre.text.isNotEmpty() && email.text.isNotEmpty() && pass.text.isNotEmpty()) {
                val intent = Intent(this, Perfil::class.java)
                intent.putExtra("nombre", nombre.text.toString())
                intent.putExtra("correo", email.text.toString())
                intent.putExtra("password", pass.text.toString())
                startActivity(intent)
            }
            else if (nombre.text.isEmpty() || email.text.isEmpty() || pass.text.isEmpty())
            {
                Toast.makeText(this,"Los campos deben ser llenados", Toast.LENGTH_LONG).show()
            }
        }

    }
}