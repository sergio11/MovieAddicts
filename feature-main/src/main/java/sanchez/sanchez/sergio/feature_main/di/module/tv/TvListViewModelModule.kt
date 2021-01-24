package sanchez.sanchez.sergio.feature_main.di.module.tv

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sanchez.sanchez.sergio.feature_main.ui.tv.TvListViewModel
import sanchez.sanchez.sergio.test.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.test.core.di.module.viewmodel.ViewModelKey
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

@Module(includes = [ ViewModelModule::class ])
abstract class TvListViewModelModule {

    @PerFragment
    @Binds
    @IntoMap
    @ViewModelKey(TvListViewModel::class)
    abstract fun bindsTvListViewModel(tvListViewModel: TvListViewModel): ViewModel
}