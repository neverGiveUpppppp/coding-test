/*
프로그래머스
SQL ORACLE leve2-2

풀이 순서, 정답률 높은 순

*/



---- 진료과별 총 예약 횟수 출력하기
/* 
조건
    2022년 5월에 예약한 환자 수
    진료과코드 별로 조회
    예약한 환자 수 오름차순 정렬, 예약한 환자 수가 같다면 진료과 코드 오름차순 정렬
    
brainstorming
    2022-05 추출 : 
        방법1)데이터타입 TIMESTAMP. EXTRACT HOUR가능(CAST필요X)
        방법2)SUBSTR(),LEFT()
    GROUP BY로 날짜 묶고 날짜를 COUNT()해서 환자수도 추출
                
Q.SUBSTR,LEFT는 SELECT절 외에 사용가능?

*/
-- SELECT COUNT(YYMM)-- 이상태에서 COUNT(YYMM)또 COUNT(*)도 가능
-- --MCDP_CD AS 진료과코드--, COUNT(YYMM) AS 5월예약건수
-- FROM (
--     SELECT MCDP_CD, APNT_YMD, EXTRACT(HOUR FROM APNT_YMD) AS YYMM
--     FROM APPOINTMENT 
--     )
-- GROUP BY YYMM
-- ORDER BY YYMM
-- -- GROUP BY YYMM, MCDP_CD
-- -- ORDER BY 5월예약건수, MCDP_CD

-- SELECT MCDP_CD AS 진료과코드, COUNT(YYMM) AS "5월예약건수"
-- FROM (
--     SELECT MCDP_CD, APNT_YMD
--             ,EXTRACT(YEAR FROM (CAST(APNT_YMD AS DATE)) AS YY
--             ,EXTRACT(MONTH FROM (CAST(APNT_YMD AS DATE)) AS MM
--     FROM APPOINTMENT 
--     )
-- GROUP BY MCDP_CD
-- ORDER BY "5월예약건수", MCDP_CD
-- ---- 오답 : 22.05 조건빠짐

-- -- 정답1
-- SELECT MCDP_CD AS 진료과코드, COUNT(*) AS "5월예약건수"
-- FROM (
--     SELECT MCDP_CD, APNT_YMD
--             ,EXTRACT(YEAR FROM CAST(APNT_YMD AS DATE)) AS YY
--             ,EXTRACT(MONTH FROM CAST(APNT_YMD AS DATE)) AS MM
--     FROM APPOINTMENT 
--     )
-- WHERE YY = '2022' AND MM = '05'
-- GROUP BY MCDP_CD
-- ORDER BY "5월예약건수", MCDP_CD

/*
where절에 함수,분기조건 사용은 데이터가 증가함에 따라 조건 탐색 증가로 성능 이슈
따라서 성능을 고려한 select의 case절 is better

*/
-- 정답2 : 성능을 고려한 select의 case절
SELECT A.MCDP_CD AS "진료과코드", COUNT(A.MON_CNT) AS "5월예약건수" 
FROM (
    SELECT MCDP_CD, 
        CASE WHEN TO_CHAR(APNT_YMD, 'YYYYMM') = '202205'
        THEN 1 
        ELSE 0 
        END AS MON_CNT
    FROM APPOINTMENT
) A 
WHERE A.MON_CNT = 1
GROUP BY A.MCDP_CD 
ORDER BY 2,1







---- 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
/* 
조건
    '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함된 자동차
    자동차 종류 별로 몇 대
    자동차 종류를 기준으로 오름차순
    
brainstorming
    옵션포함 : IN()
    자동차 종류 별로 몇 대 : COUNT()            
*/

-- SELECT CAR_TYPE, COUNT() 자동차 수 AS CARS
-- FROM CAR_RENTAL_COMPANY_CAR 
-- ORDER BY CAR_TYPE


-- SELECT CAR_TYPE--, COUNT() 자동차 수 AS CARS
-- FROM CAR_RENTAL_COMPANY_CAR 
-- WHERE OPTIONS IN('통풍시트', '열선시트', '가죽시트')
-- -- GROUP BY 
-- ORDER BY CAR_TYPE
-- -- 조회 결과 없음

-- 정답
SELECT CAR_TYPE, COUNT(CAR_TYPE) AS CARS
FROM CAR_RENTAL_COMPANY_CAR 
WHERE OPTIONS LIKE '%통풍시트%' 
   OR OPTIONS LIKE '%열선시트%' 
   OR OPTIONS LIKE '%가죽시트%'
GROUP BY CAR_TYPE
ORDER BY CAR_TYPE



---- 상품 별 오프라인 매출 구하기
/* 
조건
    상품코드 별 매출액(판매가 * 판매량) 합계
    매출액을 기준으로 내림차순 정렬, 매출액이 같다면 상품코드를 기준

    
brainstorming
    1)B.제품별 총 판매량 구하기
        OFFLINE_SALE의 PRODUCT_ID별 SALES_AMOUNT 구하기
    2)B.제품별 총 판매량 * A.가격 = 판매가
    
    OFFLINE_SALE의 PRODUCT_ID 별로 GROUP BY로 그루핑
    
*/

-- -- OFFLINE_SALE의 PRODUCT_ID별 SALES_AMOUNT 구하기
-- SELECT PRODUCT_ID, SALES_AMOUNT
-- FROM OFFLINE_SALE 
-- GROUP BY PRODUCT_ID, SALES_AMOUNT
-- ORDER BY PRODUCT_ID

-- SELECT PRODUCT_ID--, SALES_AMOUNT
-- FROM OFFLINE_SALE 
-- GROUP BY PRODUCT_ID--, SALES_AMOUNT
-- ORDER BY PRODUCT_ID

-- SELECT PRODUCT_CODE, SALES
-- FROM PRODUCT A
--     JOIN OFFLINE_SALE B ON A.PRODUCT_ID = B.PRODUCT_ID
-- GROUB B.PRODUCT_ID

-- 전체 컬럼이 어떻게 나오나 체크 -> 감잡기
-- SELECT *
-- FROM PRODUCT A
--     JOIN OFFLINE_SALE B ON A.PRODUCT_ID = B.PRODUCT_ID
    
-- SELECT A.PRODUCT_CODE, SUM(B.SALES_AMOUNT) * A.PRICE AS SALES
-- FROM PRODUCT A
--     JOIN OFFLINE_SALE B ON A.PRODUCT_ID = B.PRODUCT_ID 
-- GROUP BY A.PRODUCT_CODE
-- ORDER BY A.PRODUCT_CODE
----ORA-00979: not a GROUP BY expression



-- -- 정답1
SELECT PRODUCT_CODE, (PRICE * HAP) AS SALES 
FROM (
    SELECT P.PRODUCT_ID, P.PRODUCT_CODE, P.PRICE
          ,SUM(SALES_AMOUNT) AS HAP 
    FROM OFFLINE_SALE O, PRODUCT P -- 오라클 전용 JOIN구문
    WHERE O.PRODUCT_ID = P.PRODUCT_ID -- INNER JOIN
    GROUP BY P.PRODUCT_ID, P.PRODUCT_CODE, P.PRICE
)
ORDER BY SALES DESC, PRODUCT_CODE ASC

-- SELECT P.PRODUCT_ID, P.PRODUCT_CODE, P.PRICE
--           ,SUM(SALES_AMOUNT) AS HAP 
--     FROM OFFLINE_SALE O, PRODUCT P -- 오라클 전용 JOIN구문
--     WHERE O.PRODUCT_ID = P.PRODUCT_ID -- INNER JOIN
--     GROUP BY P.PRODUCT_ID, P.PRODUCT_CODE, P.PRICE
-- -- 정답1의 내부에 있는 인라인뷰 결과 돌려보기

-- 정답2
 SELECT P.PRODUCT_CODE, SUM(P.PRICE * OFFS.SALES_AMOUNT) AS "SALES"
 FROM PRODUCT P, OFFLINE_SALE OFFS
 WHERE P.PRODUCT_ID = OFFS.PRODUCT_ID
 GROUP BY P.PRODUCT_CODE
 ORDER BY 2 DESC, 1 ASC;


-- --정답3
SELECT A.PRODUCT_CODE
       , SUM(A.PRICE * B.SALES_AMOUNT) AS SALES
FROM PRODUCT A
    JOIN OFFLINE_SALE B ON (A.PRODUCT_ID = B.PRODUCT_ID)
GROUP BY B.PRODUCT_ID, A.PRODUCT_CODE -- B.PRODUCT_ID를 빼도 정답. WHY?
-- A.Id는 일련번호 code는 종류라고 생각해보면, 
-- Id보다 code가 더 크기때문에 id 그룹후 code 그룹화 하면 id 그룹화가 의미가 없음
ORDER BY SALES DESC, PRODUCT_CODE ASC

-- -- OVER(PARTITION BY 컬럼) 한번 써보자!
-- -- 결과가 다름. GROUP BY처럼 묶여서 안나오고 같은게 중복되서 나오고 매출액은 잘나옴
-- SELECT A.PRODUCT_CODE
--        , SUM(A.PRICE * B.SALES_AMOUNT) OVER(PARTITION BY B.PRODUCT_ID) AS SALES
-- FROM PRODUCT A
--     JOIN OFFLINE_SALE B ON (A.PRODUCT_ID = B.PRODUCT_ID)
-- ORDER BY SALES DESC, PRODUCT_CODE ASC



---- 루시와 엘라 찾기
/* 
조건
    Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 동물
    아이디와 이름, 성별 및 중성화 여부를 조회
    아이디 순으로 조회

brainstorming
    1)이름 조건 : IN, 
    
*/
-- 정답1 : IN() 사용
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS 
WHERE NAME IN('Lucy','Ella','Pickle','Rogan','Sabrina', 'Mitty')
ORDER BY ANIMAL_ID

-- 정답2 : 정규식 사용
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS 
WHERE REGEXP_LIKE(NAME, '^(Lucy|Ella|Pickle|Rogan|Sabrina|Mitty)$')
ORDER BY ANIMAL_ID







---- 조건에 맞는 도서와 저자 리스트 출력하기
/* 
조건
    경제 카테고리
    도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트 출력
    출판일을 기준으로 오름차순
    PUBLISHED_DATE의 데이트 포맷

brainstorming
    1)경제 카테고리 : CASE, LIKE
    2)JOIN
    3)PUBLISHED_DATE의 데이트 포맷 : TO_CHAR()
*/


-- SELECT A.BOOK_ID, B.AUTHOR_NAME, TO_CHAR(A.PUBLISHED_DATE,'YYYY-MM-DD') AS PUBLISHED_DATE
-- FROM BOOK A
--     JOIN AUTHOR B ON (A.AUTHOR_ID = B.AUTHOR_ID)
-- ORDER BY PUBLISHED_DATE
-- 조건에 따라 하나씩 살 붙이면서, 제대로 조회되는지와 결과 확인해가면서 쿼리짜기


-- 정답1 : LIKE
SELECT A.BOOK_ID, B.AUTHOR_NAME, TO_CHAR(A.PUBLISHED_DATE,'YYYY-MM-DD') AS PUBLISHED_DATE
FROM BOOK A
    JOIN AUTHOR B ON (A.AUTHOR_ID = B.AUTHOR_ID)
WHERE CATEGORY LIKE '%경제%'
--WHERE B.CATEGORY='경제'
ORDER BY PUBLISHED_DATE





---- 성분으로 구분한 아이스크림 총 주문량
/* 
조건
   각 아이스크림 성분 타입과 성분 아이스크림의 총주문량
     sugar_based, fruit_based 두개만 조회
     총주문량 작은 순서대로 조회
     총주문량 별칭 : TOTAL_ORDER
    
brainstorming
    1)TOTAL_ORDER 합계 : SUM()
*/


-- SELECT B.INGREDIENT_TYPE--, TOTAL_ORDER AS TOTAL_ORDER
-- FROM FIRST_HALF A
--     JOIN ICECREAM_INFO  B ON A.FLAVOR = B.FLAVOR
-- GROUP BY B.INGREDIENT_TYPE--, A.TOTAL_ORDER


-- 정답1
SELECT B.INGREDIENT_TYPE, SUM(A.TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF A
    JOIN ICECREAM_INFO  B ON A.FLAVOR = B.FLAVOR
GROUP BY B.INGREDIENT_TYPE








---- 가격대 별 상품 개수 구하기
/* 
조건
    1)만원 가격대 별로 상품 개수 출력
    2)각각 컬럼명은 PRICE_GROUP, PRODUCTS
    3)각 구간의 최소금액(10,000원 이상 ~ 20,000 미만인 구간인 경우 10,000)으로 표시
    4) 가격대 오름차순
    
brainstorming
    1)1만~2만 사이 : between and
    2)각 금액 구간 구분 : case, group by
    3)products 개수 : count
    
    해당 가격대의 PRODUCT_ID를 count()
    
*/


-- SELECT PRICE
-- FROM PRODUCT
-- GROUP BY PRICE

-- BETWEEN AND 체크
-- SELECT * 
-- FROM PRODUCT
-- WHERE PRICE BETWEEN 10000 AND 20000  
--     OR PRICE BETWEEN 20000 AND 30000

--CASE문 실행체크
-- SELECT PRODUCT_ID, PRICE,
--     CASE WHEN PRICE BETWEEN 0 AND 9999 THEN '0'
--         WHEN PRICE BETWEEN 10000 AND 19999 THEN '10000'
--         WHEN PRICE BETWEEN 20000 AND 29999 THEN '20000'
--         WHEN PRICE BETWEEN 30000 AND 39999 THEN '30000'
--         WHEN PRICE BETWEEN 40000 AND 49999 THEN '40000'
--         WHEN PRICE BETWEEN 50000 AND 59999 THEN '50000'
--         WHEN PRICE BETWEEN 60000 AND 69999 THEN '60000'
--         WHEN PRICE BETWEEN 70000 AND 79999 THEN '70000'
--         WHEN PRICE BETWEEN 80000 AND 89999 THEN '80000'
--     ELSE '확인요망'
--     END PRICE_GROUP
-- FROM PRODUCT


-- SELECT COUNT(PRICE), PRICE_GROUP,
--     CASE WHEN PRICE BETWEEN 0 AND 9999 THEN '0'
--         WHEN PRICE BETWEEN 10000 AND 19999 THEN '10000'
--         WHEN PRICE BETWEEN 20000 AND 29999 THEN '20000'
--         WHEN PRICE BETWEEN 30000 AND 39999 THEN '30000'
--         WHEN PRICE BETWEEN 40000 AND 49999 THEN '40000'
--         WHEN PRICE BETWEEN 50000 AND 59999 THEN '50000'
--         WHEN PRICE BETWEEN 60000 AND 69999 THEN '60000'
--         WHEN PRICE BETWEEN 70000 AND 79999 THEN '70000'
--         WHEN PRICE BETWEEN 80000 AND 89999 THEN '80000'
--     ELSE '확인요망'
--     END PRICE_GROUP
-- FROM(
--     SELECT PRICE
--     FROM PRODUCT
--     GROUP BY PRICE
-- )
-- GROUP BY PRICE_GROUP, PRICE -- 형식


-- 정답1
SELECT PRICE_GROUP, COUNT(PRICE) AS PRODUCTS
FROM(
    SELECT PRODUCT_ID, PRICE,
        CASE WHEN PRICE BETWEEN 0 AND 9999 THEN '0'
            WHEN PRICE BETWEEN 10000 AND 19999 THEN '10000'
            WHEN PRICE BETWEEN 20000 AND 29999 THEN '20000'
            WHEN PRICE BETWEEN 30000 AND 39999 THEN '30000'
            WHEN PRICE BETWEEN 40000 AND 49999 THEN '40000'
            WHEN PRICE BETWEEN 50000 AND 59999 THEN '50000'
            WHEN PRICE BETWEEN 60000 AND 69999 THEN '60000'
            WHEN PRICE BETWEEN 70000 AND 79999 THEN '70000'
            WHEN PRICE BETWEEN 80000 AND 89999 THEN '80000'
        ELSE '0'
        END PRICE_GROUP
    FROM PRODUCT
)
GROUP BY PRICE_GROUP--, PRICE
ORDER BY PRICE_GROUP









---- 3월에 태어난 여성 회원 목록 출력하기
/* 
조건
    생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회
    1)전화번호 NULL인 경우, 출력 제외
    2)MEMBER_ID 오름차순
    3)DATE_OF_BIRTH 1994-03-19 3월만 추출
    4)DATE_OF_BIRTH의 데이트 포맷 : 1993-03-16
    5)여성만
    
brainstorming
    1)DATE_OF_BIRTH의 데이트 포맷 : TOCHAR()
    2)여성만 : WHERE GENDER = 'W'
    3)TLNO = NULL이면 출력제외 : ?
    4)3월 추출 :
        방법1 : EXTRACT(MONTH FROM COLUMN)
        방법2 : SUBSTR()
        
*/

-- SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_OF_BIRTH
-- FROM MEMBER_PROFILE 
-- WHERE GENDER = 'W'

    
-- SELECT MEMBER_ID, MEMBER_NAME, GENDER, 
--     TO_CHAR(DATE_OF_BIRTH,'YY-MM-DD') AS DATE_OF_BIRTH
-- FROM MEMBER_PROFILE 
-- WHERE EXTRACT(MONTH FROM DATE_OF_BIRTH) = 03
--     AND GENDER = 'W' 
--     AND TLNO IS NOT NULL
-- -- 오답 : 정렬 빠지고 데이트타입 출력조건 YYYY임


SELECT MEMBER_ID, MEMBER_NAME, GENDER, 
    TO_CHAR(DATE_OF_BIRTH,'YYYY-MM-DD') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE 
WHERE EXTRACT(MONTH FROM DATE_OF_BIRTH) = 03
    AND GENDER = 'W' 
    AND TLNO IS NOT NULL
ORDER BY MEMBER_ID





---- 재구매가 일어난 상품과 회원 리스트 구하기
/* 
조건
    동일한 회원이 동일한 상품을 재구매한 데이터 추출, 재구매한 회원 ID와 재구매한 상품 ID를 출력
    1)한 회원이 동일 상품 재구매
    2)회원ID 오름차순 & 회원ID가 같다면, 상품ID 내림차순
    
brainstorming
    1)재구매 : COUNT()해서 2이상이면 재구매 분별 가능
    2)USER_ID,PRODUCT_ID를 GROUP BY로 묶은 후, COUNT(*)하면 동일한 회원이 재구매한 횟수가 나옴

*/

-- SELECT USER_ID, PRODUCT_ID
-- FROM ONLINE_SALE 
-- ORDER BY USER_ID, PRODUCT_ID

-- SELECT USER_ID, PRODUCT_ID, COUNT(USER_ID)
-- FROM ONLINE_SALE 
-- GROUP BY USER_ID, PRODUCT_ID
-- ORDER BY USER_ID, PRODUCT_ID

-- SELECT USER_ID, PRODUCT_ID, COUNT(USER_ID)
-- FROM ONLINE_SALE 
-- GROUP BY USER_ID, PRODUCT_ID
-- ORDER BY USER_ID, PRODUCT_ID
-- 이전 구매이력(userId)가 나오고 또 하나번 이상의 이력이 있으면 그걸 출력
-- 이걸 어떻게 뽑아낼까...? COUNT(USER_ID)해도 product_id가 달라서 카운트가 1씩로만 나오게됨. 아 이게 2개씩이어야 중복구매니까 카운트 맞는 듯?

-- SELECT USER_ID, PRODUCT_ID
-- FROM (
--     SELECT USER_ID, PRODUCT_ID, COUNT(USER_ID)
--     FROM ONLINE_SALE 
--     GROUP BY USER_ID, PRODUCT_ID
--     ORDER BY USER_ID, PRODUCT_ID
    -- )
    
-- WHERE,HAVING에서 카운트 추출 가능?
-- SELECT USER_ID, PRODUCT_ID, COUNT(USER_ID)
-- FROM ONLINE_SALE 
-- GROUP BY USER_ID, PRODUCT_ID
-- HAVING COUNT(USER_ID) >= 2       -- WHERE X, HAVING O
-- ORDER BY USER_ID, PRODUCT_ID
-- 단순 조회만 보면 카운트로 중복서치 결과가 2개 뿐임. COUNT(USER_ID)를 SELECT문에서 빼야함. 답과 결과 다름

-- SELECT USER_ID, PRODUCT_ID
-- FROM(
--     SELECT USER_ID, PRODUCT_ID, COUNT(USER_ID)
--     FROM ONLINE_SALE 
--     GROUP BY USER_ID, PRODUCT_ID
--     HAVING COUNT(USER_ID) >= 2       -- WHERE X, HAVING O
--     )   
-- ORDER BY USER_ID, PRODUCT_ID
-- COUNT빼고 해도 오답. 뭐가 문제일까? 정렬 내림차순 빠짐

SELECT USER_ID, PRODUCT_ID
FROM(
    SELECT USER_ID, PRODUCT_ID, COUNT(USER_ID)
    FROM ONLINE_SALE 
    GROUP BY USER_ID, PRODUCT_ID
    HAVING COUNT(USER_ID) >= 2 
    )   
ORDER BY USER_ID, PRODUCT_ID DESC






---- 조건에 부합하는 중고거래 상태 조회하기
/* 
조건
     2022년 10월 5일에 등록된 중고거래 게시물 조회
    1)거래상태가 SALE이면 판매중, RESERVED이면 예약중, DONE이면 거래완료 출력
    2)게시글ID DESC
    
brainstorming
    1)2022년 10월 5일 : WHERE CREATED_DATE = 2022-10-05
    2)거래상태 출력 : CASE WHEN THEN
        CASE WHEN STATUS = 'SALE' THEN '판매중'
             WHEN STATUS = 'RESERVED' THEN '예약중'
             WHEN STATUS = 'DONE' THEN '거래완료'
    3)DATETIEM 캐스팅 : CAST(값 AS DATE,NUMBER 등)

*/

-- SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, STATUS
-- FROM USED_GOODS_BOARD
-- ORDER BY BOARD_ID DESC

-- SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, STATUS
-- FROM USED_GOODS_BOARD
-- WHERE CREATED_DATE = CAST('2022-10-05' AS NUMBER)  -- CAST 쓰고빼고 ''도 넣고 빼고
-- 2022-10-05이 데이터타입이 안맞아 에러발생 : ORA-00932: inconsistent datatype 

-- 1.2022-10-05 게시물 추출 성공
-- SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, STATUS
-- FROM USED_GOODS_BOARD
-- WHERE EXTRACT(YEAR FROM CREATED_DATE) = 2022
--     AND EXTRACT(MONTH FROM CREATED_DATE) = 10
--     AND EXTRACT(DAY FROM CREATED_DATE) = 05
-- ORDER BY BOARD_ID DESC

-- 2.STATUS STR 적용 : CASE WHEN THEN
--SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
--        CASE WHEN STATUS = 'SALE' THEN '판매중'
--         WHEN STATUS = 'RESERVED' THEN '예약중'
--         WHEN STATUS = 'DONE' THEN '거래완료'
--         END STATUS -- ELSE 생략
--FROM USED_GOODS_BOARD
--WHERE EXTRACT(YEAR FROM CREATED_DATE) = 2022
--    AND EXTRACT(MONTH FROM CREATED_DATE) = 10
--    AND EXTRACT(DAY FROM CREATED_DATE) = 05
--ORDER BY BOARD_ID DESC



-- 정답1 : EXTRACT
-- SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
--       CASE WHEN STATUS = 'SALE' THEN '판매중'
--          WHEN STATUS = 'RESERVED' THEN '예약중'
--          WHEN STATUS = 'DONE' THEN '거래완료'
--          END STATUS -- ELSE 생략
-- FROM USED_GOODS_BOARD
-- WHERE EXTRACT(YEAR FROM CREATED_DATE) = 2022
--     AND EXTRACT(MONTH FROM CREATED_DATE) = 10
--     AND EXTRACT(DAY FROM CREATED_DATE) = 05
-- ORDER BY BOARD_ID DESC

-- 정답2 : TO_CHAR()
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
    CASE WHEN STATUS = 'SALE' THEN '판매중'
         WHEN STATUS = 'RESERVED' THEN '예약중'
         WHEN STATUS = 'DONE' THEN '거래완료'
         END STATUS -- ELSE 생략
FROM USED_GOODS_BOARD
WHERE TO_CHAR(CREATED_DATE,'YYYY-MM-DD') = '2022-10-05'
ORDER BY BOARD_ID DESC


-- 거래상태가 SALE이면 판매중, RESERVED이면 예약중, DONE이면 거래완료 출력
-- WHERE CREATED_DATE = 2022-10-05 + CAST() 방법 궁금
--    -> TO_CHAT() 사용 : 날짜 컬럼을 TO_CHAT()로 캐스팅하는 방법




/*
다시 풀어 볼 문제

    진료과별 총 예약 횟수 출력하기   
    상품 별 오프라인 매출 구하기★
    성분으로 구분한 아이스크림 총 주문량


*/





