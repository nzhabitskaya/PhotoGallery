package com.mobile.android.chameapps.photoposes.app

import com.mobile.android.chameapps.photoposes.mvp.adddialog.AddImageDialogContract
import com.mobile.android.chameapps.photoposes.mvp.adddialog.di.AddImageDialogModule
import com.mobile.android.chameapps.photoposes.mvp.adddialog.impl.AddImageDialogView
import com.mobile.android.chameapps.photoposes.mvp.grid.GridContract
import com.mobile.android.chameapps.photoposes.mvp.grid.di.GridModule
import com.mobile.android.chameapps.photoposes.mvp.mainview.MainContainerContract
import com.mobile.android.chameapps.photoposes.mvp.mainview.di.MainContainerModule
import com.mobile.android.chameapps.photoposes.mvp.mainview.impl.MainContainerView
import com.mobile.android.chameapps.photoposes.mvp.viewpager.ViewPagerContract
import com.mobile.android.chameapps.photoposes.mvp.viewpager.di.ViewPagerModule
import com.mobile.android.chameapps.photoposes.mvp.viewpager.impl.ViewPagerView
import com.mobile.android.chameapps.photoposes.room.di.RoomModule
import com.mobile.android.chameapps.photoposes.mvp.grid.impl.GridView
import dagger.Component
import javax.inject.Singleton

/**
 * Created by n.zhabitskaya on 9/28/18.
 */

@Singleton
@Component(modules = [ApplicationModule::class, RoomModule::class, MainContainerModule::class, GridModule::class, ViewPagerModule::class, AddImageDialogModule::class])
interface AppComponent {
    // Main Activity
    val mainPresenter: MainContainerContract.Presenter
    fun inject(activity: MainContainerView)

    // Grid Fragment
    val gridPresenter: GridContract.Presenter
    fun inject(fragment: GridView)

    // Viewpager Activity
    val viewPagerPresenter: ViewPagerContract.Presenter
    fun inject(activity: ViewPagerView)

    // Add Dialog Activity
    val addDialogPresenter: AddImageDialogContract.Presenter
    fun inject(activity: AddImageDialogView)
}