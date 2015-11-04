package com.example.asingh.nflquiz;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 2016asingh on 10/29/2015.
 */
public class ScorePage extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        String username = extras.getString("USER_NAME");
        Integer newScore = extras.getInt("NEW_SCORE");
        Integer highScore = 0;
        TextView highScoreTextView = (TextView) findViewById(R.id.highScoreTextView);
//        highScoreTextView.setText("High Score: " + highScore);

        TextView currentScoreTextView = (TextView) findViewById(R.id.currentScoreTextView);
        currentScoreTextView.setText("Current High Score: " + newScore);

        if(newScore > highScore) {
            Toast.makeText(ScorePage.this, "You set a new High Score!", Toast.LENGTH_SHORT).show();
        }

    }
}
