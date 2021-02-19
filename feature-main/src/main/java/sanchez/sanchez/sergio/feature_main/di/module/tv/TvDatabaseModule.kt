package sanchez.sanchez.sergio.feature_main.di.module.tv

import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_main.persistence.db.mapper.TvEntityMapper
import sanchez.sanchez.sergio.feature_main.persistence.db.model.tv.TvEntity
import sanchez.sanchez.sergio.feature_main.persistence.db.repository.tv.DiscoverTvDBRepositoryImpl
import sanchez.sanchez.sergio.feature_main.persistence.db.repository.tv.IDiscoverTvDBRepository
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

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
    fun provideTvEntityMapper() = TvEntityMapper()

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
        tvEntityMapper: TvEntityMapper
    ): IDiscoverTvDBRepository =
        DiscoverTvDBRepositoryImpl(tvDAO, tvEntityMapper)

}