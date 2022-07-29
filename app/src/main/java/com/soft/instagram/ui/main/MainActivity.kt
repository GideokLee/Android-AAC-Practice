package com.soft.instagram.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.soft.instagram.R
import com.soft.instagram.databinding.ActivityMainBinding
import com.soft.instagram.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    R.layout.activity_main
) {
    override val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vm = vm
    }
}
