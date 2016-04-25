package com.gronteza.memorich;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by gront on 26/04/2016.
 */
public class DataBase {
    ArrayList<ArrayList<Card>> DB;

    public ArrayList<Card> getGame(int gameNum){
        return DB.get(gameNum);
    }
}
