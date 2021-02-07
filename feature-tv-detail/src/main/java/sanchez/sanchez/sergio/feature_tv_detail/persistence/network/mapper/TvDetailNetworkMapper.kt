package sanchez.sanchez.sergio.feature_tv_detail.persistence.network.mapper

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.TvDetail
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.model.TvDetailDTO

/**
 * Tv Detail Network Mapper
 */
class TvDetailNetworkMapper {

    fun dtoToModel(dto: TvDetailDTO) = TvDetail(
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
            genres = dto.genres.map { it.name },
            originalLanguage = dto.originalLanguage,
            voteCount = dto.voteCount
    )

}