package com.example.workallinone.feature_authentication.data.local.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.workallinone.feature_authentication.domain.model.Staff

@Database(entities = [Staff::class], version = 1)
abstract class StaffDatabase : RoomDatabase(){

    abstract val dao: StaffDao

    companion object {
        const val DATABASE_NAME = "staff_db"
    }
}