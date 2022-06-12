package com.example.my2app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.my2app.ClienteActivity.Companion.NAME

class MainActivity : AppCompatActivity() {

    var cliente_dato: String? = ""
    var fecha_dato: String? = ""
    var libro_dato: String? = ""
    var nombre: String? = ""

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK) {
                nombre = activityResult.data?.getStringExtra(NAME)
                Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val buttonC = findViewById<Button>(R.id.buttonCliente)
        val buttonF = findViewById<Button>(R.id.buttonFecha)
        val buttonL = findViewById<Button>(R.id.buttonLibro)
        val buttonM = findViewById<Button>(R.id.buttonVenta)
        val buttonS = findViewById<Button>(R.id.buttonSalir)

        buttonC.setOnClickListener {
            recuperaDatos(clasesUsadas.Cliente)
        }

        buttonF.setOnClickListener {
            recuperaDatos(clasesUsadas.Fecha)
        }

        buttonL.setOnClickListener{
            recuperaDatos(clasesUsadas.Libro)
        }

        buttonM.setOnClickListener {
            recuperaDatos(clasesUsadas.Mostrar)
        }

        buttonS.setOnClickListener {
            recuperaDatos(clasesUsadas.Salir)
        }

    }

    // Recibe una clase.
    private fun abrirActivities(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        resultLauncher.launch(intent)
    }

    private fun recuperaDatos(usos: clasesUsadas) {
        when (usos) {
            clasesUsadas.Cliente -> {
                abrirActivities(ClienteActivity::class.java)
                cliente_dato = nombre
            }
            clasesUsadas.Fecha -> {
                abrirActivities(FechaActivity::class.java)
                fecha_dato = nombre
            }
            clasesUsadas.Libro -> {
                abrirActivities(LibroActivity::class.java)
                libro_dato = nombre
            }
            clasesUsadas.Mostrar -> {
                mostrarDatos()
            }
            clasesUsadas.Salir -> {
                finish()
            }
        }
    }

    private fun mostrarDatos() {
        val intent = Intent(this, MostrarActivity::class.java)
        intent.putExtra("cliente_dato", cliente_dato.toString())
        intent.putExtra("fecha_dato", fecha_dato.toString())
        intent.putExtra("libro_dato", libro_dato.toString())
        startActivity(intent)
    }
}

enum class clasesUsadas(val activities: String) {
    Cliente("clienteActivity"),
    Fecha("fechaActivity"),
    Libro("libroActivity"),
    Salir("salir"),
    Mostrar("mostrar")
}
