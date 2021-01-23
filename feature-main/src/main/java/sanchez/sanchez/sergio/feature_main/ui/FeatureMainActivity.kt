package sanchez.sanchez.sergio.feature_main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.di.FeatureMainComponent
import sanchez.sanchez.sergio.feature_main.di.FeatureMainComponentFactory
import sanchez.sanchez.sergio.test.core.utils.IApplicationAware
import timber.log.Timber
import javax.inject.Inject

class FeatureMainActivity : AppCompatActivity() {

    private val featureMainComponent: FeatureMainComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMainComponentFactory.getFeatureMainComponent(this)
    }

    @Inject
    lateinit var applicationAware: IApplicationAware

    @Inject
    lateinit var appCompatActivity: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        featureMainComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature_main)

        Timber.d("Feature Main: Component Name -> ${appCompatActivity.componentName}")
        Timber.d("Feature Main: App Id -> ${applicationAware.getApplicationId()}")

    }
}