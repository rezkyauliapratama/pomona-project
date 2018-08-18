package rezkyaulia.com.pomona_codingtest.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.rezkyaulia.com.hellokotlin.base.BaseActivity
import rezkyaulia.com.pomona_codingtest.BR
import rezkyaulia.com.pomona_codingtest.R
import rezkyaulia.com.pomona_codingtest.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViewModel(): MainViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun initBindingVariable(): Int {
        return BR.viewModel
    }

    override fun inject() {
        initActivityComponent()?.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
