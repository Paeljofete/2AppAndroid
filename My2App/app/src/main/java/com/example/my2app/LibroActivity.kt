package com.example.my2app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LibroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle??) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libro)

        val rB1 = findViewById<RadioButton>(R.id.radioButton1)
        val rB2 = findViewById<RadioButton>(R.id.radioButton2)
        val rB3 = findViewById<RadioButton>(R.id.radioButton3)
        val buttonG = findViewById<Button>(R.id.buttonGuardar)

        buttonG.setOnClickListener {
            val intent = Intent()

            if (rB1.isChecked) {
                intent.putExtra("NAME", rB1.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            } else if (rB2.isChecked) {
                intent.putExtra("NAME", rB2.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            } else if (rB3.isChecked){
                intent.putExtra("NAME", rB3.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this.applicationContext, "No se ha seleccionado libro.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}