package sanchez.sanchez.sergio.movie_addicts.core.auth

import sanchez.sanchez.sergio.movie_addicts.core.domain.model.AuthTypeEnum
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.AuthUser

interface IAuthManager {

    suspend fun isAuthenticated(): Boolean

    /**
     * Sign In With Access Token
     * @param accessToken
     * @param authTypeEnum
     */
    suspend fun signInWithAccessToken(accessToken: String, authTypeEnum: AuthTypeEnum): AuthUser

    suspend fun closeSession()

}