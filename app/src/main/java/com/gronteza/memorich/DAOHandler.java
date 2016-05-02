
package com.gronteza.memorich;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAOHandler {
    private Map<Subject,List<CardPair>> cardPairsMap;
    private SQLiteDatabase db;
    public static final String DATABASE_NAME = "MemoRich.db";

    public DAOHandler(Context context) {
        cardPairsMap = new HashMap<>();

        context.deleteDatabase(DATABASE_NAME);
        MemoRichReaderDbHelper dao = new MemoRichReaderDbHelper(context, DATABASE_NAME);
        db = dao.getReadableDatabase();
    }

    //TODO load with sqlite \ files \ maybe select only the relevant , then a map is not usable ?
    public List<CardPair> getRandomPairs(int pairSize, Subject subject){
        loadDataIfNeeded(subject, pairSize);
        List<CardPair>values = cardPairsMap.get(subject);
        Collections.shuffle(values);
        return values.subList(0, pairSize);
    }

    private List<CardPair> loadDataIfNeeded(Subject subject, int pairCount) {
        if (cardPairsMap.get(subject) == null) {
            cardPairsMap.put(subject, new ArrayList<CardPair>());

            Cursor c = db.rawQuery("SELECT * FROM " + MemoRichDbContract.FeedEntry.TABLE_NAME
                    + " ORDER BY RANDOM() LIMIT " + pairCount, null);
            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        cardPairsMap.get(subject).add(createPair(c));
                    } while (c.moveToNext());
                }
            }
            if (c != null) {
                c.close();
            }
        }
        return cardPairsMap.get(subject);
    }

    private CardPair createPair(Cursor c) {
        int type1 = c.getInt(c.getColumnIndex(MemoRichDbContract.FeedEntry.FIRST_CARD_TYPE));
        int type2 = c.getInt(c.getColumnIndex(MemoRichDbContract.FeedEntry.SECOND_CARD_TYPE));
        String value1 = c.getString(c.getColumnIndex(MemoRichDbContract.FeedEntry.FIRST_CARD_VALUE));
        String value2 = c.getString(c.getColumnIndex(MemoRichDbContract.FeedEntry.SECOND_CARD_VALUE));
        int subject = c.getInt(c.getColumnIndex(MemoRichDbContract.FeedEntry.SUBJECT));
        return new CardPair(type1, type2, value1, value2, subject);
    }
}
