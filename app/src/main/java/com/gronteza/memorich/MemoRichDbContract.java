package com.gronteza.memorich;

import android.provider.BaseColumns;

public final class MemoRichDbContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public MemoRichDbContract() {
    }

    /* Inner class that defines the table contents */
    public static abstract class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "memorich";
        public static final String FIRST_CARD_TYPE = "type1";
        public static final String SECOND_CARD_TYPE = "type2";
        public static final String FIRST_CARD_VALUE = "value1";
        public static final String SECOND_CARD_VALUE = "value2";
        public static final String SUBJECT = "subject";
    }
}

