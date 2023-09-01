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









---- 있었는데요 없었습니다
/* 
조건
   관리자의 실수로 일부 동물의 입양일이 잘못 입력됨
   보호 시작일보다 입양일이 더 빠른 동물의 아이디와 이름을 조회
    (결과는 보호 시작일이 빠른 순으로 조회)
    1)보호 시작일보다 입양일이 더 빠른 : A.DATETIME > B.DATETIME
    2)보호 시작일이 빠른 순 조회 : ORDER BY DATETIME ASC
    
brainstorming
    1)
    2)

*/


-- 1.보호 시작일(A.DATETIME) ASC 정렬 + JOIN
-- SELECT A.ANIMAL_ID, A.NAME, A.DATETIME
-- FROM ANIMAL_INS A
--     JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- ORDER BY A.DATETIME ASC

-- DATETIME 확인용 
-- SELECT A.ANIMAL_ID, A.NAME, A.DATETIME
-- FROM ANIMAL_INS A
--     JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- WHERE A.DATETIME < B.DATETIME
-- ORDER BY A.DATETIME ASC

-- 2.보호 시작일보다 입양일이 더 빠른 : A.DATETIME > B.DATETIME 적용
-- SELECT A.ANIMAL_ID, A.NAME
-- FROM ANIMAL_INS A
--     JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- WHERE A.DATETIME > B.DATETIME
-- ORDER BY A.DATETIME ASC


-- 정답1 : WHERE + >로 날짜 비교
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_INS A
    JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.DATETIME > B.DATETIME
ORDER BY A.DATETIME ASC

-- 정답2 :









---- 오랜 기간 보호한 동물(2)
/* 
조건
    입양을 간 동물 중, 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름을 조회
    1)보호 기간이 긴 순으로 조회 : ORDER BY DATETIME 
    2)입양을 간 동물 중, 보호 기간
    3)보호 기간 가장 길었던 
    4)가장 길었던 동물 두 마리
    
brainstorming
    1)입양 간 동물 중 보호기간 : RIGHT JOIN 사용(ANIMAL_OUTS쪽)
    2)가장 길었던 동물 두 마리 : FETCH FIRST 2 ROWS ONLY
    3)보호 기간이 가장 길다 : 입양 간 날 - 보호 시작일수가 가장 많은 
        두 날짜를 뺀 수를 DAY로 계산?
        EXTRACT(YEAR FROM A.DATETME) <- EXTRACT로 꺼낸 숫자의 타입이 뭐지?
        (YEAR * 365) + DAY 해서 이중 가장 큰 수 2개 뽑기
    
    Q. ORACLE에서 DATETIME 타입끼리 +,- 하면 어떻게 될까?
    A. +.-연산 가능! DAY기준으로 연산 결과가 나옴
    
    풀이시간 : 총35분 (노션 자료 참고)

*/

-- SELECT B.ANIMAL_ID, B.NAME, A.DATETIME
-- FROM ANIMAL_INS A
--     RIGHT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- ORDER BY A.DATETIME


-- 1.입양 간 동물 중 보호기간 : RIGHT JOIN 적용
-- SELECT B.ANIMAL_ID, B.NAME
-- FROM ANIMAL_INS A
--     RIGHT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- ORDER BY A.DATETIME

-- 2.가장 길었던 동물 두 마리 : FETCH FIRST 2 ROWS ONLY
-- SELECT B.ANIMAL_ID, B.NAME
-- FROM ANIMAL_INS A
--     RIGHT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- ORDER BY A.DATETIME 
-- FETCH FIRST 2 ROWS ONLY
--      보호 일수가 가장 긴 동물이여야함. 지금은 단순히 날짜 정렬임

-- 보호 일수 계산 try
-- SELECT B.ANIMAL_ID, B.NAME, A.DATETIME, B.DATETIME,
--     -- EXTRACT (YEAR FROM A.DATETIME),
--     -- EXTRACT (DAY FROM A.DATETIME)
--         -- EXTRACT (YEAR FROM A.DATETIME) - EXTRACT (YEAR FROM B.DATETIME),
--         B.DATETIME - A.DATETIME AS CAL
     
-- FROM ANIMAL_INS A
--     RIGHT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- -- WHERE CAL > 365
-- ORDER BY A.DATETIME
-- -- FETCH FIRST 2 ROWS ONLY

-- 3.보호 기간 가장 긴 적용 : B.DATETIME - A.DATETIME 적용 및 서브쿼리
-- SELECT ANIMAL_ID, NAME, CAL
-- FROM (
--     SELECT B.ANIMAL_ID, B.NAME, A.DATETIME, B.DATETIME,
--             B.DATETIME - A.DATETIME AS CAL
--     FROM ANIMAL_INS A
--         RIGHT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID 
-- ) 
-- ORDER BY DATETIME
-- FETCH FIRST 2 ROWS ONLY


-- 4.보호일수가 NULL값인 것을 제외 : NVL 적용 + 확인용 CAL 및 날짜 제거
-- SELECT ANIMAL_ID, NAME--, CAL
-- FROM (
--     SELECT B.ANIMAL_ID, B.NAME, 
--             NVL(B.DATETIME - A.DATETIME,0) AS CAL
--     FROM ANIMAL_INS A
--         RIGHT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID 
-- )
-- ORDER BY CAL DESC
-- FETCH FIRST 2 ROWS ONLY


-- 정답1 : RIGHT JOIN + SUBQUERY + NVL + FETCH FIRST 2 ROWS ONLY
SELECT ANIMAL_ID, NAME
FROM (
    SELECT B.ANIMAL_ID, B.NAME, 
            NVL(B.DATETIME - A.DATETIME,0) AS CAL
    FROM ANIMAL_INS A
        RIGHT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID 
)
ORDER BY CAL DESC
FETCH FIRST 2 ROWS ONLY


-- 정답2 :



















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





