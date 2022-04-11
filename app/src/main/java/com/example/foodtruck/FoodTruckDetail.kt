package com.example.foodtruck

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import com.example.foodtruck.Model.FoodTruck
import com.example.foodtruck.databinding.ActivityFoodTruckDetailBinding

class FoodTruckDetail : AppCompatActivity() {
    private lateinit var binding: ActivityFoodTruckDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodTruckDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val truck = intent.getParcelableExtra<FoodTruck>("FoodTruck")

        binding.truckName2.text = truck!!.name
        binding.truckImage2.setImageResource(truck.img)
        binding.truckLocation2.text = truck.location
        binding.truckTime2.text = truck.time

        binding.truckLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(truck.link))
            startActivity(intent)
        }

        binding.truckDescription.movementMethod = ScrollingMovementMethod.getInstance()
        binding.truckDescription.text = truck.description
    }
}