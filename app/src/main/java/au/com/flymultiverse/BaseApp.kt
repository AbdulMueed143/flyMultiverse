package au.com.flymultiverse

import android.content.Context
import androidx.multidex.MultiDex
import au.com.flymultiverse.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class BaseApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        //Changing to dagger appplication
        return DaggerApplicationComponent.builder().application(this).build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        //Here we also initialize google places sdk or facebook sdk or others sometimes
    }
}
