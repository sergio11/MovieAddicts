package sanchez.sanchez.sergio.movie_addicts.feature_login.di.module

import dagger.Module
import sanchez.sanchez.sergio.movie_addicts.feature_login.di.module.core.NavigationModule

@Module(includes = [ FacebookAuthModule::class, NavigationModule::class ] )
class FeatureLoginModule