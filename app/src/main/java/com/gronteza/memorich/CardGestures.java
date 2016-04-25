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
//        View rootLayout = ;
//        View cardFace = (View) findViewById(R.id.main_activity_card_face);
//        View cardBack = v;
//
//        FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);
//
//        if (cardFace.getVisibility() == View.GONE)
//        {
//            flipAnimation.reverse();
//        }
//        rootLayout.startAnimation(flipAnimation);
    }
}
