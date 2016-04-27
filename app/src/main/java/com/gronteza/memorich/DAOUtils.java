package com.gronteza.memorich;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

public class DAOUtils {
    private static Map<Subject,List<Pair<Card,Card>>> cardPairsMap;

    static
    {
        loadData();
    }

    //TODO load with sqlite \ files \ maybe select only the relevant , then a map is not usable ?
    private static void loadData() {
        cardPairsMap = new HashMap<>();
    }

    public static List<Pair<Card,Card>> getRandomPairs(int boardSize, Subject subject){
        List<Pair<Card, Card>> values = cardPairsMap.get(subject);
        Collections.shuffle(values);
        List<Pair<Card,Card>> destination = new ArrayList<>(boardSize);

        Collections.copy(destination, values);
        return destination.subList(0, boardSize);
    }
}
