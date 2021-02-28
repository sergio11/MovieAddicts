package sanchez.sanchez.sergio.feature_tv_detail.di.module.tv

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import sanchez.sanchez.sergio.feature_tv_detail.ui.tv.TvDetailViewModel
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.movie_addicts.core.di.module.viewmodel.ViewModelKey

/**
 * Tv Detail View Model Module
 */
@Module(includes = [ ViewModelModule::class ])
abstract class TvDetailViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TvDetailViewModel::class)
    abstract fun bindsTvDetailViewModel(viewModel: TvDetailViewModel): ViewModel
}