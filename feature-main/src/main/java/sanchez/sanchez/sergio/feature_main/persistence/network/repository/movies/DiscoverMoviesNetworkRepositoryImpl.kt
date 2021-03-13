package sanchez.sanchez.sergio.feature_main.persistence.network.repository.movies

import android.util.Log
import androidx.annotation.WorkerThread
import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.PageData
import sanchez.sanchez.sergio.feature_main.persistence.network.mapper.MovieNetworkMapper
import sanchez.sanchez.sergio.feature_main.persistence.network.service.DiscoverMoviesService
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.exception.NetworkNoResultException
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.repository.SupportNetworkRepository
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.service.IMovieFavoriteService

/**
 * Discover Movies Repository
 * @param moviesNetworkMapper
 * @param discoverMoviesService
 * @param movieFavoriteService
 */
class DiscoverMoviesNetworkRepositoryImpl(
        private val moviesNetworkMapper: MovieNetworkMapper,
        private val discoverMoviesService: DiscoverMoviesService,
        private val movieFavoriteService: IMovieFavoriteService
): SupportNetworkRepository(), IDiscoverMoviesNetworkRepository {

    /**
     * Get Discover Movies
     * @param page
     */
    @WorkerThread
    override suspend fun getDiscoverMovies(page: Long): PageData<Movie> = safeNetworkCall {
        val result = discoverMoviesService.getDiscoverMovies(page)
        if(result.results.isEmpty())
            throw NetworkNoResultException("Not Movies found")

        val favoriteMovieList = movieFavoriteService.getFavoriteMovieIds()

        val data = moviesNetworkMapper.dtoToModel(result.results)

        data.forEach {
            it.isFavorite = favoriteMovieList.contains(it.id)
        }
        PageData(
                page = result.page,
                data = data,
                isLast = result.page == result.totalPages
        )
    }
}