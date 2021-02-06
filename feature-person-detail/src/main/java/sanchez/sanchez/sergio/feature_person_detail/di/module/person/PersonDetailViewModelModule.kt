package sanchez.sanchez.sergio.feature_person_detail.di.module.person

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sanchez.sanchez.sergio.feature_person_detail.ui.person.PersonDetailViewModel
import sanchez.sanchez.sergio.test.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.test.core.di.module.viewmodel.ViewModelKey

/**
 * Person Detail View Model Module
 */
@Module(includes = [ ViewModelModule::class ])
abstract class PersonDetailViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PersonDetailViewModel::class)
    abstract fun bindsPersonDetailViewModel(viewModel: PersonDetailViewModel): ViewModel
}