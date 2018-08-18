package rezkyaulia.com.pomona_codingtest.di.application

import android.app.Application
import android.content.Context
import android.rezkyaulia.com.hellokotlin.di.application.ApplicationContext
import dagger.Module
import dagger.Provides

/**
 * Created by Rezky Aulia Pratama on 6/8/18.
 */
@Module
class ApplicationModule(private val application: Application){

    @Provides
    @ApplicationContext
    fun provideContext(): Context {
        return application
    }

    @Provides
    fun provideApplication(): Application{
        return application
    }
}