package sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Video
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.model.VideoEntity
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.mapper.IEntityToModelMapper

/**
 * Tv Video Entity Mapper
 */
class TvVideoEntityMapper: IEntityToModelMapper<VideoEntity, Video> {

    /**
     * Entity to model
     * @param entity
     */
    override fun entityToModel(entity: VideoEntity) = Video(
            id = entity.id,
            name = entity.name,
            site = entity.site,
            key = entity.key,
            size = entity.size,
            type = entity.type,
            thumbnailPath =  entity.thumbnailPath
    )

    /**
     * Entity to model
     * @param entityList
     */
    override fun entityToModel(entityList: List<VideoEntity>) = entityList.map {
        entityToModel(it)
    }

    /**
     * Model To Entity
     * @param model
     */
    override fun modelToEntity(model: Video) = VideoEntity(
            id = model.id,
            name = model.name,
            site = model.site,
            key = model.key,
            size = model.size,
            type = model.type,
            thumbnailPath =  model.thumbnailPath
    )

    /**
     * Model to entity
     * @param modelList
     */
    override fun modelToEntity(modelList: List<Video>) = modelList.map {
        modelToEntity(it)
    }
}