package sanchez.sanchez.sergio.movie_addicts.core.di.module.db

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
}