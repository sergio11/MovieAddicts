package sanchez.sanchez.sergio.feature_person_detail.persistence.network.service

import retrofit2.http.GET
import retrofit2.http.Path
import sanchez.sanchez.sergio.feature_person_detail.persistence.network.model.PersonDetailDTO

/**
 * People Service
 */
interface PeopleService {

    /**
     * [Person Detail](https://developers.themoviedb.org/3/people/get-person-details)
     *
     * Get the primary person details by id.
     *
     * @para [id] Specify the id of results to query.
     *
     * @return [PersonDetailDTO] response
     */
    @GET("/3/person/{person_id}")
    suspend fun getPersonDetail(@Path("person_id") id: Int): PersonDetailDTO
}