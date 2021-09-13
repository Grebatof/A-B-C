package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    companion object {
        const val ARG_FIRST = "arg_first"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val nextActivityIntent = Intent(this, BActivity::class.java)
            val str = editText.text.toString()

            nextActivityIntent.putExtra(BActivity.ARG_SECOND, str)
            startActivityForResult(nextActivityIntent, 404)
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        Toast.makeText(this, "Убит B", Toast.LENGTH_SHORT).show()
    }
}
