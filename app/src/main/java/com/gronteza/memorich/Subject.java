package com.gronteza.memorich;

public enum Subject {
    Children(1), GeneralKnowledge(2) , Music(3);

    public int id;
    Subject(int i){
        id  = i;
    }

    public static Subject getSubjectById(int subjectId) {
        if (subjectId == 1){
            return Subject.Children;
        } else  if (subjectId == 2){
            return Subject.GeneralKnowledge;
        } else  if (subjectId == 3){
            return Subject.Music;
        }

        return null;
    }
}
