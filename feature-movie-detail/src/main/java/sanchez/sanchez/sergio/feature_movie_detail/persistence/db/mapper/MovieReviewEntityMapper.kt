package sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Review
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.ReviewEntity
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.mapper.IEntityToModelMapper

/**
 * Movie Review Entity Mapper
 */
class MovieReviewEntityMapper: IEntityToModelMapper<ReviewEntity, Review> {

    /**
     * Entity to model
     * @param entity
     */
    override fun entityToModel(entity: ReviewEntity) = Review(
            id = entity.id,
            author = entity.author,
            content = entity.content,
            url = entity.url
    )

    /**
     * Entity to model
     * @param entityList
     */
    override fun entityToModel(entityList: List<ReviewEntity>) = entityList.map {
        entityToModel(it)
    }

    /**
     * Model To Entity
     * @param model
     */
    override fun modelToEntity(model: Review) = ReviewEntity(
        id = model.id,
        author = model.author,
        content = model.content,
        url = model.url
    )

    /**
     * Model to Entity
     * @param modelList
     */
    override fun modelToEntity(modelList: List<Review>) = modelList.map {
        modelToEntity(it)
    }

}