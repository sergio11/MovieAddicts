package sanchez.sanchez.sergio.test.core.persistence.db.repository.exception

import java.lang.Exception

/**
 * DB Common Error Exception
 */
class DBErrorException(message: String? = null, cause: Throwable? = null): Exception(message, cause)

/**
 * DB No Result Exception
 */
class DBNoResultException(message: String? = null, cause: Throwable? = null): Exception(message, cause)