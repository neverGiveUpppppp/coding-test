package level0;


import java.util.*;

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
        int answer = prbs.solution(0, 1);
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


// level0 :
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution035 {
    public static void main(String[] args) {
        Solution035 prbs = new Solution035();
        int answer = prbs.solution(0, 1);
        System.out.println(answer);
    }

    public int solution(int slice, int n) {
        int answer = 0;
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
class Solution036 {
    public static void main(String[] args) {
        Solution036 prbs = new Solution036();
        int answer = prbs.solution(0, 1);
        System.out.println(answer);
    }

    public int solution(int slice, int n) {
        int answer = 0;
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
class Solution037 {
    public static void main(String[] args) {
        Solution037 prbs = new Solution037();
        int answer = prbs.solution(0, 1);
        System.out.println(answer);
    }

    public int solution(int slice, int n) {
        int answer = 0;
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
class Solution038 {
    public static void main(String[] args) {
        Solution038 prbs = new Solution038();
        int answer = prbs.solution(0, 1);
        System.out.println(answer);
    }

    public int solution(int slice, int n) {
        int answer = 0;
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
class Solution039 {
    public static void main(String[] args) {
        Solution039 prbs = new Solution039();
        int answer = prbs.solution(0, 1);
        System.out.println(answer);
    }

    public int solution(int slice, int n) {
        int answer = 0;
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
class Solution040 {
    public static void main(String[] args) {
        Solution040 prbs = new Solution040();
        int answer = prbs.solution(0, 1);
        System.out.println(answer);
    }

    public int solution(int slice, int n) {
        int answer = 0;
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
class Solution041 {
    public static void main(String[] args) {
        Solution041 prbs = new Solution041();
        int answer = prbs.solution(0, 1);
        System.out.println(answer);
    }

    public int solution(int slice, int n) {
        int answer = 0;
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
class SolutionUnsol31 {
    public static void main(String[] args) {
        SolutionUnsol31 prbs = new SolutionUnsol31();
        int[] arr = {1, 1, 2, 3, 4, 5};
        int answer = prbs.solution(arr, 1);
        System.out.println(answer);
    }

    public int solution(int[] array, int n) {
        int answer = 0;
        return answer;
    }
}
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

