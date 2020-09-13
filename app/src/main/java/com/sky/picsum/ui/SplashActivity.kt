package com.sky.picsum.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.sky.picsum.R
import com.sky.picsum.ui.base.BaseActivity

/**
 * Splash Activity
 */
open class SplashActivity : BaseActivity() {
    var SPLASH_TIME_OUT = 5000;
    var handler: Handler = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        handler.postDelayed(Runnable() {

            var i = Intent(this@SplashActivity, MainActivity::class.java);
            startActivity(i);
            finish();

        }, SPLASH_TIME_OUT.toLong());
    }


}