package com.tempo.challenge.other;

import java.util.*;

public class Menu {

    String foodName;
    String foodType;
    String silverware;

    public Menu() {}
    public Menu(String foodName, String foodType, String silverware) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.silverware = silverware;

    }

    public void menuOrder(){
        Scanner sc = new Scanner(System.in);
        foodName = sc.nextLine();
        foodType = sc.nextLine();
        silverware = sc.nextLine();
        printMenu(foodName);
//        return null;
    }
    void printMenu(String foodName){
        System.out.printf("고객님은 %s을 주문하셨습니다.",foodName);
    }

//    Menu(String foodName, String foodType, String silverware, Scanner sc){
//        this.foodName = sc.nextLine();
//        this.foodType = sc.nextLine();
//        this.silverware = sc.nextLine();
//
//    }


}
//    public Menu(){}
//    public Menu(String foodName, String foodType, String silverware) {
//        this.foodName = foodName;
//        this.foodType = foodType;
//        this.silverware = silverware;
//    }
//
//    public String getFoodName() {
//        return foodName;
//    }
//
//    public void setFoodName(String foodName) {
//        this.foodName = this.foodName;
//    }
//
//    public String getFoodType() {
//        return foodType;
//    }
//
//    public void setFoodType(String foodType) {
//        this.foodType = this.foodType;
//    }
//
//    public String getSilverware() {
//        return silverware;
//    }
//
//    public void setSilverware(String silverware) {
//        this.silverware = this.silverware;
//    }
//
//    @Override
//    public String toString() {
//        return "Menu{" +
//                "foodName='" + foodName + '\'' +
//                ", foodType='" + foodType + '\'' +
//                ", silverware='" + silverware + '\'' +
//                '}';
//    }

