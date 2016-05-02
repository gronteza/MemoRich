package com.gronteza.memorich;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundCard extends Card {
    MediaPlayer sound;
    public SoundCard(Context context, String value1) {
        super(context);
        sound=new MediaPlayer();
        // TODO handle sound string
    }
}
