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




    public void method02() {


    }




    public void method03() {


    }




    public void method04() {


    }




    public void method05() {


    }










}
