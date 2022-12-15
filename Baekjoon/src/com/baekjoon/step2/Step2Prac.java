package com.baekjoon.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step2Prac {


    public void method01() throws IOException {
        // Step2-1 1330번 : 두 수 비교하기
        // 조건
        // 한 줄에 두 수 받기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] num = new int[2];
        for(int i=0; i < num.length;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(num));

        int num1 = num[0];
        int num2 = num[1];

        if(num1 > num2){
            System.out.println(">");
        }else if(num1 < num2){
            System.out.println("<");
        }else{
            System.out.println("==");
        }


    }


    public void method02() throws IOException {
        // Step2-2 9498번 : 시험 성적
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());

        if(score >= 90){
            System.out.println("A");
        }else if(score >= 80){
            System.out.println("B");
        }else if(score >= 70){
            System.out.println("C");
        }else if(score >= 60){
            System.out.println("D");
        }else{
            System.out.println("F");
        }


    }


    public void method03() throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int total = 0;

        total = h * 60 + m + c;

        h = ( total / 60) % 24;
        m = total % 60;

        System.out.println(h + " "+ m);

    }


    public void method04() throws IOException {

        // Step2-4 14681번 : 사분면 고르기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int quadrant;

        if(x > 0 && y > 0){
            quadrant = 1;
            System.out.println(quadrant);
        }else if(x < 0 && y > 0){
            quadrant = 2;
            System.out.println(quadrant);
        }else if(x < 0 && y < 0){
            quadrant = 3;
            System.out.println(quadrant);
        }else if(x > 0 && y < 0){
            quadrant = 4;
            System.out.println(quadrant);
        }



//        System.out.println(x);
//        System.out.println(y);




    }

    // Step2-4 14681번 : 사분면 고르기
    public void method05() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int square = 0;


        if(x > 0 && y > 0){
            square = 1;
            System.out.println(square);
        }else if(x > 0 && y < 0){
            square = 2;
            System.out.println(square);
        }else if(x < 0 && y < 0){
            square = 3;
            System.out.println(square);
        }else{
            square = 4;
            System.out.println(square);
        }


    }





}
