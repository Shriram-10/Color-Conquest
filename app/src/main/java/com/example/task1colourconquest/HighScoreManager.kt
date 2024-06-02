package com.example.task1colourconquest

import android.content.Context

class HighScoreManager(context: Context) {
    private val sharedPreferences = context.getSharedPreferences("HighScore", Context.MODE_PRIVATE)
    fun saveData(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getData(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }
}