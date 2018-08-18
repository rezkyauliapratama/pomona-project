package android.rezkyaulia.com.hellokotlin.data

import android.util.Log
import com.rezkyaulia.android.light_optimization_data.NetworkClient
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import rezkyaulia.com.pomona_codingtest.data.network.LoginApi
import java.net.URL
import javax.inject.Inject

class ApiRepository(val networkClient: NetworkClient, val url:String) : AnkoLogger{

    lateinit var loginApi: LoginApi

    init {
        error { url }
        loginApi = LoginApi(networkClient,url)
    }


}