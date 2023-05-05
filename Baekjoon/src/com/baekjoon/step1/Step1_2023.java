package com.baekjoon.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Step1_2023 {

    // Step1-2 1000번 : A+B
    public void method01(){

        // 방법1
        int a=0;
        int b=0;
        Scanner sc = new Scanner(System.in);
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.println(a+b);

        // 방법2
//        import java.util.Scanner;
//        public class Main {
//            public static void main(String[] args) {
//                Scanner sc = new Scanner(System.in);
//                int a,b;
//                String[] num = sc.nextLine().split(" ");
//                a = Integer.parseInt(num[0]);
//                b = Integer.parseInt(num[1]);
//                System.out.print(a+b);
//            }
//        }
    }


    // Step1-3 1001번 : A-B
    public void method02(){

        // 방법1
        int a = 0;
        int b = 0;

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        System.out.println(a-b);

        // 방법2
//        import java.util.Scanner;
//        public class Main {
//            public static void main(String[] args) {
//                Scanner sc = new Scanner(System.in);
//                int a,b;
//                String[] num = sc.nextLine().split(" ");
//                a = Integer.parseInt(num[0]);
//                b = Integer.parseInt(num[1]);
//                System.out.print(a-b);
//            }
//        }
    }


    // Step1-5 1008번 : A/B
    public void method03(){

        // 방법1
        double a = 0;
        double b = 0;

        Scanner sc = new Scanner(System.in);

        a = sc.nextDouble();
        b = sc.nextDouble();

        System.out.printf("%.10f",a/b);
//        System.out.printf("%.9f",a/b); 이것도 .11f도 정답. 8이하로는 오답.
        // double로 안하고 float로하면 소수점 아래 계산에서 오차가 생겨서 문제가 오답처리됨


//        float aa = 0.11111f;
//
//        System.out.printf("%.2f",aa);

        // 방법2
//        Scanner sc = new Scanner(System.in);
//        Double a,b;
//        String[] num = sc.nextLine().split(" ");
//        a = Double.parseDouble(num[0]);
//        b = Double.parseDouble(num[1]);
//        System.out.println(a/b);
////        System.out.printf("%.10f",a/b);

    }


    // Step1-6 10869번 : 사칙연산
    public void method04(){

        // 방법1
        int a = 0;
        int b = 0;

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);

        // 방법2
//        import java.util.Scanner;
//        public class Main {
//            public static void main(String[] args) {
//                Scanner sc = new Scanner(System.in);
//
//                int a,b;
//                String[] num = sc.nextLine().split(" ");
//                a = Integer.parseInt(num[0]);
//                b = Integer.parseInt(num[1]);
//
//                System.out.println(a+b);
//                System.out.println(a-b);
//                System.out.println(a*b);
//                System.out.println(a/b);
//                System.out.print(a%b);
//
//            }
//        }

    }


    // Step1-7 10926번 : ??!
    public void method05(){
        String name = null;
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        System.out.print(name+"??!");
    }


    // Step1-8 18108번 : 1998년생인 내가 태국에서는 2541년생?!
    public void method06(){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        System.out.println(year-543);
    }


    // Step1-9 1001번 : 나머지
    public void method07(){
        Scanner sc = new Scanner(System.in);
        int A,B,C;
        String[] strArr = sc.nextLine().split(" ");
        A = Integer.parseInt(strArr[0]);
        B = Integer.parseInt(strArr[1]);
        C = Integer.parseInt(strArr[2]);

        System.out.println( (A+B)%C );
        System.out.println( ((A%C) + (B%C))%C );
        System.out.println( (A*B)%C );
        System.out.print( ((A%C) * (B%C))%C );
    }
/*
 정답
    import java.util.*;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            System.out.println((a+b)%c);
            System.out.println(((a%c)+(b%c))%c);
            System.out.println((a*b)%c);
            System.out.println(((a%c)*(b%c))%c);

        // 방법2
//        Scanner sc = new Scanner(System.in);
//        int A,B,C;
//        String[] strArr = sc.nextLine().split(" ");
//        A = Integer.parseInt(strArr[0]);
//        B = Integer.parseInt(strArr[1]);
//        C = Integer.parseInt(strArr[2]);
//
//        System.out.println( (A+B)%C );
//        System.out.println( ((A%C) + (B%C))%C );
//        System.out.println( (A*B)%C );
//        System.out.print( ((A%C) * (B%C))%C );

        }
    }
*/


    // Step1-10 2588번 : 곱셈
    public void method08(){
/*
    brainstorming
    a[0] a[1] a[2]
    b[0] b[1] b[2]

    a[0-2] * b[2]
    a(472) * b[2] = (3)

 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            long first = Long.parseLong(br.readLine());
//            Long first = Long.getLong(br.readLine()); // Wrapper class Long. primitive type인 long과는 다름. 기본형과 참조형의 연산은 불가
            String second = br.readLine();

            // (2)의 각 자리수 구하기
            long second_100 = Integer.parseInt(second.substring(0,1)) * 100;
            long second_10 = Integer.parseInt(second.substring(1,2)) * 10;
            long second_1 = Integer.parseInt(second.substring(2,3));    // substring()도 for문 막자리수 -1처럼 끝자리수 -1카운트

            // (1)과 (2)의 각 자리수 곱하기
            long result1 = first * second_1;                 // 472 * 5
            long result2 = (first * second_10) / 10;         // 472 * 80 / 10
            long result3 = (first * second_100) / 100;       // 472 * 300 / 100
            long result4 = first * Integer.parseInt(second); // 472 * 385

            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result3);
            System.out.println(result4);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*
    정답
방법1 : 세 숫자를 chatAt()으로 하나씩 받아서 곱할 수 있게하는 방법
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int aa = sc.nextInt();
        String bb = sc.next(); //

        // -'0'을 해주는건 아스키코드 자동변환을 방지하기 위함
        System.out.println(aa * (bb.charAt(2)-'0'));        // 일의 자리수와 472 곱
        System.out.println(aa * (bb.charAt(1)-'0'));        // 십의 자리수와 472 곱
        System.out.println(aa * (bb.charAt(0)-'0'));        // 백의 자리수와 472 곱
        System.out.println(aa * (Integer.parseInt(bb)));    // 전체 계산
    }
}

방법2 : BufferedReader, substring 사용 및

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            long first = Long.parseLong(br.readLine());
//            Long first = Long.getLong(br.readLine()); // Wrapper class Long. primitive type인 long과는 다름. 기본형과 참조형의 연산은 불가
            String second = br.readLine();

            // (2)의 각 자리수 구하기
            long second_100 = Integer.parseInt(second.substring(0,1)) * 100;
            long second_10 = Integer.parseInt(second.substring(1,2)) * 10;
            long second_1 = Integer.parseInt(second.substring(2,3));    // substring()도 for문 막자리수 -1처럼 끝자리수 -1카운트

            // (1)과 (2)의 각 자리수 곱하기
            long result1 = first * second_1;                 // 472 * 5
            long result2 = (first * second_10) / 10;         // 472 * 80 / 10
            long result3 = (first * second_100) / 100;       // 472 * 300 / 100
            long result4 = first * Integer.parseInt(second); // 472 * 385

            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result3);
            System.out.println(result4);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
 */




    // Step1-11 11382번 : 꼬마 정민
    public void method09(){
//        Scanner sc = new Scanner(System.in);
//        int a,b,c;
//        String[] number = sc.nextLine().split(" ");
//        a = Integer.parseInt(number[0]); // 77
//        b = Integer.parseInt(number[1]); // 77
//        c = Integer.parseInt(number[2]); // 7777
//        System.out.print(a+b+c);
        // IDE에서는 잘 돌아가나 백준에서는 런타임에러(NumberFormat)발생 : int형 범위 때문. 10의 12제곱 조건 때문. long타입으로 변경 필요

        Scanner sc = new Scanner(System.in);
        long a,b,c;
        String[] number = sc.nextLine().split(" ");
        a = Long.parseLong(number[0]); // 77
        b = Long.parseLong(number[1]); // 77
        c = Long.parseLong(number[2]); // 7777
        System.out.print(a+b+c);
    }
/*
    정답

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a,b,c;
        String[] number = sc.nextLine().split(" ");
        a = Long.parseLong(number[0]); // 77
        b = Long.parseLong(number[1]); // 77
        c = Long.parseLong(number[2]); // 7777
        System.out.print(a+b+c);
    }
}

*/

    // Step1-12 10171번 : 고양이
    public void method10(){
        System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");
    }
/*
    정답
public class Main {
    public static void main(String[] args) {
        System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");
    }
}

 */

    // Step1-13 10172번 : 개
    public void method11(){
        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");
    }
/*
    정답
public class Main {
    public static void main(String[] args) {
        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("||_/=\\\\__|");
    }
}

 */


}
