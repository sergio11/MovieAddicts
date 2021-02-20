package sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Keyword
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Review
import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Video
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.KeywordEntity
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.MovieDetailEntity
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.ReviewEntity
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.VideoEntity
import sanchez.sanchez.sergio.test.core.persistence.db.mapper.IEntityToModelMapper
import java.util.*

/**
 * Movie Detail Entity Mapper
 * @param movieKeywordEntityMapper
 * @param movieReviewEntityMapper
 * @param movieVideoEntityMapper
 */
class MovieDetailEntityMapper(
        private val movieKeywordEntityMapper: IEntityToModelMapper<KeywordEntity, Keyword>,
        private val movieReviewEntityMapper: IEntityToModelMapper<ReviewEntity, Review>,
        private val movieVideoEntityMapper: IEntityToModelMapper<VideoEntity, Video>
): IEntityToModelMapper<MovieDetailEntity, MovieDetail> {

    /**
     * Entity to model
     * @param entity
     */
    override fun entityToModel(entity: MovieDetailEntity) = MovieDetail(
        id = entity.id,
        title = entity.title,
        originalTitle = entity.originalTitle,
        originalLanguage = entity.originalLanguage,
        posterPath = entity.posterPath,
        adult = entity.adult,
        overview = entity.overview,
        releaseDate = entity.releaseDate,
        genres = entity.genres,
        backdropPath =  entity.backdropPath,
        popularity = entity.popularity,
        voteCount = entity.voteCount,
        video = entity.video,
        voteAverage = entity.voteAverage,
        keywords = entity.keywords.let {
            movieKeywordEntityMapper.entityToModel(it)
        },
        videos = entity.videos.let {
            movieVideoEntityMapper.entityToModel(it)
        },
        reviews = entity.reviews.let {
            movieReviewEntityMapper.entityToModel(it)
        }
    )

    override fun entityToModel(entityList: List<MovieDetailEntity>) = entityList.map {
        entityToModel(it)
    }

    /**
     * Model to Entity
     * @param model
     */
    override fun modelToEntity(model: MovieDetail) = MovieDetailEntity(
            id = model.id,
            title = model.title,
            originalTitle = model.originalTitle,
            originalLanguage = model.originalLanguage,
            posterPath = model.posterPath,
            adult = model.adult,
            overview = model.overview,
            releaseDate = model.releaseDate,
            genres = model.genres,
            backdropPath =  model.backdropPath,
            popularity = model.popularity,
            voteCount = model.voteCount,
            video = model.video,
            voteAverage = model.voteAverage,
            savedAtInMillis = Date().time
    ).apply {
        model.keywords?.let {
             keywords.addAll(movieKeywordEntityMapper.modelToEntity(it))
        }
        model.videos?.let {
            videos.addAll(movieVideoEntityMapper.modelToEntity(it))
        }
        model.reviews?.let {
            reviews.addAll(movieReviewEntityMapper.modelToEntity(it))
        }
    }

    override fun modelToEntity(modelList: List<MovieDetail>) = modelList.map {
        modelToEntity(it)
    }

}