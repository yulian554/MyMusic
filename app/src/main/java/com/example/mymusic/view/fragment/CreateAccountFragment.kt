package com.example.mymusic.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymusic.R
import com.example.mymusic.databinding.FragmentCreateAccountBinding
import com.example.mymusic.view.activity.AuthenticationActivity

class CreateAccountFragment : Fragment() {

    private lateinit var binding: FragmentCreateAccountBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentCreateAccountBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        eventOnClick()
    }

    private fun eventOnClick() {
        binding.onBack.setOnClickListener {
            (activity as AuthenticationActivity).onBackPressed()
        }
    }
}