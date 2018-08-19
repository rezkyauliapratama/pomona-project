package rezkyaulia.com.pomona_codingtest.di.application

import android.rezkyaulia.com.hellokotlin.data.DataManager
import dagger.Component
import rezkyaulia.com.pomona_codingtest.base.BaseApplication
import rezkyaulia.com.pomona_codingtest.di.viewmodel.ViewModelFactory
import rezkyaulia.com.pomona_codingtest.di.viewmodel.ViewModelModule
import javax.inject.Singleton

/**
 * Created by Rezky Aulia Pratama on 6/8/18.
 */
@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class, ViewModelModule::class, DataModule::class])
interface ApplicationComponent{

    fun inject(app : BaseApplication)

    fun getViewModelFactory() : ViewModelFactory
    fun getDataManager(): DataManager
}