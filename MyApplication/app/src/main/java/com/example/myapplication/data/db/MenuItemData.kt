package com.example.myapplication.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

@Entity(tableName = "menu")
data class MenuItemData(
    @PrimaryKey
    @SerialName("id")
    val id: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("price")
    val price: String,//Double
    @SerialName("image")
    val image: String
)
