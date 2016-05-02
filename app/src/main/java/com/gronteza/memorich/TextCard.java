package com.gronteza.memorich;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by tal on 4/30/2016.
 */
public class TextCard extends Card {
    private TextView textView;

    public TextCard(Context context, int color, int X, int Y, int width, int height, String text) {
        super(context, color, X, Y, width, height);
        textView.setText(text);
    }

    public TextCard(Context context, String text) {
        super(context);
        textView = new TextView(context);
        textView.setText(text);
    }
}
