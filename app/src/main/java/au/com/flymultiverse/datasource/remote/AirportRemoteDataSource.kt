package au.com.flymultiverse.datasource.remote

import au.com.flymultiverse.datasource.BaseDataSource
import au.com.flymultiverse.network.AirportService

class AirportRemoteDataSource(private val airportService : AirportService) : BaseDataSource {

    suspend fun getAirports() = getResult {
        airportService.getAirports()
    }
}