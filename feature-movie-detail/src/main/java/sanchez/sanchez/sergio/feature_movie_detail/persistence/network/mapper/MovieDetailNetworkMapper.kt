package sanchez.sanchez.sergio.feature_movie_detail.persistence.network.mapper

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.MovieDetail
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.model.MovieDetailDTO

/**
 * Movie Detail Network Mapper
 */
class MovieDetailNetworkMapper  {

    fun dtoToModel(dto: MovieDetailDTO) = MovieDetail(
            id = dto.id,
            title = dto.title,
            originalTitle = dto.originalTitle,
            originalLanguage = dto.originalLanguage,
            posterPath = dto.posterPath,
            adult = dto.adult,
            overview = dto.overview,
            releaseDate = dto.releaseDate,
            genres = dto.genres.map { it.name },
            backdropPath = dto.backdropPath,
            popularity = dto.popularity,
            voteCount = dto.voteCount,
            video = dto.video,
            voteAverage = dto.voteAverage
    )


}