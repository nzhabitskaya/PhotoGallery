package com.mobile.android.chameapps.photoposes.ui.views

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.android.chameapps.photoposes.R
import com.mobile.android.chameapps.photoposes.entities.Item
import com.mobile.android.chameapps.photoposes.mvp.adddialog.impl.AddImageDialogView
import com.mobile.android.chameapps.photoposes.mvp.grid.GridContract
import com.mobile.android.chameapps.photoposes.mvp.viewpager.impl.ViewPagerView
import com.mobile.android.chameapps.photoposes.ui.adapter.GridAdapter
import com.mobile.android.chameapps.photoposes.ui.gestures.GestureCallback
import com.mobile.android.chameapps.photoposes.ui.gestures.OnGestureRegisteredListener
import kotlinx.android.synthetic.main.fragment_grid.view.*


abstract class GridFragment : Fragment(), GestureCallback, GridContract.View {
    lateinit var adapter: GridAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_grid, container, false)
        initRecyclerView(view)
        return view
    }

    override fun onResume() {
        super.onResume()
        view?.recycler_view?.setOnTouchListener(OnGestureRegisteredListener(context, this))
    }

    override fun displayItems(items: List<Item>) {
        adapter.setItems(items)
        adapter.notifyDataSetChanged()
    }

    override fun onClickItem(id: Int) {
        val intent = Intent(context, ViewPagerView::class.java)
        intent.putExtra(ITEM_ID, id)
        startActivity(intent)
        activity?.overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out)
    }

    private fun initRecyclerView(view: View) {
        adapter = GridAdapter(context!!)
        view.recycler_view.adapter = adapter

        val layoutManager = GridLayoutManager(context, 3)
        view.recycler_view.layoutManager = layoutManager as RecyclerView.LayoutManager
    }

    override fun onSwipeTop() {
        val intent = Intent(context, AddImageDialogView::class.java)
        startActivity(intent)
    }

    companion object {
        val ITEM_ID = "item_id"
    }
}
