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
