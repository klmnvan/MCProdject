package com.example.mcprodject.activity.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.mcprodject.R
import com.example.mcprodject.activity.theme.ActivityCustomTheme
import com.example.mcprodject.databinding.ActivityAuthorizationBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Authorization : ActivityCustomTheme() {

    private lateinit var binding: ActivityAuthorizationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        processInput()
        pressingClicks()
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
                pressingClicks()
                if(inputTextLogin.text.isNotEmpty()) {
                    inLoginLL.background = getDrawable(R.drawable.blue_1_5_null_rectg_20_rad)
                } else {
                    inLoginLL.background = null
                }
            }
            inputTextPassword.addTextChangedListener {
                pressingClicks()
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
    private fun pressingClicks(){
        with(binding){
            updateErrorTV("")
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

            val email = inputTextLogin.text.toString()
            val password = inputTextPassword.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()) {
                buttonNext.background = getDrawable(R.drawable.null_blue_rectg)
                buttonNext.setOnClickListener {
                    CoroutineScope(Dispatchers.Main).launch {
                        val response = service.authorize(email, password)
                        if(response == null) {
                            runOnUiThread {
                                startActivity(Intent(this@Authorization, MainScreen::class.java))
                                finish()
                            }
                        } else {
                            updateErrorTV(response)
                        }
                    }
                }
            }
            else {
                buttonNext.background = getDrawable(R.drawable.null_ncgray_rectg)
                buttonNext.setOnClickListener {
                    updateErrorTV("Не все поля заполнены")
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

    private fun updateErrorTV(error: String){
        binding.textError.text = error
    }

}