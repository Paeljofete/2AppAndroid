package com.example.my2app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ClienteActivity : AppCompatActivity() {

    companion object{
        const val NAME = "NAME"
    }

    override fun onCreate(savedInstanceState: Bundle??) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        val buttonG = findViewById<Button>(R.id.buttonGuardar)

        buttonG.setOnClickListener{
            val textCliente = findViewById<EditText>(R.id.editTextCliente)
            val intent = Intent()

            if(textCliente.text.isNullOrEmpty()){
                Toast.makeText(this.applicationContext, "No se ha escrito el nombre del cliente.", Toast.LENGTH_SHORT).show()
            }
            else{
                intent.putExtra("NAME", textCliente.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}