package com.mobile.android.chameapps.photoposes.mvp.viewpager.di

import com.mobile.android.chameapps.photoposes.mvp.viewpager.ViewPagerContract
import com.mobile.android.chameapps.photoposes.room.dao.ItemsDao
import com.mobile.android.chameapps.photoposes.mvp.grid.impl.ViewPagerModel
import com.mobile.android.chameapps.photoposes.mvp.grid.impl.ViewPagerPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewPagerModule {

    @Provides
    fun providePresenter(model: ViewPagerContract.Model): ViewPagerContract.Presenter {
        return ViewPagerPresenter(model)
    }

    @Provides
    @Singleton
    fun provideModel(itemsDao: ItemsDao): ViewPagerContract.Model {
        return ViewPagerModel(itemsDao)
    }
}