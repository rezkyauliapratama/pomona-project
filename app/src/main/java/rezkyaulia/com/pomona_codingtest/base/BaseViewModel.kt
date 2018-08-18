package rezkyaulia.com.pomona_codingtest.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.error

/**
 * Created by Rezky Aulia Pratama on 18/8/18.
 */

abstract class BaseViewModel() : ViewModel(), AnkoLogger {
    var compositeDisposable: CompositeDisposable

    init {
        error {"init"}
        compositeDisposable = CompositeDisposable()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}