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
            posterPath = BASE_POSTER_PATH + dto.posterPath,
            adult = dto.adult,
            overview = dto.overview,
            releaseDate = dto.releaseDate,
            genres = dto.genres.map { it.name },
            backdropPath = BASE_BACKDROP_PATH + dto.backdropPath,
            popularity = dto.popularity,
            voteCount = dto.voteCount,
            video = dto.video,
            voteAverage = dto.voteAverage
        )

        companion object {
                private const val BASE_POSTER_PATH = "https://image.tmdb.org/t/p/w342"
                private const val BASE_BACKDROP_PATH = "https://image.tmdb.org/t/p/w780"
        }
}