package com.example.reserva_ya_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Registrar : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        auth = Firebase.auth

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

                crearusuario(email.text.toString(),pass.text.toString(), nombre.text.toString())
            }
            else if (nombre.text.isEmpty() || email.text.isEmpty() || pass.text.isEmpty())
            {
                Toast.makeText(this,"Los campos deben ser llenados", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun crearusuario (email : String, password : String, nombre : String)
    {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "createUserWithEmail:success")
                    val user = auth.currentUser
                    Toast.makeText(this,"LA CUENTA FUE CREADA SATISFACTORIAMENTE",Toast.LENGTH_SHORT).show()
                    db.collection("Perfiles").document(email).set(hashMapOf ("nombre" to nombre, "password" to password))
                    next(email)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "YA EXISTE UNA CUENTA CON ESTE CORREO",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun next (email: String)
    {
        val intent = Intent (this, Perfil :: class.java )
        intent.putExtra("correo", email)
        startActivity(intent)
    }
}