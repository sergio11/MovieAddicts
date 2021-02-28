package sanchez.sanchez.sergio.movie_addicts.core.auth

interface IAuthManager {

    suspend fun isAuthenticated(): Boolean

}