package com.rick.problems;

public class SecondHighestSalary {
}

/*
SELECT
    IFNULL(
      (SELECT DISTINCT Salary
       FROM Employee
       ORDER BY Salary DESC
       LIMIT 1 OFFSET 1),
    NULL) AS SecondHighestSalary
 */