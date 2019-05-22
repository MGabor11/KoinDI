package com.apppoweron.koindi.util

import android.widget.EditText
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("android:src")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

/*@BindingAdapter("requestFocus")
fun requestFocus(moneyEditText: MoneyEditText, requestFocus: Boolean) {
    if (requestFocus) {
        val editText = moneyEditText.inputEditText
        editText.isFocusableInTouchMode = true
        showKeyBoard(editText)
    }
}*/


@BindingAdapter("disableEditText")
fun requestFocus(editText: EditText, isDisabled: Boolean?) {
    isDisabled?.let {
        editText.isFocusable = !it
        editText.isEnabled = !it
        editText.isCursorVisible = !it
        editText.isFocusableInTouchMode = !it
    }
}

@BindingAdapter(value = ["adapter", "layoutManager", "list"], requireAll = false)
fun <T> setRecyclerViewData(
    recyclerView: RecyclerView,
    adapter: ListAdapter<T, RecyclerView.ViewHolder>?,
    layoutManager: RecyclerView.LayoutManager?,
    list: List<T>?
) {
    adapter?.apply {
        recyclerView.layoutManager = layoutManager ?: LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = this
        submitList(list)
    }
}
