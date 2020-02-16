/*
 * @author   Anoop Maddasseri <anoopmaddasseri@gmail.com>
 * @version  1
 * @since    16th Feb 2020
 *
 * P.S. Increment version when editing
 */
package com.gojek.trendingrepos.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass]!!
        @Suppress("UNCHECKED_CAST")
        return creator.get() as T
    }
}
