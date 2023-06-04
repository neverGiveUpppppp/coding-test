package com.baekjoon.step4;


// https://www.acmicpc.net/problem/10807


import java.io.*;
import java.util.*;
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
    N : 바구니 개수
    M : 공의 개수
    출력 : 각 바구니에 들은 공(M)의 개수

    N개의 바구니가 있고, 각 바구니에는 1개의 공만 넣을 수 있음
    N개의 바구니는 1번부터 N번까지 있고, M번 공을 집어넣게 됨
    각 회차마다 공을 넣는데, i번 바구니 부터 j번 바구니에 k번 번호가 적힌 공을 넣음
        (이미 공이 들어있는 경우, 공을 빼고 새로운 공을 넣음)
    M번 반복 후 1번 바구니부터 N번 바구니까지 마지막으로 들어있는 공의 번호를 출력 (없으면 0 출력)

brainstorming
    바스켓 번호가 있으니 array나 list로 관리
    i부터 j까지 k수를 넣어야함 : ex) 1-4에 3넣기
        1 2 3 4
        3 3 3 3        list [3, 3, 3, 3]

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1) 바구니와 공 받기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int basketN = 0;
            int ballM = 0;

            while(st.hasMoreTokens()){
                basketN = Integer.parseInt(st.nextToken());
                ballM = Integer.parseInt(st.nextToken());
            }

            // 2) i,j,k 값 받기
            int basketA = 0;
            int basketB = 0;
            int ballK = 0;
//            ArrayList<Integer> listInt = new ArrayList<>(); // 배열로 미리 공간을 지정해놓지 않으면 바구니 넣을 떄 0부터 차례로 넣는 게 아니므로 IndexOutOfBoundsException 에러발생
            // 배열로 미리 공간 만들어두고어서 바구니가 있는 것 같이 구현
            int[] baskets = new int[basketN];
            for(int i = 0; i < ballM; i++){
                st = new StringTokenizer(br.readLine(), " ");
                basketA = Integer.parseInt(st.nextToken());
                basketB = Integer.parseInt(st.nextToken());
                ballK = Integer.parseInt(st.nextToken());

                // 3) i,j,k의 범위 유효성 체크 : (1 <= i,j <= N), (0 < k <= N)
                if((0 < basketA && basketA <= basketN)
                        && (0 < basketB && basketB <= basketN)
                        && (0 < ballK && ballK <= basketN)){
                    // 4) m넣기
                    for(int j = basketA-1; j < basketB; j++) {
//                        listInt.add(j, ballM);
                        baskets[j] = ballK;
                    }
                }
            }
            // 5) 바구니에 남은 마지막 번호들 출력
            for(int q = 0; q < baskets.length; q++){
                bw.write(baskets[q]+" ");
            }
            bw.flush();
            br.close();
            bw.close();
            // foreach문
//            for(int l : baskets){
//                System.out.print(l+" ");
//            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*
    정답
    	14304	124
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1) 바구니와 공 받기
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int basketN = 0;
            int ballM = 0;

            while(st.hasMoreTokens()){
                basketN = Integer.parseInt(st.nextToken());
                ballM = Integer.parseInt(st.nextToken());
            }

            // 2) i,j,k 값 받기
            int basketA = 0;
            int basketB = 0;
            int ballK = 0;
//            ArrayList<Integer> listInt = new ArrayList<>(); // 배열로 미리 공간을 지정해놓지 않으면 바구니 넣을 떄 0부터 차례로 넣는 게 아니므로 IndexOutOfBoundsException 에러발생
            // 배열로 미리 공간 만들어두고어서 바구니가 있는 것 같이 구현
            int[] baskets = new int[basketN];
            for(int i = 0; i < ballM; i++){
                st = new StringTokenizer(br.readLine(), " ");
                basketA = Integer.parseInt(st.nextToken());
                basketB = Integer.parseInt(st.nextToken());
                ballK = Integer.parseInt(st.nextToken());

                // 3) i,j,k의 범위 유효성 체크 : (1 <= i,j <= N), (0 < k <= N)
                if((0 < basketA && basketA <= basketN)
                        && (0 < basketB && basketB <= basketN)
                        && (0 < ballK && ballK <= basketN)){
                    // 4) m넣기
                    for(int j = basketA-1; j < basketB; j++) {
//                        listInt.add(j, ballM);
                        baskets[j] = ballK;
                    }
                }
            }
            // 5) 바구니에 남은 마지막 번호들 출력
            for(int q = 0; q < baskets.length; q++){
               bw.write(baskets[q]+" ");
            }
            bw.flush();
            br.close();
            bw.close();
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
    각 바구니에 부여 받은 기존의 번호를 지정된 조건의 번호와 바꾸는 로직
    첫째 줄 : N (1 ≤ N ≤ 100) // M (1 ≤ M ≤ 100)
    둘째 줄 : i,j (1 ≤ i ≤ j ≤ N)

brainstorming
    처음에는 바구니에 적혀있는 번호와 같은 번호가 적힌 공이 들어있다
        N=5 : [1 2 3 4 5]
            2 1 3 4 5   - 1과 2번 바구니 교환
            2 1 4 3 5   - 3과 4번 바구니 교환
            3 1 4 2 5   - 1과 4번 바구니 교환
            3 1 4 2 5   - 2와 2번 바구니 교환
            예제 출력처럼 나옴
    두 수를 바꾸는 로직
        a,b를 교환하려면,
          c = a    a를 c에 임시 저장하고
          a = b    b를 a에 넣고
          b = c    a값을 임시 저장해두었던 c를 b에 넣으면 a,b값 교환 완성
              a = 1     a = 1
              b = 2     b = 2
              c = 0
              c = a     c = 1
              a = b     a = 2
              b = c     b = 1

*/

/*
    풀이 과정
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1) 입력값 받기(바구니와 공 받기)
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int basketN = 0;
            int ballM = 0;
            while(st.hasMoreTokens()){
                basketN = Integer.parseInt(st.nextToken());
                ballM = Integer.parseInt(st.nextToken());
            }

            // 2) 바구니 초기 번호깔기 : [1 2 3 4 N]
            // Array or list
            ArrayList<Integer> listInt = new ArrayList<>();
            for(int i = 0; i < basketN; i++){
                listInt.add(i, i + 1);
            }

            // 3) M값 수만큼 i,j값들 받기
//            ArrayList<Integer> listInt = new ArrayList<>();
            for(int j = 0; j < ballM; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int basketA = 0;
                int basketB = 0;
                while(st.hasMoreTokens()){
                    basketA = Integer.parseInt(st.nextToken());  // 1 <- 인덱스 번호
                    basketB = Integer.parseInt(st.nextToken());  // 2
                    // 4) i,j값 바꾸기
                    //      [1 2 3 4 5]
                    //      해당 인덱스를 통해 해당 값을 꺼내와 바꾸기
                    int chgeNum1 = listInt.get(basketA-1);
                    int chgeNum2 = listInt.get(basketB-1);

                    System.out.println("변경 전 : " + listInt);
                    int temp = chgeNum1;
                    chgeNum1 = chgeNum2;
                    chgeNum2 = temp;

                    System.out.println("basketA : "+ basketA);
                    System.out.println("basketB : "+ basketB);
                    System.out.println("chgeNum1 : "+ chgeNum1);
                    System.out.println("chgeNum2 : "+ chgeNum2);
                    listInt.set( (basketA - 1), chgeNum1);
                    listInt.set( (basketB - 1), chgeNum2);
                    System.out.println("변경 후 : " + listInt);
//                    listInt.indexOf(basketA);
                }
            }
            for(int j : listInt){
                System.out.print(j + " ");
            }

            // 4) i와 j의 공번호 바꾸기
            //    초기 바구니 번호 : [1 2 3 4 5]
            //    바꾸는 로직을 값 받는 곳에서 해야할까?
            //          첫째 줄, 둘째 줄 넘어가면서 값을 받는데 따로 저장해두는게 아닌 이상 값을 못가져오고
            //          값을 저장한다해도 하나씩 나눠서 가져오는게 골치아프고 현 문제 상항에서는 요구하지 않기에 자원낭비임

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1. 입력값 받기(바구니와 공 받기)
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int basketN = 0;
            int ballM = 0;
            while(st.hasMoreTokens()){
                basketN = Integer.parseInt(st.nextToken());
                ballM = Integer.parseInt(st.nextToken());
            }

            // 2. 바구니 초기 번호깔기 : [1 2 3 4 N]
            ArrayList<Integer> listInt = new ArrayList<>();             // Array or ArrayList
            for(int i = 0; i < basketN; i++){
                listInt.add(i, i + 1);
            }

            // 3. M값 수만큼 i,j값들 받기
            for(int j = 0; j < ballM; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int basketA = 0;
                int basketB = 0;
                while(st.hasMoreTokens()){
                    basketA = Integer.parseInt(st.nextToken());  // 1 <- 인덱스 번호
                    basketB = Integer.parseInt(st.nextToken());  // 2
                    // 4. i,j값 바꾸기
                    //      1)해당 인덱스를 통해 해당 값을 꺼내오기
                    int chgeNum1 = listInt.get(basketA-1);
                    int chgeNum2 = listInt.get(basketB-1);
                    //      2)값 교환
                    int temp = chgeNum1;
                    chgeNum1 = chgeNum2;
                    chgeNum2 = temp;
                    //      3)교환한 값 다시 list로 넣기
                    listInt.set( (basketA - 1), chgeNum1);
                    listInt.set( (basketB - 1), chgeNum2);
                }
            }
            for(int j : listInt){
                bw.write(j + " ");
            }
            bw.flush();
            bw.close();
            br.close();
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

            // 1. 입력값 받기(바구니와 공 받기)
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int basketN = 0;
            int ballM = 0;
            while(st.hasMoreTokens()){
                basketN = Integer.parseInt(st.nextToken());
                ballM = Integer.parseInt(st.nextToken());
            }

            // 2. 바구니 초기 번호깔기 : [1 2 3 4 N]
            ArrayList<Integer> listInt = new ArrayList<>();             // Array or list
            for(int i = 0; i < basketN; i++){
                listInt.add(i, i + 1);
            }

            // 3. M값 수만큼 i,j값들 받기
            for(int j = 0; j < ballM; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int basketA = 0;
                int basketB = 0;
                while(st.hasMoreTokens()){
                    basketA = Integer.parseInt(st.nextToken());  // 1 <- 인덱스 번호
                    basketB = Integer.parseInt(st.nextToken());  // 2
                    // 4. i,j값 바꾸기
                    //      1)해당 인덱스를 통해 해당 값을 꺼내오기
                    int chgeNum1 = listInt.get(basketA-1);
                    int chgeNum2 = listInt.get(basketB-1);
                    //      2)값 교환
                    int temp = chgeNum1;
                    chgeNum1 = chgeNum2;
                    chgeNum2 = temp;
                    //      3)교환한 값 다시 list로 넣기
                    listInt.set( (basketA - 1), chgeNum1);
                    listInt.set( (basketB - 1), chgeNum2);
                }
            }
            for(int j : listInt){
                bw.write(j + " ");
            }
            bw.flush();
            bw.close();
            br.close();
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
    1-30 순차적 출석번호(인덱스) 중복x (1 ≤ n ≤ 30)
    출력 세로 두 줄 : 제출안한 학생 오름차순

brainstorming
    중복x : Set? List?
    1-30까지 비교할 기준으로 배열을 깔아놓고 하나씩 랜덤으로 받는 입력값과 비교?
        가능은 하지만 성능이 안좋을 듯... 풀스캔이 될테니 아직은 이진검색 같은..? 자료구조 공부는 음...
    특정값 포함 여부 :
        1)컬렉션의 contains(), indexOf(), 반복문, Iterator사용 반복문, StreamAPI
            - List,Set, Map 다 가능(Map은 containsValue,key)
        2)equals()
    binarySearch() + Arrays.sort() 사용해보기

*/
//   풀이과정
//        try{
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            // 1. 입력값 받기 : 28줄 고정
//            int[] arrInt  = new int[28];
//            for(int i = 0; i < 5; i++){
//                arrInt[i] = Integer.parseInt(br.readLine());
//            }
//
//            // 2.비교 대상 배열
//            int[] arrCompare = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28};
//
//            // 3. 두 배열 비교
//            for(int j = 0; j < 5; j++){
//                arrInt[j] = Integer.parseInt(br.readLine());
//            }
//             구구단처럼 A가 1일 때 B를 1-28까지 체크하고 2일 때 1-28까지 체크해야하니 이중포문..?
//
//        try{
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//            // 1.비교 대상 배열
//            int[] arrCompare = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
//
//            // 2. 입력값 받기 : 28줄 고정
//            int[] arrInt  = new int[28];
//            int num = 0;
//            for(int s = 0; s < 5; s++){         // 답안 제출 시, 28로 고칠 것!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//                num = Integer.parseInt(br.readLine());
////                arrInt[s] = num;
//                // 유효성 검사 : (1 ≤ n ≤ 30)
//                if( 1 <= num && num <= 30){
//                    arrInt[s] = num;
//                }
////                if( 1 <= (num = Integer.parseInt(br.readLine()))
////                        && (num = Integer.parseInt(br.readLine())) <= 30){
////                    arrInt[s] = num;
////                } // 값이 무한으로 입력되는 코드
////                arrInt[s] = Integer.parseInt(br.readLine());
//            }
//            System.out.println(Arrays.toString(arrInt));
//            System.out.println("arrInt[27] : "+arrInt[27]);
//            System.out.println("==============");
//
//            // 3. 두 배열 비교
////            ArrayList<Integer> listInt = new ArrayList<>();
////            for(int i = 0; i < 5; i++){
////                for(int j = 0; j < 5; j++){
////                    if(arrInt[i] == arrCompare[j]){
////                        listInt.add(arrInt[j]);
////                    }
////                }
////            }
////            // equals()
////            ArrayList<Integer> listInt = new ArrayList<>();
////            for(int i = 0; i < 28; i++){
////                if(!arrInt.equals(arrCompare[i])){
////                    listInt.add(i,arrInt[i]);
////                }
////            }
//
//
//
//            System.out.println("arrCom : "+Arrays.toString(arrCompare));
//            System.out.println("arrInt : "+Arrays.toString(arrInt));
//            System.out.println(listInt);
//
//            // 4. 추출된 수의 대소비교
////            if(listInt.get(0) < listInt.get(1)){
////                bw.write(listInt.get(0)+"");
////                bw.newLine();
////                bw.write(listInt.get(1)+"");
////            }else{
////                bw.write(listInt.get(1).toString());
////                bw.newLine();
////                bw.write(listInt.get(0).toString());
////            }
////            bw.flush();
////            bw.close();
////            br.close();
//        try{
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//            // 1.비교 대상 배열
//            int[] arrStandard = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
//
//            // 2. 입력값 받기 : 28줄 고정
//            int[] arrInt  = new int[5];
//            int num = 0;
//            for(int s = 0; s < 5; s++){         // 답안 제출 시, 28로 고칠 것!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//                num = Integer.parseInt(br.readLine());
////                arrInt[s] = num;
//                // 유효성 검사 : (1 ≤ n ≤ 30)
//                if( 1 <= num && num <= 30){
//                    arrInt[s] = num;
//                }
//            }
//            System.out.println(Arrays.toString(arrInt));
////            System.out.println("arrInt[27] : "+arrInt[27]);
//            System.out.println("==============");
//
//
//            // 3. 두 배열 비교
//            //      1)기준 set 선언 및 중복제거
//            Set<Integer> setStandard = new HashSet<>();
//            for(int i : arrStandard){
//                setStandard.add(i);  // set에 arrCompare의 배열 요소들 넣기
//            }
//
//            //      2)두 배열 비교 후 결과값 set선언(자동 중복제거)
//            Set<Integer> setInput = new HashSet<>();
//            for(int o : arrInt){
//                System.out.println("int o : "+o);
//                System.out.println("arrInt : "+Arrays.toString(arrInt));
//                if(!setStandard.contains(o)) {
//                    setInput.add(o);
//                }
//            }
//            System.out.println("setInput"+setInput);
//
////            setInput.forEach(System.out::println);
//
//            for(int p : setInput){
//                System.out.println("없는 수 : "+p);
//            }
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        // 출석한 학생은 1이 들어가는 구조. 즉, 1이 없으면 결석이고 1이 아닌 학생만 추출하면 됨
//        // 인덱스 == key값이라 가능한 구조
//
//        // 1.출석한 학생 출결 체크
//        int[]arr = new int[30];
//        for(int i = 0; i < 28; i++) {
//            arr[Integer.parseInt(br.readLine())-1] = 1; // 출석한 학생 index에 1을 기록
//        }
//
//        // 2.결석한 학생 뽑아내기
//        for(int i = 0; i < 30; i++) {
//            if(arr[i] == 0)
//                bw.write(String.valueOf(i + 1));
//        }
//        bw.flush();
//        bw.close();
//        br.close();

        // 정답2
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            boolean[] arr = new boolean[31];
            //온 사람은 출석 체크
            for (int i = 0; i < 28; i++) {
                int n = Integer.parseInt(br.readLine());
                arr[n] = true;
            }
            for (int i = 1; i <= 30; i++) {
                if (!arr[i]) System.out.println(i);  //불리지 않은 사람 출력
            }
        }catch(IOException e){
            e.printStackTrace();
        }


    }
/*
    정답1 Scanner
        	17672	208
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        // 방법1
        Scanner scan = new Scanner(System.in);
        // 30명, 1<=n<=28
        int[] address = new int[31];
        for(int i=1; i<29; i++)
            address[scan.nextInt()] ++;

        for(int i=1; i<address.length; i++) {
            if(address[i] == 0)
                System.out.println(i);
        }
        scan.close();
    }
}

    정답2 boolean 사용 + br
        14088	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            boolean[] arr = new boolean[31];
            //온 사람은 출석 체크
            for (int i = 0; i < 28; i++) {
                int n = Integer.parseInt(br.readLine());
                arr[n] = true;
            }
            for (int i = 1; i <= 30; i++) {
                if (!arr[i]) System.out.println(i);  //불리지 않은 사람 출력
            }
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
    열 줄 랜덤수( 0 <= num <= 1000 )
    랜덤수를 42로 나눈 나머지의 값이 10개 중 다른 값이 몇 개나 있는 지
        ex) 42로 나누고 난 후 나머지가 1,2,1,1이라면 다른 값은 2 하나이므로 답은 1

brainstorming
    배열 하나씩 비교하고 값이 다른건 따로 변수 하나 만들어서 빼서 ++하기
    나눈 값을 변수 remainder에 저장하고 이 값을 다음 값과 비교하여 다른 것은 answer에 ++하면?
    boolean처리로 다른 값 true주고 카운트?

    42로 나눈 나머지를 구하고 중복제거 set 사용!
    중복제거 및 중복제거로 Set사용이 핵심!(다른 중복제거 방법이 있다면 해보자)

    성능고려
        값 받아 arraylist에 넣기 전에 %42연산이랑 서로 다른 값 개수를 구하면 배열 생성삭제가 없어서 더 빠르긴 할 듯


*/
        
    // 풀이과정
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//            // 1.세로 열 줄 받기
//            ArrayList<Integer> listInt = new ArrayList<>();
//            for (int i = 1; i <= 10; i++) {
//                listInt.add(Integer.parseInt(br.readLine()));
//            }
//
//            // 2.42로 나누고 나머지 값 구하기
//            ArrayList<Integer> listRemainder = new ArrayList<>();
//            for (int i = 0; i < 10; i++) {
//                listRemainder.add(listInt.get(i) % 42);
//            }
//
//            // 3.서로 다른 값 개수 도출
//            int answer = 0;
//            for(int i = 1; i < 10; i++){
//                if(listRemainder.get(0) != listRemainder.get(i)) { // 0 1 2 3 4 5
//                // get(i) == get(i+1)을 한다면 마지막 수 9 == 10 비교에서 에러 발생
//                // 그럼 if를 줘서 막수 일때 스톱시키기?
//                    answer++;
//                }
//                // 이러면 첫째수랑만 비교라 2,3번째가 다르면 카운트 안됨. 각각 다 달라야하는데 어떻게 비교?
//                // 이중 포문으로 i j 하나씩 다 비교하면 되려나
//            }
//            for (int i = 0; i < 10; i++) {
//                for (int j = 1; j < 10; j++) {
//                    if (listRemainder.get(0) != listRemainder.get(j)) { // 0 1 2 3 4 5
//                        // get(i) == get(i+1)을 한다면 마지막 수 9 == 10 비교에서 에러 발생
//                        // 그럼 if를 줘서 막수 일때 스톱시키기?
//                        answer++;
//                    }
//                    // 이러면 첫째수랑만 비교라 2,3번째가 다르면 카운트 안됨. 각각 다 달라야하는데 어떻게 비교?
//                    // 이중 포문으로 i j 하나씩 다 비교하면 되려나
//                }
//            }
//
//            // 3.서로 다른 값 개수 도출
//            int answer = 0;
//            for(int i = 0; i < 10; i++) {
//                if(i < 9) {
//                    if (listRemainder.get(i) != listRemainder.get(i + 1)) {
//                        answer++;
//                    }
//                }
//            }
            // 오답

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1.세로 열 줄 받기
            ArrayList<Integer> listInt = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                listInt.add(Integer.parseInt(br.readLine()));
            }

            // 2.42로 나누고 나머지 값 구하기
            ArrayList<Integer> listRemainder = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                listRemainder.add(listInt.get(i) % 42);
            }

            // 3.서로 다른 값 개수 도출
            Set<Integer> setInt = new HashSet<>(listRemainder);
            bw.write(setInt.size()+"");
            bw.flush();
            bw.close();
            br.close();

        // for문 안에서 arraylist에 넣기 전에 %42 연산하고 시간이 얼마나 단축되는 지 해보자


        } catch(IOException e){
            e.printStackTrace();
        }
    }
/*
    정답 ArrayList + Set
        14172	124
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

            // 1.세로 열 줄 받기
            ArrayList<Integer> listInt = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                listInt.add(Integer.parseInt(br.readLine()));
            }

            // 2.42로 나누고 나머지 값 구하기
            ArrayList<Integer> listRemainder = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                listRemainder.add(listInt.get(i) % 42);
            }

            // 3.서로 다른 값 개수 도출
            Set<Integer> setInt = new HashSet<>(listRemainder);
            bw.write(setInt.size()+"");
            bw.flush();
            bw.close();
            br.close();
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
    1-N 바구니 일렬 & 세로 N열 번호 받기
    입력값 범위 1-N까지 받을 수 있음
    M은 세로 받을 줄 수

    M번부터 역순 나열
    역순 시, 역순으로 만들 범위를 지정하고 그 범위에서 역순으로 생성
    i,j를 받을 때마다 두 수의 인덱스 순서 변경하기

brainstorming
    ArrayList로 1-N 나열
    역순 : reverse() 사용
    값 바꾸기 list.set() 가능
    값 교체 알고리즘 :
        c = a   ex) ? = 5    a = 5, b = 4
        a = b       5 = 4
        b = c       4 = 5 -> a = 4, b = 5

    역순 배열 범위 계산 : ABS(a-b)
        ex) int[] arr = new int[Math.abs(a-b)]

*/

/*
    풀이과정
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = new StringBuilder();

            // 1.N,M 값 받기
            int n = 0;
            int m = 0;
            while (st.hasMoreTokens()) {
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
            }

            // 2.N 배열 값 생성
//            int[] whole = new int[n];
            ArrayList<Integer> list = new ArrayList<>();
            int loop = 1;
            while(loop <= n){
                list.add(loop);
                loop++;
            }
            // 3.M만큼 세로 값 받기
//            ArrayList<Integer> listInt = new ArrayList<>();
//            for (int i = 0; i < m; i++) {
//                st = new StringTokenizer(br.readLine(), " ");
//                int firstNum = 0;
//                int secndNum = 0;
//                while (st.hasMoreTokens()) {
//                    firstNum = Integer.parseInt(st.nextToken());
//                    secndNum = Integer.parseInt(st.nextToken());
//
//                    listInt.add(firstNum);
//                    listInt.add(secndNum);
//                }
//
//                // 3. 값 교환하기
//                int bskt1 = firstNum;
//                int bskt2 = secndNum;
//                int temp = 0;
//                temp = bskt1;
//                bskt1 = bskt2;
//                bskt2 = temp;
//
//                listInt.set()
////                listInt.set()
//
//                listInt.add(bskt1);
//                listInt.add(bskt2);
//                System.out.println("bskt1 : " + bskt1);
//                System.out.println("bskt2 : " + bskt2);
//            }
            // 3.M만큼 세로 값 받기
            ArrayList<Integer> listInt = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int firstNum = 0; // 1
                int secndNum = 0; // 2
                int temp = 0;
                while (st.hasMoreTokens()) {
                    firstNum = Integer.parseInt(st.nextToken());
                    secndNum = Integer.parseInt(st.nextToken());
                }
                temp = list.get(firstNum-1);
                list.set(firstNum-1, list.get(secndNum-1));
                list.set(secndNum-1, temp);
            }
            sb.append(list);
            System.out.print(sb.toString());



            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                StringBuilder sb = new StringBuilder();

                // 1.N,M 값 받기
                int n = 0;
                int m = 0;
                while (st.hasMoreTokens()) {
                    n = Integer.parseInt(st.nextToken());
                    m = Integer.parseInt(st.nextToken());
                }

                // 2.N 배열 값 생성
                ArrayList<Integer> list = new ArrayList<>();
                int loop = 1;
                while(loop <= n){
                    list.add(loop);
                    loop++;
                }
                // 3.M만큼 세로 값 받기
                for (int i = 0; i < m; i++) {
                    st = new StringTokenizer(br.readLine(), " ");
                    int firstNum = 0; // 1
                    int secndNum = 0; // 2
                    int temp = 0;
                    while (st.hasMoreTokens()) {
                        firstNum = Integer.parseInt(st.nextToken());
                        secndNum = Integer.parseInt(st.nextToken());
                    }
                    temp = list.get(firstNum-1);
                    list.set(firstNum-1, list.get(secndNum-1));
                    list.set(secndNum-1, temp);
                }

                // 4.list에서 엘리먼트 꺼내서 출력하기
                for(int i : list){
//                    sb.append(i+ " ");
                    System.out.print(i + " ");
                }
//                System.out.print(sb.toString());

*/
//        try{
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            StringBuilder sb = new StringBuilder();
//
//            // 1.N,M 값 받기
//            int N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//
//            // 2.N 배열 값 생성
//            int[] arr = new int[N+1];
//            for(int i = 1; i <= N; i++)
//                arr[i] = i;
//            System.out.println(Arrays.toString(arr)); // [0, 1, 2, 3, 4, 5]
//
//            // 3.M만큼 세로 값 받기
//            for (int n = 0; n < M; n++){  // 0~3
//                st = new StringTokenizer(br.readLine());
//                int i = Integer.parseInt(st.nextToken());
//                int j = Integer.parseInt(st.nextToken());
//
//                // 4.값 교환
//                while(i < j){  // 4 < 3 // 3 < 4    4 < 5
//                    int tmp = arr[i];  // arr[3]
//                    arr[i++] = arr[j]; // arr3 = arr4 // arr4 = arr5
//                    arr[j--] = tmp;     // arr4 = arr3 // arr5 = arr4
//                }
//            }
//
//            // 5.값 출력
//            for(int i = 1; i <= N; i++)
//                sb.append(arr[i]).append(" ");
//            System.out.print(sb);
//            br.close();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = new StringBuilder();

            // 1.N,M 값 받기
            int n = 0;
            int m = 0;
            while (st.hasMoreTokens()) {
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
            }

            // 2.N 배열 값 생성
            ArrayList<Integer> list = new ArrayList<>();
            int loop = 1;
            while(loop <= n){
                list.add(loop);
                loop++;
            }
            // 3.M만큼 세로 값 받기
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int firstNum = Integer.parseInt(st.nextToken()) - 1;
                int secndNum = Integer.parseInt(st.nextToken()) - 1;
                int temp = 0;
//                while (st.hasMoreTokens()) {
//                    firstNum = Integer.parseInt(st.nextToken()) - 1;
//                    secndNum = Integer.parseInt(st.nextToken()) - 1;
//                }
                while(firstNum < secndNum) {    // 이해 안된 부분
                    temp = list.get(firstNum);
                    list.set(firstNum++, list.get(secndNum));
                    list.set(secndNum--, temp);
                }
            }

            // 4.list에서 엘리먼트 꺼내서 출력하기
            for(int i : list){
                sb.append(i+ " ");
            }
            System.out.print((sb.toString()).trim());
            System.out.print((sb.toString())); // .trim()안해도 정답

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*
    정답1 : 스캐너
        17932	232
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[sc.nextInt()];
		for (int i = 0; i < arr.length; i++) { // 기본배열 생성
			arr[i] = i + 1;
		}

		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int order1 = sc.nextInt() - 1;
			int order2 = sc.nextInt() - 1;

			while (order1 < order2) {
				int temp = arr[order1];
				arr[order1++] = arr[order2];
				arr[order2--] = temp;
			}
		}
		String ret = "";
		for (int j = 0; j < arr.length; j++) {
			ret += arr[j] + " ";
		}
		System.out.print(ret.trim());
		sc.close();
	}
}

    정답2 : BufferedReader + StringBuilder
        14252	128
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = new StringBuilder();

            // 1.N,M 값 받기
            int n = 0;
            int m = 0;
            while (st.hasMoreTokens()) {
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
            }

            // 2.N 배열 값 생성
            ArrayList<Integer> list = new ArrayList<>();
            int loop = 1;
            while(loop <= n){
                list.add(loop);
                loop++;
            }
            // 3.M만큼 세로 값 받기
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int firstNum = Integer.parseInt(st.nextToken()) - 1;
                int secndNum = Integer.parseInt(st.nextToken()) - 1;
                int temp = 0;

                while(firstNum < secndNum) {
                    temp = list.get(firstNum);
                    list.set(firstNum++, list.get(secndNum));
                    list.set(secndNum--, temp);
                }
            }

            // 4.list에서 엘리먼트 꺼내서 출력하기
            for(int i : list){
                sb.append(i+ " ");
            }
            System.out.print(sb.toString());
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
    점수 중 최대값 M
    과목 수 : N ( 0 < N <= 1000)
    점수 수정 : score/M*100
        ex) 50/70*100 = 71.43점
    새로운 평균을 구하는 프로그래밍

    첫째 줄 : 과목 개수 N
    둘째 줄 : 각 과목 점수

    (실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답)

brainstorming
    최대값 구하기 :
    평균 구하기 : Math.round()
    가로 공백 값 받는 수 지정하기
        N값만큼 과목값을 받아야하는데 st는 과목값수를 정할 수 없음x
        수만큼 받을려면 결국 loop인데 루프문으로 어떻게 가로 공백 값들을 받을 수 있을까? split()?
*/

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = null;
            StringBuilder sb = new StringBuilder();

/*
            // 1.과목 수 입력값 받기
            int subject = Integer.parseInt(br.readLine());

            // 2.각 과목의 점수 입력값 받기
//            ArrayList<Integer> intSubjects = new ArrayList<>();
//            st = new StringTokenizer(br.readLine(), " ");

//            for(int i = 0; i < subject; i++){
//                st = new StringTokenizer(br.readLine(), " ");
//                intSubjects.add(Integer.parseInt(st.nextToken()));
//            }
//            int[] arrInt = new int[subject];
//            for(int i = 0; i < subject; i++){
//                String[] str = br.readLine().split(" ");
//                arrInt[i] = Integer.parseInt(str[i]);
//            } // 과목수만큼 세로줄 3개받음

*/
            // 1.과목 수 입력값 받기
            int N = Integer.parseInt(br.readLine());

            // 2.각 과목의 점수 입력값 받기
            int[] arrInt = new int[N];
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i < N; i++){
                arrInt[i] = Integer.parseInt(st.nextToken());  // 배열 수 정해놓고 이상의 값이 들어오면 무효화. 적게 들어오면 에러발생
            }

            // 3.과목 중 최대값 구하기
            int max = 0;       // arrInt = [1, 2, 3]
            for (int i = 0; i < arrInt.length; i++) {
                int number = arrInt[i];
                if (max < number) {
                    max = number;
                }
            }

            // 4.각 과목 점수 구하기
            double[] subjectsScores = new double[arrInt.length];
            double sum = 0;
            for (int i = 0; i < arrInt.length; i++) {
                int subjects = arrInt[i];
//                subjectsScores[i] = (((double)subjects/max))*100;  // int끼리 나누면 0나옴. 50/70=0  더블로 캐스팅필요!
                sum += (((double)subjects/max))*100;  // int끼리 나누면 0나옴. 50/70=0  더블로 캐스팅필요!
            }

            // 5.전체 평균 구하기
            double totalAvg = sum / arrInt.length;
            sb.append(totalAvg);


            // 5.전체 평균 구하기
//            double totalAvg = 0.0;
//            for (int i = 0; i < arrInt.length; i++) {
//                double sum = 0.0;
//                double sum2 = sum + subjectsScores[i];
//                System.out.println(sum2);
//                totalAvg = (sum2 / subjectsScores.length);
//            }
            System.out.println(sb.toString());

        }catch(IOException e){
            e.printStackTrace();
        }

    }

/*
    정답
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = null;
            StringBuilder sb = new StringBuilder();

            // 1.과목 수 입력값 받기
            int N = Integer.parseInt(br.readLine());

            // 2.각 과목의 점수 입력값 받기
            int[] arrInt = new int[N];
            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i < N; i++){
                arrInt[i] = Integer.parseInt(st.nextToken());  // 배열 수 정해놓고 이상의 값이 들어오면 무효화. 적게 들어오면 에러발생
            }

            // 3.과목 중 최대값 구하기
            int max = 0;       // arrInt = [1, 2, 3]
            for (int i = 0; i < arrInt.length; i++) {
                int number = arrInt[i];
                if (max < number) {
                    max = number;
                }
            }

            // 4.각 과목 점수 구하기
            double[] subjectsScores = new double[arrInt.length];
            double sum = 0;
            for (int i = 0; i < arrInt.length; i++) {
                int subjects = arrInt[i];
                sum += (((double)subjects/max))*100;  // int끼리 나누면 0나옴. 50/70=0  더블로 캐스팅필요!
            }

            // 5.전체 평균 구하기
            double totalAvg = sum / arrInt.length;
            sb.append(totalAvg);

            System.out.println(sb.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


/*
못 푼 문제
    Step4-7 5597	과제 안 내신 분..?
    Step4-9 10811	바구니 뒤집기     <- arr[i++], arr[j--] 로직도 이해안됨

*/




}
