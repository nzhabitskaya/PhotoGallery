package com.mobile.android.chameapps.photoposes.mvp.grid.impl

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.android.chameapps.photoposes.app.MyApplication
import com.mobile.android.chameapps.photoposes.mvp.grid.GridContract
import com.mobile.android.chameapps.photoposes.ui.adapter.GridAdapter
import com.mobile.android.chameapps.photoposes.ui.views.GridFragment
import kotlinx.android.synthetic.main.fragment_grid.view.*
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
        presenter.loadItems()
    }

    override fun initRecyclerView(view: View) {
        super.initRecyclerView(view)
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