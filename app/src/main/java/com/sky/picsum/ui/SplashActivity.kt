package com.sky.picsum.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.sky.picsum.R

open class SplashActivity : BaseActivity() {
     var SPLASH_TIME_OUT = 5000;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
         Handler().postDelayed( Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */


                // This method will be executed once the timer is over
                // Start your app main activity
                var i =  Intent(this@SplashActivity, MainActivity::class.java);
                startActivity(i);

                // close this activity
                finish();

        }, SPLASH_TIME_OUT.toLong());
    }


}