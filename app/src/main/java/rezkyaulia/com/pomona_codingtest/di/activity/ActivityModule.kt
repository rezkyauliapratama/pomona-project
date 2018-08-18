package rezkyaulia.com.pomona_codingtest.di.activity

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import rezkyaulia.com.pomona_codingtest.di.activity.ActivityContext

/**
 * Created by Rezky Aulia Pratama on 15/8/18.
 */
@Module
class ActivityModule(val activity: Activity){

    @Provides
    @ActivityContext
    fun providesContext(): Context = activity

    @Provides
    fun provideActivity(): Activity = activity
}