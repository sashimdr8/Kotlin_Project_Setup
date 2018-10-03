package com.noc.auth.login;

import android.text.TextUtils;
import android.util.Patterns;



public class Validator {
    public static final int MIN_LENGTH_PASSWORD = 4;
    public static final int MAX_LENGTH_PASSWORD = 50;
    private static final long MOBILE_NUMBER_MIN = 999999999;
    private static final long MOBILE_NUMBER_MAX = 100000000000L;
    private static final long PHONE_NUMBER_MIN = 99;

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        return !TextUtils.isEmpty(password)
                && password.length() >= MIN_LENGTH_PASSWORD
                && password.length() <= MAX_LENGTH_PASSWORD;
    }

    public static boolean isValidMobileNumber(String mobileNumber) {
        if (!TextUtils.isEmpty(mobileNumber) && mobileNumber.length() == 10) {
            try {
                long phoneNumber = Long.parseLong(mobileNumber);
                return phoneNumber > MOBILE_NUMBER_MIN && phoneNumber < MOBILE_NUMBER_MAX;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (!TextUtils.isEmpty(phoneNumber)) {
            try {
                long number = Long.parseLong(phoneNumber);
                return number > PHONE_NUMBER_MIN && number < MOBILE_NUMBER_MAX;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
}
