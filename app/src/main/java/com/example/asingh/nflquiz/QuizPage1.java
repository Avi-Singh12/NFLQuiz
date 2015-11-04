package com.example.asingh.nflquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by 2016asingh on 11/4/2015.
 */
public class QuizPage1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        final String username = extras.getString("USER_NAME");
        final Integer newScore = extras.getInt("NEW_SCORE");

        Intent i = new Intent(getApplicationContext(), QuizPage2.class);
        i.putExtra("USER_NAME", username);
        i.putExtra("NEW_SCORE", newScore);

        Button answerButton1 = (Button) findViewById(R.id.answerButton1);
        answerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
