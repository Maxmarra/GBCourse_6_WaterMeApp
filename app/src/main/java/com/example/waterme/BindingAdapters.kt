package com.example.waterme

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgId: Int) {
        imgView.load(imgId){
        }

}

