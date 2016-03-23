-- drop db if exists
DROP DATABASE IF EXISTS infinityCableServiceDb;
-- create db if does not exists
CREATE DATABASE IF NOT EXISTS infinityCableServiceDb;
-- use the db
USE infinityCableServiceDb;

-- create tables
CREATE TABLE user 
			(user_id		INT			AUTO_INCREMENT   	PRIMARY KEY ,
			 first_name     VARCHAR(45) 	NOT NULL,
			 last_name      VARCHAR(45)    	NOT NULL,
             email_address 	VARCHAR(30)    	NOT NULL,
             phone_number LONG NOT NULL,
             address1 VARCHAR(45),
             address2 VARCHAR(45),
             city VARCHAR(35),
             state VARCHAR(35),
             pincode INT,
             password VARCHAR(25),
             role_id VARCHAR(10),
             status VARCHAR(10),
             user_create_date VARCHAR(30));
            