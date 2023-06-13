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
    주어진 문자열에 단어가 몇개?
    1.문자열 구성 : 영대소문자 공백 ( str < 1,000,000)
    2.단어 구분  : 공백
    3.중복된 단어 카운트o
    4.공백 연속x
    5.문자열 시작·끝 : 공백o



brainstorming
    1.공백 구분 : String.split(), StringTokenizer
        - 단어 길이제한이나 요구사항이 없으므로 위 둘 단순 사용가능
    2.각 단어 구분해서 저장 : ArrayList, array
    3.길이 카운트 : length, size()


*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            // 1.가로 한 줄 입력값 받기
            ArrayList<String> list = new ArrayList<>();
            while(st.hasMoreTokens()){  
                list.add(st.nextToken());   // 길이 어떤 요구조건이 없어서 가공없이 가능
            }
            // 2.list 길이 카운트
            bw.write(String.valueOf(list.size()));
            bw.flush();
            bw.close();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*

    정답1 StringTokenizer
        26608	320
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
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            // 1.가로 한 줄 입력값 받기
            ArrayList<String> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(st.nextToken());   // 길이 어떤 요구조건이 없어서 가공없이 가능
            }
            // 2.list 길이 카운트
            bw.write(String.valueOf(list.size()));
            bw.flush();
            bw.close();
            br.close();
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
    수의 크기 비교
    입력값 : 세 자리 수 두 개
    1.각 수를 숫자 거꾸로
    2.큰 수 도출

brainstorming
    1.받은 입력값 양수를 str로 변환
    2.String.reverse()로 각 값 순서 반전시킴
    3.다시 str to int 캐스팅
    4.큰 수 비교 도출


*/

/*
    풀이과정

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = new StringBuilder();

            // 1.가로 한 줄 두 수 입력값 받기
            ArrayList<String> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

            // 2.값 뒤집기
            //   방법1 : loop + chatAt()
//            ArrayList<String> list2 = new ArrayList<>();
////            String reverse = "";
//            for(int i = list.size()-1; i >= 0; i--){ // list길이는 두 입력값에 대한 길이. list 내부값의 길이는 이중for문에서 설정해야함
//                String reverse = "";
//                for(int j = list.get(i).length()-1; j >= 0; j--){
//                    int k = 0;  // i를 쓰면 list 0 1번중 뒤에 값인 1번부터 값이 들어가서 reverse할 때 들어가는 값이 뒷값부터 거꾸로 들어가게됨. 이를 방지하기 위한 k변수
////                    reverse = reverse + list.get(j).charAt(j); // list.get(j)하면 list에 0 1들어가있는데 2를 불러와서 IndexOutOfBoundsException 발생
//                      reverse += list.get(k).charAt(j);
//                    k++;
//                }
//                list2.add(reverse);
//                System.out.println("list2 : " + list2);
//            }
 */

/*
    // 방법1 : loop + chatAt()
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = null;

            // 1.가로 한 줄 두 수 입력값 받기
            ArrayList<String> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

            // 2.값 뒤집기
            ArrayList<String> list2 = new ArrayList<>();
            for(int i = list.size()-1; i >= 0; i--){  // list길이는 두 입력값에 대한 길이. list 내부값의 길이는 이중for문에서 설정해야함
                String reverse = "";
                for(int j = list.get(i).length()-1; j >= 0; j--){
                    reverse += list.get(i).charAt(j);
                }
                list2.add(reverse); // 입력값에서 받은 첫수와 둘째 수의 순서가 바뀌긴 함 ex) 123 456이 -> 654 321
            }

            // 3.최대값 찾기
            //      그냥 if문 간단비교로 끝내면 더 빠를 것 같긴하나 최대값 알고리즘 공부를 위해 사용함
            int max = -1;
            for(int i = 0; i < list2.size(); i++){
                int num = Integer.parseInt(list2.get(i));
                if(max < num){
                    max = num;
                }
            }

            bw.write(max+"");
            bw.flush();
            bw.close();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

 */
    // 방법2 : StringBuilder + reverse()
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = null;

            // 1.가로 한 줄 두 수 입력값 받기
            ArrayList<String> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

            // 2.값 뒤집기
            ArrayList<String> list2 = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){  // list길이는 두 입력값에 대한 길이. list 내부값의 길이는 이중for문에서 설정해야함
                sb = new StringBuilder(list.get(i));
                list2.add(sb.reverse().toString());
            }

            // 3.최대값 찾기
            //      그냥 if문 간단비교로 끝내면 더 빠를 것 같긴하나 최대값 알고리즘 공부를 위해 사용함
            int max = -1;
            for(int i = 0; i < list2.size(); i++){
                int num = Integer.parseInt(list2.get(i));
                if(max < num){
                    max = num;
                }
            }
//            sb = null;  // NullPointerException : null이라 값을 넣을 객체 자체가 없음
            sb = new StringBuilder(); // 새 인스턴스 생성 이유 : reverse()쓰면서 이미 값이 들어있어 max값을 append추가하면 중복값이 나오는데 값 클리어할 메소드도 없음
            sb.append(max);
            System.out.println(sb.toString());
        }catch(IOException e){
            e.printStackTrace();
        }
/*
list의 값 정제하기
    ArrayList + 이중for문

    1차 for문은 전체 입력값(list의 길이)임
        - list.get(i)식으로 1차for문 변수인 i관련 값을 써야함
    2차 for문은 list 내부의 각각의 값들(list.get()한 값)임
        - list.get(j)식으로 2차for문 변수인 j관련 값을 써야함

 */

    }
/*

    방법1 : loop + chatAt()
        14228	128
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // 1.가로 한 줄 두 수 입력값 받기
            ArrayList<String> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

            // 2.값 뒤집기
            //   방법1 : loop + chatAt()
            ArrayList<String> list2 = new ArrayList<>();
            for(int i = list.size()-1; i >= 0; i--){  // list길이는 두 입력값에 대한 길이. list 내부값의 길이는 이중for문에서 설정해야함
                String reverse = "";
                for(int j = list.get(i).length()-1; j >= 0; j--){
                    reverse += list.get(i).charAt(j);
                }
                list2.add(reverse); // 입력값에서 받은 첫수와 둘째 수의 순서가 바뀌긴 함 ex) 123 456이 -> 654 321
            }

            // 3.최대값 찾기
            //      그냥 if문 간단비교로 끝내면 더 빠를 것 같긴하나 최대값 알고리즘 공부를 위해 사용함
            int max = -1;
            for(int i = 0; i < list2.size(); i++){
                int num = Integer.parseInt(list2.get(i));
                if(max < num){
                    max = num;
                }
            }
            bw.write(max+"");
            bw.flush();
            bw.close();
            br.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}


    방법2 : StringBuilder + reverse()
        14196	124
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = null;

            // 1.가로 한 줄 두 수 입력값 받기
            ArrayList<String> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }

            // 2.값 뒤집기
            ArrayList<String> list2 = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){  // list길이는 두 입력값에 대한 길이. list 내부값의 길이는 이중for문에서 설정해야함
                sb = new StringBuilder(list.get(i));
                list2.add(sb.reverse().toString());
            }

            // 3.최대값 찾기
            //      그냥 if문 간단비교로 끝내면 더 빠를 것 같긴하나 최대값 알고리즘 공부를 위해 사용함
            int max = -1;
            for(int i = 0; i < list2.size(); i++){
                int num = Integer.parseInt(list2.get(i));
                if(max < num){
                    max = num;
                }
            }
//            sb = null;  // NullPointerException : null이라 값을 넣을 객체 자체가 없음
            sb = new StringBuilder(); // 새 인스턴스 생성 이유 : reverse()쓰면서 이미 값이 들어있어 max값을 append추가하면 중복값이 나오는데 값 클리어할 메소드도 없음
            sb.append(max);
            System.out.println(sb.toString());
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
    주어진 단어로 전화번호 걸기 -> 다이얼을 걸기 위해서 필요한 최소 시간을 출력
        해당 문자를 번호 전환 필요
    1.숫자 1개 입력 후 다이얼 리셋
    2.숫자1 : 걸리는 시간 2초
        한 칸마다 +1초
    3.그림에 있는 abc는 2 def3 ...

brainstorming
    1. 다이얼 걸리는 시간 : 2에다가 ++하면?
    2. 최소 시간

*/
        
/*
    풀이과정
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1.문자열 받기
            String word = br.readLine().toUpperCase();  // 대문자로 치환

            // 2.문자를 다이얼 번호로 파싱
            ArrayList<Integer> numbers = new ArrayList<>();
            for(int i = 0; i < word.length(); i++){
                // 1)다이얼의 문자to숫자 조건적용
                // switch문 적용
//                switch(String.valueOf(word.charAt(i))){
//                    case "A" : numbers.add(1); break;
//                    case "B" : numbers.add(1); break;
//                    case "C" : numbers.add(1); break;
//                    case "D" : numbers.add(2); break;
//                    case "E" : numbers.add(2); break;
//                    case "F" : numbers.add(2); break;
//                    ...
//                } // 지저분해지니 좀 더 코드 줄일 수 있게 if로 여러개 묶어보자
                // string, int 다 논리연산자 사용해서 ==, equals() 사용불가

                // 1)다이얼의 문자to숫자 조건적용
//                if(String.valueOf(word.charAt(i)).equals("A" ||"B" || "C")){ // 컴파일 에러: "A" || "B" || "C" <- 논리연산자를 java.lang.String class에 사용 불가
                // 대안 : chatAt()으로 꺼내서 char 타입이니 아스키코드 이용해서 숫자로 바꾼다음 대량으로 비교하고 list에 넣을 때 다이얼번호로 넣으면?
//                System.out.println((int)word.charAt(i)); // w 87 a 65
//                if((int)word.charAt(i) == (65 || 66)){
//                }

*/
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1.문자열 받기
            String word = br.readLine().toUpperCase();  // 대문자로 치환

            // 2.문자를 다이얼 번호로 파싱
            ArrayList<Integer> numbers = new ArrayList<>();
            for(int i = 0; i < word.length(); i++){
                // 1)다이얼의 문자to숫자 조건적용        
                switch(String.valueOf(word.charAt(i))){
                    case "A" : numbers.add(2); break;
                    case "B" : numbers.add(2); break;
                    case "C" : numbers.add(2); break;
                    case "D" : numbers.add(3); break;
                    case "E" : numbers.add(3); break;
                    case "F" : numbers.add(3); break;
                    case "G" : numbers.add(4); break;
                    case "H" : numbers.add(4); break;
                    case "I" : numbers.add(4); break;
                    case "J" : numbers.add(5); break;
                    case "K" : numbers.add(5); break;
                    case "L" : numbers.add(5); break;
                    case "M" : numbers.add(6); break;
                    case "N" : numbers.add(6); break;
                    case "O" : numbers.add(6); break;
                    case "P" : numbers.add(7); break;
                    case "Q" : numbers.add(7); break;
                    case "R" : numbers.add(7); break;
                    case "S" : numbers.add(7); break;
                    case "T" : numbers.add(8); break;
                    case "U" : numbers.add(8); break;
                    case "V" : numbers.add(8); break;
                    case "W" : numbers.add(9); break;
                    case "X" : numbers.add(9); break;
                    case "Y" : numbers.add(9); break;
                    case "Z" : numbers.add(9); break;
                }
            }

            // 3.다이얼 걸기(시간계산)
            int wholeTime = 0;  // 총 다이얼 시간
            final int one = 2;  // 상수 써보자. 어차피 전화번호 값은 변하지 않으니
            final int two = 3;
            final int three = 4;
            final int four = 5;
            final int five = 6;
            final int six = 7;
            final int seven = 8;
            final int eight = 9;
            final int nine = 10;

            for(int i = 0; i < word.length(); i++){
                switch(numbers.get(i)){
                    case 1 : wholeTime += one; break;
                    case 2 : wholeTime += two; break;
                    case 3 : wholeTime += three; break;
                    case 4 : wholeTime += four; break;
                    case 5 : wholeTime += five; break;
                    case 6 : wholeTime += six; break;
                    case 7 : wholeTime += seven; break;
                    case 8 : wholeTime += eight; break;
                    case 9 : wholeTime += nine; break;
                }
            }
            bw.write(wholeTime+"");
            bw.flush();
            bw.close();
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
/*

    정답1
        14124	132
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1.문자열 받기
            String word = br.readLine().toUpperCase();  // 대문자로 치환

            // 2.문자를 다이얼 번호로 파싱
            ArrayList<Integer> numbers = new ArrayList<>();
            for(int i = 0; i < word.length(); i++){
                switch(String.valueOf(word.charAt(i))){
                    case "A" : numbers.add(2); break;
                    case "B" : numbers.add(2); break;
                    case "C" : numbers.add(2); break;
                    case "D" : numbers.add(3); break;
                    case "E" : numbers.add(3); break;
                    case "F" : numbers.add(3); break;
                    case "G" : numbers.add(4); break;
                    case "H" : numbers.add(4); break;
                    case "I" : numbers.add(4); break;
                    case "J" : numbers.add(5); break;
                    case "K" : numbers.add(5); break;
                    case "L" : numbers.add(5); break;
                    case "M" : numbers.add(6); break;
                    case "N" : numbers.add(6); break;
                    case "O" : numbers.add(6); break;
                    case "P" : numbers.add(7); break;
                    case "Q" : numbers.add(7); break;
                    case "R" : numbers.add(7); break;
                    case "S" : numbers.add(7); break;
                    case "T" : numbers.add(8); break;
                    case "U" : numbers.add(8); break;
                    case "V" : numbers.add(8); break;
                    case "W" : numbers.add(9); break;
                    case "X" : numbers.add(9); break;
                    case "Y" : numbers.add(9); break;
                    case "Z" : numbers.add(9); break;
                }
            }

            // 3.다이얼 걸기(시간계산)
            int wholeTime = 0;  // 총 다이얼 시간
            final int one = 2;  // 상수 써보자. 어차피 전화번호 값은 변하지 않으니
            final int two = 3;
            final int three = 4;
            final int four = 5;
            final int five = 6;
            final int six = 7;
            final int seven = 8;
            final int eight = 9;
            final int nine = 10;

            for(int i = 0; i < word.length(); i++){
                switch(numbers.get(i)){
                    case 1 : wholeTime += one; break;
                    case 2 : wholeTime += two; break;
                    case 3 : wholeTime += three; break;
                    case 4 : wholeTime += four; break;
                    case 5 : wholeTime += five; break;
                    case 6 : wholeTime += six; break;
                    case 7 : wholeTime += seven; break;
                    case 8 : wholeTime += eight; break;
                    case 9 : wholeTime += nine; break;
                }
            }
            bw.write(wholeTime+"");
            bw.flush();
            bw.close();
            br.close();
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


    // Step5-11 11718	그대로 출력하기
    public void method11() {
/*
조건
    입력 받은 그대로 출력하기
    1.입력값 구성 : 알파벳 소문자, 대문자, 공백, 숫자 ( input <= 100줄 )
    2.빈 줄 x, 공백 시작·끝 x

brainstorming
    1. 가로 세로 각각 몇 줄이 오는 지 모름
        일단 지정된 가로 길이가 없으니 StringTokenizer + while(hasMoreToken())?
            구분자로 또 잘라넣어야하기에 안맞음
        br.readLine()으로  한 줄 통째로 받고 각각 출력
    2.StringBuilder에 하나씩 문자열 축적?
        한 줄 받고, 한 줄 줄바꿈 반복
    3.EOF 문제!


*/

/*

    풀이과정

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 1. 가로 입력값 받기
//            StringTokenizer st = new StringTokenizer(br.readLine()," ");
//
//            ArrayList<String> list = new ArrayList<>();
//            while(st.hasMoreTokens()){
//                list.add(st.nextToken());
//            }

//            // loop반복횟수 정할려니 몇번 도는 지 아예 모름. 즉, 설정 불가
//            String str1 = br.readLine();
//            String str2 = br.readLine();
//            String str3 = br.readLine();
//
//            System.out.println(str1);
//            System.out.println(str2);
//            System.out.println(str3);

//            String str = br.readLine();
//            String store = null;
//            while((str = br.readLine()) != null) {  EOF 문제 같음. 얼마나 값을 받을 지 모르기에
//                store = br.readLine();
//            }
*/


        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String input = "";
            ArrayList<String> list = new ArrayList<>();
            while((input = br.readLine()) != null && !input.isEmpty()) {
                list.add(input);
            }
            for(String i : list){
                System.out.println(i);
            }

        }catch(IOException e){
            e.printStackTrace();
        }


    }
/*

    정답1
        14412	128
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

            String input = "";
            ArrayList<String> list = new ArrayList<>();
            while((input = br.readLine()) != null && !input.isEmpty()) {
                list.add(input);
            }
            for(String i : list){
                System.out.println(i);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

 */





}
