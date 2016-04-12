-- drop db if exists
DROP DATABASE IF EXISTS infinityCableServiceTestDb;
-- create db if does not exists
CREATE DATABASE IF NOT EXISTS infinityCableServiceTestDb;
-- use the db
USE infinityCableServiceTestDb;

-- drop table if exists
drop table if exists user;

-- create user tables
CREATE TABLE user 
			(user_id		INT			AUTO_INCREMENT   	PRIMARY KEY ,
			 first_name     VARCHAR(100) 	NOT NULL,
			 last_name      VARCHAR(100)    	NOT NULL,
             email_address 	VARCHAR(60)    	NOT NULL,
             phone_number LONG NOT NULL,
             address1 VARCHAR(150),
             address2 VARCHAR(150),
             city VARCHAR(35),
             state VARCHAR(35),
             pincode INT,
             password VARCHAR(25) not null,
             role_id enum('Admin','Customer') not null,
             status enum('A','I') not null,
             user_create_date datetime default now() not null) ;


-- drop table if exists
drop table if exists package;
            
-- create Package table
            
CREATE TABLE package
			(p_id		INT			AUTO_INCREMENT   	PRIMARY KEY ,
			 p_name     VARCHAR(100) unique	NOT NULL,
             p_description	VARCHAR(250)    	NOT NULL,
             p_price double NOT NULL,
             p_status enum ('Active','Inactive') not null,
             p_created_date datetime default now(),
             p_deleted_date datetime default null
             );
             
-- drop table if exists
drop table if exists channel;

-- create channel table
 CREATE TABLE channel
			(c_id	INT			AUTO_INCREMENT   	PRIMARY KEY ,
			 c_name     VARCHAR(100) unique	NOT NULL,
           --  c_description	VARCHAR(250)    	NOT NULL,
             c_price double NOT NULL,
             c_status enum ('Active','Inactive') not null,
             c_HD enum ('Y','N') not null
             );
             
-- drop table if exists
drop table if exists package_channel;
             
-- create package-channel table

 CREATE TABLE package_channel
 
			(row_id INT AUTO_INCREMENT PRIMARY KEY,
			 p_id	INT	not null ,
			 c_id  Int not null,
             foreign key (p_id)
				references package(p_id)
                on delete cascade,
             foreign key (c_id)
				references channel(c_id)
             );
             
-- drop table if exists
drop table if exists customer_subscription;             
 -- create customer subscription table
CREATE TABLE customer_subscription 
			(row_id     INT  AUTO_INCREMENT PRIMARY KEY, 
			 user_id	INT NOT NULL,
			 p_id       INT NOT NULL,
             start_date datetime,
             end_date   datetime DEFAULT NULL);
             
-- drop table if exists
drop table if exists customer_feedback;             
 -- create  customer_feedback table

CREATE TABLE customer_feedback 
			(row_id     INT  AUTO_INCREMENT PRIMARY KEY, 
			 user_id	INT NOT NULL,
			 query_type     VARCHAR(100) NOT NULL,
			 query_status enum ('Open','Inprogress','Resolved') not null,
			 start_date datetime,
             end_date   datetime DEFAULT NULL);
             
      