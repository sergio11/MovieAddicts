package sanchez.sanchez.sergio.feature_main.di.module.core

import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_main.BuildConfig.BOX_STORE_NAME
import sanchez.sanchez.sergio.feature_main.persistence.db.model.MyObjectBox
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerActivity
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.ObjectBoxManager

/**
 * Database Module
 */
@Module
class DatabaseModule {

    /**
     * Provide Box Store
     * @param appContext
     * @param objectBoxManager
     */
    @Provides
    @PerActivity
    fun provideBoxStore(appContext: Context, objectBoxManager: ObjectBoxManager): BoxStore =
            objectBoxManager.getBoxStore(BOX_STORE_NAME) ?:
            MyObjectBox.builder()
                    .androidContext(appContext)
                    .name(BOX_STORE_NAME)
                    .build().also {
                        objectBoxManager.registerBoxStore(BOX_STORE_NAME, it)
                    }

}