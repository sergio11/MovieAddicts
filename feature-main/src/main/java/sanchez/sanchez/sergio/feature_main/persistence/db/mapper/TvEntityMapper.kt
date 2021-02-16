package sanchez.sanchez.sergio.feature_main.persistence.db.mapper

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.persistence.db.model.tv.TvEntity

/**
 * Tv Entity Mapper
 */
class TvEntityMapper {

    fun entityToModel(entity: TvEntity) = Tv(
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

    fun entityToModel(entityList: List<TvEntity>) = entityList.map {
        entityToModel(it)
    }
}