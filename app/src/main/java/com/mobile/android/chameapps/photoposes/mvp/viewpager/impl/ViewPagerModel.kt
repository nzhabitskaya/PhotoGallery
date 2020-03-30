package com.mobile.android.chameapps.photoposes.mvp.grid.impl

import com.mobile.android.chameapps.photoposes.entities.Item
import com.mobile.android.chameapps.photoposes.mvp.base.BaseModel
import com.mobile.android.chameapps.photoposes.mvp.viewpager.ViewPagerContract
import com.mobile.android.chameapps.photoposes.room.dao.ItemsDao
import io.reactivex.Observable

/**
 * Created by Natallia Zhabitskaya on 12/26/2019.
 */

class ViewPagerModel(private val itemsDao: ItemsDao) : BaseModel(), ViewPagerContract.Model {

    override fun loadItems(): Observable<List<Item>> {
        return itemsDao.findAll()
    }
}
