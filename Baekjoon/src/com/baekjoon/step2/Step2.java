package com.baekjoon.step2;
import java.util.*;
import java.io.BufferedReader;

public class Step2 {

    // Step2-1 1330번 : 두 수 비교하기
    public void method01(){
        // 조건 
        // 한 줄에 두 수 받기

        // brain Storming
        // if문 사용
        // 한 줄에 두 수 받기 뭐가 있을까
        // 한 줄에 공백으로 두개 받고 구분자로 나누기? StringTokenizer
        // 방법1 : Scanner + split()
        // 방법2 : BufferedReader + StringTokenizer

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
//        System.out.println(num);    // 1 2

        String[] nums = num.split(" "); // String Class인 split()은 배열로 반환하므로, 배열로 받아야함
//        System.out.println(Arrays.toString(nums)); // [1, 2]

        // 배열로 받은 것을 인덱스 번호로 수 2개로 나눔
        int num1 =  Integer.parseInt(nums[0]);
        int num2 =  Integer.parseInt(nums[1]);

        if(num1 < num2){
            System.out.println("<");
        }else if(num1 > num2){
            System.out.println(">");
        }else {
            System.out.println("==");
        }
/*
정답


<Scanner + String Class split() 방법>
스캐너로 숫자1 공백 숫자2 이런식으로 입력을 받고,
공백을 기준으로 split을 이용하여 나눠서 배열에 넣는다(split이 배열로 반환하기에 배열로 받아줘야함)
이후 배열의 인덱스번호로 두 수를 지정하고 int로 형변환 해주면서 각각 변수에 넣어주고 if문으로 조건을 주어서 출력

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        String[] nums = num.split(" "); // String Class인 split()은 배열로 반환하므로, 배열로 받아야함


        // 배열로 받은 것을 인덱스 번호로 수 2개로 나눔
        int num1 =  Integer.parseInt(nums[0]);
        int num2 =  Integer.parseInt(nums[1]);

        if(num1 < num2){
            System.out.println("<");
        }else if(num1 > num2){
            System.out.println(">");
        }else {
            System.out.println("==");
        }

    }
}

 */

    }

    // Step2-2 9498번 : 시험 성적
    public void method02(){




    }

    // Step2-3 2753번 : 윤년
    public void method03(){


    }

    // Step2-4 14681번 : 사분면 고르기
    public void method04(){


    }

    // Step2-5 2884번 : 알람 시계
    public void method05(){


    }

    // Step2-6 2525번 : 오븐 시계
    public void method06(){


    }

    // Step2-7 2480번 : 주사위 세개
    public void method07(){


    }







}
