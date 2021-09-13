package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class BActivity : AppCompatActivity() {

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        editText = findViewById(R.id.editText)
    }

    fun passStringToNextActivity(view: View) {
        val nextActivityIntent = Intent(this, CActivity::class.java)
        val str = editText.text.toString()

        if (intent.getStringExtra("String") == null) {
            nextActivityIntent.putExtra("String", str)
        } else {
            nextActivityIntent.putExtra("String", intent.getStringExtra("String")?.toString() + str)
        }

        startActivity(nextActivityIntent)
        finish()
    }
}
