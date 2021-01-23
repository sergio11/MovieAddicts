package sanchez.sanchez.sergio.test.core.di.component

import dagger.Component
import sanchez.sanchez.sergio.test.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.test.core.di.scope.PerFragment

@PerFragment
@Component(
    dependencies = [ ActivityComponent::class ],
    modules = [ViewModelModule::class])
interface FragmentComponent {

}