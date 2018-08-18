package rezkyaulia.com.pomona_codingtest.base

import android.app.Application
import rezkyaulia.com.pomona_codingtest.di.application.ApplicationComponent
import rezkyaulia.com.pomona_codingtest.di.application.ApplicationModule
import rezkyaulia.com.pomona_codingtest.di.application.NetworkModule
import rezkyaulia.com.pomona_codingtest.di.application.DaggerApplicationComponent

/**
 * Created by Rezky Aulia Pratama on 18/8/18.
 */
class BaseApplication : Application(){

    companion object {
        lateinit var component : ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = initDagger(this)
        component.inject(this)

    }

    private fun initDagger(app: BaseApplication): ApplicationComponent =
            DaggerApplicationComponent.builder()
                    .applicationModule(ApplicationModule(app))
                    .networkModule(NetworkModule())
                    .build()



}