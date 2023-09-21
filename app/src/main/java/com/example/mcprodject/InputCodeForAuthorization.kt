package com.example.mcprodject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mcprodject.databinding.ActivityAuthorizationBinding
import com.example.mcprodject.databinding.ActivityInputCodeForAuthorizationBinding

class InputCodeForAuthorization : AppCompatActivity() {
    lateinit var binding: ActivityInputCodeForAuthorizationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputCodeForAuthorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}