package com.hadi.bit_task.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.hadi.bit_task.R
import com.squareup.picasso.Picasso

class BindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("imgSrc")
        fun setImageSrc(imageView: ImageView, imageUrl: String?) {
            Picasso.get().load(imageUrl).error(R.drawable.logo).into(imageView)
        }
    }
}