package com.example.myapplication.di

import android.content.Context
import android.content.SharedPreferences
//import androidx.room.Room
//import com.example.myapplication.data.db.MenuDao
//import com.example.myapplication.data.db.MenuDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LemonModule {

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE)
    }
//    @Singleton
//    @Provides
//    fun provideDataBase(@ApplicationContext context: Context): MenuDatabase {
//        return Room.databaseBuilder(
//            context.applicationContext,
//            MenuDatabase::class.java,
//            "Tasks.db"
//        ).build()
//    }
//
//    @Provides
//    fun provideTaskDao(database: MenuDatabase): MenuDao = database.menuDao()
}
