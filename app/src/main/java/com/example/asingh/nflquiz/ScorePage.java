package com.example.asingh.nflquiz;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 2016asingh on 10/29/2015.
 */
public class ScorePage extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_page);

        Bundle extras = getIntent().getExtras();
        final String username = extras.getString("USER_NAME");
        final Integer newScore = extras.getInt("NEW_SCORE");
        Integer highScore = extras.getInt("HIGH_SCORE");

        if(newScore > highScore) {
            Toast.makeText(ScorePage.this, "You set a new High Score!", Toast.LENGTH_SHORT).show();
            highScore = newScore;
        }

        TextView highScoreTextView = (TextView) findViewById(R.id.highScoreTextView);
        highScoreTextView.setText("High Score: " + highScore);

        TextView currentScoreTextView = (TextView) findViewById(R.id.currentScoreTextView);
        currentScoreTextView.setText("Current Score: " + newScore);

        SharedPreferences scoreSP = getApplicationContext().getSharedPreferences("ScoreSP", 0);
        final SharedPreferences.Editor editor = scoreSP.edit();
        editor.putInt("highScore", highScore);
        editor.commit();

        Button homePageButton = (Button) findViewById(R.id.homePageButton);
        final Integer finalHighScore = highScore;
        homePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), WelcomePage.class);
                i.putExtra("USER_NAME", username);
                i.putExtra("HIGH_SCORE", finalHighScore);
                startActivity(i);
            }
        });
    }
}
