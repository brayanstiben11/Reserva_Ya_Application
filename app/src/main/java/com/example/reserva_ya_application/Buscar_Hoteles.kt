package com.example.reserva_ya_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.get
import com.google.firebase.firestore.FirebaseFirestore

class Buscar_Hoteles : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_hoteles)

        val buscarb: Button = findViewById(R.id.buscar)
        val hotel: EditText = findViewById(R.id.buscar1)

        buscarb.setOnClickListener {

            if (hotel.text.isNotEmpty()) {

                val intent = Intent(this, Hotel_Encontrado:: class.java)
                intent.putExtra("nombre_hotel", hotel.text.toString())
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"INGRESA EL NOMBRE DE UN HOTEL",Toast.LENGTH_SHORT).show()
            }
        }

    }
}