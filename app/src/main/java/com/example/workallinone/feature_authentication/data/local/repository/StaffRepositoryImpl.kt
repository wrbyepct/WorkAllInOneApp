package com.example.workallinone.feature_authentication.data.local.repository

import com.example.workallinone.feature_authentication.data.local.data_source.StaffDao
import com.example.workallinone.feature_authentication.domain.model.Staff
import com.example.workallinone.feature_authentication.domain.repository.StaffRepository

class StaffRepositoryImpl(
    private val dao: StaffDao
) : StaffRepository {

    override suspend fun getStaffById(staffId: Int): Staff? {
        return dao.getStaffById(staffId)
    }

    override suspend fun insertStaff(staff: Staff) {
        dao.insertStaff(staff)
    }

    override suspend fun deleteStaff(staff: Staff) {
        dao.deleteStaff(staff)
    }
}