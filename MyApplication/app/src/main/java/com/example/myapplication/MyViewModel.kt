package com.example.myapplication

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val menuRepository: MenuRepository
) : ViewModel() {
    // Data and logic for the screen
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> get() = _name

    fun setName(newName: String) {
        _name.value = newName
    }

    fun isRegistered(): Boolean {
        return sharedPreferences.getBoolean("registered", false)
    }

    fun setRegistered(boolean: Boolean = false) {
        sharedPreferences.edit().putBoolean("registered", boolean).apply()
    }

}