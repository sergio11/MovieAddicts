package sanchez.sanchez.sergio.test.core.di.module.viewmodel

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * View Model Key
 */
@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class ViewModelKey(val value: KClass<out ViewModel>)