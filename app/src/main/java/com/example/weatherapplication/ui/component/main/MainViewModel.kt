package com.example.weatherapplication.ui.component.main

import com.example.weatherapplication.data.DataRepositorySource
import com.example.weatherapplication.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class MainViewModel (val dataRepositorySource: DataRepositorySource): BaseViewModel() {

    init{

    }
}