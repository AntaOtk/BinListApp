package com.example.binlistapp.history.data.bd.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_info_table")
data class BINInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val scheme: String,
    val type: String,
    val brand: String,
    val prepaid: Boolean?,
    val country: String,
    val bank: String,
)
