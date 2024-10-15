//package com.example.myapplication.data.db
//
//import androidx.room.Dao
//import androidx.room.Query
//import androidx.room.Upsert
//
//@Dao
//interface MenuDao {
//
//    @Query("SELECT * FROM menu")
//    suspend fun getAll(): List<MenuItemData>
//
//    /**
//     * Insert or update a task in the database. If a task already exists, replace it.
//     *
//     * @param menuItemData the task to be inserted or updated.
//     */
//    @Upsert
//    suspend fun upsert(menuItemData: MenuItemData)
//
//    /**
//     * Insert or update tasks in the database. If a task already exists, replace it.
//     *
//     * @param menuList the tasks to be inserted or updated.
//     */
//    @Upsert
//    suspend fun upsertAll(menuList: List<MenuItemData>)
//}