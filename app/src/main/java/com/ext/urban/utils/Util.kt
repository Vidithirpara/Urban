package com.example.viewpager.Utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.text.TextUtils
import android.util.Patterns
import android.widget.EditText
import android.widget.TextView
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


fun validateFirstNameORLastName(context: Context, firstName : EditText, lastName : EditText) : Boolean{
    if (TextUtils.isEmpty(firstName.text)) {
        Toast.makeText(context, "Enter First Name", Toast.LENGTH_SHORT).show()
        return false
    } else if (TextUtils.isEmpty(lastName.text)) {
        Toast.makeText(context, "Enter Last Name", Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

fun validateEmailAddress(context: Context, emailAddress : EditText) : Boolean{
    if (TextUtils.isEmpty(emailAddress.text)){
        Toast.makeText(context, "Email address not empty", Toast.LENGTH_SHORT).show()
        return false
    }
    else if(!Patterns.EMAIL_ADDRESS.matcher(emailAddress.getText().toString()).matches()){
        Toast.makeText(context, "Enter valid email address", Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

fun validateAadharNumber(context: Context, aadharNumber : EditText) : Boolean{
    if (TextUtils.isEmpty(aadharNumber.text)){
        Toast.makeText(context, "Aadhar number not empty", Toast.LENGTH_SHORT).show()
        return false
    }
    else if(aadharNumber.text.length < 12){
        Toast.makeText(context, "Enter valid aadhar number", Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

fun validateBirthDate(context: Context, birthDate : TextView) : Boolean{
    if (birthDate.text == "Select date"){
        Toast.makeText(context, "Please select birth date", Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

fun validateGenderAndCategory(context: Context, gender : TextView, category : TextView) : Boolean{
    if (gender.text == "-Select one-") {
        Toast.makeText(context, "Please select gender", Toast.LENGTH_SHORT).show()
        return false
    } else if (category.text == "-Select one-") {
        Toast.makeText(context, "Please select category", Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

fun validateFatherNameORMotherName(context: Context, fatherName : EditText, motherName : EditText) : Boolean{
    if (TextUtils.isEmpty(fatherName.text)) {
        Toast.makeText(context, "Enter Father Name", Toast.LENGTH_SHORT).show()
        return false
    } else if (TextUtils.isEmpty(motherName.text)) {
        Toast.makeText(context, "Enter Mother Name", Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

fun validateAddress(context: Context, address : EditText) : Boolean{
    if (TextUtils.isEmpty(address.text)) {
        Toast.makeText(context, "Address is not empty", Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

fun validateStateAndCity(context: Context, state : TextView, city : TextView) : Boolean{
    if (state.text == "-Select one-") {
        Toast.makeText(context, "Please select state", Toast.LENGTH_SHORT).show()
        return false
    } else if (city.text == "-Select one-") {
        Toast.makeText(context, "Please select city", Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}

fun validatePincode(context: Context, pinCode : EditText) : Boolean{
    if (TextUtils.isEmpty(pinCode.text)){
        Toast.makeText(context, "Pincode not empty", Toast.LENGTH_SHORT).show()
        return false
    }
    else if(pinCode.text.length < 6){
        Toast.makeText(context, "Enter valid pincode", Toast.LENGTH_SHORT).show()
        return false
    }
    return true
}
