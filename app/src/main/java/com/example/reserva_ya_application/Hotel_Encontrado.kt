package com.example.reserva_ya_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class Hotel_Encontrado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val db = FirebaseFirestore.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_encontrado)

        val infohotel : TextView = findViewById(R.id.infohotel)
        val nombreh : String? = intent.getStringExtra("nombre_hotel")
        val boton : Button = findViewById(R.id.ir)

        if (nombreh != null) {
            db.collection("Hoteles").document(nombreh).get().addOnSuccessListener {
                if (it.get("nombre") != null) {
                    infohotel.setText(

                        "INFORMACION DEL HOTEL ENCONTRADO: \n" +

                        "NOMBRE HOTEL: " + it.get("nombre") as String? + "\n" +
                                "HORARIO: " + it.get("Horario") as String? + "\n" +
                                "UBICACION: " + it.get("ubicacion") as String? + "\n" +
                                "CUPOS DISPONIBLES: " + it.get("cupos") + "\n" +
                    "DIRECCION: " + it.get("direccion") as String?

                    )
                }
                else
                {
                    Toast.makeText(this, "NO SE ENCONTRARON RESULTADOS",Toast.LENGTH_SHORT).show()
                }
            }
        }

        boton.setOnClickListener {
            val intent = Intent (this, Hacer_Reserva :: class.java)
            intent.putExtra("nombre_hotelreserva", nombreh)
            startActivity(intent)
        }
    }
}