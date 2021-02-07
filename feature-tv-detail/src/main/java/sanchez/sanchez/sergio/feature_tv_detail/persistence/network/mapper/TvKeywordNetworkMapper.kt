package sanchez.sanchez.sergio.feature_tv_detail.persistence.network.mapper

import sanchez.sanchez.sergio.feature_tv_detail.domain.model.Keyword
import sanchez.sanchez.sergio.feature_tv_detail.persistence.network.model.KeywordDTO

/**
 * Tv Keyword Network Mapper
 */
class TvKeywordNetworkMapper {

    fun dtoToModel(keywordDTO: KeywordDTO) = Keyword(
            id = keywordDTO.id,
            name = keywordDTO.name
    )

    fun dtoToModel(keywordDTOList: List<KeywordDTO>) = keywordDTOList.map {
        dtoToModel(it)
    }

}