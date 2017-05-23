DROP TABLE pollution_data IF EXISTS;

CREATE TABLE pollution_data  (
    station_code VARCHAR (20),
    station_name TEXT,
    daily_mean INT,
    measuring_method VARCHAR (20),
    first_measuring_date VARCHAR (20),
    recent_measuring_date VARCHAR (20),
    jan INT,
    feb INT,
    mar INT,
    apr INT,
    may INT,
    jun INT,
    jul INT,
    aug INT,
    sep INT,
    oct INT,
    nov INT,
    dec INT,

);
