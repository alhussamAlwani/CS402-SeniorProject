package com.example.hussamalwani.tweets4news;

import android.os.Bundle;

import helper.SQLiteHandler;
import helper.SessionManager;
import io.fabric.sdk.android.Fabric;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class MainActivity extends Activity {

    private static final String TWITTER_KEY = "21wbxIeZwKwPy9Xi4Ul5M6BOg";
    private static final String TWITTER_SECRET = "O77msCvgPu5G2EyDhfxwrZ6JSkIA2uAT4txYMJpBPrDL8zHMTK";


    private TextView txtName;
    private TextView txtEmail;
    private Button btnLogout;
    private TwitterLoginButton loginButton;

    private SQLiteHandler db;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TEST
        //TextAnalyzer text = new TextAnalyzer();
        //String result = text.analyze();
        //Toast.makeText(this, result, Toast.LENGTH_LONG).show();

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.name);
        txtEmail = (TextView) findViewById(R.id.email);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);

        loginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
                String userName = result.data.getUserName();
                Toast.makeText(getApplicationContext(), userName, Toast.LENGTH_LONG).show();
                Log.d("login", userName);
                Intent in = new Intent(MainActivity.this, HomePage.class);
                startActivity(in);

            }

            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
                Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        // Fetching user details from sqlite
        HashMap<String, String> user = db.getUserDetails();

        String name = user.get("name");
        String email = user.get("email");

        // Displaying the user details on the screen
        txtName.setText(name);
        txtEmail.setText(email);

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });
    }

    @Override
    public void onStop() {
        super.onStop();
        SessionManager SM = new SessionManager(this);
        SM.setLogin(false);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "LogOut First Please..", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */

    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(MainActivity.this, activity.LoginActivity.class);
        startActivity(intent);
        finish();
    }
}