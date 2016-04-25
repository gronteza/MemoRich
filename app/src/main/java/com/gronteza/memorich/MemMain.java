package com.gronteza.memorich;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MemMain extends AppCompatActivity {

    Point screenSize;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);


        setContentView(R.layout.activity_mem_main);

        relativeLayout = (RelativeLayout) findViewById(R.id.mainRelativeLayout);

        createBoard(6,6);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private void createBoard(int cardsInRow,int cardsInCol){
        setConstants(cardsInRow, cardsInCol);

        for (int rows = 0;rows < cardsInCol;rows++){
            for (int cols = 0; cols < cardsInRow;cols++){
                ImageView card = new ImageView(this);
                card.setBackgroundColor(Color.BLUE);
                card.setLayoutParams(new RelativeLayout.LayoutParams(Constants.CARD_WIDTH, Constants.CARD_HEIGHT));
                relativeLayout.addView(card);
                card.setX(cols * (Constants.CARD_WIDTH) + (cols + 1) * Constants.SPACE);
                card.setY(rows * (Constants.CARD_HEIGHT) + (rows + 1) * Constants.SPACE);
            }
        }
    }

    private void setConstants(int cardsInRow, int cardsInCol){
        screenSize = new Point();
        this.getWindowManager().getDefaultDisplay().getSize(screenSize);
        Constants.CARD_WIDTH = (screenSize.x - ((cardsInRow+1)* Constants.SPACE))/cardsInRow;
        Constants.CARD_HEIGHT = (screenSize.y - ((cardsInCol+1)* Constants.SPACE))/cardsInCol;
    }

}
