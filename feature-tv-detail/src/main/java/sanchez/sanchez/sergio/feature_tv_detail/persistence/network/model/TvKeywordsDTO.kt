package sanchez.sanchez.sergio.feature_tv_detail.persistence.network.model

import com.squareup.moshi.Json

/**
 * Tv Keywords DTO
 */
data class TvKeywordsDTO (
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "results")
        val keywords: List<KeywordDTO>
)

/**
 * Keyword DTO
 */
data class KeywordDTO (
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "name")
        val name: String
)

