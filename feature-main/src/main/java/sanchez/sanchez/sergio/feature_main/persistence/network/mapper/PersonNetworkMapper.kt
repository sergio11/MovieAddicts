package sanchez.sanchez.sergio.feature_main.persistence.network.mapper

import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.persistence.network.model.people.PersonDTO

class PersonNetworkMapper {

    /**
     * Dto To Model
     * @param dto
     */
    fun dtoToModel(dto: PersonDTO): Person = Person(
        id = dto.id,
        name = dto.name,
        popularity = dto.popularity,
        profilePath = dto.profilePath,
        adult = dto.adult
    )

    /**
     * dto To Model
     * @param dtoList
     */
    fun dtoToModel(dtoList: List<PersonDTO>): List<Person> =
            dtoList.map {
                dtoToModel(it)
            }

}