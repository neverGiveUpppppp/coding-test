/*
프로그래머스
SQL ORACLE leve3-2

풀이 순서, 정답률 높은 순

*/






---- 대여 기록이 존재하는 자동차 리스트 구하기
/* 
조건
    자동차 종류가 '세단'인 자동차들 중 10월에 대여를 시작한 기록이 있는 자동차 ID 리스트를 출력 
    1)종류 세단
    2)10월 대여
    3)자동차 ID 리스트는 중복x
    4)자동차 ID를 기준으로 내림차순 
    
brainstorming
    1)종류 세단 : WHERE OR HAVING A.CAR_TYPE = '세단'
    2)10월 대여 : WHERE OR HAVING EXTRACT(MONTH FROM B.START_DATE) = 10
    3)자동차 ID 리스트는 중복x : GROUP BY

*/


-- 1.종류 세단 : WHERE A.CAR_TYPE = '세단'
-- SELECT A.CAR_ID, CAR_TYPE
-- FROM CAR_RENTAL_COMPANY_CAR A
--     JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B ON A.CAR_ID = B.CAR_ID
-- WHERE A.CAR_TYPE = '세단'
-- ORDER BY A.CAR_ID DESC


-- 2. 10월 대여 시작 : HAVING EXTRACT(MONTH FROM B.START_DATE) = 10
-- SELECT A.CAR_ID--, CAR_TYPE
-- FROM CAR_RENTAL_COMPANY_CAR A
--     JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B ON A.CAR_ID = B.CAR_ID
-- WHERE A.CAR_TYPE = '세단'
-- GROUP BY A.CAR_ID,B.START_DATE -- 자동자ID중복X 조건?
-- HAVING EXTRACT(MONTH FROM B.START_DATE) = 10
-- ORDER BY A.CAR_ID DESC
-- -- CAR_ID 중복됨 -> HAVING 때문에 GROUP BY에 START_DATE를 추가해야하므로 WHERE문으로 변경

-- SELECT A.CAR_ID--, CAR_TYPE
-- FROM CAR_RENTAL_COMPANY_CAR A
--     JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B ON A.CAR_ID = B.CAR_ID
-- WHERE A.CAR_TYPE = '세단'
--     AND EXTRACT(MONTH FROM B.START_DATE) = 10
-- GROUP BY A.CAR_ID
-- ORDER BY A.CAR_ID DESC


-- 정답1 : WHERE + EXTRACT + GROUP BY
 SELECT A.CAR_ID
 FROM CAR_RENTAL_COMPANY_CAR A
     JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY B ON A.CAR_ID = B.CAR_ID
 WHERE A.CAR_TYPE = '세단'
     AND EXTRACT(MONTH FROM B.START_DATE) = 10
 GROUP BY A.CAR_ID
 ORDER BY A.CAR_ID DESC

-- 정답2 : DISTINCT + WHERE + TO_CHAR()
SELECT DISTINCT A.CAR_ID
FROM CAR_RENTAL_COMPANY_CAR A, CAR_RENTAL_COMPANY_RENTAL_HISTORY B
WHERE A.CAR_ID = B.CAR_ID
    AND A.CAR_TYPE = '세단' 
    AND TO_CHAR(B.START_DATE, 'YYYYMM') = '202210' 
ORDER BY 1 DESC;












---- 없어진 기록 찾기
/* 
조건
    데이터가 유실됨. 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물 조회
    1)입양기록O, 보호소 IN기록X
    2)
    
brainstorming
    1)입양기록O : B.DATETIME NOT NULL || NVL, IS NULL, NULLIF
        WHERE B.DATETIME IS NOT NULL
    2)보호소IN기록X : A.DATETIME NULL 
        WHERE A.DATETIME IS NULL
    3)한쪽에만 있는 데이터도 나와야하기 때문에 FULL JOIN
        입양기록O,보호소기록X면 LEFT,RIGHT를 써야하나...?
    4)ANIMAL_INS에 없으므로 라는 말을 보면 ANIMAL_OUTS B 기준으로 봐야할 듯?
    
*/

-- SELECT A.ANIMAL_ID, A.NAME
-- FROM ANIMAL_INS A
--     JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID

-- -- 1.입양간 기록O,보호소기록X 조건 추가 : WHERE A.DATETIME IS NULL AND B.DATETIME IS NOT NULL
-- SELECT A.ANIMAL_ID, A.NAME
-- FROM ANIMAL_INS A
--     FULL OUTER JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- WHERE A.DATETIME IS NULL 
--     AND B.DATETIME IS NOT NULL
-- ORDER BY A.ANIMAL_ID, A.NAME

-- 혹시 몰라서 B테이블도 조회해봄 : 내용X
-- SELECT B.ANIMAL_ID, B.NAME
-- FROM ANIMAL_INS A
--     FULL OUTER JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- HERE A.DATETIME IS NULL 
--     AND B.DATETIME IS NOT NULL
-- ORDER BY B.ANIMAL_ID, B.NAME


-- 뭘해야할지 모르겠으니 일단 다시한번 하나씩 쪼개서 조회해보자
-- SELECT A.ANIMAL_ID, A.DATETIME, B.ANIMAL_ID, B.DATETIME
-- FROM ANIMAL_INS A
--     FULL JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- -- 각각 한쪽에만 있는 동물들이 있음. A만 있으면 입양아직인거고, B에만 있으면 데이터유실임


-- 예제 "Allie의 ID는 ANIMAL_INS에 없으므로, Allie의 데이터는 유실되었습니다"로 만들어봄
-- SELECT A.ANIMAL_ID, A.DATETIME, B.ANIMAL_ID, B.DATETIME
-- FROM ANIMAL_INS A
--     FULL JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- WHERE B.DATETIME IS NOT NULL    
--     AND A.DATETIME IS NULL
-- ORDER BY B.ANIMAL_ID, B.NAME
    
-- 예제보면 'ANIMAL_INS에 없으므로'의 말로보아 ANIMAL_OUTS B 기준으로 봐야할 듯  
-- SELECT B.ANIMAL_ID, B.NAME
-- FROM ANIMAL_INS A
--     FULL JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
-- WHERE B.DATETIME IS NOT NULL    
--     AND A.DATETIME IS NULL
-- ORDER BY B.ANIMAL_ID, B.NAME


-- 정답1 : FULL JOIN + IS NULL + IS NOT NULL
SELECT B.ANIMAL_ID, B.NAME
FROM ANIMAL_INS A
    FULL JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.DATETIME IS NOT NULL    
    AND A.DATETIME IS NULL
ORDER BY B.ANIMAL_ID, B.NAME

-- 정답2 : RIGHT JOIN + IS NULL (리소스 덜 잡아먹는 쿼리)
SELECT B.ANIMAL_ID, B.NAME
FROM ANIMAL_INS A, ANIMAL_OUTS B
WHERE A.ANIMAL_ID (+) = B.ANIMAL_ID
   AND A.ANIMAL_ID IS NULL
ORDER BY B.ANIMAL_ID


-- 정답3 : SUBQUERY + NOT EXISTS
SELECT ANIMAL_ID, NAME 
FROM ANIMAL_OUTS AO
WHERE NOT EXISTS (
    SELECT 1 
    FROM ANIMAL_INS AI 
    WHERE AI.ANIMAL_ID = AO.ANIMAL_ID
    )
ORDER BY ANIMAL_ID












---- 조건에 맞는 사용자 정보 조회하기
/* 
조건
    중고 거래 게시물을 3건 이상 등록한 사용자의 사용자 ID, 닉네임, 전체주소, 전화번호를 조회
    1)게시물을 3건 이상
        A.BOARD_ID 
    2)전체 주소는 시, 도로명 주소, 상세 주소가 함께 출력
        CITY, STREET_ADDRESS1, STREET_ADDRESS2 AS 전체주소
    3)전화번호의 경우 xxx-xxxx-xxxx 같은 형태로 하이픈 문자열(-)을 삽입하여 출력
        TLNO AS 전화번호 <- xxx-xxxx-xxxx 하이픈 추가
    4)회원 ID를 기준으로 내림차순
    
brainstorming
    1)게시물을 3건 이상 :  A.BOARD_ID FETCH FIRST 3 ? // WHERE COUNT(A.BOARD_ID) >= 3 // RANK() OVER
    2)전체 주소 : (CITY + " " + STREET_ADDRESS1 + " " + STREET_ADDRESS2) AS 전체주소
        +는 계산식으로 들어감. 자바식. ||으로 리터럴 이어붙이기 가능
    3)전화번호 하이픈 : SUBSTR(TLNO,1,3) || '-' || SUBSTR(TLNO,4,4) || '-' || SUBSTR(TLNO,8,4) AS 전화번호

*/

-- SELECT  B.USER_ID, B.NICKNAME, 전체주소, 전화번호
-- FROM USED_GOODS_BOARD A
--     JOIN USED_GOODS_USER B ON A.WRITER_ID = B.USER_ID
-- ORDER BY B.USER_ID DESC


-- 1.게시물 3건이상 : 
---- 1)GROUP BY + HAVING COUNT(B.USER_ID) >= 3
-- SELECT  B.USER_ID, B.NICKNAME--,--COUNT(B.USER_ID)--,--, 전체주소, 전화번호
--         --RANK() OVER(ORDER BY BOARD_ID)
-- FROM USED_GOODS_BOARD A
--     JOIN USED_GOODS_USER B ON A.WRITER_ID = B.USER_ID
-- -- WHERE COUNT(A.BOARD_ID) >= 3 -- ORA-00934: group function is not allowed here
-- GROUP BY B.USER_ID, B.NICKNAME
-- HAVING COUNT(B.USER_ID) >= 3
-- ORDER BY B.USER_ID DESC

---- 2)RANK() OVER
-- SELECT B.USER_ID, B.NICKNAME
-- FROM USED_GOODS_BOARD A
--     JOIN (
--         SELECT  U.USER_ID, U.NICKNAME,
--                 RANK() OVER(ORDER BY U.BOARD_ID)
--         FROM USED_GOODS_USER AS U
--         FETCH FIRST 3 ROWS ONLY
--     ) B ON A.WRITER_ID = B.USER_ID
-- ORDER BY B.USER_ID DESC
-- SELECT U.USER_ID, U.NICKNAME--,RANK() OVER(ORDER BY U.BOARD_ID)
-- FROM USED_GOODS_USER U
-- FETCH FIRST 3 ROWS ONLY
---- 애초에 안되는 방법인 듯. FETCH로는 3건 이상 조건 만족안됨. RANK() OVER 사용법 아직 잘모르는 것도 있음.



--2. 전체 주소 :  CITY, STREET_ADDRESS1, STREET_ADDRESS2 AS 전체주소
-- SELECT  B.USER_ID, B.NICKNAME, 
--         (CITY +STREET_ADDRESS1 + STREET_ADDRESS2) AS 전체주소 -- ORA-00979 : GROUP BY에 안들어 있어 에러
-- FROM USED_GOODS_BOARD A
--     JOIN USED_GOODS_USER B ON A.WRITER_ID = B.USER_ID
-- GROUP BY B.USER_ID, B.NICKNAME
-- HAVING COUNT(B.USER_ID) >= 3
-- ORDER BY B.USER_ID DESC

-- SELECT C.USER_ID, C.NICKNAME--, (CITY +STREET_ADDRESS1 + STREET_ADDRESS2) AS 전체주소
-- FROM(
--     SELECT  B.USER_ID, B.NICKNAME
--     FROM USED_GOODS_BOARD A
--         JOIN USED_GOODS_USER B ON A.WRITER_ID = B.USER_ID
--     GROUP BY B.USER_ID, B.NICKNAME
--     HAVING COUNT(B.USER_ID) >= 3
--     ) C
-- ORDER BY C.USER_ID DESC

-- SELECT C.USER_ID, C.NICKNAME--, (CITY +STREET_ADDRESS1 + STREET_ADDRESS2) AS 전체주소
-- FROM(
--     SELECT  USER_ID, NICKNAME
--     FROM USED_GOODS_BOARD A
--     GROUP BY USER_ID, NICKNAME
--     HAVING COUNT(USER_ID) >= 3
--     ) C
-- ORDER BY C.USER_ID DESC

-- SELECT  WRITER_ID -- USED_GOODS_BOARD에서 쓰고 싶은 SELECT컬럼이 WRITER_ID하나라 이렇게 서브쿼리써도 OK
-- FROM USED_GOODS_BOARD  
-- GROUP BY WRITER_ID
-- HAVING COUNT(BOARD_ID) >= 3


-- SELECT B.USER_ID, B.NICKNAME, (CITY + STREET_ADDRESS1 + STREET_ADDRESS2) AS 전체주소 -- ORA-01722: invalid number
---- ORA-01722: invalid number : 수내로 13 + 401호 이런식으로 숫자계산으로 되서 에러나는 듯
-- SELECT B.USER_ID, B.NICKNAME, (TO_CHAT(CITY) + TO_CHAT(STREET_ADDRESS1) + TO_CHAT(STREET_ADDRESS2)) AS 전체주소
---- ORA-00904: "TO_CHAT": invalid identifier
-- SELECT B.USER_ID, B.NICKNAME, TO_CHAR(CITY) AS 전체주소1, TO_CHAR(STREET_ADDRESS1) AS ㅁ, 전체주소1 + ㅁ--ORA-00904: "ㅁ": invalid identifier
---- TO_CHAT() 자체가 간단한 계산은 되는 구조라 계산식이 먹혀서 invalid number라고 뜨는 듯?
-- SELECT B.USER_ID, B.NICKNAME,  CONCAT(CITY, STREET_ADDRESS1) -- CONCAT()은 공백 추가가 안됨

-- SELECT B.USER_ID, B.NICKNAME, SUBSTR(TLNO,1,3) || '-' || SUBSTR(TLNO,4,4) || '-' || SUBSTR(TLNO,8,4) AS 전화번호
-- -- 성공


-- 3.전화번호 : SUBSTR(TLNO,1,3) || '-' || SUBSTR(TLNO,4,4) || '-' || SUBSTR(TLNO,8,4) AS 전화번호
-- SELECT B.USER_ID, B.NICKNAME, 
--        CITY || ' ' || STREET_ADDRESS1  || ' ' || STREET_ADDRESS2 AS 전체주소,
--        SUBSTR(TLNO,1,3) || '-' || SUBSTR(TLNO,4,4) || '-' || SUBSTR(TLNO,8,4) AS 전화번호
-- FROM(
--     SELECT  WRITER_ID
--     FROM USED_GOODS_BOARD  
--     GROUP BY WRITER_ID
--     HAVING COUNT(BOARD_ID) >= 3
--     ) A
--     JOIN USED_GOODS_USER B ON A.WRITER_ID = B.USER_ID
-- ORDER BY B.USER_ID DESC

-- 정답1 :  || + SUBSTR + SUBQUERY + GROUP BY, HAVING
 SELECT B.USER_ID, B.NICKNAME, 
        CITY || ' ' || STREET_ADDRESS1  || ' ' || STREET_ADDRESS2 AS 전체주소,
        SUBSTR(TLNO,1,3) || '-' || SUBSTR(TLNO,4,4) || '-' || SUBSTR(TLNO,8,4) AS 전화번호
 FROM(
     SELECT  WRITER_ID
     FROM USED_GOODS_BOARD  
     GROUP BY WRITER_ID
     HAVING COUNT(BOARD_ID) >= 3
     ) A
     JOIN USED_GOODS_USER B ON A.WRITER_ID = B.USER_ID
 ORDER BY B.USER_ID DESC

-- 정답2 : WITH문 + GROUP BY, HAVING + || + SUBSTR + CHR(32)
WITH OVER_THREE AS 
    (
    SELECT WRITER_ID, COUNT(WRITER_ID)
    FROM USED_GOODS_BOARD
    GROUP BY WRITER_ID
    HAVING COUNT(WRITER_ID) >= 3
    )

SELECT OT.WRITER_ID, UGU.NICKNAME, 
       UGU.CITY || CHR(32) || UGU.STREET_ADDRESS1 || CHR(32) || UGU.STREET_ADDRESS2 AS 전체주소,
       SUBSTR(UGU.TLNO,1,3) || '-' || SUBSTR(UGU.TLNO,4,4) || '-' || SUBSTR(UGU.TLNO,-4,4) AS 전화번호
       -- CHR(32) : ASCII 코드 32에 해당하는 문자를 반환하는 오라클 함수
FROM OVER_THREE OT 
    JOIN USED_GOODS_USER UGU ON OT.WRITER_ID = UGU.USER_ID
ORDER BY OT.WRITER_ID DESC


/*
MYSQL은 CONCAT 파라미터 3개이상 가능
오라클은 CONCAT 파라미터 2개 고정
*/







---- 헤비 유저가 소유한 장소
/* 

조건
    공간을 둘 이상 등록한 사람 : "헤비 유저"
    헤비 유저가 등록한 공간의 정보를 아이디 순으로 조회
    1)헤비유저 : 공간 아이디가 두개인 host_id 찾기
    2)
    
brainstorming
    1)SELF-JOIN 사용해서 GROUP으로 외부쿼리에서 조회하는 방식?
    2)

*/

-- SELECT ID, NAME, HOST_ID
-- FROM PLACES A
--     LEFT JOIN (
--         SELECT C.HOST_ID
--         FROM PLACES 
--         ) B ON A.HOST_ID = C.HOST.ID

-- SELECT A.ID, A.NAME, A.HOST_ID
-- FROM PLACES A
--     LEFT JOIN (
--         SELECT B.HOST_ID
--         FROM PLACES B
--         ) C ON A.HOST_ID = C.HOST.ID -- ORA-00904
-- -- ORA-00904:  "C"."HOST"."ID": invalid identifier
-- -- 셀프조인 인라인뷰 안 SELECT 컬럼을 JOIN ON절에서 못씀

-- SELECT A.ID, A.NAME, A.HOST_ID, COUNT(A.HOST_ID)
-- FROM PLACES A
-- GROUP BY A.HOST_ID, A.ID, A.NAME
-- -- HAVING COUNT(A.HOST_ID) >= 2
-- ORDER BY A.ID

-- 1.헤비유저 조건
-- SELECT A.HOST_ID, COUNT(A.HOST_ID)
-- FROM PLACES A
-- GROUP BY A.HOST_ID
-- HAVING COUNT(A.HOST_ID) >= 2

-- 2.조회 조건 만족
-- SELECT A.ID, A.NAME, A.HOST_ID
-- FROM PLACES A
--     JOIN (
--         SELECT B.HOST_ID, COUNT(B.HOST_ID)
--         FROM PLACES B
--         GROUP BY B.HOST_ID
--         HAVING COUNT(B.HOST_ID) >= 2
--         ) C ON A.HOST_ID = C.HOST_ID


 --정답1 : 인라인뷰 + GROUP HAVING + COUNT()
 SELECT A.ID, A.NAME, A.HOST_ID
 FROM PLACES A
     JOIN (
         SELECT B.HOST_ID, COUNT(B.HOST_ID)
         FROM PLACES B
         GROUP BY B.HOST_ID
         HAVING COUNT(B.HOST_ID) >= 2
         ) C ON A.HOST_ID = C.HOST_ID

-- 정답2 : 인라인뷰 + ROW_NUBMER() + IN + GROUP BY, HAVING
 SELECT 
     P.ID, P.NAME, P.HOST_ID
 FROM (
     SELECT PLACES.*,   
            ROW_NUMBER() OVER (ORDER BY ID) AS row_num
     FROM PLACES
     WHERE HOST_ID IN (
             SELECT HOST_ID  
             FROM PLACES 
             GROUP BY HOST_ID    
             HAVING COUNT(*) > 1
         )
 ) P
 ORDER BY P.row_num;

-- 정답3 : WHERE + IN + 서브쿼리 + GROUP BY, HAVING + COUNT()
SELECT * 
FROM PLACES
WHERE HOST_ID IN
    (
    SELECT HOST_ID FROM PLACES
    GROUP BY HOST_ID
    HAVING COUNT(HOST_ID) >= 2
    )
ORDER BY ID;

    


















---- 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
/* 
조건
    2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시하고, 
    대여 중이지 않은 자동차인 경우 '대여 가능'을 표시하는 컬럼(컬럼명: AVAILABILITY)을 추가하여 
    자동차 ID와 AVAILABILITY 리스트를 출력
    1) 2022년 10월 16일
    2) 대여 중인 자동차인 경우 '대여중' or '대여 가능' 표시하는 컬럼(컬럼명: AVAILABILITY)을 추가
    3) 반납 날짜가 2022년 10월 16일인 경우에도 '대여중'으로 표시
    4) 자동차 ID를 기준으로 내림차순
    
brainstorming
    END_DATE가 10월 16일까지 '대여중'
    1)2022년 10월 16일 : TO_CHAR(END_DATE)  <= '2022-10-16'
      - 단순 END_DATE가 16일 이전꺼면 과거 기록 다 불러오니 대여종료인 기록도 불러와서 판별 불가
      - 근데 어쨋든 대여종료 기록이 16일 전이면 차는 돌아왔으니 대여 가능한 상태임.
      - 문제는 START_DATE가 10.16이후인 것들임. 미래 예약인데 이것도 언제 예약인지가 문제네
        BETWEEN 쓸려해도 기준을 어떻게 잡지?
      
    2)'대여중' or '대여 가능' AVAILABILITY컬럼 : case when + literal

*/

-- SELECT CAR_ID, START_DATE, END_DATE
-- FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
-- ORDER BY CAR_ID DESC


-- DATE와 NUMBER의 데이터타입 테스트
-- SELECT CAR_ID, START_DATE, END_DATE
-- FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
-- -- WHERE END_DATE  <= 2022-10-16    -- ORA-00932: inconsistent datatypes: expected DATE got NUMBER
-- -- WHERE END_DATE  <= TO_CHAR(2022-10-16) -- ORA-01861: literal does not match format string
-- -- WHERE TO_CHAR(END_DATE)  <= 2022-10-16 -- ORA-01722: invalid number
-- WHERE TO_CHAR(END_DATE)  <= '2022-10-16' -- 성공
-- ORDER BY CAR_ID DESC


-- 1.AVAILABILITY 및 대여중 추가
-- SELECT CAR_ID, START_DATE, END_DATE,
--        CASE WHEN TO_CHAR(END_DATE,'YY-MM-DD')  >= '22-10-16' THEN '대여중'
--        ELSE '대여가능'
--        END AS AVAILABILITY
-- FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
-- -- WHERE  TO_CHAR(END_DATE,'YY-MM-DD')  = '22-10-16'
-- ORDER BY CAR_ID DESC
---- CAR_ID 중복 -> END_DATE의 가장 최근 기록을 불러와야함 -> GROUP으로 묶고 거기서 END 최신것만 조건으로 추려내고 서브쿼리
---- END_DATE 최신 것만 어떻게 불러오지? 
---- 아니다. 대여 시작과 종료 중간에 22년10월16일이 있으면 대여중이고 아니면 대여가능이네


-- SELECT CAR_ID, START_DATE, END_DATE,
--        CASE WHEN TO_CHAR(END_DATE,'YY-MM-DD')  >= '22-10-16' THEN '대여중'
--        ELSE '대여가능'
--        END AS AVAILABILITY
-- FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
-- GROUP BY CAR_ID, START_DATE, END_DATE
-- HAVING MAX(TO_CHAR(END_DATE,'YYMMDD'))
-- ORDER BY CAR_ID DESC






-- 2.
-- 3.

-- 정답1 : 
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

     1.자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기
     2.



*/





