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
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        val email: EditText = findViewById(R.id.email1)
        val password: EditText = findViewById(R.id.pass)
        val iniciar: Button = findViewById(R.id.login)
        val registrar: Button = findViewById(R.id.registrar)

        iniciar.setOnClickListener()
        {
            if (email.text.isNotEmpty() && password.text.isNotEmpty()) {
                SignIn(email.text.toString(), password.text.toString())
            }

            else
            {
                Toast.makeText(this, "Llene completamente los espacios", Toast.LENGTH_SHORT).show()
            }
        }

        registrar.setOnClickListener()
        {
            val intent = Intent (this,Registrar::class.java)
            startActivity(intent)
        }
    }

    private fun SignIn (email: String, password: String)
    {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("TAG", "signInWithEmail:success")
                    Toast.makeText(this,"Has entrado a tu cuenta satisfactoriamente",Toast.LENGTH_SHORT).show()
                    ReLoad()

                } else {
                    Log.w("TAG", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "TUS DATOS SON INCORRECTOS",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
    private fun ReLoad()
    {
        val intent = Intent (this, Ver_Hoteles :: class.java )
        startActivity(intent)
    }
}