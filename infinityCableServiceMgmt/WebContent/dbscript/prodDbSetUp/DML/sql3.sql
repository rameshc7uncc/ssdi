-- use the db
USE infinityCableServiceDb;

-- drop table if exists
drop table if exists standard;
 
 CREATE TABLE standard
			(c_id	INT			AUTO_INCREMENT   	PRIMARY KEY ,
			 c_name     VARCHAR(100) unique	NOT NULL,
           --  c_description	VARCHAR(250)    	NOT NULL,
             c_price double NOT NULL,
             c_status enum ('Active','Inactive') not null,
             c_HD enum ('Y','N') not null
             );

insert into standard (c_name , c_price, c_status, c_HD)
values ('Flix',3,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('Hallmark',5,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('History',5,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('Movies Now',4,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('Discovery',7,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('National Geographic',5,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('Discovery HD',10,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('National Geographic HD',10,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('universal',7,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('universal HD',10,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('sundance',3,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('Epix',5,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('TWC',4,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('Encore',6,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('HBO',7,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('HBO HD',10,'Active','Y');

insert into standard (c_name , c_price, c_status, c_HD)
values ('Star Movies',7,'Active','N');

insert into standard (c_name , c_price, c_status, c_HD)
values ('Star Movies HD',10,'Active','Y');
