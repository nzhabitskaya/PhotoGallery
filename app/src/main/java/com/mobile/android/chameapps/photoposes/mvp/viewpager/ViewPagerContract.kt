package com.mobile.android.chameapps.photoposes.mvp.viewpager

import com.mobile.android.chameapps.photoposes.entities.Item
import com.mobile.android.chameapps.photoposes.mvp.base.BaseContract
import io.reactivex.Observable

/**
 * Created by Natallia Zhabitskaya on 03/07/2020.
 */

interface ViewPagerContract {
    interface View : BaseContract.View {
        fun displayItems(items: List<Item>)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadItems()
    }

    interface Model : BaseContract.Model {
        fun loadItems(): Observable<List<Item>>
    }
}