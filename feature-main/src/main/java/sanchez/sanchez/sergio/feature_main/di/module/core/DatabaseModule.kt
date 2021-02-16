package sanchez.sanchez.sergio.feature_main.di.module.core

import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_main.BuildConfig.BOX_STORE_NAME
import sanchez.sanchez.sergio.feature_main.persistence.db.model.MyObjectBox
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Database Module
 */
@Module
class DatabaseModule {

    /**
     * Provide Box Store
     * @param appContext
     */
    @Provides
    @PerFragment
    fun provideBoxStore(appContext: Context): BoxStore =
        MyObjectBox.builder()
            .androidContext(appContext)
            .name(BOX_STORE_NAME)
            .build()
}