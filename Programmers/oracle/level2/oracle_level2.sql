/*
프로그래머스
SQL ORACLE level2 

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








/*
다시 풀어 볼 문제

    이름에 el이 들어가는 동물 찾기
    가격이 제일 비싼 식품의 정보 출력하기




*/





