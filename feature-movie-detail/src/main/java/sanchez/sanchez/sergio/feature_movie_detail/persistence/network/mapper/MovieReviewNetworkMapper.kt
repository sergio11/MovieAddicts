package sanchez.sanchez.sergio.feature_movie_detail.persistence.network.mapper

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Review
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.model.ReviewDTO

/**
 * Movie Reviews Network Mapper
 */
class MovieReviewNetworkMapper {

    fun dtoToModel(dto: ReviewDTO) = Review(
            id = dto.id,
            author = dto.author,
            content = dto.content,
            url = dto.url
    )

    fun dtoToModel(dtoList: List<ReviewDTO>) = dtoList.map {
        dtoToModel(it)
    }

}