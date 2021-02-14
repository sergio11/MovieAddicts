package sanchez.sanchez.sergio.feature_person_detail.di.module.db

import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_person_detail.BuildConfig.BOX_STORE_NAME
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.model.MyObjectBox
import sanchez.sanchez.sergio.test.core.di.scope.PerApplication

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
    @PerApplication
    fun provideBoxStore(appContext: Context): BoxStore =
        MyObjectBox.builder()
            .androidContext(appContext)
            .name(BOX_STORE_NAME)
            .build()
}