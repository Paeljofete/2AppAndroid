package com.example.my2app

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MostrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar)


        val cliente = findViewById<TextView>(R.id.textViewVacio)
        val fecha = findViewById<TextView>(R.id.textViewVacio1)
        val libro = findViewById<TextView>(R.id.textViewVacio2)

        cliente.text = intent.extras?.get("cliente_dato") as String?
        fecha.text = intent.extras?.get("fecha_dato") as String?
        libro.text = intent.extras?.get("libro_dato") as String?
    }
}