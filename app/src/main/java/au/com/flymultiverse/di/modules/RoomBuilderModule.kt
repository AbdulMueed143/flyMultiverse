package au.com.flymultiverse.di.modules

import android.app.Application
import au.com.flymultiverse.database.AppDatabase
import au.com.flymultiverse.database.dao.AirportDao
import au.com.flymultiverse.database.repositories.AirportRepository
import au.com.flymultiverse.datasource.remote.AirportRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomBuilderModule {

    @Singleton
    @Provides
    fun providesAppDatabase(application: Application) : AppDatabase {
        return AppDatabase.getInstance(application.applicationContext)
    }

    @Singleton
    @Provides
    fun providesAirportDao(appDatabase: AppDatabase) : AirportDao {
        return appDatabase.airportDao()
    }

    @Singleton
    @Provides
    fun providesUserRepository(userDao: AirportDao, userRemoteDataSource: AirportRemoteDataSource) : AirportRepository {
        return AirportRepository(userRemoteDataSource, userDao)
    }

}