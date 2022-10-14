package com.baekjoon.test;


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),",");

        int x = 0;
        int y = 0;
        while(st.hasMoreTokens()){
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
        }
        System.out.println(x);
        System.out.println(y);

        if( x > 0 && y > 0){
            System.out.print(1);
        }else if(x < 0 && y > 5){
            System.out.print(2);
        }else if( x < 0 && y < 0){
            System.out.print(3);
        }else if(x > 0 && y < 0){
            System.out.print(4);
        }else{
            System.out.print("잘못 입력 되어있습니다");
        }

    }
}