package com.example.mymusic.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymusic.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigateToLoginActivity()
    }

    private fun initNavigateToLoginActivity() {
        binding.imageSplash.alpha = 0f
        binding.imageSplash.animate().setDuration(2000).alpha(1f).withEndAction{
            startActivity(Intent(this, AuthenticationActivity::class.java))
            finish()
        }
    }
}