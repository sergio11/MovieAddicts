package sanchez.sanchez.sergio.movie_addicts.core.persistence.network.service

/**
 * Movie Favorite Service
 */
interface IMovieFavoriteService {

    suspend fun getFavoriteMovieIds(): List<Long>

    suspend fun addMovieToFavorite(movieId: Long)

    suspend fun deleteMovieFromFavorite(movieId: Long)

}