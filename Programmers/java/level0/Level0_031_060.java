package level0;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// level0 : 중복된 숫자 개수
/*
조건
    array에 n이 몇 개 있는 지를 return
    1.
    2.

brainstorming
    1.저번에 나온 set 써보기
    2.

*/
class Solution031 {
    public static void main(String[] args) {
        Solution031 prbs = new Solution031();
        int[] arr = {1, 1, 2, 3, 4, 5};
        int answer = prbs.solution(arr, 1);
        System.out.println(answer);
    }

    public int solution(int[] array, int n) {
        // 정답1 : HashSet + contains() 사용
//        int answer = 0;
////        List<int[]> list = Arrays.asList(array);
////        Set<int[]> set2 = new HashSet<>(list); // array -> list 변환 -> 그리고 set 적용 가능
//        Set<Integer> set = new HashSet<>();
//        set.add(n);
//
//        for (int i = 0; i < array.length; i++) {
//            if(set.contains(array[i]))
//                answer++;
//        }
//        return answer;

        // 정답2 : Arrays.Stream() + filter() + count()
        return (int)Arrays.stream(array).
                    filter(e -> e == n).
                    count(); // count() : mapToLong(e -> 1L).sum()
        // 정답3 : Arrays.Stream() + filter() + sum()
//        return Arrays.stream(array).
//                filter(e -> e == n).
//                sum(); // sum() : reduce(0, Integer::sum)
    }
}

/*

    정답1 : Hash + contains() 사용
import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();
        set.add(n);
        for (int i = 0; i < array.length; i++) {
            if(set.contains(array[i]))
                answer++;
        }
        return answer;
    }
}


    정답2 : Stream() + filter() + count()


 */



// level0 : 머쓱이보다 키 큰 사람
/*
조건
    머쓱이네 반 친구들의 키가 담긴 정수 배열 array와 머쓱이의 키 height가 매개변수로 주어질 때,
    머쓱이보다 키 큰 사람 수를 return
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution032 {
    public static void main(String[] args) {
        Solution032 prbs = new Solution032();
        int[] arr = {149, 180, 192, 170};
        int answer = prbs.solution(arr, 167);
        System.out.println(answer);
    }

    public int solution(int[] array, int height) {
        int answer = 0;
        for(int i = 0; i < array.length; i++){
            if(height < array[i])
                answer++;
        }
        return answer;
    }
}

/*

    정답1
class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;

        for(int i = 0; i < array.length; i++){
            if(height < array[i])
                answer++;
        }

        return answer;
    }
}

 */


// level0 : 자릿수 더하기
/*
조건
    1.
    2.

brainstorming
    1.loop + charAt()으로 자릿수마다 하나씩 빼서 더하기?
        char타입이라 아스키코드 변환문제랑 문자열 길이를 알아야해서 str로 변환필요
    2.

*/
class Solution033 {
    public static void main(String[] args) {
        Solution033 prbs = new Solution033();
        int answer = prbs.solution(1234);
        System.out.println(answer);
    }

    public int solution( int n) {
        int answer = 0;

//        String str = String.valueOf(n);
//        for(int i = 0; i < str.length(); i++)
//            answer += (int)str.charAt(i);

        LinkedList<String> list = new LinkedList<>();
        String str = String.valueOf(n);

        for (int i = 0; i < str.length(); i++) {
            list.add(String.valueOf(str.charAt(i)));
        }
        for (int i = 0; i < str.length(); i++) {
            answer += Integer.parseInt(list.pop()); // 끝에서 빼오는 큐(queue)의 메소드 pop() //  자바에서 큐는 주로 LinkedList로 구현
        }
        return answer;
    }
}

/*

    정답1
import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;

        LinkedList<String> list = new LinkedList<>();
        String str = String.valueOf(n);

        for (int i = 0; i < str.length(); i++) {
            list.add(String.valueOf(str.charAt(i)));
        }
        for (int i = 0; i < str.length(); i++) {
            answer += Integer.parseInt(list.pop());
        }
        return answer;
    }
}


 */


// level0 : 배열 두배 만들기
/*
조건
    numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution034 {
    public static void main(String[] args) {
        Solution034 prbs = new Solution034();
        int[] arr = {1, 2, 3, 4, 5};
        int[] answer = prbs.solution(arr);
        System.out.println(answer);
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++)
            answer[i] = numbers[i] * 2;
        
        
        return answer;
    }
}

/*
    정답1
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++)
            answer[i] = numbers[i] * 2;
        
        
        return answer;
    }
}

 */


// level0 : 특정 문자 제거하기
/*
조건
    my_string에서 letter를 제거한 문자열을 return
    1.my_string 전체를 loop 한번 돌면서 letter를 찾아 제거 String.remove()
    2.대소문자 구별

brainstorming
    1.a문장에서 b의 문자를 제거한 a문장 리턴이 조건이므로 a문장 전체를 한바퀴 돌아야함 -> 브루트포스 필요
    2.제거 : ArrayList.remove() or LinkedList.pop()
    3.str -> list로 넣는 loop 1번, letter 제거하는 loop 1번
    4.반드시 제거해야하므로 Set은 사용불가


*/
class Solution035 {
    public static void main(String[] args) {
        Solution035 prbs = new Solution035();

        String my_string = "abcdef";
        String letter = "f";
        String answer = prbs.solution(my_string,letter);
        System.out.println(answer);
    }

    public String solution(String my_string, String letter) {
        String answer = "";

        List<String> list = new ArrayList<>();

        // 1.String to List 변환
        for (int i = 0; i < my_string.length(); i++) {
            list.add(String.valueOf(my_string.charAt(i)));
        }
        // 2.my_string에서 letter 제거
        for(int i = 0; i < my_string.length(); i++){
            if(list.get(i).equals(letter)){
            }else{
                answer += list.get(i);
            }
        }
        return answer;
    }
}

/*

    정답1
import java.util.*;

class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";

        List<String> list = new ArrayList<>();

        // 1.String to List 변환
        for (int i = 0; i < my_string.length(); i++) {
            list.add(String.valueOf(my_string.charAt(i)));
        }
        // 2.my_string에서 letter 제거
        for(int i = 0; i < my_string.length(); i++){
            if(list.get(i).equals(letter)){
            }else{
                answer += list.get(i);
            }
        }
        return answer;
    }
}

 */


    // level0 : 숨어있는 숫자의 덧셈 (1)
/*
조건
    my_string안의 모든 자연수들의 합을 return
    1.my_string은 소문자, 대문자 그리고 한자리 자연수로만 구성
    2.

brainstorming
    1.문자열에 있는 숫자의 연산 : 어떻게 되지?
    2.문자열에서 숫자인지 확인하는 법
        1)Character.isDigit()
        2)아스키코드 이용 : if (ch >= '0' && ch <= '9') {

*/
class Solution036 {
    public static void main(String[] args) {
        Solution036 prbs = new Solution036();
        String input = "aAb1B2cC34oOp";
        String answer = String.valueOf(prbs.solution(input));
        System.out.println(answer);
    }

    public int solution(String my_string) {
        int answer = 0;

        // 방법1 : Character.isDigit() 사용
//        for(int i = 0; i < my_string.length(); i++) {
//            if (Character.isDigit(my_string.charAt(i))) {
//                answer += Integer.parseInt(String.valueOf(my_string.charAt(i)));
//            }
//        }

        // 방법2 : 아스키코드 이용 : if (ch >= '0' && ch <= '9')
//        for(int i = 0; i < my_string.length(); i++) {
//            if(my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9') {
//                answer += Integer.parseInt(String.valueOf(my_string.charAt(i)));
//            }
//        }

        // 방법3 : foreach + .toCharArray() + 아스키코드
        for(char ch : my_string.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                answer += Integer.parseInt(String.valueOf(ch));
            }
        }
        // 방법4 : Character.isDigit() + Character.getNumericValue()
//        for (char ch : my_string.toCharArray()) {
//            if (Character.isDigit(ch)) {
//                answer += Character.getNumericValue(ch);
//            }
//        }
        return answer;
    }
}

/*

    정답1
import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;

        // 방법1 : Character.isDigit() 사용
//        for(int i = 0; i < my_string.length(); i++) {
//            if (Character.isDigit(my_string.charAt(i))) {
//                answer += Integer.parseInt(String.valueOf(my_string.charAt(i)));
//            }
//        }

        // 방법2 : 아스키코드 이용 : if (ch >= '0' && ch <= '9')
//        for(int i = 0; i < my_string.length(); i++) {
//            if(my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9') {
//                answer += Integer.parseInt(String.valueOf(my_string.charAt(i)));
//            }
//        }

        // 방법3 : foreach + .toCharArray() + 아스키코드
        for(char ch : my_string.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                answer += Integer.parseInt(String.valueOf(ch));
            }
        }
        // 방법4 : Character.isDigit() + Character.getNumericValue()
//        for (char ch : my_string.toCharArray()) {
//            if (Character.isDigit(ch)) {
//                answer += Character.getNumericValue(ch);
//            }
//        }
        return answer;
    }
}
 */


// level0 : 문자열안에 문자열
/*
조건
    str1 안에 str2가 있다면 1을 없다면 2를 return
    1.문자열은 알파벳 대문자, 소문자, 숫자로 구성
    2.

brainstorming
    1.문자열 관련 함수를 써야할 것 같음
    2.

*/
class Solution037 {
    public static void main(String[] args) {
        Solution037 prbs = new Solution037();
        String answer = String.valueOf(prbs.solution("ppprrrogrammers", "pppp"));
        System.out.println(answer);
    }

    public int solution(String str1, String str2) {
        int answer = 0;

//        // 방법1. String.contains()
//        if(str1.contains(str2)){
//            answer = 1;
//        }else{
//            answer = 2;
//        }

        // 방법2. String.indexOf() : 찾는 문자열이 존재하면 해당 문자열의 인덱스를 반환하고, 없으면 -1을 반환
        if (str1.indexOf(str2) != -1) { // 응용 : char boolean처럼 사용 할 수 있을 듯함
            answer = 1;
        }else{
            answer = 2;
        }
        return answer;
    }
}

/*

    정답1
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
//        // 방법1. String.contains()
//        if(str1.contains(str2)){
//            answer = 1;
//        }else{
//            answer = 2;
//        }
        // 방법2. String.indexOf() : 찾는 문자열이 존재하면 해당 문자열의 인덱스를 반환하고, 없으면 -1을 반환
        if (str1.indexOf(str2) != -1) {
            answer = 1;
        }else{
            answer = 2;
        }
        return answer;
    }
}

 */


// level0 : 짝수는 싫어요
/*
조건
    정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution038 {
    public static void main(String[] args) {
        Solution038 prbs = new Solution038();
        int[] answer = prbs.solution(15);
        System.out.println(answer);
    }

    public int[] solution(int n) {
        int odd = 0;
        // 1)홀수 개수 구하기
        for(int i = 0; i < n; i++){
            if(i % 2 != 0){
                odd++;
            }
        }
        // 2)n이 홀수면 n까지 포함하기
        if(n % 2 != 0){
            odd++;
        }
        // 3)홀수 만들어 넣기
        int[] answer = new int[odd];
        answer[0] = 1;
        for(int i = 1; i <= odd-1; i++){
            answer[i] = (2 * i) + 1;
        }
        return answer;
    }
}

/*

    정답1


 */


// level0 : 제곱수 판별하기
/*
조건
    n이 제곱수라면 1을 아니라면 2를 return
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution039 {
    public static void main(String[] args) {
        Solution039 prbs = new Solution039();
        int answer = prbs.solution(144);
        System.out.println(answer);
    }

    public int solution(int n) {
        int answer = 0;

        double sqrt1 = Math.sqrt(n);
        int sqrt2 = (int)Math.sqrt(n);

        if(sqrt1 == sqrt2){ // 구한 제곱근을 int로 캐스팅한 제곱근과 원본값 double 제곱근이 같으면 제곱근, 아니면 제곱근X
            answer = 1;
        }else{
            answer = 2;
        }
        return answer;
    }
}

/*

    정답1


 */


// level0 : 세균 증식
/*
조건
    세균의 마리수 n과 경과한 시간 t가 매개변수로 주어질 때 t시간 후 세균의 수를 return
    1.1시간에 두배만큼 증식
    2.

brainstorming
    1.
    2.

*/
class Solution040 {
    public static void main(String[] args) {
        Solution040 prbs = new Solution040();
        int answer = prbs.solution(10, 15);
        System.out.println(answer);
    }

    public int solution(int n, int t) {
        int answer = n;
        if(t > 1){
            for(int i = 0; i < t; i++){
                answer = answer * 2;
            }
        }else if(t == 1){
            answer = n * 2;
        }
        return answer;
    }
}

/*

    정답1
class Solution {
    public int solution(int n, int t) {
        int answer = n;

        if(t > 1){
            for(int i = 0; i < t; i++){
                answer = answer * 2;
            }
        }else if(t == 1){
            answer = n * 2;
        }

        return answer;
    }
}

 */


// level0 : 중앙값 구하기
/*
조건
    1.정수 배열 중 가운데 값 구하기
    2.배열 길이는 홀수로만

brainstorming
    1.값 받고 일단 오름차순 정렬하기
    2.배열 길이에서 / 2해서 몫만 구하고, +1하면 중앙 인덱스 도출가능

*/
class Solution041 {
    public static void main(String[] args) {
        Solution041 prbs = new Solution041();
        int[] answer = new int[]{2, 9, 5, 7, 6};
        prbs.solution(answer);
        System.out.println(answer);
    }

    public int solution(int[] array) {
        int answer = 0;
        // 1.배열 정렬하기
        Arrays.sort(array);
        // 2.중앙값의 인덱스 번호 구하기
        int index = (int)Math.floor(array.length / 2) + 1; //  floor()는 doulbe 반환이라 (int) 캐스팅 필요
        answer = array[index - 1]; // zero-base index이므로 -1해줘야함
        System.out.println(answer);
        return answer;
    }
}

/*

    정답1
import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        // 1.배열 정렬하기
        Arrays.sort(array); // order by ASC
        //        Arrays.sort(array, Collections.reverseOrder());   // order by DESC
        // 2.중앙값의 인덱스번호 구하기
        int index = (int)Math.floor(array.length / 2) + 1;  // floor()는 doulbe 반환이라 (int) 캐스팅 필요
        answer = array[index-1]; // zero-base index이므로 -1해줘야함
        return answer;
    }
}

 */



// level0 : 문자열의 뒤의 n글자
/*
/*
조건
    1.뒤에서부터 n길이만큼 출력
    2.

brainstorming
    1.인덱스 필요 : array or arraylist
    2.받은 문자로 배열로 전환하기
    3.split()?, substring으로 짤라서 도출하기

*/

class Solution042 {
    public static void main(String[] args) {
        Solution042 prbs = new Solution042();
        String answer = prbs.solution("ProgrammerS123", 11);
        System.out.println(answer);
    }

    public String solution(String my_string, int n) {
        String answer = "";
        int length = my_string.length();
        answer = my_string.substring(length - n, length);
        return answer;
    }
}

/*

    정답1
class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        int length = my_string.length();
        answer = my_string.substring(length - n, length);

        return answer;
    }
}

 */



// level0 : 대문자로 바꾸기
/*
조건
    1.모든 알파벳을 대문자로 변환
    2.

brainstorming
    1.toUppercase()

*/
class Solution043 {
    public static void main(String[] args) {
        Solution043 prbs = new Solution043();
        String answer = prbs.solution("abcd");
        System.out.println(answer);
    }

    public String solution(String myString) {
        String answer = "";
        answer = myString.toUpperCase();
        return answer;
    }
}

/*

    정답1
class Solution {
    public String solution(String myString) {
        String answer = "";
        answer = myString.toUpperCase();
        return answer;
    }
}

 */



// level0 :
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution044 {
    public static void main(String[] args) {
        Solution044 prbs = new Solution044();
    }

    public void solution(int slice, int n) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.print(a+b);

    }
}

/*

    정답1
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.print(a+b);
    }
}

 */



// level0 : n의 배수
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution045 {
    public static void main(String[] args) {
        Solution045 prbs = new Solution045();
        int answer = prbs.solution(0, 1);
        System.out.println(answer);
    }

    public int solution(int num, int n) {
        int answer = 0;
        if(num % n == 0){
            answer = 1;
        }else{
            answer = 0;
        }
        return answer;
    }
}

/*

    정답1
class Solution {
    public int solution(int num, int n) {
        int answer = 0;
        if(num % n == 0){
            answer = 1;
        }else{
            answer = 0;
        }
        return answer;
    }
}

 */



// level0 : 정수 찾기
/*
조건
    1.num_list 안에 n이 있는 지 없는 지 찾는 문제
    2.

brainstorming
    1.브루트포스 필요
    2.

*/
class Solution046 {
    public static void main(String[] args) {
        Solution046 prbs = new Solution046();
        int[] num_list = new int[]{1, 2, 3, 4, 5};
        int answer = prbs.solution(num_list, 3);
        System.out.println(answer);
    }

    public int solution(int[] num_list, int n) {
        int answer = 0;

        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] == n) {
                answer = 1;
                return answer;
            } else {
                answer = 0;
            }
        }
        return answer;
    }
}

/*

    정답1
class Solution {
    public int solution(int[] num_list, int n) {
        int answer = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] == n) {
                answer = 1;
                return answer;
            } else {
                answer = 0;
            }
        }
        return answer;
    }
}

 */



// level0 : n의 배수 고르기
/*
조건
    1.numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return
    2.

brainstorming
    1.전체 수를 다 체크해야하니 브루트포스
    2.배열 삭제가 안되므로 새 배열에 담아야할 듯

*/
class Solution047 {
    public static void main(String[] args) {
        Solution047 prbs = new Solution047();
        int[] arr = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] answer = prbs.solution(3, arr);
        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(int n, int[] numlist) {
        List<Integer> newArr = new ArrayList<>();
        // 1.n의 배수 아닌 것 제거(n의 배수만 newArr에 담기)
        for(int i = 0; i < numlist.length; i++){
            if(numlist[i] % n == 0)
                newArr.add(numlist[i]);
        }

        // 2.n의배수가 담긴 List를 array로 변환
        int[] answer = new int[newArr.size()];
        for(int j = 0; j < newArr.size(); j++)
            answer[j] = newArr.get(j);
        System.out.println(Arrays.toString(String.valueOf(answer[0]).toCharArray()));
        return answer;
    }
}

/*

    정답1

import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> newArr = new ArrayList<>();
        // 1.n의 배수 아닌 것 제거(n의 배수만 newArr에 담기)
        for(int i = 0; i < numlist.length; i++){
            if(numlist[i] % n == 0)
                newArr.add(numlist[i]);
        }

        // 2.n의배수가 담긴 List를 array로 변환
        int[] answer = new int[newArr.size()];
        for(int j = 0; j < newArr.size(); j++)
            answer[j] = newArr.get(j);
        return answer;
    }
}

 */



// level0 : flag에 따라 다른 값 반환하기
/*
조건
    1.flag가  true면 a + b
    2.flag가 false면 a - b

brainstorming
    1.flow controll
    2.
    
*/
class Solution048 {
    public static void main(String[] args) {
        Solution048 prbs = new Solution048();
        int answer = prbs.solution(-4, 7, true);
        System.out.println(answer);
    }

    public int solution(int a, int b, boolean flag) {
        int answer = 0;
        if(flag){
            answer = a + b;
        }else{
            answer = a - b;
        }

        return answer;
    }
}

/*

    정답1
class Solution {
    public int solution(int a, int b, boolean flag) {
        int answer = 0;
        if(flag){
            answer = a + b;
        }else{
            answer = a - b;
        }

        return answer;
    }
}

 */



// level0 : 공 던지기
/*
조건
    1.공은 1번부터 시작
    2.오른쪽으로 한 명을 건너뛰고 그다음 사람에게만 던질 수 있음

brainstorming
    1.(끝이 홀수로 끝나는 경우) 첫바퀴는 홀수만 가능하나, 두바퀴 째 짝수로 변함
    2.(끝이 짝수로 끝나는 경우) 홀수만 가능
    3.numbers가 얼마나 될지 모름
    4.numbers 1-6의 길이가 k 홀수보다 크면 처음으로 돌아가게하고 그보다 짧다면 그냥 인덱스번호 추출하기

5까지 k3 = 1 3 5
7까지 k4 = 1 3 5 7
9까지 k5 = 1 3 5 7 9
(numbers.length / 2) >= k : 인덱스로 추출
(numbers.length / 2) <= k : 두바퀴째로 돌아가서 새로 계산

*/
class Solution049 {
    public static void main(String[] args) {
        Solution049 prbs = new Solution049();
        int[] arr = {1,2,3,4,5,6};
        int answer = prbs.solution(arr, 5);
        System.out.println(answer);
    }

    public int solution(int[] numbers, int k) {
        int answer = 0;
        int pointer = 1;

        // 끝수가 홀수
        // 끝수가 짝수
        if((numbers.length % 2) == 0){
            System.out.println("짝수");
            for(int i = 1; i <= k; i++){ // k만큼 반복
//                if(numbers)


            }
        }else{
            System.out.println("홀수");
        }

        return answer;
    }
}

/*

    정답1


 */


// level0 : 대문자와 소문자
/*
조건
    1.각 글자마다 변환 -> 브루투포스
    2.

brainstorming
    1.한 글자씩 전부 체크해야하므로 브루투포스
    2.StringBuilder 사용?
    3.해당 글자가 대문자인지 소문자인지 판단 어떻게?
        if a.equals(a.toUpperCase())


*/
class Solution050 {
    public static void main(String[] args) {
        Solution050 prbs = new Solution050();
        String answer = prbs.solution("abCdEfghIJ");
        System.out.println(answer);
    }

    public String solution(String my_string) {
        String answer = "";
        for(int i = 0; i < my_string.length(); i++){
            if(String.valueOf(my_string.charAt(i)).equals(String.valueOf(my_string.charAt(i)).toUpperCase())){
                answer += String.valueOf(my_string.charAt(i)).toLowerCase();
            }else{
                answer += String.valueOf(my_string.charAt(i)).toUpperCase();
            }
        }
        return answer;
    }
}

/*

    정답1


 */



// level0 : 개미 군단
/*
조건
    1.적은 병력 수 : 우선순위 5 -> 3 -> 1
    2.

brainstorming
    1.5로 먼저 나누고 나머지를 3 그 다음 나머지를 1로
    2.


*/
class Solution051 {
    public static void main(String[] args) {
        Solution051 prbs = new Solution051();
        int answer = prbs.solution(23);
        System.out.println(answer);
    }

    public int solution(int hp) {
        int answer = 0;

        int generalAnt = hp / 5;
        hp = hp - (generalAnt * 5);

        int soldierAnt = hp / 3;
        hp = hp - (soldierAnt * 3);

        int ergate = hp / 1;

        answer = generalAnt + soldierAnt + ergate;
        return answer;

        // 한줄 코드
        // return hp / 5 + (hp % 5 / 3) + hp % 5 % 3;
    }
}

/*

    정답1
class Solution {
    public int solution(int hp) {
        int answer = 0;

        int generalAnt = hp / 5;
        hp = hp - (generalAnt * 5);

        int soldierAnt = hp / 3;
        hp = hp - (soldierAnt * 3);

        int ergate = hp / 1;

        answer = generalAnt + soldierAnt + ergate;
        return answer;
    }
}

    정답2
    return hp / 5 + (hp % 5 / 3) + hp % 5 % 3;
 */



// level0 : 가위 바위 보
/*
조건
    1.가바보 이기는 수 반환
    2. 2면 0
        0이면 5
        5면 2를 반환

brainstorming
    1.atChat()로 하나씩 읽어들이기
    2.toCharArray()

*/
class Solution052 {
    public static void main(String[] args) {
        Solution052 prbs = new Solution052();
        String answer = prbs.solution("abCdEfghIJ");
        System.out.println(answer);
    }

    public String solution(String rsp) {
        String answer = "";
        for(char c : rsp.toCharArray()){
            if(c == '2'){
                answer += "0";
            }else if(c == '0'){
                answer += "5";
            }else if(c == '5'){
                answer += "2";
            }
        }
        return answer;
    }
}

/*

    정답1
class Solution {
    public String solution(String rsp) {
            String answer = "";
            for(char c : rsp.toCharArray()){
                if(c == '2'){
                    answer += "0";
                }else if(c == '0'){
                    answer += "5";
                }else if(c == '5'){
                    answer += "2";
                }
            }
            return answer;
        }
}
    정답2
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String rsp) {
        return Arrays.stream(rsp.split(""))
            .map(s -> s.equals("2") ? "0" : s.equals("0") ? "5" : "2")
            .collect(Collectors.joining());
    }
}
 */



// level0 : 암호 해독
/*
조건
    1. n의배수만 꺼내 return
    2. zerobase index X : 1부터 시작

brainstorming
    1.toCharArray()
    2.

*/
class Solution053 {
    public static void main(String[] args) {
        Solution053 prbs = new Solution053();
        String answer = prbs.solution("dfjardstddetckdaccccdegk",4); // dfjardstddetckdaccccdegk
        System.out.println(answer);
    }

    public String solution(String cipher, int code) {
        // 정답1 : ArrayList + StringBuilder()
//            StringBuilder answer = new StringBuilder();
//
//            ArrayList<String> aList = new ArrayList<>();
//            for(int i = 0; i < cipher.length(); i++){
//                aList.add(String.valueOf(cipher.charAt(i)));
//            }
//            for(int i = 1; i <= aList.size(); i++){
//                if(i % code == 0){
//                    answer.append(aList.get(i-1));
//                }
//            }
//            return answer.toString();

        // 정답2 : IntStream.range() + filter() + mapToObj()
        return IntStream.range(0, cipher.length())
                .filter(index -> (index + 1) % code == 0)  // 인덱스 조정: 1을 더해 code의 배수를 맞춤
                .mapToObj(index -> String.valueOf(cipher.charAt(index)))
                .collect(Collectors.joining());
    }
}

/*

import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String cipher, int code) {
    // 정답1 : ArrayList + StringBuilder()
    StringBuilder answer = new StringBuilder();

    ArrayList<String> aList = new ArrayList<>();
    for(int i = 0; i < cipher.length(); i++){
        aList.add(String.valueOf(cipher.charAt(i)));
    }
    for(int i = 1; i <= aList.size(); i++){
        if(i % code == 0){
            answer.append(aList.get(i-1));
        }
    }
    return answer.toString();

    // 정답2 : IntStream.range() + filter() + mapToObj()
    return IntStream.range(0, cipher.length())
        .filter(index -> (index + 1) % code == 0)  // 인덱스 조정: 1을 더해 code의 배수를 맞춤
        .mapToObj(index -> String.valueOf(cipher.charAt(index)))
        .collect(Collectors.joining());
    }
}
 */



// level0 :
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution054 {
    public static void main(String[] args) {
        Solution054 prbs = new Solution054();
        String answer = prbs.solution("abCdEfghIJ");
        System.out.println(answer);
    }

    public String solution(String my_string) {
        String answer = "";


        return answer;
    }
}

/*

    정답1


 */



// level0 :
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution055 {
    public static void main(String[] args) {
        Solution055 prbs = new Solution055();
        String answer = prbs.solution("abCdEfghIJ");
        System.out.println(answer);
    }

    public String solution(String my_string) {
        String answer = "";


        return answer;
    }
}

/*

    정답1


 */




// level0 :
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution056 {
    public static void main(String[] args) {
        Solution056 prbs = new Solution056();
        String answer = prbs.solution("abCdEfghIJ");
        System.out.println(answer);
    }

    public String solution(String my_string) {
        String answer = "";


        return answer;
    }
}

/*

    정답1


 */




// level0 :
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution057 {
    public static void main(String[] args) {
        Solution057 prbs = new Solution057();
        String answer = prbs.solution("abCdEfghIJ");
        System.out.println(answer);
    }

    public String solution(String my_string) {
        String answer = "";


        return answer;
    }
}

/*

    정답1


 */




// level0 :
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution058 {
    public static void main(String[] args) {
        Solution058 prbs = new Solution058();
        String answer = prbs.solution("abCdEfghIJ");
        System.out.println(answer);
    }

    public String solution(String my_string) {
        String answer = "";


        return answer;
    }
}

/*

    정답1


 */




// level0 :
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution059 {
    public static void main(String[] args) {
        Solution059 prbs = new Solution059();
        String answer = prbs.solution("abCdEfghIJ");
        System.out.println(answer);
    }

    public String solution(String my_string) {
        String answer = "";


        return answer;
    }
}

/*

    정답1


 */




// level0 :
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution060 {
    public static void main(String[] args) {
        Solution060 prbs = new Solution060();
        String answer = prbs.solution("abCdEfghIJ");
        System.out.println(answer);
    }

    public String solution(String my_string) {
        String answer = "";


        return answer;
    }
}

/*

    정답1


 */















public class Level0_031_060 {
}



// Unsolved

// level0 031 :
//class SolutionUnsol31 {
//    public static void main(String[] args) {
//        SolutionUnsol31 prbs = new SolutionUnsol31();
//        int[] arr = {1, 1, 2, 3, 4, 5};
//        int answer = prbs.solution(arr, 1);
//        System.out.println(answer);
//    }
//
//    public int solution(int[] array, int n) {
//        int answer = 0;
//        return answer;
//    }
//}
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/

/*

    정답1


 */



/*
못 푼 문제(다시풀어보기)
    1.피자 나눠 먹기 (3)


 */

