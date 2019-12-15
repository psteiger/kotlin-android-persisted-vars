package com.freelapp.persistedvars

import androidx.preference.PreferenceManager
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

interface Persisted {
    fun Boolean(default: Boolean): VariableDelegate<Boolean>
    fun Int(default: Int): VariableDelegate<Int>
    fun String(default: String): VariableDelegate<String>
}

interface VariableDelegate<T> {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T)
}

class PersistedImpl: Persisted {

    override fun Boolean(default: Boolean): VariableDelegate<Boolean> =
        VariableDelegateImpl(Boolean::class, default)

    override fun Int(default: Int): VariableDelegate<Int> =
        VariableDelegateImpl(Int::class, default)

    override fun String(default: String): VariableDelegate<String> =
        VariableDelegateImpl(String::class, default)

    private val prefs =
        PreferenceManager.getDefaultSharedPreferences(App.instance.applicationContext)

    private val editor = prefs.edit()

    private val getters = mapOf(
        Int::class to prefs::getInt,
        Boolean::class to prefs::getBoolean,
        String::class to prefs::getString
    )

    private val setters = mapOf(
        Int::class to editor::putInt,
        Boolean::class to editor::putBoolean,
        String::class to editor::putString
    )

    private inner class VariableDelegateImpl<T : Any>(
        private val klass: KClass<T>,
        private val default: T
    ) : VariableDelegate<T> {

        override operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
            (getters.getValue(klass))(property.name, default) as T

        override operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            (setters.getValue(klass))(property.name, value).apply()
        }

    }

}
