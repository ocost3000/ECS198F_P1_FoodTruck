package com.example.foodtruck.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FoodTruck(
    val id: Int,
    val name: String,
    val img: Int,
    val location: String,
    val time: String,
    val description: String,
    val link: String
): Parcelable