package com.tempo.challenge.other;

import java.util.Objects;

public class Dish extends Menu{

    String dishName;

    public Dish(){}

    public Dish(String foodName, String foodType, String silverware, String dishName) {
        super(foodName, foodType, silverware);
        this.dishName = dishName;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return Objects.equals(dishName, dish.dishName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishName);
    }

//    String galbi;
//    String pasta;
//    String topu;

    // korean 나라별 메소드 만들어야하나?
    // vo 클래스로 만들어야하나?
}
