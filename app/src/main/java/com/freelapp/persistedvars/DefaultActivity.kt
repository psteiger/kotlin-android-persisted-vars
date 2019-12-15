package com.freelapp.persistedvars

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.freelapp.persistedvars.App.Companion.persisted
import kotlinx.android.synthetic.main.default_activity.*

class DefaultActivity : AppCompatActivity() {

    var timesStarted by persisted.Int(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.default_activity)
        timesStarted++
        times_started_value.text = timesStarted.toString()
        Log.d("PersistedDebug", "timesStarted: $timesStarted")
    }
}