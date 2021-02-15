package sanchez.sanchez.sergio.feature_movie_detail.persistence.db.mapper

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.persistence.db.model.MovieDetailEntity

/**
 * Movie Detail Entity Mapper
 * @param movieKeywordEntityMapper
 * @param movieReviewEntityMapper
 * @param movieVideoEntityMapper
 */
class MovieDetailEntityMapper(
    private val movieKeywordEntityMapper: MovieKeywordEntityMapper,
    private val movieReviewEntityMapper: MovieReviewEntityMapper,
    private val movieVideoEntityMapper: MovieVideoEntityMapper
) {

    /**
     * Entity to model
     * @param movieDetailEntity
     */
    fun entityToModel(movieDetailEntity: MovieDetailEntity) = MovieDetail(
        id = movieDetailEntity.id,
        title = movieDetailEntity.title,
        originalTitle = movieDetailEntity.originalTitle,
        originalLanguage = movieDetailEntity.originalLanguage,
        posterPath = movieDetailEntity.posterPath,
        adult = movieDetailEntity.adult,
        overview = movieDetailEntity.overview,
        releaseDate = movieDetailEntity.releaseDate,
        genres = movieDetailEntity.genres,
        backdropPath =  movieDetailEntity.backdropPath,
        popularity = movieDetailEntity.popularity,
        voteCount = movieDetailEntity.voteCount,
        video = movieDetailEntity.video,
        voteAverage = movieDetailEntity.voteAverage,
        keywords = movieDetailEntity.keywords?.let {
            movieKeywordEntityMapper.entityToModel(it)
        },
        videos = movieDetailEntity.videos?.let {
            movieVideoEntityMapper.entityToModel(it)
        },
        reviews = movieDetailEntity.reviews?.let {
            movieReviewEntityMapper.entityToModel(it)
        }
    )

    /**
     * Model to Entity
     * @param movieDetail
     */
    fun modelToEntity(movieDetail: MovieDetail) = MovieDetailEntity(
        id = movieDetail.id,
        title = movieDetail.title,
        originalTitle = movieDetail.originalTitle,
        originalLanguage = movieDetail.originalLanguage,
        posterPath = movieDetail.posterPath,
        adult = movieDetail.adult,
        overview = movieDetail.overview,
        releaseDate = movieDetail.releaseDate,
        genres = movieDetail.genres,
        backdropPath =  movieDetail.backdropPath,
        popularity = movieDetail.popularity,
        voteCount = movieDetail.voteCount,
        video = movieDetail.video,
        voteAverage = movieDetail.voteAverage,
        keywords = movieDetail.keywords?.let {
            movieKeywordEntityMapper.modelToEntity(it)
        },
        videos = movieDetail.videos?.let {
            movieVideoEntityMapper.modelToEntity(it)
        },
        reviews = movieDetail.reviews?.let {
            movieReviewEntityMapper.modelToEntity(it)
        }
    )


}