package com.mobile.android.chameapps.photoposes.mvp.mainview

import android.view.ViewGroup
import com.mobile.android.chameapps.photoposes.mvp.base.BaseContract

/**
 * Created by Natallia Zhabitskaya on 03/07/2020.
 */

interface MainContainerContract {

    interface Presenter : BaseContract.Presenter<View> {

    }

    interface View : BaseContract.View {
        fun getView(): ViewGroup

        fun displayFragment()

        fun openDetailsActivity(categoryId: Long)
    }
}