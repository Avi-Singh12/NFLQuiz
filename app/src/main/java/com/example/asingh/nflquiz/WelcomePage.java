package com.example.asingh.nflquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 2016asingh on 10/26/2015.
 */
public class WelcomePage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);

        Bundle extras = getIntent().getExtras();
        final String username = extras.getString("USER_NAME");
        final Integer highScore = extras.getInt("HIGH_SCORE");

        final Integer newScore = 0;

        TextView welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        welcomeTextView.setText("Welcome: " + username);

        TextView currentHighScoreTextView = (TextView) findViewById(R.id.currentHighScoreTextView);
        currentHighScoreTextView.setText("Current High Score:" + highScore);

        Button beginQuizButton = (Button) findViewById(R.id.beginQuizButton);
        beginQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), QuizPage1.class);
                i.putExtra("USER_NAME", username);
                i.putExtra("NEW_SCORE", newScore);
                i.putExtra("HIGH_SCORE", highScore);
                startActivity(i);
            }
        });

        Button logoutButton = (Button) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
