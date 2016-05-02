package com.gronteza.memorich;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MemoRichReaderDbHelper extends SQLiteOpenHelper {

    private static final String COMMA_SEP = ", ";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INT";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MemoRichDbContract.FeedEntry.TABLE_NAME + " (" +
                    MemoRichDbContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    MemoRichDbContract.FeedEntry.FIRST_CARD_TYPE + INT_TYPE + COMMA_SEP +
                    MemoRichDbContract.FeedEntry.FIRST_CARD_VALUE + TEXT_TYPE + COMMA_SEP +
                    MemoRichDbContract.FeedEntry.SECOND_CARD_TYPE + INT_TYPE + COMMA_SEP +
                    MemoRichDbContract.FeedEntry.SECOND_CARD_VALUE + TEXT_TYPE + COMMA_SEP +
                    MemoRichDbContract.FeedEntry.SUBJECT + INT_TYPE + ");";

    public static final String INSERT_TEMPLATE = "INSERT INTO " + MemoRichDbContract.FeedEntry.TABLE_NAME + " ("
            + MemoRichDbContract.FeedEntry._ID + COMMA_SEP
            + MemoRichDbContract.FeedEntry.FIRST_CARD_TYPE + COMMA_SEP
            + MemoRichDbContract.FeedEntry.FIRST_CARD_VALUE + COMMA_SEP
            + MemoRichDbContract.FeedEntry.SECOND_CARD_TYPE + COMMA_SEP
            + MemoRichDbContract.FeedEntry.SECOND_CARD_VALUE + COMMA_SEP
            + MemoRichDbContract.FeedEntry.SUBJECT + ") Values (?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MemoRichDbContract.FeedEntry.TABLE_NAME;

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;

    public MemoRichReaderDbHelper(Context context, String databaseName) {
        super(context, databaseName, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
        insertDemoData(db);
    }

    private void insertDemoData(SQLiteDatabase db) {
        db.execSQL(INSERT_TEMPLATE, new Object[]{1, 1, "Israel", 1, "Jerusalem", 2});
        db.execSQL(INSERT_TEMPLATE, new Object[]{2, 1, "USA", 1, "Washington", 2});
        db.execSQL(INSERT_TEMPLATE, new Object[]{3, 1, "Italy", 1, "Rome", 2});
        db.execSQL(INSERT_TEMPLATE, new Object[]{4, 1, "Norway", 1, "Oslo", 2});
        db.execSQL(INSERT_TEMPLATE, new Object[]{5, 1, "France", 1, "Paris", 2});
        db.execSQL(INSERT_TEMPLATE, new Object[]{6, 1, "Peru", 1, "Lima", 2});
        db.execSQL(INSERT_TEMPLATE, new Object[]{7, 1, "Spain", 1, "Madrid", 2});
        db.execSQL(INSERT_TEMPLATE, new Object[]{8, 1, "Hungary", 1, "Budapest", 2});
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}