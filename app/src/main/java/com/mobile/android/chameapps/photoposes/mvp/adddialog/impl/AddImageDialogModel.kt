package com.mobile.android.chameapps.photoposes.mvp.adddialog.impl

import com.mobile.android.chameapps.photoposes.entities.Item
import com.mobile.android.chameapps.photoposes.mvp.adddialog.AddImageDialogContract
import com.mobile.android.chameapps.photoposes.room.dao.ItemsDao
import io.reactivex.Single
import io.reactivex.disposables.Disposable

/**
 * Created by Natallia Zhabitskaya on 12/26/2019.
 */

class AddImageDialogModel(private val itemsDao: ItemsDao) :
    AddImageDialogContract.Model {

    private var subscription: Disposable? = null

    override fun unsubscribe() {
        subscription?.dispose()
    }

    override fun saveItem(item: Item): Single<Long> {
        return Single.just(itemsDao.insert(item))
    }
}
