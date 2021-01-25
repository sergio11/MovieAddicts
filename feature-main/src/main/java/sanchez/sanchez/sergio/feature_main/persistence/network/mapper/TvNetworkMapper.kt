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
        posterPath = dto.posterPath,
        popularity = dto.popularity,
        backdropPath = dto.backdropPath,
        voteAverage = dto.voteAverage,
        overview = dto.overview,
        firstAirDate = dto.firstAirDate,
        originCountry = dto.originCountry,
        genreIDS = dto.genreIDS,
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

}