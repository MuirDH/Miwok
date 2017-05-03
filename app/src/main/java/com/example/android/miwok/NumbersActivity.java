package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        /*
         Array adapter whose data source is a list of Strings. The list item layout, which is a
         resource defined in the Android framework, contains a single TextView which the adapter
         will set to display a single word.
         */
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, words);

        /*
         Find the ListView object in the view hierarchy of the Activity.
         */
        ListView listView = (ListView) findViewById(R.id.list);

        /*
         Make the ListView use the ArrayAdapter we created above, so that the ListView will display
         list items for each word in the list of words. This is done by calling the setAdapter
         method on the Listview object and passing in 1 argument, whichis the ArrayAdapter with the
         variable name itemsAdapter.
         */
        listView.setAdapter(itemsAdapter);


    }

}
