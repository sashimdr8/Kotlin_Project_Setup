package com.dms.data

import com.dms.data.local.LocalRepo
import com.dms.data.remote.RemoteRepo
import javax.inject.Inject

/**
 * Created by brain on 12/5/17.
 */
class AppData @Inject
internal constructor(private val localRepo: LocalRepo,
                     private val remoteRepo: RemoteRepo) {


    }