package sanchez.sanchez.sergio.feature_main.di.module.person

import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_main.domain.model.Person
import sanchez.sanchez.sergio.feature_main.persistence.db.mapper.PersonEntityMapper
import sanchez.sanchez.sergio.feature_main.persistence.db.model.people.PersonEntity
import sanchez.sanchez.sergio.feature_main.persistence.db.model.people.PersonEntity_
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.mapper.IEntityToModelMapper
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.IDBRepository
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.objectbox.ObjectBoxRepositoryConfiguration
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.repository.objectbox.SupportObjectBoxRepositoryImpl

/**
 * People Database Module
 */
@Module
class PeopleDatabaseModule {

    /**
     * Provide Person Entity Mapper
     */
    @Provides
    @PerFragment
    fun providePersonEntityMapper(): IEntityToModelMapper<PersonEntity, Person> = PersonEntityMapper()

    /**
     * Provide Object Box Configuration
     */
    @Provides
    @PerFragment
    fun provideObjectBoxConfiguration(): ObjectBoxRepositoryConfiguration<PersonEntity>
        = ObjectBoxRepositoryConfiguration(
            maxObjectsAllowed = MAX_OBJECTS_ALLOWED,
            objectsExpireInMillis = OBJECTS_EXPIRE_IN_MILLIS,
            objectIdProperty = PersonEntity_.id,
            savedAtInMillisProperty = PersonEntity_.savedAtInMillis)

    /**
     * Provide People DAO
     * @param boxStore
     */
    @Provides
    @PerFragment
    fun providePeopleDAO(boxStore: BoxStore): Box<PersonEntity> =
        boxStore.boxFor(PersonEntity::class.java)

    /**
     * Provide People DB Repository
     * @param peopleDAO
     * @param personEntityMapper
     * @param objectBoxRepositoryConfiguration
     */
    @Provides
    @PerFragment
    fun providePeopleDBRepository(
        peopleDAO: Box<PersonEntity>,
        personEntityMapper: IEntityToModelMapper<PersonEntity, Person>,
        objectBoxRepositoryConfiguration: ObjectBoxRepositoryConfiguration<PersonEntity>
    ): IDBRepository<Person> =
        SupportObjectBoxRepositoryImpl(peopleDAO, personEntityMapper, objectBoxRepositoryConfiguration)

    companion object {
        private const val MAX_OBJECTS_ALLOWED = 20
        private const val OBJECTS_EXPIRE_IN_MILLIS = 86400000 // 24 hours
    }
}