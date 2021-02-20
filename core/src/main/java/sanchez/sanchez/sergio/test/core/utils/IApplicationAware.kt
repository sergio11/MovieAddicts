package sanchez.sanchez.sergio.test.core.utils

interface IApplicationAware {

    /**
     * Get Application Id
     */
    fun getApplicationId(): String

    /**
     * Get Base URL
     */
    fun getBaseUrl(): String

    /**
     * Get API Key
     */
    fun getApiKey(): String

}