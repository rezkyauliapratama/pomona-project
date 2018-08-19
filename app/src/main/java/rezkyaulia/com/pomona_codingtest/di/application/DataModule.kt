package rezkyaulia.com.pomona_codingtest.di.application

import android.content.Context
import android.rezkyaulia.com.hellokotlin.di.application.ApplicationContext
import com.securepreferences.SecurePreferences
import dagger.Module
import dagger.Provides

/**
 * Created by Rezky Aulia Pratama on 19/8/18.
 */
@Module
class DataModule{


    @Provides
    internal fun providePreferenceManager(@ApplicationContext context: Context): SecurePreferences {
        return SecurePreferences(context)
    }
}