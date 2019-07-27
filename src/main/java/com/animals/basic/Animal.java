package com.animals.basic;

public abstract class Animal {
//todo wyodrębnić elementy wspólne dla psa i kota
    protected int weight; //todo ustawiac wage w konstruktorze

    Animal(final String name){

    }

    public abstract String getName();

    public abstract boolean isRested();

    public abstract String makeVoice(int numberOfVoices);

    public abstract void walkInMinutes(int minutes);

    public abstract void sleep(int minutes);
}
