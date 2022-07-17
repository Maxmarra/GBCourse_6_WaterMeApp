package com.example.waterme

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.waterme.adapater.PlantAdapter
import com.example.waterme.adapater.PlantListener
import com.example.waterme.adapater.ShortListener
import com.example.waterme.ui.ReminderDialogFragment
import com.example.waterme.viewmodel.PlantViewModel
import com.example.waterme.viewmodel.PlantViewModelFactory
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private val viewModel: PlantViewModel by viewModels {
        PlantViewModelFactory(application)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PlantAdapter(

            PlantListener { plant ->
            val dialog = ReminderDialogFragment(plant.name)
            dialog.show(supportFragmentManager, "WaterReminderDialogFragment")
            true
            },
            ShortListener {
                //viewModel.updateCurrentPlant(it)
                val gson = Gson()
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra("Plant", gson.toJson(it))
                startActivity(intent)

            }

        )
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter
        val data = viewModel.plants
        adapter.submitList(data)
    }
}
