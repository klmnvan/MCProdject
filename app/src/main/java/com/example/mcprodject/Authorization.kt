package com.example.mcprodject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mcprodject.databinding.ActivityAuthorizationBinding

class Authorization : AppCompatActivity() {
    lateinit var binding: ActivityAuthorizationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        processInput()
    }

    /*
    processInput() - функция, которая красит кнопку в другой цвет, когда она становится
    кликабельной */
    private fun processInput(){
        with(binding){
            if(inputTextLogin.text.isNotEmpty() && inputTextPassword.text.isNotEmpty())
              buttonNext.setOnClickListener {
                  startActivity(Intent(this@Authorization, Authorization::class.java))
                  finish()
              }

        }
    }
}