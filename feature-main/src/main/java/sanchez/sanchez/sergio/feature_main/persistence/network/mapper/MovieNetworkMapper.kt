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
            posterPath = dto.posterPath,
            adult = dto.adult,
            overview = dto.overview,
            releaseDate = dto.releaseDate,
            genreIds = dto.genreIDS,
            originalTitle = dto.originalTitle,
            originalLanguage = dto.originalLanguage,
            backdropPath = dto.backdropPath,
            popularity = dto.popularity,
            voteCount = dto.voteCount,
            video = dto.video,
            voteAverage = dto.voteAverage
    )

    fun dtoToModel(dtoList: List<MovieDTO>): List<Movie> =
            dtoList.map {
                dtoToModel(it)
            }

}