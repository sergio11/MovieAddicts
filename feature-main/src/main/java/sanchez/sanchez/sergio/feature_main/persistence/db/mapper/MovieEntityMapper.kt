package sanchez.sanchez.sergio.feature_main.persistence.db.mapper

import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.feature_main.persistence.db.model.movies.MovieEntity

/**
 * Movie entity Mapper
 */
class MovieEntityMapper {

    /**
     * Entity to model
     * @param entity
     */
    fun entityToModel(entity: MovieEntity) = Movie(
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
    fun entityToModel(entityList: List<MovieEntity>) = entityList.map {
        entityToModel(it)
    }

    /**
     * Model To Entity
     * @param model
     */
    fun modelToEntity(model: Movie) = MovieEntity(
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
            voteAverage = model.voteAverage
    )

    /**
     * Model To Entity
     * @param modelList
     */
    fun modelToEntity(modelList: List<Movie>) = modelList.map {
        modelToEntity(it)
    }

}