package com.example.mymusic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymusic.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigateToMainActivity()
    }

    private fun initNavigateToMainActivity() {
        binding.imageSplash.alpha = 0f
        binding.imageSplash.animate().setDuration(2000).alpha(1f).withEndAction{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}