package sanchez.sanchez.sergio.feature_main.persistence.network.service

import retrofit2.http.GET
import retrofit2.http.Query
import sanchez.sanchez.sergio.feature_main.persistence.network.model.tv.DiscoverTvDTO

interface DiscoverTvService {

    /**
     * [Tv Discover](https://developers.themoviedb.org/3/discover/tv-discover)
     *
     *  Discover TV shows by different types of data like average rating, number of votes, genres, the network they aired on and air dates.
     *
     *  @param [page] Specify the page of results to query.
     *
     *  @return [DiscoverTvDTO] response
     */
    @GET("/3/discover/tv?language=en&sort_by=popularity.desc")
    suspend fun fetchDiscoverTv(@Query("page") page: Int): DiscoverTvDTO

}