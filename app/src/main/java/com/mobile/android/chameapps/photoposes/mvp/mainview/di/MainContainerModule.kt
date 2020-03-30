package com.mobile.android.chameapps.photoposes.mvp.mainview.di

import com.mobile.android.chameapps.photoposes.mvp.mainview.MainContainerContract
import com.mobile.android.chameapps.photoposes.mvp.mainview.impl.MainContainerPresenter
import dagger.Module
import dagger.Provides

/**
 * Created by Natallia Zhabitskaya on 03/08/2020.
 */

@Module
class MainContainerModule {

    @Provides
    fun providePresenter(): MainContainerContract.Presenter {
        return MainContainerPresenter()
    }
}