package com.baekjoon.step9;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Step9-1 	5086 배수와 약수
/*
조건
    3가지 중 하나를 도출하는 문제
        첫째 숫자가 둘째 숫자의 약수 = factor
        첫째 숫자가 둘째 숫자의 배수 = multiple
        첫째 숫자가 둘째 숫자의 약수,배수x = neither
    입력값 : 0 < T <= 10000
            마지막 줄에 0 2개
            두 수 같은 경우x

brainstorming
    1.switch(int)로 받으면 될 듯
    2.약수,배수 구하는 공식 찾아보기
        약수 : a % b == 0
        배수 : b % a == 0
    3.테스트케이스만큼 반복
    4. 마지막 줄에 0 두 개가 주어지는 이유는 특정 메소드나 방법을 사용하라는 암시이자 그럴 수 밖에 없는 조건임

 */
class Step9_1{
    public static void main(String[] args) {

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = null;

            // 1.테스트케이스 입력값 받기
            int testcase = Integer.parseInt(br.readLine());

            int[] numbers = new int[testcase];
            for (int i = 0; i < testcase; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                while(st.hasMoreTokens()){
                    numbers[i] += Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(Arrays.toString(numbers));


        }catch(IOException e){
            e.printStackTrace();
        }


    }



}


/*

    정답1
        14088	124
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */





// Step9-2 5086 배수와 약수
class Step9_2{
    public static void main(String[] args) {

    }



}


/*

    정답1
        14088	124
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */










public class Step9_2023 {


}






