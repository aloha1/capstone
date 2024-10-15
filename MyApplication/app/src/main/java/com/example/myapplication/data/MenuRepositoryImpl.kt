package com.example.myapplication.data

import com.example.myapplication.MenuRepository
//import com.example.myapplication.data.db.MenuDao
//import com.example.myapplication.data.db.MenuItemData
import com.example.myapplication.di.ApplicationScope
import com.example.myapplication.di.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuRepositoryImpl @Inject constructor(
//    private val dao: MenuDao,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    @ApplicationScope private val scope: CoroutineScope
) : MenuRepository {

//    override suspend fun getMenuItem(): List<MenuItemData> {
//        return withContext(dispatcher){
////            dao.getAll()
//        }
//    }
}