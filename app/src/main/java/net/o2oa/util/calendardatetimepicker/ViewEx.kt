package net.o2oa.util.calendardatetimepicker

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView

/**
 * Created by fancy on 2017/4/10.
 */

inline fun <reified T : Activity> Activity.go(bundle: Bundle? = null) {
    val intent = Intent(this, T::class.java)
    if (bundle != null) {
        intent.putExtras(bundle)
    }
    startActivity(intent)
}

inline fun <reified T:Activity> Activity.goWithRequestCode(bundle: Bundle? = null, requestCode: Int = 0) {
    val intent = Intent(this, T::class.java)
    if (bundle !=null) {
        intent.putExtras(bundle)
    }
    startActivityForResult(intent, requestCode)
}

inline fun <reified T: Activity> Activity.goThenKill(bundle: Bundle? = null) {
    val intent = Intent(this, T::class.java)
    if (bundle != null) {
        intent.putExtras(bundle)
    }
    startActivity(intent)
    finish()
}

/**
 * 启动T 并清除堆栈中的所有Activity
 */
inline fun <reified T:Activity> Activity.goAndClearBefore(bundle: Bundle? = null) {
    val intent = Intent(this, T::class.java)
    if (bundle!=null){
        intent.putExtras(bundle)
    }
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
    finish()
}

fun Activity.hideSoftInput() {
    var view: View? = this.currentFocus
    if (view !=null && view.windowToken !=null) {
        val manager = applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (manager.isActive) {
            manager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}

fun View.visible() {
    visibility = View.VISIBLE
}
fun View.gone() {
    visibility = View.GONE
}
fun View.inVisible() {
    visibility = View.INVISIBLE
}


fun TextView.text2String(): String = text.toString()


