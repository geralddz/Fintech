package com.mobile.fintech.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mobile.fintech.data.local.database.dao.FlowerDao
import com.mobile.fintech.data.local.database.model.FlowerEntity

@Database(entities = [FlowerEntity::class], version = 1)

abstract class AppDatabase : RoomDatabase() {

    abstract fun flowerDao(): FlowerDao

    companion object {

        private var instance: AppDatabase? = null
        fun newInstance(context: Context): AppDatabase = instance ?: Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "financeapp.db"
        ).build().also {
            instance = it
        }
    }
}