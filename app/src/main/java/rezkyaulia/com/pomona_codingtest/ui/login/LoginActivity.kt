package rezkyaulia.com.pomona_codingtest.ui.login

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.rezkyaulia.com.hellokotlin.base.BaseActivity
import android.support.v4.app.LoaderManager
import android.support.v4.content.AsyncTaskLoader
import android.support.v4.content.Loader
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.error
import rezkyaulia.com.pomona_codingtest.BR
import rezkyaulia.com.pomona_codingtest.R
import rezkyaulia.com.pomona_codingtest.databinding.ActivityLoginBinding


/**
 * Created by Rezky Aulia Pratama on 18/8/18.
 */
class LoginActivity: BaseActivity<ActivityLoginBinding, LoginViewModel>(){

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initViewModel(): LoginViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)

    }

    override fun initBindingVariable(): Int {
        return BR.viewModel
    }

    override fun inject() {
        initActivityComponent()?.inject(this)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()

    }


    fun initView(){

        button.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()
            viewModel.login(username,password)
        }
    }



}

