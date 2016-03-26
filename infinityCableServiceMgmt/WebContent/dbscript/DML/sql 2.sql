-- use the db
USE infinityCableServiceDb;

-- drop table if exists
drop table if exists Music;

 CREATE TABLE Music 
			(c_id	INT			AUTO_INCREMENT   	PRIMARY KEY ,
			 c_name     VARCHAR(100) unique	NOT NULL,
           --  c_description	VARCHAR(250)    	NOT NULL,
             c_price double NOT NULL,
             c_status enum ('Active','Inactive') not null,
             c_HD enum ('Y','N') not null
             );

insert into music (c_name , c_price, c_status, c_HD)
values ('CMT',3,'Active','N');

insert into music (c_name , c_price, c_status, c_HD)
values ('Music On Demand',5,'Active','N');

insert into music (c_name , c_price, c_status, c_HD)
values ('MTV Live',5,'Active','N');

insert into music (c_name , c_price, c_status, c_HD)
values ('MTV Jams',4,'Active','N');

insert into music (c_name , c_price, c_status, c_HD)
values ('MTV Hits',7,'Active','N');

insert into music (c_name , c_price, c_status, c_HD)
values ('Revolt',5,'Active','N');

insert into music (c_name , c_price, c_status, c_HD)
values ('FM',7,'Active','N');

insert into music (c_name , c_price, c_status, c_HD)
values ('GAC',3,'Active','N');

insert into music (c_name , c_price, c_status, c_HD)
values ('Blue Highways',5,'Active','N');

insert into music (c_name , c_price, c_status, c_HD)
values ('RFD TV',4,'Active','N');

insert into music (c_name , c_price, c_status, c_HD)
values ('MC',6,'Active','N');
