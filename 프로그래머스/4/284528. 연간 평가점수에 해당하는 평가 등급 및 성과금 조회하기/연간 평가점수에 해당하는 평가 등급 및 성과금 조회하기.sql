-- 코드를 작성해주세요
SELECT E.EMP_NO, E.EMP_NAME, CASE 
                                WHEN AVG(G.SCORE) >= 96 THEN 'S'
                                WHEN AVG(G.SCORE) >= 90 THEN 'A'
                                WHEN AVG(G.SCORE) >= 80 THEN 'B'
                                ELSE 'C' END AS GRADE,
                            CASE
                                WHEN AVG(G.SCORE) >= 96 THEN ROUND(E.SAL * 0.2, 0)
                                WHEN AVG(G.SCORE) >= 90 THEN ROUND(E.SAL * 0.15, 0)
                                WHEN AVG(G.SCORE) >= 80 THEN ROUND(E.SAL * 0.1, 0)
                                ELSE 0 END AS BONUS
                                    
FROM HR_EMPLOYEES E
    JOIN  HR_DEPARTMENT D
        ON E.DEPT_ID = D.DEPT_ID
    JOIN HR_GRADE G
        ON E.EMP_NO = G.EMP_NO
GROUP BY E.EMP_NO, E.EMP_NAME
ORDER BY EMP_NO;