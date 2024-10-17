package com.example.myapplication.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

@Entity(tableName = "menu_table")
data class MenuItemRoom(
    @PrimaryKey
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("price")
    val price: String,
    @SerialName("image")
    val image: String,
    @SerialName("category")
    val category: String
)
