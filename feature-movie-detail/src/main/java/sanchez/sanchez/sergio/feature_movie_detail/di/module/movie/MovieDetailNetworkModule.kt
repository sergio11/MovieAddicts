package sanchez.sanchez.sergio.feature_movie_detail.di.module.movie

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.mapper.MovieDetailNetworkMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.mapper.MovieKeywordNetworkMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.mapper.MovieReviewNetworkMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.mapper.MovieVideoNetworkMapper
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.repository.IMoviesNetworkRepository
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.repository.MoviesNetworkRepositoryImpl
import sanchez.sanchez.sergio.feature_movie_detail.persistence.network.service.MoviesService
import sanchez.sanchez.sergio.movie_addicts.core.di.scope.PerFragment

/**
 * Movie Detail Network Module
 */
@Module
class MovieDetailNetworkModule {

    /**
     * Provide Movies Service
     * @param retrofit
     */
    @Provides
    @PerFragment
    fun provideMoviesService(retrofit: Retrofit): MoviesService =
            retrofit.create(MoviesService::class.java)

    /**
     * Provide Movie Detail Network Mapper
     */
    @Provides
    @PerFragment
    fun privateMovieDetailNetworkMapper(): MovieDetailNetworkMapper = MovieDetailNetworkMapper()

    /**
     * Provide Movie Keyword Network Mapper
     */
    @Provides
    @PerFragment
    fun privateMovieKeywordNetworkMapper(): MovieKeywordNetworkMapper = MovieKeywordNetworkMapper()

    /**
     * Provide Movie Review Network Mapper
     */
    @Provides
    @PerFragment
    fun privateMovieReviewNetworkMapper(): MovieReviewNetworkMapper = MovieReviewNetworkMapper()

    /**
     * Provide Movie Video Network Mapper
     */
    @Provides
    @PerFragment
    fun privateMovieVideoNetworkMapper(): MovieVideoNetworkMapper = MovieVideoNetworkMapper()

    /**
     * Provide Movies Network Repository
     */
    @Provides
    @PerFragment
    fun provideMoviesNetworkRepository(
            moviesService: MoviesService,
            movieDetailNetworkMapper: MovieDetailNetworkMapper,
            movieKeywordNetworkMapper: MovieKeywordNetworkMapper,
            movieReviewNetworkMapper: MovieReviewNetworkMapper,
            movieVideoNetworkMapper: MovieVideoNetworkMapper
    ): IMoviesNetworkRepository = MoviesNetworkRepositoryImpl(
            movieDetailNetworkMapper, movieKeywordNetworkMapper,
            movieReviewNetworkMapper, movieVideoNetworkMapper,
            moviesService
    )

}