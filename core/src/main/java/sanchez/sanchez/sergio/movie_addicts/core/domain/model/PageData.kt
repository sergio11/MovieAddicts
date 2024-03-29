package sanchez.sanchez.sergio.movie_addicts.core.domain.model

/**
 * Page Data
 * @param page
 * @param data
 * @param isLast
 */
data class PageData<T> (val page: Long, val data: List<T>, val isLast: Boolean)
