package com.mobile.android.chameapps.photoposes.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.mobile.android.chameapps.photoposes.R
import com.mobile.android.chameapps.photoposes.ui.adapter.ViewPagerAdapter

abstract class ViewPagerActivity : AppCompatActivity() {
    protected var mPager: ViewPager? = null
    protected var mAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager)
        mPager = findViewById(R.id.viewpager_container)
        mAdapter = ViewPagerAdapter(this)
        mPager?.setAdapter(mAdapter)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        mAdapter?.setItems(ArrayList())
        mAdapter?.notifyDataSetChanged()
        overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out)
    }
}