package au.com.flymultiverse.models.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import au.com.flymultiverse.database.repositories.AirportRepository
import au.com.flymultiverse.models.entitymodels.Airport
import au.com.flymultiverse.util.Resource
import javax.inject.Inject

class AirportListViewModel @Inject constructor(airportRepository: AirportRepository) : ViewModel() {

    val _airports : LiveData<Resource<List<Airport>>> = airportRepository.getAirports()
    var airpots : List<Airport>? = null

}