package com.tempo.challenge.other;

/*

SRP(Single Responsibility Principle, 단일 책임 원칙): 클래스는 단 하나의 목적을 가져야 하며, 클래스를 변경하는 이유는 단 하나의 이유여야 한다.
OCP(Open-Closed Principle, 개방 폐쇠 원칙): 클래스는 확장에는 열려 있고, 변경에는 닫혀 있어야 한다.
LSP(Liskov Substitution Principle, 리스코프 치환 원칙): 상위 타입의 객체를 하위 타입으로 바꾸어도 프로그램은 일관되게 동작해야 한다.
ISP(Interface Segregation Principle, 인터페이스 분리 원칙): 클라이언트는 이용하지 않는 메소드에 의존하지 않도록 인터페이스를 분리해야 한다.
DIP(Dependency Inversion Principle, 의존 역전 법칙): 클라이언트는 추상화(인터페이스)에 의존해야 하며, 구체화(구현된 클래스)에 의존해선 안된다.


order 배열로 한번에 받을까?


  */


import java.util.*;



public class Client {

    static Scanner sc = new Scanner(System.in);



//    public static final int SIZE = 3;
//    Order[] orders = new Order[SIZE];

    public static void main(String[] args) {

        Menu menu = new Menu();

        menu.menuOrder();


//        menu.printMenu();
//        System.out.println("a");
//        Order order = new Order();
//        order.Order();

//        sc.nextLine();

//        System.out.printf("고객은 %s을 주문하였습니다.");
//        System.out.printf("   고객은 %s을 주문하였습니다.");

    }
}

//class Menu{
//
//    private String foodName;
//    private String foodType;
//    private String silverware;
//
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
//    public void setFoodName() {
//        this.foodName = foodName;
//    }
//
//    public String getFoodType() {
//        return foodType;
//    }
//
//    public void setFoodType() {
//        this.foodType = foodType;
//    }
//
//    public String getSilverware() {
//        return silverware;
//    }
//
//    public void setSilverware() {
//        this.silverware = silverware;
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
//
//
//}

//class Shef{
//    String Kor;
//    private String Ch;
//    private String Jp;
//    private String Wes;
//
//
//}

//class Dish{
//
//
//}

//class Functions{
//
//    Menu menu = new Menu();
//    Shef shef = new Shef();
//
//    public String Order(String foodName, String foodType, String siverware){
//        menu.setFoodName();
//        menu.setFoodType();
//        menu.setSilverware();
//
//        return "고객은 %s을 주문하였습니다.";
//    }
//
//
//
//}

//class Cook{
//    Menu menu = new Menu();
//    Shef shef = new Shef();
//    menu.getFoodName();
//    menu.getFoodType();
//    menu.getSilverware();
//
//    if(menu.getFoodType() == "한식"){
////        shef.Kor;
//
//    }else if(menu.getFoodType() == "중식") {
//
//    }else if(menu.getFoodType() == "일식"){
//
//    }else if(menu.getFoodType() == "양식"){
//
//    }else{
//        System.out.println("잘못 주문");
//    }
//
//}