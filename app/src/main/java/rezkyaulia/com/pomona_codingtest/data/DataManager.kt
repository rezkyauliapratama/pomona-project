package android.rezkyaulia.com.hellokotlin.data

import android.preference.PreferenceManager
import android.util.Log
import rezkyaulia.com.pomona_codingtest.data.PreferencesManager
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Rezky Aulia Pratama on 6/8/18.
 */
@Singleton
class DataManager @Inject constructor(private val apiRepository: ApiRepository){

    @Inject
    lateinit var preferencesManager: PreferencesManager
    fun getRepo(): ApiRepository{
        return apiRepository
    }

    fun getPref() : PreferencesManager {
        return preferencesManager;
    }


}
