/*
프로그래머스
SQL ORACLE level1 

*/

---- 어린 동물 찾기
SELECT ANIMAL_ID,NAME
FROM ANIMAL_INS
WHERE INTAKE_CONDITION != 'Aged'
ORDER BY ANIMAL_ID


---- 동물의 아이디와 이름
SELECT ANIMAL_ID,NAME
FROM ANIMAL_INS
ORDER BY ANIMAL_ID


---- 여러 기준으로 정렬하기
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS
ORDER BY NAME, DATETIME DESC -- NAME으로 오름차순으로 A to Z로 정렬 후, 
-- 여기서 이름이 같으면 DATETIME으로 DESC로 다시 내림차순 정렬해서 나중에 들어온 동물부터 보여줌


---- 상위 n개 레코드
--SELECT NAME
--FROM ANIMAL_INS
--GROUP BY DATETIME
--HAVING MIN(DATETIME) -- 결과수가 많음. 오답
-- 
/*
brainstorming
datatime의 자료형을 number로 바꾸고 min()를 쓰면 어떨까?
to_number() + min()
*/
--SELECT NAME
--FROM ANIMAL_INS
--GROUP BY DATETIME
--HAVING MIN(DATETIME) -- 결과수가 많음

--SELECT NAME
--FROM ANIMAL_INS
--GROUP BY DATETIME
--HAVING MIN(TO_NUMBER(DATETIME)) -- ERROR

--SELECT MIN(TO_NUMBER(NAME))
--FROM ANIMAL_INS-- ERROR

-- FETCH 사용(오라클 12c 부터 사용 가능)
-- SELECT NAME
-- FROM ANIMAL_INS
-- ORDER BY DATETIME
-- FETCH FIRST 1 ROWS ONLY

SELECT NAME
FROM(
    SELECT NAME
    FROM ANIMAL_INS
    ORDER BY DATETIME
    )
WHERE rownum = 1;


-- 이름이 있는 동물의 아이디
    SELECT ANIMAL_ID
    FROM ANIMAL_INS 
    WHERE NAME IS NOT NULL
    ORDER BY ANIMAL_ID


-- 역순 정렬하기
SELECT NAME, DATETIME
FROM ANIMAL_INS 
ORDER BY ANIMAL_ID DESC


-- 아픈 동물 찾기
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS 
WHERE INTAKE_CONDITION = 'Sick'
ORDER BY ANIMAL_ID


-- 강원도에 위치한 생산공장 목록 출력하기
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
FROM FOOD_FACTORY 
WHERE ADDRESS LIKE '강원도%'
ORDER BY FACTORY_ID

-- 나이 정보가 없는 회원 수 구하기
SELECT COUNT(*) AS USERS
FROM USER_INFO 
WHERE AGE IS NULL


-- 가장 비싼 상품 구하기
SELECT MAX(PRICE) AS MAX_PRICE
FROM PRODUCT 

-- 경기도에 위치한 식품창고 목록 출력하기
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, NVL(FREEZER_YN,'N') AS FREEZER_YN
FROM FOOD_WAREHOUSE 
WHERE ADDRESS LIKE '경기도%'
ORDER BY WAREHOUSE_ID


-- 이름이 없는 동물의 아이디
SELECT ANIMAL_ID
FROM ANIMAL_INS 
WHERE NAME IS NULL
ORDER BY ANIMAL_ID


-- 조건에 맞는 회원수 구하기
-- USER_INFO 테이블에서 2021년에 가입한 회원 중 나이가 20세 이상 29세 이하인 회원이 몇 명인지 출력하는 SQL문을 작성해주세요.
-- SELECT * -- 자료 확인용
SELECT COUNT(*) AS USERS
FROM USER_INFO 
-- WHERE JOINED LIKE '%2021%' -- 조회X
-- BRAINSTORMING : EXTRACT 2021, TO_NUMBER(), 
WHERE EXTRACT(YEAR FROM JOINED) = 2021
    AND AGE BETWEEN 20 AND 29;

SELECT COUNT(*) AS USERS
FROM USER_INFO 
WHERE EXTRACT(YEAR FROM JOINED) = 2021
    AND AGE BETWEEN 20 AND 29;


-- 흉부외과 또는 일반외과 의사 목록 출력하기
--SELECT DR_NAME, DR_ID, MCDP_CD, HIRE_YMD
--FROM DOCTOR
--WHERE MCDP_CD IN('CS', 'GS')
--ORDER BY HIRE_YMD DESC, DR_NAME -- 틀림 : HIRE_YMD의 출력 양식이 같아야함. 시간정보 제거

SELECT DR_NAME, DR_ID, MCDP_CD, 
    TO_CHAR(HIRE_YMD,'YYYY-MM-DD') -- TO_CHAR() : 문자열 출력양식 지정. FM 넣으면 0지움
FROM DOCTOR
WHERE MCDP_CD IN('CS', 'GS')
ORDER BY HIRE_YMD DESC, DR_NAME



-- 12세 이하인 여자 환자 목록 출력하기
SELECT PT_NAME, PT_NO, GEND_CD, AGE, NVL(TLNO, 'NONE')
FROM PATIENT 
WHERE AGE <= 12 AND GEND_CD = 'W'
ORDER BY AGE DESC, PT_NAME ASC



-- 인기있는 아이스크림
SELECT FLAVOR
FROM FIRST_HALF 
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC



-- 모든 레코드 조회하기
SELECT *
FROM ANIMAL_INS  
ORDER BY ANIMAL_ID



-- 조건에 맞는 도서 리스트 출력하기
SELECT BOOK_ID, TO_CHAR(PUBLISHED_DATE, 'YYYY-MM-DD') AS PUBLISHED_DATE
FROM BOOK 
WHERE  EXTRACT(YEAR FROM PUBLISHED_DATE) = 2021
    AND CATEGORY = '인문'
ORDER BY PUBLISHED_DATE ASC



-- 평균 일일 대여 요금 구하기
SELECT ROUND(AVG(DAILY_FEE),0) AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR 
WHERE CAR_TYPE = 'SUV'


/*
다시 풀어 볼 문제
경기도에 위치한 식품창고 목록 출력하기
조건에 맞는 회원수 구하기
흉부외과 또는 일반외과 의사 목록 출력하기



*/





