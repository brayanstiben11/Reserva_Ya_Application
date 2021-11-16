package com.example.reserva_ya_application

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class Detalles_hotel1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_hotel1)

       var ratingBar : RatingBar = findViewById(R.id.ratingBar)
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        ratingBar = findViewById(R.id.ratingBar)
        ratingBar.numStars=5
        ratingBar.rating = load()
        ratingBar.onRatingBarChangeListener =
            RatingBar.OnRatingBarChangeListener ()
            {
                    _, rating, _ ->

                Toast.makeText(this, "TU CALIFICACION FUE: " + rating.toInt(), Toast.LENGTH_SHORT).show()
                save(rating.toFloat());
            }
    }

    fun save (f: Float)
    {
        val sharedPreference = getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putFloat("rating",f)
        editor.commit()

    }

    fun  load (): Float {
        val sharedPreference = getPreferences(Context.MODE_PRIVATE)
        var i : Float
        i = sharedPreference.getFloat("rating",0f)
        return i
    }

}