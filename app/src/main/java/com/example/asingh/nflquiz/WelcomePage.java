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

        Bundle extras = getIntent().getExtras();
        final String username = extras.getString("USER_NAME");

        final Integer newScore = 0;

        TextView welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        welcomeTextView.setText("Welcome: " + username);

        TextView currentScoreTextView = (TextView) findViewById(R.id.currentScoreTextView);

        Button beginQuizButton = (Button) findViewById(R.id.beginQuizButton);
        beginQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), QuizPage1.class);
                i.putExtra("USER_NAME", username);
                i.putExtra("NEW_SCORE", newScore);
                startActivity(i);
            }
        });
    }
}
