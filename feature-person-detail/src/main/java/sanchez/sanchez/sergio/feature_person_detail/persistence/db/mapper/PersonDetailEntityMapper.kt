package sanchez.sanchez.sergio.feature_person_detail.persistence.db.mapper

import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.model.PersonDetailEntity
import java.util.*

/**
 * Person Detail Entity Mapper
 */
class PersonDetailEntityMapper {

    /**
     * Entity To Model
     * @param entity
     */
    fun entityToModel(entity: PersonDetailEntity) =
        PersonDetail(
            id = entity.id,
            name = entity.name,
            profilePath = entity.profilePath,
            adult = entity.adult,
            popularity = entity.popularity,
            birthday = entity.birthday,
            knownForDepartment = entity.knownForDepartment,
            placeOfBirth = entity.placeOfBirth,
            alsoKnownAs = entity.alsoKnownAs,
            biography = entity.biography
        )

    /**
     * Model To Entity
     * @param model
     */
    fun modelToEntity(model: PersonDetail) =
        PersonDetailEntity(
            id = model.id,
            name = model.name,
            profilePath = model.profilePath,
            adult = model.adult,
            popularity = model.popularity,
            birthday = model.birthday,
            knownForDepartment = model.knownForDepartment,
            placeOfBirth = model.placeOfBirth,
            alsoKnownAs = model.alsoKnownAs,
            biography = model.biography,
            savedAtInMillis = Date().time
        )

}