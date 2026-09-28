DROP DATABASE IF EXISTS currency_db;

CREATE DATABASE currency_db;
USE currency_db;

CREATE TABLE currency (
                          abbreviation VARCHAR(10) PRIMARY KEY,
                          name VARCHAR(50) NOT NULL,
                          rate DOUBLE NOT NULL
);

INSERT INTO currency (abbreviation, name, rate) VALUES
                                                    ('USD', 'US Dollar', 1.00),
                                                    ('EUR', 'Euro', 0.92),
                                                    ('GBP', 'British Pound', 0.79),
                                                    ('JPY', 'Japanese Yen', 155.50),
                                                    ('CAD', 'Canadian Dollar', 1.36),
                                                    ('AUD', 'Australian Dollar', 1.51),
                                                    ('CHF', 'Swiss Franc', 0.91),
                                                    ('UAH', 'Ukrainian Hryvnia', 44.65),
                                                    ('INR', 'Indian Rupee', 83.30);

DROP USER IF EXISTS 'appuser'@'localhost';

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT ON currency_db.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;