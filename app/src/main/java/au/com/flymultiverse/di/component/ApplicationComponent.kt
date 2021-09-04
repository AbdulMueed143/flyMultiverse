package au.com.flymultiverse.di.component

import android.app.Application
import au.com.flymultiverse.BaseApp
import au.com.flymultiverse.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationBuilderModule::class,
        ViewModelFactoryModule::class,
        ViewModelBuilderModule::class,
        ActivityBuilderModule::class, //All the activities
        RoomBuilderModule::class, //Database
        FragmentBuilderModule::class //Fragments
    ]
)
interface ApplicationComponent : AndroidInjector<BaseApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : ApplicationComponent
    }
}