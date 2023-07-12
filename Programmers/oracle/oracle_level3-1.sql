/*
프로그래머스
SQL ORACLE leve3-1

풀이 순서, 정답률 높은 순

*/




---- 오랜 기간 보호한 동물(1)
/* 
조건
    입양을 못 간 동물 중, 가장 오래 보호소에 있었던 동물 3마리 조회
    1)동물 이름과 보호 시작일 조회
    2)정렬 : 보호 시작일
    
brainstorming
    ANIMAL_INS : 보호소에 들어온 동물 정보(들어왔을 당시)
    ANIMAL_OUTS : 입양 보낸 동물 정보(나갔을 당시)
    가장 오래 보호소에 있었던 동물 = 들어와서 못나간 동물(남아있는)
    1)현재시간 - 보호입양일 = 가장 큰 ROW 3개 
        ROWNUM
        RANK() OVER
    2)입양을 못 간 동물 : 
        입양 관련 컬럼이 따로 없다면, 
        두 테이블 중 OUTS는 나간거니까 OUTS를 제외한 INS것만 조인하면 됨
        (일반 INNER JOIN이 아닌 LEFT,RIGHT JOIN )
            LEFT만하면 OUTS와 INS의 교집합도 여전히 나오니까 입양도 나옴
            LEFT JOIN - OUTS테이블
             시도1) MINUS
             시도2) LEFT JOIN + WHERE B.KEY IS NULL
*/


-- SELECT A.NAME, A.DATETIME
-- FROM ANIMAL_INS A 
--     JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- ORDER BY A.DATETIME


-- 1.현재시간 - 보호입양일 = 체류일자
-- SELECT A.NAME, A.DATETIME, 
--     SYSDATE - A.DATETIME,   -- 일수 차
-- FROM ANIMAL_INS A 
--     JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- ORDER BY A.DATETIME


-- 2.상위 3마리
-- SELECT A.NAME, A.DATETIME, 
--     SYSDATE - A.DATETIME,   -- 일수 차
--     RANK() OVER(ORDER BY SYSDATE - A.DATETIME DESC) -- 상위 3마리
-- FROM ANIMAL_INS A 
--     JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- ORDER BY A.DATETIME
-- -- 인라인뷰로 뽑아내면 어떨까?


-- 틀림
-- 뭐가 틀렸을까? 조인 고리? 오더바이? 문제 다시 읽기,
-- SELECT C.NAME, C.DATETIME 
-- FROM (
--     SELECT A.NAME, A.DATETIME, 
--         SYSDATE - A.DATETIME AS STAYDAYS,   -- 일수 차
--         RANK() OVER(ORDER BY SYSDATE - A.DATETIME DESC) AS TOP-- 상위 3마리
--     FROM ANIMAL_INS A 
--         LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- ) C -- 인라인뷰 별칭으로 지정해서 안쓰면 에러 발생
-- WHERE TOP <= 3
-- ORDER BY C.DATETIME


-- SELECT NAME, DATETIME 
-- FROM ANIMAL_INS--ANIMAL_OUTS
-- ORDER BY DATETIME DESC

-- 테이블 A-B의 범위로 입양간 B테이블의 영역을 제외한 A만 뽑는 WHERE B.EKY IS NULL 적용
-- SELECT C.NAME, C.DATETIME 
-- FROM (
--     SELECT A.NAME, A.DATETIME, 
--         RANK() OVER(ORDER BY SYSDATE - A.DATETIME DESC) AS TOP-- 상위 3마리
--     FROM ANIMAL_INS A 
--         LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
--     WHERE B.NAME IS NULL
-- ) C 
-- WHERE TOP <= 3
-- ORDER BY C.DATETIME
-- 틀림 : WHY? RANK() OVER() 빼보자...


-- ROWNUM 적용 
-- ROWNUM이 FROM절에서 깔리니 ROWNUM 전 ORDER BY로 먼저 DATETIME으로 정렬. 이후 외측에서 ROWNUM으로 3순위 추출
-- SELECT C.NAME, C.DATETIME 
-- FROM (
--     SELECT A.NAME, A.DATETIME
--     FROM ANIMAL_INS A 
--         LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
--     ORDER BY A.DATETIME 
-- ) C 
-- WHERE ROWNUM <= 3
-- 틀린 이유 : LEFT만 하고 OUTS와의 교집합 부분을 제거안함


-- 정답1 : 인라인뷰 + LEFT JOIN + B테이블 범위 제거 + ROWNUM
-- SELECT C.NAME, C.DATETIME 
-- FROM (
--     SELECT A.NAME, A.DATETIME
--     FROM ANIMAL_INS A 
--         LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
--     WHERE B.DATETIME IS NULL
--     ORDER BY A.DATETIME 
-- ) C 
-- WHERE ROWNUM <= 3


-- 정답2 : 인라인뷰 + LEFT JOIN + B테이블 범위 제거 + RANK() OVER()
-- SELECT C.NAME, C.DATETIME 
-- FROM (
--     SELECT A.NAME, A.DATETIME,
--         RANK() OVER(ORDER BY SYSDATE - A.DATETIME DESC) AS TOP
--     FROM ANIMAL_INS A 
--         LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
--     WHERE B.DATETIME IS NULL

-- ) C 
-- WHERE TOP <= 3
-- ORDER BY C.DATETIME 


-- 정답3-1 : (ANSI표준) + LEFT JOIN + B테이블 IS NULL + FETCH FIRST 3 ROWS ONLY
SELECT A.NAME, A.DATETIME
FROM ANIMAL_INS A
	LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY A.DATETIME
FETCH FIRST 3 ROWS ONLY;

-- 정답3-2 : (오라클구문) + LEFT JOIN + B테이블 IS NULL + FETCH FIRST 3 ROWS ONLY
--SELECT A.NAME, A.DATETIME 
--FROM ANIMAL_INS A, ANIMAL_OUTS B
--WHERE A.ANIMAL_ID = B.ANIMAL_ID(+) -- 오라클 LEFT구문
--AND B.ANIMAL_ID IS NULL
--ORDER BY A.DATETIME
--FETCH FIRST 3 ROWS ONLY




---- TITLE
/* 
조건
    2022년 10월 5일에 등록된 중고거래 게시물 조회
    1)
    2)
    
brainstorming
    1)
    2)

*/


-- 1.
-- 2.
-- 3.

-- 정답1 : 
-- 정답2 : 




/*
다시 풀어 볼 문제

     1.



*/





