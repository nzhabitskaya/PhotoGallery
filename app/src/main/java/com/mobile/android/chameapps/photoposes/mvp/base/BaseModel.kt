package com.mobile.android.chameapps.photoposes.mvp.base

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Natallia Zhabitskaya on 03/08/2020.
 */

abstract class BaseModel: BaseContract.Model {
    protected var subscriptions = CompositeDisposable()

    override fun unsubscribe() {
        subscriptions.clear()
    }
}