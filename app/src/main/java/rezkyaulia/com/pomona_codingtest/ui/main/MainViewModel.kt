package rezkyaulia.com.pomona_codingtest.ui.main

import android.rezkyaulia.com.hellokotlin.data.DataManager
import org.jetbrains.anko.error
import rezkyaulia.com.pomona_codingtest.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Rezky Aulia Pratama on 18/8/18.
 */
class MainViewModel @Inject constructor(val dataManager: DataManager) : BaseViewModel(){

    init {
        error { "mainviewmodel" }
        error { dataManager.getRepo().url }
    }
}