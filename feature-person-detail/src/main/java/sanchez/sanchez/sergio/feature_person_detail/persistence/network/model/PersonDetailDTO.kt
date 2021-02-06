package sanchez.sanchez.sergio.feature_person_detail.persistence.network.model

import com.squareup.moshi.Json

data class PersonDetailDTO (
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "birthday")
        val birthday: String,
        @field:Json(name = "known_for_department")
        val knownForDepartment: String,
        @field:Json(name = "deathday")
        val deathday: String? = null,
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "also_known_as")
        val alsoKnownAs: List<String>,
        @field:Json(name = "gender")
        val gender: Long,
        @field:Json(name = "biography")
        val biography: String,
        @field:Json(name = "popularity")
        val popularity: Double,
        @field:Json(name = "place_of_birth")
        val placeOfBirth: String,
        @field:Json(name = "profile_path")
        val profilePath: String,
        @field:Json(name = "adult")
        val adult: Boolean,
        @field:Json(name = "imdb_id")
        val imdbID: String,
        @field:Json(name = "homepage")
        val homepage: String? = null
)

