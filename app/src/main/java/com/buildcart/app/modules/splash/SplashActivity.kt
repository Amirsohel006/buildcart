package com.buildcart.app.modules.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import com.airbnb.lottie.LottieAnimationView
import me.grantland.widget.AutofitHelper
import me.grantland.widget.AutofitTextView
import androidx.appcompat.app.AppCompatActivity
import com.buildcart.app.R
import com.buildcart.app.modules.frame314.ui.Frame314Activity

class SplashActivity : AppCompatActivity() {

    private val texts = arrayOf("Loading...", "Please wait...", "Almost there...")
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)

        if (isFirstLaunch()) {
            // If it's the first launch, show screens 1, 2, and 3
            setupFirstLaunch()
        } else {
            // If not the first launch, redirect to Frame314Activity
            redirectToFrame314Activity()
        }
    }

    private fun isFirstLaunch(): Boolean {
        return sharedPreferences.getBoolean("isFirstLaunch", true)
    }

    private fun setupFirstLaunch() {
        // Make the status bar transparent
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        // Set the status bar color to white
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = getColor(android.R.color.white)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        setContentView(R.layout.activity_splash)

        val animationView = findViewById<LottieAnimationView>(R.id.animationView)
        val fadingTextView = findViewById<AutofitTextView>(R.id.fadingTextView)

        // Set initial text
        fadingTextView.text = "Welcome to Build Cart..."

        // Set the maximum text size programmatically
        val autofitHelper = AutofitHelper.create(fadingTextView)
        autofitHelper.maxTextSize = 24f // Replace 24f with your desired maximum text size
        autofitHelper.minTextSize = 12f

        // Start animation
        animationView.setAnimation(R.raw.loading_animation)
        animationView.playAnimation()

        // Simulate a delay before moving to the next screen
        Handler().postDelayed({
            // Move to the next activity and update text
            fadingTextView.text = texts[0]
            startActivity(Intent(this, SplashScreen1Activity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, 3000) // 3000 milliseconds (3 seconds) delay

        // Delay before moving to the next screen
        Handler().postDelayed({
            // Move to the next activity and update text
            fadingTextView.text = texts[1]
            startActivity(Intent(this, SplashScreen2Activity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }, 6000) // 6000 milliseconds (6 seconds) delay

        // Delay before moving to the next screen
        Handler().postDelayed({
            // Move to the next activity and update text
            fadingTextView.text = texts[2]
            startActivity(Intent(this, SplashScreen3Activity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            // Mark that the app has been launched once
            //markFirstLaunch()

            // Finish the SplashActivity after the last screen transition
            finish()
        }, 9000) // 9000 milliseconds (9 seconds) delay
    }

    private fun markFirstLaunch() {
        val editor = sharedPreferences.edit()
        editor.putBoolean("isFirstLaunch", false)
        editor.apply()
    }

    private fun redirectToFrame314Activity() {
        startActivity(Intent(this, Frame314Activity::class.java))
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}
