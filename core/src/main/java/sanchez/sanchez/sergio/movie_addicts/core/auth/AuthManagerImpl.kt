package sanchez.sanchez.sergio.movie_addicts.core.auth

import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
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

    override suspend fun signInWithAccessToken(accessToken: String): AuthUser = withContext(Dispatchers.IO) {
        try {
            val authResult = firebaseAuth.signInWithCredential(
                FacebookAuthProvider.getCredential(accessToken))
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
}