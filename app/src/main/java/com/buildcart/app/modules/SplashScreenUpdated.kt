package com.buildcart.app.modules

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.buildcart.app.R
import com.buildcart.app.data.SessionManager
import com.buildcart.app.modules.frame314.ui.Frame314Activity
import com.buildcart.app.modules.homeonecontainer.ui.HomeOneContainerActivity

class SplashScreenUpdated : AppCompatActivity() {

    //var loginPageDisplayed = false

    private var loginPageDisplayed = false
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var imageView: ImageView
    private lateinit var indicator1: ImageView
    private lateinit var indicator2: ImageView
    private lateinit var indicator3: ImageView
    private lateinit var indicator4: ImageView
    private lateinit var indicator5: ImageView
    private lateinit var skipbutton: ImageView
    private lateinit var accessToken: String  // Declare accessToken here

    // Add more indicator ImageViews as needed

    private val imageArray = arrayOf(
        R.drawable.imag1,
        R.drawable.imag2,
        R.drawable.imag3,
        R.drawable.imag4

        // Add more image resources as needed
    )


    private lateinit var  sessionManager: SessionManager
    private var currentIndex = 0
    private val handler = Handler()
    private val imageChangeRunnable = object : Runnable {
        override fun run() {
            // Check if the login page has already been displayed
            if (!loginPageDisplayed) {
                // Update the ImageView with the next image
                imageView.setImageResource(imageArray[currentIndex])

                // Update the custom shape indicators
                updateIndicator(currentIndex)

                // Increment the index or reset it if it reaches the end
                currentIndex = (currentIndex + 1) % imageArray.size

                // Schedule the next image change after 3 seconds
                handler.postDelayed(this, 3000)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_updated)


        sessionManager=SessionManager(this)


        if (sessionManager.fetchAuthToken() != null && sessionManager.fetchRefreshToken() != null) {
            // User is already logged in, navigate to home
          navigateToNextPage()
            finish() // Finish the current activity to prevent the user from going back to the login screen
        }

        // Check the user's login status when the activity is first created
        sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
        accessToken = sharedPreferences.getString("token", "") ?: ""

        // If the user is already logged in, navigate to the next activity immediately
        if (!accessToken.isEmpty()) {
            navigateToNextPage()
            return // Exit the onCreate method to prevent splash screen animations
        }

        imageView = findViewById(R.id.imageView)

        // Initialize the indicator ImageViews
        indicator1 = findViewById(R.id.indicator1)
        indicator2 = findViewById(R.id.indicator2)
        indicator3 = findViewById(R.id.indicator3)
        indicator4 = findViewById(R.id.indicator4)
        indicator5 = findViewById(R.id.indicator5)
        // Initialize more indicator ImageViews as needed



        // Define a handler outside of onCreate
        val handler = Handler()

        // Start the image change process
        handler.post(imageChangeRunnable)

        // After a certain duration (e.g., 3 seconds), navigate to the next activity
        val delayedIntent = Intent(this, Frame314Activity::class.java)
        var loginPageDisplayed = false

        skipbutton = findViewById(R.id.skipbutton)
        skipbutton.setOnClickListener {
            // Check if the login page has already been displayed
            if (!loginPageDisplayed) {
                // Cancel the delayed intent if the skip button is clicked
                handler.removeCallbacksAndMessages(null)

                if (accessToken.isEmpty()) {
                    // User is not logged in, navigate to the login page
                    val intent = Intent(this, Frame314Activity::class.java)
                    startActivity(intent)
                    finishAffinity()
                } else {
                    // User is already logged in, navigate to the home container activity
                    navigateToNextPage()
                }

                // Set the flag to true to indicate login page has been displayed
                loginPageDisplayed = true
            }
        }


        // Change the status bar color to transparent
        window.statusBarColor = Color.TRANSPARENT
    }



    private fun navigateToNextPage() {
        val intent = HomeOneContainerActivity.getIntent(this, null)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finishAffinity()
    }

    private fun updateIndicator(currentIndex: Int) {
        // Reset all indicators to unselected state
        indicator1.setImageResource(R.drawable.indicator_unselected)
        indicator2.setImageResource(R.drawable.indicator_unselected)
        indicator3.setImageResource(R.drawable.indicator_unselected)
        indicator4.setImageResource(R.drawable.indicator_unselected)
        indicator5.setImageResource(R.drawable.indicator_unselected)
        // Update more indicators as needed

        // Set the selected indicator based on the current index
        when (currentIndex) {
            0 -> indicator1.setImageResource(R.drawable.indicator_selected)
            1 -> indicator2.setImageResource(R.drawable.indicator_selected)
            2 -> indicator3.setImageResource(R.drawable.indicator_selected)
            3 -> indicator4.setImageResource(R.drawable.indicator_selected)
            4 -> indicator5.setImageResource(R.drawable.indicator_selected)
            // Update more indicators as needed
        }
    }
}
