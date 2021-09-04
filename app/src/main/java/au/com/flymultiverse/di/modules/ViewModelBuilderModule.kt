package au.com.flymultiverse.di.modules

import androidx.lifecycle.ViewModel
import au.com.flymultiverse.di.annotations.ViewModelKey
import au.com.flymultiverse.models.viewmodels.AirportListViewModel
import au.com.flymultiverse.models.viewmodels.AirportViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelBuilderModule {

    @Binds
    @IntoMap
    @ViewModelKey(AirportListViewModel::class)
    abstract fun bindAirportListViewModel(airportListViewModel: AirportListViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AirportViewModel::class)
    abstract fun bindAirportViewModel(airportViewModel: AirportViewModel) : ViewModel

}