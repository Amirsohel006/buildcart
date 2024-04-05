package com.buildcart.app.modules.splash

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import com.buildcart.app.R
import com.buildcart.app.modules.frame314.ui.Frame314Activity

class SplashScreen2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Make the status bar transparent
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        // Set the status bar color to white
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = getColor(android.R.color.white)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        setContentView(R.layout.activity_splash_screen2)
        val nextButton=findViewById<Button>(R.id.nextButton)
        val skipButton=findViewById<AppCompatButton>(R.id.skipButton)

        // Customize this activity's layout and add any necessary code
        nextButton.setOnClickListener {
            val intent = Intent(this, SplashScreen3Activity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            finish()
        }

        // Set click listener for the Skip button
        skipButton.setOnClickListener {
            // Skip the animation and go directly to Frame314Activity
            startActivity(Intent(this, Frame314Activity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}