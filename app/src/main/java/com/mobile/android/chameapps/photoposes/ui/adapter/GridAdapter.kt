package com.mobile.android.chameapps.photoposes.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.android.chameapps.photoposes.R
import com.mobile.android.chameapps.photoposes.entities.Item
import com.mobile.android.chameapps.photoposes.mvp.grid.GridContract
import kotlinx.android.synthetic.main.grid_view.view.*
import kotlinx.android.synthetic.main.image_view.view.image_view


class GridAdapter(private val context: Context) : OnDeleteZoneClickCallback, OnItemClickCallback,
    RecyclerView.Adapter<GridViewHolder>() {
    private var items: List<Item> = ArrayList()
    private lateinit var presenter: GridContract.Presenter

    fun setItems(items: List<Item>) {
        this.items = items
    }

    fun setPresenter(presenter: GridContract.Presenter) {
        this.presenter = presenter
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val layoutResId = R.layout.grid_view
        val viewHolder = GridViewHolder(
            LayoutInflater.from(context).inflate(layoutResId, parent, false),
            this,
            this
        )
        return viewHolder
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val imageByteArray = items.get(position).byteArray
        Glide.with(context)
            .load(imageByteArray)
            .placeholder(R.drawable.circle_shape_white)
            .into(holder.imageView)
        holder.id = items.get(position).id
        holder.pos = position
    }

    override fun onClickItem(id: Int) {
        presenter.onClickItem(id)
    }

    override fun onDeleteItem(id: Long) {
        presenter.deleteItemById(id)
    }
}

class GridViewHolder(
    view: View,
    private val onItemClickCallback: OnItemClickCallback,
    private val onDeleteZoneClickCallback: OnDeleteZoneClickCallback
) : View.OnClickListener, View.OnLongClickListener, RecyclerView.ViewHolder(view) {
    val imageView = view.image_view
    val deleteBtn = view.bt_delete
    var onLongClicked = false
    var id = 0L
    var pos = 0

    init {
        deleteBtn.setOnClickListener(this)
        imageView.setOnClickListener({
            if (onLongClicked) {
                onLongClicked = false
            } else {
                onItemClickCallback.onClickItem(pos)
            }
        })
        imageView.setOnLongClickListener(this)
    }

    override fun onClick(v: View?) {
        if (deleteBtn.visibility == GONE) {
            return
        }
        onDeleteZoneClickCallback.onDeleteItem(id)
    }

    override fun onLongClick(v: View?): Boolean {
        onLongClicked = true
        deleteBtn.visibility = if (deleteBtn.visibility == VISIBLE) GONE else VISIBLE
        return false
    }
}

interface OnItemClickCallback {
    fun onClickItem(id: Int)
}

interface OnDeleteZoneClickCallback {
    fun onDeleteItem(id: Long)
}