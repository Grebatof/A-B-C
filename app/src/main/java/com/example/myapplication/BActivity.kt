package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BActivity : AppCompatActivity() {

    companion object {
        const val ARG_SECOND = "arg_second"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val editText: EditText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)
        val buttonBack: Button = findViewById(R.id.buttonBack)

        button.setOnClickListener {
            val nextActivityIntent = Intent(this, CActivity::class.java)
            val str = editText.text.toString()

            if (intent.getStringExtra(ARG_SECOND) == null)
                nextActivityIntent.putExtra(CActivity.ARG_THIRD, str)
            else
                nextActivityIntent.putExtra(CActivity.ARG_THIRD, intent.getStringExtra(ARG_SECOND) + " " + str)

            startActivityForResult(nextActivityIntent, 404)
        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            setResult(RESULT_OK, intent)
            startActivity(intent)
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        Toast.makeText(this, "Убит С", Toast.LENGTH_SHORT).show()
    }
}
