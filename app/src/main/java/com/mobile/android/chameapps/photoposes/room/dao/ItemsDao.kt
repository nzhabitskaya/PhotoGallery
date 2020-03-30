package com.mobile.android.chameapps.photoposes.room.dao

import androidx.room.*
import com.mobile.android.chameapps.photoposes.entities.Item
import io.reactivex.Observable

@Dao
interface ItemsDao {
    @Query("SELECT * FROM items ORDER BY timestamp DESC")
    fun findAll(): Observable<List<Item>>

    @Query("SELECT * FROM items WHERE id=:id")
    fun findItemById(id: Long): Observable<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Item): Long

    @Update
    fun update(item: Item): Int

    @Delete
    fun delete(item: Item)
}