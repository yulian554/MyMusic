package com.example.mymusic.view.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.example.mymusic.R
import com.example.mymusic.databinding.FragmentAuthenticationLoginBinding
import com.example.mymusic.models.GetTokensModel
import com.example.mymusic.util.SharedPreferences
import com.example.mymusic.util.dialog.DialogErrorLogin
import com.example.mymusic.view.activity.AuthenticationActivity
import com.example.mymusic.viewModel.AuthenticationLoginViewModel
import com.example.mymusic.viewModel.resource.AuthenticationLoginResource

class AuthenticationLoginFragment : Fragment() {

    private lateinit var binding: FragmentAuthenticationLoginBinding
    private val viewModel: AuthenticationLoginViewModel by viewModels()
    private lateinit var myActivity : AuthenticationActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAuthenticationLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        eventOnClick()
        initObservers()
        configuration()
    }

    private fun configuration() {
        myActivity = (activity as AuthenticationActivity)
    }

    private fun eventOnClick() {
        binding.onBack.setOnClickListener {
            myActivity.onBackPressed()
        }
        binding.textInputEmailOrUser.addTextChangedListener {
            validateEnableButton()
        }
        binding.textInputPassword.addTextChangedListener {
            validateEnableButton()
        }
        binding.buttonLoginNext.setOnClickListener {
            viewModel.getTokens(GetTokensModel(binding.textInputEmailOrUser.text.toString(),
                binding.textInputPassword.text.toString()))
        }
    }

    private fun initObservers() {
        viewModel.eventGetToken.observe(viewLifecycleOwner) { event ->
            when(val response = event.getIfPending()) {
                is AuthenticationLoginResource.Loading -> {
                    myActivity.showLoading()
                }
                is AuthenticationLoginResource.FailureGetToken -> {
                    Handler(Looper.getMainLooper()).postDelayed({ showErrorLogin() }, 2000)
                }
                is AuthenticationLoginResource.SuccessGetToken -> {
                    response.successToken?.let { SharedPreferences.setToken(requireContext(), it) }
                    Handler(Looper.getMainLooper()).postDelayed({ myActivity.initNavigateToHome() }, 2000)
                }
                else -> { myActivity.hideLoading() }
            }
        }
    }

    private fun showErrorLogin() {
        myActivity.hideLoading()
        DialogErrorLogin.create(requireContext())?.show()
    }

    private fun validateEnableButton() {
        binding.buttonLoginNext.isEnabled = binding.textInputEmailOrUser.text.toString().isNotEmpty()
                && binding.textInputPassword.text.toString().length >= 8
    }
}