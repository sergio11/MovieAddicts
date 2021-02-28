package sanchez.sanchez.sergio.movie_addicts.core.di.component

import dagger.Component
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment

@PerFragment
@Component(
    dependencies = [ ActivityComponent::class ],
    modules = [ViewModelModule::class])
interface FragmentComponent {

}