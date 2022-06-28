package com.rick.problems;

public class DuplicateEmails {
}
/*
SELECT `Email`
FROM Person
GROUP BY `Email`
HAVING COUNT(`Email`) > 1
 */