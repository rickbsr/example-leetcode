package com.rick.problems;

public class SwapSalary {
}
/*
UPDATE salary
SET sex = CASE
WHEN sex = 'm' THEN 'f'
ELSE 'm'
END

UPDATE salary
SET sex = CHAR(ASCII('f') + ASCII('m') - ASCII(sex))
 */