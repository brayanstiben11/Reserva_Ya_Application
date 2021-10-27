package com.example.reserva_ya_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Hacer_Reserva : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hacer_reserva)

        val nombreen : EditText = findViewById(R.id.nombreen)
        val numeropersonas : EditText = findViewById(R.id.numeroper)
        val otroemail : EditText = findViewById(R.id.otroemail)
        val fecha : EditText = findViewById(R.id.fecha)
        val telefono : EditText = findViewById(R.id.telefono)
        val hacerreservab : Button = findViewById(R.id.hacerreserva)

        if (nombreen.text.isNotEmpty() && numeropersonas.text.isNotEmpty() && otroemail.text.isNotEmpty() &&
                fecha.text.isNotEmpty() && telefono.text.isNotEmpty()
         )
        {
            hacerreservab.setOnClickListener()
            {
                val intent = Intent (this, Ver_reserva_hecha :: class.java)
                intent.putExtra("nombrepersona",nombreen.text.toString())
                intent.putExtra("personas",numeropersonas.text.toString())
                intent.putExtra("otroemail",otroemail.text.toString())
                intent.putExtra("fechallegada",fecha.text.toString())
                intent.putExtra("numerotel", telefono.text.toString())
                startActivity(intent)
                Toast.makeText(this,"Tu reserva fue hecha satisfactoriamente", Toast.LENGTH_LONG).show()
            }
        }
        else if (nombreen.text.isEmpty() || numeropersonas.text.isEmpty() || otroemail.text.isEmpty() ||
            fecha.text.isEmpty() || telefono.text.isEmpty())
        {
            Toast.makeText(this,"Los campos deben ser llenados", Toast.LENGTH_LONG).show()
        }


}
}