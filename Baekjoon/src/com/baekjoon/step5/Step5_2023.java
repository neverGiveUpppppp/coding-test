package com.baekjoon.step5;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Step5_2023 {



    // Step5-1 27866	문자와 문자열
    public void method01() {
/*
조건
    1. S의 i번째 글자 출력

brainstorming
    1.인덱스 번호로 해당 값 구하기 : String.charAt()


*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String s = br.readLine();
            int i = Integer.parseInt(br.readLine());

            bw.write(s.charAt(i-1));
            bw.flush();
            bw.close();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }


    }
/*

    정답1 : .chatAt() 사용
        14236	124
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
            String s = br.readLine();
            int i = Integer.parseInt(br.readLine());

            bw.write(s.charAt(i-1));
            bw.flush();
            bw.close();
            br.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step5-2 2743	단어 길이 재기
    public void method02() {
/*
조건
    1. 단어 길이 출력
    2. 첫째 줄에 영어 소문자와 대문자

brainstorming
    1.길이 : length는 str?  size()는 list

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String input = br.readLine();
            bw.write(input.length()+"");
            bw.flush();
            bw.close();
            br.close();

        }catch(IOException e){
            e.printStackTrace();
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
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String input = br.readLine();
            bw.write(input.length()+"");
            bw.flush();
            bw.close();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step5-3 9086	문자열
    public void method03() {
/*
조건
    1.첫 글자와 마지막 글자를 출력

    첫째 줄 : 테스트 케이스 수(1 ≤ T ≤ 10)
        주어지는 문자열 구성 : 알파벳 A~Z 대문자,공백x, 길이 1000이하
    둘째 줄 : 테스트 수 만큼 문자열 받기

brainstorming
    1.마지막 글자 : indexOf(), lastIndexOf() -> 어떤 글자의 인덱스 번호 찾는 것
    2.글자 찾기 :
        첫글자 : chatAt(0)
        막글자 : chatAt()
                for문의 마지막?
                문자열의 length!

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1.테스트케이스 수 입력값 받기
            int t = Integer.parseInt(br.readLine());

            // 2.문자열 값 받기
            String str = null;
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < t; i++){
                str = br.readLine();
                list.add(str);
            }

            // 3.첫글자, 마지막글자 꺼내기
            for(int i = 0; i < list.size(); i++){   // 테스트케이스 수(t & list.size)만큼 for문 반복
                String firstLetter = String.valueOf(list.get(i).charAt(0)); // list에서 value를 하나씩 꺼내서 거기서 첫번째 글자 꺼내기
                String lastLetter = String.valueOf(list.get(i).charAt((list.get(i)).length()-1)); // 마지막 글자는 해당 문자열의 길이로 도출
                bw.write(firstLetter+lastLetter);
                bw.newLine();
//                System.out.println(String.valueOf(list.get(i).charAt(0)) + list.get(i).charAt((list.get(i)).length()-1));
            }
            bw.flush();
            bw.close();
            br.close();

        }catch(IOException e){
            e.printStackTrace();
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
            import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1.테스트케이스 수 입력값 받기
            int t = Integer.parseInt(br.readLine());

            // 2.문자열 값 받기
            String str = null;
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < t; i++){
                str = br.readLine();
                list.add(str);
            }

            // 3.첫글자, 마지막글자 꺼내기
            for(int i = 0; i < list.size(); i++){   // 테스트케이스 수(t & list.size)만큼 for문 반복
                String firstLetter = String.valueOf(list.get(i).charAt(0)); // list에서 value를 하나씩 꺼내서 거기서 첫번째 글자 꺼내기
                String lastLetter = String.valueOf(list.get(i).charAt((list.get(i)).length()-1)); // 마지막 글자는 해당 문자열의 길이로 도출
                bw.write(firstLetter+lastLetter);
                bw.newLine();
//                System.out.println(String.valueOf(list.get(i).charAt(0)) + list.get(i).charAt((list.get(i)).length()-1));
            }
            bw.flush();
            bw.close();
            br.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step5-4 11654	아스키 코드
    public void method04() {
/*
조건
    1.주어진 글자의 아스키 코드값을 출력
    2.입력값 : 알파벳 소문자, 대문자, 숫자 0-9

brainstorming
    1.아스키코드 관련 char타입, chatAt()
    2.if조건문? : 타입이 str이라면 (int), int라면 (char) -> 불가능. 이유3번
    3.입력값이 str,int 다 받으므로 str으로 받고 타입에 따라 캐스팅해야할 듯
*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();

            System.out.println((int)input.charAt(0));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*

    정답1 : (int) + .chatAt(0)
        14180	124
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();

            System.out.println((int)input.charAt(0));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
 */

    // Step5-5 11720	숫자의 합
    public void method05() {
/*
조건
    1.입력값 N개의 숫자 , 공백x (1 ≤ N ≤ 100)

    첫째 줄 N : 받을 수의 개수
    둘째 줄 ea : N개만큼 숫자 받음

brainstorming
    1.숫자 하나씩 쪼개기 : chatAt(i)로 for문으로 하나씩 배열에 넣고, 다시 빼면서 sum +=?

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1. 첫째,둘째 값 받기
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            // 2. 둘째 값 쪼개서 배열에 넣기
            int[] arrs = new int[n];
            for(int i = 0; i < n; i++){
                arrs[i] = Integer.parseInt(input.charAt(i)+"");
//                arrs[i] = input.charAt(i); // char타입이지만 아스키코드 변환으로 인트값으로 변환되서 int[]에 파싱없이 들어갈 수 있는 것
            }

            // 3.값 합치기
            int sum = 0;
            for(int i = 0; i < n; i++){
                 sum += arrs[i];
            }
            bw.write(String.valueOf(sum));
            bw.flush();
            bw.close();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*

    정답1 : Array 사용
        14088	124
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

            // 1. 첫째,둘째 값 받기
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            // 2. 둘째 값 쪼개서 배열에 넣기
            int[] arrs = new int[n];
            for(int i = 0; i < n; i++){
                arrs[i] = Integer.parseInt(input.charAt(i)+"");
//                arrs[i] = input.charAt(i); // char타입이지만 아스키코드 변환으로 인트값으로 변환되서 int[]에 파싱없이 들어갈 수 있는 것
            }

            // 3.값 합치기
            int sum = 0;
            for(int i = 0; i < n; i++){
                 sum += arrs[i];
            }
            bw.write(String.valueOf(sum));
            bw.flush();
            bw.close();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */


    // Step5-6 10809	알파벳 찾기
    public void method06() {
/*
조건
    1.알파벳 소문자 구성  단어 S ( S < 100 )
    2.단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력
    3.주어진 단어에서 각 알파벳이 처음 등장하는 인덱스 번호를 반환
        ex) apple이면 a는 문자 첫번째에 왔으므로 0, p는 두세번째 왔으므로 1,2, l은 4번째 왔으므로 3이다.
    4.출력은 a-z까지 전체 알파벳 중에서 주어진 단어에 값이 있으면 해당 인덱스 번호 반환,
                                                    없으면 -1 반환

brainstorming
    1. 인덱스 번호 반환하는 String.indexOf()
    2. a-z까지 다 비교해야하므로 풀스캔. linear search(선형검색) 필요
    3. word의 length구하기
    4. 소문자 변환 : toLowerCase()
    5. 시도1 : 알바팻배열 alphabet 각각 전부 -1임
                여기서 word의 indexOf() 번호로 해당 알파벳만 숫자를 alphabet에 넣기
       시도2 :

*/

/*
    풀이과정

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1.첫째줄 받기
            String word = br.readLine();
            // 비교용 알파벳 배열
            String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","s","y","z"};

            // 2.비교를 위해 배열에 넣기
//            String[] arrStr = new String[word.length()];
//            for(int i = 0; i < word.length(); i++) { // word가  몇 글자(letter)일지 모름. 26은 아니다 nullpoint뜸
//                arrStr[i] = String.valueOf(word.charAt(i));
//            }
            String[] arrStr = null;
            if(word.length() <= 100) {      // 단어 100자 안넘는 유효성검사
                arrStr = new String[word.length()];
                for (int i = 0; i < word.length(); i++) {  // word가  몇 글자(letter)일지 모름. 26은 아니다 nullpoint뜸
                    arrStr[i] = String.valueOf(word.charAt(i)).toLowerCase();
                }
            }
            System.out.println("arrStr : "+ Arrays.toString(arrStr));

//            // 3.알파벳과 word 비교하기
//            int[] answer = new int[26];
//            for(int i = 0; i < 26; i++) { // word가  몇 글자(letter)일지 모름. 26은 아니다 nullpoint뜸
//                answer[i] = arrStr[i].indexOf(alphabet[i]); // error : ArrayIndexOutOfBoundsException 받은 word의 길이와 알파벳26자의 길이가 안맞음. 거의 그럴 수 밖에 없는 구조라 구조 개선 필요
//                // 각 알파벳문자 abcd와 word에서 받은 한글자 씩 비교해야함
////                if(alphabet[i] == arrStr[i]){ // alphabet[i]랑 arrStr[i] 둘 다 String -> 문자열 비교
////
////                }
//                // 아니 근데 indexOf()하면 아니면 -1 반환하고 있으면 자동적으로 해당 인덱스 반환하는데?
//                answer[i] = arrStr[i].indexOf(alphabet[i],i);
//
//                // 또한 값이 0으로만 들어오는 상태
//                System.out.println("arrStr[i]" + arrStr[i]);
//                System.out.println("alphabet[i] : "+alphabet[i]);
//                // indexOf()의 인자에 주어지는 값에 따라 해당 값이 있으면 해당 값의 인덱스 번호 위치를 반환하고 없으면 -1 반환
//            }
//            System.out.println(Arrays.toString(answer));


//            // 3.알파벳과 word 비교하기
//            int[] answer = new int[26];   // 각 알파벳문자 abcd와 word에서 받은 한글자 씩 비교해야함
//            for(int i = 0; i < 26; i++) {   // i : abcd~wxz
//                System.out.println("===================================================================");
//                System.out.println("[i] : "+i);
//                for(int j = 0; j < arrStr.length; j++){  // j : abcd (word 길이만큼)
//                    System.out.println("------------------------------");
//                    System.out.println("[j] : "+j);
//                    answer[i] = arrStr[j].indexOf(alphabet[i]);
//                    System.out.println("arrStr[j] : " + arrStr[j]);
////                    System.out.println("------answer-----"+Arrays.toString(answer));
//                }
////                answer[i] = arrStr[i].indexOf(alphabet[i],i);
//
//                // 또한 값이 0으로만 들어오는 상태
//                System.out.println("alphabet[i] : "+alphabet[i]);
//                // indexOf()의 인자에 주어지는 값에 따라 해당 값이 있으면 해당 값의 인덱스 번호 위치를 반환하고 없으면 -1 반환
//            }
//            System.out.println("======answer======="+Arrays.toString(answer));


            // 3.알파벳과 word 비교하기
            int[] answer = new int[26];   // 각 알파벳문자 abcd와 word에서 받은 한글자 씩 비교해야함
            for(int i = 0; i < 26; i++) {   // i : abcd~wxz
                for(int j = 0; j < arrStr.length; j++){  // j : abcd (word 길이만큼)
                    answer[i] = arrStr[j].indexOf(alphabet[i]);
                    System.out.print(arrStr[j].indexOf(alphabet[i])+" "); // 이중 포문으로 26개보다 넘게 비교중복이 발생함
                }
            }
            System.out.println();
            System.out.println("arrStr[1] : " + arrStr[1]);
            System.out.println("indexof() : "+arrStr[1].indexOf("b"));
            String str = "str";

            // 4.배열에서 값 꺼내서 출력하기
            for(int i = 0; i < answer.length; i++){
                bw.write(answer[i]+ " ");
            }

            bw.flush();
            bw.close();
            br.close();
 */
        try{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1.첫째줄 받기
            String word = br.readLine();
            // 2.비교용 알파벳 배열
            String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","s","y","z"};

            // 3.비교를 위해 word의 문자열을 쪼개서 배열에 넣기
//            String[] arrStr = new String[word.length()];
//            for(int i = 0; i < word.length(); i++) { // word가  몇 글자(letter)일지 모름. 26은 아니다 nullpoint뜸
//                arrStr[i] = String.valueOf(word.charAt(i));
//            }
            String[] arrStr = null;
            if(word.length() <= 100) {      // 단어 100자 안넘는 유효성검사
                arrStr = new String[word.length()];
                for (int i = 0; i < word.length(); i++) {  // word가  몇 글자(letter)일지 모름. 26은 아니다 nullpoint뜸
                    arrStr[i] = String.valueOf(word.charAt(i)).toLowerCase();
                }
            }
            System.out.println("arrStr : "+ Arrays.toString(arrStr));

            // 4.값 하나 씩 대조(linear search)
            int i = 0;
            int j = 0;
            ArrayList<String> list = new ArrayList<>();
            while( i< 26){
                // 알파벳과 arrStr 하나 씩 대조하기
//                if(alphabet[i] == arrStr[j])
//                    list.add(arrStr[j].indexOf(alphabet[i]));
                // 알파벳 값를 찾으면 해당 포문을 멈추고 다음 알바펫값의 포문으로 이동하기 : break
                i++;
            }
//            for(int i = 0; i < 26; i++){
// {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","s","y","z"};
//  [b, a, e, k, j, o, o, n]
// 하나씩 체크하되 값이 있으면 break하고 다음 값 대조하기


        }catch(IOException e){
            e.printStackTrace();
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

 */


    // Step5-7 2675	문자열 반복
    public void method07() {
/*
조건
    1.문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력
        즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식
    2. S에는 QR Code "alphanumeric" 문자만
         - QR Code: 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./:
    첫째 줄 : 테스트 케이스 개수 T(1 ≤ T ≤ 1,000)
    둘째 줄 : 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S 공백 후 주어짐( 문자열 <= 20)

brainstorming
    1.공백 기준 나누기 : StringTokenizer
    2.R만큼 해당 문자 반복
    3. 특문 이스케이프 코드 때문에 다 제대로 들어가는지 확인 필요 : \$%*+-./:
    4.문자열 반복하는 방법
        1)loop
        2) String.repeat() :Java11↑
                ex) String str = "Hello";
                    int a = 5;
                    String repeatedStr = str.repeat(a);
        3)StringBuilder.append()
                ex) StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < a; i++) {
                        sb.append(str);
                    }

*/

/*
    풀이과정

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = null;

            // 1.첫째줄 테스트케이스 T 개수 받기
            int t = Integer.parseInt(br.readLine());

            // 2.둘째줄 반복R값과 문자열 받기
            int[] r = new int[t];
            String[] str = new String[t];
            for(int i = 0; i < t; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                while (st.hasMoreTokens()) {
                    r[i] = Integer.parseInt(st.nextToken());
                    str[i] = st.nextToken();
                }
            }
            
            // 3.반복값 반영하기                     <------------ 여기부터 다시
            String[][] str2nd = new String[r.length][20];
            for(int i = 0; i < t; i++){
                for(int j = 0; j < r.length; j++) // r의 길이는 t에서 정해지므로 값 2개 고정이라 로직 수정 필요
                    str2nd[i][j] = String.valueOf(str[i].charAt(j));
//                        str[0] abc
            }

            // 3.배열에서 각각 값 꺼내서 반복값 반영하기
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < t; i++){
                int num = r[i];
                String[] strings = new String[str[i].length()];
                for(int j = 0; j < str[i].length(); j++){
//                    System.out.println("j : "+ j);
//                    System.out.println("str[i] : "+ str[i].length());
                    strings[j] = String.valueOf(str[i].charAt(j));
                    list.add(strings[j]);
                    System.out.print("strings[j].repeat - "+strings[j].repeat(num));
//                    System.out.println("strings[j] : "+ strings[j]);

                }
                // 방법1 : String.repeat() java11
//                String prints = strings[i].repeat(num);
                list.get(i).repeat(num);
                System.out.println("list :: " + list.get(i).repeat(num));
                System.out.println("repeat :: " + strings[i].repeat(num));

            }
            // 3.배열에서 각각 값 꺼내서 반복값 반영하기
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < t; i++){
                int num = r[i];
                String[] strings = new String[str[i].length()];
                for(int j = 0; j < str[i].length(); j++){
                    strings[j] = String.valueOf(str[i].charAt(j));
                    bw.write(strings[j].repeat(num));
                }
                bw.newLine();
                // 방법1 : String.repeat() java11
                String prints = strings[i].repeat(num);
                list.get(i).repeat(num);
                System.out.println("list :: " + list.get(i).repeat(num));
                System.out.println("repeat :: " + strings[i].repeat(num));
 */
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = null;

            // 1.첫째줄 테스트케이스 T 개수 받기
            int t = Integer.parseInt(br.readLine());

            // 2.둘째줄 반복R값과 문자열 받기
            int[] r = new int[t];
            String[] str = new String[t];
            for(int i = 0; i < t; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                while (st.hasMoreTokens()) {
                    r[i] = Integer.parseInt(st.nextToken());
                    str[i] = st.nextToken();
                }
            }

            // 3.배열에서 각각 값 꺼내서 반복값 반영하기
            //      방법1 : String.repeat() java11↑
//            ArrayList<String> list = new ArrayList<>();
//            for(int i = 0; i < t; i++){
//                int num = r[i];
//                String[] strings = new String[str[i].length()];
//                for(int j = 0; j < str[i].length(); j++){
//                    strings[j] = String.valueOf(str[i].charAt(j));
//                    // 4. 값 반복
//                    bw.write(strings[j].repeat(num));
//                }
//                bw.newLine();
//            }
//            bw.flush();
//            bw.close();
//            br.close();

            // 3.배열에서 각각 값 꺼내서 반복값 반영하기
            //      방법2 StringBuilder.append()
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < t; i++){
                int num = r[i];
                String[] strings = new String[str[i].length()];
                for(int j = 0; j < str[i].length(); j++){
                    strings[j] = String.valueOf(str[i].charAt(j));
                    // 4. 값 반복
                    for(int k = 0; k < num; k++)
                        sb.append(strings[j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }catch(IOException e){
            e.printStackTrace();
        }


    }
/*
    정답1 : java11 String.repeat()
        14044	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = null;

            // 1.첫째줄 테스트케이스 T 개수 받기
            int t = Integer.parseInt(br.readLine());

            // 2.둘째줄 반복R값과 문자열 받기
            int[] r = new int[t];
            String[] str = new String[t];
            for(int i = 0; i < t; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                while (st.hasMoreTokens()) {
                    r[i] = Integer.parseInt(st.nextToken());
                    str[i] = st.nextToken();
                }
            }

            // 3.배열에서 각각 값 꺼내서 반복값 반영하기
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < t; i++){
                int num = r[i];
                String[] strings = new String[str[i].length()];
                for(int j = 0; j < str[i].length(); j++){
                    strings[j] = String.valueOf(str[i].charAt(j));
                    // 4. 값 반복 : 방법1 String.repeat()
                    bw.write(strings[j].repeat(num));
                }
                bw.newLine();
            }

            bw.flush();
            bw.close();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}



    정답2 : StringBuilder + for문
        14036	116
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = null;

            // 1.첫째줄 테스트케이스 T 개수 받기
            int t = Integer.parseInt(br.readLine());

            // 2.둘째줄 반복R값과 문자열 받기
            int[] r = new int[t];
            String[] str = new String[t];
            for(int i = 0; i < t; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                while (st.hasMoreTokens()) {
                    r[i] = Integer.parseInt(st.nextToken());
                    str[i] = st.nextToken();
                }
            }

            // 3.배열에서 각각 값 꺼내서 반복값 반영하기
            //      방법2 StringBuilder.append()
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < t; i++){
                int num = r[i];
                String[] strings = new String[str[i].length()];
                for(int j = 0; j < str[i].length(); j++){
                    strings[j] = String.valueOf(str[i].charAt(j));
                    // 4. 값 반복
                    for(int k = 0; k < num; k++)
                        sb.append(strings[j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}



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

 */


    // Step5-8 1152	단어의 개수
    public void method08() {
/*
조건
    1.

brainstorming
    1.

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

        }catch(IOException e){
            e.printStackTrace();
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

 */


    // Step5-9 2908	상수
    public void method09() {
/*
조건
    1.

brainstorming
    1.

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

        }catch(IOException e){
            e.printStackTrace();
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

 */


    // Step5-10 	5622	다이얼
    public void method10() {
/*
조건
    1.

brainstorming
    1.

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

        }catch(IOException e){
            e.printStackTrace();
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

 */


    // Step5-11 11718	그대로 출력하기
    public void method11() {
/*
조건
    1.

brainstorming
    1.

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

        }catch(IOException e){
            e.printStackTrace();
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

 */





}
