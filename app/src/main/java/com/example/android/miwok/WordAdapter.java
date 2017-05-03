package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Miwok Created by Muir on 03/05/2017.
 */

public class WordAdapter extends ArrayAdapter<Word>{

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    public WordAdapter(Activity context, ArrayList<Word> words){
        super(context, 0, words);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwokWordTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokWordTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultWordTextview = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultWordTextview.setText(currentWord.getDefaultTranslation());

        //ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        //iconView.setImageResource(currentWord.getImageResourceId());
        return listItemView;
    }
}
