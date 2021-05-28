package com.sobarna.success.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sobarna.success.core.domain.usecase.MovieUseCase
import com.sobarna.success.di.AppScope
import com.sobarna.success.viewmodel.DetailViewModel
import com.sobarna.success.viewmodel.FavoriteViewModel
import com.sobarna.success.viewmodel.HomeViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider


@AppScope
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        return creator.get() as T
    }


}