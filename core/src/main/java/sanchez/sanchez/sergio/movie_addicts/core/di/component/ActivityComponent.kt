package sanchez.sanchez.sergio.movie_addicts.core.di.component

import dagger.Component
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ActivityModule
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ViewModelModule
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerActivity

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 */
@PerActivity
@Component(
    dependencies = [ ApplicationComponent::class ],
    modules = [ ActivityModule::class, ViewModelModule::class ] )
interface ActivityComponent {

    //Exposed to sub-graphs.
    fun context(): Context

    fun activity(): AppCompatActivity
}