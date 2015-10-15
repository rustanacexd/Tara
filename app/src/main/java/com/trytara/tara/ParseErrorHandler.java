package com.trytara.tara;

import android.support.design.widget.Snackbar;
import android.util.Log;

import com.parse.ParseException;

public class ParseErrorHandler {

    private static final String TAG = "ParseErrorHandler";

    private static final int INVALID_SESSION_TOKEN = 209;
    private static final int USERNAME_TAKEN = 202;

    public static void handleParseError(ParseException e) {
        switch (e.getCode()) {
            case INVALID_SESSION_TOKEN:
                handleInvalidSessionToken();
                break;

            default:
                Log.d(TAG, e.getCode() + " " + e.getLocalizedMessage());

        }
    }



    private static void handleInvalidSessionToken() {
        //--------------------------------------
        // Option 1: Show a message asking the user to log out and log back in.
        //--------------------------------------
        // If the user needs to finish what they were doing, they have the opportunity to do so.
        //
        // new AlertDialog.Builder(getActivity())
        //   .setMessage("Session is no longer valid, please log out and log in again.")
        //   .setCancelable(false).setPositiveButton("OK", ...).create().show();

        //--------------------------------------
        // Option #2: Show login screen so user can re-authenticate.
        //--------------------------------------
        // You may want this if the logout button could be inaccessible in the UI.
        //

    }
}