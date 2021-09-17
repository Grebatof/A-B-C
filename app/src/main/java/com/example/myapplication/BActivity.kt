package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BActivity : AppCompatActivity() {

    companion object {
        const val ARG_B = "arg_B"

        fun getIntent(context: Context, userKey:String): Intent
        {
            val intent = Intent(context, BActivity::class.java)
            intent.putExtra(ARG_B, userKey)
            return intent
        }
    }

    var editText: EditText? = null
    var button: Button? = null
    var buttonBack: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        buttonBack = findViewById(R.id.buttonBack)

        button?.setOnClickListener {
            var str = editText?.text.toString()

            if (intent.getStringExtra(ARG_B) != null)
                str = "${intent.getStringExtra(ARG_B)} $str"

            startActivityForResult(CActivity.getIntent(this, str), 404)
        }

        buttonBack?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            setResult(RESULT_OK, intent)
            startActivity(intent)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        Toast.makeText(this, "Убит С", Toast.LENGTH_SHORT).show()
    }
}
