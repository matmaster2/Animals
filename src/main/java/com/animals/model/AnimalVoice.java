package com.animals.model;

public class AnimalVoice {

    private String rested;
    private String normal;
    private String tired;
    private String exhausted;

    public String getRested() {
        return rested;
    }

    public String getNormal() {
        return normal;
    }

    public String getTired() {
        return tired;
    }

    public String getExhausted() {
        return exhausted;
    }

    @Override
    public String toString() {
        return "AnimalVoice{" +
                "rested='" + rested + '\'' +
                ", normal='" + normal + '\'' +
                ", tired='" + tired + '\'' +
                ", exhausted='" + exhausted + '\'' +
                '}';
    }
}
