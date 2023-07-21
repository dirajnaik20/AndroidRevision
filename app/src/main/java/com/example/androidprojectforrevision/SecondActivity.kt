package com.example.androidprojectforrevision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val person= intent.getSerializableExtra("EXTRA_PERSON") as Person
        findViewById<TextView>(R.id.tvSecondActivity).text=person.toString()
    }
}