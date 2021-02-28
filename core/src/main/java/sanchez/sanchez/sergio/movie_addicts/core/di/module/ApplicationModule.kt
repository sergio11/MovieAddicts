package sanchez.sanchez.sergio.movie_addicts.core.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.movie_addicts.core.SupportApp
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerApplication
import sanchez.sanchez.sergio.movie_addicts.core.utils.IApplicationAware

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