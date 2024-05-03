package com.example.mcprodject.activity.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.mcprodject.R
import com.example.mcprodject.activity.models.ModelNameMK
import com.example.mcprodject.activity.theme.ActivityCustomTheme
import com.example.mcprodject.databinding.ActivityRegistrationBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Registration : ActivityCustomTheme() {

    private lateinit var binding: ActivityRegistrationBinding
    private var listMK: List<ModelNameMK> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        processInput()
    }

    /**
    processInput() - функция, которая красит кнопку в другой цвет, когда она становится
    кликабельной */
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun processInput(){
        with(binding){
            inputTextFam.addTextChangedListener {
                pressingClicks()
                if(inputTextFam.text.isNotEmpty()) {
                    inFamLL.background = getDrawable(R.drawable.blue_1_5_null_rectg_20_rad)
                } else {
                    inFamLL.background = null
                }
            }
            inputTextName.addTextChangedListener {
                pressingClicks()
                if(inputTextName.text.isNotEmpty()) {
                    inNameLL.background = getDrawable(R.drawable.blue_1_5_null_rectg_20_rad)
                } else {
                    inNameLL.background = null
                }
            }
            inputTextOtch.addTextChangedListener {
                pressingClicks()
                if(inputTextOtch.text.isNotEmpty()) {
                    inOtchLL.background = getDrawable(R.drawable.blue_1_5_null_rectg_20_rad)
                } else {
                    inOtchLL.background = null
                }
            }
            inputTextLogin.addTextChangedListener{
                pressingClicks()
                if(inputTextLogin.text.isNotEmpty()) {
                    inLoginLL.background = getDrawable( R.drawable.blue_1_5_null_rectg_20_rad)
                } else {
                    inLoginLL.background = null
                }
            }
            inputTextPassword.addTextChangedListener{
                pressingClicks()
                if(inputTextPassword.text.isNotEmpty()) {
                    inPasswordLL.background = getDrawable(R.drawable.blue_1_5_null_rectg_20_rad)
                } else {
                    inPasswordLL.background = null
                }
            }
            inputTextRepeatPassword.addTextChangedListener {
                pressingClicks()
                if(inputTextRepeatPassword.text.isNotEmpty()) {
                    inRepeatPasswordLL.background = getDrawable(R.drawable.blue_1_5_null_rectg_20_rad)
                } else {
                    inRepeatPasswordLL.background = null
                }
            }
        }
    }

    /** pressingСlicks() - Обработка нажатий*/
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun pressingClicks(){
        updateErrorTV("")
        with(binding){
            //Чтобы пользователь точно попал по полю ввода
            famLL.setOnClickListener{
                inputTextFam.requestFocus()
            }
            nameLL.setOnClickListener{
                inputTextName.requestFocus()
            }
            otchLL.setOnClickListener{
                inputTextOtch.requestFocus()
            }
            loginLL.setOnClickListener{
                inputTextLogin.requestFocus()
            }
            passwordLL.setOnClickListener{
                inputTextPassword.requestFocus()
            }
            repeatPasswordLL.setOnClickListener{
                inputTextRepeatPassword.requestFocus()
            }
            //Кнопки очистить поле
            buttonDeleteFam.setOnClickListener{
                inputTextFam.text.clear()
            }
            buttonDeleteName.setOnClickListener{
                inputTextName.text.clear()
            }
            buttonDeleteOtch.setOnClickListener{
                inputTextOtch.text.clear()
            }
            buttonDeleteLogin.setOnClickListener{
                inputTextLogin.text.clear()
            }
            buttonDeletePassword.setOnClickListener{
                inputTextPassword.text.clear()
            }
            buttonDeleteRepeatPassword.setOnClickListener{
                inputTextRepeatPassword.text.clear()
            }
            buttonBack.setOnClickListener {
                startActivity(Intent(this@Registration, Authorization::class.java))
                finish()
            }
            val email = inputTextLogin.text.toString()
            val name = inputTextName.text.toString()
            val surname = inputTextFam.text.toString()
            val patronymic = inputTextOtch.text.toString()
            val password = inputTextPassword.text.toString()
            val passwordConfirm = inputTextRepeatPassword.text.toString()

            //Кнопка далее
            if (surname.isNotEmpty() && name.isNotEmpty() && patronymic.isNotEmpty() &&
                password.isNotEmpty() && passwordConfirm.isNotEmpty() && email.isNotEmpty()) {

                buttonNext.background = getDrawable(R.drawable.null_blue_rectg)

                buttonNext.setOnClickListener {

                    CoroutineScope(Dispatchers.Main).launch {
                        val response = service.registerUser(email, surname, name, patronymic, password, passwordConfirm)
                        if(response == null) {
                            runOnUiThread {
                                startActivity(Intent(this@Registration, EndRegistration::class.java))
                                finish()
                            }
                        }
                        else {
                            updateErrorTV(response)
                        }
                    }
                }
            }
            else {
                buttonNext.background = getDrawable(R.drawable.null_ncgray_rectg)
                buttonNext.setOnClickListener {
                    updateErrorTV("Не все поля заполнены")
                    if(inputTextFam.text.isEmpty()) {
                        inFamLL.background = getDrawable(R.drawable.orange_1_5_null_rectg_20_rad)
                    }
                    if(inputTextName.text.isEmpty()) {
                        inNameLL.background = getDrawable(R.drawable.orange_1_5_null_rectg_20_rad)
                    }
                    if(inputTextOtch.text.isEmpty()) {
                        inOtchLL.background = getDrawable(R.drawable.orange_1_5_null_rectg_20_rad)
                    }
                    if(inputTextLogin.text.isEmpty()) {
                        inLoginLL.background = getDrawable(R.drawable.orange_1_5_null_rectg_20_rad)
                    }
                    if(inputTextPassword.text.isEmpty()) {
                        inPasswordLL.background = getDrawable(R.drawable.orange_1_5_null_rectg_20_rad)
                    }
                    if(inputTextRepeatPassword.text.isEmpty()) {
                        inRepeatPasswordLL.background = getDrawable(R.drawable.orange_1_5_null_rectg_20_rad)
                    }
                    if(inputTextRepeatPassword.text.isEmpty()) {
                        inRepeatPasswordLL.background = getDrawable(R.drawable.orange_1_5_null_rectg_20_rad)
                    }
                }
            }
        }

    }

    private fun updateErrorTV(error: String){
        binding.textError.text = error
    }

}