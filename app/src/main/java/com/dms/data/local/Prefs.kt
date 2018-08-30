package com.dms.data.local

import android.content.Context
import android.preference.PreferenceManager
import com.google.gson.Gson
import android.content.SharedPreferences
import javax.inject.Singleton


@Singleton
class Prefs(private val app: Context, private val gson: Gson) {

    private val sharedPreferences: SharedPreferences

    private val fcmPrefs: SharedPreferences


    init {

        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)

        fcmPrefs = app.getSharedPreferences(SHARED_FCM_PREFERENCE, Context.MODE_PRIVATE)

    }

    companion object {


        private val SHARED_FCM_PREFERENCE = "FcmPreference"
    }

}