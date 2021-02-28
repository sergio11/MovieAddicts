package sanchez.sanchez.sergio.movie_addicts.feature_login.ui

import sanchez.sanchez.sergio.movie_addicts.core.ui.SupportActivity
import sanchez.sanchez.sergio.movie_addicts.feature_login.R
import sanchez.sanchez.sergio.movie_addicts.feature_login.databinding.ActivityFeatureLoginBinding
import sanchez.sanchez.sergio.movie_addicts.feature_login.di.factory.FeatureLoginComponentFactory

class FeatureLoginActivity : SupportActivity<ActivityFeatureLoginBinding>() {

    override fun layoutId(): Int = R.layout.activity_feature_login

    override fun onAttachComponent() {
        FeatureLoginComponentFactory.getFeatureLoginComponent(this)
                .inject(this)
    }

    override fun onDetachComponent() {
        FeatureLoginComponentFactory.removeFeatureLoginComponent()
    }

    override fun initializeUI() {}

}