package com.example.mcprodject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
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
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun processInput(){
        with(binding){
            inputTextLogin.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    сheckingfields()
                }
            })
            inputTextPassword.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    сheckingfields()
                }
            })
        }
    }

    /**
     * сheckingfields() - проверка заполнения полей
     * */
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun сheckingfields(){
        with(binding){
            if(inputTextLogin.text.isNotEmpty() && inputTextPassword.text.isNotEmpty()){
                buttonNext.background = getDrawable(R.drawable.for_button__blue__null__rounded_edges)
                buttonNext.setOnClickListener {
                    startActivity(Intent(this@Authorization, InputCodeForAuthorization::class.java))
                    finish()
                }
            }
            else {
                buttonNext.background = getDrawable(R.drawable.for_button__blue_light__null__rounded_edges)
                buttonNext.setOnClickListener {
                    Toast.makeText(this@Authorization,  "Не все поля заполнены", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}