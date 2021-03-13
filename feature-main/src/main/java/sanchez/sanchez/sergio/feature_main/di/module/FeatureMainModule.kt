package sanchez.sanchez.sergio.feature_main.di.module

import dagger.Module
import sanchez.sanchez.sergio.feature_main.di.module.core.DatabaseModule
import sanchez.sanchez.sergio.feature_main.di.module.core.NavigationModule

@Module(includes = [ DatabaseModule::class, NavigationModule::class ])
class FeatureMainModule