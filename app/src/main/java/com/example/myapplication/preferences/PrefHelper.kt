package com.example.myapplication.preferences

import android.content.Context
import android.content.SharedPreferences

class PrefHelper (context: Context) {

    private val PREFS_NAME: String = "Cozycraft_pref"
    private var sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPref.edit()

    fun putString(key: String, value: String) {
        editor.putString(key, value)
            .apply()
    }

    fun putBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
            .apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPref.getBoolean(key, false)
    }

    fun getString(key: String): String? {
        return sharedPref.getString(key, null)
    }

    fun clear() {
        editor.clear()
            .apply()
    }

    companion object {
         var prefHelper: PrefHelper? = null
        fun getInstance(context: Context?) : PrefHelper? {
            if (prefHelper == null) {
                prefHelper = context?.let { PrefHelper(it) }
            }
            return prefHelper

        }
    }

}