package sanchez.sanchez.sergio.feature_main.domain.model

data class Person(
  val id: Long,
  val name: String,
  val popularity: Double,
  val profilePath: String?,
  val adult: Boolean,
)
