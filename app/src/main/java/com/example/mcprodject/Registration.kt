package com.example.mcprodject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mcprodject.databinding.ActivityAuthorizationBinding

class Registration : AppCompatActivity() {
    lateinit var binding: ActivityAuthorizationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}