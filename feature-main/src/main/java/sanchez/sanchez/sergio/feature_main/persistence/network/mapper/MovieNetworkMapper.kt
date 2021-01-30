package sanchez.sanchez.sergio.feature_main.persistence.network.mapper

import sanchez.sanchez.sergio.feature_main.domain.model.Movie
import sanchez.sanchez.sergio.feature_main.persistence.network.model.movies.MovieDTO

class MovieNetworkMapper {

    /**
     * Dto To Model
     * @param dto
     */
    fun dtoToModel(dto: MovieDTO): Movie = Movie(
            id = dto.id,
            title = dto.title,
            posterPath = BASE_POSTER_PATH + dto.posterPath,
            adult = dto.adult,
            overview = dto.overview,
            releaseDate = dto.releaseDate,
            genreIds = dto.genreIDS,
            originalTitle = dto.originalTitle,
            originalLanguage = dto.originalLanguage,
            backdropPath = BASE_BACKDROP_PATH + dto.backdropPath,
            popularity = dto.popularity,
            voteCount = dto.voteCount,
            video = dto.video,
            voteAverage = dto.voteAverage
    )

    fun dtoToModel(dtoList: List<MovieDTO>): List<Movie> =
            dtoList.map {
                dtoToModel(it)
            }

    companion object {
        private const val BASE_POSTER_PATH = "https://image.tmdb.org/t/p/w342"
        private const val BASE_BACKDROP_PATH = "https://image.tmdb.org/t/p/w780"
    }

}