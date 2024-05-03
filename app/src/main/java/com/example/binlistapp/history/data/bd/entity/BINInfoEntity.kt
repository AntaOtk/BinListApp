package com.example.binlistapp.history.data.bd.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_info_table")
data class BINInfoEntity(
    @PrimaryKey
    val id: Int,
    val country: String?
)
