package com.example.workallinone.feature_authentication.domain.repository


import com.example.workallinone.feature_authentication.domain.model.Staff

interface StaffRepository {

    suspend fun getStaffById(staffId: Int): Staff?

    suspend fun insertStaff(staff: Staff)

    suspend fun deleteStaff(staff: Staff)
}