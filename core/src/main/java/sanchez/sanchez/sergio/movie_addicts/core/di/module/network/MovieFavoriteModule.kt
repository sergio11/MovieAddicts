package sanchez.sanchez.sergio.movie_addicts.core.di.module.network

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerApplication
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.service.IMovieFavoriteService
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.service.MovieFavoriteServiceImpl

/**
 * Movie Favorite Module
 */
@Module
class MovieFavoriteModule {

    /**
     * Provide Movie Favorite Service
     * @param fireStore
     * @param firebaseAuth
     */
    @Provides
    @PerApplication
    fun provideMovieFavoriteService(
        fireStore: FirebaseFirestore,
        firebaseAuth: FirebaseAuth): IMovieFavoriteService =
        MovieFavoriteServiceImpl(fireStore, firebaseAuth)

}