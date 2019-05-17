package net.o2oa.util.calendardatetimepicker

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_date_picker.setOnClickListener {
            showPicker(CalendarDateTimePickerFragment.DATE_PICKER_TYPE)
        }
        btn_date_interval_picker.setOnClickListener {
            showPicker(CalendarDateTimePickerFragment.DATEINTERVAL_PICKER_TYPE)
        }
        btn_date_time_picker.setOnClickListener {
            showPicker(CalendarDateTimePickerFragment.DATE_TIME_PICKER_TYPE)
        }
    }

    private fun showPicker(type: String) {
        val dialog = CalendarDateTimePickerFragment()
        val arg = Bundle()
        arg.putString(CalendarDateTimePickerFragment.PICKER_TYPE_KEY, type)
        dialog.arguments = arg
        dialog.setOnDateTimeSetListener(object : CalendarDateTimePickerFragment.OnDateTimeSetListener{
            override fun onSet(time: String) {
                Log.i("Main", "选择：$time")
                tv_center.text = "选择：$time"
            }

            override fun onSetInterval(startDate: String, endDate: String) {
                Log.i("Main", "开始：$startDate, 结束: $endDate")
                tv_center.text = "开始：$startDate, 结束: $endDate"
            }

        })
        dialog.show(supportFragmentManager, "CalendarDateTimePicker")
    }
}
