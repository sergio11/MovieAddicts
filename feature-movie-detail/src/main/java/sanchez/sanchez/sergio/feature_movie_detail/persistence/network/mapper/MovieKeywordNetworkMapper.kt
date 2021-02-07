package sanchez.sanchez.sergio.feature_movie_detail.persistence.network.mapper

import sanchez.sanchez.sergio.feature_movie_detail.domain.model.Keyword
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.model.KeywordDTO

/**
 * Movie Keyword Network Mapper
 */
class MovieKeywordNetworkMapper {

    fun dtoToModel(keywordDTO: KeywordDTO) = Keyword(
            id = keywordDTO.id,
            name = keywordDTO.name
    )

    fun dtoToModel(keywordDTOList: List<KeywordDTO>) = keywordDTOList.map {
        dtoToModel(it)
    }

}