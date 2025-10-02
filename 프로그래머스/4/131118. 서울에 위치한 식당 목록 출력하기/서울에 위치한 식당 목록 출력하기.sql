SELECT
    ri.REST_ID,
    ri.REST_NAME,
    ri.FOOD_TYPE,
    ri.FAVORITES,
    ri.ADDRESS,
    ROUND(AVG(rr.REVIEW_SCORE), 2) AS SCORE
FROM
    REST_INFO   AS ri
JOIN
    REST_REVIEW AS rr
      ON ri.REST_ID = rr.REST_ID
WHERE
    ri.ADDRESS LIKE '서울%'          -- '서울'로 시작(접두 일치)
GROUP BY
    ri.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS
ORDER BY
    SCORE DESC,                    -- 평균점수 내림차순
    ri.FAVORITES DESC;             -- 동점이면 즐겨찾기 내림차순
