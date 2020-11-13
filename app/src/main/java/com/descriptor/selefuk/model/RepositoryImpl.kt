package com.descriptor.selefuk.model

import android.app.Activity
import android.content.Context
import android.util.ArrayMap
import android.util.Log

class RepositoryImpl(val context: Activity?): Repository {

    override fun getMenu(): MutableList<Data.GroupItem> {
        var menu: MutableList<Data.GroupItem> = ArrayList<Data.GroupItem>()
        val list = getGroupList()
        for(i in 0..list.size - 1 step 2){
            var group: MutableList<Data.Item> = ArrayList<Data.Item>()
            group.add(Data.Item(list.get(i)))
            group.add(Data.Item(list.get(i+1)))
            menu.add(Data.GroupItem(group))
        }
        return menu
    }

    override fun getListFilesFromAssets(): MutableList<String>{
        var list: MutableList<String> = ArrayList<String>()
        val am = context?.assets
        am?.list("")?.map {
            list.add(it)
        }
        return list
    }

    override fun getGroupList(): MutableList<String>{
        val listFiles = getListFilesFromAssets()
        listFiles.apply {
            remove("images")
            remove("webkit")
        }
        listFiles.sort()
        return listFiles
    }

    override fun getText(file: String): String{
        val text = context?.assets?.open(file)?.bufferedReader().use {
            it?.readText()
        }
        return text ?: ""
    }

}