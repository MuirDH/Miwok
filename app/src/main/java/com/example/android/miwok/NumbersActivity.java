package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Create a String array with 10 indices containing the words for the numbers 1-10
        String words[] = new String[10];
        words[0] = "one";
        words[1] = "two";
        words[2] = "three";
        words[3] = "four";
        words[4] = "five";
        words[5] = "six";
        words[6] = "seven";
        words[7] = "eight";
        words[8] = "nine";
        words[9] = "ten";

        // Log messages to check that the array has been initialised correctly
        Log.v("NumbersActivity", "Word at index 0: " + words[0]);
        Log.v("NumbersActivity", "Word at index 1: " + words[1]);
        Log.v("NumbersActivity", "Word at index 1: " + words[2]);
        Log.v("NumbersActivity", "Word at index 1: " + words[3]);
        Log.v("NumbersActivity", "Word at index 1: " + words[4]);
        Log.v("NumbersActivity", "Word at index 1: " + words[5]);
        Log.v("NumbersActivity", "Word at index 1: " + words[6]);
        Log.v("NumbersActivity", "Word at index 1: " + words[7]);
        Log.v("NumbersActivity", "Word at index 1: " + words[8]);
        Log.v("NumbersActivity", "Word at index 1: " + words[9]);

    }

}
