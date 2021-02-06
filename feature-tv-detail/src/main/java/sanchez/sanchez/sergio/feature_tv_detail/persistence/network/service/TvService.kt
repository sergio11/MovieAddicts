package sanchez.sanchez.sergio.feature_tv_detail.persistence.network.service

import retrofit2.http.GET
import retrofit2.http.Path
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.model.TvDetailDTO
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.model.TvKeywordsDTO
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.model.TvReviewsDTO
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.model.TvVideosDTO

interface TvService {

    /**
     * Get Tv Detail
     * @param id
     *
     * @return [TvDetailDTO] response
     */
    @GET("/3/tv/{tv_id}")
    suspend fun getTvDetail(@Path("tv_id") id: Int): TvDetailDTO

    /**
     * [Tv Videos](https://developers.themoviedb.org/3/tv/get-tv-keywords)
     *
     * Get the keywords that have been added to a TV show.
     *
     * @param [id] Specify the id of tv keywords.
     *
     * @return [TvKeywordsDTO] response
     */
    @GET("/3/tv/{tv_id}/keywords")
    suspend fun getTvKeywords(@Path("tv_id") id: Int): TvKeywordsDTO

    /**
     * [Tv Videos](https://developers.themoviedb.org/3/tv/get-tv-videos)
     *
     * Get the videos that have been added to a TV show.
     *
     * @param [id] Specify the id of tv id.
     *
     * @return [TvVideosDTO] response
     */
    @GET("/3/tv/{tv_id}/videos")
    suspend fun getTvVideos(@Path("tv_id") id: Int): TvVideosDTO

    /**
     * [Tv Reviews](https://developers.themoviedb.org/3/tv/get-tv-reviews)
     *
     * Get the reviews for a TV show.
     *
     * @param [id] Specify the id of tv id.
     *
     * @return [TvReviewsDTO] response
     */
    @GET("/3/tv/{tv_id}/reviews")
    suspend fun getTvReviews(@Path("tv_id") id: Int): TvReviewsDTO
}