package com.baekjoon.step9;


import java.io.*;
import java.util.*;

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

/*
    문제풀이
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = null;

            // 1.테스트케이스 입력값 받기
            int testcase = Integer.parseInt(br.readLine());

            int[][] numbers = new int[testcase][2];
            for (int i = 0; i < testcase; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                while(st.hasMoreTokens()){
                    numbers[i][0] = Integer.parseInt(st.nextToken());
                    numbers[i][1] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(Arrays.toString(numbers[0]));
            System.out.println(Arrays.toString(numbers[1]));
            System.out.println(Arrays.deepToString((numbers)));

            // 2.약수배수 판별하기
            for (int i = 0; i < testcase; i++) {
                if (numbers[i][1] % numbers[i][0] == 0){
                    System.out.println("factor");
                }else if(numbers[i][0] % numbers[i][1] == 0){
                    System.out.println("multiple");
                }else{
                    System.out.println("neither");
                }
//                약수 : a % b == 0
//                배수 : b % a == 0
            }

            System.out.println( 8 % 16 );

    // 테스트케이스 입력값 받는 게 없이 0 0 받으면 종류시켜야하는 조건인 듯

//        try{
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            StringTokenizer st = null;

//            ArrayList<Integer> list = new ArrayList<>();
//            int temp = -1;
//            int i = 0;
//            // 1. 입력 값 받기(0 0이면 값 받기 종료)
//            while(list.get(i) != 0){
//                st = new StringTokenizer(br.readLine(), " ");
//                while(st.hasMoreTokens()){
//                    list.add(Integer.parseInt(st.nextToken()));
////                    list[i][1] = Integer.parseInt(st.nextToken());
//                    i++;
//                }
//            }

//            // 2차원 arrayList 해보기
//            ArrayList<String>[] list = new ArrayList[2];
//            String[] tempArray = new String[list.length];
//            for(int i = 0; i < list.length; i++){
//                for(int j = 0; j < tempArray.length; j++){
//                    list[i].add("추가할 값"); // 해당 값 추가
//                }
//            }

//            // 1.테스트케이스 입력값 받기
//            int testcase = Integer.parseInt(br.readLine());
//
//            int[][] numbers = new int[testcase][2];
//            for (int i = 0; i < testcase; i++) {
//                st = new StringTokenizer(br.readLine(), " ");
//                while(st.hasMoreTokens()){
//                    numbers[i][0] = Integer.parseInt(st.nextToken());
//                    numbers[i][1] = Integer.parseInt(st.nextToken());
//                }
//            }
//            System.out.println(Arrays.toString(numbers[0]));
//            System.out.println(Arrays.toString(numbers[1]));
//            System.out.println(Arrays.deepToString((numbers)));
//
//            // 2.약수배수 판별하기
//            for (int i = 0; i < testcase; i++) {
//                if (numbers[i][1] % numbers[i][0] == 0){
//                    System.out.println("factor");
//                }else if(numbers[i][0] % numbers[i][1] == 0){
//                    System.out.println("multiple");
//                }else{
//                    System.out.println("neither");
//                }
////                약수 : a % b == 0
////                배수 : b % a == 0
//            }
//            System.out.println( 8 % 16 );



            // 1.테스트케이스 입력값 받기
            //      배열 생성할려면 길이를 정해야함 -> 길이는 입력값을 다 받아야 알 수 있음
            //      그럼 입력값을 StringBuilder로 쌓아서 받고 배열 변환은 어때?
//            StringBuilder sb = new StringBuilder();
//            String input = "";
//            while((sb.append(st = new StringTokenizer(br.readLine()," "))+" ") != null && !sb.isEmpty()) {

            

//            while(sb.toString() != "0 0"){
//                st = new StringTokenizer(br.readLine()," ");
//                while(st.hasMoreTokens()){
//                    sb.append(st.nextToken() + "\n");
//                    sb.append(st.nextToken() + "\n");
//                }
//            }

// 정해진 입력값 라인 수 없이 0 0이 들어와야 종료해야하는 조건
// 정해진 입력값 라인수가 없어 배열 생성 불가
// 받는 입력값 형태도 구분자가(" ")가 필요해서 split()내지는 StringTokenizer가 필요한데 정해진 라인수가 없다보니 까다로워서 막힌 상태
// 일단 입력값 받는 종료 조건이 0 0이라 이 처리가 안되는 상태
//            String inputt = "";
//            String str = "";
//            while((inputt = br.readLine()) != null && !inputt.isEmpty()){
////                st = new StringTokenizer(br.readLine()," ");
////                while(st.hasMoreTokens()){
////                    inputt += st.nextToken() + "\n";
////                    inputt += st.nextToken() + "\n";
////                }
//                str += inputt + "\n";
//            }
//            System.out.println(inputt);
//            System.out.println(str);

//            String inputt = "";
//            String str = "";
//            while((inputt = br.readLine()) != null && !inputt.isEmpty()){
////                st = new StringTokenizer(br.readLine()," ");
////                while(st.hasMoreTokens()){
////                    inputt += st.nextToken() + "\n";
////                    inputt += st.nextToken() + "\n";
////                }
//                str += inputt + "\n";
//                if(str == ("0 0" + "\n")){
//                    break;
//                }
//            }
//            System.out.println(inputt);
//            System.out.println(str);
//        try{
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            StringTokenizer st = null;
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }
*/
// 값 가로 한줄 받고 출력 가능하고 조건이 아니면 다시 가로 한 줄 받는 구조가 가능한 걸 알았다면 
// 진작 풀었을 것을... 백준 문제가 너무 불친절하다. 입력 예제에는 한번에 다 받는 것처럼 해놓고ㅡㅡ
        
        
/******************************************************************************/

        // 방법1
//        Scanner sc = new Scanner(System.in);
//        while(true){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//
//            if(a == 0 && b ==0){
//                break;
//            }
//
//            if(b % a == 0){
//                System.out.println("factor");
//            }else if ( a % b == 0){
//                System.out.println("multiple");
//            }else{
//                System.out.println("neither");
//            }
//        }

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");

                int firstNum = Integer.parseInt(st.nextToken());
                int secondNum = Integer.parseInt(st.nextToken());

                if(firstNum == 0 && secondNum == 0)
                    break;

                if(secondNum % firstNum == 0){
                    sb.append("factor\n");
                }else if(firstNum % secondNum == 0){
                    sb.append("multiple\n");
                }else {
                    sb.append("neither\n");
                }
            }
            System.out.println(sb.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }



}


/*

    정답1 : Scanner
        17276	204
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
        while(true) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            if(A == 0 && B == 0)
                break;

            if(B % A == 0)
                System.out.println("factor");
            else if(A % B == 0)
                System.out.println("multiple");
            else
                System.out.println("neither");
        }
    }
}


    정답2 :
    	14016	120
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");

                int firstNum = Integer.parseInt(st.nextToken());
                int secondNum = Integer.parseInt(st.nextToken());

                if(firstNum == 0 && secondNum == 0)
                    break;

                if(secondNum % firstNum == 0){
                    sb.append("factor\n");
                }else if(firstNum % secondNum == 0){
                    sb.append("multiple\n");
                }else {
                    sb.append("neither\n");
                }
            }
            System.out.println(sb.toString());

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






