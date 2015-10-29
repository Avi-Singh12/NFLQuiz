package com.example.asingh.nflquiz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by 2016asingh on 10/26/2015.
 */
public class WelcomePage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        String username = extras.getString("USER_NAME");

        TextView welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        welcomeTextView.setText("Welcome: " + username);
    }
}
