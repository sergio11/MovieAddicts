package sanchez.sanchez.sergio.feature_main.domain.model

data class Movie(
  val id: Long,
  val posterPath: String?,
  val adult: Boolean,
  val overview: String,
  val releaseDate: String?,
  val originalTitle: String,
  val originalLanguage: String,
  val title: String,
  val backdropPath: String?,
  val popularity: Double,
  val voteCount: Long,
  val video: Boolean,
  val voteAverage: Double,
  var isFavorite: Boolean = false
)
