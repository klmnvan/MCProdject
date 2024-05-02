package com.example.mcprodject.activity.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.mcprodject.R
import com.example.mcprodject.activity.models.ModelNameMK
import com.example.mcprodject.databinding.ActivityRegistrationBinding


class Registration : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private var listMK: List<ModelNameMK> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        processInput()
        createListMK()
    }

    private fun createListMK() {
        listMK = listMK + ModelNameMK(1, "Информационные системы")
        listMK = listMK + ModelNameMK(2, "Юристы")
        listMK = listMK + ModelNameMK(3, "Бухгалтера")
        val spinnerArrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item,
            listMK.map{it.NamesMK}
        )
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMK.adapter = spinnerArrayAdapter
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
                if(inputTextPassword.text.isNotEmpty()) { (R.drawable.blue_1_5_null_rectg_20_rad)
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
            //Кнопка далее
            if(
                inputTextFam.text.isNotEmpty() &&
                inputTextName.text.isNotEmpty() &&
                inputTextOtch.text.isNotEmpty() &&
                inputTextPassword.text.isNotEmpty() &&
                inputTextRepeatPassword.text.isNotEmpty() &&
                inputTextLogin.text.isNotEmpty()
                ) {

                buttonNext.background = getDrawable(R.drawable.null_blue_rectg)
                textError.visibility = View.GONE

                buttonNext.setOnClickListener {
                    startActivity(Intent(this@Registration, EndRegistration::class.java))
                    finish()
                }

            }
            else {
                buttonNext.background = getDrawable(R.drawable.null_ncgray_rectg)
                buttonNext.setOnClickListener {
                    textError.visibility = View.VISIBLE
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

}