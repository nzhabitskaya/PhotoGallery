package com.mobile.android.chameapps.photoposes.mvp.adddialog.impl

import android.os.Bundle
import com.mobile.android.chameapps.photoposes.app.MyApplication
import com.mobile.android.chameapps.photoposes.mvp.adddialog.AddImageDialogContract
import com.mobile.android.chameapps.photoposes.ui.views.AddImageDialogActivity
import javax.inject.Inject

class AddImageDialogView : AddImageDialogActivity(), AddImageDialogContract.View {

    @Inject
    lateinit var presenter: AddImageDialogContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
        presenter.onAttachView(this)
    }

    private fun injectDependency() {
        (application as MyApplication).getAppComponent(this)?.inject(this)
    }
}