package sanchez.sanchez.sergio.feature_movie_detail.persistence.network.model

import com.squareup.moshi.Json

data class MovieKeywordsDTO(
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "keywords")
        val keywords: List<KeywordDTO>
)

/**
 * Keyword DTO
 */
data class KeywordDTO(
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "name")
        val name: String,
)

