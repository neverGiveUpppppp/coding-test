package com.baekjoon.step2;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Scanner;
/*


두 줄 세로값 받기 : BufferedReader 각 변수에
한 줄 가로값 받기 : BufferedReader+StringTokenizer
 - Array variable + .countTokens() + for문 + .nextToken()



 */


public class Step2_2023 {
/*


import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


    }
}

*/


    // Step2-1 1330 : 두 수 비교하기
    public void method01(){
        // 방법1 : 스캐너
//        Scanner sc = new Scanner(System.in);
//        int A = sc.nextInt();
//        int B = sc.nextInt();
//
//        if(A > B){
//            System.out.println(">");
//        }else if(A < B){
//            System.out.println("<");
//        }else if(A == B){
//            System.out.println("==");
//        }
        
        // 방법2 : BufferedReader + StringTokenizer
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int A = Integer.parseInt(String.valueOf(br.read()));
//            int B = Integer.parseInt(String.valueOf(br.read())); // 값 세로로 2번 받아야함
//            int B = Integer.parseInt(br.readLine());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");

            int[] num = new int[st.countTokens()];
            for(int i=0; i < num.length; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            int A = num[0];
            int B = num[1];

            if(A > B){
                System.out.println(">");
            }else if(A < B){
                System.out.println("<");
            }else if(A == B){
                System.out.println("==");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*
    정답
방법1 : 스캐너 사용
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        if(A > B){
            System.out.println(">");
        }else if(A < B){
            System.out.println("<");
        }else if(A == B){
            System.out.println("==");
        }
    }
}

방법2 : BufferedReader 사용

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");

            int[] num = new int[st.countTokens()];
            for(int i=0; i < num.length; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            int A = num[0];
            int B = num[1];

            if(A > B){
                System.out.println(">");
            }else if(A < B){
                System.out.println("<");
            }else if(A == B){
                System.out.println("==");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */

    // Step2-2 9498	: 시험 성적
    public void method02(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int score = Integer.parseInt(br.readLine());
            if(score >= 90){
                System.out.println("A");
            }else if(score >= 80){
                System.out.println("B");
            }else if(score >= 70){
                System.out.println("C");
            }else if(score >=60){
                System.out.println("D");
            }else{
                System.out.println("F");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*
    정답
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int score = Integer.parseInt(br.readLine());
            if(score >= 90){
                System.out.println("A");
            }else if(score >= 80){
                System.out.println("B");
            }else if(score >= 70){
                System.out.println("C");
            }else if(score >=60){
                System.out.println("D");
            }else{
                System.out.println("F");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */

    // Step2-3 12753 : 윤년
    public void method03(){
        // 조건
        // 윤년 : 4의배수 && (!100의배수 || 400의배수)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int year = Integer.parseInt(br.readLine());
            if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*
    정답
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int year = Integer.parseInt(br.readLine());
            if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}

 */

    // Step2-4 14681 : 사분면 고르기
    public void method04(){

    }


    // Step2-5 2884	: 알람 시계
    public void method05(){

    }


    // Step2-6 2525	: 오븐 시계
    public void method06(){

    }


    // Step2-7 2480	주사위 세개
    public void method07(){

    }








}
