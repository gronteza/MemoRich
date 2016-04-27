package com.gronteza.memorich;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gront on 26/04/2016.
 */
public class Game {
    private Subject subject;
    private int pairCount;
    List<Pair<Card, Card>> pairs;
    List<Card> firstCardList;
    List<Card> secondCardList;
    public Game(Subject subject, int pairCount) {
        this.subject = subject;
        this.pairCount = pairCount;
        firstCardList = new ArrayList<>();
        secondCardList = new ArrayList<>();
        init();
    }

    private void init(){
        pairs = DAOUtils.getRandomPairs(pairCount, subject);
        for (Pair<Card, Card> pair : pairs){
            firstCardList.add(pair.first);
            secondCardList.add(pair.second);
        }
    }
}
