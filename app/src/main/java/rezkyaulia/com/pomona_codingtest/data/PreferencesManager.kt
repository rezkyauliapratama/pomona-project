package rezkyaulia.com.pomona_codingtest.data

import com.securepreferences.SecurePreferences
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Rezky Aulia Pratama on 19/8/18.
 */
@Singleton
class PreferencesManager @Inject
constructor(private val mSecurePreferences: SecurePreferences) {

    private val TOKEN = "TOKEN"

    var token: String
        get() = mSecurePreferences.getString(TOKEN,"")
        set(jwtToken) {
            val editor = mSecurePreferences.edit()
            editor.putString(TOKEN, jwtToken)
            editor.apply()
        }

}
