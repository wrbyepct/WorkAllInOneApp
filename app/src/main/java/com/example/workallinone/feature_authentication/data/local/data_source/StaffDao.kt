package com.example.workallinone.feature_authentication.data.local.data_source

import androidx.compose.material.contentColorFor
import androidx.room.*
import com.example.workallinone.feature_authentication.domain.model.Staff

@Dao
interface StaffDao {
    @Query("Select * FROM staff_table WHERE id = :staffId")
    suspend fun getStaffById(staffId: Int): Staff?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStaff(staff: Staff)

    @Delete
    suspend fun deleteStaff(staff: Staff)
}