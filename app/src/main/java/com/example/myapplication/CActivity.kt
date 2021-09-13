package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class CActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        textView = findViewById(R.id.textView)

        getTextFromOtherActivitiesAndSetToTextView()
    }

    private fun getTextFromOtherActivitiesAndSetToTextView() {
        if (intent.getStringExtra("String") == null) {
            Toast.makeText(this,"Input string is null", Toast.LENGTH_SHORT)
            return
        }

        textView.text = intent.getStringExtra("String")?.toString()
    }

    fun goToMainActivity(view: View) {
        val nextActivityIntent = Intent(this, MainActivity::class.java)

        startActivity(nextActivityIntent)
        finish()
    }
}
