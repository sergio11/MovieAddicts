package sanchez.sanchez.sergio.feature_person_detail.persistence.network.mapper

import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.feature_person_detail.persistence.network.model.PersonDetailDTO

/**
 * Person Detail Network Mapper
 */
class PersonDetailNetworkMapper {

    fun dtoToModel(dto: PersonDetailDTO) = PersonDetail(
            id = dto.id,
            name = dto.name,
            profilePath = dto.profilePath,
            adult = dto.adult,
            popularity = dto.popularity,
            birthday = dto.birthday,
            knownForDepartment = dto.knownForDepartment,
            placeOfBirth = dto.placeOfBirth,
            alsoKnownAs = dto.alsoKnownAs,
            biography = dto.biography
    )

}