package com.example.reserva_ya_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Ver_Hoteles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_hoteles)

        val buscar : Button = findViewById(R.id.verhotel)
        val perfil : Button = findViewById(R.id.perfil)
        val reserva : Button = findViewById(R.id.reservas)
        val hotel1 : ImageButton = findViewById(R.id.holtel1)

        perfil.setOnClickListener()
        {
            val intent = Intent (this, Perfil :: class.java)
            startActivity(intent)
        }

        buscar.setOnClickListener()
        {
            val intent = Intent (this, Buscar_Hoteles :: class.java)
            startActivity(intent)
        }

        hotel1.setOnClickListener()
        {
            val intent = Intent (this, Detalles_hotel1 :: class.java )
            startActivity(intent)
        }

    }
}