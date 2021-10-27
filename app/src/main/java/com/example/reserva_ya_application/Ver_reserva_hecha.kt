package com.example.reserva_ya_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Ver_reserva_hecha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_reserva_hecha)

        val nombrencargado : String? = intent.getStringExtra("nombrepersona")
        val personas : String? = intent.getStringExtra("personas")
        val fecha : String? = intent.getStringExtra("fechallegada")
        val extraemail : String? = intent.getStringExtra("otroemail")
        val telefono : String? = intent.getStringExtra("numerotel")
        val resumen : TextView = findViewById(R.id.resumenreserva)

        resumen.setText(

            "SE HA REALIZADO LA RESERVA SATISFACTORIAMETE "+ "\n" +
                    "LA RESERVA QUEDO BAJO EL NOMBRE DE $nombrencargado PARA $personas persona (s)  " + "\n"
        + "EL DIA DE LLEGADA AL HOTEL VASOLAR SERA $fecha, MAS DETALLES SERAN ENVIADOS AL CORREO RESGISTRADO Y A $extraemail" + "\n"
        + "SIN EMEBARGO PODEMOS COMUNICARNOS AL NUMERO DE CONTACTO $telefono" + "\n" +"¡TE ESPERAMOS PRONTO!"

        )
    }
}