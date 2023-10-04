package com.example.mcprodject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import com.example.mcprodject.databinding.ActivityAuthorizationBinding
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
    //Запускает таймер при открытии активности (пока что)
    private fun startTimer(){
        val timer = object: CountDownTimer(600000, 1000){
            @SuppressLint("SetTextI18n")
            override fun onTick(p0: Long) {
                var sec = p0 / 10000
                binding.textTimer.text = "Отправить код повторно можно будет через $sec секунд"
            }
            override fun onFinish() {
            }
        }
        timer.start()
    }

    /**
    processInput() - функция, которая красит кнопку в другой цвет, когда она становится
    кликабельной */
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun processInput(){
        with(binding){
            if(inputNumber1.text.isNotEmpty() && inputNumber2.text.isNotEmpty() && inputNumber3.text.isNotEmpty() && inputNumber4.text.isNotEmpty()) {
                buttonNext.background = getDrawable(R.drawable.for_button__blue__null__rounded_edges)
                buttonNext.setOnClickListener {
                    startActivity(Intent(this@InputCodeForAuthorization, Authorization::class.java))
                    finish()
                }
            } else {
                buttonNext.background = getDrawable(R.drawable.for_button__blue_light__null__rounded_edges)
            }
        }


    }

    /**
     * сheckingfields() - проверка заполнения полей
     * */
    private fun checkingfields(){
        with (binding){
            inputNumber1.addTextChangedListener (object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                @SuppressLint("UseCompatLoadingForDrawables")
                override fun afterTextChanged(p0: Editable?) {
                    if(inputNumber1.text.isEmpty()) {
                        inputNumber1.background =
                            getDrawable(R.drawable.for_input_text__white__blue_light__rounded_edges)
                    }
                    else {
                        inputNumber1.background = getDrawable(R.drawable.for_input_text__white__blue__rounded_edges)
                    }
                    inputNumber2.requestFocus()
                    processInput()
                }
            })
            inputNumber2.addTextChangedListener (object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                @SuppressLint("UseCompatLoadingForDrawables")
                override fun afterTextChanged(p0: Editable?) {
                    if(inputNumber2.text.isEmpty()) {
                        inputNumber2.background =
                            getDrawable(R.drawable.for_input_text__white__blue_light__rounded_edges)
                    }
                    else {
                        inputNumber2.background = getDrawable(R.drawable.for_input_text__white__blue__rounded_edges)
                    }
                    inputNumber3.requestFocus()
                    processInput()
                }
            })
            inputNumber3.addTextChangedListener (object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                @SuppressLint("UseCompatLoadingForDrawables")
                override fun afterTextChanged(p0: Editable?) {
                    if(inputNumber3.text.isEmpty()) {
                        inputNumber3.background =
                            getDrawable(R.drawable.for_input_text__white__blue_light__rounded_edges)
                    }
                    else {
                        inputNumber3.background = getDrawable(R.drawable.for_input_text__white__blue__rounded_edges)
                    }
                    inputNumber4.requestFocus()
                    processInput()
                }
            })
            inputNumber4.addTextChangedListener (object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                @SuppressLint("UseCompatLoadingForDrawables")
                override fun afterTextChanged(p0: Editable?) {
                    if(inputNumber4.text.isEmpty()) {
                        inputNumber4.background =
                            getDrawable(R.drawable.for_input_text__white__blue_light__rounded_edges)
                    }
                    else {
                        inputNumber4.background = getDrawable(R.drawable.for_input_text__white__blue__rounded_edges)
                    }
                    inputNumber4.isFocusable = false
                    processInput()
                }
            })
        }
    }
}