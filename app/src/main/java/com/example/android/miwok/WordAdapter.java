package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Miwok Created by Muir on 03/05/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int mColorResourceId;

    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the @link WordAdapter object located at this position in the list.
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // Get the Miwok word from the current Word object and set this text on the Word TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version name
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        // Get the default word from the current Word object and set this text on the Word TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_item_icon);

        if(currentWord.hasImage()) {
            // Set the ImageView to the image resource specified in the current Word
            imageView.setImageResource(currentWord.getImageResourceId());

            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            // Otherwise hide the ImageView (setVisibility GONE)
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (contains 2 TextViews) so that it can be shown.
        return listItemView;
    }
}
