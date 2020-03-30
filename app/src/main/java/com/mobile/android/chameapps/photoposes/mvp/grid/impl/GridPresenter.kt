package com.mobile.android.chameapps.photoposes.mvp.grid.impl

import com.mobile.android.chameapps.photoposes.mvp.base.BasePresenter
import com.mobile.android.chameapps.photoposes.mvp.grid.GridContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GridPresenter(private val model: GridContract.Model) : BasePresenter<GridContract.View>(),
    GridContract.Presenter {

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

    override fun onClickItem(id: Int) {
        view.onClickItem(id)
    }

    override fun deleteItemById(id: Long) {
        add(
            model.findItemsById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe {
                    model.removeItem(it)
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.io())
                        .subscribe()
                }
        )
    }
}
