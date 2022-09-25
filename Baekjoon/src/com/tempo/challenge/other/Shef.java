package com.tempo.challenge.other;

import java.util.Objects;

public class Shef extends Menu{


    private String ShefType;

    public Shef() {}

    public Shef(String foodName, String foodType, String silverware, String shefType) {
        super(foodName, foodType, silverware);
        ShefType = shefType;
    }

    public String getShefType() {
        return ShefType;
    }

    public void setShefType(String shefType) {
        ShefType = shefType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shef)) return false;
        Shef shef = (Shef) o;
        return getShefType().equals(shef.getShefType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShefType());
    }





//    public String kor;
//    public String ch;
//    public String jp;
//    public String wes;




}
