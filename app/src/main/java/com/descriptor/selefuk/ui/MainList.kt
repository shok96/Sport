package com.descriptor.selefuk.ui

import com.descriptor.selefuk.model.Data


interface MainList:MainView {
    fun setupAdapter(list: MutableList<Data.GroupItem>)
}