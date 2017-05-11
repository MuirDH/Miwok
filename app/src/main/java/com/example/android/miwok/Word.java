package com.example.android.miwok;

/**
 * Miwok Created by Muir on 03/05/2017.
 */

/**
 * @link Word represents a vocabulary word that the user wants to learn.
 * It contains a default translation and a Miwok translation for that word.
 */
public class Word {

    private static final int NO_IMAGE_PROVIDED = -1;
    // Default translation for the word
    private String mDefaultTranslation;
    // Miwok translation for the word
    private String mMiwokTranslation;
    // Image resource for each word
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    // Audio resource ID
    private int AudioResourceId;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     * @param miwokTranslation   is the word in the Miwok language
     */

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        AudioResourceId = audioResourceId;
    }

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     * @param miwokTranslation   is the word in the Miwok language
     * @param imageResourceId    is the image associated with the word
     * @param audioResourceId is the sound file associated with the word
     */

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        AudioResourceId = audioResourceId;

    }

    // get the Miwok translation of the word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    // Get the image of the word
    public int getImageResourceId() {
        return mImageResourceId;
    }

    // Get the sound of the word
    public int getAudioResourceId(){
        return AudioResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
