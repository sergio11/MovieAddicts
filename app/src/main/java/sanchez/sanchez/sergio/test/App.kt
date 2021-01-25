package sanchez.sanchez.sergio.test

import com.facebook.stetho.Stetho
import sanchez.sanchez.sergio.test.core.SupportApp
import timber.log.Timber

class App: SupportApp() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            onDebugConfig()
        } else {
            onReleaseConfig()
        }
    }

    override fun getApplicationId(): String = BuildConfig.APPLICATION_ID
    override fun getBaseUrl(): String = BuildConfig.APPLICATION_ID
    override fun getApiKey(): String = BuildConfig.APPLICATION_ID

    /**
     * Private Methods
     */

    /**
     * On Debug Config
     */
    private fun onDebugConfig() {
        Stetho.initializeWithDefaults(this)
        Timber.plant(Timber.DebugTree())
    }

    /**
     * On Release Config
     */
    private fun onReleaseConfig(){}

}