package com.baekjoon.step9;


import java.io.*;
import java.util.*;

// Step9-1 	5086 배수와 약수
/*
조건
    3가지 중 하나를 도출하는 문제
        첫째 숫자가 둘째 숫자의 약수 = factor
        첫째 숫자가 둘째 숫자의 배수 = multiple
        첫째 숫자가 둘째 숫자의 약수,배수x = neither
    입력값 : 0 < T <= 10000
            마지막 줄에 0 2개
            두 수 같은 경우x

brainstorming
    1.switch(int)로 받으면 될 듯
    2.약수,배수 구하는 공식 찾아보기
        약수 : a % b == 0
        배수 : b % a == 0
    3.테스트케이스만큼 반복
    4. 마지막 줄에 0 두 개가 주어지는 이유는 특정 메소드나 방법을 사용하라는 암시이자 그럴 수 밖에 없는 조건임

 */
class Step9_1{
    public static void main(String[] args) {

/*
    문제풀이
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = null;

            // 1.테스트케이스 입력값 받기
            int testcase = Integer.parseInt(br.readLine());

            int[][] numbers = new int[testcase][2];
            for (int i = 0; i < testcase; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                while(st.hasMoreTokens()){
                    numbers[i][0] = Integer.parseInt(st.nextToken());
                    numbers[i][1] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(Arrays.toString(numbers[0]));
            System.out.println(Arrays.toString(numbers[1]));
            System.out.println(Arrays.deepToString((numbers)));

            // 2.약수배수 판별하기
            for (int i = 0; i < testcase; i++) {
                if (numbers[i][1] % numbers[i][0] == 0){
                    System.out.println("factor");
                }else if(numbers[i][0] % numbers[i][1] == 0){
                    System.out.println("multiple");
                }else{
                    System.out.println("neither");
                }
//                약수 : a % b == 0
//                배수 : b % a == 0
            }

            System.out.println( 8 % 16 );

    // 테스트케이스 입력값 받는 게 없이 0 0 받으면 종류시켜야하는 조건인 듯

//        try{
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            StringTokenizer st = null;

//            ArrayList<Integer> list = new ArrayList<>();
//            int temp = -1;
//            int i = 0;
//            // 1. 입력 값 받기(0 0이면 값 받기 종료)
//            while(list.get(i) != 0){
//                st = new StringTokenizer(br.readLine(), " ");
//                while(st.hasMoreTokens()){
//                    list.add(Integer.parseInt(st.nextToken()));
////                    list[i][1] = Integer.parseInt(st.nextToken());
//                    i++;
//                }
//            }

//            // 2차원 arrayList 해보기
//            ArrayList<String>[] list = new ArrayList[2];
//            String[] tempArray = new String[list.length];
//            for(int i = 0; i < list.length; i++){
//                for(int j = 0; j < tempArray.length; j++){
//                    list[i].add("추가할 값"); // 해당 값 추가
//                }
//            }

//            // 1.테스트케이스 입력값 받기
//            int testcase = Integer.parseInt(br.readLine());
//
//            int[][] numbers = new int[testcase][2];
//            for (int i = 0; i < testcase; i++) {
//                st = new StringTokenizer(br.readLine(), " ");
//                while(st.hasMoreTokens()){
//                    numbers[i][0] = Integer.parseInt(st.nextToken());
//                    numbers[i][1] = Integer.parseInt(st.nextToken());
//                }
//            }
//            System.out.println(Arrays.toString(numbers[0]));
//            System.out.println(Arrays.toString(numbers[1]));
//            System.out.println(Arrays.deepToString((numbers)));
//
//            // 2.약수배수 판별하기
//            for (int i = 0; i < testcase; i++) {
//                if (numbers[i][1] % numbers[i][0] == 0){
//                    System.out.println("factor");
//                }else if(numbers[i][0] % numbers[i][1] == 0){
//                    System.out.println("multiple");
//                }else{
//                    System.out.println("neither");
//                }
////                약수 : a % b == 0
////                배수 : b % a == 0
//            }
//            System.out.println( 8 % 16 );



            // 1.테스트케이스 입력값 받기
            //      배열 생성할려면 길이를 정해야함 -> 길이는 입력값을 다 받아야 알 수 있음
            //      그럼 입력값을 StringBuilder로 쌓아서 받고 배열 변환은 어때?
//            StringBuilder sb = new StringBuilder();
//            String input = "";
//            while((sb.append(st = new StringTokenizer(br.readLine()," "))+" ") != null && !sb.isEmpty()) {

            

//            while(sb.toString() != "0 0"){
//                st = new StringTokenizer(br.readLine()," ");
//                while(st.hasMoreTokens()){
//                    sb.append(st.nextToken() + "\n");
//                    sb.append(st.nextToken() + "\n");
//                }
//            }

// 정해진 입력값 라인 수 없이 0 0이 들어와야 종료해야하는 조건
// 정해진 입력값 라인수가 없어 배열 생성 불가
// 받는 입력값 형태도 구분자가(" ")가 필요해서 split()내지는 StringTokenizer가 필요한데 정해진 라인수가 없다보니 까다로워서 막힌 상태
// 일단 입력값 받는 종료 조건이 0 0이라 이 처리가 안되는 상태
//            String inputt = "";
//            String str = "";
//            while((inputt = br.readLine()) != null && !inputt.isEmpty()){
////                st = new StringTokenizer(br.readLine()," ");
////                while(st.hasMoreTokens()){
////                    inputt += st.nextToken() + "\n";
////                    inputt += st.nextToken() + "\n";
////                }
//                str += inputt + "\n";
//            }
//            System.out.println(inputt);
//            System.out.println(str);

//            String inputt = "";
//            String str = "";
//            while((inputt = br.readLine()) != null && !inputt.isEmpty()){
////                st = new StringTokenizer(br.readLine()," ");
////                while(st.hasMoreTokens()){
////                    inputt += st.nextToken() + "\n";
////                    inputt += st.nextToken() + "\n";
////                }
//                str += inputt + "\n";
//                if(str == ("0 0" + "\n")){
//                    break;
//                }
//            }
//            System.out.println(inputt);
//            System.out.println(str);
//        try{
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//            StringTokenizer st = null;
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }
*/
// 값 가로 한줄 받고 출력 가능하고 조건이 아니면 다시 가로 한 줄 받는 구조가 가능한 걸 알았다면 
// 진작 풀었을 것을... 백준 문제가 너무 불친절하다. 입력 예제에는 한번에 다 받는 것처럼 해놓고ㅡㅡ
        
        
///////////////////////////////////////////////////////////////////////////////

        // 방법1
//        Scanner sc = new Scanner(System.in);
//        while(true){
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//
//            if(a == 0 && b ==0){
//                break;
//            }
//
//            if(b % a == 0){
//                System.out.println("factor");
//            }else if ( a % b == 0){
//                System.out.println("multiple");
//            }else{
//                System.out.println("neither");
//            }
//        }

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");

                int firstNum = Integer.parseInt(st.nextToken());
                int secondNum = Integer.parseInt(st.nextToken());

                if(firstNum == 0 && secondNum == 0)
                    break;

                if(secondNum % firstNum == 0){
                    sb.append("factor\n");
                }else if(firstNum % secondNum == 0){
                    sb.append("multiple\n");
                }else {
                    sb.append("neither\n");
                }
            }
            System.out.println(sb.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }



}


/*

    정답1 : Scanner
        17276	204
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
        while(true) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            if(A == 0 && B == 0)
                break;

            if(B % A == 0)
                System.out.println("factor");
            else if(A % B == 0)
                System.out.println("multiple");
            else
                System.out.println("neither");
        }
    }
}


    정답2 :
    	14016	120
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();

            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");

                int firstNum = Integer.parseInt(st.nextToken());
                int secondNum = Integer.parseInt(st.nextToken());

                if(firstNum == 0 && secondNum == 0)
                    break;

                if(secondNum % firstNum == 0){
                    sb.append("factor\n");
                }else if(firstNum % secondNum == 0){
                    sb.append("multiple\n");
                }else {
                    sb.append("neither\n");
                }
            }
            System.out.println(sb.toString());

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


 */





// Step9-2 2501	약수 구하기
class Step9_2{
/*
조건
    1.자연수 N, K
    2.N의 약수 중 K번재로 작은 약수

braintstorm
    1.N의 약수 구하기
        전체 약수 구하는 공식
    2.주어진 수(약수들) 중 K번째 작은 수
        배열,list이라면 sort() 실행 후 인덱스로 꺼내기



*/
    public static void main(String[] args) throws IOException {
        Step9_2 main = new Step9_2();

        // 1. 입력값 받기
        int[] input = main.input();
        int k = input[0];
        int n = input[1];

        // 2.k의 약수 구하기
        ArrayList<Integer> list = main.factors(k);

        // 3.k의 약수 중 n번째 작은 수 구하기
//        int answer = stp.min(list, n);
//        list.get(n);

        // 3.유효성체크+출력하기
        main.validPrint(list, n);
    }

    // 1. 입력값 받기
    public int[] input() {
        int[] input = new int[2];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                input[0] = Integer.parseInt(st.nextToken());
                input[1] = Integer.parseInt(st.nextToken());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    // 2.k의 약수 구하기
    public ArrayList<Integer> factors(int k){
        ArrayList<Integer> list = new ArrayList<>();

        // 방법1 : loop + if(n % i)
        for(int i = 1; i <= k; i++){
            if(k % i == 0){
                list.add(i);
            }
        }

        // 방법2 : Math.sqrt()

        return list;
    }

    // 3.k의 약수 중 n번째 작은 수 구하기
    public int min(ArrayList<Integer> list, int n){
        int answer = list.get(0);
        // 앞에서 for문으로 돌려서 받기 때문에 수는 순서데로 정렬인 상태
        list.get(n);

        // 방법1 : loop
//        for(int i = 0; i < list.size(); i++){
//            int num = list.get(i);
//            if(answer > num){
//                answer = num;
//            }
//        }
        // 방법2 : Collections.min()
//        answer = Collections.min(list);
        // 방법3 : Stream.min()
//        answer = list.stream().min(Integer::compare).orElse(-1);
        return answer;
        // list.get(n-1)만 해도 값 추출 가능이므로 필요x
    }
    // 3.유효성체크+출력하기
    public void validPrint(ArrayList<Integer> list, int n) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 유효성검사
        if(list.size() < n){
            bw.write("0");
        }else{
            bw.write(list.get(n-1)+"");
        }
        bw.flush();
        bw.close();
    }

}

/*

    정답1
        14224	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();

        // 1. 입력값 받기
        int[] input = main.input();
        int k = input[0];
        int n = input[1];

        // 2.k의 약수 구하기
        ArrayList<Integer> list = main.factors(k);

        // 3.유효성체크+출력하기
        main.validPrint(list, n);
    }

    // 1. 입력값 받기
    public int[] input() {
        int[] input = new int[2];
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                input[0] = Integer.parseInt(st.nextToken());
                input[1] = Integer.parseInt(st.nextToken());
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }


     public ArrayList<Integer> factors(int k){
        ArrayList<Integer> list = new ArrayList<>();

        // 방법1 : loop + if(n % i)
        for(int i = 1; i <= k; i++){
            if(k % i == 0){
                list.add(i);
            }
        }

        // 방법2 : Math.sqrt()

        return list;
    }
    public void validPrint(ArrayList<Integer> list, int n) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 유효성검사
        if(list.size() < n){
            bw.write("0");
        }else{
            bw.write(list.get(n-1)+"");
        }
        bw.flush();
        bw.close();
    }
}

 */



// Step9-3 9506	약수들의 합
class Step9_3 {
    /*
    조건
        1.첫째 줄 입력값 N : 숫자의 개수 (1 ≤ N ≤ 1000)
        2.둘째 줄 입력값 : N개 만큼의 수
        3.입력값 N개의 수들 중 소수 개수 세기


    braintstorm
        1. 입력값 마지막 -1 : 뭔가 수를 찾다가 없을 때 -1 반환하는 메소드들 때문일지도
            여튼, -1이면 break;
        2. 약수 구하고 배열에 담은 약수를 다 더해서 n과 같다면 완전수
            약수 구하기
                방법1 : for + if(n % i == 0)
                방법2 : Math.sqrt()
        3.입력값 출력 : 한 줄 씩일 걸로 예상됨

        n이 완전수인지 아닌지 판단하는 프로그램
        완전수 : 자신을 제외한 모든 약수의 합이 같은 수
        1. n이 완전수라면, n을 n이 아닌 약수들의 합으로 출력
        2. n이 완전수인지 아닌지 판단
        3. 약수 오름차순
        4. 입력 마지막 값은 -1


    */
/*
풀이과정
    public static void main(String[] args) throws IOException {
        Step9_3 main = new Step9_3();

        ArrayList<Integer> list = main.input();
        System.out.println(list);

        boolean[] isPrime = main.isPrime(list);

//        boolean[] prime = main.prime_number(list);
        int answer = main.prime_number(list);
        System.out.println(answer);
//        System.out.println(Arrays.toString(prime));

    }

    // 1.입력값 받기
    public ArrayList<Integer> input(){
        ArrayList<Integer> list = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            list = new ArrayList<>();

            // 1)N값 받기
            int N = Integer.parseInt(br.readLine());

            // 2)N만큼 수 받기
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            while(st.hasMoreTokens()){
                list.add(Integer.parseInt(st.nextToken()));
            }
//            // 현재는 막 받지만, N값 만큼 수를 받아야함 for문? 일단
 문제에서 어떨지 모르니
//            for (int i = 0; i < N; i++) {
//                list.add(Integer.parseInt(st.nextToken()));
//            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    // 2.소수 찾기 & 카운트
    public int prime_number(ArrayList<Integer> list){
        int answer = 0;



        return answer;
    }

    //    public boolean[] prime_number(ArrayList<Integer> list){
////        boolean[] prime = new boolean[list.size()+1];	// 0 ~ N
//        boolean[] prime = new boolean[list.size()];	// 0 ~ N
//
//
//        // 2미만은 소수가 아니니 제외
//        for (int i = 0; i < list.size(); i++) {
//            if(list.get(i) < 2){
//                prime[i] = true;
//            }
//        }
//
//        // 소수 판별 : 제곱근 함수 Math.sqrt() 사용
//        for (int i = 2; i <= Math.sqrt(list.size()); i++) {
//            // 이미 체크된 배열이면 다음 반복문으로 skip
//
//            if(prime[i] == true){
//                continue;
//            }
//
//            // i 의 배수들을 걸러주기 위한 반복문
//            for(int j = i * i; j < prime.length; j = j+i) {
//                prime[j] = true;
//            }
//        }
//
//        return prime;
//    }
    public void isPrime(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            // 0 과 1 은 소수가 아니므로 종료
            if(list.get(i) < 2) {
                continue;
            }


            // 2 는 소수이기에 카운트
            if(list.get(i) == 2) {
                answer++;   // 소수 2 발견이므로 개수 카운트 +1
            }


            // 제곱근 함수 : Math.sqrt()
            for(int j = 2; j <= list.get(i); j++) {

                // 소수일 경우 카운트
                if(list.get(i) % j == 0) {
                    break;
                }

            }
        }
    }

}

*/
    public static void main(String[] args) throws IOException {
        Step9_3 main = new Step9_3();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1.입력값
        int testCase = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            testCase = Integer.parseInt(br.readLine());

            if (testCase == -1) {
                break;
            } else {
                // 2.n값의 약수 구하기
                list = main.factors(testCase);

                // 3.n값의 약수들의 합 구하기(완전수 구분)
                int num = main.sum(list);

                // 4.완전수 판별하기 + 출력
                main.categorize(testCase, num, list);
            }
        }
    }

    // 2.n값의 약수 구하기
    public ArrayList<Integer> factors(int testCase) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= testCase; i++) {
            if (testCase % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

    // 3.n값의 약수들의 합 구하기(완전수 구분)
    public int sum(ArrayList<Integer> list) {
        int num = 0;

        for (int i = 0; i < list.size() - 1; i++) { // n 자신의 수는 빠져야 하므로 -1
            num += list.get(i);
        }
        return num;
    }

    // 4.완전수 판별하기 + 출력
    StringBuilder sb = new StringBuilder();

    public void categorize(int testCase, int num, ArrayList<Integer> list) {
        if (num == testCase) {
            // 약수의 개수가 몇개일지 모르니 list를 for문 돌려야할 듯
            sb.append(num + " = ");
            for (int i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i) + " + ");
            }
            sb.delete(sb.length() - 3, sb.length() - 1);
            System.out.println(sb.toString());
            sb.setLength(0);    // sb 값 초기화
        } else {
            sb.append(testCase + " is NOT perfect.");
            System.out.println(sb.toString());
            sb.setLength(0);    // sb 값 초기화
        }
    }

}



/*

    정답1 : while(true) break + StringBuilder + sb.setLength(0)
        14120	128
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1.입력값
        int testCase = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            testCase = Integer.parseInt(br.readLine());

            if(testCase == -1){
                break;
            }else{
                // 2.n값의 약수 구하기
                list = main.factors(testCase);

                // 3.n값의 약수들의 합 구하기(완전수 구분)
                int num = main.sum(list);

                // 4.완전수 판별하기 + 출력
                main.categorize(testCase, num, list);
            }
        }
    }

    // 2.n값의 약수 구하기
    public ArrayList<Integer> factors(int testCase){

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= testCase; i++){
            if(testCase % i == 0){
                list.add(i);
            }
        }
        return list;
    }

    // 3.n값의 약수들의 합 구하기(완전수 구분)
    public int sum(ArrayList<Integer> list) {
        int num = 0;

        for(int i = 0; i < list.size()-1; i++){ // n 자신의 수는 빠져야 하므로 -1
            num += list.get(i);
        }
        return num;
    }

    // 4.완전수 판별하기 + 출력
    StringBuilder sb = new StringBuilder();
    public void categorize(int testCase, int num, ArrayList<Integer> list){
        if(num == testCase){
            sb.append(num + " = ");
            for(int i = 0; i < list.size()-1; i++){
                sb.append(list.get(i) + " + ");
            }
            sb.delete(sb.length()-3,sb.length()-1);
            System.out.println(sb.toString());
            sb.setLength(0);    // sb 값 초기화
        }else{
            sb.append(testCase + " is NOT perfect.");
            System.out.println(sb.toString());
            sb.setLength(0);    // sb 값 초기화
        }
    }
}
 */




// Step9-4 1978	소수 찾기
class Step9_4{
    /*
    조건
        1.첫째 줄 N ( 0 < N < = 100)
        2.둘째 줄 N개의 수 ( <= 1000)
        3.소수 count

    braintstorm
        1.애초에 가로 한 줄 값을 몇개 받을 지 입력 단계에서 통제 불가능이라,
            값을 받을 대로 받고 해당 값을 n값 이상 넘어가면 절삭
        2.소수가 아닌 경우의 수 ( N % i ==0)를 받은 값이 들어있는 list에서 remove
    */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Step9_4 main = new Step9_4();

        // 1.입력값 N 받기
        int n = main.input_n();

        // 2.N개만큼 가로줄 입력값 받기
        ArrayList<Integer> list = main.input_numbers(n);
//        System.out.println(list);

        // 3.ArrayList or Array로 받고 소수 뽑아내기
        ArrayList<Integer> prime = main.prime(list);
//        System.out.println(prime);

        // 4.소수 개수 카운트
        bw.write(prime.size()+"");
        bw.flush();
        bw.close();
    }

    // 1.입력값 N 받기
    private int input_n() throws IOException {
        int n = Integer.parseInt(br.readLine());
        return n;
    }

    // 2.N개만큼 가로줄 입력값 받기
    private ArrayList<Integer> input_numbers(int n) throws IOException {
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            input.add(Integer.parseInt(st.nextToken()));
        }
// 애초에 가로 한 줄 값을 몇개 받을 지 입력 단계에서 통제 불가능이라, 값을 받을 대로 받고 해당 값을 n값 이상 넘어가면 절삭
        if(n == input.size() || n < input.size()) {
            // n값과 같거나 초과할 경우 n개까지만 받기
            for (int i = n - 1; i >= 0; i--) {
                list.add(input.get(i));
            }
        }else{ // n값보다 적은 수 받을 경우
            list.addAll(input);
        }
        list.sort(Comparator.naturalOrder());
        return list;
    }

    // 3.ArrayList or Array로 받고 소수 뽑아내기
    private ArrayList<Integer> prime(ArrayList<Integer> list) {
        ArrayList<Integer> prime = new ArrayList<>(list);
        // list 반복문 k
        for (int k = 0; k < list.size(); k++) {
            // 2 미만이면 소수가 아니므로 list에서 삭제
            if(list.get(k) < 2) {
                prime.remove(list.get(k));
            }else if(list.get(k) > 2){
                for(int i = 2; i <= Math.sqrt(list.get(k)); i++) {
                    // 소수가 아닐경우 list에서 값 제거
                    if(list.get(k) % i == 0) {
                        prime.remove(list.get(k));
                    }
                }
            }
        }
        return prime;
    }
}


/*

    정답1
        14344	128
import java.util.*;
import java.io.*;
public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Main main = new Main();

        // 1.입력값 N 받기
        int n = main.input_n();

        // 2.N개만큼 가로줄 입력값 받기
        ArrayList<Integer> list = main.input_numbers(n);

        // 3.ArrayList or Array로 받고 소수 뽑아내기
        ArrayList<Integer> prime = main.prime(list);

        // 4.소수 개수 카운트
        bw.write(prime.size()+"");
        bw.flush();
        bw.close();
    }

      // 1.입력값 N 받기
    private int input_n() throws IOException {
        int n = Integer.parseInt(br.readLine());
        return n;
    }

    // 2.N개만큼 가로줄 입력값 받기
    private ArrayList<Integer> input_numbers(int n) throws IOException {
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st = null;


        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            input.add(Integer.parseInt(st.nextToken()));
        }
        // 애초에 가로 한 줄 값을 몇개 받을 지 입력 단계에서 통제 불가능이라, 값을 받을 대로 받고 해당 값을 n값 이상 넘어가면 절삭
        if(n == input.size() || n < input.size()) { 
            // n값과 같거나 초과할 경우 n개까지만 받기
            for (int i = n - 1; i >= 0; i--) {
                list.add(input.get(i));
            }
        }else{ // n값보다 적은 수 받을 경우
            list.addAll(input);
        }
        list.sort(Comparator.naturalOrder());
        return list;
    }

    // 3.ArrayList or Array로 받고 소수 뽑아내기
    private ArrayList<Integer> prime(ArrayList<Integer> list) {
        ArrayList<Integer> prime = new ArrayList<>(list);
        // list 반복문 k
        for (int k = 0; k < list.size(); k++) {
            // 2 미만이면 소수가 아니므로 list에서 삭제
            if(list.get(k) < 2) {
                prime.remove(list.get(k));
            }else if(list.get(k) > 2){
                for(int i = 2; i <= Math.sqrt(list.get(k)); i++) {
                    // 소수가 아닐경우 list에서 값 제거
                    if(list.get(k) % i == 0) {
                        prime.remove(list.get(k));
                    }
                }
            }
        }
        return prime;
    }
}

 */





// Step9-5 2581	소수
class Step9_5{
    /*
    조건
        1.M이상 N이하의 자연수 중 소수인 것 ( M <= N )
        2.위의 소수들 중 합과 최솟값
        3.세로 두 줄

    braintstorm
        1.소수 : 전체수를 arrayList 담고 소수 아닌 것 remove
        2.최솟값 : 방법1 loop문, 방법2 Collections.min()
        3.소수의 합은 +=로

    */
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Step9_5 main = new Step9_5();

        // 1.입력값 m,n 받기
        int m = main.inputM();
        int n = main.inputN();

        // 2.소수 뽑기
        ArrayList<Integer> prime = main.prime(m,n);

        // 3. 소수의 합 및 최소값
        main.min_sum(prime);

    }



    // 1.입력값 m,n 받기
    private int inputM() throws IOException{
        int m = Integer.parseInt(br.readLine());
        return m;
    }
    public int inputN() throws IOException{
        int n = Integer.parseInt(br.readLine());
        return n;
    }
    
    // 2.소수 뽑기
    private ArrayList<Integer> prime(int m, int n) {
        // 2-1) m~n사이 값 list에 넣기
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            list.add(i);
        }

        // 2-2)소수 찾기
        ArrayList<Integer> prime = new ArrayList<>(list);   // list.remove()하면서 list.size()가 줄어 인덱스가 달라지기 때문에 list객체 2개 필요
        for (int i = 0; i < list.size(); i++) {
            // 0과 1 소수x 제거
            if (list.get(i) < 2){   // 주어지는 수 자연수
//                prime.remove(list.get(i));
                prime.remove(i);
            }else if(list.get(i) > 2){
                for (int j = 2; j <= Math.sqrt(list.get(i)); j++) {
                    if (list.get(i) % j == 0) {
                        prime.remove(list.get(i));
                    }
                }
            }
        }
        return prime;
    }


    // 3. 소수의 합 및 최소값
    private void min_sum(ArrayList<Integer> prime) {
        StringBuilder sb = new StringBuilder();
        Step9_5 main = new Step9_5();
        if (prime.isEmpty()) {
            prime.add(-1);
            sb.append(prime.get(0));
            System.out.print(sb.toString());
        }else{
            // 3-1) 소수의 합
            int sum = main.sum(prime);
            // 3-2) 최솟값
            int min = main.min(prime);
            // 3-3) 값 출력
            sb.append(sum+"\n");
            sb.append(min);
            System.out.print(sb.toString());
        }
    }

    // 3-1)소수의 합
    public int sum(ArrayList<Integer> prime) {
        int sum = 0;
        for (int i = 0; i < prime.size(); i++) {
            sum += prime.get(i);
        }
        return sum;
    }

    // 3-2)최솟값
    private int min(ArrayList<Integer> list) {
        int min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (min > num) {
                min = num;
            }
        }
        return min;
    }
}


/*

    정답1
        16068	360
import java.util.*;
import java.io.*;
public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Main main = new Main();

        // 1.입력값 m,n 받기
        int m = main.inputM();
        int n = main.inputN();

        // 2.소수 뽑기
        ArrayList<Integer> prime = main.prime(m,n);

        // 3. 소수의 합 및 최소값
        main.min_sum(prime);
    }

    // 1.입력값 m,n 받기
    private int inputM() throws IOException{
        int m = Integer.parseInt(br.readLine());
        return m;
    }
    public int inputN() throws IOException{
        int n = Integer.parseInt(br.readLine());
        return n;
    }

    // 2.소수 뽑기
    private ArrayList<Integer> prime(int m, int n) {
        // 2-1) m~n사이 값 list에 넣기
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            list.add(i);
        }
        // 2-2)소수 찾기
        ArrayList<Integer> prime = new ArrayList<>(list);   // list.remove()하면서 list.size()가 줄어 인덱스가 달라지기 때문에 list객체 2개 필요
        for (int i = 0; i < list.size(); i++) {
            // 0과 1 소수x 제거
            if (list.get(i) < 2){   // 주어지는 수 자연수
//                prime.remove(list.get(i));
                prime.remove(i);
            }else if(list.get(i) > 2){
                for (int j = 2; j <= Math.sqrt(list.get(i)); j++) {
                    if (list.get(i) % j == 0) {
                        prime.remove(list.get(i));
                    }
                }
            }
        }
        return prime;
    }


    // 3. 소수의 합 및 최소값
    private void min_sum(ArrayList<Integer> prime) {
        StringBuilder sb = new StringBuilder();
        Main main = new Main();
        if (prime.isEmpty()) {
            prime.add(-1);
            sb.append(prime.get(0));
            System.out.print(sb.toString());
        }else{
            // 3-1) 소수의 합
            int sum = main.sum(prime);
            // 3-2) 최솟값
            int min = main.min(prime);
            // 3-3) 값 출력
            sb.append(sum+"\n");
            sb.append(min);
            System.out.print(sb.toString());
        }
    }



    // 3-1)소수의 합
    public int sum(ArrayList<Integer> prime) {
        int sum = 0;
        for (int i = 0; i < prime.size(); i++) {
            sum += prime.get(i);
        }
        return sum;
    }
    // 3-2)최솟값
    private int min(ArrayList<Integer> list) {
        int min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (min > num) {
                min = num;
            }
        }
        return min;
    }
}


 */





// Step9-6 11653 소인수분해
class Step9_6{
/*
조건
    1.정수 N이 주어졌을 때, 소인수분해
    2.N (1 ≤ N ≤ 10,000,000)

braintstorm
    소인수 : 인수 중에 소수인 것들
    인수 : 어떤 수나 식을 곱하기로만 표현 했을 때, 곱해지는 각각의 것들 (곱셈 기준)
        1 x 12 = 12
        3 x 4 = 12
        = 약수(a % b)와 같은 구성(나눗셈 기준)
    즉, 약수를 구하고 거기서 소수인 것 도출
    1.약수 구하고 소수 도출
    2.수의 모든 수를 다 체크해야하므로 브루트 포스

*/
    public static void main(String[] args) throws IOException{
        Step9_6 main = new Step9_6();

        // 1.자연수 n값 받기
        int n = main.input();

        // 2.약수(인수) 구하기
        ArrayList<Integer> divisor = main.divisor(n);

        // 3.약수(인수) 중 소수 구하기
        main.prime_number(divisor);

    }

    // 1.자연수 n값 받기
    public int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        return n;
    }

    // 2.약수(인수) 구하기
    private ArrayList<Integer> divisor(int n) {
        ArrayList<Integer> divisor = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i >= 2 && n % i == 0)
                divisor.add(i);
        }
        return divisor;
    }

    // 3.약수(인수) 중 소수 구하기
    private ArrayList<Integer> prime_number(ArrayList<Integer> divisor) {
        ArrayList<Integer> prime = new ArrayList<>(divisor);

        for (int i = 2; i < divisor.size(); i++) {
//            if(divisor.get(i) % i == 0) {
//                prime.remove(i);
//            }
            if(divisor.get(i) < 2) {
                prime.remove(divisor.get(i));
            }else if(divisor.get(i) > 2){
                for(int j = 2; j <= Math.sqrt(divisor.get(i)); j++) {
                    // 소수가 아닐경우 list에서 값 제거
                    if(divisor.get(i) % j == 0) {
//         소수 2,3,5,7,11,13,17,19 같은거라면, 왼쪽 소수로 나뉘었을 때 2,2,3이런식으로 찍히게 수가 나오게 해야하는데 이럴려면 소수를 하나씩 다 경의수를 해줘야하니 오버임
//                        if(divisor.get(i) % 2 == 0){
//                        }else if(divisor.get(i) % 3 == 0){
//                        }else if(divisor.get(i) % 5 == 0){
                        prime.remove(divisor.get(i));
                    }
                }
            }
        }
        System.out.println(divisor);

        System.out.println(prime);
        // 2,2,2,3,3 이런 식으로 안찍히는 상태 // 아래 정답 다른 사람 풀이 참조
        return prime;
    }
}


/*

    정답1
        14088	124
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}



    정답2
        18032	264
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i = 2; i <= num; i++){
            while(num % i == 0){
                System.out.println(i);
                num /= i;
            }
        }
    }
}
    정답3 : BufferedReader
        15488	180
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 2; i <= num; i++){
            while(num % i == 0){
                bw.write(i+"");
                bw.newLine();
                num /= i;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

 */



// 혼자서 못 푼 문제 : 11653 소인수분해



public class Step9_2023 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 2; i <= num; i++){
            while(num % i == 0){
                bw.write(i+"");
                bw.newLine();
                num /= i;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}






