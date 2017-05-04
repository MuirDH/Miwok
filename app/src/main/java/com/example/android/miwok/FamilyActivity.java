package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Create an ArrayList containing the words for the Family Members
        ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("father", "әpә"));
        words.add(new Word("mother", "әṭa"));
        words.add(new Word("son", "angsi"));
        words.add(new Word("daughter", "tune"));
        words.add(new Word("older brother", "taachi"));
        words.add(new Word("younger brother", "chalitti"));
        words.add(new Word("older sister", "teṭe"));
        words.add(new Word("younger sister", "kolliti"));
        words.add(new Word("grandmother", "ama"));
        words.add(new Word("grandfather", "paapa"));

        /*
         Array adapter whose data source is a list of Strings. The list item layout, which is a
         resource defined in the Android framework, contains a single TextView which the adapter
         will set to display a single word.
         */
        WordAdapter adapter = new WordAdapter(this, words);

        /*
         Find the ListView object in the view hierarchy of the Activity.
         */
        ListView listView = (ListView) findViewById(R.id.list);

        /*
         Make the ListView use the ArrayAdapter we created above, so that the ListView will display
         list items for each word in the list of words. This is done by calling the setAdapter
         method on the Listview object and passing in 1 argument, which is the ArrayAdapter with the
         variable name itemsAdapter.
         */
        listView.setAdapter(adapter);

    }

}
