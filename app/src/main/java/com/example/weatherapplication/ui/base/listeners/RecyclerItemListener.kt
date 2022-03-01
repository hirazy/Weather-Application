package com.example.weatherapplication.ui.base.listeners

import com.example.weatherapplication.base.OBase


/**
 * Created by AhmedEltaher
 */

interface RecyclerItemListener {
    fun onItemSelected(index: Int, data: OBase)
    fun onOption(index: Int, data: OBase)
}
