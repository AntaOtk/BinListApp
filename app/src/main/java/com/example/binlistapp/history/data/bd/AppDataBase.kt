package com.example.binlistapp.history.data.bd

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.binlistapp.history.data.bd.entity.BINInfoEntity

@Database(version = 1, entities = [BINInfoEntity::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun infoDao(): BINInfoDao

}
