package sanchez.sanchez.sergio.movie_addicts.core.di.module.auth

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.movie_addicts.core.auth.AuthManagerImpl
import sanchez.sanchez.sergio.movie_addicts.core.auth.IAuthManager
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerApplication

@Module
class AuthModule {

    /**
     * Provide Firebase Auth
     */
    @Provides
    @PerApplication
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    /**
     * Provide Auth Manager
     * @param firebaseAuth
     */
    @Provides
    @PerApplication
    fun provideAuthManager(firebaseAuth: FirebaseAuth): IAuthManager =
        AuthManagerImpl(firebaseAuth)

}