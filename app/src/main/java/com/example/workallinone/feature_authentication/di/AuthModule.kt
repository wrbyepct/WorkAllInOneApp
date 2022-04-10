package com.example.workallinone.feature_authentication.di

import android.app.Application
import androidx.room.Room
import com.example.workallinone.WorkApp
import com.example.workallinone.feature_authentication.data.local.data_source.StaffDatabase
import com.example.workallinone.feature_authentication.data.local.repository.StaffRepositoryImpl
import com.example.workallinone.feature_authentication.domain.repository.StaffRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideStaffDatabase(app: Application): StaffDatabase {
        return Room.databaseBuilder(
            app,
            StaffDatabase::class.java,
            StaffDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideStaffRepository(db: StaffDatabase): StaffRepository {
        return StaffRepositoryImpl(db.dao)
    }

}