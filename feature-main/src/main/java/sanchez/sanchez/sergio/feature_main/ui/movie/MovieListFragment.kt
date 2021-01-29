package sanchez.sanchez.sergio.feature_main.ui.movie

import androidx.appcompat.app.AppCompatActivity
import sanchez.sanchez.sergio.feature_main.R
import sanchez.sanchez.sergio.feature_main.databinding.FragmentMovieListBinding
import sanchez.sanchez.sergio.feature_main.di.component.MovieListComponent
import sanchez.sanchez.sergio.feature_main.di.factory.FeatureMainComponentFactory
import sanchez.sanchez.sergio.test.core.ui.SupportFragment

class MovieListFragment : SupportFragment<MovieListViewModel, FragmentMovieListBinding>(MovieListViewModel::class.java) {

    private val component: MovieListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        FeatureMainComponentFactory.getMovieListComponent(requireActivity() as AppCompatActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_movie_list

    override fun onInject() {
        component.inject(this)
    }
}