package com.gronteza.memorich;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by gront on 26/04/2016.
 */
public class CardFrame extends RelativeLayout {
    Card frontCard;
    ImageView backImage;

    public CardFrame(Context context, int color, int X, int Y, int width, int height, int id) {
        super(context);
        this.setX(X);
        this.setY(Y);
        this.setId(id);
        this.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
        this.setOnClickListener(CardGestures.getInstance());

        frontCard = new Card(context,color,X,Y,width,height);
        frontCard.setScaleType(ImageView.ScaleType.FIT_XY);

        backImage = new ImageView(context);
        backImage.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
        backImage.setBackground(getResources().getDrawable(R.drawable.card_back));

        this.addView(frontCard,width,height);
        this.addView(backImage,width,height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }
}
