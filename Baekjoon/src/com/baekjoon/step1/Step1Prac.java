package com.baekjoon.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Step1Prac {

    public void method01() throws IOException {
        // Step1-10 3003번 : 킹, 퀸, 룩, 비숍, 나이트, 폰
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] horse = {1,1,2,2,2,8};
        int[] temp = new int[6];
        String answer = "";

        for(int i=0; i<horse.length;i++){
            temp[i] = Integer.parseInt(st.nextToken());
//            answer[i] = horse[i] - temp[i] + " ";
            answer += horse[i] - temp[i] + " ";
        }
//        System.out.println(Arrays.toString(answer));
        System.out.println(answer);

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



import

public class Main {
    public static void main(String[] args) {


    }
}



public class Main {
    public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] horse = {1,1,2,2,2,8};
        int[] temp = new int[6];
        String answer = "";

        for(int i=0; i<horse.length;i++){
            temp[i] = Integer.parseInt(st.nextToken());
//            answer[i] = horse[i] - temp[i] + " ";
            answer += horse[i] - temp[i] + " ";
        }
//        System.out.println(Arrays.toString(answer));
        System.out.println(answer);

    }
}


 */

    }



    // Step1-10 3003번 : 킹, 퀸, 룩, 비숍, 나이트, 폰
    public void method02() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] hor = {1,1,2,2,2,8};
        int[] tem = new int[6];
        String ans = "";

        for(int i = 0; i < hor.length; i++){
            tem[i] = Integer.parseInt(st.nextToken());
            ans += hor[i] - tem[i] + " ";
        }
        System.out.println(ans);



    }



    // Step1-10 3003번 : 킹, 퀸, 룩, 비숍, 나이트, 폰
    public void method03() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] horse = {1,1,2,2,2,8};
        int[] switching = new int[6];

        String answer = "";

        for(int i=0; i < horse.length; i++){
            switching[i] = Integer.parseInt(st.nextToken());
            answer += horse[i] - switching[i] + " ";
        }
        System.out.println(answer);
    }




    public void method04() {

        Scanner sc = new Scanner(System.in);
        int a,b;
        String[] num = sc.nextLine().split(" ");
        a = Integer.parseInt(num[0]);
        b = Integer.parseInt(num[1]);
        System.out.print(a+b);

//        int a=0;
//        int b=0;
//        Scanner sc = new Scanner(System.in);
//        a=sc.nextInt();
//        b=sc.nextInt();
//        System.out.println(a+b);

    }




    public void method05() {
        // 1008번	A/B
        Scanner sc = new Scanner(System.in);
        Double a,b;
        String[] num = sc.nextLine().split(" ");
        a = Double.parseDouble(num[0]);
        b = Double.parseDouble(num[1]);
        System.out.println(a/b);
        System.out.printf("%.10f",a/b);

    }


    public void method06() {
        // 	10869	사칙연산
        Scanner sc = new Scanner(System.in);

        int a,b;
        String[] num = sc.nextLine().split(" ");
        a = Integer.parseInt(num[0]);
        b = Integer.parseInt(num[1]);

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.print(a%b);
    }


    public void method07() {
        // 10926	??!
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.print(str+"??!");

    }


    public void method08() {
        // 18108	1998년생인 내가 태국에서는 2541년생?!
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        System.out.println(year-543);


    }


    public void method09() {
        // 10430	나머지
        Scanner sc = new Scanner(System.in);
        int A,B,C;
        String[] strArr = sc.nextLine().split(" ");
        A = Integer.parseInt(strArr[0]);
        B = Integer.parseInt(strArr[1]);
        C = Integer.parseInt(strArr[2]);

        System.out.println( (A+B)%C );
        System.out.println( ((A%C) + (B%C))%C );
        System.out.println( (A*B)%C );
        System.out.print( ((A%C) * (B%C))%C );

    }


    public void method10() {
        // 2588	곱셈
/*
    brainstorming
    a[0] a[1] a[2]
    b[0] b[1] b[2]

    a[0-2] * b[2]
    a(472) * b[2] = (3)

 */
//        Scanner sc = new Scanner(System.in);
//        int num1;
//        String num2;
//        num1 = sc.nextInt();
//        num2 = sc.next();
//        System.out.println(num1 * (num2.charAt(2)-'0'));
//        System.out.println(num1 * (num2.charAt(1) -'0'));
//        System.out.println(num1 * (num2.charAt(0) -'0'));
//        System.out.println(num1 * Integer.parseInt(num2));


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            long first = Long.parseLong(br.readLine());
//            Long first = Long.getLong(br.readLine()); // Wrapper class Long. primitive type인 long과는 다름. 기본형과 참조형의 연산은 불가
            String second = br.readLine();

            // (2)의 각 자리수 구하기
            long second_100 = Integer.parseInt(second.substring(0,1)) * 100;
            long second_10 = Integer.parseInt(second.substring(1,2)) * 10;
            long second_1 = Integer.parseInt(second.substring(2,3));    // substring()도 for문 막자리수 -1처럼 끝자리수 -1카운트

            // (1)과 (2)의 각 자리수 곱하기
            long result1 = first * second_1;                 // 472 * 5
            long result2 = (first * second_10) / 10;         // 472 * 80 / 10
            long result3 = (first * second_100) / 100;       // 472 * 300 / 100
            long result4 = first * Integer.parseInt(second); // 472 * 385

            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result3);
            System.out.println(result4);
        }catch(IOException e){
            e.printStackTrace();
        }

    }


    public void method11() {
        // 11382	꼬마 정민

    }


    public void method12() {
        // 10171	고양이

    }


    public void method13() {
        // 10172	개

    }









}
