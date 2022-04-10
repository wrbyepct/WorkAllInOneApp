package com.example.workallinone.feature_authentication.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "staff_table")
data class Staff(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val username: String,
    val password: String,
    @ColumnInfo(name = "is_manager")
    val isManager: Boolean = false,

    @ColumnInfo(name = "is_full_timer")
    val isFullTimer: Boolean = false
)
