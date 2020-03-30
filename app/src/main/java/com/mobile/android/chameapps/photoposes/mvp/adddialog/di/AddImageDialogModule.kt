package com.mobile.android.chameapps.photoposes.mvp.adddialog.di

import com.mobile.android.chameapps.photoposes.mvp.adddialog.AddImageDialogContract
import com.mobile.android.chameapps.photoposes.mvp.adddialog.impl.AddImageDialogModel
import com.mobile.android.chameapps.photoposes.mvp.adddialog.impl.AddImageDialogPresenter
import com.mobile.android.chameapps.photoposes.room.dao.ItemsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AddImageDialogModule {

    @Provides
    fun providePresenter(model: AddImageDialogContract.Model): AddImageDialogContract.Presenter {
        return AddImageDialogPresenter(model)
    }

    @Provides
    @Singleton
    fun provideModel(itemsDao: ItemsDao): AddImageDialogContract.Model {
        return AddImageDialogModel(itemsDao)
    }
}