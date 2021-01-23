package sanchez.sanchez.sergio.test.core.di.component

import android.content.Context
import dagger.Component
import sanchez.sanchez.sergio.test.core.di.module.ApplicationModule
import sanchez.sanchez.sergio.test.core.di.scope.PerApplication
import sanchez.sanchez.sergio.test.core.utils.IApplicationAware

/**
 * A component whose lifetime is the life of the application.
 */
@PerApplication
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    //Exposed to sub-graphs.
    fun context(): Context

    fun applicationAware(): IApplicationAware

}