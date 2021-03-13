package sanchez.sanchez.sergio.feature_main.domain.model

import sanchez.sanchez.sergio.movie_addicts.core.utils.Identificable

data class Movie(
  override val id: Long,
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
): Identificable
