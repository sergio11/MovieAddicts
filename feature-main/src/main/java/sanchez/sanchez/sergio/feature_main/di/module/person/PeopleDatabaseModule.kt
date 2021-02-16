package sanchez.sanchez.sergio.feature_main.di.module.person

import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import sanchez.sanchez.sergio.feature_main.di.module.core.DatabaseModule
import sanchez.sanchez.sergio.feature_main.persistence.db.mapper.PersonEntityMapper
import sanchez.sanchez.sergio.feature_main.persistence.db.model.people.PersonEntity
import sanchez.sanchez.sergio.feature_main.persistence.db.repository.people.IPeopleDBRepository
import sanchez.sanchez.sergio.feature_main.persistence.db.repository.people.PeopleDBRepositoryImpl
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

/**
 * People Database Module
 */
@Module(includes = [ DatabaseModule::class ])
class PeopleDatabaseModule {

    /**
     * Provide Person Entity Mapper
     */
    @Provides
    @PerFragment
    fun providePersonEntityMapper() = PersonEntityMapper()

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
     */
    @Provides
    @PerFragment
    fun providePeopleDBRepository(
        peopleDAO: Box<PersonEntity>,
        personEntityMapper: PersonEntityMapper
    ): IPeopleDBRepository =
        PeopleDBRepositoryImpl(peopleDAO, personEntityMapper)

}