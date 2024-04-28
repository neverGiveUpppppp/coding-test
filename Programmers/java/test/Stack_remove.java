package test;

import java.util.Stack;


/*

입출력 예시 : String s
baabaa
cdcd

같은 알파펫 문자열 2개가 붙어있는 걸 제거하고 또 앞뒤로 이어 붙여서 같다면 제거 반복해
알고리즘 예시
b aa baa -> bb aa ->  aa -> ""

 */
public class Stack_remove {

    public static String removePairs(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();  // 스택의 맨 위의 문자와 현재 문자가 같다면 제거
            } else {
                stack.push(c);  // 다르면 스택에 추가
            }
        }

        // 스택에 남아있는 문자를 문자열로 변환
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input1 = "baabaa";
        String input2 = "cdcd";
        String input3 = "ccdd";

        System.out.println("Result for 'baabaa': " + removePairs(input1));  // 결과: ""
        System.out.println("Result for 'cdcd': " + removePairs(input2));    // 결과: ""
        System.out.println("Result for 'ccdd': " + removePairs(input3));    // 결과: ""
    }

}
