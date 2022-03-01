package com.example.weatherapplication.base.adapter

import com.example.weatherapplication.base.OBase


interface BaseViewListener {
    fun onItemClicked(index: Int, data: OBase)
    fun onItemLongClicked(index: Int, data: OBase)
    fun OnItemLiked(index: Int)
}