-- APPOINTMENT 테이블에서 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회하는 SQL문을 작성해주세요. 이때, 컬럼명은 '진료과 코드', '5월예약건수'로 지정해주시고 결과는 진료과별 예약한 환자 수를 기준으로 오름차순 정렬하고, 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬해주세요.
SELECT MCDP_CD as 진료과코드, count(distinct PT_NO) as 5월예약건수
from APPOINTMENT
where year(APNT_YMD) = 2022 and month(APNT_YMD) = 5
group by mcdp_cd
order by 5월예약건수, 진료과코드;