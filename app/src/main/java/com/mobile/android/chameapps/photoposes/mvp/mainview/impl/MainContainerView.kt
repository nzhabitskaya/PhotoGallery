package com.mobile.android.chameapps.photoposes.mvp.mainview.impl

import android.os.Bundle
import com.mobile.android.chameapps.photoposes.app.MyApplication
import com.mobile.android.chameapps.photoposes.mvp.mainview.MainContainerContract
import com.mobile.android.chameapps.photoposes.ui.views.MainActivity
import com.mobile.android.chameapps.photoposes.mvp.grid.impl.GridView
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class MainContainerView : MainActivity(), MainContainerContract.View {
    var subscriptions = CompositeDisposable()

    @Inject
    lateinit var presenter: MainContainerContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
        presenter.onAttachView(this)
    }

    override fun displayFragment() {
        changeFragment(GridView.newInstance())
    }

    private fun injectDependency() {
        (application as MyApplication).getAppComponent(this)?.inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptions.clear()
    }
}
