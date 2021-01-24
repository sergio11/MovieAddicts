package sanchez.sanchez.sergio.feature_main.di.module.person

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sanchez.sanchez.sergio.feature_main.ui.person.PersonListViewModel
import sanchez.sanchez.sergio.test.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.test.core.di.module.viewmodel.ViewModelKey
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

@Module(includes = [ ViewModelModule::class ])
abstract class PersonListViewModelModule {

    @PerFragment
    @Binds
    @IntoMap
    @ViewModelKey(PersonListViewModel::class)
    abstract fun bindsPersonListViewModel(personListViewModel: PersonListViewModel): ViewModel
}