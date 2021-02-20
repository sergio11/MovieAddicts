package sanchez.sanchez.sergio.feature_person_detail.di.module.person

import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_person_detail.BuildConfig.BOX_STORE_NAME
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.mapper.PersonDetailEntityMapper
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.model.MyObjectBox
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.model.PersonDetailEntity
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.repository.IPeopleDBRepository
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.repository.PeopleObjectBoxRepositoryImpl
import sanchez.sanchez.sergio.feature_person_detail.persistence.db.repository.objectbox.ObjectBoxRepositoryConfiguration
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * Person Detail Database Module
 */
@Module
class PersonDetailDatabaseModule {

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

    /**
     * Provide Person Detail Entity Mapper
     */
    @Provides
    @PerFragment
    fun providePersonDetailEntityMapper() = PersonDetailEntityMapper()

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
    fun provideObjectBoxConfiguration() = ObjectBoxRepositoryConfiguration(MAX_OBJECTS_ALLOWED, OBJECTS_EXPIRE_IN_MILLIS)

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
        personDetailEntityMapper: PersonDetailEntityMapper,
        objectBoxConfiguration: ObjectBoxRepositoryConfiguration
    ): IPeopleDBRepository =
        PeopleObjectBoxRepositoryImpl(
            peopleDAO, personDetailEntityMapper, objectBoxConfiguration
        )


    companion object {

        private const val MAX_OBJECTS_ALLOWED = 10
        private const val OBJECTS_EXPIRE_IN_MILLIS = 86400000 // 24 hours

    }

}