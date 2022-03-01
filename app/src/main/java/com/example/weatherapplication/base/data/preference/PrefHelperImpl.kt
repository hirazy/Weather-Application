package com.example.weatherapplication.base.data.preference

import android.content.Context
import android.content.SharedPreferences
import com.example.weatherapplication.R

class PrefHelperImpl(var context: Context): PrefHelper {
    private val mPrefs: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    private val editor = mPrefs.edit()

    override fun setData(key: String, data: String) {
        editor.putString(key, data)
        editor.commit()
    }

    override fun getData(key: String): String {
        return mPrefs
            .getString(key, "").toString();
    }
}