package com.gronteza.memorich;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by tal on 4/30/2016.
 */
public class ImageCard extends Card {
    private MediaPlayer mediaPlayer;

    public ImageCard(Context context, int color, int X, int Y, int width, int height, String path) {
        super(context, color, X, Y, width, height);
        // TODO handle mediaPlayer
    }

    public ImageCard(Context context, String value1) {
        super(context);
        mediaPlayer = new MediaPlayer();
        // TODO set the value1 as path
    }
}
