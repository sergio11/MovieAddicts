package sanchez.sanchez.sergio.feature_movie_detail.di.module.movie

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sanchez.sanchez.sergio.feature_movie_detail.ui.movie.MovieDetailViewModel
import sanchez.sanchez.sergio.test.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.test.core.di.module.viewmodel.ViewModelKey

/**
 * Movie Detail View Model Module
 */
@Module(includes = [ ViewModelModule::class ])
abstract class MovieDetailViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun bindsMovieDetailViewModel(viewModel: MovieDetailViewModel): ViewModel
}