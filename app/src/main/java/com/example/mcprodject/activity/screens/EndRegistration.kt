package com.example.mcprodject.activity.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mcprodject.databinding.ActivityEndRegistrationBinding

class EndRegistration : AppCompatActivity() {
    lateinit var binging: ActivityEndRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityEndRegistrationBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.buttonNext.setOnClickListener{
            startActivity(Intent(this@EndRegistration, Authorization::class.java))
            finish()
        }
    }
}