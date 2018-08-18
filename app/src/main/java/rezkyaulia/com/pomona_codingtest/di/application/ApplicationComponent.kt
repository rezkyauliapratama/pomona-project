package rezkyaulia.com.pomona_codingtest.di.application

import android.rezkyaulia.com.hellokotlin.data.DataManager
import dagger.Component
import rezkyaulia.com.pomona_codingtest.base.BaseApplication
import javax.inject.Singleton

/**
 * Created by Rezky Aulia Pratama on 6/8/18.
 */
@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent{

    fun inject(app : BaseApplication)

    fun getDataManager(): DataManager
}