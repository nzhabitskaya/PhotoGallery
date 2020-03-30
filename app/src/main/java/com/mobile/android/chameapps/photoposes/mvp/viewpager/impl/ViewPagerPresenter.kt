package com.mobile.android.chameapps.photoposes.mvp.grid.impl

import com.mobile.android.chameapps.photoposes.mvp.base.BasePresenter
import com.mobile.android.chameapps.photoposes.mvp.viewpager.ViewPagerContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ViewPagerPresenter(private val model: ViewPagerContract.Model) : BasePresenter<ViewPagerContract.View>(),
    ViewPagerContract.Presenter {

    override fun loadItems() {
        add(
            model.loadItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view.displayItems(it)
                }
        )
    }
}
