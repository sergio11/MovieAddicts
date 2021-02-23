package sanchez.sanchez.sergio.test.core.di.module.db

import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.test.core.di.scope.PerApplication
import sanchez.sanchez.sergio.test.core.persistence.db.ObjectBoxManager

@Module
class DatabaseModule {

    /**
     * Provide Object Box Manager
     */
    @Provides
    @PerApplication
    fun provideObjectBoxManager() = ObjectBoxManager()
}