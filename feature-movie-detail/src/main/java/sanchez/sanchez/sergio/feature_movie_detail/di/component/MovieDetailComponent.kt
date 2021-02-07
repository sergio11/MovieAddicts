package sanchez.sanchez.sergio.feature_movie_detail.di.component

import dagger.Subcomponent
import sanchez.sanchez.sergio.feature_movie_detail.di.module.movie.MovieDetailModule
import sanchez.sanchez.sergio.feature_movie_detail.di.module.movie.MovieDetailViewModelModule
import sanchez.sanchez.sergio.feature_movie_detail.ui.movie.MovieDetailFragment
import sanchez.sanchez.sergio.test.core.di.component.FragmentComponent
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Movie Detail Component
 */
@PerFragment
@Subcomponent(modules = [ MovieDetailViewModelModule::class, MovieDetailModule::class ])
interface MovieDetailComponent: FragmentComponent {

    /**
     * inject into
     * @param movieDetailFragment
     */
    fun inject(movieDetailFragment: MovieDetailFragment)
}