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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num1 = Integer.parseInt(br.readLine());
            int num2 = Integer.parseInt(br.readLine());

            if(num1 > 0 && num2 > 0){
                System.out.println(1);
            }else if(num1 < 0 && num2 >0){
                System.out.println(2);
            }else if(num1 < 0 && num2 < 0){
                System.out.println(3);
            }else if(num1 > 0 && num2 <0){
                System.out.println(4);
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
            int num1 = Integer.parseInt(br.readLine());
            int num2 = Integer.parseInt(br.readLine());

            if(num1 > 0 && num2 > 0){
                System.out.println(1);
            }else if(num1 < 0 && num2 >0){
                System.out.println(2);
            }else if(num1 < 0 && num2 < 0){
                System.out.println(3);
            }else if(num1 > 0 && num2 <0){
                System.out.println(4);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
 */

    // Step2-5 2884	: 알람 시계
    public void method05(){
/*
조건
    1)받는 입력값 2개 : H, M
    2)24시제
    3)시간표현 시, 불필요한 0제거
brainstorming
    1hour = 60mins
    시간과 분을 전체 분으로 변경해 거기서 다시 시간으로 재조립하는 방법
    ex) 10시 : 1h x 10 x 60
        35분
        600 + 35 = 635
        635 - 45 = 595
        595 / 60 && 595 % 60 = 나눈 수는 시간, 나머지는 분
        
        0시 30분 관련 풀이
        30 - 45 = -15
        60 - 45 = 15
            15+30 = 45

 */
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] input = new int[st.countTokens()];
            for(int i=0; i < input.length; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }

            int hour = input[0];
            int min = input[1];

            while(st.hasMoreTokens()){
                hour = Integer.parseInt(st.nextToken());
                min = Integer.parseInt(st.nextToken());
            }

            if((min-45) < 0 ){
                hour = hour-1;
                min = min - 45 + 60;
                if(hour < 0){
                    hour = hour + 24;
                }
                System.out.println(hour + " " + min);
            }
            else {
                System.out.println(hour + " " + (min - 45));
            }

        }catch (IOException e){
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
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] input = new int[st.countTokens()];
            for(int i=0; i < input.length; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }

            int hour = input[0];
            int min = input[1];

            while(st.hasMoreTokens()){
                hour = Integer.parseInt(st.nextToken());
                min = Integer.parseInt(st.nextToken());
            }

            if((min-45) < 0 ){
                hour = hour-1;
                min = min - 45 + 60;
                if(hour < 0){
                    hour = hour + 24;
                }
                System.out.println(hour + " " + min);
            }
            else {
                System.out.println(hour + " " + (min - 45));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


오답이나 괜찮은 식이어서 남김
    int[] input = new int[st.countTokens()];
    for(int i=0; i < input.length; i++){
        input[i] = Integer.parseInt(st.nextToken());
    }

    int hour = input[0];
    int min = input[1];

    if(hour > 0){
        int temp = hour * 60;
        int hours = (temp + min - 45) / 60;
        int mins = (temp + min - 45) % 60;
        System.out.println(hours+" "+ mins);
    }else if(hour == 0){
        int hours = 23;
        int mins = 60 - 45 + min;
        System.out.println(hours+" "+ mins);
    }
 */



    // Step2-6 2525	: 오븐 시계
    public void method06(){
/*
조건
    조리시간 : 최대 1000분

brainstorming
    1) 조리시간 + 현시간이 23시59분을 지나 0시라면 0시로 시작하는 로직 필요
    2) 분 + 조리시간이 60넘어가면 분을 0부터하고 시간에 +해야함
        시 = 분+조리시간 / 60
        분 = 분+조리시간 % 60
    3) 조리시간 : 최대 1000분
        100분 = 960분 = 약16시간

        그냥 포탈 분 구하고 23시간 넘는 분수면 0처리?
            24시간 == 1440분
            1440분 넘으면 0시처리?
        경우의 수 : 0시 오버, 안오버, 딱 0시
            0시 오버의 경우 일자까지는 표시 안하니 +day는 신경x

 */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] input = new int[st.countTokens()];
            for(int i=0; i < input.length; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }
            int hour = input[0];
            int min = input[1];
            int cooking_time = Integer.parseInt(br.readLine());

            int totalTime = hour * 60 + min + cooking_time;

            // 0시 안넘어가는 경우
            if(totalTime < 1440 ){
                int hours = totalTime / 60;
                int mins = totalTime % 60;
                System.out.println(hours + " " + mins);
            // 0시 넘어가는 경우
            }else{
                int hours = (totalTime / 60) - 24; // -24 대신 %24도 가능
                int mins = totalTime % 60;
                System.out.println(hours + " " + mins);
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
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] input = new int[st.countTokens()];
            for(int i=0; i < input.length; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }
            int hour = input[0];
            int min = input[1];
            int cooking_time = Integer.parseInt(br.readLine());

            int totalTime = hour * 60 + min + cooking_time;

            // 0시 안넘어가는 경우
            if(totalTime < 1440 ){
                int hours = totalTime / 60;
                int mins = totalTime % 60;
                System.out.println(hours + " " + mins);
            // 0시 넘어가는 경우
            }else{
                int hours = (totalTime / 60) - 24;
                int mins = totalTime % 60;
                System.out.println(hours + " " + mins);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */



    // Step2-7 2480	주사위 세개
    public void method07(){
/*
조건
    1.같은 눈 3개 : 10000 +(같은눈수) * 1000
    2.같은 눈 2개 : 1000 + (같은눈수) * 100
    3.모두 다른 눈 : (가장 큰눈) * 100

brainstorming
    1.같은 눈 3개 : if(a==b==c)
    2.같은 눈 2개 : if(a==b && a==c)
    3.모두 다른눈 : if(a != b && b != c)

    숫자 중 가장 큰 수 구하는 로직 : heap정렬 max 공부해보기
 */
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int[] input = new int[st.countTokens()];
            for(int i = 0; i < input.length; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }

            int dice1 = input[0];
            int dice2 = input[1];
            int dice3 = input[2];

            // 1.같은 눈 3개
            if(dice1 == dice2 && dice2 == dice3) {
                System.out.println(10000 + (dice1) * 1000);
            // 2.같은 눈 2개 : 1,3번기준
            }else if(dice1 != dice2 && dice1 == dice3) {
                System.out.println(1000 + (dice1) * 100);
            // 2.같은 눈 2개 : 2,3번기준
            }else if(dice2 != dice1 && dice2 == dice3) {
                System.out.println(1000 + (dice2) * 100);
            // 2.같은 눈 2개 : 1,2번기준
            }else if(dice1 == dice2 && dice1 != dice3){
                System.out.println(1000 + (dice2) * 100);
            // 3.모두 다른 눈
            }else if(dice1 != dice2 && dice2 != dice3){
                int max_dice = 0;
                // 최대값 구하기
                if(dice1 > dice2){
                    if(dice2 > dice3){
                        max_dice = dice1; // System.out.println("max : dice1");
                    }else if(dice2 < dice3){
                        if(dice1 > dice3){
                            max_dice = dice1; // System.out.println("max : dice1");
                        }else{
                            max_dice = dice3; // System.out.println("max : dice3");
                        }
                    }
                }else if(dice2 > dice3){ // dice2 < dice1 // dice2가 1보다 큰 상태
                    max_dice = dice2; // System.out.println("max : dice2");
                }else if(dice2 < dice3){
                    max_dice = dice3; // System.out.println("max : dice3");
                }
                System.out.println((max_dice) * 100);
            }
        // 숫자 중 가장 큰 수 구하는 로직 : heap정렬 max 공부해보기
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
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int[] input = new int[st.countTokens()];
            for(int i = 0; i < input.length; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }

            int dice1 = input[0];
            int dice2 = input[1];
            int dice3 = input[2];

            // 1.같은 눈 3개
            if(dice1 == dice2 && dice2 == dice3) {
                System.out.println(10000 + (dice1) * 1000);
            // 2.같은 눈 2개 : 1,3번기준
            }else if(dice1 != dice2 && dice1 == dice3) {
                System.out.println(1000 + (dice1) * 100);
            // 2.같은 눈 2개 : 2,3번기준
            }else if(dice2 != dice1 && dice2 == dice3) {
                System.out.println(1000 + (dice2) * 100);
            // 2.같은 눈 2개 : 1,2번기준
            }else if(dice1 == dice2 && dice1 != dice3){
                System.out.println(1000 + (dice2) * 100);
            // 3.모두 다른 눈
            }else if(dice1 != dice2 && dice2 != dice3){
                int max_dice = 0;
                // 최대값 구하기
                if(dice1 > dice2){
                    if(dice2 > dice3){
                        max_dice = dice1; // System.out.println("max : dice1");
                    }else if(dice2 < dice3){
                        if(dice1 > dice3){
                            max_dice = dice1; // System.out.println("max : dice1");
                        }else{
                            max_dice = dice3; // System.out.println("max : dice3");
                        }
                    }
                }else if(dice2 > dice3){ // dice2 < dice1 // dice2가 1보다 큰 상태
                    max_dice = dice2; // System.out.println("max : dice2");
                }else if(dice2 < dice3){
                    max_dice = dice3; // System.out.println("max : dice3");
                }
                System.out.println((max_dice) * 100);
            }
        // 숫자 중 가장 큰 수 구하는 로직 : heap정렬 max 공부해보기
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */







}
