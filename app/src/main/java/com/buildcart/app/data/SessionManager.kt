package com.buildcart.app.data

import android.content.Context
import android.content.SharedPreferences
import android.provider.ContactsContract.CommonDataKinds.Email
import android.system.Os.remove
import androidx.core.content.edit
import com.buildcart.app.R

/**
 * Session manager to save and fetch data from SharedPreferences
 */
class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name),
        Context.MODE_PRIVATE)


    private val sharedPreferences =
        context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    companion object {
        const val USER_TOKEN = "access_token"
        const val REFRESH_TOKEN = "refresh_token"
        const val USER_ID="user_id"
        const val FULL_NAME="full_name"
        const val EMAIL="email"
        const val MOBILE_NUMBER="phone_number"
        const val IMAGE="profile_image"
    }

    /**
     * Function to save auth token
     */

    fun saveProfilePicture(image:String){
        val editor=prefs.edit()
        editor.putString(IMAGE,image)
        editor.apply()
    }



    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    fun saveUserFullName(name:String){
        val editor = prefs.edit()
        editor.putString(FULL_NAME, name)
        editor.apply()
    }

    fun saveUserMobile(mobile:String){
        val editor = prefs.edit()
        editor.putString(MOBILE_NUMBER, mobile)
        editor.apply()
    }

    fun saveUserEmail(email:String){
        val editor = prefs.edit()
        editor.putString(EMAIL, email)
        editor.apply()
    }

    fun fetchUserFullName(): String? {
        return prefs.getString(FULL_NAME,null)
    }
    fun fetchUserMobileNumber(): String? {
        return prefs.getString(MOBILE_NUMBER,null)
    }
    fun fetchUserEmail(): String? {
        return prefs.getString(EMAIL,null)
    }
    fun clearTokens() {
        sharedPreferences.edit().remove(USER_TOKEN).remove(REFRESH_TOKEN).apply()
    }

    fun fetchProfileImage():String?{
        return prefs.getString(IMAGE,null)
    }

    fun saveUserId(userId: Int) {
        val editor = prefs.edit()
        editor.putInt(USER_ID, userId)
        editor.apply()
    }

    fun fetchUserID(): Int? {
        return prefs.getInt(USER_ID,-1)
    }
    fun saveRefreshToken(token: String) {
        val editor = prefs.edit()
        editor.putString(REFRESH_TOKEN, token)
        editor.apply()
    }

    /**
     * Function to fetch auth token
     */
    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN,null)
    }
    fun fetchRefreshToken(): String? {
        return prefs.getString(REFRESH_TOKEN,null)
    }


    fun logout() {
        prefs.edit().apply {
            remove(USER_TOKEN)
            remove(REFRESH_TOKEN)
            apply()
        }
    }

    fun clearSession() {
        sharedPreferences.edit().remove("access_token").apply()
    }


}