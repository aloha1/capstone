package com.example.myapplication.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MenuDao {

    @Query("SELECT * FROM menu_table")
    fun getAll(): LiveData<List<MenuItemRoom>>

    @Insert
    fun insertAll(vararg menuItems: MenuItemRoom)

    @Query("SELECT (SELECT COUNT(*) FROM menu_table) == 0")
    fun isEmpty(): Boolean
}