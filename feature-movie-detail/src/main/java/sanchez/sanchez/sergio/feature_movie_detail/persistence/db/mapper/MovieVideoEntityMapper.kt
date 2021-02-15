package sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Video
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.VideoEntity

/**
 * Movie Video Entity Mapper
 */
class MovieVideoEntityMapper {

    /**
     * Entity to model
     * @param entity
     */
    fun entityToModel(entity: VideoEntity) = Video(
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
    fun entityToModel(entityList: List<VideoEntity>) = entityList.map {
        entityToModel(it)
    }

    /**
     * Model To Entity
     * @param model
     */
    fun modelToEntity(model: Video) = VideoEntity(
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
    fun modelToEntity(modelList: List<Video>) = modelList.map {
        modelToEntity(it)
    }

}