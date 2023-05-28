package com.baekjoon.step4;


// https://www.acmicpc.net/problem/10807


import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Step4_2023 {

    // Step4-1 	10807	개수 세기
    public void method01() {
/*
조건
    N : 주어지는 갯수 (1 ≤ N ≤ 100)

    V : 찾으려는 수
    N만큼 숫자가 n개 주어지고 거기서 V가 있는 개수를 도출
        n개가 몇개가 될지 모르니 길이만큼 반복문 필요

brainstorming
    array 사용? 마진님 식
    메소드참조, 람다, 함수형 인터페이스

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // 1) 값 받기
            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] arrInt = Stream.of(str).mapToInt(Integer::parseInt).toArray();
            int v = Integer.parseInt(br.readLine());
            int count = 0;

            // 2) v의 수를 arrInt에서 카운트하기
            for(int i = 0; i < N; i++){
                if(v == arrInt[i]){
                    count++;
                }
            }
            bw.write(String.valueOf(count));
            bw.flush();
            br.close();
            bw.close();

//                String[] str = br.readLine().split(" ");
//                int v = Integer.parseInt(br.readLine());

//            List<Integer> list = new ArrayList<>();
//                st = new StringTokenizer(br.readLine(), " ");
//                list = st.hasMoreTokens();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*
    정답 방법1 : stream사용(배열 파싱용)
import java.util.stream.Stream;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // 1) 값 받기
            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] arrInt = Stream.of(str).mapToInt(Integer::parseInt).toArray();
            int v = Integer.parseInt(br.readLine());
            int count = 0;

            // 2) v의 수를 arrInt에서 카운트하기
            for(int i = 0; i < N; i++){
                if(v == arrInt[i]){
                    count++;
                }
            }
            bw.write(String.valueOf(count));
            bw.flush();
            br.close();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


    정답2 StringTokenizer
import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // 1) 값 받기
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int[] arrInt = new int[N];
            int i = 0;
            while(st.hasMoreTokens()){
                arrInt[i] = Integer.parseInt(st.nextToken());
                i++;
            }
            int v = Integer.parseInt(br.readLine());
            int count = 0;

            // 2) v의 수를 arrInt에서 카운트하기
            for(int j = 0; j < N; j++){
                if(v == arrInt[j]){
                    count++;
                }
            }
            bw.write(String.valueOf(count));
            bw.flush();
            br.close();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */



    // Step4-2 	10871	X보다 작은 수
    public void method02() {
/*
조건
    첫째 줄 : N,X(1 ≤ N, X ≤ 10,000)
    둘째 줄 : N개만큼 수
    출력 : x보다 작은 수

brainstorming
    수를 하나 씩 비교해야하므로 배열이나 for문 필수

*/
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // 1) N,X 값 받기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            ArrayList<String> list = new ArrayList<>();
            while (st.hasMoreTokens()){
                String str = st.nextToken();
                list.add(str);
            }
            int N = Integer.parseInt(list.get(0));
            int X = Integer.parseInt(list.get(1));

            // 2) N만큼 둘째 줄 값 받기
            st = new StringTokenizer(br.readLine(), " ");

            List<Integer> listInteger = new ArrayList<>();
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                listInteger.add(num);
            }

            // 3) X값과 비교해서 추출하기(List방식)
            List<Integer> listPick = new ArrayList<>();
            for(int i = 0; i < N; i++){ // N크기만큼 반복
                if(X > listInteger.get(i)){ // x보다 작으면
                    listPick.add(listInteger.get(i)); // 수를 변수에 넣고 후에 출력
                }
            }
            // 배열로 받기
//            int[] number = new int[N];
//            for(int i = 0; i < N; i++){ // N크기만큼 반복
//                if(X > listInteger.get(i)){ // x보다 작으면
//                    number[i] = listInteger.get(i);
//                }
//            }
//            System.out.println(Arrays.toString(number));

            // 4) list에서 값 꺼내서 int로 출력하기
            // foreach문(향상된포문)
            for(int j : listPick){
                System.out.print(listPick.get(j)+" ");
            }
//            for(int j = 0; j < listPick.size(); j++){
//                System.out.print(listPick.get(j)+" ");
//            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
/*
    정답 List사용
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // 1) N,X 값 받기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            ArrayList<String> list = new ArrayList<>();
            while (st.hasMoreTokens()){
                String str = st.nextToken();
                list.add(str);
            }
            int N = Integer.parseInt(list.get(0));
            int X = Integer.parseInt(list.get(1));

            // 2) N만큼 둘째 줄 값 받기
            st = new StringTokenizer(br.readLine(), " ");

            List<Integer> listInteger = new ArrayList<>();
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                listInteger.add(num);
            }

            // 3) X값과 비교해서 추출하기(List방식)
            List<Integer> listPick = new ArrayList<>();
            for(int i = 0; i < N; i++){ // N크기만큼 반복
                if(X > listInteger.get(i)){ // x보다 작으면
                    listPick.add(listInteger.get(i)); // 수를 변수에 넣고 후에 출력
                }
            }
            // 배열로 받기
//            int[] number = new int[N];
//            for(int i = 0; i < N; i++){ // N크기만큼 반복
//                if(X > listInteger.get(i)){ // x보다 작으면
//                    number[i] = listInteger.get(i);
//                }
//            }
//            System.out.println(Arrays.toString(number));

            // 4) list에서 값 꺼내서 int로 출력하기
                        // foreach문(향상된포문)
            for(int j : listPick){
                System.out.print(listPick.get(j)+" ");
            }
//            for(int j = 0; j < listPick.size(); j++){
//                System.out.print(listPick.get(j)+" ");
//            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */



    // Step4-3 	10818	최소, 최대
    public void method03() {
/*
조건
    첫째 줄 :  정수의 개수 N (1 ≤ N ≤ 1,000,000)이
    둘째 줄 : N만큼 숫자 개수
    최대최소값 구하기

brainstorming
    최대최소값 구하는 알고리즘 사용
    array나 list로 하나씩 비교(풀스캔) or 이진검색(binary search)
    효율은 일단 패스
*/
        try{


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = null;
            // 1) N값 받기
            int N = Integer.parseInt(br.readLine());

            // 2) 둘째 줄 값 받기
            List<Integer> listInt = new ArrayList<>();
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i < N; i++){
                int number = Integer.parseInt(st.nextToken());
                listInt.add(number);
            }

            // 3) 최대최소값 도출하기
            //    방법1 : Loop 사용                  118016	520
//            int max = listInt.get(0);
//            int min = listInt.get(0);
//            for(int i = 0; i < listInt.size(); i++){
//                int number = listInt.get(i);
//                if(max < number)
//                    max = number;
//                if(min > number)
//                    min = number;
//            }
            //    방법2 : Collections.max()            117672	556
//            int max = listInt.isEmpty() ? -1 : Collections.max(listInt);
//            int min = listInt.isEmpty() ? -1 : Collections.min(listInt);
//            // mins인 경우 왜 -1 가장 작은 수로 안나올까?

            //    방법3 :  Stream().max()                208488	1132
            int max = listInt.stream().max(Integer::compare).orElse(-1);
            int min = listInt.stream().min(Integer::compare).orElse(-1);

            bw.write(min + " " + max);
            bw.flush();
            br.close();
            bw.close();

        }catch(IOException e){
            e.printStackTrace();
        }

        
    }
/*
    정답1 : 최대최소값 비교 조건 Loop 사용            118016	520
    정답2 : 최대최소값 비교 조건 Collections.max()   118016	520
    정답3 : 최대최소값 비교 조건 stream().max()      208488	1132
    	118016	520
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = null;
            // 1) N값 받기
            int N = Integer.parseInt(br.readLine());

            // 2) 둘째 줄 값 받기
            List<Integer> listInt = new ArrayList<>();
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i < N; i++){
                int number = Integer.parseInt(st.nextToken());
                listInt.add(number);
            }

            // 3) 최대최소값 도출하기
            //    방법1 : Loop 사용                  118016	520
//            int max = listInt.get(0);
//            int min = listInt.get(0);
//            for(int i = 0; i < listInt.size(); i++){
//                int number = listInt.get(i);
//                if(max < number)
//                    max = number;
//                if(min > number)
//                    min = number;
//            }
            //    방법2 : Collections.max()            117672	556
//            int max = listInt.isEmpty() ? -1 : Collections.max(listInt);
//            int min = listInt.isEmpty() ? -1 : Collections.min(listInt);
//            // mins인 경우 왜 -1 가장 작은 수로 안나올까?

            //    방법3 :  Stream().max()                208488	1132
            int max = listInt.stream().max(Integer::compare).orElse(-1);
            int min = listInt.stream().min(Integer::compare).orElse(-1);

            bw.write(min + " " + max);
            bw.flush();
            br.close();
            bw.close();
            bw.write(min + " " + max);
            bw.flush();
            br.close();
            bw.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */



    // Step4-4 2562	최댓값
    public void method04() {
/*
조건
    9개의 자연수 세로입력( 0 < N < 100)
    이 중 최대값 몇번째인지 도출

brainstorming
    1)9개 수 입력 받기
    2)9개 수를 배열이나 리스트에 넣기
    3)최대값이면 IndexOf()로 인덱스 도출
        Zero-base index일 테니 +1해주기
*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // 1) 9개 입력값 받기
            int[] numbers = new int[9];
            for(int i = 0; i < 9; i++)
                numbers[i] = Integer.parseInt(br.readLine());

            // 2) 최대값 구하기
            int max = numbers[0];
            int index = 0;
            for(int j = 0; j < 9; j++){
                int number = numbers[j];
                if(max < number){
                    max = number;       // 최대값 구하기
                    index = j;          // 최대값의 인덱스번호 구하기
                }
            }

            // 3) 최대값의 인덱스 번호 구하기
//            int index = Arrays.binarySearch(numbers, max); // 정렬이 전제인 binarySearch()는 현 문제랑 안맞음. 정렬하면 안되는 문제임
            bw.write(String.valueOf(max));
            bw.flush();
            bw.newLine();
            bw.write(String.valueOf(index + 1)); // zero-base index이므로 +1해주기
            bw.flush();
            br.close();
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
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // 1) 9개 입력값 받기
            int[] numbers = new int[9];
            for(int i = 0; i < 9; i++)
                numbers[i] = Integer.parseInt(br.readLine());

            // 2) 최대값 구하기
            int max = numbers[0];
            int index = 0;
            for(int j = 0; j < 9; j++){
                int number = numbers[j];
                if(max < number){
                    max = number;       // 최대값 구하기
                    index = j;          // 최대값의 인덱스번호 구하기
                }
            }

            // 3) 최대값의 인덱스 번호 구하기
//            int index = Arrays.binarySearch(numbers, max); // 정렬이 전제인 binarySearch()는 현 문제랑 안맞음. 정렬하면 안되는 문제임
            bw.write(String.valueOf(max));
            bw.flush();
            bw.newLine();
            bw.write(String.valueOf(index + 1)); // zero-base index이므로 +1해주기
            bw.flush();
            br.close();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */



    // Step4-5 	10810	공 넣기
    public void method05() {
/*
조건
    숫자 범위 1-9

brainstorming
    a
*/

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
        try{

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */



    // Step4-6 	10813	공 바꾸기
    public void method06() {
/*
조건
    숫자 범위 1-9

brainstorming
    a
*/

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
        try{

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */



    // Step4-7 5597	과제 안 내신 분..?
    public void method07() {
/*
조건
    숫자 범위 1-9

brainstorming
    a
*/

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
        try{

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */



    // Step4-8 3052	나머지
    public void method08() {
/*
조건
    숫자 범위 1-9

brainstorming
    a
*/

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
        try{

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */



    // Step4-9 10811	바구니 뒤집기
    public void method09() {
/*
조건
    숫자 범위 1-9

brainstorming
    a
*/

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
        try{

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */



    // Step4-10 1546	평균
    public void method10() {
/*
조건
    숫자 범위 1-9

brainstorming
    a
*/

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
        try{

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */







}
