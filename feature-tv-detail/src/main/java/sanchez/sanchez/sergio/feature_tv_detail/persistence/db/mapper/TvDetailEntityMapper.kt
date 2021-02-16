package sanchez.sanchez.sergio.feature_tv_detail.persistence.db.mapper

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.feature_tv_detail.persistence.db.model.TvDetailEntity

/**
 * Tv Detail Entity Mapper
 * @param tvKeywordEntityMapper
 * @param tvReviewEntityMapper
 * @param tvVideoEntityMapper
 */
class TvDetailEntityMapper(
        private val tvKeywordEntityMapper: TvKeywordEntityMapper,
        private val tvReviewEntityMapper: TvReviewEntityMapper,
        private val tvVideoEntityMapper: TvVideoEntityMapper
) {

    /**
     * Entity to model
     * @param entity
     */
    fun entityToModel(entity: TvDetailEntity) = TvDetail(
            id = entity.id,
            name = entity.name,
            originalName = entity.originalName,
            posterPath = entity.posterPath,
            popularity = entity.popularity,
            backdropPath = entity.backdropPath,
            voteAverage = entity.voteAverage,
            overview = entity.overview,
            firstAirDate = entity.firstAirDate,
            originCountry = entity.originCountry,
            genres = entity.genres,
            originalLanguage = entity.originalLanguage,
            voteCount = entity.voteCount,
            keywords = entity.keywords.let {
                tvKeywordEntityMapper.entityToModel(it)
            },
            videos = entity.videos.let {
                tvVideoEntityMapper.entityToModel(it)
            },
            reviews = entity.reviews.let {
                tvReviewEntityMapper.entityToModel(it)
            }

    )

    /**
     * Entity to Model
     * @param entityList
     */
    fun entityToModel(entityList: List<TvDetailEntity>) = entityList.map {
        entityToModel(it)
    }

    /**
     * Model to entity
     * @param model
     */
    fun modelToEntity(model: TvDetail) = TvDetailEntity(
            id = model.id,
            name = model.name,
            originalName = model.originalName,
            posterPath = model.posterPath,
            popularity = model.popularity,
            backdropPath = model.backdropPath,
            voteAverage = model.voteAverage,
            overview = model.overview,
            firstAirDate = model.firstAirDate,
            originCountry = model.originCountry,
            genres = model.genres,
            originalLanguage = model.originalLanguage,
            voteCount = model.voteCount
    ).apply {
        model.keywords?.let {
            keywords.addAll(tvKeywordEntityMapper.modelToEntity(it))
        }
        model.videos?.let {
            videos.addAll(tvVideoEntityMapper.modelToEntity(it))
        }
        model.reviews?.let {
            reviews.addAll(tvReviewEntityMapper.modelToEntity(it))
        }
    }

    /**
     * Model to entity
     * @param modelList
     */
    fun modelToEntity(modelList: List<TvDetail>) = modelList.map {
        modelToEntity(it)
    }
}