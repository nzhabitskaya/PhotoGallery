package com.mobile.android.chameapps.photoposes.mvp.adddialog.impl

import android.graphics.drawable.Drawable
import com.mobile.android.chameapps.photoposes.entities.Item
import com.mobile.android.chameapps.photoposes.mvp.adddialog.AddImageDialogContract
import com.mobile.android.chameapps.photoposes.mvp.base.BasePresenter
import com.mobile.android.chameapps.photoposes.tools.Utils.convertImageToBytes
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AddImageDialogPresenter(private val model: AddImageDialogContract.Model) :
    BasePresenter<AddImageDialogContract.View>(), AddImageDialogContract.Presenter {

    private lateinit var onItemSaved: Single<Long>

    override fun onAttachView(view: AddImageDialogContract.View) {
        this.view = view
        subscribeOnClick()
    }

    private fun subscribeOnClick() {
        add(
            view.clickSave
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe {
                    if (it != null) {
                        saveImage(it)
                        subscribeOnImageSaved()
                    }
                    view.closeDialog()
                }
        )
    }

    private fun saveImage(image: Drawable) {
        onItemSaved = model.saveItem(Item(convertImageToBytes(image), getCurrentTime()))
    }

    private fun subscribeOnImageSaved() {
        add(
            onItemSaved
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }

    fun getCurrentTime(): String {
        val tsLong = System.currentTimeMillis() / 1000
        return java.lang.Long.toString(tsLong)
    }
}
