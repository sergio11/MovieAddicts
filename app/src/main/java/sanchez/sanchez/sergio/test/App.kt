package sanchez.sanchez.sergio.test

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

    /**
     * Private Methods
     */

    /**
     * On Debug Config
     */
    private fun onDebugConfig() {
        Timber.plant(Timber.DebugTree())
    }

    /**
     * On Release Config
     */
    private fun onReleaseConfig(){}

}