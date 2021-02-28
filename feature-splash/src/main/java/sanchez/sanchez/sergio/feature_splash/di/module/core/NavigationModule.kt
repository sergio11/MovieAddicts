package sanchez.sanchez.sergio.feature_splash.di.module.core

import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_splash.ui.core.INavigatorManager
import sanchez.sanchez.sergio.feature_splash.ui.core.NavigationManagerImpl
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerActivity

/**
 * Navigation Module
 */
@Module
class NavigationModule {

    /**
     * Provide Navigation Manager
     * @param activity
     */
    @Provides
    @PerActivity
    fun provideNavigationManager(activity: AppCompatActivity): INavigatorManager =
            NavigationManagerImpl(activity)
}