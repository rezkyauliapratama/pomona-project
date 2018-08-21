package rezkyaulia.com.pomona_codingtest.di.application

import android.content.Context
import android.rezkyaulia.com.hellokotlin.data.ApiRepository
import android.rezkyaulia.com.hellokotlin.di.application.ApplicationContext
import com.google.gson.Gson
import com.rezkyaulia.android.light_optimization_data.NetworkClient
import dagger.Module
import dagger.Provides
import rezkyaulia.com.pomona_codingtest.BuildConfig
import javax.inject.Singleton

/**
 * Created by Rezky Aulia Pratama on 6/8/18.
 */
@Module
class NetworkModule{

    @Singleton
    @Provides
    internal fun provideHttpClient(@ApplicationContext context: Context): NetworkClient {
        return NetworkClient(context)
    }

    @Provides
    @NetworkInfo
    internal fun provideBaseUrl(): String {
        return BuildConfig.BASE_URL
    }
    @Provides
    fun providesNetwork(@NetworkInfo url : String, networkClient: NetworkClient) : ApiRepository{
        return ApiRepository(networkClient,url)
    }

}