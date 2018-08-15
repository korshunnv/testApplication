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
                170));

        questionList.add(new Question(
                "ВОЗ собирала данные по доношенным новорожденным детям. Средний рост для девочек составляет 46,1 см. По вашему мнению:",
                "Каков может самый маленький рост доношенной новорожденной девочки?",
                "Каков может самый большой рост доношеннй новорожденной девочки?",
                40,
                60));

        questionList.add(new Question(
                "Средний рост мужчины на планете 176 см. По вашему мнению:",
                "Сколько см роста может быть у самого низкого мужчины?",
                "Сколько см роста может быть у самого высокого мужчины?",
                50,
                290));
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
