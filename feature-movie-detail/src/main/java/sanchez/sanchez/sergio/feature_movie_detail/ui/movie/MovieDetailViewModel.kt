package sanchez.sanchez.sergio.feature_movie_detail.ui.movie

import sanchez.sanchez.sergio.test.core.ui.SupportViewModel
import javax.inject.Inject

/**
 * Movie Detail View Model
 */
class MovieDetailViewModel @Inject constructor()
    : SupportViewModel<MovieDetailContract.Event, MovieDetailContract.State, MovieDetailContract.Effect>(){

    override fun createInitialState(): MovieDetailContract.State =
            MovieDetailContract.State(
                    MovieDetailContract.MovieState.OnIdle
            )

    override fun handleEvent(event: MovieDetailContract.Event) {

    }
}