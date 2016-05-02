package com.gronteza.memorich;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemMain extends AppCompatActivity {
    private Point screenSize;
    private RelativeLayout relativeLayout;
    private int cardsInCol = 4;
    private int cardsInRow = 2;
    private int cardHeight;
    private int cardWidth;
    private List<Card> firstCardsType;
    private List<Card> secondCardsType;
    private List<Card> shuffleAll;
    public static final int SPACE = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);


        setContentView(R.layout.activity_mem_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.mainRelativeLayout);

        firstCardsType = new ArrayList<>();
        secondCardsType = new ArrayList<>();
        createBoard(cardsInRow, cardsInCol);

    }

    private void transferCards(List<CardPair> pairList) {
        for (CardPair cardPair : pairList){
            firstCardsType.add(getFirstCard(cardPair));
            secondCardsType.add(getSecondCard(cardPair));
        }
    }

    private Card getFirstCard(CardPair cardPair) {
        return getCard(cardPair, true);
    }

    private Card getSecondCard(CardPair cardPair) {
        return getCard(cardPair, false);
    }

    private Card getCard(CardPair cardPair, boolean isFirst) {
        Card card = null;
        CardType cardType = isFirst ? cardPair.cardType1 : cardPair.cardType2;
        if (cardType.equals(CardType.PlainText)){
            card = new TextCard(this, cardPair.value1);
        } else if(cardType.equals(CardType.Image)){
            card = new ImageCard(this, cardPair.value1);
        }else if(cardType.equals(CardType.Sound)){
            card = new SoundCard(this,cardPair.value1);
        }

        return card;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private void createBoard(int cardsInRow, int cardsInCol) {
        DAOHandler dao = new DAOHandler(this);
        List<CardPair> randomPairs = dao.getRandomPairs((cardsInCol * cardsInRow) / 2, Subject.GeneralKnowledge);
        transferCards(randomPairs);
        calcRelativeSize(cardsInRow, cardsInCol);

        shuffleAll = new ArrayList<>();
        shuffleAll.addAll(firstCardsType);
        shuffleAll.addAll(secondCardsType);
        Collections.shuffle(shuffleAll);
        for (int rows = 0; rows < cardsInCol; rows++) {
            for (int cols = 0; cols < cardsInRow; cols++) {
                relativeLayout.addView
                        (new CardFrame
                        (getCardAfterMetaDataSet(rows, cols),((rows+1)*10 + cols + 1)));
            }
        }
        int a=8;
    }

    private Card getCardAfterMetaDataSet(int row, int col) {
        Card card = shuffleAll.get(row*cardsInRow + col);
        card.setBackgroundColor(Color.BLUE);
        card.setX(col * (cardWidth) + (col + 1) * SPACE);
        card.setY(row * (cardHeight) + (row + 1) * SPACE);
        card.setLayouyParams(cardWidth, cardHeight);
        return card;
    }

    private void calcRelativeSize(int cardsInRow, int cardsInCol) {
        screenSize = new Point();
        this.getWindowManager().getDefaultDisplay().getSize(screenSize);
        cardWidth = (screenSize.x - ((cardsInRow + 1) * SPACE)) / cardsInRow;
        cardHeight = (screenSize.y - ((cardsInCol + 1) * SPACE)) / cardsInCol;
    }
}
