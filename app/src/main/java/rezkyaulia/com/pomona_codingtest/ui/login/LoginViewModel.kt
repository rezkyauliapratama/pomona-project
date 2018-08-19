package rezkyaulia.com.pomona_codingtest.ui.login

import android.arch.lifecycle.MutableLiveData
import android.rezkyaulia.com.hellokotlin.data.DataManager
import android.text.Editable
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.error
import rezkyaulia.com.pomona_codingtest.base.BaseViewModel
import rezkyaulia.com.pomona_codingtest.data.model.LoginRequest
import rezkyaulia.com.pomona_codingtest.data.model.LoginResponse
import rezkyaulia.com.pomona_codingtest.data.network.NetworkStatus
import rezkyaulia.com.pomona_codingtest.ui.UiStatus
import javax.inject.Inject



/**
 * Created by Rezky Aulia Pratama on 18/8/18.
 */
class LoginViewModel @Inject constructor(val dataManager: DataManager): BaseViewModel(){

    var netWorkStatusLD : MutableLiveData<NetworkStatus> = MutableLiveData()
    var viewStatuLD : MutableLiveData<UiStatus> = MutableLiveData()

    init {
        viewStatuLD.value = UiStatus.HIDE_LOADER
        val token = dataManager.preferencesManager.token
        if (token.isNotEmpty()){
            netWorkStatusLD.value = NetworkStatus.SUCCESS
        }
    }

    fun login(username: String, password: String) {

        if (username.isNotEmpty() && password.isNotEmpty()){
            error("username $username and password $password")
            val loginRequest = LoginRequest(
                    username,
                    password)
            doingLogin(loginRequest)
        }
    }


    fun doingLogin(loginRequest: LoginRequest){
        viewStatuLD.value = UiStatus.SHOW_LOADER
        compositeDisposable.add(dataManager.getRepo().loginApi
                .loginSingle(loginRequest).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    if (response != null){
                        dataManager.getPref().token = response.jwt_token
                        netWorkStatusLD.value = NetworkStatus.SUCCESS
                        viewStatuLD.value = UiStatus.HIDE_LOADER

                    }

                }, { throwable ->
                    error { "error : "+Gson().toJson(throwable) }
                    netWorkStatusLD.value = NetworkStatus.NOT_SUCCESS
                    viewStatuLD.value = UiStatus.HIDE_LOADER


                }))


    }

}