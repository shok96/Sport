package com.descriptor.selefuk.model

class Data {
    data class Item(var title: String)
    data class GroupItem(var group: List<Item>)
}