package com.example.mymusic.util.dialog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import com.example.mymusic.databinding.LoadingDialogBinding

object DialogLoading {

    fun create(context: Context): AlertDialog? {
        val alertDialogBinding = LoadingDialogBinding.inflate(LayoutInflater.from(context))
        val builderDialog =
            AlertDialog.Builder(context).setView(alertDialogBinding.root)
                .setTitle("")
                .setCancelable(false)
                .create()
        builderDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return builderDialog
    }
}