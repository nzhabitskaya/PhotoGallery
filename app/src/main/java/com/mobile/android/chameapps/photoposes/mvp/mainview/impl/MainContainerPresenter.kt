package com.mobile.android.chameapps.photoposes.mvp.mainview.impl

import com.mobile.android.chameapps.photoposes.mvp.mainview.MainContainerContract
import com.mobile.android.chameapps.photoposes.mvp.base.BasePresenter

/**
 * Created by Natallia Zhabitskaya on 03/08/2020.
 */

class MainContainerPresenter() :
    BasePresenter<MainContainerContract.View>(),
    MainContainerContract.Presenter {

    override fun onAttachView(view: MainContainerContract.View) {
        super.onAttachView(view)
        view.displayFragment()
    }
}