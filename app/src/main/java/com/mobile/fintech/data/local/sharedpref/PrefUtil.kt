package com.mobile.fintech.data.local.sharedpref

import android.content.Context
import android.preference.PreferenceManager

class PrefUtil(context: Context) {
    private var pref = PreferenceManager.getDefaultSharedPreferences(context)

    fun savestring(key: String, value: String) = apply {
        pref.edit().putString(key,value).apply()
    }

    fun saveboolean(key: String, value: Boolean) = apply {
        pref.edit().putBoolean(key,value).apply()
    }

    fun getString(key: String) = pref.getString(key,"")
    fun getBoolean(key: String) = pref.getBoolean(key,false)
    fun getInt(key: String) = pref.getInt(key,0)

    companion object {
        private var instance : PrefUtil? = null

        fun newInstance(context: Context) = instance ?: PrefUtil(context).also {
            instance = it
        }
    }
}