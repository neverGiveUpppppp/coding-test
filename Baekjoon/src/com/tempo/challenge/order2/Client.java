package com.tempo.challenge.order2;

import java.util.*;

public class Client {

//    Menu m = new Menu();
//    Scanner sc = new Scanner(System.in);
//    m.foodName = sc.nextLine();

    public static void main(String[] args) {
        RestaurantImpl rl = new RestaurantImpl();
        rl.menuOrder();
        rl.menuConfirm();
        rl.cooking();

    }
}
