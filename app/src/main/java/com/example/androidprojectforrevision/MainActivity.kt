package com.example.androidprojectforrevision

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnOrder).setOnClickListener {

            val radioButtonId=findViewById<RadioGroup>(R.id.rgMeat).checkedRadioButtonId
            val meat=findViewById<RadioButton>(radioButtonId)
            val cbCheese=findViewById<CheckBox>(R.id.cbCheese).isChecked
            val cbOnion=findViewById<CheckBox>(R.id.cbOnion).isChecked
            val cbCream=findViewById<CheckBox>(R.id.cbCream).isChecked
            val tvOrderDetail=findViewById<TextView>(R.id.tvOrderDetail)
            tvOrderDetail.text="You order Burger\n"+"${meat.text}"+(if (cbCheese) "Cheese" else "")+
                    (if (cbOnion) "Onion" else "")+
                    (if (cbCream) "Cream" else "").toString()


        }
    }
}