package com.example.myapplication

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TextView
import android.app.DialogFragment
import android.app.Dialog
import android.content.DialogInterface
import java.util.Calendar
import android.widget.TimePicker
import android.widget.Toast

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    private lateinit var calendar:Calendar

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        calendar = Calendar.getInstance()

        // Получение текущего времени (часы, минуты)
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        // Создание TimePickerDialog с текущим системным временем
        return TimePickerDialog(
            activity, // Установка контекста диалога
            android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth, // Тема оформления
            this, // TimePickerDialog.OnTimeSetListener
            hour, // Установка значения часов
            minute, // Установка значения минут
            false // Использование 12/24 формата (false - AM/PM)
        )
    }

    // Обработчик при нажатии кнопки подтверждения
    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {
        // Обработка установленного времени и вывод в TextView в формате AM/PM
        val tv:TextView = activity.findViewById(R.id.text_view) as TextView
        tv.text = "Hour : Minute\n${getHourAMPM(hourOfDay)}:$minute ${getAMPM(hourOfDay)}"

    }

    // Обработчик при нажатии кнопки отмены
    override fun onCancel(dialog: DialogInterface?) {
        Toast.makeText(activity,"Picker Canceled.",Toast.LENGTH_SHORT).show()
        super.onCancel(dialog)
    }

    // Вывод AM/PM в зависимости от времени суток
    private fun getAMPM(hour:Int):String{
        return if (hour>11) "PM" else "AM"
    }

    // Вывод значения часов в формате AM/PM
    private fun getHourAMPM(hour:Int):Int{
        var modifiedHour = if (hour>11) hour-12 else hour
        if (modifiedHour == 0){modifiedHour = 12}
        return modifiedHour
    }
}