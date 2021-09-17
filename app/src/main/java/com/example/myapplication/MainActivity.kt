package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var editText: EditText? = null
    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)

        button?.setOnClickListener {
            val str = editText?.text.toString()

            //openActivityCustom.launch("3232")

            startActivityForResult(BActivity.getIntent(this, str), 404)
        }
    }

    private val openActivityCustom =
        registerForActivityResult(MyActivityContract()) { result ->
            // parseResult will return this as string?
            if (result != null) Log.d("!!!", "Result : $result")
            else Log.d("!!!","No Result")
        }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        Toast.makeText(this, "Убит B", Toast.LENGTH_SHORT).show()
    }
}

class MyActivityContract : ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String): Intent {
        return Intent(context, BActivity.getIntent(context, input)::class.java)/*.apply {
            putExtra(PostActivity.ID, postId)
        }*/
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        val data = intent?.getStringExtra(BActivity.ARG_B)
        return if (resultCode == Activity.RESULT_OK && data != null) data
        else null
    }
}
