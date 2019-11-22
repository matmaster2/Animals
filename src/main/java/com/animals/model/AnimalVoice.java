package com.animals.model;

import com.animals.enums.TypeOfAnimal;
import com.animals.factory.AnimalVoiceFactory;

public class AnimalVoice {

    private TypeOfAnimal typeOfAnimal;

    public AnimalVoice(TypeOfAnimal typeOfAnimal){
        this.typeOfAnimal = typeOfAnimal;
    }

    private String rested;
    private String halfRested;
    private String normal;
    private String tired;
    private String exhausted;

    public String getRested() {
        return rested;
    }

    public String getHalfRested() {
        return halfRested;
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
                ", halfRested='" + halfRested + '\'' +
                ", normal='" + normal + '\'' +
                ", tired='" + tired + '\'' +
                ", exhausted='" + exhausted + '\'' +
                '}';
    }
}
