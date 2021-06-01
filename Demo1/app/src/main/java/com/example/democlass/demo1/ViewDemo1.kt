package com.example.democlass.demo1

import android.app.Activity
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import com.example.democlass.R

class ViewDemo1(activityDemo1: ActivityDemo1) {
    var context: Activity? = null
    var btSave: Button? = null
    var btClear: Button? = null
    var searchInput: EditText? = null
    var tagInput: EditText? = null
    var listView: LinearLayout? = null

    init {
        context = activityDemo1
        this.btSave = activityDemo1.findViewById(R.id.btSave)
        this.btClear = activityDemo1.findViewById(R.id.btClear)
        this.searchInput = activityDemo1.findViewById(R.id.searchInput)
        this.tagInput = activityDemo1.findViewById(R.id.tagQuery)
        this.listView = activityDemo1.findViewById(R.id.listView)
    }


}