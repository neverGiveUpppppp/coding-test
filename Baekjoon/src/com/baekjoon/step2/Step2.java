package com.baekjoon.step2;

import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Step2 {

    // Step2-1 1330번 : 두 수 비교하기
    public void method01(){
        // 조건 
        // 한 줄에 두 수 받기

        // brain Storming
        // if문 사용
        // 한 줄에 두 수 받기 뭐가 있을까
        // 한 줄에 공백으로 두개 받고 구분자로 나누기? StringTokenizer
        // 방법1 : Scanner + split()
        // 방법2 : BufferedReader + StringTokenizer

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
//        System.out.println(num);    // 1 2

        String[] nums = num.split(" "); // String Class인 split()은 배열로 반환하므로, 배열로 받아야함
//        System.out.println(Arrays.toString(nums)); // [1, 2]

        // 배열로 받은 것을 인덱스 번호로 수 2개로 나눔
        int num1 =  Integer.parseInt(nums[0]);
        int num2 =  Integer.parseInt(nums[1]);

        if(num1 < num2){
            System.out.println("<");
        }else if(num1 > num2){
            System.out.println(">");
        }else {
            System.out.println("==");
        }
/*
정답


<Scanner + String Class split() 방법>
스캐너로 숫자1 공백 숫자2 이런식으로 입력을 받고,
공백을 기준으로 split을 이용하여 나눠서 배열에 넣는다(split이 배열로 반환하기에 배열로 받아줘야함)
이후 배열의 인덱스번호로 두 수를 지정하고 int로 형변환 해주면서 각각 변수에 넣어주고 if문으로 조건을 주어서 출력

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();

        String[] nums = num.split(" "); // String Class인 split()은 배열로 반환하므로, 배열로 받아야함


        // 배열로 받은 것을 인덱스 번호로 수 2개로 나눔
        int num1 =  Integer.parseInt(nums[0]);
        int num2 =  Integer.parseInt(nums[1]);

        if(num1 < num2){
            System.out.println("<");
        }else if(num1 > num2){
            System.out.println(">");
        }else {
            System.out.println("==");
        }

    }
}


 */
/*

BufferedReader + StringTokenizer

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] num = new int[2];
        for(int i=0; i < num.length;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(num));

        int num1 = num[0];
        int num2 = num[1];

        if(num1 > num2){
            System.out.println(">");
        }else if(num1 < num2){
            System.out.println("<");
        }else{
            System.out.println("==");
        }

*/


    }

    // Step2-2 9498번 : 시험 성적
    public void method02() throws IOException {

        // brain Storming
        // 스캐너 혹은 버퍼드리더로 점수 받고, if문으로 나누면 될 듯

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());

//        System.out.println(score);
        if(score >= 90){
            System.out.println("A");
        }else if(score >= 80){
            System.out.println("B");
        }else if(score >= 70){
            System.out.println("C");
        }else if(score >= 60){
            System.out.println("D");
        }else{
            System.out.println("F");
        }

/*
정답

풀이
스캐너 혹은 버퍼드리더로 숫자를 받는다
  - 버퍼드는 str만 받으므로 int로 형변환해야함
  - 또한, import문 넣을 때도 IOException도 같이 넣어줘야 컴파일 에러 안남
각 점수대 별로 if문으로 점수 분배

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());


        if(score >= 90){
            System.out.println("A");
        }else if(score >= 80){
            System.out.println("B");
        }else if(score >= 70){
            System.out.println("C");
        }else if(score >= 60){
            System.out.println("D");
        }else{
            System.out.println("F");
        }
    }
}

 */


    }

    // Step2-3 2753번 : 윤년
    public void method03() throws IOException {

        // brain Storming
        // 조건
        // 윤년 == 4의배수인 연도 중 100의 배수가 아닌 연도 or 400의 배수인 연도
        // 4의 배수이면서 100의 배수가 아님 : (year%4 == 0) and !(year%100 == 0)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());

        if(((year%4 == 0) && !(year%100 == 0))){
            System.out.println("1");
        }else if(year%400 == 0){
            System.out.println("1");
        }else{
            System.out.println("0");
        }


/*
정답

풀이


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());

        if(((year%4 == 0) && !(year%100 == 0))){
            System.out.println("1");
        }else if(year%400 == 0){
            System.out.println("1");
        }else{
            System.out.println("0");
        }
    }
}

 */


    }

    // Step2-4 14681번 : 사분면 고르기
    public void method04() throws IOException {

        // brain Storming
        // x,y는 양수,음수 (0은 제외)

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(),",");
//        // 첫줄 정수x 다음줄 정수y주어진다고 해서 StringTokenizer로 받으면 오답처리 될지도 모름
//        // 오답 처리시, BufferedReader 2개로 받자
//        // 양수 구분 : 0초과  ex) x > 0
//        // 음수 구분 : 0미만  ex) x < 0
//
//        int x = 0;
//        int y = 0;
//        while(st.hasMoreTokens()){
//            x = Integer.parseInt(st.nextToken());
//            y = Integer.parseInt(st.nextToken());
//        }

//        System.out.println(x);
//        System.out.println(y);

//        if( x > 0 && y > 0){
//            System.out.print(1);
//        }else if(x < 0 && y > 0){
//            System.out.print(2);
//        }else if( x < 0 && y < 0){
//            System.out.print(3);
//        }else if(x > 0 && y < 0){
//            System.out.print(4);
//        }else{
//            System.out.print("잘못 입력 되어있습니다");
//        }
        // 인텔리제이에서 돌리면 작동 잘하는데 백준에서 런타임 에러 (NoSuchElement) 발생
        // 아마도 다른 입력 경우의수가 잘못된게 아닌가 싶다
        // br 2개로 받아서 진행해보자

        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

//        int x = Integer.parseInt(br1.readLine());
//        int y = Integer.parseInt(br2.readLine());
//
//        if( x > 0 && y > 0 && x!=0 && y!=0){
//            System.out.print(1);
//        }else if(x < 0 && y > 0 && x!=0 && y!=0){
//            System.out.print(2);
//        }else if( x < 0 && y < 0 && x!=0 && y!=0){
//            System.out.print(3);
//        }else if(x > 0 && y < 0 && x!=0 && y!=0){
//            System.out.print(4);
//        }else{
//            System.out.print("잘못 입력 되어있습니다");
//        }
        // 이번에는 런타임 에러(NumberFormat) 발생
        // 런타임에러 : 배열의 크기를 잘못지정하거나 함수가 끝나지 않을 시 발생
        // 뭐가 문제일까
        // 0 입력 방지 + else의 에러메시지가 str이므로 제거 해보자
        // x,y쪽 br 받는 부분만 for 돌려서 0 안받는 방법?

        
        // if문 조건 x,y가 0이 아닌 조건 추가해도 런타임 에러(NumberFormat) 발생
        // 0 0입력시, else의 에러메세지로 가는거보니 역시 입력부터 0을 받으면 안될 듯
//        if( x > 0 && y > 0 && x!=0 && y!=0){
//            System.out.print(1);
//        }else if(x < 0 && y > 0 && x!=0 && y!=0){
//            System.out.print(2);
//        }else if( x < 0 && y < 0 && x!=0 && y!=0){
//            System.out.print(3);
//        }else if(x > 0 && y < 0 && x!=0 && y!=0){
//            System.out.print(4);
//        }else{
//            System.out.print("잘못 입력 되어있습니다");
//        }

        // x,y에 0 안받는 코드 : for문+if문 조건식
        int x = 0;
        int y = 0;
        for(int i=1; i <=2; i++) {
            if(x!=0 && y!=0) {
               x = Integer.parseInt(br1.readLine());
               y = Integer.parseInt(br2.readLine());
            }
        }


        // 첫 줄에는 정수 x가 주어진다. (−1000 ≤ x ≤ 1000; x ≠ 0) 다음 줄에는 정수 y가 주어진다. (−1000 ≤ y ≤ 1000; y ≠ 0)
        //  -> 백준에서 이런 조건이 주어지면 테스트 시, 해당 수의 범위만 테스트한다는 의미
        //     즉, 0입력을 코드에서 고려할 필요없고, 다른게 문제라는 의미


        // 버퍼드리더 : stream()의 한 종류
        // 스트림 : 임시적으로 데이터를 받아 저장하고 넘겨주면 자신이 가지고 있던 데이터는 삭제함
        // kh 17일차 필기 참조

        // BufferedReader 2개로 각각 x,y로 받았을 때 런타임에러(NumberFormat) 발생한 이유
        // 백준에서는 파일 형식으로 받는데(IDE에서의 작동방식과 다르다는 의미)
        // 스트림으로 데이터를 받을 때, BufferedReader 2개로 각각 받으면 IDE랑 다르게
        // 파일형식이라 첫줄에 br1이 값을 받아 x로 넘기고 br1 값은 지워지고 br2 받을 때 둘째줄로 넘어가는게 아닌
        // 첫줄에서 시작하고 또한 공백값을 받기에 br2가 공백을 받아 NumberFormat이 발생한 것


        
/*
정답

풀이


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {

       BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br1.readLine());
        int y = Integer.parseInt(br1.readLine());

        if( x > 0 && y > 0){
            System.out.print(1);
        }else if(x < 0 && y > 0){
            System.out.print(2);
        }else if( x < 0 && y < 0){
            System.out.print(3);
        }else if(x > 0 && y < 0){
            System.out.print(4);
        }else{
            System.out.print("잘못 입력 되어있습니다");
        }

    }
}

 */

    }

    // Step2-5 2884번 : 알람 시계
    public void method05() throws IOException {

        // 문제 조건
        // 입력 첫 줄 : int 2ea
        //      h : hour    0~23
        //      m : minute  0~59
        // 시간표시 : 24시간 형태
        //           불필요한 0표시 x
        // 첫째 줄에 상근이가 창영이의 방법을 사용할 때, 설정해야 하는 알람 시간을 출력한다



/*
        // brain Storming
        // 입력된 설정 시간보다 시간이 빨라야함(값이 작아야함)
        // -45 한다고하면 hour가 -1되는 경우와 -1시가 되는 경우가 고려되어야함
      1. 분(min)이 -1이하가 되는 경우
        - 0분에서 -되면 59부터 시작해야함 ex)2시30분-45분=1시45분가 되게 해야함
      +60하면 된다
        30-45=45 // 30-45=-15+60 = 45
        20-45=35 // 20-45=-25+60 = 35
        10-45=25 // 10-45=-35+60 = 25
        00-45=15 // 00-45=-45+60 = 15
      2. 시(hour)에 -1해야되는 경우 고려
        - if로 min을 -45해서 h의값이 0이하일 때 -1이면, 23으로 가게해야함
        0:30-45=23:45 // 

        h값 범위 0~23
        0-1 = -1 + 24 = 23
        1-1 = 0 + 24 = 24 // 24시는 0시로 표시해야함
        2-1 = 1 + 24 = 25 // 여기부터는 실질적으로 1시이므로 +24 할 필요 없음
        3-1 = 2 + 24 = 26
        ...
        23-1 = 22 + 24 = 46

        hour -1해서 값이 -인 경우에만 +24하거나 그냥 hour를 if조건줘서 23으로 지정하면 됨



*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int hour = 0;
        int min = 0;

        while(st.hasMoreTokens()){
            hour = Integer.parseInt(st.nextToken());
            min = Integer.parseInt(st.nextToken());
        }
//        System.out.println("h = "+hour);
//        System.out.println("m = "+min);

        if((min-45) < 0 ){
            hour = hour-1;
            min = min - 45 + 60;
            if(hour < 0){
               hour = hour + 24;
            }
            System.out.println(hour+" "+min);
        }else {
            System.out.println(hour + " " + (min - 45));
        }


        // 다른 정답
//        if(min < 45){
//        if((min-45) < 0 ){
//            hour = hour-1;
//            hour--;
//            min = min - 45 + 60;
//            min = 60 - (45 - min);
//            if(hour < 0){
//                hour = hour + 24;
//                hour = 23;
//            }
//        }


/*
정답
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int hour = 0;
        int min = 0;

        while(st.hasMoreTokens()){
            hour = Integer.parseInt(st.nextToken());
            min = Integer.parseInt(st.nextToken());
        }

        if((min-45) < 0 ){
            hour = hour-1;
            min = min - 45 + 60;
            if(hour < 0){
               hour = hour + 24;
            }
			System.out.println(hour + " " + min);
		}
		else {
			System.out.println(hour + " " + (min - 45));
		}


    }
}


다른 정답
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if(M < 45) {
			H--;
			M = 60 - (45 - M);
			if(H < 0) {
				H = 23;
			}
			System.out.println(H + " " + M);
		}
		else {
			System.out.println(H + " " + (M - 45));
		}


풀이



 */

    }

    // Step2-6 2525번 : 오븐 시계
    public void method06() throws IOException {

        // 조건
        // 시작 시간과 조리 시간 주어졌을 때, 요리 끝나는 시간 구하기
        // 첫째줄 : 현재 시각
        // 둘째줄 : 필요 시간
        // 시간의 입출력 : 정수, 시와 분 사이에 공백으로 표현할 것
        // 24시간제 : 23시 넘어가면 0시로
        // 두 줄을 받는데 한 줄에 공백을 처리하면서 받을 수 있어야함
        //  - BufferedReader + StringTokenizer 불가 : 두번째 줄 입력으로 안넘어감
        //  - BufferedReader + readline() 불가 : NumberFormatException
        //  -


/*
        // brain Storming
         필요 시간이 60분이 넘어가면, 끝나는 시간(hour)에 60분당 +1(최대 1000분이므로 16시간까지 +가능)
         시작 시간의 분과 필요시간의 분을 더하여 끝나는 시간의 시(hour)를 도출해야함
         BufferedReader 두줄이상 받기 : 공백 마다 기준 하나마다 st하나씩 받고 다음 줄은 br로 또 받으면 됨

        min + need
           - min 59초과시, hour +1
           - cookTime > 60이면, +1

        14 30 + 20 = 14 50
        14 30 + 30 = 15 00 -> hour에 +1 되어야함

        요리 시간 60이 넘어가면 +1해야함

         60분 이상이면 hour에 +1 해줘야하는데, 2,3시간 넘어갈 경우 각각의 경우의 수를 고려해야함
         1000분 제한이라 switch로 일일히 각 시간을 나눠서 할 수 있지만 너무 비효율적임. 다른 방법이 뭐가 있을까?
         분 단위 계산으로 min에 cookTime을 더하고, 총 min을 60으로 나눠서 hour 더하면 될 듯...?


        풀다 막혀서 구글링



 */


        // BufferedReader + StringTokenizer
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine()," ");
////        StringTokenizer st = new StringTokenizer(br.readLine(),"\\s"); : NumberFormatException 발생
//
//        int hour = Integer.parseInt(st.nextToken());
//        int min = Integer.parseInt(st.nextToken());
//        int need = Integer.parseInt(st.nextToken());
//
//        System.out.println(hour+" "+min);
//        System.out.println(need);
//        // StringTokenizer 구분자 때문에 두번째 줄 입력을 안받는 문제


//        // BufferedReader + readline() : 두개 받기
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int x = Integer.parseInt(br.readLine());
//        int y = Integer.parseInt(br.readLine());
//        // 에러발생 : NumberFormatException: For input string: "14 30"
//        // 공백 때문에 넘버포맷익셉션 발생함


//       // BufferedReader + read()
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int x = br.read();
//        int y = br.read();
//        System.out.println(x);
//        System.out.println(y);
//        // 공백 NumberFormatException 때문에 readline() 대신 read() 사용해봄
//        // integer in the range 0 to 65535 (0x00-0xffff)로 반환 하기 때문에 char로 변환되서 난감해짐



//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        try {
//            while ((line = br.readLine()) != null)
//            {
//                String[] tokens = line.split("\\s");
//                System.out.println(Arrays.toString(tokens));
//            }
//            br.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



        // BufferedReader + StringTokenizer
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int cookTime = Integer.parseInt(br.readLine());

        System.out.println( (min/60) % 24 );

//        if(cookTime >= 60){
//
//            if(cookTime / 60 == 1){
//
//            }
//
//        }
//        if(min >= 60){
//            hour++;
//
//        }



//        System.out.println(hour+" "+min);










/*
정답

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());

        int min = 60 * A + B;   // 시 -> 분
        min += C;

        int hour = (min / 60) % 24;
        int minute = min % 60;

        System.out.println(hour + " " + minute);
    }
}

다른 정답1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());

        int min = 60 * A + B;   // 시 -> 분
        min += C;

        int hour = (min / 60) % 24;
        int minute = min % 60;

        System.out.println(hour + " " + minute);

풀이
전체를 분으로 바뀌서 후에 60을 나누거나 나머지로 시, 분을 각각 구하는 방식
시를 분으로 변환(변수 min)
여기에 요리시간(분)을 더함
이 상태에서 60으로 나눈 나머지가 시(hour)가 되는데, 23시를 넘어가는 경우를 생각해서 24로 나누고 난 나머지를 hour로 사용
또한 분(변수 minute)도 60으로 나눈 나머지는 60이하만 나오기 때문에 자연스레 분으로 만들어진다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());

        int min = 60 * A + B;  // 시 -> 분                // 60 * 17 + 40 = 1060 min
        min += C;              // 전체 분 + 요리시간 분의 합 // 1060 + 80 = 1140min

        int hour = (min / 60) % 24; // 23시를 넘은 0시를 위한 처리           // (1140 / 60) % 24 = 19
        int minute = min % 60;      // 60분 넘어가면 나머지만 구하면 분이 나옴 // (1140 % 60) = 0

        System.out.println(hour + " " + minute);


다른 정답2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int total = 0;

        total = h * 60 + m + c;

        h = ( total / 60) % 24;
        m = total % 60;

        System.out.println(h + " "+ m);



다른 정답3
       int hour = scanner.nextInt();
        int min = scanner.nextInt();
        int cookTime = scanner.nextInt();
        int wholeTime = cookTime + min;

        if (min + cookTime < 60) {
            System.out.println(hour + " " + wholeTime);
        } else {
            if (wholeTime % 60 == 0) {
                if (hour + (wholeTime/60) > 23) {
                    System.out.println(hour + (wholeTime / 60) - 24 + " " + "0");
                } else {
                    System.out.println(hour + (wholeTime / 60) + " " + "0");
                }
            } else {
                if (hour + (wholeTime/60) > 23) {
                    System.out.println(hour + (wholeTime / 60) - 24 + " " + (wholeTime % 60));
                } else {
                    System.out.println(hour + (wholeTime / 60) + " " + (wholeTime % 60));
                }
            }
        }

 */


    }

    // Step2-7 2480번 : 주사위 세개
    public void method07() throws IOException {

        // 문제조건
        // 목표 : 주어진 주사위에 따른 상금계산
        // 3개의 주사위
        // 같은 눈 3 : 10000 + (three) * 1000
        // 같은 눈 2 : 1000 + (two) * 100
        // 같은 눈 1 : (maxNumber) * 100


        // brain Storming
        // 조건문 카테고리니 3개의 눈의 경우의 수를 if문으로?
        // 마지막 최대값 구하는 식 적용해야함
        //  a :       a > b
        //            b > c
        //
        //  c :       a > b
        //            c > a
        //
        //  b :       b > a
        //            b > c 
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int three = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        int one = Integer.parseInt(st.nextToken());
        int total = 0;


        if((three == two) && (three == one)){
            // 같은 눈 3 : 10000 + (three) * 1000
            total = 10000 + (three) * 1000;
        }else if((three == two) && (three != one)){
            // 같은 눈 2 : 1000 + (two) * 100
            total = 1000 + (two) * 100;
        }else if((three != two) && (three != one)){
            // 같은 눈 1 : (maxNumber) * 100
            if((three > two) && (two > one)){ // three = max
                total = (three) * 100;
            }else if((three > two) && (one > three)){ // one = max
                total = (one) * 100;
            }else if((three > two) && (one > three)){ // two = max
                total = (two) * 100;
            }

            // 최대값 구하는 식이나 함수 구글링할 것
            // Math.max()
            // 향상된 포문+배열
            // 자바 배열의 최대값 구하는 3가지방법
            // https://wakestand.tistory.com/423
            // 주석

        }else{
            System.out.println("잘못입력함");
        }

        System.out.println(three);
        System.out.println(two);
        System.out.println(one);

        System.out.println(total);


/*
정답

풀이


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


 */


    }


/*
정답

풀이


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


 */




public static class Step2_2023 {




}}
