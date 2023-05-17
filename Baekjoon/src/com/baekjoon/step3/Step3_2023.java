package com.baekjoon.step3;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Step3_2023 {

    private int a;

    // Step3-1 2739	: 구구단
    public void method01() {
/*
조건
    숫자 범위 1-9
*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int multiplication_table = Integer.parseInt(br.readLine());

            for(int i = 1; i < 10; i++){
                System.out.printf("%d * %d = %d\n",multiplication_table, i, multiplication_table*i);
            }
            // 1-9까지 다 뽑는 구구단
    //        for(int i = 1; i < 10; i++){
    //            for(int j = 1; j < 10; j++){
    //                System.out.printf("%d * %d = %d\n",i,j,i*j);
    //            }
    //        }
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
        try{
            int multiplication_table = Integer.parseInt(br.readLine());
            for(int i = 1; i < 10; i++){
                System.out.printf("%d * %d = %d\n",multiplication_table, i, multiplication_table*i);
            }
            // 1-9까지 다 뽑는 구구단
    //        for(int i = 1; i < 10; i++){
    //            for(int j = 1; j < 10; j++){
    //                System.out.printf("%d * %d = %d\n",i,j,i*j);
    //            }
    //        }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step3-2 10950 : A+B - 3
    public void method02() {
/*
조건
    인풋한 테스트케이스 수 만큼 문장 반복하고 그에 따라 A+B 연산해야하는 문제

brainstorming


*/
//        try{
////            Scanner sc = new Scanner(System.in);
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            StringTokenizer st = new StringTokenizer(br.readLine(), " "); // st에서 br을 불러와야하니 st부터 실행됐던 것!
//            int testCase = Integer.parseInt(br.readLine()); // br 받은 후 st 받으면 에러발생 : NumberFormatException
//            int testCase1 = Integer.parseInt(String.valueOf(br.read())); // br 받은 후 st 받으면 에러발생 : NumberFormatException

//            int testCase = sc.nextInt(); // 어째서인지 변수로 값이 안들어감. println으로 더미값 하나 넣어줘도 같음
//            int testCase = Integer.parseInt(sc.nextLine()) ; // 어째서인지 변수로 값이 안들어감. println으로 더미값 하나 넣어줘도 같음
//            System.out.println(); // 어째서인지 변수로 값이 안들어감. println으로 더미값 하나 넣어줘도 같음

            // 스캐너 객체가 먼저 생성되고 변수 testCase가 input변수보다 먼저 선언되는데도 st가 먼저 입력되게끔한다.
            // 왜지? 여튼 st를 먼저 입력하고 스캐너 입력하면 오류x
            // br도 그런가 해보자 : br도 마찬가지. st먼저 입력하고 br 입력해야 오류가 안난다

//            int testCase = Integer.parseInt(br.readLine());
//            System.out.println("testCase : "+testCase);
//        try{

//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int testCase = Integer.parseInt(br.readLine());

//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//            int[] input = new int[st.countTokens()];
//            for(int i = 0; i < input.length; i++){
//                input[i] = Integer.parseInt(st.nextToken());
//            }
//            int num1 = input[0];
//            int num2 = input[1];

//            StringTokenizer st = new StringTokenizer(br.readLine()," ");
//            int[] input = new int[st.countTokens()]; // new int[2]
//            int num1;
//            int num2;
//            for(int i = 0; i < testCase; i++){
//                for(int j = 0; j < input.length; j++){ // j < 2 : 0 1 두번 돌기
//                    input[j] = Integer.parseInt(st.nextToken()); // 한바퀴 돌고나서 두바퀴째에 여기서 에러발생 :.NoSuchElementException
//                }                                                //  원인??
//                num1 = input[0];
//                num2 = input[1];
//                System.out.println(num1 + num2);
//            }

//            StringTokenizer st = new StringTokenizer(br.readLine()," ");
//            int num1 = 0;
//            int num2 = 0;
//            for(int i = 0; i < testCase; i++) {
//                while (st.hasMoreTokens()) {
//                    num1 = Integer.parseInt(st.nextToken());
//                    num2 = Integer.parseInt(st.nextToken());
//                }
//                System.out.println(num1 + num2);
//            }
//            얘도 계속 2만 세로로 나옴



//            System.out.println("num1 : "+ num1);
//            System.out.println("num2 : "+ num2);

//        try{
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int testCase = Integer.parseInt(br.readLine());
//            int[] testCase_times = new int[testCase];
//
//            StringTokenizer st = new StringTokenizer(br.readLine()," ");
//            int[] input = new int[st.countTokens()]; // new int[2]
//            int num1 = 0;
//            int num2 = 0;
//            for(int i = 0; i < testCase; i++) {
//                while (st.hasMoreTokens()) {
//                    num1 = Integer.parseInt(st.nextToken());
//                    num2 = Integer.parseInt(st.nextToken());
//                }
//                testCase_times[i] = num1 + num2;
//            }
//            for(int num : testCase_times){
//                System.out.println(num);
//            }

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int testCase = Integer.parseInt(br.readLine());

            for (int i = 0; i < testCase; i++) {
                String[] str = br.readLine().split(" ");

                int A = Integer.parseInt(str[0]);
                int B = Integer.parseInt(str[1]);

                int sum = A + B;
                bw.write(sum + "\n"); // int + str은 str으로 변환됨
            }
            bw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }




    }
/*
    정답
    방법1 : BufferedReader + BufferedWriter
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int testCase = Integer.parseInt(br.readLine());

            for (int i = 0; i < testCase; i++) {
                String[] str = br.readLine().split(" ");

                int A = Integer.parseInt(str[0]);
                int B = Integer.parseInt(str[1]);

                int sum = A + B;
                bw.write(sum + "\n");
            }
            bw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

    방법2 : 스캐너
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int[] sum = new int[A];

        for (int i = 0; i < A; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            sum[i] = x+y;
        }
        for(int num : sum){
            System.out.println(num);
        }
    }
}

 */


    // Step3-3 8393 : 합
    public void method03() {
/*
조건
    1부터 n까지 합 구하기

brainstorming
    (n-(n-1)) + (n-(n-2)) + ... + (n-(n-n))
    1(5-4) + 2(5-3) + 3(5-2) + 4(5-1) + 5(5-0)
    for문 이용해서 n의 숫자만큼 -1해가면서 +시키는 건?


*/
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            int sum = 0;

            for(int i = 1; i <= n; i++){
                sum += n-(n-i);
            }
//            bw.write(String.valueOf(sum));
            bw.write(sum); //  출력됨. 왜지...? 
            // A.아스키코드로 변환되기 때문
            // 위 메소드 bw에서는 int + str(개행문자)은 str으로 변환되기 때문에 문제x
            bw.flush();
            bw.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*
    정답
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            int sum = 0;

            for(int i = 1; i <= n; i++){
                sum += n-(n-i);
            }
            bw.write(String.valueOf(sum));
            bw.flush();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step3-4 25304 : 영수증
    public void method04() {
/*
조건
    조리시간 : 최대 1000분

brainstorming
맨 처음 X하나를 받고, 이후에 N 수에 따라 반복문을 돌리고 그 안에서 a,b 수를 받는다


*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            int X = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            for(int i = 1; i <= N; i++){
                String[] num = br.readLine().split(" "); // split()과 함께 통째로 int로 파싱안됨
                int a = Integer.parseInt(num[0]);       // 일단 array에 값을 받은 후, 다시 변수에 넣어줄 때 파싱해야함
                int b = Integer.parseInt(num[1]);       // 

                sum += a*b;
            }
            if(sum == X){
                bw.write("Yes");
                bw.flush();
//                System.out.print("Yes");
            }else{
                bw.write("No");
                bw.flush();
//                System.out.print("No");
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
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            int X = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            for(int i = 1; i <= N; i++){
                String[] num = br.readLine().split(" "); // split()과 함께 통째로 int로 파싱안됨
                int a = Integer.parseInt(num[0]);       // 일단 array에 값을 받은 후, 다시 변수에 넣어줄 때 파싱해야함
                int b = Integer.parseInt(num[1]);       //

                sum += a*b;
            }
            if(sum == X){
                System.out.print("Yes");
            }else{
                System.out.print("No");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step3-5 25314 : 코딩은 체육과목 입니다
    public void method05() {
/*
조건
    조리시간 : 최대 1000분

brainstorming


*/

    }
/*
    정답
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {

    }
}

 */


    // Step3-6 15552 : 빠른 A+B
    public void method06() {
/*
조건
    조리시간 : 최대 1000분

brainstorming


*/

    }
/*
    정답
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {

    }
}

 */


    // Step3-7 11021 : A+B - 7
    public void method07() {
/*
조건
    조리시간 : 최대 1000분

brainstorming


*/

    }
/*
    정답
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {

    }
}

 */


    // Step3-8 11022 : A+B - 8
    public void method08() {
/*
조건
    조리시간 : 최대 1000분

brainstorming


*/

    }
/*
    정답
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {

    }
}

 */


    // Step3-9 	2438 : 별 찍기 - 1
    public void method09() {
/*
조건
    조리시간 : 최대 1000분

brainstorming


*/

    }
/*
    정답
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {

    }
}

 */


    // Step3-10 2439 : 별 찍기 - 2
    public void method10() {
/*
조건
    조리시간 : 최대 1000분

brainstorming


*/

    }
/*
    정답
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {

    }
}

 */


    // Step3-11 10952 : A+B - 5
    public void method11() {
/*
조건
    조리시간 : 최대 1000분

brainstorming


*/

    }
/*
    정답
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {

    }
}

 */


    // Step3-12 10951 : A+B - 4
    public void method12() {
/*
조건
    조리시간 : 최대 1000분

brainstorming


*/

    }
/*
    정답
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {

    }
}

 */




}
