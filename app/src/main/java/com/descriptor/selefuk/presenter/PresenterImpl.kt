package com.descriptor.selefuk.presenter

import android.app.Activity
import android.content.Context
import android.util.ArrayMap
import android.util.Log
import com.descriptor.selefuk.model.Repository
import com.descriptor.selefuk.model.RepositoryImpl
import com.descriptor.selefuk.ui.MainList
import com.descriptor.selefuk.ui.MainText
import com.descriptor.selefuk.ui.MainView
import java.nio.charset.StandardCharsets

class PresenterImpl(val listView: MainList? = null, val textView: MainText? = null, val context: Activity?): Presenter {
    val repository: Repository = RepositoryImpl(context)

    override fun getAdapter() {
        listView?.setupAdapter(repository.getMenu())
    }

    override fun getText(file: String) {
        textView?.setupText(repository.getText(file))
    }


}