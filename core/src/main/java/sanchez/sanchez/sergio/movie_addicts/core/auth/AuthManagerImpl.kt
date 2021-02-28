package sanchez.sanchez.sergio.movie_addicts.core.auth

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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
}