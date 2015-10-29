package com.example.asingh.nflquiz;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by 2016asingh on 10/29/2015.
 */
public class ScorePage extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        String username = extras.getString("USER_NAME");
        Integer curHighScore = extras.getInt("CURRENT_HIGH_SCORE");


    }
}
