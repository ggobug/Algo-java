SELECT CATEGORY, SUM(SALES) AS TOTAL_SALES FROM BOOK
JOIN (SELECT BOOK_ID, SALES FROM BOOK_SALES
     WHERE SALES_DATE LIKE "%2022-01%") AS BOOK_SALES
     ON BOOK.BOOK_ID = BOOK_SALES.BOOK_ID
     GROUP BY CATEGORY
     ORDER BY CATEGORY ASC