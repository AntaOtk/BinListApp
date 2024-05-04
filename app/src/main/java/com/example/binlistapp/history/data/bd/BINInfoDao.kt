package com.example.binlistapp.history.data.bd

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.binlistapp.history.data.bd.entity.BINInfoEntity


@Dao
interface BINInfoDao {
    @Insert
    suspend fun setBinInfo(item: BINInfoEntity)

    @Query("SELECT * FROM bin_info_table")
    suspend fun getHistory(): List<BINInfoEntity>

    @Query("DELETE FROM bin_info_table")
    suspend fun clearHistory()
}
