package sanchez.sanchez.sergio.feature_tv_detail.persistence.network.mapper

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Video
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.model.VideoDTO


/**
 * Tv Video Network Mapper
 */
class TvVideoNetworkMapper {

    fun dtoToModel(dto: VideoDTO) = Video(
            id = dto.id,
            name = dto.name,
            site = dto.site,
            key = dto.key,
            size = dto.size,
            type = dto.type,
            thumbnailPath = "$YOUTUBE_THUMBNAIL_URL${dto.key}/default.jpg"
    )

    fun dtoToModel(dtoList: List<VideoDTO>) = dtoList.map {
        dtoToModel(it)
    }

    companion object {
        private const val YOUTUBE_THUMBNAIL_URL = "https://img.youtube.com/vi/"
    }

}