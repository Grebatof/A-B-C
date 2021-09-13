package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
    }

    fun passStringToNextActivity(view: View) {
        val nextActivityIntent = Intent(this, BActivity::class.java)
        val str = editText.text.toString()

        nextActivityIntent.putExtra("String", str)

        startActivity(nextActivityIntent)
        finish()
    }
}
