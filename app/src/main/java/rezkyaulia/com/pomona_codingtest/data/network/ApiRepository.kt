package android.rezkyaulia.com.hellokotlin.data

import android.util.Log
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error
import java.net.URL
import javax.inject.Inject

class ApiRepository(val url:String) : AnkoLogger{
    init {
        error { url }
    }
}