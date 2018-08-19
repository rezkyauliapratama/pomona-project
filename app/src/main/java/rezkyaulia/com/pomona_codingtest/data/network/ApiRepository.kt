package android.rezkyaulia.com.hellokotlin.data

import com.rezkyaulia.android.light_optimization_data.NetworkClient
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import rezkyaulia.com.pomona_codingtest.data.network.LoginApi

class ApiRepository(val networkClient: NetworkClient, val url:String) : AnkoLogger{

    lateinit var loginApi: LoginApi

    init {
        error { url }
        loginApi = LoginApi(networkClient,url)
    }


}