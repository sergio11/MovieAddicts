package sanchez.sanchez.sergio.feature_main.persistence.network.service

import retrofit2.http.GET
import retrofit2.http.Query
import sanchez.sanchez.sergio.feature_main.persistence.network.model.people.PopularPeopleDTO

interface PeopleService {

    /**
     * [People Popular](https://developers.themoviedb.org/3/people/get-popular-people)
     *
     * Get the list of popular people on TMDb. This list updates daily.
     *
     * @param [page] Specify the page of results to query.
     *
     * @return [PeopleResponse] response
     */
    @GET("/3/person/popular?language=en")
    suspend fun fetchPopularPeople(@Query("page") page: Int): PopularPeopleDTO
}