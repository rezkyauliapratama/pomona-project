package rezkyaulia.com.pomona_codingtest.ui.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.rezkyaulia.com.hellokotlin.base.BaseActivity
import android.support.v4.app.LoaderManager
import android.support.v4.content.AsyncTaskLoader
import android.support.v4.content.Loader
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.error
import org.jetbrains.anko.toast
import rezkyaulia.com.pomona_codingtest.BR
import rezkyaulia.com.pomona_codingtest.R
import rezkyaulia.com.pomona_codingtest.data.network.NetworkStatus
import rezkyaulia.com.pomona_codingtest.databinding.ActivityLoginBinding
import rezkyaulia.com.pomona_codingtest.ui.UiStatus
import rezkyaulia.com.pomona_codingtest.ui.main.MainActivity


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
        initObserver()
    }

    private fun initObserver() {
        viewModel.viewStatuLD.observe(this, Observer {
            if (it == UiStatus.SHOW_LOADER){
                layout_progress.visibility = View.VISIBLE
            }else if (it == UiStatus.HIDE_LOADER){
                layout_progress.visibility = View.GONE
            }
        })

        viewModel.netWorkStatusLD.observe(this, Observer {
            if (it == NetworkStatus.SUCCESS){
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }else if(it == NetworkStatus.NOT_SUCCESS){
                toast("TIDAK SUKSES")
            }
        })
    }


    fun initView(){

        button.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()
            viewModel.login(username,password)
        }
    }



}

