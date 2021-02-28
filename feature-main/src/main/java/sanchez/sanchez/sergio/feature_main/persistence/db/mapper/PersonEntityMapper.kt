package sanchez.sanchez.sergio.feature_main.persistence.db.mapper

import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.persistence.db.model.people.PersonEntity
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.mapper.IEntityToModelMapper
import java.util.*

/**
 * Person Entity Mapper
 */
class PersonEntityMapper: IEntityToModelMapper<PersonEntity, Person> {

    override fun entityToModel(entity: PersonEntity) = Person(
        id = entity.id,
        name = entity.name,
        popularity = entity.popularity,
        profilePath = entity.profilePath,
        adult = entity.adult
    )

    override fun entityToModel(entityList: List<PersonEntity>) = entityList.map {
        entityToModel(it)
    }

    override fun modelToEntity(model: Person) = PersonEntity(
            id = model.id,
            name = model.name,
            popularity = model.popularity,
            profilePath = model.profilePath,
            adult = model.adult,
            savedAtInMillis = Date().time
    )

    override fun modelToEntity(modelList: List<Person>) = modelList.map {
        modelToEntity(it)
    }
}