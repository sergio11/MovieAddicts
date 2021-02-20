package sanchez.sanchez.sergio.feature_main.di.module.tv

import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_main.domain.model.Tv
import sanchez.sanchez.sergio.feature_main.persistence.db.mapper.TvEntityMapper
import sanchez.sanchez.sergio.feature_main.persistence.db.model.tv.TvEntity
import sanchez.sanchez.sergio.feature_main.persistence.db.model.tv.TvEntity_
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment
import sanchez.sanchez.sergio.test.core.persistence.db.mapper.IEntityToModelMapper
import sanchez.sanchez.sergio.test.core.persistence.db.repository.IDBRepository
import sanchez.sanchez.sergio.test.core.persistence.db.repository.objectbox.ObjectBoxRepositoryConfiguration
import sanchez.sanchez.sergio.test.core.persistence.db.repository.objectbox.SupportObjectBoxRepositoryImpl

/**
 * Tv Database Module
 */
@Module
class TvDatabaseModule {

    /**
     * Provide Tv Entity Mapper
     */
    @Provides
    @PerFragment
    fun provideTvEntityMapper(): IEntityToModelMapper<TvEntity, Tv> = TvEntityMapper()

    /**
     * Provide Object Box Configuration
     */
    @Provides
    @PerFragment
    fun provideObjectBoxConfiguration(): ObjectBoxRepositoryConfiguration<TvEntity>
            = ObjectBoxRepositoryConfiguration(
            maxObjectsAllowed = MAX_OBJECTS_ALLOWED,
            objectsExpireInMillis = OBJECTS_EXPIRE_IN_MILLIS,
            objectIdProperty = TvEntity_.id,
            savedAtInMillisProperty = TvEntity_.savedAtInMillis)

    /**
     * Provide Tv DAO
     * @param boxStore
     */
    @Provides
    @PerFragment
    fun provideTvDAO(boxStore: BoxStore): Box<TvEntity> =
        boxStore.boxFor(TvEntity::class.java)

    /**
     * Provide Tv DB Repository
     * @param tvDAO
     * @param tvEntityMapper
     */
    @Provides
    @PerFragment
    fun provideTvDBRepository(
        tvDAO: Box<TvEntity>,
        tvEntityMapper: IEntityToModelMapper<TvEntity, Tv>,
        objectBoxRepositoryConfiguration: ObjectBoxRepositoryConfiguration<TvEntity>
    ): IDBRepository<Tv> =
        SupportObjectBoxRepositoryImpl(tvDAO, tvEntityMapper, objectBoxRepositoryConfiguration)

    companion object {
        private const val MAX_OBJECTS_ALLOWED = 20
        private const val OBJECTS_EXPIRE_IN_MILLIS = 86400000 // 24 hours
    }
}