package com.example.mcprodject.activity.screens

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import com.example.mcprodject.R
import com.example.mcprodject.databinding.ActivityInputCodeForAuthorizationBinding

class InputCodeForAuthorization : AppCompatActivity() {
    lateinit var binding: ActivityInputCodeForAuthorizationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputCodeForAuthorizationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startTimer()
        checkingfields()
    }

    /** startTimer() Запускает таймер при открытии активности (пока что)*/
    private fun startTimer(){
        val timer = object: CountDownTimer(60000, 1000){
            @SuppressLint("SetTextI18n")
            override fun onTick(milsec: Long) {
                val sec = milsec / 1000 ///перевод миллесекунд в секунды
                binding.buttonRepeat.text = "Повторить через $sec сек."
            }
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onFinish() {
                binding.buttonRepeat.text = "Повторить"
                binding.buttonRepeat.background = getDrawable(R.drawable.null_blue_rectg)
            }
        }
        timer.start()
    }

    private fun checkCode(){
        with(binding){
            if(inputNumber1.text.isNotEmpty() && inputNumber2.text.isNotEmpty() && inputNumber3.text.isNotEmpty() && inputNumber4.text.isNotEmpty()) {
                startActivity(Intent(this@InputCodeForAuthorization, MainScreen::class.java))
                finish()
            }
        }
    }

    /** processInput() - функция, которая красит кнопку в другой цвет, когда она становится кликабельной */
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun processInput(){
        with(binding){
            buttonRepeat.background = getDrawable(R.drawable.null_blue_rectg)
            buttonRepeat.setOnClickListener {
                buttonRepeat.background = getDrawable(R.drawable.null_ncgray_rectg)
                startTimer()
            }
        }
    }

    /** сheckingfields() - проверка заполнения полей */
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkingfields(){
        with (binding){
            inputNumber1.addTextChangedListener {
                if(inputNumber1.text.isEmpty()) {
                    inNum1LL.background = null
                }
                else {
                    inNum1LL.background = getDrawable(R.drawable.blue_1_5_null_rectg_15_rad)
                    inputNumber2.requestFocus()
                }
                checkCode()
                processInput()
            }
            inputNumber2.addTextChangedListener {
                if(inputNumber2.text.isEmpty()) {
                    inNum2LL.background = null
                    inputNumber1.requestFocus()
                }
                else {
                    inNum2LL.background = getDrawable(R.drawable.blue_1_5_null_rectg_15_rad)
                    inputNumber3.requestFocus()
                }
                checkCode()
                processInput()
            }
            inputNumber3.addTextChangedListener {
                if(inputNumber3.text.isEmpty()) {
                    inNum3LL.background = null
                    inputNumber2.requestFocus()
                }
                else {
                    inNum3LL.background = getDrawable(R.drawable.blue_1_5_null_rectg_15_rad)
                    inputNumber4.requestFocus()
                }
                checkCode()
                processInput()
            }
            inputNumber4.addTextChangedListener {
                if(inputNumber4.text.isEmpty()) {
                    inNum4LL.background = null
                    inputNumber3.requestFocus()
                }
                else {
                    inNum4LL.background = getDrawable(R.drawable.blue_1_5_null_rectg_15_rad)
                    buttonRepeat.requestFocus()
                }
                checkCode()
                processInput()
            }
        }
    }
}