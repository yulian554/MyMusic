package com.example.mymusic.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mymusic.R
import com.example.mymusic.databinding.ActivityMainBinding
import com.example.mymusic.view.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        navView = binding.navView
        setUpAppBar()
        setContentView(binding.root)
    }

    private fun setUpAppBar() {

    }

    override fun onBackPressed() {
        super.onBackPressed()
        when (getVisibleFragment()?.childFragmentManager!!.fragments[0]) {
            is HomeFragment -> {
                finish()
            }
        }
    }

    private fun getVisibleFragment(): Fragment? {
        val fragmentManager = this@MainActivity.supportFragmentManager
        val fragments = fragmentManager.fragments
        for (fragment in fragments) {
            if (fragment != null && fragment.isVisible)
                return fragment
        }
        return null
    }
}