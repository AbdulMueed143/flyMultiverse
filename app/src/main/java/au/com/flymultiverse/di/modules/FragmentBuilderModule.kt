package au.com.flymultiverse.di.modules

import au.com.flymultiverse.ItemDetailFragment
import au.com.flymultiverse.ItemListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesItemDetailFragment() : ItemDetailFragment

    @ContributesAndroidInjector
    abstract fun contributesItemListFragment() : ItemListFragment

}