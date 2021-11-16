package com.example.reserva_ya_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class Hacer_Reserva : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val db = FirebaseFirestore.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hacer_reserva)

        val nombreen : EditText = findViewById(R.id.nombreen)
        val numeropersonas : EditText = findViewById(R.id.numeroper)
        val nombreh : String? = intent.getStringExtra("nombre_hotelreserva")
        val otroemail : EditText = findViewById(R.id.otroemail)
        val fecha : EditText = findViewById(R.id.fecha)
        val telefono : EditText = findViewById(R.id.telefono)
        val hacerreservab : Button = findViewById(R.id.hacerreserva)

        hacerreservab.setOnClickListener {

            if (nombreen.text.isNotEmpty() && numeropersonas.text.isNotEmpty() && otroemail.text.isNotEmpty() &&
                fecha.text.isNotEmpty() && telefono.text.isNotEmpty() )
            {

               if (nombreh != null) {
                    db.collection("Hoteles").document(nombreh).get().addOnSuccessListener()
                    {

                        val cuposh  = it.get("cupos") as Int
                        val npersonas = numeropersonas.text.toString().toInt()
                        val total = cuposh - npersonas
                        db.collection("Hoteles").document(nombreh).update(
                            hashMapOf("cupos" to total.toString()) as Map<String, Any>
                        )
                    }


                }
                    db.collection("Reservas").document(otroemail.text.toString()).set(
                            hashMapOf(
                                "nombre" to nombreen.text.toString(),
                                "numero Personas" to numeropersonas.text.toString(),
                                "fecha" to fecha.text.toString(),
                                "telefono" to telefono.text.toString()
                            )

                        )

                Toast.makeText(this,"Reserva Realizada",Toast.LENGTH_SHORT).show()
            }
                else if (nombreen.text.isEmpty() || numeropersonas.text.isEmpty() || otroemail.text.isEmpty() ||
                fecha.text.isEmpty() || telefono.text.isEmpty()
            ) {
                Toast.makeText(this, "Los campos deben ser llenados", Toast.LENGTH_LONG).show()
            }
        }

}

}




