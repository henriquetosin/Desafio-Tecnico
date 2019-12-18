CREATE TABLE Country (
    country_id   INTEGER      NOT NULL AUTO_INCREMENT,
    name 		 VARCHAR(100) NOT NULL, 
    PRIMARY KEY (country_id)
);

CREATE TABLE City (
    city_id   	INTEGER      NOT NULL AUTO_INCREMENT,
    name 	   VARCHAR(100)	 NOT NULL,
    country_id INTEGER 		 NOT NULL,
    PRIMARY KEY (city_id)
);

ALTER TABLE City ADD CONSTRAINT fk_contry FOREIGN KEY (country_id) REFERENCES Country (country_id);

