package ru.method.figurese.models;

public class Task {

    public Task( String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    public void setPictureAddress(String pictureAddress) {

        this.pictureAddress = pictureAddress;
    }

    public void setTrueAnswer(String trueAnswer) {

        this.trueAnswer = trueAnswer;
    }

    public void setRealAnswer(String realAnswer) {
        this.realAnswer = realAnswer;
    }

    public String getPictureAddress() {

        return pictureAddress;
    }

    public String getRealAnswer() {

        return realAnswer;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    String pictureAddress;
    String trueAnswer;
    String realAnswer;

}
