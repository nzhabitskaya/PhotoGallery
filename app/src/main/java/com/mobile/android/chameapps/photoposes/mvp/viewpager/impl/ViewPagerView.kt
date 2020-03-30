package com.mobile.android.chameapps.photoposes.mvp.viewpager.impl

import android.os.Bundle
import com.mobile.android.chameapps.photoposes.app.MyApplication
import com.mobile.android.chameapps.photoposes.entities.Item
import com.mobile.android.chameapps.photoposes.mvp.viewpager.ViewPagerContract
import com.mobile.android.chameapps.photoposes.ui.views.GridFragment.Companion.ITEM_ID
import com.mobile.android.chameapps.photoposes.ui.views.ViewPagerActivity
import javax.inject.Inject


class ViewPagerView : ViewPagerActivity(), ViewPagerContract.View {

    @Inject
    lateinit var presenter: ViewPagerContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
        presenter.onAttachView(this)
        val position = intent.getIntExtra(ITEM_ID, 0)
        mAdapter?.setCurrentPosition(position)
    }

    override fun onResume() {
        super.onResume()
        presenter.loadItems()
    }

    override fun displayItems(items: List<Item>) {
        mAdapter?.setItems(items)
        mAdapter?.notifyDataSetChanged()
    }

    private fun injectDependency() {
        (application as MyApplication).getAppComponent(this)?.inject(this)
    }
}
