package sanchez.sanchez.sergio.movie_addicts.core.persistence.network.service

import android.accounts.NetworkErrorException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

/**
 * Movie Favorite Service Impl
 * @param firestore
 * @param firebaseAuth
 */
class MovieFavoriteServiceImpl(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth
): IMovieFavoriteService {

    /**
     * Get Favorite Movie Ids
     * @return ids
     */
    override suspend fun getFavoriteMovieIds(): List<Long> = withContext(Dispatchers.Default) {
        firebaseAuth.currentUser?.let {
            firestore.collection(it.uid).get().await().documents.map { doc ->
                doc.get("movieId") as Long
            }
        } ?: emptyList()
    }

    /**
     * Add Movie to favorite
     * @param movieId
     */
    override suspend fun addMovieToFavorite(movieId: Long) {
        firebaseAuth.currentUser?.let {
            firestore.collection(it.uid).add(hashMapOf(
                    "movieId" to movieId
                )).await()
        } ?: throw NetworkErrorException("Operation can't made")
    }

    /**
     * Delete Movie From favorite
     * @param movieId
     */
    override suspend fun deleteMovieFromFavorite(movieId: Long)  = withContext(Dispatchers.Default) {
        firebaseAuth.currentUser?.let {
            firestore.collection(it.uid).whereEqualTo("movieId", movieId).get()
                .await().forEach { doc -> doc.reference.delete() }
        } ?: throw NetworkErrorException("Operation can't made")
    }
}