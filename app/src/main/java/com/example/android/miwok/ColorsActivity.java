package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Create an ArrayList containing the words for the colours
       final ArrayList<Word> words = new ArrayList<>();

        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        /*
         Array adapter whose data source is a list of Strings. The list item layout, which is a
         resource defined in the Android framework, contains a single TextView which the adapter
         will set to display a single word.
         */
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

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

                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

                Log.v("ColorsActivity", "Current word: " + word);

                // Create an instance of MediaPlayer and cue the mp3
                mediaPlayer  = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
                // play the sound file
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(completionListener);
            }
        });


    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;

            Log.v("ColorsActivity", "MediaPlayer has been released");
        }
    }

}
