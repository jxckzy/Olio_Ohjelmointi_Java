USE currency_db;

SELECT * FROM currency;

SELECT * FROM currency WHERE abbreviation = 'EUR';

SELECT COUNT(*) AS total_currencies FROM currency;

SELECT * FROM currency ORDER BY rate DESC LIMIT 1;