package com.mobile.android.chameapps.photoposes.entities

import androidx.room.*

@Entity(tableName = "items")
class Item {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @ColumnInfo(name = "timestamp")
    var timestamp: String

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    var byteArray: ByteArray?

    @Ignore
    constructor() {
        this.timestamp = ""
        this.byteArray = null
    }

    constructor(byteArray: ByteArray, timestamp: String) {
        this.timestamp = timestamp
        this.byteArray = byteArray
    }
}
