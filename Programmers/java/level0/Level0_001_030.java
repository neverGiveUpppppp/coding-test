package level0;


import java.util.Arrays;

public class Level0_001_030 {
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
            answer = (n / 7);  // 7과 딱 맞아떨어지는 수면 나머지가 없어 +1해주면 안되기 때문
        }else{
            answer = (n / 7) + 1;
        }
        return answer;
    }
}

 */




// level0 014 : 편지
class Solution014 {
    public static void main(String[] args) {
        Solution014 prbs = new Solution014();
        prbs.solution("");
        System.out.println(prbs.solution("happy birthday!"));
    }
    public int solution(String message) {
        int answer = 0;
        answer = message.length() * 2;

        return answer;
    }
}
/*
조건
    1.한 글자 * 2 & 가로 한 줄
    2.영문 알파벳 대소문자, ‘!’, ‘~’ 또는 공백
    3.1 ≤ message의 길이 ≤ 50


brainstorming
    1.글자 수 카운트 = length

*/

/*

    정답1
class Solution {
    public int solution(String message) {
        int answer = 0;
        answer = message.length() * 2;
        return answer;
    }
}


 */




// level0 015 : 배열 뒤집기
class Solution015 {
    public static void main(String[] args) {
        Solution015 prbs = new Solution015();
        int[] arr = new int[]{1,2,3,4,5};
        prbs.solution(arr);
        System.out.println(Arrays.toString(prbs.solution(arr)));
    }
    public int[] solution(int[] num_list) {
//        StringBuilder sb = new StringBuilder(Arrays.toString(arr));
//        String reverse = sb.reverse().toString();
//        System.out.println(reverse); // ]5 ,4 ,3 ,2 ,1[
        int[] answer = new int[num_list.length];
        int j = 0;
        for (int i = num_list.length; i > 0; i--) {
            answer[j] += num_list[i-1];
            j++;
        }
        return answer;
    }
}
/*
조건
    1.입력값 : 정수 배열
    2.배열 순서 거꾸로 뒤집기

brainstorming
    1.StringBuilder.reverse()로 파싱 후 다시 배열로 파싱
    2.loop로 거꾸로 다시 넣기
        - for문으로 i해서 끝부터 거꾸로 넣기 & reverse한 배열

*/

/*

    정답1
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        int j = 0;
        for (int i = num_list.length; i > 0; i--) {
            answer[j] += num_list[i-1];
            j++;
        }
        return answer;
    }
}

 */




// level0 016 : 최댓값 만들기 (1)
class Solution016 {
    public static void main(String[] args) {
        Solution016 prbs = new Solution016();
        int[] numbers = new int[]{0, 31, 24, 10, 1, 9};
        prbs.solution(numbers);
        System.out.println(prbs.solution(numbers));
    }
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        answer = numbers[numbers.length-1] * numbers[numbers.length-2];
//        answer = numbers.length * (numbers.length-1);
        return answer;
    }
}
/*
조건
    1.numbers의 원소 중 두 개를 곱하기
    2.가장 최대값 * 두번째 최대값

brainstorming
    1.정렬 후 last index, last index-1 추출
        or 전통적 loop문 max구하기도 가능하나 2번째 최대값 구할려면 또 연산이 늘어나네 정렬로
    2.

*/

/*

    정답1
import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        answer = numbers[numbers.length-1] * numbers[numbers.length-2];

        return answer;
    }
}

 */




// level0 017 : 짝수 홀수 개수
class Solution017 {
    public static void main(String[] args) {
        Solution017 prbs = new Solution017();
        int[] arr = {1, 2, 3, 4, 5};
        int[] answer = prbs.solution(arr);
        System.out.println(Arrays.toString(answer));
    }
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int even = 0;
        int odd = 0;
        for(int i = 0; i < num_list.length; i++)
            if(num_list[i] % 2 == 0)
                even++;
            else if(num_list[i] %2 != 0)
                odd++;
        answer[0] = even;
        answer[1] = odd;

        return answer;
    }
}
/*
조건
    1.결과 [짝수개수, 홀수개수]


brainstorming
    1.짝수 : n % 2 == 0
    2.홀수 : n % 2 != 0

*/

/*

    정답1
class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int even = 0;
        int odd = 0;
        for(int i = 0; i < num_list.length; i++)
            if(num_list[i] % 2 == 0)
                even++;
            else if(num_list[i] %2 != 0)
                odd++;
        answer[0] = even;
        answer[1] = odd;

        return answer;
    }
}

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




// level0 019 : 점의 위치 구하기
class Solution019 {
    public static void main(String[] args) {
        Solution019 prbs = new Solution019();
        int[] arr = {-7, 9};
        prbs.solution(arr);
        System.out.println(prbs.solution(arr));
    }
    public int solution(int[] dot) {
        int answer = 0;
        if(dot[0] > 0 && dot[1] > 0)
            answer = 1;
        else if(dot[0] < 0 && dot[1] > 0)
            answer = 2;
        else if(dot[0] < 0 && dot[1] < 0)
            answer = 3;
        else if(dot[0] > 0 && dot[1] < 0)
            answer = 4;

        return answer;
    }
}
/*
조건
    1.주어지는 정수a,b에 따라 1-4분면 판별하기
    2.dot[0]은 x좌표, dot[1]은 y좌표

brainstorming
    1.조건문으로 양수양수 양수음수 식으로 각각 나누면 됨

*/

/*

    정답1
class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        if(dot[0] > 0 && dot[1] > 0)
            answer = 1;
        else if(dot[0] < 0 && dot[1] > 0)
            answer = 2;
        else if(dot[0] < 0 && dot[1] < 0)
            answer = 3;
        else if(dot[0] > 0 && dot[1] < 0)
            answer = 4;

        return answer;
    }
}

 */




// level0 020 : 피자 나눠 먹기 (3)
class Solution020 {
    public static void main(String[] args) {
        Solution020 prbs = new Solution020();
        prbs.solution(7, 10);
        System.out.println(prbs.solution(7, 10));
    }
    public int solution(int slice, int n) {
        int answer = 0;
//        n > slice * 판수;
        while(n > slice * answer)
            answer++;
        return answer; // 2
    }
}
/*
조건
    n명의 사람이 최소 한 조각 이상 피자를 먹으려면 최소 몇 판의 피자를 시켜야 하는지
    1.피자 조각 수 : slice (2 ≤ slice ≤ 10)
      피자 먹는 사람수 : n (1 ≤ n ≤ 100)
    2.

brainstorming
    1.한판당 최소 2조각에서 최대 10조각
    2.최소 한명 당 1조각이상 : n >= 전체조각
    3.n >= slice * 판수
     사람수 >= 조각 * 판수
    4. 10 > = 7 * ?   <- 해당 공식 챗gpt한테 물어보자
        = 기준 양변에 7(slice)로 나누면
            10/7 >= 7/7 * ?
            1 >= ?
    5. 10명 7조각


*/

/*

    정답1
class Solution {
        public int solution(int slice, int n) {
        int answer = 0;
//        n > slice * 판수;
        while(n > slice * answer)
            answer++;
        return answer;
    }
}

 */




/*
못 푼 문제(다시풀어보기)
    1.피자 나눠 먹기 (3)


 */




// level0 021 : 옷가게 할인 받기
class Solution021 {
    public static void main(String[] args) {
        Solution021 prbs = new Solution021();
//        prbs.solution(580000);
        System.out.println(prbs.solution(580000));
    }
    public int solution(int price) {
//        int answer = 0;
//        if (price >= 500000) {  // 10만부터 if문 넣으면 10만이 실행되므로 50만부터 if 문 시작
//            answer = price - ((int) Math.floor(price * 0.2));
//        } else if (price >= 300000) {
//            answer = price - ((int) Math.floor(price * 0.1));
//        } else if (price >= 100000) {
//            answer = price - ((int) Math.floor(price * 0.05));
//        } else {
//            answer = price;
//        }
// price - Math.floor(price * 0.05)와 Math.floor(price * .95) 다름!!
//      price가 10이라고 가정을 했을 때, price * 0.95는 9.5, price * 0.05는 0.5입니다.
//      Math.floor는 소수점을 버리는 함수이므로 price - Math.floor(price * 0.05) 는 10 - 0 즉 10과 같고 Math.floor(price * .95)는 9와 같습니다.
        int answer = 0;
        if (price >= 500000) {  // 10만부터 if문 넣으면 10만이 실행되므로 50만부터 if 문 시작
            answer = (int)((double)price - (price * 0.2));
        } else if (price >= 300000) {
            answer = (int)((double)price - (price * 0.1));
        } else if (price >= 100000) {
            answer = (int)((double)price - (price * 0.05));
        } else {
            answer = price;
        }
        return answer;
    }
}
/*
조건
    1.금액에 따른 할인
        100,000이상 5% :  * 0.05
        300,000이상 10% : * 0.1
        500,000이상 20% : * 0.2
    2.할인된 후 최종 금액 산출
    3.소수점 이하 버림
brainstorming
    1.구간별이라 switch문, if문
    2.여기에 계산식 추가해서 output

*/

/*

    정답1
class Solution {
    public int solution(int price) {
        int answer = 0;
        if (price >= 500000) {  // 10만부터 if문 넣으면 10만이 실행되므로 50만부터 if 문 시작
            answer = (int)((double)price - (price * 0.2));
        } else if (price >= 300000) {
            answer = (int)((double)price - (price * 0.1));
        } else if (price >= 100000) {
            answer = (int)((double)price - (price * 0.05));
        } else {
            answer = price;
        }
        return answer;
    }
}

    정답2: 0.2가 아닌 0.8로


 */




// level0 022 :
class Solution022 {
    public static void main(String[] args) {
        Solution022 prbs = new Solution022();
        prbs.solution(7, 10);
        System.out.println(prbs.solution(7, 10));
    }
    public int solution(int slice, int n) {
        int answer = 0;
        return answer;
    }
}
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/

/*

    정답1


 */




// level0 023 :
class Solution023 {
    public static void main(String[] args) {
        Solution023 prbs = new Solution023();
        prbs.solution(7, 10);
        System.out.println(prbs.solution(7, 10));
    }
    public int solution(int slice, int n) {
        int answer = 0;
        return answer;
    }
}
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/

/*

    정답1


 */




// level0 024 :
class Solution024 {
    public static void main(String[] args) {
        Solution024 prbs = new Solution024();
        prbs.solution(7, 10);
        System.out.println(prbs.solution(7, 10));
    }
    public int solution(int slice, int n) {
        int answer = 0;
        return answer;
    }
}
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/

/*

    정답1


 */




// level0 025 :
class Solution025 {
    public static void main(String[] args) {
        Solution025 prbs = new Solution025();
        prbs.solution(7, 10);
        System.out.println(prbs.solution(7, 10));
    }
    public int solution(int slice, int n) {
        int answer = 0;
        return answer;
    }
}
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/

/*

    정답1


 */




// level0 026 :
class Solution026 {
    public static void main(String[] args) {
        Solution026 prbs = new Solution026();
        prbs.solution(7, 10);
        System.out.println(prbs.solution(7, 10));
    }
    public int solution(int slice, int n) {
        int answer = 0;
        return answer;
    }
}
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/

/*

    정답1


 */




// level0 027 :
class Solution027 {
    public static void main(String[] args) {
        Solution027 prbs = new Solution027();
        prbs.solution(7, 10);
        System.out.println(prbs.solution(7, 10));
    }
    public int solution(int slice, int n) {
        int answer = 0;
        return answer;
    }
}
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/

/*

    정답1


 */




// level0 028 :
class Solution028 {
    public static void main(String[] args) {
        Solution028 prbs = new Solution028();
        prbs.solution(7, 10);
        System.out.println(prbs.solution(7, 10));
    }
    public int solution(int slice, int n) {
        int answer = 0;
        return answer;
    }
}
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/

/*

    정답1


 */




// level0 029 :
class Solution029 {
    public static void main(String[] args) {
        Solution029 prbs = new Solution029();
        prbs.solution(7, 10);
        System.out.println(prbs.solution(7, 10));
    }
    public int solution(int slice, int n) {
        int answer = 0;
        return answer;
    }
}
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/

/*

    정답1


 */



// level0 030 :
class Solution030 {
    public static void main(String[] args) {
        Solution030 prbs = new Solution030();
        prbs.solution(7, 10);
        System.out.println(prbs.solution(7, 10));
    }
    public int solution(int slice, int n) {
        int answer = 0;
        return answer;
    }
}
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/

/*

    정답1


 */




/*
못 푼 문제(다시풀어보기)
    1.피자 나눠 먹기 (3)


 */









