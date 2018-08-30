package com.dms.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.dms.databinding.ActivityMainBinding
import com.dms.R

/**
 * Created by brain on 12/5/17.
 */
class MainActivity : BaseActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main)

    }


}