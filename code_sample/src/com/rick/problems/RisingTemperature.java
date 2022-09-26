package com.rick.problems;

public class RisingTemperature {
}
/*
SELECT weather.id AS 'Id'
FROM weather
        JOIN weather w ON DATEDIFF(weather.date, w.date) = 1
        AND weather.Temperature > w.Temperature
 */