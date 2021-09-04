package au.com.flymultiverse.database.repositories

import android.util.Log
import au.com.flymultiverse.database.dao.AirportDao
import au.com.flymultiverse.datasource.remote.AirportRemoteDataSource
import au.com.flymultiverse.util.performGetOperation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AirportRepository @Inject constructor(
    private val remoteDataSource: AirportRemoteDataSource,
    private val localDataSource: AirportDao
) {

    fun getAirports() = performGetOperation(
        databaseQuery = {
            localDataSource.getAirports()
        },
        networkCall = {
             remoteDataSource.getAirports()
        },
        saveCallResult = {
            localDataSource.insertAll(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {
                    Log.e("Qeury Error", "Error MEssage")
                })
        }
    )
}