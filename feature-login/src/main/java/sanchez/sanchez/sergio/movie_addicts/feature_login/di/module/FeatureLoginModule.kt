package sanchez.sanchez.sergio.movie_addicts.feature_login.di.module

import dagger.Module
import sanchez.sanchez.sergio.movie_addicts.feature_login.di.module.auth.FacebookAuthModule
import sanchez.sanchez.sergio.movie_addicts.feature_login.di.module.auth.GoogleAuthModule
import sanchez.sanchez.sergio.movie_addicts.feature_login.di.module.core.NavigationModule

@Module(includes = [
    FacebookAuthModule::class,
    GoogleAuthModule::class,
    NavigationModule::class ] )
class FeatureLoginModule