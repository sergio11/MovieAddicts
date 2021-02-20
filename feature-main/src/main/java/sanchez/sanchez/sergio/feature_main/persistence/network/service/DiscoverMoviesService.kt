package sanchez.sanchez.sergio.feature_main.persistence.network.service

import retrofit2.http.GET
import retrofit2.http.Query
import sanchez.sanchez.sergio.feature_main.persistence.network.model.movies.DiscoverMoviesDTO

/**
 * Discover Movies Service
 */
interface DiscoverMoviesService {

    /**
     * [Movie Discover](https://developers.themoviedb.org/3/discover/movie-discover)
     *
     *  Discover movies by different types of data like average rating, number of votes, genres and certifications.
     *  You can get a valid list of certifications from the  method.
     *
     *  @param [page] Specify the page of results to query.
     *
     *  @return [DiscoverMoviesDTO] response
     */
    @GET("/3/discover/movie?language=en&sort_by=popularity.desc")
    suspend fun getDiscoverMovies(@Query("page") page: Long): DiscoverMoviesDTO
}