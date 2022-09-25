package com.tempo.challenge.order2;

import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantImpl implements Restaurant{
    Scanner sc = new Scanner(System.in);

    Menu m = new Menu();

    @Override
    public void menuOrder(){
        m.foodName = sc.nextLine();
        m.foodType = sc.nextLine();
        m.silverware = sc.nextLine();

        System.out.printf("고객님이 %s를 주문하였습니다.%n",m.foodName);
    }
    @Override
    public void menuConfirm(){

        System.out.printf("%s 요리사는 %s 주문을 받았습니다.%n",m.foodType,m.foodName);
    }
    @Override
    public void cooking(){

        System.out.printf("%s 요리사는 %s을 만들었습니다.%n",m.foodType,m.foodName);
    }
    @Override
    public void menuReserve(){

        System.out.printf("고객은 주문한 %s을 받았으며, %s으로 먹었습니다.%n",m.foodName,m.silverware);
    }


}
