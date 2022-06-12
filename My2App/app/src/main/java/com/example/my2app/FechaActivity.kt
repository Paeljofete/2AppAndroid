package com.example.my2app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FechaActivity : AppCompatActivity() {

    var etDate : EditText? = null

    override fun onCreate(savedInstanceState: Bundle??) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fecha)

        val buttonG = findViewById<Button>(R.id.buttonGuardar)
        etDate = findViewById(R.id.editTextFecha)

        etDate?.setOnClickListener{
            showDatePickerDialog()
        }

        buttonG.setOnClickListener{
            val intent = Intent()

            if(etDate?.text.isNullOrEmpty()){
                Toast.makeText(this.applicationContext, "No se ha seleccionado fecha.", Toast.LENGTH_SHORT).show()
            }
            else{
                intent.putExtra("NAME", etDate?.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    // Método para mostrar el calendario.
    fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day: Int, month: Int, year: Int) {
        var mes = 0
        mes = month + 1
        etDate?.setText("$day / $mes / $year")
    }
}