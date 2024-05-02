package com.example.mcprodject.activity.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mcprodject.R
import com.example.mcprodject.activity.models.ModelEvent
import com.example.mcprodject.databinding.ItemEventBinding

class AdapterFillEvents: RecyclerView.Adapter<AdapterFillEvents.EventHolder>() {

    val eventsList = ArrayList<ModelEvent>()

    class EventHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = ItemEventBinding.bind(item)

        fun bind(modelEvent: ModelEvent){
            binding.textDate.text = modelEvent.date
            binding.textDescription.text = modelEvent.description
            binding.textTitle.text = modelEvent.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventHolder(view)
    }

    override fun onBindViewHolder(holder: EventHolder, position: Int) {
        holder.bind(eventsList[position])
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addEvent(modelEvent: ModelEvent){
        eventsList.add(modelEvent)
        notifyDataSetChanged()
    }

}