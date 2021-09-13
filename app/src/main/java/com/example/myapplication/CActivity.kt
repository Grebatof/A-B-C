package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CActivity : AppCompatActivity() {

    companion object {
        const val ARG_THIRD = "arg_third"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)
        val buttonBack: Button = findViewById(R.id.buttonBack)

        setTextToTextView(textView)

        button.setOnClickListener {
            val nextActivityIntent = Intent(this, MainActivity::class.java)
            nextActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(nextActivityIntent)
        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, BActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            setResult(RESULT_OK, intent)
            startActivity(intent)
        }
    }

    private fun setTextToTextView(textView: TextView) {
        if (intent.getStringExtra(ARG_THIRD) == null)
            Toast.makeText(this,"Input string is null", Toast.LENGTH_SHORT).show()
        else
            textView.text = intent.getStringExtra(ARG_THIRD)
    }
}
