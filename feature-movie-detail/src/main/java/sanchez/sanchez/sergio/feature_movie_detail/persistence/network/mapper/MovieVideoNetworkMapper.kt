package sanchez.sanchez.sergio.feature_movie_detail.persistence.network.mapper

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Video
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.model.VideoDTO

/**
 * Movie Video Network Mapper
 */
class MovieVideoNetworkMapper {

    fun dtoToModel(dto: VideoDTO) = Video(
            id = dto.id,
            name = dto.name,
            site = dto.site,
            key = dto.key,
            size = dto.size,
            type = dto.type
    )

    fun dtoToModel(dtoList: List<VideoDTO>) = dtoList.map {
        dtoToModel(it)
    }

}