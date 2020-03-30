package com.mobile.android.chameapps.photoposes.mvp.base

class BaseContract {

    interface View

    interface Presenter<in T> {
        fun onAttachView(view: T)
        fun unsubscribe()
    }

    interface Model {
        fun unsubscribe()
    }
}