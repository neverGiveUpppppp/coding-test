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


    public void method03() {


    }


    public void method04() {


    }


    public void method05() {


    }





}