package com.example.viewpager.Utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast

fun checkForInternet(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val network = connectivityManager.activeNetwork ?: return false
        val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
        return when {
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            else -> false
        }
    } else {
        @Suppress("DEPRECATION") val networkInfo = connectivityManager.activeNetworkInfo ?: return false
        @Suppress("DEPRECATION")
        return networkInfo.isConnected
    }
}

fun validatePhoneNumber(context: Context, phoneNumber : EditText): Boolean{
    if (TextUtils.isEmpty(phoneNumber.text.toString())){
        Toast.makeText(context, "Please enter phone number", Toast.LENGTH_SHORT).show()
        return false
    }
    else if(phoneNumber.text.length < 10){
        Toast.makeText(context, "Please enter valid phone number", Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

fun validateOTP(context: Context, otpDigit1 : EditText, otpDigit2 : EditText, otpDigit3 : EditText, otpDigit4 : EditText, otpDigit5 : EditText, otpDigit6 : EditText): Boolean{
    if (TextUtils.isEmpty(otpDigit1.text.toString()) || TextUtils.isEmpty(otpDigit2.text.toString()) || TextUtils.isEmpty(otpDigit3.text.toString()) || TextUtils.isEmpty(otpDigit4.text.toString()) || TextUtils.isEmpty(otpDigit5.text.toString()) || TextUtils.isEmpty(otpDigit6.text.toString())){
        Toast.makeText(context, "Please enter correct OTP", Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}


