-- putting all queries into one stored procedure

-- drop db if exists
DROP DATABASE IF EXISTS infinityCableServiceTestDb;
-- create db if does not exists
CREATE DATABASE IF NOT EXISTS infinityCableServiceTestDb;
-- use the db
USE infinityCableServiceTestDb;

-- creating mockup tables for loading channels from the excel file 
create table starter(channel varchar(200));
create table standard(channel varchar(200));
create table preferred(channel varchar(200));

-- loading data from excel file
LOAD DATA LOCAL INFILE 'C:\\Users\\Ramesh\\Desktop\\starter.xls'
INTO TABLE starter
FIELDS TERMINATED BY '\n'
ESCAPED BY '\\';

LOAD DATA LOCAL INFILE 'C:\\Users\\Ramesh\\Desktop\\standard.xls'
INTO TABLE standard
FIELDS TERMINATED BY '\n'
ESCAPED BY '\\';

LOAD DATA LOCAL INFILE 'C:\\Users\\Ramesh\\Desktop\\preferred.xls'
INTO TABLE preferred
FIELDS TERMINATED BY '\n'
ESCAPED BY '\\';

drop procedure if exists initial_setup ;

DELIMITER //

 CREATE PROCEDURE initial_setup()
   BEGIN


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
             status enum('Active','Inactive') not null,
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


-- inserting package details
-- insert initial mock up data to package table

insert into package ( p_name ,p_description	,p_price ,p_status ,p_created_date ,p_deleted_date )
values ('starter','Includes 20 plus channels','30','Active',now(),null);

insert into package ( p_name ,p_description	,p_price ,p_status ,p_created_date ,p_deleted_date )
values ('standard','Includes 70 plus channels','60','Active',now(),null);

insert into package ( p_name ,p_description	,p_price ,p_status ,p_created_date ,p_deleted_date )
values ('preferred','Includes 130 plus channels ','90','Active',now(),null);

insert into package ( p_name ,p_description	,p_price ,p_status ,p_created_date ,p_deleted_date )
values ('Custom 1','Includes Starter channels plus additonal few standard channels','45','Active',now(),null);

insert into package ( p_name ,p_description	,p_price ,p_status ,p_created_date ,p_deleted_date )
values ('Custom 2','Includes Standard channels plus additonal few preferred channels','75','Active',now(),null);


-- drop table if exists
drop table if exists channel;

-- create channel table
 CREATE TABLE channel
			(c_id	INT			AUTO_INCREMENT   	PRIMARY KEY ,
			 c_name     VARCHAR(100) unique	NOT NULL,
             c_price double NOT NULL default 5,
             c_status enum ('Active','Inactive') not null default 'Active',
             c_HD enum ('Y','N') not null default 'Y'
             );

-- inserting all channels into the channel table
insert into channel (c_name)
select channel from preferred;

-- To remove trailing spaces
UPDATE channel set c_name = TRIM(Replace(Replace(Replace(c_name,'\t',''),'\n',''),'\r',''));

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

-- inserting all mockup channels into the channel table
insert into package_channel (p_id,c_id)
select 1,C.c_id from starter S inner join channel C on C.c_name = S.channel;

insert into package_channel (p_id,c_id)
select 2,C.c_id from standard S inner join channel C on C.c_name = S.channel;

insert into package_channel (p_id,c_id)
select 3,C.c_id from preferred S inner join channel C on C.c_name = S.channel;

             
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
             
-- create payment table
create table payment
			(row_id int primary key auto_increment,
			user_id long,
			billing_date datetime,
			bill_amount double,
			payment_date datetime default null,
			payment_status enum ('Paid','Unpaid') default 'Unpaid'
			);
            
-- create custom package table
create table custom_package
(
user_id int not null,
p_id int not null,
c_id int not null
);

   END //

 DELIMITER ;

-- creating procedure to load 105 data

drop procedure if exists insert_users ;

DELIMITER //

 CREATE PROCEDURE insert_users(no_of_users int)
   BEGIN
   declare user_count int;
   set user_count = 1;
    
    while (user_count <= (no_of_users -30) ) 
		do
		insert into user(first_name,last_name,email_address,phone_number,pincode,password,role_id,status,user_create_date) 
		values('Cfirstname','Clastname','customer@uncc.edu','7049536205',28262,'customer','customer','Active',now());
		set user_count = user_count +1;
	end while;
    
    while (user_count <= no_of_users) 
    do
    
		insert into user(first_name,last_name,email_address,phone_number,pincode,password,role_id,status,user_create_date) 
		values('Cfirstname','Clastname','customer@uncc.edu','7049536205',28262,'customer','customer','Inactive',now());
		set user_count = user_count +1;
	END while;

		insert into user(first_name,last_name,email_address,phone_number,pincode,password,role_id,status,user_create_date) 
		values('Ramesh','Chelliah','rchellia@uncc.edu','7049536205',28262,'Valliammal@7god','Admin','Active',now());

		insert into user(first_name,last_name,email_address,phone_number,pincode,password,role_id,status,user_create_date) 
		values('Divya Lakshmi','Rani Kuppusamy','dranikup@uncc.edu','7049075711',28262,'Divya@20','Admin','Active',now());

		insert into user(first_name,last_name,email_address,phone_number,pincode,password,role_id,status,user_create_date) 
		values('lakshmi','Sridhar','lsridhar@uncc.edu','7049536205',28262,'Summer100','Admin','Active',now());


   END //

 DELIMITER ;
 
 
 -- procedure to load the payment details
 
 drop procedure if exists insert_subscription_payment ;

DELIMITER //

 CREATE PROCEDURE insert_subscription_payment()
   BEGIN
   declare user_count int;
   set user_count = 1;
    
    while (user_count <= 30 ) do
        insert into customer_subscription(user_id,p_id ,start_date,end_date ) select user_count,1,'20160301','20160331';
        insert into payment(user_id,billing_date,bill_amount,payment_date,payment_status) select user_count,'20160322',30,'20160330','Paid' ;
        insert into customer_subscription(user_id,p_id ,start_date ) select user_count,1,'20160401';
        insert into payment(user_id,billing_date,bill_amount,payment_status) select user_count,'20160422',30,'Unpaid' ;
		set user_count = user_count +1;
	end while;
    
    while (user_count <= 110) do
        insert into customer_subscription(user_id,p_id ,start_date,end_date ) select user_count,2,'20160301','20160331';
        insert into payment(user_id,billing_date,bill_amount,payment_date,payment_status) select user_count,'20160322',60,'20160330','Paid' ;
        insert into customer_subscription(user_id,p_id ,start_date ) select user_count,2,'20160401';
        insert into payment(user_id,billing_date,bill_amount,payment_status) select user_count,'20160422',60,'Unpaid' ;
        set user_count = user_count +1;
	END while;
    
    while (user_count <= 170) do
        insert into customer_subscription(user_id,p_id ,start_date,end_date ) select user_count,3,'20160301','20160331';
        insert into payment(user_id,billing_date,bill_amount,payment_date,payment_status) select user_count,'20160322',90,'20160330','Paid' ;
        insert into customer_subscription(user_id,p_id ,start_date ) select user_count,3,'20160401';
        set user_count = user_count +1;
	END while;
    
    while (user_count <=200 ) do
        insert into customer_subscription(user_id,p_id ,start_date,end_date ) select user_count,2,'20160301','20160331';
        set user_count = user_count +1;
	END while; 

   END //

 DELIMITER ;
 
  -- procedure call to set up the initial database 
 call initial_setup();

 -- procedure call to load the data 
 call insert_users(200);
 
 -- procedure call to load the data 
 call insert_subscription_payment();
