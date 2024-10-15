package com.example.myapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MenuData::class], version = 1, exportSchema = false)
abstract class MenuDatabase: RoomDatabase() {
    abstract fun menuDao(): MenuDao
}