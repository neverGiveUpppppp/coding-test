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









/*
다시 풀어 볼 문제

    진료과별 총 예약 횟수 출력하기   
    상품 별 오프라인 매출 구하기★



*/





