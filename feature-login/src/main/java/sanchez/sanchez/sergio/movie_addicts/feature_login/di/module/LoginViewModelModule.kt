package sanchez.sanchez.sergio.movie_addicts.feature_login.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.movie_addicts.core.di.module.viewmodel.ViewModelKey
import sanchez.sanchez.sergio.movie_addicts.feature_login.ui.login.LoginViewModel

/**
 * Login View Model Module
 */
@Module(includes = [ ViewModelModule::class ])
abstract class LoginViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindsLoginViewModel(viewModel: LoginViewModel): ViewModel
}