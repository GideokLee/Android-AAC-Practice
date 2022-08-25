package com.soft.instagram.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.soft.instagram.R
import com.soft.instagram.databinding.ActivityLoginBinding
import com.soft.instagram.ui.base.BaseActivity
import com.soft.instagram.ui.main.MainActivity
import com.soft.instagram.util.UiState
import com.soft.instagram.util.extensions.hide
import com.soft.instagram.util.extensions.repeatOnStarted
import com.soft.instagram.util.extensions.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {

    override val vm: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding.vm = vm

        repeatOnStarted {
            launch {
                vm.eventFlow.collect(::handleEvent)
            }

            launch {
                vm.loginState.collect { uiState ->
                    when (uiState) {
                        is UiState.Loading -> {
                            binding.progressBar.show()
                        }
                        is UiState.Success -> {
                            binding.progressBar.hide()
                            finishLogin()
                        }
                        is UiState.Error -> {
                            binding.progressBar.hide()
                        }
                        else -> Unit
                    }
                }
            }
        }
    }

    private fun handleEvent(event: Event) = when (event) {
        is Event.Signin -> signin()
        is Event.Signup -> signup()
    }

    private fun signin() {
        val email = binding.tietEmail.text.toString()
        val pwd = binding.tietPassword.text.toString()
        if (!checkLoginValidate(email, pwd)) {
            Toast.makeText(this, "유효하지 않은 email 또는 password", Toast.LENGTH_SHORT).show()
        } else vm.login(email, pwd)
    }

    private fun checkLoginValidate(email: String?, password: String?): Boolean {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) return false
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) return false

        return true
    }

    private fun signup() {
        Toast.makeText(this, "회원가입 지원하지 않음", Toast.LENGTH_SHORT).show()
    }

    private fun finishLogin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
