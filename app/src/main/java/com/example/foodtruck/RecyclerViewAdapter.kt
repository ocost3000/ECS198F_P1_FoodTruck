package com.example.foodtruck

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodtruck.Model.FoodTruck

class RecyclerViewAdapter(private val foodTrucks: List<FoodTruck>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val truckName: TextView = itemView.findViewById(R.id.truckName1)
        val truckImage: ImageView = itemView.findViewById(R.id.truckImage1)
        val truckLocation: TextView = itemView.findViewById(R.id.truckLocation1)
        val truckTime: TextView = itemView.findViewById(R.id.truckTime1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.food_truck_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val truck = foodTrucks[position]

        holder.apply {
            truckName.text = truck.name
            truckImage.setImageResource(truck.img)
            truckLocation.text = truck.location
            truckTime.text = truck.time
        }

        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, FoodTruckDetail::class.java)
            intent.putExtra("FoodTruck", truck)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = foodTrucks.size
}