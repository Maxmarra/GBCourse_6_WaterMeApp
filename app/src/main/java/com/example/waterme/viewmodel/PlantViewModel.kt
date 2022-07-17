package com.example.waterme.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.work.*
import com.example.waterme.data.DataSource
import com.example.waterme.model.Plant
import com.example.waterme.worker.WaterReminderWorker
import java.util.concurrent.TimeUnit

class PlantViewModel(application: Application) : ViewModel() {

    private var _currentPlant: MutableLiveData<Plant> = MutableLiveData<Plant>()
    val currentPlant: LiveData<Plant>
        get() = _currentPlant

    fun updateCurrentPlant(plant: Plant) {
        _currentPlant.value = plant
    }

    private val workManager = WorkManager.getInstance(application)
    val plants = DataSource.plants

    internal fun scheduleReminder(
        duration: Long,
        unit: TimeUnit,
        plantName: String
    ) {

        // TOD+: create a Data instance with the plantName passed to it
        val data = Data.Builder().
        putString(WaterReminderWorker.nameKey, plantName).build()

        // TOD+: Generate a OneTimeWorkRequest with the passed in
        //  duration, time unit, and data instance
        val remainderWorkRequest = OneTimeWorkRequestBuilder<WaterReminderWorker>()
            .setInputData(data)
            .setInitialDelay(duration, unit)
            .build()

        // TOD+: Enqueue the request as a unique work request
        workManager.enqueue(remainderWorkRequest)
    }


}

class PlantViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PlantViewModel::class.java)) {
            PlantViewModel(application) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
