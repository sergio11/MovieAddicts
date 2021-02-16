package sanchez.sanchez.sergio.feature_main.persistence.network.mapper

import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.persistence.network.model.tv.TvDTO

class TvNetworkMapper {

    /**
     * Dto To Model
     * @param dto
     */
    fun dtoToModel(dto: TvDTO) = Tv(
        id = dto.id,
        name = dto.name,
        originalName = dto.originalName,
        posterPath = BASE_POSTER_PATH + dto.posterPath,
        popularity = dto.popularity,
        backdropPath = BASE_BACKDROP_PATH + dto.backdropPath,
        voteAverage = dto.voteAverage,
        overview = dto.overview,
        firstAirDate = dto.firstAirDate,
        originCountry = dto.originCountry,
        originalLanguage = dto.originalLanguage,
        voteCount = dto.voteCount
    )

    /**
     * dto To Model
     * @param dtoList
     */
    fun dtoToModel(dtoList: List<TvDTO>): List<Tv> =
            dtoList.map {
                dtoToModel(it)
            }

    companion object {
        private const val BASE_POSTER_PATH = "https://image.tmdb.org/t/p/w342"
        private const val BASE_BACKDROP_PATH = "https://image.tmdb.org/t/p/w780"
    }

}