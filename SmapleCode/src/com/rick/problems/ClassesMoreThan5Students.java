package com.rick.problems;

public class ClassesMoreThan5Students {
}
/*
SELECT Class
FROM Courses
GROUP BY Class
HAVING COUNT(DISTINCT student) >= 5
 */