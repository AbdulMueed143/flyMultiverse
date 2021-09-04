package au.com.flymultiverse.di.modules

import au.com.flymultiverse.ItemDetailHostActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesItemDetailHostActivity() : ItemDetailHostActivity

}