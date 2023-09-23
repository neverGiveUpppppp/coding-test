package level0;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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



// level0 :
/*
조건
    1.
    2.

brainstorming
    1.
    2.

*/
class Solution032 {
    public static void main(String[] args) {
        Solution032 prbs = new Solution032();
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
class Solution033 {
    public static void main(String[] args) {
        Solution033 prbs = new Solution033();
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
class Solution034 {
    public static void main(String[] args) {
        Solution034 prbs = new Solution034();
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

