package sanchez.sanchez.sergio.feature_main.persistence.db.mapper

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.persistence.db.model.tv.TvEntity
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.mapper.IEntityToModelMapper
import java.util.*

/**
 * Tv Entity Mapper
 */
class TvEntityMapper: IEntityToModelMapper<TvEntity, Tv> {

    override fun entityToModel(entity: TvEntity) = Tv(
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
        originalLanguage = entity.originalLanguage,
        voteCount = entity.voteCount
    )

    override fun entityToModel(entityList: List<TvEntity>) = entityList.map {
        entityToModel(it)
    }

    override fun modelToEntity(model: Tv) = TvEntity(
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
            originalLanguage = model.originalLanguage,
            voteCount = model.voteCount,
            savedAtInMillis = Date().time
    )

    override fun modelToEntity(modelList: List<Tv>) = modelList.map {
        modelToEntity(it)
    }
}