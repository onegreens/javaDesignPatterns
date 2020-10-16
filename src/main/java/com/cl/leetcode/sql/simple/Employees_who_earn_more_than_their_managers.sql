# {"headers": {"Employee": ["Id", "Name", "Salary", "ManagerId"]}, "rows": {"Employee": [[1, "Joe", 70000, 3], [2, "Henry", 80000, 4], [3, "Sam", 60000, null], [4, "Max", 90000, null]]}}
USE leetcode;

SELECT name Employee
FROM (SELECT
        name,
        em.Salary                   es,
        (SELECT min(Salary)
         FROM employee e
         WHERE e.id = em.ManagerId) ms
      FROM employee em
      WHERE em.ManagerId IS NOT NULL) rs
WHERE rs.es > rs.ms

## 优化

SELECT e.name Employee
FROM employee e, employee m
WHERE e.ManagerId = m.id AND e.Salary > m.Salary;

## 使用 join
SELECT e.name Employee
FROM employee e
  JOIN employee m ON
                    e.ManagerId = m.id
WHERE e.Salary > m.Salary;