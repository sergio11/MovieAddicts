package sanchez.sanchez.sergio.movie_addicts.feature_login.di.module.login

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.movie_addicts.core.auth.IAuthManager
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment
import sanchez.sanchez.sergio.movie_addicts.feature_login.domain.usecase.SignInWithCredentialInteract

/**
 * Login Module
 */
@Module
class LoginModule {

    @Provides
    @PerFragment
    fun provideSignInWithCredentialInteract(authManager: IAuthManager): SignInWithCredentialInteract =
        SignInWithCredentialInteract(authManager)

}