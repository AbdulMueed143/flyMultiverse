package au.com.flymultiverse.models.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import au.com.flymultiverse.database.repositories.AirportRepository
import au.com.flymultiverse.models.entitymodels.Airport
import au.com.flymultiverse.util.Event
import au.com.flymultiverse.util.Resource
import javax.inject.Inject

class AirportListViewModel @Inject constructor(airportRepository: AirportRepository) : ViewModel() {

    val _airports : LiveData<Resource<List<Airport>>> = airportRepository.getAirports()
    var airports : List<Airport>? = null

    private val _openPetDetailPageEvent = MutableLiveData<Event<Airport>>()
    val openPetDetailPageEvent : LiveData<Event<Airport>> = _openPetDetailPageEvent

    private val _selectedAirport = MutableLiveData<Airport>()
    var selectedAirport : LiveData<Airport> = _selectedAirport

    var isLoading = MutableLiveData<Boolean>(false)

    fun onAirportItemClick(airport: Airport) {
        _selectedAirport.postValue(airport)
        _openPetDetailPageEvent.value = Event(airport)
    }

}