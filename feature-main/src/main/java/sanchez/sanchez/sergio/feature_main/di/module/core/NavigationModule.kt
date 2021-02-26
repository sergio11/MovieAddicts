package sanchez.sanchez.sergio.feature_main.di.module.core

import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.feature_main.ui.core.INavigatorManager
import sanchez.sanchez.sergio.feature_main.ui.core.NavigatorManagerImpl
import sanchez.sanchez.sergio.test.core.di.scope.PerActivity

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