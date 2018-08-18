package rezkyaulia.com.pomona_codingtest.base

import okhttp3.Headers
import javax.inject.Inject

/**
 * Created by Rezky Aulia Pratama on 18/8/18.
 */


open class BaseApi {


    val userHeaderWithParam: Headers
        get() {
            /*if (preferencesManager == null) {
                throw NullPointerException("preferences manager is null")
            }*/
            return Headers.Builder()
                    .add("Content-Type", "application/json")
                    .add("Authorization", "")
//                    .add("UserKey", preferencesManager!!.getUserKey())
                    .build()
        }


    val userHeader: Headers
        get() = Headers.Builder()
                .add("Content-Type", "application/json")
                .build()

}
