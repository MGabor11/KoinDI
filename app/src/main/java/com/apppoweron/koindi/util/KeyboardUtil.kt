package com.apppoweron.koindi.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.FragmentActivity


fun hideKeyboard(activity: FragmentActivity?) {
    val view: View? = activity?.findViewById(android.R.id.content)
    view?.let {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it.windowToken, 0)
    }
}