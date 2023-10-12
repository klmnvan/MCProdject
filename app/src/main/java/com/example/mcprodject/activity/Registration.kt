package com.example.mcprodject.activity

import android.R
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.mcprodject.databinding.ActivityAuthorizationBinding
import com.example.mcprodject.databinding.ActivityRegistrationBinding


class Registration : AppCompatActivity() {
    lateinit var binding: ActivityRegistrationBinding
    var listMK: List<ModelNameMK> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createListMK()
    }

    fun createListMK(){
        listMK = listMK + ModelNameMK(1, "Информационные системы")
        listMK = listMK + ModelNameMK(2, "Юристы")
        listMK = listMK + ModelNameMK(3, "Бухгалтера")
        val spinnerArrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this, R.layout.simple_spinner_item,
            listMK.map{it.NamesMK}
        ) //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.SpinnerMK.setAdapter(spinnerArrayAdapter)
    }

    /**
    processInput() - функция, которая красит кнопку в другой цвет, когда она становится
    кликабельной */
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun processInput(){
        with(binding){
            inputTextF.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkingfields()
                    if(inputTextF.text.isNotEmpty()) {
                        LinearLayoutF.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__blue__rounded_edges)
                    } else {
                        LinearLayoutF.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__blue_light__rounded_edges)
                    }
                }
            })
            inputTextI.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkingfields()
                    if(inputTextI.text.isNotEmpty()) {
                        LinearLayoutI.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__blue__rounded_edges)
                    } else {
                        LinearLayoutI.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__blue_light__rounded_edges)
                    }
                }
            })
            inputTextO.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkingfields()
                    if(inputTextO.text.isNotEmpty()) {
                        LinearLayoutO.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__blue__rounded_edges)
                    } else {
                        LinearLayoutO.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__blue_light__rounded_edges)
                    }
                }
            })
            inputPassword.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkingfields()
                    if(inputPassword.text.isNotEmpty()) {
                        LinearLayoutPassword.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__blue__rounded_edges)
                    } else {
                        LinearLayoutPassword.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__blue_light__rounded_edges)
                    }
                }
            })
            inputLogin.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkingfields()
                    if(inputLogin.text.isNotEmpty()) {
                        LinearLayoutLogin.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__blue__rounded_edges)
                    } else {
                        LinearLayoutLogin.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__blue_light__rounded_edges)
                    }
                }
            })
            inputPasswordReplay.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    checkingfields()
                    if(inputPasswordReplay.text.isNotEmpty()) {
                        LinearLayoutPasswordReplay.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__blue__rounded_edges)
                    } else {
                        LinearLayoutPasswordReplay.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__blue_light__rounded_edges)
                    }
                }
            })
        }
    }

    /**
     * сheckingfields() - проверка заполнения полей
     * */
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun checkingfields(){
        with(binding){
            if(inputTextF.text.isNotEmpty() && inputTextI.text.isNotEmpty() && inputTextO.text.isNotEmpty()
                && inputLogin.text.isNotEmpty() && inputPassword.text.isNotEmpty()
                && inputPasswordReplay.text.isNotEmpty()){
                /*buttonNext.background = getDrawable(com.example.mcprodject.R.drawable.for_button__blue__null__rounded_edges)
                buttonNext.setOnClickListener {
                    startActivity(Intent(this@Authorization, InputCodeForAuthorization::class.java))
                    finish()
                }*/
            }
            else {
                /*buttonNext.background = getDrawable(com.example.mcprodject.R.drawable.for_button__blue_light__null__rounded_edges)
                buttonNext.setOnClickListener {
                    textError.visibility = View.VISIBLE
                    if(inputTextPassword.text.isEmpty()) {
                        passwordLinearLayout.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__red__rounded_edges)
                    }
                    if(inputTextLogin.text.isEmpty()) {
                        loginLinearLayout.background = getDrawable(com.example.mcprodject.R.drawable.for_input_text__white__red__rounded_edges)
                    }
                }*/
            }
        }

    }
}