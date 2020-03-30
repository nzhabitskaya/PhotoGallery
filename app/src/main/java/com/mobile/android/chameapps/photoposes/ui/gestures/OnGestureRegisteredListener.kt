package com.mobile.android.chameapps.photoposes.ui.gestures

import android.annotation.SuppressLint
import android.content.Context
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener

class OnGestureRegisteredListener(context: Context?, callback: GestureCallback) :
    OnTouchListener {
    private val gestureDetector: GestureDetector
    private var view: View? = null
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(view: View, event: MotionEvent): Boolean {
        this.view = view
        try {
            return gestureDetector.onTouchEvent(event)
        } catch (e: java.lang.IllegalArgumentException) {
            return false
        }
    }

    private val callback: GestureCallback

    init {
        this.callback = callback
    }

    private inner class GestureListener : SimpleOnGestureListener() {
        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onLongPress(e: MotionEvent) {
            callback.onLongClick()
            super.onLongPress(e)
        }

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            callback.onClick()
            return super.onSingleTapUp(e)
        }

        override fun onFling(
            e1: MotionEvent,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            var result = false
            try {
                val diffY = e2.y - e1.y
                val diffX = e2.x - e1.x
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > Companion.SWIPE_THRESHOLD && Math.abs(
                            velocityX
                        ) > Companion.SWIPE_VELOCITY_THRESHOLD
                    ) {
                        if (diffX > 0) {
                            callback.onSwipeRight()
                        } else {
                            callback.onSwipeLeft()
                        }
                        result = true
                    }
                } else if (Math.abs(diffY) > Companion.SWIPE_THRESHOLD && Math.abs(
                        velocityY
                    ) > Companion.SWIPE_VELOCITY_THRESHOLD
                ) {
                    if (diffY > 0) {
                        callback.onSwipeBottom()
                    } else {
                        callback.onSwipeTop()
                    }
                    result = true
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }
            return result
        }
    }

    companion object {
        private const val SWIPE_THRESHOLD = 500
        private const val SWIPE_VELOCITY_THRESHOLD = 500
    }

    init {
        gestureDetector = GestureDetector(
            context,
            GestureListener()
        )
    }
}

interface GestureCallback {
    fun onSwipeRight() {}
    fun onSwipeLeft() {}
    fun onSwipeBottom() {}
    fun onSwipeTop() {}
    fun onClick() {}
    fun onLongClick() {}
}