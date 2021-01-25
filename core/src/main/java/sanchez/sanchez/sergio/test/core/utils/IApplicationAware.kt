package sanchez.sanchez.sergio.test.core.utils

interface IApplicationAware {

    fun getApplicationId(): String

    fun getBaseUrl(): String

    fun getApiKey(): String

}