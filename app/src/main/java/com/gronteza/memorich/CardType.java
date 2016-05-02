package com.gronteza.memorich;

public enum CardType {
    PlainText(1), Image(2), Sound(3);

    public int id;
    CardType(int i){
        id  = i;
    }
    public static CardType getTypeById(int i){
        if (i == 1){
            return CardType.PlainText;
        } else if (i == 2){
            return CardType.Image;
        }else if (i == 3){
            return CardType.Sound;
        }
        return null;
    }
}
