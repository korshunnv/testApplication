package ru.method.figurese.models;


public class MiniMax {

    private double koefficient=0.5;
    private double min;
    private double max;

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double absMaxMin(){
        return max-min;
    }

    public boolean isSmall(double l) {//узкая
        return absMaxMin()>l*koefficient;
    }

    public MiniMax(double min, double max){
        this.max=max;
        this.min=min;
    }

}
