package com.baekjoon.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// Step3 : 반복문
public class Step3 {
    // Step3-1 2739번 : 구구단
    public void method01() throws IOException {
        // 조건
        // 입력 한줄 & 값 범위 : 1-9
        // 입력값으로 구구단 생성

        // brain Storming
        // 이중 포문으로 외부포문은 n단의 입력을 표현, 내부포문은 인덱스번호로 해당 수가 몇번 곱해졌는지 나타냄

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = br.read(); // .read() : int type single character reads
        int N = Integer.parseInt(br.readLine());

//        for(int i=1; i <= 9; i++){
//            for(int j=1; j <= 9; j++){
//                System.out.println(N+" * "+j+" = "+N*i);
//            }
////            N++;
//        }
        for(int i=1; i <= 9; i++){
            System.out.println(N+" * "+i+" = "+N*i);
        }




/*
정답

풀이

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i <= 9; i++){
            System.out.println(N+" * "+i+" = "+N*i);
        }

    }
}


 */
/*

BufferedReader + StringTokenizer



*/


    }

    // Step3-2 10950번 : A+B - 3
    public void method02() throws IOException {

        // brain Storming
        // 첫 줄에 하나 받고, 둘째 줄에 공백 기준으로 두개 받기
        // BufferedReader .readLine()으로 하나 받고, StringTokenizer로 공백 기준 두개 받으면 될 듯

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        int num = Integer.parseInt(br.readLine());
////        int num = br.read();
//        int a = Integer.parseInt(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());

        // error : NumberFormatException: For input string: "1 1"
        // 데이터형태가 잘못들어와서 나는 에러인데 뭐가 문제일까? 인티저로 바꿨는데
/*
        구글링 결과
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = bf.readLine().split(" ");
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        System.out.println(a+b);

 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

//        String[] str = br.readLine().split(" ");
////        String[] str = st.nextToken(" ");
//        int a = Integer.parseInt(str[0]);
//        int b = Integer.parseInt(str[1]);
//        int c = Integer.parseInt(str[2]);
//
//        System.out.println(a);
//        System.out.println(b);





/*
정답

풀이

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {

    }
}

 */


    }

    // Step3-3 8393번 : 합
    public void method03() throws IOException {

        // brain Storming
        // 조건
        //



/*
정답

풀이


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


    }
}

 */


    }

    // Step3-4 25304번 : 영수증
    public void method04() throws IOException {

        // brain Storming
        // x,y는 양수,음수 (0은 제외)




/*
정답

풀이


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {


    }
}

 */

    }

    // Step3-5 15552번 : 빠른 A+B
    public void method05() throws IOException {

        // 문제 조건
        //

/*
        // brain Storming
        //

*/




/*
정답
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");



    }
}


다른 정답


풀이



 */

    }

    // Step3-6 11021번 : A+B - 7
    public void method06() throws IOException {

        // 조건
        //


/*
        // brain Storming



 */








/*
정답

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {


    }
}

다른 정답


풀이
전체를 분으로 바뀌서 후에 60을 나누거나 나머지로 시, 분을 각각 구하는 방식



 */


    }    // Step3-7 11022번 : A+B - 8
    public void method07() throws IOException {

        // 조건
        //


/*
        // brain Storming



 */








/*
정답

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {


    }
}

다른 정답


풀이
전체를 분으로 바뀌서 후에 60을 나누거나 나머지로 시, 분을 각각 구하는 방식



 */


    }    // Step3-8 2438번 : 별 찍기 - 1
    public void method08() throws IOException {

        // 조건
        //


/*
        // brain Storming



 */








/*
정답

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {


    }
}

다른 정답


풀이
전체를 분으로 바뀌서 후에 60을 나누거나 나머지로 시, 분을 각각 구하는 방식



 */


    }    // Step3-9 2439번 : 별 찍기 - 2
    public void method09() throws IOException {

        // 조건
        //


/*
        // brain Storming



 */








/*
정답

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {


    }
}

다른 정답


풀이
전체를 분으로 바뀌서 후에 60을 나누거나 나머지로 시, 분을 각각 구하는 방식



 */


    }    // Step3-10 10952번 : A+B - 5
    public void method10() throws IOException {

        // 조건
        //


/*
        // brain Storming



 */








/*
정답

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {


    }
}

다른 정답


풀이
전체를 분으로 바뀌서 후에 60을 나누거나 나머지로 시, 분을 각각 구하는 방식



 */


    }    // Step3-11 10951번 : A+B - 4
    public void method11() throws IOException {

        // 조건
        //


/*
        // brain Storming



 */








/*
정답

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {


    }
}

다른 정답


풀이
전체를 분으로 바뀌서 후에 60을 나누거나 나머지로 시, 분을 각각 구하는 방식



 */


    }    // Step3-12 1110번 : 더하기 사이클
    public void method12() throws IOException {

        // 조건
        //


/*
        // brain Storming



 */








/*
정답

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {


    }
}

다른 정답


풀이
전체를 분으로 바뀌서 후에 60을 나누거나 나머지로 시, 분을 각각 구하는 방식



 */


    }



}
