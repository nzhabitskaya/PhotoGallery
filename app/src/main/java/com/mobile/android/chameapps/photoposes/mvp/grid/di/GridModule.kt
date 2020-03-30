package com.mobile.android.chameapps.photoposes.mvp.grid.di

import com.mobile.android.chameapps.photoposes.mvp.grid.GridContract
import com.mobile.android.chameapps.photoposes.room.dao.ItemsDao
import com.mobile.android.chameapps.photoposes.mvp.grid.impl.GridModel
import com.mobile.android.chameapps.photoposes.mvp.grid.impl.GridPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GridModule {

    @Provides
    fun providePresenter(model: GridContract.Model): GridContract.Presenter {
        return GridPresenter(model)
    }

    @Provides
    @Singleton
    fun provideModel(itemsDao: ItemsDao): GridContract.Model {
        return GridModel(itemsDao)
    }
}