package com.example.mcprodject.activity.screens

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.example.mcprodject.R
import com.example.mcprodject.databinding.ActivityAuthorizationBinding

class Authorization : AppCompatActivity() {
    lateinit var binding: ActivityAuthorizationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        processInput()
        pressingСlicks()
        binding.buttonRegist.setOnClickListener {
            startActivity(Intent(this@Authorization, Registration::class.java))
            finish()
        }
    }

    /** processInput() - функция, которая красит кнопку в другой цвет, когда она становится кликабельной */
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun processInput(){
        with(binding){
            inputTextLogin.addTextChangedListener {
                pressingСlicks()
                if(inputTextLogin.text.isNotEmpty()) {
                    inLoginLL.background = getDrawable(R.drawable.blue_1_5_null_rectg_20_rad)
                } else {
                    inLoginLL.background = null
                }
            }
            inputTextPassword.addTextChangedListener {
                pressingСlicks()
                if(inputTextPassword.text.isNotEmpty()) {
                    inPasswordLL.background = getDrawable(R.drawable.blue_1_5_null_rectg_20_rad)
                } else {
                    inPasswordLL.background = null
                }
            }
        }
    }

    /** pressingСlicks() - Обработка нажатий*/
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun pressingСlicks(){
        with(binding){
            loginLL.setOnClickListener{
                inputTextLogin.requestFocus()
            }
            passwordLL.setOnClickListener{
                inputTextPassword.requestFocus()
            }
            buttonDeleteLogin.setOnClickListener {
                inputTextLogin.text.clear()
            }
            buttonDeletePassword.setOnClickListener {
                inputTextPassword.text.clear()
            }
            if(inputTextLogin.text.isNotEmpty() && inputTextPassword.text.isNotEmpty()){
                buttonNext.background = getDrawable(R.drawable.null_blue_rectg)
                textError.visibility = View.GONE
                buttonNext.setOnClickListener {
                    startActivity(Intent(this@Authorization, InputCodeForAuthorization::class.java))
                    finish()
                }
            }
            else {
                buttonNext.background = getDrawable(R.drawable.null_ncgray_rectg)
                buttonNext.setOnClickListener {
                    textError.visibility = View.VISIBLE
                    if(inputTextPassword.text.isEmpty()) {
                        inPasswordLL.background = getDrawable(R.drawable.orange_1_5_null_rectg_20_rad)
                    }
                    if(inputTextLogin.text.isEmpty()) {
                        inLoginLL.background = getDrawable(R.drawable.orange_1_5_null_rectg_20_rad)
                    }
                }
            }
        }

    }

}