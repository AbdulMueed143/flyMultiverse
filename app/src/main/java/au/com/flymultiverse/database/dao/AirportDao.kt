package au.com.flymultiverse.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import au.com.flymultiverse.models.entitymodels.Airport

@Dao
interface AirportDao : BaseDao<Airport> {

    @Query( "SELECT * FROM "+Airport.TABLE_NAME)
    fun getAirports() : LiveData<List<Airport>>

    @Query( "SELECT * FROM "+Airport.TABLE_NAME + " WHERE "+Airport.COL_AIRPORT_CODE + "=:airportCode")
    fun getAirport(airportCode: String) : LiveData<Airport>
}