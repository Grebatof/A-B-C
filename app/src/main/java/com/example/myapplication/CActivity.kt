package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_c.*

class CActivity : AppCompatActivity() {

    companion object {
        const val ARG_C = "arg_C"

        fun getIntent(context: Context, userKey:String): Intent
        {
            val intent = Intent(context, CActivity::class.java)
            intent.putExtra(ARG_C, userKey)
            return intent
        }
    }

    var editText: EditText? = null
    var button: Button? = null
    var buttonBack: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        buttonBack = findViewById(R.id.buttonBack)

        setTextToTextView(textView)

        button?.setOnClickListener {
            val nextActivityIntent = Intent(this, MainActivity::class.java)
            nextActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(nextActivityIntent)
        }

        buttonBack?.setOnClickListener {
            val intent = Intent(this, BActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            setResult(RESULT_OK)
            finish()
        }
    }

    private fun setTextToTextView(textView: TextView) {
        if (intent.getStringExtra(ARG_C) == null)
            Toast.makeText(this,"Input string is null", Toast.LENGTH_SHORT).show()
        else
            textView.text = intent.getStringExtra(ARG_C)
    }
}
