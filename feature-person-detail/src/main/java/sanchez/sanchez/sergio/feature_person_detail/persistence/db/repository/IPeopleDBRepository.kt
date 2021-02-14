package sanchez.sanchez.sergio.feature_person_detail.persistence.db.repository

import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail

/**
 * People DB Repository
 */
interface IPeopleDBRepository {

    /**
     * Get Person Detail By Id
     * @param id
     */
    suspend fun getById(id: Long): PersonDetail

    /**
     * Save Person Detail
     * @param personDetail
     */
    suspend fun save(personDetail: PersonDetail)

}