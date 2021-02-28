package sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.exception

import java.lang.Exception

abstract class DBError(message: String? = null, cause: Throwable? = null): Exception(message, cause)

/**
 * DB Common Error Exception
 */
class DBErrorException(message: String? = null, cause: Throwable? = null): DBError(message, cause)

/**
 * DB No Result Exception
 */
class DBNoResultException(message: String? = null, cause: Throwable? = null): DBError(message, cause)