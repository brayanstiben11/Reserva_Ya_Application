package com.example.reserva_ya_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val db = FirebaseFirestore.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)


        val salir : Button = findViewById(R.id.logout)
        val email1 : String? = intent.getStringExtra("correo")
        val nombre : EditText = findViewById(R.id.name1)
        val correo :EditText = findViewById(R.id.correo1)
        val pass : EditText = findViewById(R.id.contra1)
        val verhot : Button = findViewById(R.id.main)


        if (email1 != null) {
            db.collection("Perfiles").document(email1).get().addOnSuccessListener {
                nombre.setText(it.get("nombre") as String?)
                correo.setText(email1)
                pass.setText(it.get("password") as String?)

            }
        }


        salir.setOnClickListener()
        {
            signOut()
        }

        verhot.setOnClickListener()
        {
            val intent = Intent(this,Ver_Hoteles :: class.java)
            startActivity(intent)
        }


    }

    fun signOut ()
    {
        Firebase.auth.signOut()
        val intent = Intent (this, MainActivity :: class.java)
        startActivity(intent)
    }
}