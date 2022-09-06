package src.com.baekjoon.step1;

import java.util.Scanner;


public class Step1{

    // Step1-3 A+B
    public void method01(){

        int a=0;
        int b=0;
        Scanner sc = new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.println(a+b);
    }

    // Step1-4 1001번 A-B
    public void method02(){
        // import java.util.*;
        int a = 0;
        int b = 0;

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        System.out.println(a-b);

    }

    // Step1-5 10998번 A*B
    public void method03(){
        // import java.util.*;
        int a = 0;
        int b = 0;

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        System.out.println(a*b);

    }

    // Step1-6 1008번 A/B
    public void method04(){
//        import java.util.*;

        double a = 0;
        double b = 0;

        Scanner sc = new Scanner(System.in);

        a = sc.nextDouble();
        b = sc.nextDouble();

        System.out.printf("%.10f",a/b);
//        System.out.printf("%.9f",a/b); 이것도 .11f도 정답. 8이하로는 오답.
        // double로 안하고 float로하면 소수점 아래 계산에서 오차가 생겨서 문제가 오답처리됨


//        float aa = 0.11111f;
//
//        System.out.printf("%.2f",aa);

    }

    // Step1-7 10869번 사칙연산
    public void method05(){

//        import java.util.*;
//        public class Main {
//        public static void main(String[] args) {

        int a = 0;
        int b = 0;

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);


    }

    // Step1-8 10926번 ??!
    public void method06(){

        String name = null;

        Scanner sc = new Scanner(System.in);
        name = sc.next();

        System.out.print(name+"??!");


    }

    // Step1-9 18108번 1998년생인 내가 태국에서는 2541년생?!
    public void method07(){

        int year = 0;

        Scanner sc = new Scanner(System.in);
        year = sc.nextInt();

        System.out.printf("%d",year-543);


    }


    // Step1-10 3003번 : 킹, 퀸, 룩, 비숍, 나이트, 폰
    public void method08(){



    }

}
