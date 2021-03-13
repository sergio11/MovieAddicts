package sanchez.sanchez.sergio.movie_addicts.core.di.module.db

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerApplication
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.ObjectBoxManager

@Module
class DatabaseModule {

    /**
     * Provide Object Box Manager
     */
    @Provides
    @PerApplication
    fun provideObjectBoxManager() = ObjectBoxManager()

    /**
     * Provide Firebase Firestore
     */
    @Provides
    @PerApplication
    fun provideFirestore(): FirebaseFirestore = Firebase.firestore
}