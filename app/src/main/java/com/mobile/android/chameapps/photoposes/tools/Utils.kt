package com.mobile.android.chameapps.photoposes.tools

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import java.io.ByteArrayOutputStream

object Utils {
    val currentTime: String
        get() {
            val tsLong = System.currentTimeMillis() / 1000
            return java.lang.Long.toString(tsLong)
        }

    fun convertImageToBytes(image: Drawable): ByteArray {
        val bitmap = (image as BitmapDrawable).bitmap
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)
        return stream.toByteArray()
    }
}