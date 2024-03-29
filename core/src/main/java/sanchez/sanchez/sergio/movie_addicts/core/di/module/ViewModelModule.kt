package sanchez.sanchez.sergio.movie_addicts.core.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import sanchez.sanchez.sergio.movie_addicts.core.di.module.viewmodel.ViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}