package rezkyaulia.com.pomona_codingtest.di.activity

import rezkyaulia.com.pomona_codingtest.di.application.ApplicationComponent
import dagger.Component
import rezkyaulia.com.pomona_codingtest.ui.MainActivity

/**
 * Created by Rezky Aulia Pratama on 15/8/18.
 */
@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent{

    fun inject(activity: MainActivity)
}