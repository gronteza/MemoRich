package com.gronteza.memorich;

import android.view.View;

/**
 * Created by gront on 26/04/2016.
 */
public class CardGestures implements View.OnClickListener {
    private static CardGestures cardGestures;


    protected CardGestures() {
    }

    public static CardGestures getInstance(){
        if (cardGestures == null){
            cardGestures = new CardGestures();
        }
        return cardGestures;
    }


    @Override
    public void onClick(View v) {

// TODO: THE CODE IS COPIED, NEED TO UNDERSTAND WHAT THE FUCK IS GOING ON...
        View cardFace = ((CardFrame)v).frontCard;
        View cardBack = ((CardFrame)v).backImage;

        FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);
        flipAnimation.initialize((int)(((CardFrame)v).frontCard.getWidth()/2 + ((CardFrame)v).frontCard.getX()),
                (int)(((CardFrame)v).frontCard.getHeight()/2 + ((CardFrame)v).frontCard.getY()),
                ((CardFrame)v).frontCard.getWidth(),
                ((CardFrame)v).frontCard.getHeight());

        if (cardFace.getVisibility() == View.GONE)
        {
            flipAnimation.reverse();
        }
        v.startAnimation(flipAnimation);
    }
}
