package com.example.mymusic.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mymusic.R
import com.example.mymusic.databinding.LoginHomeFragmentBinding

class LoginHomeFragment: Fragment() {

    private lateinit var binding: LoginHomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = LoginHomeFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initOnClick()
    }

    private fun initOnClick() {
        binding.createAccount.setOnClickListener {
            findNavController().navigate(R.id.createAccountFragment)
        }

        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.authenticationFragment)
        }
    }
}