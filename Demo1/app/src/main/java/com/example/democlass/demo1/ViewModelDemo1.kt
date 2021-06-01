package com.example.democlass.demo1

import android.app.Activity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import java.util.Collections.min
import kotlin.math.min

class ViewModelDemo1(activityDemo1: ActivityDemo1, view: ViewDemo1, model: ModelDemo1) {
    var view: ViewDemo1? = null
    var model: ModelDemo1? = null
    var context: Activity? = null

    init {
        this.view = view
        this.model = model
        this.context = activityDemo1
    }

    fun addEventsListener() {
        addSearchTextListener()
        addTagTextListener()
        setBtClearClickListener()
        setBtSaveClickListener()
    }

    fun updateListItem() {
        this.view?.listView?.removeAllViews()
        for (item in this.model?.listResult!!) {
            this.view?.listView?.addView(this.context?.let { item.createItemListView(it) });
        }
    }

    private fun addSearchTextListener() {
        this.view?.searchInput?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                model?.searchText = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }

    private fun addTagTextListener() {
        this.view?.tagInput?.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                model?.tagText = s.toString()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

        })
    }

    private fun setBtSaveClickListener() {
        this.view?.btSave?.setOnClickListener {
            if (model?.tagText?.equals("")!!) {
                Toast.makeText(this.context, "Input something", Toast.LENGTH_LONG)
            } else {
                model?.listItemTag = Array(model?.listItemTag?.size!! + 1, { index -> model?.listItemTag!![min(index, model?.listItemTag?.size!! - 1)] })
                model?.listItemTag!![model?.listItemTag?.size!! - 1] = ItemTag(model?.tagText)
                model?.listResult = model?.listItemTag
                updateListItem()
            }
        }
    }

    private fun setBtClearClickListener() {
        this.view?.btClear?.setOnClickListener {
            Log.d("@@@", "click clear");
            model?.listItemTag = emptyArray()
            model?.listResult = model?.listItemTag
            updateListItem()
        }
    }

}