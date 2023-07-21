package com.example.androidprojectforrevision

import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnCustomToast).setOnClickListener {
            Toast(this).also {
                Toast.LENGTH_LONG
         it.view = layoutInflater.inflate(R.layout.custom_toast_layout,findViewById<ConstraintLayout>(R.id.clCustomToast),false)
                it.show()
            }
        }
    }
}