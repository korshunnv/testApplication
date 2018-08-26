package ru.method.figurese.models;

import java.util.ArrayList;
import java.util.List;

public class QuestionList {

    private List<Question> questionList;
    private static QuestionList instance = null;

    private QuestionList(){
        questionList=new ArrayList<Question>();
        questionList.add(new Question(
                "Орнитологи считают, что средняя скорость полёта птиц — около 27 км/час. По вашему мнению:",
                "Какова может быть скорость полёта самой медленной птицы?",
                "Какова может быть скорость полёта самой быстрой птицы?",
                0,
                170,
                "/sample/music/textSound1.wav",
                "/sample/music/questionMinSound1.wav",
                "/sample/music/questionMaxSound1.wav",
                "/sample/pictures/rangeofequivalence/1.jpg"));

        questionList.add(new Question(
                "ВОЗ собирала данные по доношенным новорожденным детям. Средний рост девочек составил 46,1 см. По вашему мнению:",
                "Каков может самый маленький рост доношенной новорожденной девочки?",
                "Каков может самый большой рост доношеннй новорожденной девочки?",
                40,
                60,
                "/sample/music/textSound2.wav",
                "/sample/music/questionMinSound2.wav",
                "/sample/music/questionMaxSound2.wav",
                "/sample/pictures/rangeofequivalence/2.jpg"));

        questionList.add(new Question(
                "Средний рост мужчины на планете 176 см. По вашему мнению:",
                "Сколько см роста может быть у самого низкого мужчины?",
                "Сколько см роста может быть у самого высокого мужчины?",
                50,
                290,
                "/sample/music/textSound3.wav",
                "/sample/music/questionMinSound3.wav",
                "/sample/music/questionMaxSound3.wav",
                "/sample/pictures/rangeofequivalence/3.jpg"));
    }

    public Question getElement(int index) {
        return questionList.get(index);
    }

    public static QuestionList createQuestionList(){
        if (instance==null) {
            return new QuestionList();
        };
        return instance;
    }

    public int size(){
        return  questionList.size();
    }
}
