package com.mobile.android.chameapps.photoposes.mvp.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Natallia Zhabitskaya on 03/08/2020.
 */

abstract class BasePresenter<T: BaseContract.View>(private val model: BaseContract.Model? = null): BaseContract.Presenter<T> {
    private var subscriptions = CompositeDisposable()
    lateinit var view: T

    open fun add(disposable: Disposable) {
        subscriptions.add(disposable)
    }

    override fun onAttachView(view: T) {
        this.view = view
    }

    override fun unsubscribe() {
        subscriptions.clear()
        model?.unsubscribe()
    }
}