package sanchez.sanchez.sergio.feature_person_detail.di.module.person

import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_person_detail.BuildConfig.BOX_STORE_NAME
import sanchez.sanchez.sergio.feature_person_detail.domain.model.PersonDetail
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.mapper.PersonDetailEntityMapper
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.model.MyObjectBox
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.model.PersonDetailEntity
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.model.PersonDetailEntity_
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.ObjectBoxManager
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.mapper.IEntityToModelMapper
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.IDBRepository
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.objectbox.ObjectBoxRepositoryConfiguration
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.objectbox.SupportObjectBoxRepositoryImpl

/**
 * Person Detail Database Module
 */
@Module
class PersonDetailDatabaseModule {

    /**
     * Provide Box Store
     * @param appContext
     * @param objectBoxManager
     */
    @Provides
    @PerFragment
    fun provideBoxStore(appContext: Context, objectBoxManager: ObjectBoxManager): BoxStore =
            objectBoxManager.getBoxStore(BOX_STORE_NAME) ?:
            MyObjectBox.builder()
                    .androidContext(appContext)
                    .name(BOX_STORE_NAME)
                    .build().also {
                        objectBoxManager.registerBoxStore(BOX_STORE_NAME, it)
                    }

    /**
     * Provide Person Detail Entity Mapper
     */
    @Provides
    @PerFragment
    fun providePersonDetailEntityMapper(): IEntityToModelMapper<PersonDetailEntity, PersonDetail>
        = PersonDetailEntityMapper()

    /**
     * Provide People DAO
     * @param boxStore
     */
    @Provides
    @PerFragment
    fun providePeopleDAO(boxStore: BoxStore): Box<PersonDetailEntity> =
        boxStore.boxFor(PersonDetailEntity::class.java)

    /**
     * Provide Object Box Configuration
     */
    @Provides
    @PerFragment
    fun provideObjectBoxConfiguration(): ObjectBoxRepositoryConfiguration<PersonDetailEntity>
        = ObjectBoxRepositoryConfiguration(
            maxObjectsAllowed = MAX_OBJECTS_ALLOWED,
            objectsExpireInMillis = OBJECTS_EXPIRE_IN_MILLIS,
            objectIdProperty = PersonDetailEntity_.id,
            savedAtInMillisProperty = PersonDetailEntity_.savedAtInMillis)

    /**
     * Provide People DB Repository
     * @param peopleDAO
     * @param personDetailEntityMapper
     * @param objectBoxConfiguration
     */
    @Provides
    @PerFragment
    fun providePeopleDBRepository(
        peopleDAO: Box<PersonDetailEntity>,
        personDetailEntityMapper: IEntityToModelMapper<PersonDetailEntity, PersonDetail>,
        objectBoxConfiguration: ObjectBoxRepositoryConfiguration<PersonDetailEntity>
    ): IDBRepository<PersonDetail> =
        SupportObjectBoxRepositoryImpl(
                peopleDAO, personDetailEntityMapper, objectBoxConfiguration
        )


    companion object {
        private const val MAX_OBJECTS_ALLOWED = 10
        private const val OBJECTS_EXPIRE_IN_MILLIS = 86400000 // 24 hours
    }

}