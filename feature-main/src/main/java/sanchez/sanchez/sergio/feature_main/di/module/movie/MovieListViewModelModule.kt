package sanchez.sanchez.sergio.feature_main.di.module.movie

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sanchez.sanchez.sergio.feature_main.ui.movie.MovieListViewModel
import sanchez.sanchez.sergio.test.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.test.core.di.module.viewmodel.ViewModelKey
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

@Module(includes = [ ViewModelModule::class ])
abstract class MovieListViewModelModule {

    @PerFragment
    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindsMovieListViewModel(movieListViewModel: MovieListViewModel): ViewModel
}