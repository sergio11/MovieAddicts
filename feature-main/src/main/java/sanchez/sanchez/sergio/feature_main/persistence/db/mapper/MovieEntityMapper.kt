package sanchez.sanchez.sergio.feature_main.persistence.db.mapper

import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.feature_main.persistence.db.model.movies.MovieEntity
import sanchez.sanchez.sergio.test.core.persistence.db.mapper.IEntityToModelMapper
import java.util.*

/**
 * Movie entity Mapper
 */
class MovieEntityMapper: IEntityToModelMapper<MovieEntity, Movie> {

    /**
     * Entity to model
     * @param entity
     */
    override fun entityToModel(entity: MovieEntity) = Movie(
            id = entity.id,
            title = entity.title,
            posterPath = entity.posterPath,
            adult = entity.adult,
            overview = entity.overview,
            releaseDate = entity.releaseDate,
            originalTitle = entity.originalTitle,
            originalLanguage = entity.originalLanguage,
            backdropPath = entity.backdropPath,
            popularity = entity.popularity,
            voteCount = entity.voteCount,
            video = entity.video,
            voteAverage = entity.voteAverage
    )

    /**
     * Entity to model
     * @param entityList
     */
    override fun entityToModel(entityList: List<MovieEntity>) = entityList.map {
        entityToModel(it)
    }

    /**
     * Model To Entity
     * @param model
     */
    override fun modelToEntity(model: Movie) = MovieEntity(
            id = model.id,
            title = model.title,
            posterPath = model.posterPath,
            adult = model.adult,
            overview = model.overview,
            releaseDate = model.releaseDate,
            originalTitle = model.originalTitle,
            originalLanguage = model.originalLanguage,
            backdropPath = model.backdropPath,
            popularity = model.popularity,
            voteCount = model.voteCount,
            video = model.video,
            voteAverage = model.voteAverage,
            savedAtInMillis = Date().time
    )

    /**
     * Model To Entity
     * @param modelList
     */
    override fun modelToEntity(modelList: List<Movie>) = modelList.map {
        modelToEntity(it)
    }

}