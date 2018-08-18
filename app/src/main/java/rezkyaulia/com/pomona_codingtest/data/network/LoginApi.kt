package rezkyaulia.com.pomona_codingtest.data.network

import com.google.gson.Gson
import com.rezkyaulia.android.light_optimization_data.NetworkClient
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import rezkyaulia.com.pomona_codingtest.data.model.LoginRequest
import rezkyaulia.com.pomona_codingtest.data.model.LoginResponse
import rezkyaulia.com.pomona_codingtest.di.application.NetworkInfo
import javax.inject.Inject
import io.reactivex.Single
import rezkyaulia.com.pomona_codingtest.base.BaseApi


@Suppress("UNCHECKED_CAST")
/**
 * Created by Rezky Aulia Pratama on 18/8/18.
 */
class LoginApi (val networkClient: NetworkClient, val url : String) : BaseApi(),AnkoLogger{
    fun loginSingle(loginRequest: LoginRequest): Single<LoginResponse> {
        return Single.create<LoginResponse> { emitter ->
            try {
                val response = postLoginSync(loginRequest)
                error { Gson().toJson(response) }
                response?.let { emitter.onSuccess(it) }

            } catch (e: Exception) {
                emitter.onError(e)
            }


        }
    }
    fun postLoginSync(loginRequest: LoginRequest) : LoginResponse?
    {

        if (networkClient == null) {
            throw NullPointerException("Network client == null")
        }
        try {
            error{"loginReq : " + Gson().toJson(loginRequest)}
            return networkClient.withUrl(url + "/sign-in")
                    .init(LoginResponse::class.java)
                    .setJsonPojoBody(loginRequest)
                    .getSyncFuture()
        } catch (e: Exception) {
            error{ "getUser Error "}
        }


        return null
    }

}