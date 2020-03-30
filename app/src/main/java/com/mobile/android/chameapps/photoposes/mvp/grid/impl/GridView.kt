package com.mobile.android.chameapps.photoposes.mvp.grid.impl

import android.os.Bundle
import com.mobile.android.chameapps.photoposes.app.MyApplication
import com.mobile.android.chameapps.photoposes.mvp.grid.GridContract
import com.mobile.android.chameapps.photoposes.ui.views.GridFragment
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Natallia Zhabitskaya on 10/26/2019.
 */

class GridView : GridFragment(), GridContract.View {

    @Inject
    lateinit var presenter: GridContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
        presenter.onAttachView(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.loadItems()
        adapter.setPresenter(presenter)
    }

    private fun injectDependency() {
        (activity?.application as MyApplication).getAppComponent(context!!)?.inject(this)
    }

    companion object {
        @Singleton
        fun newInstance(): GridView {
            return GridView()
        }
    }
}