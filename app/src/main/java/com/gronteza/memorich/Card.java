package com.gronteza.memorich;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class Card extends ImageView{
    Card equivalent;

    public Card(Context context, int color, int X, int Y, int width, int height){
        super(context);
        this.setBackgroundColor(color);
        this.setX(X);
        this.setY(Y);
        this.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
    }

    public void setLayouyParams(int width, int height){
        this.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
    }

    public void setImage(int drawableId){
        this.setBackground( getResources().getDrawable(drawableId));
    }

    public Card(Context context) {
        super(context);
    }

    public Card(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Card(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public Card(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


}
