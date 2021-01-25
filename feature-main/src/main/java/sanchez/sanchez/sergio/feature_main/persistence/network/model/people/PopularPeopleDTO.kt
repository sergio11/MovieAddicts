package sanchez.sanchez.sergio.feature_main.persistence.network.model.people

import com.squareup.moshi.Json

data class PopularPeopleDTO (
    @field:Json(name = "page")
    val page: Long,
    @field:Json(name = "results")
    val results: List<PersonDTO>,
    @field:Json(name = "total_results")
    val totalResults: Long,
    @field:Json(name = "total_pages")
    val totalPages: Long
)
