package ru.method.figurese.models;

public class Question {
    private String text;
    private String questionMin;
    private String questionMax;
    private double max;
    private double min;
    private MiniMax miniMax;

    public Question(String text, String questionMin, String questionMax, double min, double max) {
        this.text = text;
        this.questionMin = questionMin;
        this.questionMax = questionMax;
        this.max = max;
        this.min = min;
        miniMax=new MiniMax(min, max);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setQuestionMin(String questionMin) {
        this.questionMin = questionMin;
    }

    public void setQuestionMax(String questionMax) {
        this.questionMax = questionMax;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getText() {

        return text;
    }

    public String getQuestionMin() {
        return questionMin;
    }

    public String getQuestionMax() {
        return questionMax;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public MiniMax getMiniMax(){
        return miniMax;
    }
}
