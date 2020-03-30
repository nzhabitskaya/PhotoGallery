package com.mobile.android.chameapps.photoposes.mvp.adddialog

import android.graphics.drawable.Drawable
import com.mobile.android.chameapps.photoposes.mvp.base.BaseContract
import com.mobile.android.chameapps.photoposes.entities.Item
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

class AddImageDialogContract {

    interface View : BaseContract.View {

        val clickSave: PublishSubject<Drawable?>

        fun closeDialog()
    }

    interface Presenter : BaseContract.Presenter<View> {

    }

    interface Model : BaseContract.Model {

        fun saveItem(item: Item): Single<Long>
    }
}