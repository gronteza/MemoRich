package com.gronteza.memorich;

public class CardPair {
    Subject subject;
    CardType cardType1;
    CardType cardType2;
    String value1;
    String value2;

    public CardPair(int cardType1, int cardType2, String value1, String value2, int subjectId) {
        this.cardType1 = CardType.getTypeById(cardType1);
        this.cardType2 = CardType.getTypeById(cardType2);
        this.value1 = value1;
        this.value2 = value2;
        this.subject = Subject.getSubjectById(subjectId);
    }
}
