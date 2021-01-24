package sanchez.sanchez.sergio.feature_main.ui.movie

import sanchez.sanchez.sergio.test.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Movie List View Model
 */
class MovieListViewModel @Inject constructor(): SupportViewModel<MovieListContract.Event, MovieListContract.State, MovieListContract.Effect>() {

    override fun createInitialState(): MovieListContract.State =
        MovieListContract.State(
            MovieListContract.RandomNumberState.Idle
        )

    override fun handleEvent(event: MovieListContract.Event) {

    }
}