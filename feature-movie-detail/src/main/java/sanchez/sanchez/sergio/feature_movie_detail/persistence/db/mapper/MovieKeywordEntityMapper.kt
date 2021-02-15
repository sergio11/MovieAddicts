package sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Keyword
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.KeywordEntity

/**
 * Movie Keyword Entity Mapper
 */
class MovieKeywordEntityMapper {

    /**
     * Entity to model
     * @param entity
     */
    fun entityToModel(entity: KeywordEntity) = Keyword(
        id = entity.id,
        name = entity.name
    )

    /**
     * Entity to model
     * @param entityList
     */
    fun entityToModel(entityList: List<KeywordEntity>) = entityList.map {
        entityToModel(it)
    }

    /**
     * Model to entity
     * @param model
     */
    fun modelToEntity(model: Keyword) = KeywordEntity(
        id = model.id,
        name = model.name
    )

    /**
     * Model To entity
     * @param modelList
     */
    fun modelToEntity(modelList: List<Keyword>) = modelList.map {
        modelToEntity(it)
    }

}