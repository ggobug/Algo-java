-- 접근 순서
-- 1. 동일한 회원이 동일한 상품을 구매한 경우 : GROUP BY로 그룹핑
-- 2. 재구매한 데이터를 추출 : 그룹핑 된 데이터가 두개 이상이어야 함 -> HAVING
-- 3. 회원 ID 오름차순, TKDVNA ID 내림차순 정렬

SELECT USER_ID, PRODUCT_ID FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) >= 2
ORDER BY USER_ID, PRODUCT_ID DESC;