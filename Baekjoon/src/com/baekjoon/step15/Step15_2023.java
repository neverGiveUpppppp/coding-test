package com.baekjoon.step15;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// Step15-1 1934 최소공배수
class Step15_1{
/*
조건
    두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수
    이런 공배수 중에서 가장 작은 수를 최소공배수
        ex)6과 15의 공배수는 30, 60, 90 등이 있으며, 최소 공배수는 30
    두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수 구하는 프로그램 작성
    1.첫째 줄 테스트케이스 수 (1 <= T <= 1000)
    2.둘째 줄 A,B 입력

braintstorm
    1.A,B의 각 배수
    2.공배수 : A,B의 배수 중 공통 수 : 해당 수 / A,B
    3.최소 공배수 : 공배수 중 최솟값. 최솟값 알고리즘 적용


*/
    public static void main(String[] args) throws IOException{
        Step15_1 main = new Step15_1();

//        // 1.테스트케이스 횟수 값 받기
//        int testcaseNum = main.testcaseNum();
//        // 2.각 A,B값 받기
//        main.inputAB(testcaseNum);

        // 1.input값 받기
        main.input();

        // 3.각 A,B의 배수 구하기

//        main.multiple();
//        main.common_multiple();
//        main.least_common_multiple();

    }

//    private int testcaseNum() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int testcaseNum = Integer.parseInt(br.readLine());
//
//        StringTokenizer st = null;
//        int[] arrInt = new int[1];
//        st = new StringTokenizer(br.readLine()," ");
//        for(int i = 0; i < subject; i++){
//            arrInt[i] = Integer.parseInt(st.nextToken());  // 배열 수 정해놓고 이상의 값이 들어오면 무효화. 적게 들어오면 에러발생
//        }
//        return testcaseNum;
//    }
//    private void inputAB(int testcaseNum) {
//    }
    private void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int testcase = Integer.parseInt(br.readLine());

//        ArrayList<Integer>[] list = new ArrayList[testcase];
//        for(int i = 0; i < testcase; i++){
//            list[i] = new ArrayList<>();
//            st = new StringTokenizer(br.readLine()," ");
//            for (int j = 0; j < 2; i++) { // 가로 입력값 2개 받으니 2번 돌아가도록
//                list[i].add(Integer.parseInt(st.nextToken()));
//            }
//        }

        ArrayList<Integer>[] list = new ArrayList[testcase];
        for (int i = 0; i < testcase; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < testcase; i++){
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 2; i++) { // 가로 입력값 2개 받으니 2번 돌아가도록
                System.out.println("list[0] : " + list[0]);
                System.out.println("list[0] : " + list[1]);
                list[i].add(j);
//                list[i].add(list[j].add(Integer.parseInt(st.nextToken())));
//                list[i][j].add(Integer.parseInt(st.nextToken()));
//                list[i].add(list[j].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i< list.length; i++){
            for(int j=0; j< 2; j++){
                System.out.println(list[i].get(j)); // 해당 값 확인
            }
        }


//        System.out.println(Arrays.toString(arrInt));
//        System.out.println(list[0]);

    }

    private void multiple(int inputA, int inputB){

    }


    private void common_multiple(){

    }


    private void least_common_multiple(){

    }


}


/*

    정답1
        14088	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {


    }
}

*/



// Step15-2 13241 최소공배수
class Step15_2{
/*
조건
    1.
    2.

braintstorm
    1.
    2.

*/

}


/*

    정답1
        14088	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {


    }
}

*/




// Step15-3 1735 분수 합
class Step15_3{
/*
조건
    1.
    2.

braintstorm
    1.
    2.

*/

}


/*

    정답1
        14088	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {


    }
}

*/




// Step15-4 2485 가로수
class Step15_4{
/*
조건
    1.
    2.

braintstorm
    1.
    2.

*/

}


/*

    정답1
        14088	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {


    }
}

*/




// Step15-5 4134 다음 소수
class Step15_5{
/*
조건
    1.
    2.

braintstorm
    1.
    2.

*/

}


/*

    정답1
        14088	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {


    }
}

*/




// Step15-6 1929 소수 구하기
class Step15_6{
/*
조건
    1.
    2.

braintstorm
    1.
    2.

*/

}


/*

    정답1
        14088	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {


    }
}

*/



// Step15-7 4948 베르트랑 공준
class Step15_7{
/*
조건
    1.
    2.

braintstorm
    1.
    2.

*/

}


/*

    정답1
        14088	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {


    }
}

*/



// Step15-8 17103 골드바흐 파티션
class Step15_8{
/*
조건
    1.
    2.

braintstorm
    1.
    2.

*/

}


/*

    정답1
        14088	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {


    }
}

*/




// Step15-9 13909  창문 닫기
class Step15_9{
/*
조건
    1.
    2.

braintstorm
    1.
    2.

*/

}


/*

    정답1
        14088	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {


    }
}

*/




public class Step15_2023 {


}
