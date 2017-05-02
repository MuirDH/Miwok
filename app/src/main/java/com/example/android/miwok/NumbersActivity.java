package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        // Find the root view of the layout
        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);

        // A variable which keeps track of the current index position
        int index = 0;

        // Create a new TextView that displays the number word at the index position and adds the
        // view as a child to the rootView until we get to the end of the ArrayList
        while (index < words.size()){

            TextView wordView = new TextView(this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);

            index++;

        }


    }

}
