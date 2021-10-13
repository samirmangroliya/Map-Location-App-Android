package com.zt.mylocation.common

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import com.zt.mylocation.R

fun Context.showToast(msg: String?, time: Int = Toast.LENGTH_LONG) {
    if (msg?.isNotBlank() == true) {
        Toast.makeText(this, msg, time).show()
    }
}

fun Activity.showAlert(
    msg: String?,
    listener: DialogInterface.OnClickListener? = null,
    title: String? = getString(R.string.app_name)
) {
    try {
        if (listOfNotNull(this, msg).size == 2) {
            AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton("Ok", listener)
                .create()
                .show()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}