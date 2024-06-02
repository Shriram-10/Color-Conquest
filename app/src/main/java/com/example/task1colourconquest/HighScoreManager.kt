package com.example.task1colourconquest

import android.content.Context

class HighScoreManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("HighScore", Context.MODE_PRIVATE)
    fun saveData(key1: String, value1: String, key2: String, value2: String, key3: String, value3: String, key4: String, value4: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key1, value1)
        editor.apply()
        editor.putString(key2, value2)
        editor.apply()
        editor.putString(key3, value3)
        editor.apply()
        editor.putString(key4, value4)
        editor.apply()
    }

    fun getData(key1: String, defaultValue1: String, key2: String, defaultValue2: String, key3: String, defaultValue3: String, key4: String, defaultValue4: String): List<String> {
        val data = mutableListOf<String>()
        data.add(sharedPreferences.getString(key1, defaultValue1) ?: defaultValue1)
        data.add(sharedPreferences.getString(key2, defaultValue2) ?: defaultValue2)
        data.add(sharedPreferences.getString(key3, defaultValue3) ?: defaultValue3)
        data.add(sharedPreferences.getString(key4, defaultValue4) ?: defaultValue4)
        return data
    }
}