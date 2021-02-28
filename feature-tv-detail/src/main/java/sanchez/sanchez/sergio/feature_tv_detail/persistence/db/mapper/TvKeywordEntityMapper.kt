package sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Keyword
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.model.KeywordEntity
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.mapper.IEntityToModelMapper

/**
 * Tv Keyword Entity Mapper
 */
class TvKeywordEntityMapper: IEntityToModelMapper<KeywordEntity, Keyword> {

    /**
    * Entity to model
    * @param entity
    */
    override fun entityToModel(entity: KeywordEntity) = Keyword(
            id = entity.id,
            name = entity.name
    )

    /**
     * Entity to model
     * @param entityList
     */
    override fun entityToModel(entityList: List<KeywordEntity>) = entityList.map {
        entityToModel(it)
    }

    /**
     * Model to entity
     * @param model
     */
    override fun modelToEntity(model: Keyword) = KeywordEntity(
            id = model.id,
            name = model.name
    )

    /**
     * Model To entity
     * @param modelList
     */
    override fun modelToEntity(modelList: List<Keyword>) = modelList.map {
        modelToEntity(it)
    }
}