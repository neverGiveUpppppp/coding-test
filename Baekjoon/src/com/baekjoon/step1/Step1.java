package com.baekjoon.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Step1{

/*

    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {


        }
    }

*/

    // Step1-3 A+B
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

    // Step1-4 1001번 A-B
    public void method02(){
        // import java.util.*;

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

    // Step1-5 10998번 A*B
    public void method03(){
        // import java.util.*;
        int a = 0;
        int b = 0;

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        System.out.println(a*b);

        // 방법2
//        import java.util.Scanner;
//        public class Main {
//            public static void main(String[] args) {
//                Scanner sc = new Scanner(System.in);
//                int a,b;
//                String[] num = sc.nextLine().split(" ");
//                a = Integer.parseInt(num[0]);
//                b = Integer.parseInt(num[1]);
//                System.out.print(a*b);
//            }
//        }
    }

    // Step1-6 1008번 A/B
    public void method04(){
//        import java.util.*;

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

    // Step1-7 10869번 사칙연산
    public void method05(){

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

    // Step1-8 10926번 ??!
    public void method06(){

        String name = null;

        Scanner sc = new Scanner(System.in);
        name = sc.next();

        System.out.print(name+"??!");


    }

    // Step1-9 18108번 1998년생인 내가 태국에서는 2541년생?!
    public void method07(){

        int year = 0;

        Scanner sc = new Scanner(System.in);
        year = sc.nextInt();

        System.out.printf("%d",year-543);


    }


    // Step1-10 3003번 : 킹, 퀸, 룩, 비숍, 나이트, 폰
    public void method08() throws IOException {
/*
        brain storming
         총합 16개
         주어진수 + 부족한수 = 16개 가 되어야할 듯
        킹~폰까지 6종이니 값을 받는 변수 6개
        값 받기 = 스캐너

        맞춰져야하는 말의 숫자
        int king = 1;
        int queen = 1;
        int rook = 2;
        int bishop = 2;
        int night = 2;
        int pawn = 8;

        해당 숫자를 각각 if조건문으로 맞추기기

        scanner보다 BufferedReader
        split()보다 StringTokenizer
        println()보더 StringBuilder+println()이 빠르다

        위와 같이 같은 성향이면 배열로 받는게 좋다

*/
        int king = 0;
        int queen = 0;
        int rook = 0;
        int bishop = 0;
        int night = 0;
        int pawn = 0;

        int king0 = 1;
        int queen0 = 1;
        int rook0 = 2;
        int bishop0 = 2;
        int night0 = 2;
        int pawn0 = 8;

        Scanner sc = new Scanner(System.in);
        king = sc.nextInt();
        queen = sc.nextInt();
        rook = sc.nextInt();
        bishop = sc.nextInt();
        night = sc.nextInt();
        pawn = sc.nextInt();



// 배열로 처리해보기

// 최종정답
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//        public class Main {
//            public static void main(String[] args) throws IOException {
//
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                StringTokenizer st = new StringTokenizer(br.readLine() , " ");
//
//                int [] arr = {1,1,2,2,2,8};
//                String answer = "";
//                int U;
//                for(int i = 0; i < 6; i++) {
//                    U = Integer.parseInt(st.nextToken());
//                    answer += arr[i] - U+" ";
//                }
//                System.out.println(answer);
//            }
//        }




    }

    // Step1-11 10430번 : 나머지
    public void method09(){

        // 방법1
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println((a+b)%c);
        System.out.println(((a%c)+(b%c))%c);
        System.out.println((a*b)%c);
        System.out.println(((a%c)*(b%c))%c);

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

    }

    // Step1-12 2588 : 곱셈
    public void method10(){

        // brain storming
        // 472
        // 385 에서 먼저 일의 자리부터 5x2를 해야하므로 472를 인덱스번호로 지정하고
        //          인덱스2번을 하면 2와 5를 찍어올 수 있으므로 a[2]*b[2] 이런식이면 가능할 듯?
        //          두 수를 곱해서 10이 넘어가는건 두번째 자리수에 +1,+2 이런식으로 해 볼 수 있을 듯함
        //          -> 인덱스 사용할려면 배열이나 list 사용해야함
        //              숫자 입력받을 때 한번에 주어진다면 split이나 StringTokenizer로 나눠서 하나씩 넣어주면 될 듯
        // split()은 해당 문자열을 나눠서 array로 반환

        // 입력 값 저장 변수
//        int a=0;
//        int b=0;
//
//        Scanner sc = new Scanner(System.in);
//        a = sc.nextInt();
//        b = sc.nextInt();
//
//        // 계산되서 출력할 변수
//        int num1 = 0;
//        int num2 = 0;
//        int num3 = 0;
//        int num4 = 0;

//        Scanner sc = new Scanner(System.in);
//        int[] arr = {};
//        String a = null;
//        String b = null;
//        int[] a2 = {};
//        int[] b2 = {};
//
//        a = sc.nextLine();
//        b = sc.nextLine();
//        System.out.println(Arrays.toString(a.split(" "))); // String클래스 split은 배열로 반환
        // 472가 입력됐을 때, 다 붙어서 나오기 때문에 구분자를 사용할 게 없다...


        // 문자열 하나씩 여러하도록 chatAt() 써보자 : chatAt() + for()
        // http://mwultong.blogspot.com/2007/05/java-1-string-one-char-at-time.html

//        int[] a2 = {Integer.parseInt(a)};
//        arr[i] = a.split(" ");


        Scanner sc = new Scanner(System.in);
        int aa = sc.nextInt();
        String bb = sc.next();

        System.out.println(aa * (bb.charAt(2)-'0'));      // 일의 자리수와 472 곱
        System.out.println(aa * (bb.charAt(1)-'0'));      // 십의 자리수와 472 곱
        System.out.println(aa * (bb.charAt(0)-'0'));      // 백의 자리수와 472 곱
        System.out.println(aa * (Integer.parseInt(bb)));

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

    }

    // Step1-13 10171번 : 고양이
    public void method11(){
        // 포인트 : 이스케이프 코드
        // 해당 문자를 문자열로 출력 해주는 코드 : \
        System.out.println("\\    /\\");
        System.out.println(" )  ( ')");
        System.out.println("(  /  )");
        System.out.println(" \\(__)|");

    }

    // Step1-14 10172번 : 개
    public void method12(){
        // 포인트 : 이스케이프 코드
        // 해당 문자를 문자열로 출력 해주는 코드 : \
        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");

    }

    // Step1-15 25083번 : 새싹
    public void method13(){

        // 포인트 : 이스케이프 코드
        // 해당 문자를 문자열로 출력 해주는 코드 : \
        System.out.println("         ,r'\"7");
        System.out.println("r`-_   ,'  ,/");
        System.out.println(" \\. \". L_r'");
        System.out.println("   `~\\/");
        System.out.println("      |");
        System.out.println("      |");


    }








}
