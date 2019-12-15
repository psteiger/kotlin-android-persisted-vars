package com.freelapp.persistedvars

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.freelapp.persistedvars.App.Companion.persisted
import kotlinx.android.synthetic.main.default_activity.*

class DefaultActivity : AppCompatActivity() {

    /**
     * This var will be backed by SharedPreferences. The value will be persisted on disk and will
     * survive app restarts. In this example '0' is the initial/default value. In the
     * SharedPreferences file, the key name will be the var name: { 'timesStarted' : 0 }
     */
    var timesStarted by persisted.Int(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.default_activity)

        // Will read from and write to SharedPreferences
        timesStarted++

        // Verify it worked. Will read from SharedPreferences.
        times_started_value.text = timesStarted.toString()
        Log.d("PersistedDebug", "timesStarted: $timesStarted")
    }
}