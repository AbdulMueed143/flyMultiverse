package au.com.flymultiverse.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import au.com.flymultiverse.database.dao.AirportDao
import au.com.flymultiverse.models.entitymodels.*
import au.com.flymultiverse.util.Constants

@Database(entities = [Airport::class], version = Constants.DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun airportDao() : AirportDao

    companion object {

        private var instance : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {

            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, Constants.DATABASE_NAME)
                        .fallbackToDestructiveMigration().build()
                }
            }

            return instance!!
        }
    }
}