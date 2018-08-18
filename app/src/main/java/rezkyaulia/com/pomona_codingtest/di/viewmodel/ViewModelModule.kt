package rezkyaulia.com.pomona_codingtest.di.viewmodel

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import rezkyaulia.com.pomona_codingtest.ui.main.MainViewModel
import rezkyaulia.com.pomona_codingtest.ui.login.LoginViewModel

/**
 * Created by Rezky Aulia Pratama on 15/8/18.
 */
@Module
abstract class ViewModelModule{

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel : MainViewModel) : ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(loginViewModel : LoginViewModel) : ViewModel



}