package sanchez.sanchez.sergio.test.core.di.factory

import sanchez.sanchez.sergio.test.core.SupportApp
import sanchez.sanchez.sergio.test.core.di.component.ApplicationComponent
import sanchez.sanchez.sergio.test.core.di.component.DaggerApplicationComponent
import sanchez.sanchez.sergio.test.core.di.module.ApplicationModule

object AppComponentFactory {

    private var appComponent: ApplicationComponent? = null

    /**
     * Get App Component
     * @param app
     */
    fun getAppComponent(app: SupportApp): ApplicationComponent =
        appComponent ?: DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(app))
            .build().also {
                appComponent = it
            }

}