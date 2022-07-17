package com.example.waterme

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import coil.load
import com.example.waterme.databinding.ActivityDetailBinding
import com.example.waterme.model.Plant
import com.example.waterme.viewmodel.PlantViewModel
import com.example.waterme.viewmodel.PlantViewModelFactory
import com.google.gson.Gson

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)

        val gson = Gson()
        val plant = gson.fromJson(intent.getStringExtra("Plant"), Plant::class.java)

        binding.lifecycleOwner = this
        binding.plant = plant

        setContentView(binding.root)
    }
}