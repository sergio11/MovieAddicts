package sanchez.sanchez.sergio.feature_main.persistence.db.mapper

import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.persistence.db.model.people.PersonEntity

/**
 * Person Entity Mapper
 */
class PersonEntityMapper {

    fun entityToModel(entity: PersonEntity) = Person(
        id = entity.id,
        name = entity.name,
        popularity = entity.popularity,
        profilePath = entity.profilePath,
        adult = entity.adult
    )

    fun entityToModel(entityList: List<PersonEntity>) = entityList.map {
        entityToModel(it)
    }
}