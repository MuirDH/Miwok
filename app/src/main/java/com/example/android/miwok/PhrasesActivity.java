package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Create an ArrayList containing the words for the Phrases
        final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes, I'm coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming.", "әәnәm", R.raw.phrase_im_coming));
        words.add(new Word("Let's go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

        /*
         Array adapter whose data source is a list of Strings. The list item layout, which is a
         resource defined in the Android framework, contains a single TextView which the adapter
         will set to display a single word.
         */
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

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

        // Set the listener on the listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                // Create an instance of MediaPlayer and cue the mp3
                mediaPlayer  = MediaPlayer.create(PhrasesActivity.this, word.getAudioResourceId());
                // play the sound file
                mediaPlayer.start();
            }
        });

    }

}
