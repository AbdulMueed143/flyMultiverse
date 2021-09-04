package au.com.flymultiverse.network

import au.com.flymultiverse.models.entitymodels.Airport
import retrofit2.Response
import retrofit2.http.GET

interface AirportService {

    @GET("/flight/refData/airport")
    suspend fun getAirports() : Response<List<Airport>>

}