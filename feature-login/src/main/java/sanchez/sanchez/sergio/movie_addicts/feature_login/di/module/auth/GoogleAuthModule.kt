package sanchez.sanchez.sergio.movie_addicts.feature_login.di.module.auth

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerActivity
import sanchez.sanchez.sergio.movie_addicts.feature_login.R

@Module
class GoogleAuthModule {

    /**
     * Provide Google Sign In Options
     */
    @Provides
    @PerActivity
    fun provideGoogleSignInOptions(context: Context): GoogleSignInOptions =
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(R.string.google_client_id))
            .requestEmail()
            .build()

    /**
     * Provide Google SignIn Client
     * @param activity
     * @param gso
     */
    @Provides
    @PerActivity
    fun provideGoogleSignInClient(
        activity: AppCompatActivity,
        gso: GoogleSignInOptions): GoogleSignInClient =
        GoogleSignIn.getClient(activity, gso)
}