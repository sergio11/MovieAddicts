package sanchez.sanchez.sergio.feature_main.domain.model

import sanchez.sanchez.sergio.movie_addicts.core.utils.Identificable

data class Person(
  override val id: Long,
  val name: String,
  val popularity: Double,
  val profilePath: String?,
  val adult: Boolean,
): Identificable
