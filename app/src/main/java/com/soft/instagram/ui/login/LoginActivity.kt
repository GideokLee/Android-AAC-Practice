package com.soft.instagram.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.soft.instagram.R
import com.soft.instagram.databinding.ActivityLoginBinding
import com.soft.instagram.ui.base.BaseActivity
import com.soft.instagram.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(R.layout.activity_login) {

    override val vm: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding.vm = vm

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
