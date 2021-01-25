package sanchez.sanchez.sergio.feature_main.persistence.network.model.people

import com.squareup.moshi.Json

data class PersonDTO (
    @field:Json(name = "id")
    val id: Long,
    @field:Json(name = "profile_path")
    val profilePath: String,
    @field:Json(name = "adult")
    val adult: Boolean,
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "popularity")
    val popularity: Double
)
