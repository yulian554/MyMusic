package com.example.mymusic.view.activity

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mymusic.databinding.ActivityLoginBinding
import com.example.mymusic.util.dialog.DialogLoading

class AuthenticationActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var loading: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun initNavigateToHome() {
        hideLoading()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    fun showLoading() {
        if (loading == null) {
            loading = DialogLoading.create(this)
            loading?.show()
        } else {
            loading?.show()
        }
    }

    fun hideLoading() {
        if (loading != null) {
            loading?.dismiss()
        }
    }
}