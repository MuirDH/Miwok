package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.rootView;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find the root view of the layout
        LinearLayout foundRootView = (LinearLayout)findViewById(rootView);
        printNumbers(foundRootView);

    }

    private void printNumbers (LinearLayout rootView){

        //Create an ArrayList containing the words for the numbers 1-10
        ArrayList<String> words = new ArrayList<>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");
        // loops until we get to the end of the ArrayList
        for (int index = 0; index < words.size(); index++){

            // Create a new TextView
            TextView wordView = new TextView(this);

            // Set the text to be the number word at the current index
            wordView.setText(words.get(index));

            // Add this view as another child to the root view of this layout
            rootView.addView(wordView);
        }
    }



}
