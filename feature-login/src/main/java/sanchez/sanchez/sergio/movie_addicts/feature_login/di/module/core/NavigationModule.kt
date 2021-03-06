package sanchez.sanchez.sergio.movie_addicts.feature_login.di.module.core

import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerActivity
import sanchez.sanchez.sergio.movie_addicts.feature_login.ui.core.INavigatorManager
import sanchez.sanchez.sergio.movie_addicts.feature_login.ui.core.NavigatorManagerImpl

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
            NavigatorManagerImpl(activity)
}