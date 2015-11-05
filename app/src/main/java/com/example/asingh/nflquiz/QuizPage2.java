package com.example.asingh.nflquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by 2016asingh on 11/4/2015.
 */
public class QuizPage2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_page2);

        Bundle extras = getIntent().getExtras();
        final String username = extras.getString("USER_NAME");
        final Integer newScore = extras.getInt("NEW_SCORE");

        Button answerButton1 = (Button) findViewById(R.id.answerButton1);
        answerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizPage2.this, "Incorrect", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), QuizPage3.class);
                i.putExtra("USER_NAME", username);
                i.putExtra("NEW_SCORE", newScore);
                startActivity(i);
            }
        });

        Button answerButton2 = (Button) findViewById(R.id.answerButton2);
        answerButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizPage2.this, "Correct", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), QuizPage3.class);
                i.putExtra("USER_NAME", username);
                i.putExtra("NEW_SCORE", newScore + 1);
                startActivity(i);
            }
        });

        Button answerButton3 = (Button) findViewById(R.id.answerButton2);
        answerButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizPage2.this, "Incorrect", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), QuizPage3.class);
                i.putExtra("USER_NAME", username);
                i.putExtra("NEW_SCORE", newScore);
                startActivity(i);
            }
        });

        Button answerButton4 = (Button) findViewById(R.id.answerButton4);
        answerButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizPage2.this, "Incorrect", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), QuizPage3.class);
                i.putExtra("USER_NAME", username);
                i.putExtra("NEW_SCORE", newScore);
                startActivity(i);
            }
        });
    }
}
