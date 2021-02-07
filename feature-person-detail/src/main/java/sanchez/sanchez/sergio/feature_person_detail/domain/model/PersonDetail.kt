package sanchez.sanchez.sergio.feature_person_detail.domain.model

data class PersonDetail(
        val id: Long,
        val name: String,
        val profilePath: String?,
        val adult: Boolean,
        val popularity: Double,
        val birthday: String?,
        val knownForDepartment: String,
        val placeOfBirth: String?,
        val alsoKnownAs: List<String>?,
        val biography: String
)