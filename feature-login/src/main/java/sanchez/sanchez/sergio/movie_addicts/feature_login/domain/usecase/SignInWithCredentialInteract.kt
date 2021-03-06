package sanchez.sanchez.sergio.movie_addicts.feature_login.domain.usecase

import sanchez.sanchez.sergio.movie_addicts.core.auth.IAuthManager
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.AuthTypeEnum
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.AuthUser

/**
 * Sign In With Credential Interact
 * @param authManager
 */
class SignInWithCredentialInteract(private val authManager: IAuthManager) {

    /**
     * Execute
     * @param onSuccess
     * @param onError
     */
    suspend fun execute(
        params: Params,
        onSuccess: (authUser: AuthUser) -> Unit,
        onError: (ex: Exception) -> Unit) = try {
        val authUser = authManager.signInWithAccessToken(params.accessToken, params.authType)
        onSuccess(authUser)
    } catch (ex: Exception) {
        onError(ex)
    }

    /**
     * Params
     */
    data class Params(
        val accessToken: String,
        val authType: AuthTypeEnum
    )

}