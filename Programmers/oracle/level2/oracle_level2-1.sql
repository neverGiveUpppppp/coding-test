/*
프로그래머스
SQL ORACLE leve2-1

풀이 순서, 정답률 높은 순

*/



---- 동물 수 구하기
SELECT COUNT(ANIMAL_ID) AS COUNT
FROM ANIMAL_INS


---- 중복 제거하기
/* 
조건
1)입소 동물 이름 개수 조회
2)이름 NULL이면 집계X
3)중복X

NVL
DISCTINCT

*/
SELECT COUNT(DISTINCT(NAME)) AS COUNT
FROM ANIMAL_INS


---- 최솟값 구하기
/*  
조건
1)가장 먼저 입소
2)별칭

NVL
DISCTINCT

*/

SELECT MIN(DATETIME) AS 시간
FROM ANIMAL_INS




---- 동명 동물 수 찾기
/*  
조건
1)이름 중복 2번이상
2)중복 횟수 조회
3)이름X으면 제외
4)이름 정렬

중복 2회이상 : GROUP BY
중복횟수 조회 : COUNT

*/

SELECT NAME, COUNT(NAME) AS COUNT
FROM ANIMAL_INS
GROUP BY NAME
HAVING COUNT(NAME) >= 2
ORDER BY NAME ASC



---- 이름에 el이 들어가는 동물 찾기
/*  
조건
1)이름에 'el'이 들어간
2)개만 조회
3)아이디와 이름을 조회
4)대소문자 구분X
5)이름 정렬

이름 EL 포함 : LIKE '%el%'
대소문자 처리 : LOWER() OR UPPER()


*/

SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Dog'
    AND LOWER(NAME) LIKE LOWER('%el%')
ORDER BY NAME ASC



---- NULL 처리하기
/*  
조건
1)입양 게시판에 동물 정보를 게시
2)이름 NULL -> No name

NULL : NVL

*/

SELECT ANIMAL_TYPE, NVL(NAME,'No name') AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID



---- DATETIME에서 DATE로 형 변환
SELECT ANIMAL_ID, NAME, TO_CHAR(DATETIME,'YYYY-MM-DD') AS 날씨		
FROM ANIMAL_INS 
ORDER BY ANIMAL_ID



---- 가격이 제일 비싼 식품의 정보 출력하기
/*  
조건
테이블에서 가격이 제일 비싼 식품
*/
-- SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
SELECT *
FROM FOOD_PRODUCT 
WHERE PRICE = (SELECT MAX(PRICE)
               FROM FOOD_PRODUCT);
               
SELECT * FROM FOOD_PRODUCT 
ORDER BY PRICE DESC
FETCH FIRST ROWS ONLY;

/*
MYSQL
SELECT *
FROM FOOD_PRODUCT
ORDER BY PRICE DESC -- 가격 내림차순 
LIMIT 1 -- 하나의 행만
-- 즉, ORDER BY 이용해서 가장 큰 하나만 보여주는 것
*/




---- 고양이와 개는 몇 마리 있을까
/*  
조건
 고양이와 개가 각각 몇 마리
 고양이를 개보다 먼저 조회(정렬) : ASC DESC 결과에 따라 C D 순으로 하면 될 듯
*/
SELECT ANIMAL_TYPE, COUNT(*) AS COUNT
FROM ANIMAL_INS  
GROUP BY ANIMAL_TYPE
HAVING ANIMAL_TYPE IN ('Cat', 'Dog') -- 실무 대비 LOWER()가능? 가능
-- HAVING LOWER(ANIMAL_TYPE) IN (LOWER('Cat'), LOWER('Dog'))
ORDER BY ANIMAL_TYPE; 



---- 입양 시각 구하기(1)
/*
조건
몇 시에 입양이 가장 활발하게
09:00부터 19:59까지, 
각 시간대별 입양 발생 건수 조회
시간대 순으로 정렬

brainstorming
to_char로 시간만 나오게 하고 group by써서 시간대 같은거 하나로 묶고?
    -그룹바이 문법이 아니라 오류
group by 시간대 나온걸 count하면 될 듯?
서브쿼리로 한번 걸르고 하는 수 밖에..(서브쿼리 성능저하 때문에 되도록 안쓰는게...)
중복되는 시간 : DISTINCT
*/

-- SELECT TO_CHAR(DATETIME,'FMHH24') AS HOUR, DATETIME, COUNT(DATETIME) AS COUNT -- FM 공백제거, HH24 시간만 24시제로 표시
-- FROM ANIMAL_OUTS 
-- GROUP BY DATETIME
-- ORDER BY DATETIME
-- 원하는 결과물x

-- SELECT HOUR, DATETIME, COUNT(DATETIME) AS COUNT -- FM 공백제거, HH24 시간만 24시제로 표시
-- FROM (
--     SELECT TO_CHAR(DATETIME,'FMHH24') AS HOUR, DATETIME
--     FROM ANIMAL_OUTS
--     GROUP BY DATETIME -- ORA-00937: not a single-group group function
--     )
-- ORDER BY DATETIME
-- ORA-00937 : not a single-group group function
-- select 리스트에 있는 컬럼명이나 표현식 중 집계함수를 제외하고 모두 gruop by 절에 작성을 해야함
-- 위의 쿼리의 경우 COUNT() AS COUNT가 외부 쿼리에 있기에 GROUP BY도 외부에 있어야함

-- SELECT HOUR -- hour 하나만 조회하면 ORA-00937 해결
-- FROM (
--     SELECT TO_CHAR(DATETIME,'FMHH24') AS HOUR, DATETIME
--     FROM ANIMAL_OUTS
--     GROUP BY DATETIME
--     ) 
-- ORDER BY DATETIME
-- -- 시간이 GROUP BY안되어져서 나옴

-- SELECT HOUR, DATETIME
-- FROM (
--     SELECT TO_CHAR(DATETIME,'FMHH24') AS HOUR, DATETIME
--     FROM ANIMAL_OUTS    
--     ) 
-- GROUP BY HOUR, DATETIME
-- ORDER BY DATETIME
-- HOUR가 서브쿼리써도 그룹핑이 안되는 상황

-- SELECT SUBSTR(TO_CHAR(DATETIME,'YYYY-MM-DD-HH'),12,2), TO_CHAR(DATETIME,'YYYY-MM-DD-HH'), DATETIME
-- FROM ANIMAL_OUTS     
-- GROUP BY DATETIME
-- ORDER BY DATETIME
-- SUBSTR을 DATE형에 쓸려면 T0_CHAR()로 한번 변환하고 써야함. 안그러면 -FE 이런 결과가 나올 수 있음

-- SELECT HOUR
-- FROM (
--     SELECT SUBSTR(TO_CHAR(DATETIME,'YYYY-MM-DD-HH'),12,2) AS HOUR, DATETIME
--     FROM ANIMAL_OUTS
--     )
-- GROUP BY HOUR -- ORA-00979: not a GROUP BY expression
-- ORDER BY DATETIME
-- -- 서브쿼리 안에 선언된 별칭을 밖에 group by에서 사용불가

-- SELECT DATETIME AS HOUR, COUNT(DATETIME) AS COUNT
-- FROM (
--     SELECT SUBSTR(TO_CHAR(DATETIME,'YYYY-MM-DD-HH24'),12,2) AS DATETIME
--     FROM ANIMAL_OUTS
--     )
-- GROUP BY DATETIME
-- ORDER BY DATETIME ASC
-- 원래 날짜 컬럼명인 DATETIME을 별칭으로 바꿨더니 가능해짐!!
-- HOUR만 9-19까지 출력해보자


-- SELECT DATETIME AS HOUR, COUNT(DATETIME) AS COUNT
-- FROM (
--     SELECT SUBSTR(TO_CHAR(DATETIME,'YYYY-MM-DD-HH24'),12,2) AS DATETIME
--     FROM ANIMAL_OUTS
--     )
-- GROUP BY DATETIME
-- ORDER BY DATETIME ASC
-- -- 09의 0빼는 것과 7,8시 빼야함

SELECT LTRIM(DATETIME,0) AS HOUR, COUNT(DATETIME) AS COUNT
FROM (
    SELECT SUBSTR(TO_CHAR(DATETIME,'YYYY-MM-DD-HH24'),12,2) AS DATETIME
    FROM ANIMAL_OUTS
    )
GROUP BY DATETIME
HAVING NOT(DATETIME < 9 )
ORDER BY DATETIME ASC
-- HAVING NOT(DATETIME < 9 ) 으로 7,8시 빼고 9시부터 출력
-- LTRIM(DATETIME,0)으로 9시 0 지웠지만 오답처리됨



------------------------------------------------------

-- SELECT EXTRACT(HOUR FROM DATETIME)
-- FROM ANIMAL_OUTS
-- -- ORA-30076: invalid extract field for extract source

-- SELECT EXTRACT(HOUR FROM CAST(DATETIME AS TIMESTAMP)) HOUR
-- FROM ANIMAL_OUTS
-- -- CAST()로 파싱해서 오류해결


-- 정답1
SELECT HOUR, COUNT(HOUR) AS COUNT
FROM (
    SELECT EXTRACT(HOUR FROM CAST(DATETIME AS TIMESTAMP)) HOUR, DATETIME
    FROM ANIMAL_OUTS
    )
WHERE HOUR BETWEEN 9 AND 19
GROUP BY HOUR
ORDER BY HOUR --HOUR, DATETIME 
-- ORDER BY DATETIME 으로 하면 에러발생. 인라인뷰에 DATETIEM이 있더라도. GROUP BY때문에 HOUR로 해야함
-- ORA-00979: not a GROUP BY expression

-- 정답2
SELECT LTRIM(HOUR,0), COUNT(*)
FROM (SELECT to_char(DATETIME,'hh24') hour
     FROM ANIMAL_OUTS )
WHERE HOUR BETWEEN 9 AND 19
GROUP BY HOUR
ORDER BY HOUR


---- 중성화 여부 파악하기
/*  
조건
 'Neutered' 또는 'Spayed'라는 단어 포함 : LIKE
 중성화O,X 표기 : SELECT절 CASE문
*/
-- SELECT ANIMAL_ID, NAME
--     -- DECODE(SEX_UPON_INTAKE LIKE '%Neutered%',TRUE,'O','X') 
--     -- CASE WHEN SEX_UPON_INTAKE IN (SEX_UPON_INTAKE LIKE 'Neutered%') THEN 'O' 
--     --      WHEN SEX_UPON_INTAKE IN (SEX_UPON_INTAKE LIKE 'Spayed%') THEN 'O' 
--     --     CASE WHEN SEX_UPON_INTAKE IN (SEX_UPON_INTAKE LIKE 'Neutered%') THEN 'O' 
--     --      WHEN SEX_UPON_INTAKE IN (SEX_UPON_INTAKE LIKE 'Spayed%') THEN 'O' 
--     -- ELSE 'X' 
--     -- END '중성화'
-- FROM ANIMAL_INS A
--     JOIN (
--         SELECT *
--         FROM ANIMAL_INS
--         WHERE SEX_UPON_INTAKE LIKE '%Neutered%'
--                            OR LIKE '%Spayed%'
--         ) B 
--     ON (A.ANIMAL_ID = B.ANIMAL_ID)
-- WHERE SEX_UPON_INTAKE LIKE '%Neutered%'
--                    OR LIKE '%Spayed%'
-- 중성화 안된 것도 보여줘야하니 WHERE조건 X

-- 정답1 : SELECT절 CASE문 사용
SELECT ANIMAL_ID
      ,NAME
      ,(CASE WHEN SEX_UPON_INTAKE LIKE 'Spayed%' 
               OR SEX_UPON_INTAKE LIKE 'Neutered%' 
        THEN 'O'
        ELSE 'X'
        END
       )  AS 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID

-- 정답2 : 정규식 사용
SELECT ANIMAL_ID
      ,NAME
      ,CASE WHEN REGEXP_LIKE(SEX_UPON_INTAKE,'^Neutered|^Spayed') 
       THEN 'O'
       ELSE 'X' 
       END AS "중성화"
FROM ANIMAL_INS
ORDER BY 1,2,3




---- 카테고리 별 상품 개수 구하기
/*  
조건
 'Neutered' 또는 'Spayed'라는 단어 포함 : LIKE
 중성화O,X 표기 : SELECT절 CASE문
*/

-- SELECT SUBSTR(PRODUCT_CODE,0,2) AS CATEGORY--, COUNT(*) AS PRODUCTS
-- FROM PRODUCT
-- ORDER BY CATEGORY

-- 정답1 : GROUP BY + INLINE VIEW
 SELECT CATEGORY, COUNT(CATEGORY) AS PRODUCTS
 FROM 
     (SELECT SUBSTR(PRODUCT_CODE,0,2) AS CATEGORY
      FROM PRODUCT
      )
 GROUP BY CATEGORY
 ORDER BY CATEGORY

-- 정답2 : DISTINCT + OVER절
SELECT DISTINCT SUBSTR(PRODUCT_CODE,0,2) AS CATEGORY, 
       COUNT(*) OVER(PARTITION BY SUBSTR(PRODUCT_CODE,0,2)) AS PRODUCTS 
FROM PRODUCT
ORDER BY CATEGORY;



/*
다시 풀어 볼 문제

    이름에 el이 들어가는 동물 찾기
    가격이 제일 비싼 식품의 정보 출력하기
    입양 시각 구하기(1)    



*/





