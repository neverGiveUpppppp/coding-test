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
