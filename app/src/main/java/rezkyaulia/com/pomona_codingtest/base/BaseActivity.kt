package android.rezkyaulia.com.hellokotlin.base

import android.app.Fragment
import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.rezkyaulia.com.hellokotlin.data.DataManager
import rezkyaulia.com.pomona_codingtest.di.activity.ActivityComponent
import rezkyaulia.com.pomona_codingtest.di.activity.ActivityModule
import rezkyaulia.com.pomona_codingtest.di.viewmodel.ViewModelFactory
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import rezkyaulia.com.pomona_codingtest.base.BaseApplication
import rezkyaulia.com.pomona_codingtest.di.activity.DaggerActivityComponent
import javax.inject.Inject

/**
 * Created by Rezky Aulia Pratama on 15/8/18.
 */

abstract class BaseActivity<T : ViewDataBinding, V: ViewModel> :  AppCompatActivity(), AnkoLogger{

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var dataManager: DataManager

    lateinit var viewDataBinding: T
    lateinit var viewModel : V


    /**
     * @return layout resource id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun initViewModel(): V

    abstract fun initBindingVariable() : Int

    abstract fun inject()

    var activityComponent: ActivityComponent?= null

    fun initActivityComponent(): ActivityComponent? {
        if (activityComponent == null)
            activityComponent = DaggerActivityComponent.builder()
                    .applicationComponent(BaseApplication.component)
                    .activityModule(ActivityModule(this))
                    .build()

        return activityComponent
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        inject()

        super.onCreate(savedInstanceState)

        performDataBinding()



    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this,getLayoutId())
        this.viewModel =  initViewModel()

        viewDataBinding.setVariable(initBindingVariable(), viewModel)
        viewDataBinding.executePendingBindings()

    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
    }
}