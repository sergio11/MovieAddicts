package sanchez.sanchez.sergio.feature_person_detail.domain.model

import sanchez.sanchez.sergio.movie_addicts.core.utils.Identificable

data class PersonDetail(
        override val id: Long,
        val name: String,
        val profilePath: String?,
        val adult: Boolean,
        val popularity: Double,
        val birthday: String?,
        val knownForDepartment: String,
        val placeOfBirth: String?,
        val alsoKnownAs: List<String>?,
        val biography: String
): Identificable