package sanchez.sanchez.sergio.movie_addicts.feature_login.di.component

import dagger.Subcomponent
import sanchez.sanchez.sergio.movie_addicts.core.di.component.FragmentComponent
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment
import sanchez.sanchez.sergio.movie_addicts.feature_login.di.module.LoginViewModelModule
import sanchez.sanchez.sergio.movie_addicts.feature_login.ui.login.LoginFragment

/**
 * Login Component
 */
@PerFragment
@Subcomponent(modules = [ LoginViewModelModule::class ])
interface LoginComponent: FragmentComponent {

    /**
     * Inject into
     * @param loginFragment
     */
    fun inject(loginFragment: LoginFragment)
}