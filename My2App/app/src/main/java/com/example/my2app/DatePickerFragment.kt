package com.example.my2app

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

// La clase recibe un parámetro que al ejecutar hay que pasarle los tres valores de la fecha. Esta clase extiende de DialogFragment.
class DatePickerFragment(val listener: (day: Int, month: Int, year: Int) -> Unit) :
    DialogFragment(), DatePickerDialog.OnDateSetListener {

    // Cuando se seleecione una fecha se llama a este método. El listener ejecutará el código que está en la clase MainActivity: showDatePickerDialog.
    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener(dayOfMonth, month, year)
    }

    // Este método lo implementa con el DialogFragment.
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

        val picker = DatePickerDialog(activity as Context, R.style.datePickerTheme, this, year, month, day)
        // El día máximo para la fecha será el de hoy.
        picker.datePicker.maxDate = c.timeInMillis
        return picker

    /*  Con el estilo de color no se ven los botones pero funcionan. Dejo este aquí para hacer la prueba con los botonos visibles.
        val picker = DatePickerDialog(activity as Context, this, year, month, day)
        return picker*/
    }
}