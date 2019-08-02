package com.animals.basic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Animal {

    protected final Logger log = LogManager.getLogger(getClass());

    protected static final int WALK_SPEED = 20;

    protected String name;
    protected int energy = 0;

    protected int weight;
    
    Animal(final String name){
    }
    Animal(int weight){
        this.weight=weight;
    }

    public abstract String getName();

    public abstract boolean isRested();

    public abstract String makeVoice(int numberOfVoices);

    public abstract void walkInMinutes(int minutes);

    public abstract void sleep(int minutes);
}
