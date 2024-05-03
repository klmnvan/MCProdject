package com.example.mcprodject.activity.theme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mcprodject.activity.api.PostsService
import com.example.mcprodject.activity.objects.PrefManager

open class ActivityCustomTheme: AppCompatActivity() {
    val service = PostsService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        //super - аналог base. (base.show()) из c#
        //super - обращение к функционалу родительского метода (в классе, который будет
        //от этого, мы перейдём к этому методу, если пропишем super.onCreate(savedInstanceState). Это
        //нужно для того, чтобы инициализировать тему активностей
        super.onCreate(savedInstanceState)
        setTheme()
    }

    private fun setTheme() {
        PrefManager.init(this@ActivityCustomTheme)
        /*if(!PrefManager.isLightMode) {
            UserData.theme = R.style.DarkMode
        }
        setTheme(UserData.theme)*/
    }

}