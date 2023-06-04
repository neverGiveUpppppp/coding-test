package com.baekjoon.step5;

import java.io.*;
import java.util.ArrayList;

public class Step5_2023 {



    // Step5-1 27866	문자와 문자열
    public void method01() {
/*
조건
    1. S의 i번째 글자 출력

brainstorming
    1.인덱스 번호로 해당 값 구하기 : String.charAt()


*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String s = br.readLine();
            int i = Integer.parseInt(br.readLine());

            bw.write(s.charAt(i-1));
            bw.flush();
            bw.close();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }


    }
/*

    정답1 : .chatAt() 사용
        14236	124
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String s = br.readLine();
            int i = Integer.parseInt(br.readLine());

            bw.write(s.charAt(i-1));
            bw.flush();
            bw.close();
            br.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step5-2 2743	단어 길이 재기
    public void method02() {
/*
조건
    1. 단어 길이 출력
    2. 첫째 줄에 영어 소문자와 대문자

brainstorming
    1.길이 : length는 str?  size()는 list

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String input = br.readLine();
            bw.write(input.length()+"");
            bw.flush();
            bw.close();
            br.close();

        }catch(IOException e){
            e.printStackTrace();
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
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String input = br.readLine();
            bw.write(input.length()+"");
            bw.flush();
            bw.close();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step5-3 9086	문자열
    public void method03() {
/*
조건
    1.첫 글자와 마지막 글자를 출력

    첫째 줄 : 테스트 케이스 수(1 ≤ T ≤ 10)
        주어지는 문자열 구성 : 알파벳 A~Z 대문자,공백x, 길이 1000이하
    둘째 줄 : 테스트 수 만큼 문자열 받기

brainstorming
    1.마지막 글자 : indexOf(), lastIndexOf() -> 어떤 글자의 인덱스 번호 찾는 것
    2.글자 찾기 :
        첫글자 : chatAt(0)
        막글자 : chatAt()
                for문의 마지막?
                문자열의 length!

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1.테스트케이스 수 입력값 받기
            int t = Integer.parseInt(br.readLine());

            // 2.문자열 값 받기
            String str = null;
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < t; i++){
                str = br.readLine();
                list.add(str);
            }

            // 3.첫글자, 마지막글자 꺼내기
            for(int i = 0; i < list.size(); i++){   // 테스트케이스 수(t & list.size)만큼 for문 반복
                String firstLetter = String.valueOf(list.get(i).charAt(0)); // list에서 value를 하나씩 꺼내서 거기서 첫번째 글자 꺼내기
                String lastLetter = String.valueOf(list.get(i).charAt((list.get(i)).length()-1)); // 마지막 글자는 해당 문자열의 길이로 도출
                bw.write(firstLetter+lastLetter);
                bw.newLine();
//                System.out.println(String.valueOf(list.get(i).charAt(0)) + list.get(i).charAt((list.get(i)).length()-1));
            }
            bw.flush();
            bw.close();
            br.close();

        }catch(IOException e){
            e.printStackTrace();
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
            import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1.테스트케이스 수 입력값 받기
            int t = Integer.parseInt(br.readLine());

            // 2.문자열 값 받기
            String str = null;
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < t; i++){
                str = br.readLine();
                list.add(str);
            }

            // 3.첫글자, 마지막글자 꺼내기
            for(int i = 0; i < list.size(); i++){   // 테스트케이스 수(t & list.size)만큼 for문 반복
                String firstLetter = String.valueOf(list.get(i).charAt(0)); // list에서 value를 하나씩 꺼내서 거기서 첫번째 글자 꺼내기
                String lastLetter = String.valueOf(list.get(i).charAt((list.get(i)).length()-1)); // 마지막 글자는 해당 문자열의 길이로 도출
                bw.write(firstLetter+lastLetter);
                bw.newLine();
//                System.out.println(String.valueOf(list.get(i).charAt(0)) + list.get(i).charAt((list.get(i)).length()-1));
            }
            bw.flush();
            bw.close();
            br.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step5-3 2444	별 찍기 - 7
    public void method04() {
/*
조건
    1.

brainstorming
    1.

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

        }catch(IOException e){
            e.printStackTrace();
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


    // Step5-3 2444	별 찍기 - 7
    public void method05() {
/*
조건
    1.

brainstorming
    1.

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

        }catch(IOException e){
            e.printStackTrace();
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


    // Step5-3 2444	별 찍기 - 7
    public void method06() {
/*
조건
    1.

brainstorming
    1.

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

        }catch(IOException e){
            e.printStackTrace();
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


    // Step5-3 2444	별 찍기 - 7
    public void method07() {
/*
조건
    1.

brainstorming
    1.

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

        }catch(IOException e){
            e.printStackTrace();
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


    // Step5-3 2444	별 찍기 - 7
    public void method08() {
/*
조건
    1.

brainstorming
    1.

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

        }catch(IOException e){
            e.printStackTrace();
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


    // Step5-3 2444	별 찍기 - 7
    public void method09() {
/*
조건
    1.

brainstorming
    1.

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

        }catch(IOException e){
            e.printStackTrace();
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


    // Step5-3 2444	별 찍기 - 7
    public void method10() {
/*
조건
    1.

brainstorming
    1.

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

        }catch(IOException e){
            e.printStackTrace();
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


    // Step5-3 2444	별 찍기 - 7
    public void method11() {
/*
조건
    1.

brainstorming
    1.

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

        }catch(IOException e){
            e.printStackTrace();
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





}
