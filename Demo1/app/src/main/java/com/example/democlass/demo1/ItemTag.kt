package com.example.democlass.demo1

import android.app.Activity
import android.widget.Button
import android.widget.LinearLayout

class ItemTag(title: String?) {
    var title: String? = null

    init {
        this.title = title
    }

    fun createItemListView(activity: Activity): LinearLayout {
        var container = LinearLayout(activity)
        container.orientation = LinearLayout.HORIZONTAL
        //
        var btName = Button(activity)
        btName.text = this.title
        btName.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 2F);

        container.addView(btName)
        container.addView(createButtonEdit(activity));

        return container
    }

    fun createButtonEdit(activity: Activity): Button {
        var bt = Button(activity);
        bt.text = "Edit"
        bt.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 8F);
        return bt
    }


}