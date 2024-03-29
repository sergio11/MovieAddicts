package sanchez.sanchez.sergio.movie_addicts.core.di.component

import android.content.Context
import dagger.Component
import retrofit2.Retrofit
import sanchez.sanchez.sergio.movie_addicts.core.auth.IAuthManager
import sanchez.sanchez.sergio.movie_addicts.core.di.module.ApplicationModule
import sanchez.sanchez.sergio.movie_addicts.core.di.module.auth.AuthModule
import sanchez.sanchez.sergio.movie_addicts.core.di.module.db.DatabaseModule
import sanchez.sanchez.sergio.movie_addicts.core.di.module.network.MovieFavoriteModule
import sanchez.sanchez.sergio.movie_addicts.core.di.module.network.NetworkModule
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerApplication
import sanchez.sanchez.sergio.movie_addicts.core.persistence.db.ObjectBoxManager
import sanchez.sanchez.sergio.movie_addicts.core.persistence.network.service.IMovieFavoriteService
import sanchez.sanchez.sergio.movie_addicts.core.utils.IApplicationAware

/**
 * A component whose lifetime is the life of the application.
 */
@PerApplication
@Component(modules = [
    ApplicationModule::class, NetworkModule::class,
    DatabaseModule::class, AuthModule::class, MovieFavoriteModule::class ])
interface ApplicationComponent {

    //Exposed to sub-graphs.
    fun context(): Context
    fun applicationAware(): IApplicationAware
    fun retrofit(): Retrofit
    fun objectBoxManager(): ObjectBoxManager
    fun authManager(): IAuthManager
    fun movieFavoriteService(): IMovieFavoriteService
}