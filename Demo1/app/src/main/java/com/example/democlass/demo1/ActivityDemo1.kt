package com.example.democlass.demo1

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import com.example.democlass.R

class ActivityDemo1 : Activity() {
    var viewModel: ViewModelDemo1? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo_1_layout)

        val view = ViewDemo1(this)
        val model = ModelDemo1()
        viewModel = ViewModelDemo1(this, view, model)

        viewModel?.addEventsListener()

        viewModel?.updateListItem()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val thumbnail: Bitmap = data.getParcelableExtra("data")
            // Do other work with full size photo saved in locationForPhotos
        }


    }