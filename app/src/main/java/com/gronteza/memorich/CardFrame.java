package com.gronteza.memorich;

import android.widget.ImageView;
import android.widget.RelativeLayout;

public class CardFrame extends RelativeLayout {
    Card frontCard;
    ImageView backImage;

    public CardFrame(Card card, int id) {
        super(card.getContext());
        this.setX(card.getX());
        this.setY(card.getY());
        this.setId(id);
        int width = card.getLayoutParams().width;
        int height = card.getLayoutParams().height;
        this.setLayoutParams(new RelativeLayout.LayoutParams(width, height));
        this.setOnClickListener(CardGestures.getInstance());

        frontCard = card;
        frontCard.setScaleType(ImageView.ScaleType.FIT_XY);

        backImage = new ImageView(card.getContext());
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
