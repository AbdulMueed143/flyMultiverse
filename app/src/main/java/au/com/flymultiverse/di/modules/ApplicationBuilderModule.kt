package au.com.flymultiverse.di.modules

import android.app.Application
import au.com.flymultiverse.datasource.remote.AirportRemoteDataSource
import au.com.flymultiverse.network.AirportService
import au.com.flymultiverse.util.Constants
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationBuilderModule {

    @Singleton
    @Provides
    fun provideGlideInstance(application: Application, requestOptions: RequestOptions) : RequestManager {
        return Glide.with(application).setDefaultRequestOptions(requestOptions)
    }

    @Singleton
    @Provides
    fun providesRetrofitInstance(application: Application) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //User Information Service
    @Singleton
    @Provides
    fun providesAirportService(retrofit: Retrofit) : AirportService = retrofit.create(AirportService::class.java)

    @Singleton
    @Provides
    fun providesAirportRemoteDataSource(userInformationService: AirportService) = AirportRemoteDataSource(userInformationService)

}