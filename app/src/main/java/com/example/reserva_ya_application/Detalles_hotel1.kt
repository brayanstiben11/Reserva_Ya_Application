package com.example.reserva_ya_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Detalles_hotel1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_hotel1)

        val goreserva : Button = findViewById(R.id.hacer)

        goreserva.setOnClickListener()
        {
            val intent = Intent (this, Hacer_Reserva :: class.java )
            startActivity(intent)
        }
    }
}