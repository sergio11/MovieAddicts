package sanchez.sanchez.sergio.feature_movie_detail.persistence.network.service

import retrofit2.http.GET
import retrofit2.http.Path
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.model.MovieDetailDTO
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.model.MovieKeywordsDTO
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.model.MovieReviewsDTO
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.model.MovieVideosDTO

/**
 * Movies Service
 */
interface MoviesService {

    /**
     * Get Movie Details
     * @param id
     */
    @GET("/3/movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") id: Int): MovieDetailDTO

    /**
     * [Movie Keywords](https://developers.themoviedb.org/3/movies/get-movie-keywords)
     *
     * Get the keywords that have been added to a movie.
     *
     * @param [id] Specify the id of movie id.
     *
     * @return [MovieKeywordsDTO] response
     */
    @GET("/3/movie/{movie_id}/keywords")
    suspend fun getMovieKeywords(@Path("movie_id") id: Int): MovieKeywordsDTO

    /**
     * [Movie Videos](https://developers.themoviedb.org/3/movies/get-movie-videos)
     *
     * Get the videos that have been added to a movie.
     *
     * @param [id] Specify the id of movie id.
     *
     * @return [MovieVideosDTO] response
     */
    @GET("/3/movie/{movie_id}/videos")
    suspend fun getMovieVideos(@Path("movie_id") id: Int): MovieVideosDTO

    /**
     * [Movie Reviews](https://developers.themoviedb.org/3/movies/get-movie-reviews)
     *
     * Get the user reviews for a movie.
     *
     * @param [id] Specify the id of movie id.
     *
     * @return [MovieReviewsDTO] response
     */
    @GET("/3/movie/{movie_id}/reviews")
    suspend fun getMovieReviews(@Path("movie_id") id: Int): MovieReviewsDTO

}