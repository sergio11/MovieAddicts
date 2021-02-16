package sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Review
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.model.ReviewEntity

/**
 * Tv Review Entity Mapper
 */
class TvReviewEntityMapper {

    /**
     * Entity to model
     * @param entity
     */
    fun entityToModel(entity: ReviewEntity) = Review(
            id = entity.id,
            author = entity.author,
            content = entity.content,
            url = entity.url
    )

    /**
     * Entity to model
     * @param entityList
     */
    fun entityToModel(entityList: List<ReviewEntity>) = entityList.map {
        entityToModel(it)
    }

    /**
     * Model To Entity
     * @param model
     */
    fun modelToEntity(model: Review) = ReviewEntity(
            id = model.id,
            author = model.author,
            content = model.content,
            url = model.url
    )

    /**
     * Model to Entity
     * @param modelList
     */
    fun modelToEntity(modelList: List<Review>) = modelList.map {
        modelToEntity(it)
    }

}