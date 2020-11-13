package com.descriptor.selefuk.model

interface Repository {
    fun getMenu(): MutableList<Data.GroupItem>
    fun getListFilesFromAssets(): MutableList<String>
    fun getGroupList(): MutableList<String>
    fun getText(file: String): String
}