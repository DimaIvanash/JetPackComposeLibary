package com.example.jetpackcompose.ui

import android.app.Application
import com.example.jetpackcompose.data.AppContainer
import com.example.jetpackcompose.data.DefaultAppContainer


class BooksApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}