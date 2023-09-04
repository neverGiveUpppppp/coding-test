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











---- 카테고리 별 도서 판매량 집계하기
/* 
조건
    2022년 1월의 카테고리 별 도서 판매량을 합산하고, 카테고리, 총 판매량 출력
    1)카테고리명을 기준으로 오름차순 정렬
    2)INNER JOIN?
    3)1월의 카테고리
    4)총 판매량 계산
    
brainstorming
    1)카테고리 정렬 : ORDER BY A.CATEGORY
    2)CATREGORY로 그룹지정 : GROUP BY A.CATREGORY
    3)판매일이 22.01월 : HAVING 또는 WHERE + EXTRACT, SUBSTR
        WHERE EXTRACT(YEAR FROM B.SALES_DATE) = 2022
            AND EXTRACT(MONTH FROM B.SALES_DATE) = 01
    4)총 판매량 : SELECT SUM()

*/

-- 1.GROUP BY + JOIN
-- SELECT A.CATEGORY, SUM(B.SALES)
-- FROM BOOK A
--     JOIN BOOK_SALES B ON A.BOOK_ID = B.BOOK_ID
-- GROUP BY A.CATEGORY
-- ORDER BY A.CATEGORY

-- 2.조건 추가 : 22년01월 
-- SELECT A.CATEGORY, SUM(B.SALES)
-- FROM BOOK A
--     JOIN BOOK_SALES B ON A.BOOK_ID = B.BOOK_ID
-- GROUP BY A.CATEGORY
-- -- HAVING SUBSTR(B.SALES_DATE,7) = 2022-01 
-- ORDER BY A.CATEGORY
--      GROUP안에 SALES_DATE가 안들어가 안됨. 쓸려면 서브쿼리 필요할 듯

-- SELECT A.CATEGORY, SUM(B.SALES)
-- FROM BOOK A
--     JOIN BOOK_SALES B ON A.BOOK_ID = B.BOOK_ID
-- GROUP BY A.CATEGORY
-- -- HAVING SUBSTR(B.SALES_DATE,7) = 2022-01 
-- WHERE SUBSTR(B.SALES_DATE,1,7) = '2022-01'
-- ORDER BY A.CATEGORY
--      GROUP안에 SALES_DATE가 안들어가 안됨. 쓸려면 서브쿼리 필요할 듯

-- SELECT A.CATEGORY, B.SALES_DATE, SUBSTR(B.SALES_DATE,0,20),
--         TO_CHAR(EXTRACT(YEAR FROM B.SALES_DATE))  , EXTRACT(MONTH FROM B.SALES_DATE),
--         CAST(B.SALES_DATE AS TIMESTAMP) -- 22.01 조건 CAST()도 해보고 EXTRACT도 이것저것 해보면서 값 조히ㅗ하면서 값 확인
-- FROM BOOK A
--     JOIN BOOK_SALES B ON A.BOOK_ID = B.BOOK_ID
-- -- HAVING SUBSTR(B.SALES_DATE,7) = 2022-01 -- GROUP안에 SALES_DATE가 안들어가 안됨. 쓸려면 서브쿼리 필요할 듯
-- -- WHERE SUBSTR(B.SALES_DATE,1,7) = '2022-01'
-- WHERE EXTRACT(YEAR FROM B.SALES_DATE) = 2022
--     AND EXTRACT(MONTH FROM B.SALES_DATE) = 01
-- ORDER BY A.CATEGORY

-- 22년 01월 조건 발견
-- SELECT A.CATEGORY, B.SALES_DATE
-- FROM BOOK A
--     JOIN BOOK_SALES B ON A.BOOK_ID = B.BOOK_ID
-- WHERE EXTRACT(YEAR FROM B.SALES_DATE) = '2022'
--     AND EXTRACT(MONTH FROM B.SALES_DATE) = '01'
-- ORDER BY A.CATEGORY


-- 3.두 쿼리 합체 : GROUP + WHERE EXTRACT
-- SELECT A.CATEGORY, SUM(B.SALES)
-- FROM BOOK A
--     JOIN BOOK_SALES B ON A.BOOK_ID = B.BOOK_ID
-- GROUP BY A.CATEGORY
-- WHERE EXTRACT(YEAR FROM B.SALES_DATE) = '2022' 
--     AND EXTRACT(MONTH FROM B.SALES_DATE) = '01'
-- ORDER BY A.CATEGORY
-- --  WHERE문에서 에러발생 : ORA-00933: SQL command not properly ended
-- --  GROUP BY와 WHERE문 순서가 뒤바껴서 발생

-- SELECT A.CATEGORY, SUM(B.SALES)
-- FROM BOOK A
--     JOIN BOOK_SALES B ON A.BOOK_ID = B.BOOK_ID
-- WHERE EXTRACT(YEAR FROM B.SALES_DATE) = '2022'
--     AND EXTRACT(MONTH FROM B.SALES_DATE) = '01'
-- GROUP BY A.CATEGORY
-- ORDER BY A.CATEGORY



-- 정답1 : WHERE + EXTRACT(YEAR) + AND EXTRACT(MONTH) 
-- SELECT A.CATEGORY, SUM(B.SALES) AS TOTAL_SALES
-- FROM BOOK A
--     JOIN BOOK_SALES B ON A.BOOK_ID = B.BOOK_ID
-- WHERE EXTRACT(YEAR FROM B.SALES_DATE) = '2022'
--     AND EXTRACT(MONTH FROM B.SALES_DATE) = '01'
-- GROUP BY A.CATEGORY
-- ORDER BY A.CATEGORY

-- 정답2 : WHERE + LIKE '2022-01%'(MySQL only)
-- SELECT A.CATEGORY, SUM(B.SALES) AS TOTAL_SALES
-- FROM BOOK A
--     JOIN BOOK_SALES B ON A.BOOK_ID = B.BOOK_ID
-- WHERE B.SALES_DATE LIKE '2022-01%'
-- GROUP BY A.CATEGORY
-- ORDER BY A.CATEGORY

-- 정답3 : 오라클조인구문 + TO_CHAR()
SELECT B.CATEGORY, SUM(A.SALES)
FROM BOOK_SALES A, BOOK B
WHERE A.BOOK_ID = B.BOOK_ID -- 오라클 조인구문
    AND TO_CHAR(SALES_DATE, 'MM') = '01'
GROUP BY B.CATEGORY
ORDER BY B.CATEGORY








---- 조건별로 분류하여 주문상태 출력하기
/* 
조건
    5월 1일을 기준으로 주문 ID, 제품 ID, 출고일자, 출고여부를 조회
    1)출고여부는 5월 1일까지 출고완료로 이 후 날짜는 출고 대기로 미정이면 출고미정으로 출력
    2)주문 ID를 기준으로 오름차순 정렬
    
brainstorming
    1)5월 1일 조건 : OUT_DATE > '2022-05-01'
    2)TO_DATE()로 기준이 되는 '2022-05-01'를 DATE타입으로 바꿔서 
      OUT_DATE의 데이터타입과 맞추고 날짜 대소비교를 가능케함 
    
*/


-- SELECT ORDER_ID, PRODUCT_ID, OUT_DATE,
--     OUT_DATE
--     AS 출고여부
-- FROM FOOD_ORDER 
-- ORDER BY ORDER_ID

-- 1.5월 1일 조건 : OUT_DATE > '2022-05-01' 적용
-- SELECT ORDER_ID, PRODUCT_ID, OUT_DATE,
--     CASE WHEN OUT_DATE > '2022-05-01'  THEN '출고x' -- ORA-00923: FROM keyword not found where expected
--     -- OUT_DATE
--         WHEN OUT_DATE < '2022-05-01' THEN '출고O'
--         END AS '출고여부'
-- FROM FOOD_ORDER 
-- ORDER BY ORDER_ID


-- SELECT ORDER_ID, PRODUCT_ID, OUT_DATE,
--     CASE WHEN OUT_DATE <= '2022-05-01' THEN '출고완료' -- ORA-01861: 
--          WHEN OUT_DATE > '2022-05-01' THEN '출고대기' 
--          ELSE '출고미정'
--     END AS 출고여부
-- FROM FOOD_ORDER 
-- ORDER BY ORDER_ID
--      ORA-01861: literal does not match format string
--      2022-05-01가 '' 때문에 literal이라 비교 불가해서 에러 발생

-- '' 지우고 리터럴 해제하면?
-- SELECT ORDER_ID, PRODUCT_ID, OUT_DATE,
--     CASE WHEN OUT_DATE <= 2022-05-01 THEN '출고완료' -- ORA-00932: 
--          WHEN OUT_DATE > 2022-05-01 THEN '출고대기'
--          ELSE '출고미정'
--     END AS 출고여부
-- FROM FOOD_ORDER 
-- ORDER BY ORDER_ID
--      ORA-00932: inconsistent datatypes: expected DATE got NUMBER
--      데이터 타입 안맞아서 오류? 파싱 필요


-- 2. TO_DATE 사용
-- SELECT ORDER_ID, PRODUCT_ID, OUT_DATE,
--     CASE WHEN OUT_DATE <= TO_DATE('2022-05-01', 'YYYY-MM-DD') THEN '출고완료'
--          WHEN OUT_DATE > TO_DATE('2022-05-01', 'YYYY-MM-DD') THEN '출고대기'
--          ELSE '출고미정'
--     END AS 출고여부
-- FROM FOOD_ORDER 
-- ORDER BY ORDER_ID
-- -- OUT_DATE 출력 양식이 DAY까지만 나와야하는데 시간까지 나와서 틀린 듯

-- 3. SELECT에 TO_CHAR() 적용
-- SELECT ORDER_ID, PRODUCT_ID, TO_CHAR(OUT_DATE,'YYYY-MM-DD'),
--     CASE WHEN OUT_DATE <= TO_DATE('2022-05-01', 'YYYY-MM-DD') THEN '출고완료'
--          WHEN OUT_DATE > TO_DATE('2022-05-01', 'YYYY-MM-DD') THEN '출고대기'
--          ELSE '출고미정'
--     END AS 출고여부
-- FROM FOOD_ORDER 
-- ORDER BY ORDER_ID



-- 정답1 : CASE + TO_CHAR(), TO_DATE()
SELECT ORDER_ID, PRODUCT_ID, TO_CHAR(OUT_DATE,'YYYY-MM-DD') AS OUT_DATE,
    CASE WHEN OUT_DATE <= TO_DATE('2022-05-01', 'YYYY-MM-DD') THEN '출고완료'
         WHEN OUT_DATE > TO_DATE('2022-05-01', 'YYYY-MM-DD') THEN '출고대기'
         ELSE '출고미정'
    END AS 출고여부
FROM FOOD_ORDER 
ORDER BY ORDER_ID

-- 정답2 :












---- 조건에 맞는 사용자와 총 거래금액 조회하기
/* 
조건
     완료된 중고 거래의 총금액이 70만 원 이상인 사람의 회원 ID, 닉네임, 총거래금액을 조회
    1)완료된 중고 거래
    2)총금액이 70만원이상
    3)총거래금액을 기준으로 오름차순 정렬
    
brainstorming
    1)완료된 중고 거래 : WHERE 또는 HAVING A.STATUS = DONE
    2)총금액이 70만 원 이상 : TOTAL_SALES 
    3)A.WRITE_ID와 B.USER_ID를 JOIN하고 GROUP BY로 이를 묶음
    

*/


-- 1.완료된 중고 거래 : WHERE 또는 HAVING A.STATUS = DONE
-- SELECT B.USER_ID, B.NICKNAME, A.STATUS, A.PRICE--, TOTAL_SALES
-- FROM USED_GOODS_BOARD A
--     JOIN USED_GOODS_USER B ON A.WRITER_ID = B.USER_ID
-- WHERE A.STATUS = 'DONE'
-- -- 그룹바이로 이제 WRITER_ID를 합쳐야 아이디별 총액을 구할 수 있을 듯?


-- 2.총금액이 70만원이상 : GROUP BY A.WRITER_ID
-- SELECT WRITER_ID, A.PRICE, A.STATUS, SUM(A.PRICE) AS TOTAL_SALES--, B.NICKNAME--, TOTAL_SALES
-- FROM USED_GOODS_BOARD A
-- GROUP BY A.WRITER_ID, A.PRICE, A.STATUS
-- HAVING A.STATUS = 'DONE'
-- ORDER BY A.WRITER_ID

-- SELECT WRITER_ID, SUM(A.PRICE) AS TOTAL_SALES--, B.NICKNAME--, TOTAL_SALES
-- FROM USED_GOODS_BOARD A
-- WHERE A.STATUS = 'DONE'
-- GROUP BY A.WRITER_ID
-- -- HAVING A.STATUS = 'DONE' -- HAVING은 그룹바이를 가지고 조건을 추리기 때문에 안됨
-- -- -- GROUP BY에 STATUS가 끼면 PRICE가 나뉠 수 밖에 없기 때문에 GROUP 이전에 WHERE로 조건을 줘야함
-- ORDER BY A.WRITER_ID


-- 3.둘 합치기
-- SELECT WRITER_ID, B.NICKNAME, SUM(A.PRICE) AS TOTAL_SALES  -- 에러발생
-- FROM USED_GOODS_BOARD A
--     JOIN USED_GOODS_USER B ON A.WRITER_ID = B.USER_ID
-- WHERE A.STATUS = 'DONE'
-- GROUP BY A.WRITER_ID
-- ORDER BY TOTAL_SALES
-- -- B.NICKNAME이 GROUP에 없어서 에러 -> 서브쿼리?

-- SELECT USER_ID, C.NICKNAME, TOTAL_SALES 
-- FROM (
--     SELECT WRITER_ID, SUM(A.PRICE) AS TOTAL_SALES 
--     FROM USED_GOODS_BOARD A
--     WHERE A.STATUS = 'DONE'
--     GROUP BY A.WRITER_ID
--     ) B
--         JOIN USED_GOODS_USER C ON B.WRITER_ID = C.USER_ID
-- ORDER BY TOTAL_SALES


-- 4.총액 70만원 이상 조건 적용
-- SELECT USER_ID, C.NICKNAME, TOTAL_SALES 
-- FROM (
--     SELECT WRITER_ID, SUM(A.PRICE) AS TOTAL_SALES 
--     FROM USED_GOODS_BOARD A
--     WHERE A.STATUS = 'DONE'
--     GROUP BY A.WRITER_ID
--     ) B
--         JOIN USED_GOODS_USER C ON B.WRITER_ID = C.USER_ID
-- WHERE TOTAL_SALES >= 700000
-- ORDER BY TOTAL_SALES


-- 정답1 : GROUP BY + JOIN + SUBQUERY
SELECT USER_ID, C.NICKNAME, TOTAL_SALES 
FROM (
    SELECT WRITER_ID, SUM(A.PRICE) AS TOTAL_SALES 
    FROM USED_GOODS_BOARD A
    WHERE A.STATUS = 'DONE'
    GROUP BY A.WRITER_ID
    ) B
        JOIN USED_GOODS_USER C ON B.WRITER_ID = C.USER_ID
WHERE TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES

-- 정답2 : GROUP BY + HAVING + JOIN(오라클구문)
SELECT A.WRITER_ID, B.NICKNAME, SUM(A.PRICE) AS TOTAL_SALES
FROM USED_GOODS_BOARD A, USED_GOODS_USER B
WHERE A.WRITER_ID = B.USER_ID
    AND A.STATUS = 'DONE'
-- AND TOTAL_SALES >= 700000 SELECT에서 AS TOTAL_SALES가 지정되기 때문에 동작x
GROUP BY A.WRITER_ID, B.NICKNAME
HAVING SUM(A.PRICE) >= 700000
ORDER BY TOTAL_SALES








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





