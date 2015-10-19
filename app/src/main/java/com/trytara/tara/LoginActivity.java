package com.trytara.tara;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.json.JSONObject;

import java.util.Arrays;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LogInActivity";

    private static final int REQUEST_SIGNUP = 344;

    // UI references.
    private EditText mUsernameView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        ImageView loginButton = (ImageView) findViewById(R.id.facebook_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showProgress(true);
                ParseFacebookUtils.logInWithReadPermissionsInBackground(LoginActivity.this,
                        Arrays.asList("user_location, email, user_birthday"), new LogInCallback() {
                            @Override
                            public void done(ParseUser parseUser, ParseException e) {
                                if (parseUser == null) {
                                } else if (parseUser.isNew()) {
                                    getFacebookInfo();
                                } else {
                                    Log.d(TAG, "CURRENT USER: " + parseUser.toString());
                                }
                            }

                        });
            }
        });


        TextView signUp = (TextView) findViewById(R.id.signup);
        signUp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivityForResult(i, REQUEST_SIGNUP);
            }
        });

        // Set up the login form.
        mUsernameView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);


        Button mEmailSignInButton = (Button) findViewById(R.id.username_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        showProgress(false);
        ParseFacebookUtils.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) return;
        finish();
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {

        // Reset errors.
        mUsernameView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String username = mUsernameView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(username)) {
            mUsernameView.setError(getString(R.string.error_field_required));
            focusView = mUsernameView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);

            ParseUser.logInInBackground(username, password, new LogInCallback() {
                public void done(ParseUser user, ParseException e) {
                    if (user != null) {
                        finish();
                    } else {
                        Snackbar.make(findViewById(android.R.id.content), e.getLocalizedMessage(), Snackbar.LENGTH_LONG)
                                .setAction("Ok", null)
                                .show();

                        ParseErrorHandler.handleParseError(e);
                    }
                    showProgress(false);
                }
            });

        }
    }


    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });


            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }


    private void getFacebookInfo() {
        Bundle parameters = new Bundle();
        parameters.putString("fields", "name, id, email, location");
        new GraphRequest(AccessToken.getCurrentAccessToken(),
                "/me", parameters, HttpMethod.GET, new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse response) {

                JSONObject user = response.getJSONObject();
                Log.d(TAG, "RESPONSE OBJECT: " + user);

                ParseUser currentUser = ParseUser.getCurrentUser();
                currentUser.put("name", user.optString("name"));
                currentUser.setEmail(user.optString("email"));
                currentUser.put("facebookID", user.optString("id"));
                currentUser.put("address", user.optJSONObject("location").optString("name"));

                currentUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {

                    }
                });
            }
        }).executeAsync();

    }
}

