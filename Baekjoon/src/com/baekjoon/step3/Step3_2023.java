package com.baekjoon.step3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
    long int = 4byte
    long이 앞에 하나 씩 붙을 때마다 4바이트 추가
    새로 붙는 long이 앞에 붙어야함

brainstorming
    반복문 사용 필요
    4인 long int를 찍고 그 앞으로 나오는 방법...? 없는 듯. 그럼 숫자에 따라 한번에 계산해야함
    입력 받은 값(4배수)를 4로 나눠서 몫의 수에 따라 long을 찍고 뒤에 int를 +해보는 건?

    long 개수에 따라 찍기
        1000까지 case문 불가능
        long개수에 따라 *로 long을 찍어봐야할 것 같은데 String long * 5? 형이 달라서 무리
        long개수에 따라 for문 찍기
*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int input = Integer.parseInt(br.readLine());
            int long_ea = 0;
            String word = "long ";
            String words = "";
            if(input%4 == 0){   // 4배수 유효성체크
                long_ea = input / 4;

                for(int i = 1; i <= long_ea; i++){
                    words += word;    // "long "을 4로 나눈 몫의 개수만큼 words에 이어붙이기
                }
                bw.write(words+"int");
                bw.close();
//                System.out.println(words+"int");
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
import java.util.StringTokenizer;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int input = Integer.parseInt(br.readLine());
            int long_ea = 0;
            String word = "long ";
            String words = "";
            if(input%4 == 0){   // 4배수 유효성체크
                long_ea = input / 4;

                for(int i = 1; i <= long_ea; i++){
                    words += word;    // "long "을 4로 나눈 몫의 개수만큼 words에 이어붙이기
                }
                bw.write(words+"int");
                bw.close();
//                System.out.println(words+"int");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step3-6 15552 : 빠른 A+B
    public void method06() {
/*
조건
    입력값 : 첫째 수, 둘째줄부터 가로 2개
    첫수에 따라 가로 줄 수가 정해지고 연산이 결정됨

brainstorming


*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
//            int testCaseNum = Integer.parseInt(br.readLine());
//
//            for(int i = 0; i < testCaseNum; i++){
//                String[] arrStr = br.readLine().split(" ");
//                int num1 = Integer.parseInt(arrStr[0]);
//                int num2 = Integer.parseInt(arrStr[1]);
//                System.out.println(num1+num2);
//            } // 시간초과 & 하나받고 찍고 하나 받고 찍고라 아닌 듯

            int testCaseNum = Integer.parseInt(br.readLine());
            int num1 = 0;
            int num2 = 0;
            for(int i = 0; i < testCaseNum; i++){
                String[] arrStr = br.readLine().split(" ");
                num1 = Integer.parseInt(arrStr[0]);
                num2 = Integer.parseInt(arrStr[1]);
                int sum = num1+num2;
                bw.write(String.valueOf(sum));
                bw.newLine();
            }
//            bw.flush();
            bw.close();
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
import java.util.StringTokenizer;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int testCaseNum = Integer.parseInt(br.readLine());
            int num1 = 0;
            int num2 = 0;
            for(int i = 0; i < testCaseNum; i++){
                String[] arrStr = br.readLine().split(" ");
                num1 = Integer.parseInt(arrStr[0]);
                num2 = Integer.parseInt(arrStr[1]);
                int sum = num1+num2;
                bw.write(String.valueOf(sum));
                bw.newLine();
            }
            bw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            List<String> answers = new ArrayList<>();
            int count = Integer.parseInt(br.readLine());
            String prefix = "Case #";
            for(int i=1; i<= count; i++){
                String[] temp = br.readLine().split(" ");
                int A = Integer.parseInt(temp[0]);
                int B = Integer.parseInt(temp[1]);

                String answer = prefix + i + ": " + (A+B);
                answers.add(answer);
            }
            answers.forEach(System.out::println);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*
    정답
import java.io.*;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            int testCaseTimes = Integer.parseInt(br.readLine());
            String word = "Case #";
            for(int i = 1; i <= testCaseTimes; i++) {
                String[] arrStr = br.readLine().split(" ");
                int num1 = Integer.parseInt(arrStr[0]);
                int num2 = Integer.parseInt(arrStr[1]);

                int sum = num1 + num2;
                bw.write(word+i+": "+String.valueOf(sum));
                bw.newLine();
            }
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

    정답2 : List + ArrayList + 메소드 참조
import java.util.List;
import java.util.ArrayList;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            List<String> answers = new ArrayList<>();
            int count = Integer.parseInt(br.readLine());
            String prefix = "Case #";
            for(int i=1; i<= count; i++){
                String[] temp = br.readLine().split(" ");
                int A = Integer.parseInt(temp[0]);
                int B = Integer.parseInt(temp[1]);

                String answer = prefix + i + ": " + (A+B);
                answers.add(answer);
            }
            answers.forEach(System.out::println);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step3-8 11022 : A+B - 8
    public void method08() {
/*
조건
    위와 동

brainstorming
     List ArrayList forEach 메소드참조 사용해보기
     BufferedWriter말고 문자열 이어붙이는 StringBuilder 사용해보기!

*/

        // 풀이과정
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//
//        List<String> list = new ArrayList<>();
//        try{
//
//            int testCaseTimes = Integer.parseInt(br.readLine());
//            String word = "Case #";
//            for(int i = 1; i <= testCaseTimes; i++){
//                String[] arrStr = br.readLine().split(" ");
//                int a = Integer.parseInt(arrStr[0]);
//                int b = Integer.parseInt(arrStr[1]);
//
//                String formula = i + ": " + a + " + " + b + " = ";
//                int compute = a + b;
//                String all = word + formula + compute;
////                sb.append(word + formula + compute+"\n");
////                sb.append(word + i + ": ");
////                sb.append(i + " + " + i + " = ");
////                sb.append(compute+"\n");
////                sb.append(word + formula + compute+"\n");
////                String str = sb.toString();
////                bw.write(word + formula + compute+"\n");
//                list.add(all);
////                list.add(sb.toString());
//            }
////            System.out.println(sb.toString());
////            bw.flush();
////            bw.close();
////            list.forEach(System.out::println);
//            for(String str : list){    // 위의 list.forEach()와 같은 구문
//                System.out.println(str);
//            }
////            sb.append(list);
////            System.out.println(sb.toString()); // [Case #1: 1 + 2 = 3, Case #2: 3 + 4 = 7, Case #3: 4 + 5 = 9] 리스트 형태 그대로 출력됨
//        }catch(IOException e){
//            e.printStackTrace();
//        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        try{
            int testCaseTimes = Integer.parseInt(br.readLine());
            String word = "Case #";
            for(int i = 1; i <= testCaseTimes; i++){
                String[] arrStr = br.readLine().split(" ");
                int a = Integer.parseInt(arrStr[0]);
                int b = Integer.parseInt(arrStr[1]);

                String formula = i + ": " + a + " + " + b + " = ";
                int compute = a + b;
                String all = word + formula + compute;

                list.add(all);
            }
//            list.forEach(System.out::println);
            for(String str : list){    // 위의 list.forEach()와 같은 구문
                System.out.println(str);
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
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        try{
            int testCaseTimes = Integer.parseInt(br.readLine());
            String word = "Case #";
            for(int i = 1; i <= testCaseTimes; i++){
                String[] arrStr = br.readLine().split(" ");
                int a = Integer.parseInt(arrStr[0]);
                int b = Integer.parseInt(arrStr[1]);

                String formula = i + ": " + a + " + " + b + " = ";
                int compute = a + b;
                String all = word + formula + compute;

                list.add(all);
            }
            list.forEach(System.out::println);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step3-9 	2438 : 별 찍기 - 1
    public void method09() {
/*
조건
    N의 수에따라 *이 1부터 하나씩 우측에 추가

brainstorming
    for문 i해서 star += i처럼?
    문자열 덧붙이는거니 StringBuilder 응용해볼 수도?

*/
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try{
//            int num = Integer.parseInt(br.readLine());
//            String star = "";
//            for(int i = 1; i <= num; i++){
////                System.out.println(star);
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try{
            int num = Integer.parseInt(br.readLine());
            String star = "*";
            for(int i = 1; i <= num; i++){
//                star += "*";
                sb.append(star);
                System.out.println(sb.toString());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
/*
StringBuilder 사용 시, 별표가 아래처럼 찍히는 이유
star += "*";
sb.append(star);
System.out.println(sb.toString());
StringBuilder에서는 문자열이 변경되면 재생성하는 게 아닌 기존거에 덧붙이기 때문에
for문 첫바퀴 때 별 하나가 저장되면서 프린트되고 두번째 돌때 첫번째 때 별 하나가 남아있기 때문에 * + **이 되면서 3개가 찍히는 것

 *
 ***
 ******
 **********
 ***************

 */


    }
/*
    정답1 : println
    14228kb	128ms
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int num = Integer.parseInt(br.readLine());
            String star = "";
            for(int i = 1; i <= num; i++){
               star += "*";
               System.out.println(star);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


    정답2 : StringBuilder 사용
    14192kb	124ms
import java.io.*;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try{
            int num = Integer.parseInt(br.readLine());
            String star = "*";
            for(int i = 1; i <= num; i++){
//                star += "*";
                sb.append(star);
                System.out.println(sb.toString());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

    정답3 : 이중for문
    14904kb 228ms
import java.io.*;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(br.readLine());
            for (int i = 1; i <= num; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println("");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step3-10 2439 : 별 찍기 - 2
    public void method10() {
/*
조건
    총 5칸 중 for문에 따라 여백이 별표로 치환

brainstorming
    여백을 *로 치환 replace()
    5칸 설정 : printf(),
    trim(),

*/

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try{
//            int num = Integer.parseInt(br.readLine());
//            String str = "";
//
//            for(int i = 1; i <= num; i++){
//                str += "*";
//                System.out.printf("%5s%n",str); // 오답 : 출력 형식이 잘못되었습니다
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try{
//            int num = Integer.parseInt(br.readLine());
//            String str = "";
//            for(int i = 1; i <= num; i++){
//                String a = str.replace(" ","*");
//                System.out.println(a);
//            }
////                System.out.printf("%5s%n",str); // 오답 : 출력 형식이 잘못되었습니다
////                str += "*";
//        }catch(IOException e){
//            e.printStackTrace();
//        }

        // 방법1
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            int num = Integer.parseInt(br.readLine());
//
//            for (int i = 1; i <= num; i++) {
//                for (int j = num; j > 0; j--) {
//                    if(i < j) {
//                        System.out.print(" ");
//                    }else{
//                        System.out.print("*");
//                    }
//                }
//                System.out.println("");
//            }
//        }catch(IOException e){
//            e.printStackTrace();
//        }


        // 방법2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int num = Integer.parseInt(br.readLine());

            for (int i = 1; i <= num; i++) {
                for (int j = num; j > 0; j--) {
                    if(i < j) {
                        bw.write(" ");
//                        System.out.print(" ");
                    }else{
                        bw.write("*");
//                        System.out.print("*");
                    }
                }
                bw.newLine();
//                System.out.println("");
            }
            bw.flush();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*
    정답1 :  이중for문
    15272kb	268ms
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(br.readLine());

            for (int i = 1; i <= num; i++) {
                for (int j = num; j > 0; j--) {
                    if(i < j) {
                        System.out.print(" ");
                    }else{
                        System.out.print("*");
                    }
                }
                System.out.println("");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


    방법2 : BufferedWriter 사용
    14296kb	136ms
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int num = Integer.parseInt(br.readLine());

            for (int i = 1; i <= num; i++) {
                for (int j = num; j > 0; j--) {
                    if(i < j) {
                        bw.write(" ");
                    }else{
                        bw.write("*");
                    }
                }
                bw.newLine();
            }
            bw.flush();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step3-11 10952 : A+B - 5
    public void method11() {
/*
조건
    두 정수 A와 B를 입력값 & 한 줄 값 2개
    입력값 범위(0 < A, B < 10) : a,b 둘다 1~9사이 값만 들어옴
    A+B를 출력 & 범위값 이외에 0같은게 들어오면 프로그램 종료
    입력의 마지막에는 0 두 개

brainstorming
    입력6줄 출력5줄 고정인 듯?
    마지막 0 2개는 입력만 받고 출력안하면 될 듯
        마지막 0을 넣으면 0은 예외처리해서 출력안하게끔 처리해야하는 듯. nullpointer 뜨는게 왠지 수상
        그럼 6줄 다 받고 if문으로 유효성체크해서 0이면 값 안나가게 처리?
    한 줄 값 2개 받기 코드 한 세트 말고 그 상위 카테고리로 6번 돌려서 입력값 6번 받기

*/
//        try {
//            StringBuilder sb = new StringBuilder();
//            for(int j = 0; j < 5; j++){
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//                // 한 줄 값 2개 받기
//                int[] input = new int[st.countTokens()];
//                for(int i = 0; i < input.length; i++){
//                    input[i] = Integer.parseInt(st.nextToken());
//                }
//                int a = input[0];
//                int b = input[1];
//                sb.append(a + " "+ b + "\n"); // 스트링빌더, 마지막 줄바꿈이 2개 추가로 떠서 오답될 듯
//            }
//            System.out.println(sb.toString());
//        }catch(IOException e){
//            e.printStackTrace();
//        }
// 스트링빌더, 마지막 줄바꿈이 2개 추가로 떠서 오답될 듯

//        try {
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            Scanner sc = new Scanner(System.in);
//            for(int j = 0; j < 5; j++){
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//                // 한 줄 값 2개 받기
//                int[] input = new int[st.countTokens()];
//                for(int i = 0; i < input.length; i++){
//                    input[i] = Integer.parseInt(st.nextToken());
//                }
//                int a = input[0];
//                int b = input[1];
////                bw.write(Integer.toString(a + b));  // toString() 대신 => valueOf() 사용
//                bw.write(String.valueOf(a + b));  // toString() 대신 => valueOf() 사용
//                bw.newLine();
//            }
//            int lastNum = sc.nextInt();
//            bw.flush();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
// 널포인터 발생
// 마지막 0을 넣으면 0은 예외처리해서 출력안하게끔 처리해야하는 듯. nullpointer 뜨는게 왠지 수상

//        try {
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            // 입력값 6줄 받기
//            for(int j = 0; j < 6; j++){
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//                // 한 줄 값 2개 받기
//                int[] input = new int[st.countTokens()];
//                for(int i = 0; i < input.length; i++){
//                    input[i] = Integer.parseInt(st.nextToken());
//                }
//                int a = input[0];
//                int b = input[1];
//                // 0이면 출력 안하게끔 if 유효성 추가
//                if(a != 0 && b != 0) {  // a 또는 b로 줘서 에러나면 a and b로도 한번 더 해보자
//                    //                bw.write(Integer.toString(a + b));  // toString() 대신 => valueOf() 사용
//                    bw.write(String.valueOf(a + b));  // toString() 대신 => valueOf() 사용
//                    bw.newLine();
//                }
//            }
//            bw.flush();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
// 여전히 널포인터 발생

//        try {
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            // 입력값 6줄 받기
//            for(int j = 0; j < 6; j++){
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//                // 한 줄 값 2개 받기
//                int[] input = new int[st.countTokens()];
//                for(int i = 0; i < input.length; i++){
//                    input[i] = Integer.parseInt(st.nextToken());
//                }
//                int a = input[0];
//                int b = input[1];
//                // 0이면 출력 안하게끔 if 유효성 추가
//                if( 0 < a && b < 10) {  // a 또는 b로 줘서 에러나면 a and b로도 한번 더 해보자
//                    //                bw.write(Integer.toString(a + b));  // toString() 대신 => valueOf() 사용
//                    bw.write(String.valueOf(a + b));  // toString() 대신 => valueOf() 사용
//                    bw.newLine();
//                }
//            }
//            bw.flush();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
// 여전히 널포인터 발생 : 한 줄 값 2개받기 코드를 while hasmore로 바꿔보자. 얘도 널포인터...

//        try {
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            // 입력값 6줄 받기
//            while(true){
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//                // 한 줄 값 2개 받기
//                int a = 0;
//                int b = 0;
//                while(st.hasMoreTokens()){
//                    a = Integer.parseInt(st.nextToken());
//                    b = Integer.parseInt(st.nextToken());
//                }
//
//                // 0이면 출력 안하게끔 if 유효성 추가
//                if( (0 < a && a < 10) && (0 < b && b < 10) ) {  // a 또는 b로 줘서 에러나면 a and b로도 한번 더 해보자
//                    //                bw.write(Integer.toString(a + b));  // toString() 대신 => valueOf() 사용
////                    bw.write(String.valueOf(a + b)+"\n");  // toString() 대신 => valueOf() 사용
////                    bw.write(a + b);
//                    bw.write((a + b) + "\n");
////                    bw.newLine();
//                }else{
//                    break;
//                }
//            }
//            bw.flush();
//        }catch(IOException e){
//            e.printStackTrace();
//        }

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;

            while (true) {
                st = new StringTokenizer(br.readLine(), " ");

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                if (x == 0 && y == 0) {
                    break;
                }
                bw.write((x + y) + "\n");
            }
            br.close();
            bw.flush();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
// 입력값 범위(0 < A, B < 10) : A 1이상, B 9이하

    }
/*
    정답1 : StringTokenizer 위치
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0) {
				break;
			} else {
				bw.write(a + b +"\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}


    정답2 : StringTokenizer 위치
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (x == 0 && y == 0) {
				break;
			}
			bw.write((x + y) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}


 */


    // Step3-12 10951 : A+B - 4
    public void method12() {
/*
조건
    두 정수 A와 B를 입력값 & 한 줄 값 2개
    입력값 범위(0 < A, B < 10) : a,b 둘다 1~9사이 값만 들어옴

brainstorming
    br.readLine()이 EOF를 만나면 null을 반환하기에 StringTokenizer 선언 시 NullPointer 에러가 생김
    이를 방지하기 위한 코드
    String str;
    while((str = br.readLine()) != null) {

*/
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = null;
            String input = "";
            while((input = br.readLine()) != null) {
                st = new StringTokenizer(input," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if( (0 < a && a < 10) && (0 < b && b < 10) ) {
//                bw.write(String.valueOf(a + b + "\n"));
                    bw.write(a + b + "\n");
                }
            }
            br.close();
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
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.*;
public class Main {
    public static void main(String[] args) {

    }
}

 */



/*
다시 풀 문제

    2439	별 찍기 - 2
    10952	A+B - 5

 */



}
