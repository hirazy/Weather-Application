package com.example.weatherapplication.base.data.preference

import com.example.weatherapplication.base.OBase
import com.example.weatherapplication.utils.toArrayList
import com.example.weatherapplication.utils.toObject

interface PrefHelper {
    fun setData(key: String, data: String)
    fun getData(key: String): String
}

inline fun <reified T : OBase> PrefHelper.getList(
    key: String
): MutableList<T> {
    var jsonList = getData(key)

    var list = jsonList.toArrayList<T>();
    return list
}

inline fun <reified T : OBase> PrefHelper.getObject(
    key: String
): T? {
    var s = getData(key)
    if (s != "") {
        var obj = s.toObject<T>()
        return obj
    }
    return null
}