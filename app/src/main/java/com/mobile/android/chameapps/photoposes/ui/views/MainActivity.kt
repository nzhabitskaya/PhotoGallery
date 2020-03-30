package com.mobile.android.chameapps.photoposes.ui.views

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mobile.android.chameapps.photoposes.R
import com.mobile.android.chameapps.photoposes.mvp.adddialog.impl.AddImageDialogView
import com.mobile.android.chameapps.photoposes.mvp.mainview.MainContainerContract

abstract class MainActivity : AppCompatActivity(), MainContainerContract.View {

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        setContentView(R.layout.activity_main)
    }

    open fun changeFragment(fragment: Fragment?) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment!!).commit()
    }

    override fun openDetailsActivity(categoryId: Long) {
        val myIntent = Intent(this, AddImageDialogView::class.java)
        startActivity(myIntent)
    }

    override fun getView(): ViewGroup {
        return findViewById<FrameLayout>(R.id.fragment_container) as ViewGroup
    }
}
