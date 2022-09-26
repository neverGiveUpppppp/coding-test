package com.baekjoon.step2.run;

import com.baekjoon.step2.Step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        Step2 s = new Step2();

//        s.method01();
        s.method02();
//        s.method03();
//        s.method04();
//        s.method05();
//        s.method06();
//        s.method07();


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
}
