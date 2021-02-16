package sanchez.sanchez.sergio.feature_main.domain.model

data class Tv(
    val id: Long,
    val posterPath: String,
    val popularity: Double,
    val backdropPath: String? = null,
    val voteAverage: Double,
    val overview: String,
    val firstAirDate: String,
    val originCountry: List<String>,
    val originalLanguage: String,
    val voteCount: Long,
    val name: String,
    val originalName: String
)
