package au.com.flymultiverse.models.viewmodels

import androidx.lifecycle.ViewModel
import au.com.flymultiverse.database.repositories.AirportRepository
import javax.inject.Inject

class AirportViewModel @Inject constructor(airportRepository: AirportRepository) : ViewModel() {

}