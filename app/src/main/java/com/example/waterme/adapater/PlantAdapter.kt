package com.example.waterme.adapater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.waterme.databinding.ListItemBinding
import com.example.waterme.model.Plant

class PlantAdapter(
    private val longClickListener: PlantListener,
    private val shortClickListener: ShortListener
    ) :
    ListAdapter<Plant, PlantAdapter.PlantViewHolder>(DiffCallback) {

    class PlantViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            longClickListener: PlantListener,
            shortClickListener: ShortListener,
            plant: Plant
        ) {
            binding.plant = plant
            binding.longClickListner = longClickListener
            binding.shortClickListner = shortClickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Plant>() {
        override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean {
            return oldItem.name == newItem.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PlantViewHolder(
            ListItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = getItem(position)
        holder.bind(longClickListener, shortClickListener, plant)
    }
}

class PlantListener(val longClickListener: (plant: Plant) -> Boolean) {
    fun onLongClick(plant: Plant) = longClickListener(plant)
}

class ShortListener(val shortClickListener: (plant: Plant) -> Unit) {
    fun onShortClick(plant: Plant) = shortClickListener(plant)
}

