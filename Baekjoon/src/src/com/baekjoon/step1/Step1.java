package src.com.baekjoon.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


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
    public void method08() throws IOException {
/*
        brain storming
         총합 16개
         주어진수 + 부족한수 = 16개 가 되어야할 듯
        킹~폰까지 6종이니 값을 받는 변수 6개
        값 받기 = 스캐너
        맞춰져야하는 말의 숫자

        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int night = 2;
        int pawn = 8;

        해당 숫자를 각각 if조건문으로 맞추기기
        위와 같이 같은 성향이면 배열로 받는게 좋다

        scanner보다 BufferedReader
        split()보다 StringTokenizer
        println()보더 StringBuilder+println()이 빠르다

*/
        int king = 0;
        int queen = 0;
        int rook = 0;
        int bishop = 0;
        int night = 0;
        int pawn = 0;

        int king0 = 1;
        int queen0 = 1;
        int rook0 = 2;
        int bishop0 = 2;
        int night0 = 2;
        int pawn0 = 8;

        Scanner sc = new Scanner(System.in);
        king = sc.nextInt();
        queen = sc.nextInt();
        rook = sc.nextInt();
        bishop = sc.nextInt();
        night = sc.nextInt();
        pawn = sc.nextInt();



// 배열로 처리해보기

// 최종정답
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//        public class Main {
//            public static void main(String[] args) throws IOException {
//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        int [] arr = {1,1,2,2,2,8};
        String answer = "";
        int U;
        for(int i = 0; i < 6; i++) {
            U = Integer.parseInt(st.nextToken());
            answer += arr[i] - U+" ";
        }
        System.out.println(answer);
    }




    // Step1-11 3003번 : 킹, 퀸, 룩, 비숍, 나이트, 폰
    public void method09(){

    }

    // Step1-12 3003번 : 킹, 퀸, 룩, 비숍, 나이트, 폰
    public void method10(){



    }

    // Step1-13 3003번 : 킹, 퀸, 룩, 비숍, 나이트, 폰
    public void method11(){



    }

    // Step1-14 3003번 : 킹, 퀸, 룩, 비숍, 나이트, 폰
    public void method12(){



    }

    // Step1-15 3003번 : 킹, 퀸, 룩, 비숍, 나이트, 폰
    public void method13(){



    }



}
