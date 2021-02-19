package sanchez.sanchez.sergio.feature_main.di.module

import dagger.Module
import sanchez.sanchez.sergio.feature_main.di.module.core.DatabaseModule

@Module(includes = [ DatabaseModule::class ])
class FeatureMainModule {}