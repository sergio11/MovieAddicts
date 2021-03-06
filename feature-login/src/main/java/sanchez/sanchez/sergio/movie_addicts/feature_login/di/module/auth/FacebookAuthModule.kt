package sanchez.sanchez.sergio.movie_addicts.feature_login.di.module.auth

import com.facebook.CallbackManager
import com.facebook.login.LoginManager
import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerActivity

/**
 * Facebook Auth Module
 */
@Module
class FacebookAuthModule {

    /**
     * Provide Callback Manager
     */
    @Provides
    @PerActivity
    fun provideCallbackManager(): CallbackManager =
        CallbackManager.Factory.create()

    /**
     * Provide Login Manager
     */
    @Provides
    @PerActivity
    fun provideLoginManager(): LoginManager =
        LoginManager.getInstance()

}