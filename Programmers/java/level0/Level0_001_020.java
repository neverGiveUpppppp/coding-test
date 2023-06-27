package level0;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

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






}






// level0 011 : 배열의 평균값
class Solution011 {
    public static void main(String[] args) {
        Solution011 prbs = new Solution011();
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        prbs.solution(numbers);
        System.out.println(prbs.solution(numbers));
    }
    public double solution(int[] numbers) {
        double answer = 0;
        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
//        answer = (double) (sum / numbers.length);  // 소괄호 먼저 int끼리 계산하면 소수점아래는 절삭되서 나와서 각각 소수로 치환 후 나눠줘야 정확히 떨어짐
        answer = ((double)sum / (double)numbers.length);
//        System.out.println(sum);
//        System.out.println(numbers.length);
//        System.out.println(sum / numbers.length);
//        System.out.println(answer);
        return answer;
    }
}

/*

    정답1
class Solution011 {
    public double solution(int[] numbers) {
        double answer = 0;
        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
//        answer = (double) (sum / numbers.length);  // 소괄호 먼저 int끼리 계산하면 소수점아래는 절삭되서 나와서 각각 소수로 치환 후 나눠줘야 정확히 떨어짐
        answer =  ((double)sum / (double)numbers.length);
        return answer;
    }
}

 */




// level0 012 : 양꼬치
class Solution012 {
/*
조건
    1.


brainstorming
    (10 * 12000) + (3 * 2000) if(10마다) - 2000 = 124000
    (n * 12000) + (k * 2000) - if(10마다) {l * 2000}

    n 10개마다 k 1개 서비스 : n % 10 == 0
*/

    public static void main(String[] args) {
        Solution012 prbs = new Solution012();
//        System.out.println(prbs.solution(64, 6));
        System.out.println(prbs.solution(10, 3));
    }
    public int solution(int n, int k) {
        int answer = 0;

        if(n % 10 >= 0 && n / 10 >= 1){
        // n이 10의 배수이면서 10나누기10 1이상 즉, 10개가 1개 이상이면서 10의 배수로 20,30개라면

            answer = (n * 12000) + (k * 2000) - ((n /10) * 2000);
        }else{
            answer = (n * 12000) + (k * 2000);
        }
        int a = (n * 12000) + (k * 2000);
        System.out.println(a);
        System.out.println((n %10));

        return answer;
    }
}

/*

    정답1
class Solution012 {
    public int solution(int n, int k) {
        int answer = 0;
        if(n % 10 >= 0 && n / 10 >= 1){
        // n이 10의 배수이면서 10나누기10 1이상
        // 즉, 10개가 1개 이상이면서 10의 배수로 20,30개라면
            answer = (n * 12000) + (k * 2000) - ((n /10) * 2000);
        }else{
            answer = (n * 12000) + (k * 2000);
        }
        return answer;
    }
}

 */




// level0 013 : 피자 나눠 먹기 (1)
class Solution013 {
    public static void main(String[] args) {
        Solution013 prbs = new Solution013();
        System.out.println(prbs.solution(8));
    }
    public int solution(int n) {
        int answer = 0;

        if(n%7 == 0){
            answer = (n / 7);
            // 7과 딱 맞아떨어지는 수면 나머지가 없어 +1해주면 안되기 때문
        }else{
            answer = (n / 7) + 1;
        }
        return answer;
    }
}
/*
조건
	피자 7조각
    나눠먹을 사람 수 : n
    인당 1조각을 위한 피자수

brainstorming
	피자 한판당 7명까지 : 7의 배수d
    나눈 몫 = 필요한 피자 판 수
    	만약, 나머지가 있다면 몫+1

*/

/*

    정답1
class Solution013 {
    public int solution(int n) {
        int answer = 0;

        if(n%7 == 0){
            answer = (n / 7);
            // 7과 딱 맞아떨어지는 수면 나머지가 없어 +1해주면 안되기 때문
        }else{
            answer = (n / 7) + 1;
        }
        return answer;
    }
}

 */




// level0 014 : 최댓값 만들기(1)
class Solution014 {
    public static void main(String[] args) {
        Solution014 prbs = new Solution014();
        prbs.solution(1);
        System.out.println(prbs.solution(1));
    }
    public int solution(int n) {
        int answer = 0;


        return answer;
    }
}
/*
조건
    1.

brainstorming
    1.

*/

/*

    정답1


 */




// level0 015 : 배열 뒤집기
class Solution015 {
    public static void main(String[] args) {
        Solution015 prbs = new Solution015();
        prbs.solution(1);
        System.out.println(prbs.solution(1));
    }
    public int solution(int n) {
        int answer = 0;


        return answer;
    }
}
/*
조건
    1.

brainstorming
    1.

*/

/*

    정답1


 */




// level0 016 : 순서쌍의 개수
class Solution016 {
    public static void main(String[] args) {
        Solution016 prbs = new Solution016();
        prbs.solution(1);
        System.out.println(prbs.solution(1));
    }
    public int solution(int n) {
        int answer = 0;


        return answer;
    }
}
/*
조건
    1.

brainstorming
    1.

*/

/*

    정답1


 */




// level0 017 : 순서쌍의 개수
class Solution017 {
    public static void main(String[] args) {
        Solution017 prbs = new Solution017();
        prbs.solution(1);
        System.out.println(prbs.solution(1));
    }
    public int solution(int n) {
        int answer = 0;


        return answer;
    }
}
/*
조건
    1.

brainstorming
    1.

*/

/*

    정답1


 */




// level0 018 : 배열 원소의 길이
class Solution018 {
    public static void main(String[] args) {
        Solution018 prbs = new Solution018();
        String[] strlist = new String[]{"We","are","the","world!"};
        int[] answer = prbs.solution(strlist);
        System.out.println(Arrays.toString(answer));
    }
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];

        for (int i = 0; i < strlist.length; i++) {
            answer[i] = strlist[i].length();
        }

        return answer;
    }
}
/*
조건
    1.배열 안에 값의 길이 각각 구하기
    2.캐스팅 str to int

brainstorming
    1.for loop 돌려서 하나씩 빼서 길이 구하기

*/

/*

    정답1
class Solution018 {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];

        for (int i = 0; i < strlist.length; i++) {
            answer[i] = strlist[i].length();
        }

        return answer;
    }
}

 */




// level0 019 : 짝수 홀수 개수
class Solution019 {
    public static void main(String[] args) {
        Solution019 prbs = new Solution019();
        prbs.solution(1);
        System.out.println(prbs.solution(1));
    }
    public int solution(int n) {
        int answer = 0;


        return answer;
    }
}
/*
조건
    1.

brainstorming
    1.

*/

/*

    정답1


 */




// level0 020 : 편지
class Solution020 {
    public static void main(String[] args) {
        Solution020 prbs = new Solution020();
        prbs.solution(1);
        System.out.println(prbs.solution(1));
    }
    public int solution(int n) {
        int answer = 0;


        return answer;
    }
}
/*
조건
    1.

brainstorming
    1.

*/

/*

    정답1


 */




/*
못 푼 문제(다시풀어보기)
    1.


 */