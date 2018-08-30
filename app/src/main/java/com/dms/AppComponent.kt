package com.dms

import android.content.Context
import com.dms.data.AppData
import com.dms.main.BaseActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by brain on 12/5/17.
 */

@Component(modules = arrayOf(AppModule::class, DataModule::class))
@Singleton
interface AppComponent {

    fun context(): Context

//    fun buildType(): BuildTypeComponent

    fun data(): AppData

    fun inject(baseActivity: BaseActivity)

    fun inject(baseFragment: BaseFragment)
}