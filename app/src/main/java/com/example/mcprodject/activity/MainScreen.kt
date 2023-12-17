package com.example.mcprodject.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mcprodject.R
import com.example.mcprodject.databinding.ActivityMainScreenBinding

class MainScreen : AppCompatActivity() {
    lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}