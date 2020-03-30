package com.mobile.android.chameapps.photoposes.mvp.grid

import com.mobile.android.chameapps.photoposes.entities.Item
import com.mobile.android.chameapps.photoposes.mvp.base.BaseContract
import io.reactivex.Completable
import io.reactivex.Observable

class GridContract {

    interface View : BaseContract.View {
        fun displayItems(items: List<Item>)

        fun onClickItem(id: Int)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadItems()

        fun onClickItem(id: Int)

        fun deleteItemById(id: Long)
    }

    interface Model : BaseContract.Model {

        fun loadItems(): Observable<List<Item>>

        fun findItemsById(id: Long): Observable<Item>

        fun removeItem(item: Item): Completable
    }
}