package sanchez.sanchez.sergio.test.core.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.test.core.SupportApp
import sanchez.sanchez.sergio.test.core.di.scope.PerApplication
import sanchez.sanchez.sergio.test.core.utils.IApplicationAware

/**
 * Application Module
 */
@Module
class ApplicationModule constructor(private val application: SupportApp) {

    /**
     * Provide Application Context
     * @return
     */
    @Provides
    @PerApplication
    fun provideApplicationContext(): Context = application

    /**
     * Provide Application Aware
     */
    @Provides
    @PerApplication
    fun provideApplicationAware(): IApplicationAware = application
}