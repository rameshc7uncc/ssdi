-- use the db
USE infinityCableServiceDb;

-- drop table if exists
drop table if exists sports;

 CREATE TABLE sports
			(c_id	INT			AUTO_INCREMENT   	PRIMARY KEY ,
			 c_name     VARCHAR(100) unique	NOT NULL,
           --  c_description	VARCHAR(250)    	NOT NULL,
             c_price double NOT NULL,
             c_status enum ('Active','Inactive') not null,
             c_HD enum ('Y','N') not null
             );

insert into sports (c_name , c_price, c_status, c_HD)
values ('espn',5,'Active','N');

insert into sports (c_name , c_price, c_status, c_HD)
values ('espn HD',8,'Active','Y');

insert into sports (c_name , c_price, c_status, c_HD)
values ('tensports',5,'Active','N');

insert into sports (c_name , c_price, c_status, c_HD)
values ('tensports HD',8,'Active','Y');

insert into sports (c_name , c_price, c_status, c_HD)
values ('foxsports',5,'Active','N');

insert into sports (c_name , c_price, c_status, c_HD)
values ('foxsports HD',8,'Active','Y');

insert into sports (c_name , c_price, c_status, c_HD)
values ('sportsouth',4,'Active','N');

insert into sports (c_name , c_price, c_status, c_HD)
values ('golf sports',3,'Active','N');

insert into sports (c_name , c_price, c_status, c_HD)
values ('NBC',5,'Active','N');

insert into sports (c_name , c_price, c_status, c_HD)
values ('NBC HD',8,'Active','Y');

insert into sports (c_name , c_price, c_status, c_HD)
values ('SEC',3,'Active','N');

insert into sports (c_name , c_price, c_status, c_HD)
values ('BIG TEN',3,'Active','N');

insert into sports (c_name , c_price, c_status, c_HD)
values ('YES',4,'Active','N');

insert into sports (c_name , c_price, c_status, c_HD)
values ('NESN',3,'Active','N');
