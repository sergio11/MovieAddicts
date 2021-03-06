package sanchez.sanchez.sergio.movie_addicts.core.auth

import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.AuthTypeEnum
import sanchez.sanchez.sergio.movie_addicts.core.domain.model.AuthUser
import java.lang.Exception

/**
 * Authentication Manager
 * @param firebaseAuth
 */
class AuthManagerImpl(
    private val firebaseAuth: FirebaseAuth
): IAuthManager {

    /**
     * Check if user authenticated
     */
    override suspend fun isAuthenticated(): Boolean = withContext(Dispatchers.IO) {
        firebaseAuth.currentUser != null
    }

    override suspend fun signInWithAccessToken(accessToken: String, authTypeEnum: AuthTypeEnum): AuthUser = withContext(Dispatchers.IO) {
        try {
            val authResult = firebaseAuth.signInWithCredential(
                getCredentials(accessToken, authTypeEnum))
                .await()
            authResult?.user?.let {
                AuthUser(
                    displayName = it.displayName,
                    email = it.email
                )
            } ?: kotlin.run {
                throw Exception("Login failed")
            }
        } catch (ex: Exception) {
            throw AuthException(ex)
        }

    }

    /**
     * Private Methods
     */

    /**
     * Get Credentials
     * @param accessToken
     * @param authTypeEnum
     */
    private fun getCredentials(accessToken: String, authTypeEnum: AuthTypeEnum) =
        when(authTypeEnum) {
            AuthTypeEnum.FACEBOOK -> FacebookAuthProvider.getCredential(accessToken)
            AuthTypeEnum.GOOGLE -> GoogleAuthProvider.getCredential(accessToken, null)
        }
}