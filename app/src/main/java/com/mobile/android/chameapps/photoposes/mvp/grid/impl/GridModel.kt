package com.mobile.android.chameapps.photoposes.mvp.grid.impl

import com.mobile.android.chameapps.photoposes.entities.Item
import com.mobile.android.chameapps.photoposes.mvp.base.BaseModel
import com.mobile.android.chameapps.photoposes.mvp.grid.GridContract
import com.mobile.android.chameapps.photoposes.room.dao.ItemsDao
import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Created by Natallia Zhabitskaya on 12/26/2019.
 */

class GridModel(private val itemsDao: ItemsDao) : BaseModel(), GridContract.Model {

    override fun loadItems(): Observable<List<Item>> {
        return itemsDao.findAll()
    }

    override fun findItemsById(id: Long): Observable<Item> {
        return itemsDao.findItemById(id)
    }

    override fun removeItem(item: Item): Completable {
        return Completable.fromAction{ itemsDao.delete(item) }
    }
}
