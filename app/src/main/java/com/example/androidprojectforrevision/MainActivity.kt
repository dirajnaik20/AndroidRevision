package com.example.androidprojectforrevision

import android.app.ProgressDialog.show
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnApply).setOnClickListener {
            val etName=findViewById<EditText>(R.id.etName).text.toString()
            val etAge=findViewById<EditText>(R.id.etAge).text.toString().toInt()
            val etCountry=findViewById<EditText>(R.id.etCountry).text.toString()
            val person=Person(etName,etAge,etCountry)
            Intent(this,SecondActivity::class.java).also {
                it.putExtra("EXTRA_PERSON",person)
                startActivity(it)
            }

        }
    }
}