package rezkyaulia.com.pomona_codingtest.di.application

import android.rezkyaulia.com.hellokotlin.data.ApiRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import rezkyaulia.com.pomona_codingtest.BuildConfig

/**
 * Created by Rezky Aulia Pratama on 6/8/18.
 */
@Module
class NetworkModule{


    @Provides
    @NetworkInfo
    internal fun provideBaseUrl(): String {
        //        return "http://156.67.221.206/dont-do-framework/public/v1/";
        return BuildConfig.BASE_URL
    }
    @Provides
    fun providesNetwork(@NetworkInfo url : String) : ApiRepository{
        return ApiRepository(url)
    }

}