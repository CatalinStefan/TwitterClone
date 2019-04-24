package com.devtides.twitterclone.util

import android.content.Context
import android.support.v4.widget.CircularProgressDrawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devtides.twitterclone.R
import java.text.DateFormat
import java.util.*

fun ImageView.loadUrl(url: String?, errorDrawable: Int = R.drawable.empty) {
    context?.let {
        val options = RequestOptions()
            .placeholder(progressDrawable(context))
            .error(errorDrawable)
        Glide.with(context.applicationContext)
            .load(url)
            .apply(options)
            .into(this)
    }
}

fun progressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }
}

fun getDate(s: Long?): String {
    s?.let {
        val df = DateFormat.getDateInstance()
        return df.format(Date(it))
    }
    return "Unknown"
}