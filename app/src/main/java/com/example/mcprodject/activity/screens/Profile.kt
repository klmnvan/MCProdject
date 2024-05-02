package com.example.mcprodject.activity.screens

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.mcprodject.activity.models.ModelNameMK
import com.example.mcprodject.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    var listMK: List<ModelNameMK> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pressingСlicks()
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
        binding.spinnerMK.setAdapter(spinnerArrayAdapter)
    }

    /** pressingСlicks() - Обработка нажатий*/
    private fun pressingСlicks(){
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
            buttonDeleteFam.setOnClickListener{
                inputTextFam.text.clear()
            }
            buttonDeleteName.setOnClickListener{
                inputTextName.text.clear()
            }
            buttonDeleteOtch.setOnClickListener{
                inputTextOtch.text.clear()
            }

            buttonEvent.setOnClickListener {
                startActivity(Intent(this@Profile, MainScreen::class.java))
                finish()
            }
        }
    }



}