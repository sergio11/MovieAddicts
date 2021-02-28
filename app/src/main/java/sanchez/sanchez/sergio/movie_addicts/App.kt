package sanchez.sanchez.sergio.movie_addicts

import com.facebook.stetho.Stetho
import sanchez.sanchez.sergio.movie_addicts.core.SupportApp
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
     * Get Base URL
     */
    override fun getBaseUrl(): String = BuildConfig.TMDB_BASE_URL

    /**
     * Get API Key
     */
    override fun getApiKey(): String = BuildConfig.TMDB_API_KEY

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