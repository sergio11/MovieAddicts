package sanchez.sanchez.sergio.feature_tv_detail.persistence.network.model

import com.squareup.moshi.Json

data class TvReviewsDTO (
        @field:Json(name = "id")
        val id: Long,
        @field:Json(name = "page")
        val page: Long,
        @field:Json(name = "results")
        val reviews: List<ReviewDTO>,
        @field:Json(name = "total_pages")
        val totalPages: Long,
        @field:Json(name = "total_results")
        val totalResults: Long
)

data class ReviewDTO (
        @field:Json(name = "author")
        val author: String,
        @field:Json(name = "author_details")
        val authorDetails: AuthorDetailsDTO,
        @field:Json(name = "content")
        val content: String,
        @field:Json(name = "created_at")
        val createdAt: String,
        @field:Json(name = "id")
        val id: String,
        @field:Json(name = "updated_at")
        val updatedAt: String,
        @field:Json(name = "url")
        val url: String
)

data class AuthorDetailsDTO (
        @field:Json(name = "name")
        val name: String,
        @field:Json(name = "username")
        val username: String,
        @field:Json(name = "avatar_path")
        val avatarPath: String? = null,
        @field:Json(name = "rating")
        val rating: Long? = null
)

