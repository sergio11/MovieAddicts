package sanchez.sanchez.sergio.movie_addicts.core.persistence.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response
import sanchez.sanchez.sergio.movie_addicts.core.utils.IApplicationAware

/**
 * Auth Interceptor
 *
 */
class AuthInterceptor(
        private val applicationAware: IApplicationAware
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val urlWithApiKey = originalRequest.url()
                .newBuilder()
                .addQueryParameter(API_KEY_KEY_PARAM_NAME, applicationAware.getApiKey())
                .build()
        val requestWithApiKeyQueryParam = originalRequest.newBuilder()
                .url(urlWithApiKey)
                .build()
        return chain.proceed(requestWithApiKeyQueryParam)
    }

    companion object {

        /**
         * API Key Param Name
         */
        private const val API_KEY_KEY_PARAM_NAME = "api_key"
    }
}