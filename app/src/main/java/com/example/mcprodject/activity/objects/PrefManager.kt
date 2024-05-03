package com.example.mcprodject.activity.objects

import android.content.Context
import android.content.SharedPreferences

object PrefManager {
    private lateinit var spUserProfile: SharedPreferences
    private lateinit var spActSystem: SharedPreferences
    private lateinit var spUserOrders: SharedPreferences

    /* Сюда приходит контекст класса, из которого мы обращаемся к SharedPref, с помощью чего
    мы можем каждый раз заново не прописывать создание объекта Shred Pref, а просто изменять
    и получать часто применяемые переменные через геттеры и сеттеры */
    fun init(context: Context){
        spUserProfile = context.getSharedPreferences("userProfile", Context.MODE_PRIVATE)
        spUserOrders = context.getSharedPreferences("userOrder", Context.MODE_PRIVATE)
        spActSystem = context.getSharedPreferences("Act", Context.MODE_PRIVATE)
    }

    //работа геттеров и сеттеров в kotlin
    var email: String
        //когда мы откуда-то пытаемся получить данные email
        get() = spUserProfile.getString("userEmail", "")!!
        //когда мы пытаемся приравнять к email
        set(value) {
            spUserProfile.edit().putString("userEmail", value).apply()
        }

    var password: String
        get() = spUserProfile.getString("userPassword", "")!!
        set(value) {
            spUserProfile.edit().putString("userPassword", value).apply()
        }

    var passwordSHA512: String
        get() = spUserProfile.getString("userPasswordSHA512", "")!!
        set(value) {
            spUserProfile.edit().putString("userPasswordSHA512", value).apply()
        }

    var indAct: Int
        get() = spActSystem.getInt("indAct", 0)
        set(value) {
            spActSystem.edit().putInt("indAct", value).apply()
        }

    var isLightMode: Boolean
        get() = spUserProfile.getBoolean("modeTheme", true)
        set(value) {
            spUserProfile.edit().putBoolean("modeTheme", value).apply()
        }

}