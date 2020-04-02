package com.mobile.android.chameapps.photoposes.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.mobile.android.chameapps.photoposes.R
import com.mobile.android.chameapps.photoposes.entities.Item


/**
 * Created by n.zhabitskaya on 2019-07-09.
 */
class ViewPagerAdapter(private val context: Context) : PagerAdapter() {
    private var items: List<Item> = ArrayList()
    private var currentPosition = 0

    fun setItems(items : List<Item>) {
        this.items = items
    }

    fun setCurrentPosition(currentPosition: Int) {
        this.currentPosition = currentPosition
    }

    override fun instantiateItem(parent: ViewGroup, position: Int): View {
        val inflater = LayoutInflater.from(context)
        val view =
            inflater.inflate(R.layout.image_view, parent, false) as View

        val imageView: ImageView = view.findViewById(R.id.image_view)
        val imageByteArray = items.get((position + currentPosition) % items.size).byteArray
        Glide.with(context)
            .load(imageByteArray)
            .dontAnimate()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .placeholder(R.drawable.circle_shape_white)
            .into(imageView)

        parent.addView(view)
        return view
    }

    override fun destroyItem(parent: ViewGroup, position: Int, view: Any) {
        val imageView: ImageView = (view as View).findViewById(R.id.image_view)
        Glide.with(context).clear(imageView)
        parent.removeView(view as View?)
    }

    override fun getCount(): Int {
        return items.size * 100
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }
}