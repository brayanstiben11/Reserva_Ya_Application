package com.example.reserva_ya_application

import android.app.DatePickerDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.google.firebase.firestore.FirebaseFirestore
import org.intellij.lang.annotations.JdkConstants
import java.util.*
import kotlin.random.Random

class Hacer_Reserva : AppCompatActivity(), View.OnClickListener {
    val escoger : Button = findViewById(R.id.seleccionarf)
    val fecha : EditText = findViewById(R.id.fecha)
    override fun onCreate(savedInstanceState: Bundle?) {
        val db = FirebaseFirestore.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hacer_reserva)

        val nombreen : EditText = findViewById(R.id.nombreen)
        val numeropersonas : EditText = findViewById(R.id.numeroper)
        val nombreh : String? = intent.getStringExtra("nombre_hotelreserva")
        val otroemail : EditText = findViewById(R.id.otroemail)

        val telefono : EditText = findViewById(R.id.telefono)
        val espacio : TextView = findViewById(R.id.numeror)
        val hacerreservab : Button = findViewById(R.id.hacerreserva)
        var numeroReserva :  Int = Random.nextInt(1000,10000)

        espacio.setText(
            "Numero de reserva : $numeroReserva"
        )

        escoger.setOnClickListener {

            inicializarComponentes ()
        }

        hacerreservab.setOnClickListener {

            if (nombreen.text.isNotEmpty() && numeropersonas.text.isNotEmpty() && otroemail.text.isNotEmpty() &&
                fecha.text.isNotEmpty() && telefono.text.isNotEmpty() )
            {

               if (nombreh != null) {
                    db.collection("Hoteles").document(nombreh).get().addOnSuccessListener()
                    {

                        val cuposh  = it.get("cupos") as Int
                        val npersonas = numeropersonas.text.toString().toInt()
                        val total = cuposh-npersonas
                        db.collection("Hoteles").document(nombreh).update(
                            hashMapOf("cupos" to total.toString()) as Map<String, Any>
                        )
                    }


                }
                    db.collection("Reservas").document(numeroReserva.toString()).set(
                            hashMapOf(
                                "nombre" to nombreen.text.toString(),
                                "numero Personas" to numeropersonas.text.toString(),
                                "fecha" to fecha.text.toString(),
                                "email" to otroemail.text.toString(),
                                "telefono" to telefono.text.toString(),
                                "numero_reserva" to numeroReserva.toString()
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

  private fun  inicializarComponentes ()
  {
      escoger. setOnClickListener (this)
  }

    override fun onClick(p0: View?) {

        val fecha = DatePickerFragment {year, month, day -> mostrarResultado(year,month,day) }

    }

    private fun mostrarResultado(year: Int, month: Int, day: Int) {
        fecha?.setText("$year/$month/$day")
    }

    class DatePickerFragment(val listener: (year:Int,month : Int, day : Int)-> Unit) : DialogFragment(), DatePickerDialog.OnDateSetListener{

        fun OncreateDialog (savedInstanceState: Bundle?): Dialog {
            val c = Calendar.getInstance()
            var year = c.get(Calendar.YEAR)
            var month = c.get(Calendar.MONTH)
            var day = c.get(Calendar.DAY_OF_MONTH)
            return DatePickerDialog(requireActivity(),this, year,month,day)
        }

        override fun onDateSet(p0: DatePicker?, year: Int, month: Int,day: Int) {

            listener(year, month, day)
        }
    }



}






