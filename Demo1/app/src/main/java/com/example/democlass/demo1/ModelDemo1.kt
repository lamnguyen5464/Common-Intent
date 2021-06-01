package com.example.democlass.demo1

class ModelDemo1 {
    var searchText: String? = null
    var tagText: String? = null
    var listItemTag: Array<ItemTag>? = null
    var listResult: Array<ItemTag>? = null

    init {
        this.searchText = ""
        this.tagText = ""
        this.listItemTag = Array(5, {index -> ItemTag(index.toString()+" test") })
        this.listResult = this.listItemTag
    }
}