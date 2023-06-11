package level0;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Level0_001_020 {
// 문제 순서 정렬 : 정답률 높은 순


    // level0 001 : 몫 구하기
    public void method001() {
        int num1 = 10;
        int num2 = 5;

        int answer = 0;
        answer = num1 / num2;
        System.out.println(answer);
    }

/*

    정답1
class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        answer = num1 / num2;
        return answer;
    }
}
 */




    // level0 002 : 두 수의 곱
    public void method002() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1
class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        answer = num1 * num2;
        return answer;
    }
}

 */



    // level0 003 : 두 수의 차
    public void method003() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1
class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        answer = num1 - num2;
        return answer;
    }
}

 */




    // level0 004 : 나머지 구하기
    public void method004() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1
class Solution {
    public int solution(int num1, int num2) {
        int answer = -1;
        answer = num1 % num2;
        return answer;
    }
}

 */




    // level0 005 : 숫자 비교하기
    public void method005() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1
class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        if(num1 == num2){
            answer = 1;
        } else{
            answer = -1;
        }
        return answer;
    }
}

 */




    // level0 006 : 나이 출력
    public void method006() {
/*
brainstorming
	일단 한번 연도 계산해보기 : 2022-40 = 1982 + 1
    실제 1983년생

*/

    }
/*

    정답1
class Solution {
    public int solution(int age) {
        int answer = 0;
        answer = 2022 - age + 1;

        return answer;
    }
}

 */




    // level0 007 : 두 수의 합
    public void method007() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1
class Solution {
    public int solution(int num1, int num2) {
        int answer = -1;
        answer = num1 + num2;
        return answer;
    }
}

 */




    // level0 008 : 두 수의 나눗셈
    public void method008() {
/*
조건
    1.계산 후 정수만 출력

brainstorming
    1.Math.

*/
        int num1 = 7;
        int num2 = 3;
        int answer = 0;
//        double num1 = 7.0;
//        double num2 = 3.0;
//        System.out.printf("%10.5f",num1/num2);
        answer = (int)(((double)num1 / (double)num2) * 1000);
        System.out.println(answer);
        System.out.println(7/3);
        System.out.println(((double)num1 / (double)num2 * 1000));
        System.out.println(Math.abs(num1 / num2 * 1000));
        System.out.println(Math.floor(num1 / num2 * 1000));

        // 입력값이 int이고 나누기 때문에 계산이 소수가 나오면서 double이 필요한데
        // 다시 정수를 뽑아야하므로 int -> double -> int로 파싱 필요
    }
/*

    정답1
class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        answer = (int)(((double)num1 / (double)num2) * 1000);
        return answer;
    }
}

 */




    // level0 009 : 각도기
    public void method009() {
/*
조건
    1.

brainstorming
	값에 따른 분류이므로 flowcontroll필요

*/

    }
/*

    정답1

class Solution {
    public int solution(int angle) {
        int answer = 0;

        if(0 < angle && angle < 90){
            answer = 1;
        }else if(angle == 90){
            answer = 2;
        }else if( 90 < angle && angle < 180){
            answer = 3;
        }else if(angle == 180){
            answer = 4;
        }

        return answer;
    }
}

 */




    // level0 010 : 짝수의 합
    public void method010() {
/*
조건
    1.

brainstorming
	n이하 짝수 모두 더하기
    짝수 : n%2 == 0
    n이하 짝수 구하기 : ?
    n=10
    2 4 6 8 10 = 30

    loop i로 0부터 n까지 반복하면서 n%2 == 0이면 짝수 n%2 != 0이면 홀수 식으로 sum에 더하면 됨

*/

        int answer = 0;
        for(int i = 0; i <= 10; i++){
            if(i % 2 == 0)
                answer += i;
        }
        System.out.println(answer);


    }
/*

    정답1
class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 0; i <= n; i++){
            if(i % 2 == 0)
            	answer += i;
        }
        return answer;
    }
}

 */




    // level0 011 : 배열의 평균값
    public void method011() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1


 */




    // level0 012 : 양꼬치
    public void method012() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1


 */




    // level0 013 : 중복된 숫자 개수
    public void method013() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1


 */




    // level0 014 : 점의 위치 구하기
    public void method014() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1


 */




    // level0 015 : 짝수 홀수 개수
    public void method015() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1


 */




    // level0 016 : 최댓값 만들기(1)
    public void method016() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1


 */




    // level0 017 : 피자 나눠 먹기 (1)
    public void method017() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1


 */




    // level0 018 : 편지
    public void method018() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1


 */




    // level0 019 : 배열의 유사도
    public void method019() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1


 */




    // level0 020 : 옷가게 할인 받기
    public void method020() {
/*
조건
    1.

brainstorming
    1.

*/

    }
/*

    정답1


 */


    
    
/*
못 푼 문제(다시풀어보기)
    1.


 */


}