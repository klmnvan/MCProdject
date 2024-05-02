package com.example.mcprodject.activity.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mcprodject.activity.adapters.AdapterFillEvents
import com.example.mcprodject.activity.models.ModelEvent
import com.example.mcprodject.databinding.ActivityMainScreenBinding

class MainScreen : AppCompatActivity() {
    lateinit var binding: ActivityMainScreenBinding
    private val adapterFillEvents = AdapterFillEvents()
    var eventsList: MutableList<ModelEvent>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pressingСlicks()
        getData()
    }

    /** pressingСlicks() - Обработка нажатий*/
    private fun pressingСlicks(){
        with(binding){
            buttonCleanPoisk.setOnClickListener {
                inputTextPoisk.text.clear()
            }
            buttonProfile.setOnClickListener {
                startActivity(Intent(this@MainScreen, Profile::class.java))
                finish()
            }
        }
    }

    fun initEvents(events: List<ModelEvent>){
        with(binding){
            listEvents.layoutManager = GridLayoutManager(this@MainScreen, 1)
            listEvents.adapter = adapterFillEvents
            if(events.isNotEmpty()) events.forEach { el -> adapterFillEvents.addEvent(el) }
        }
    }

    private fun getData(){
        eventsList?.add(ModelEvent(1, "Открытый урок", "16.06.2023", "Открытый урок английского языка в группе 23П"))
        eventsList?.add(ModelEvent(2, "Вебинар", "16.07.2023", "Беседа с участковым по делам несовершеннолетних"))
        eventsList?.add(ModelEvent(3, "Конкурс", "16.08.2023", "Конкурс красоты “Мисс Осень” среди учащихся колледжа"))
        eventsList?.add(ModelEvent(4, "Олимпиада", "16.09.2023", "Олимпиада по программированию в группе 33П"))
        eventsList?.add(ModelEvent(5, "Конкурс", "16.10.2023", "Конкурс чтецов на английском языке"))
        initEvents(eventsList!!)
//        val api = Retrofit.Builder()
//            .baseUrl("адресАпишки")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiRequest::class.java)
//
//        CoroutineScope(Dispatchers.IO).launch {
//            try {
//                val response = api.getEvents().awaitResponse()
//                if (response.isSuccessful) {
//                    val data = response.body()!!
//                    runOnUiThread { initEvents(data) }
//                    Log.d(TAG, data.toString())
//                }
//            } catch (e: Exception) {
//                withContext(Dispatchers.Main) {
//                    Log.d(TAG, e.toString())
//                }
//            }
//        }

//        val arrayEvents = List<ModelEvent>(3) { ModelEvent(0, "Открытый урок", "16.06.2023", "Открытый урок английского языка в группе 23П"),
//            ModelEvent(1, "Вебинар", "16.05.2023", "Беседа с участковым по делам несовершеннолетних"),
//            ModelEvent(2, "Конкурс", "16.04.2023", "Конкурс красоты “Мисс Осень” среди учащихся колледжа")}

    }

}