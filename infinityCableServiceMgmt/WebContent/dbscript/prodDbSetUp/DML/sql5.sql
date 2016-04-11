-- use the db
USE infinityCableServiceDb;

-- insert initial mock up data to package table

insert into package ( p_name ,p_description	,p_price ,p_status ,p_created_date ,p_deleted_date )
values ('premium','Includes 10 standard channels and 4 music channels and 2 sports channels','60','Active',now(),null);

insert into package ( p_name ,p_description	,p_price ,p_status ,p_created_date ,p_deleted_date )
values ('standard','Includes 10 channels and 3 month subscription free','25','Active',now(),null);

insert into package ( p_name ,p_description	,p_price ,p_status ,p_created_date ,p_deleted_date )
values ('sports','Includes 10 sport channels ','30','Active',now(),null);

insert into package ( p_name ,p_description	,p_price ,p_status ,p_created_date ,p_deleted_date )
values ('music','Includes 12 music channels','30','Active',now(),null);

-- insert initial mock up data to channel table (Sports channel)

insert into channel (c_name , c_price, c_status, c_HD)
values ('espn',5,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('espn HD',8,'Active','Y');

insert into channel (c_name , c_price, c_status, c_HD)
values ('tensports',5,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('tensports HD',8,'Active','Y');

insert into channel (c_name , c_price, c_status, c_HD)
values ('foxsports',5,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('foxsports HD',8,'Active','Y');

insert into channel (c_name , c_price, c_status, c_HD)
values ('sportsouth',4,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('golf channel',3,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('NBC',5,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('NBC HD',8,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('SEC',3,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('BIG TEN',3,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('YES',4,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('NESN',3,'Active','N');

-- insert initial mock up data to channel table (Music channel)

insert into channel (c_name , c_price, c_status, c_HD)
values ('CMT',3,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('Music On Demand',5,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('MTV Live',5,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('MTV Jams',4,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('MTV Hits',7,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('Revolt',5,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('FM',7,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('GAC',3,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('Blue Highways',5,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('RFD TV',4,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('MC',6,'Active','N');

-- insert initial mock up data to channel table (standard channel)

insert into channel (c_name , c_price, c_status, c_HD)
values ('Flix',3,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('Hallmark',5,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('History',5,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('Movies Now',4,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('Discovery',7,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('National Geographic',5,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('Discovery HD',10,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('National Geographic HD',10,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('universal',7,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('universal HD',10,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('sundance',3,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('Epix',5,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('TWC',4,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('Encore',6,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('HBO',7,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('HBO HD',10,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('Star Movies',7,'Active','N');

insert into channel (c_name , c_price, c_status, c_HD)
values ('Star Movies HD',10,'Active','Y');

-- insert mockup data to package_channel table(standard)

insert into package_channel(p_id,c_id)
select 2,C.c_id from channel C inner join standard S
on C.c_name = S.c_name;

-- insert mockup data to package_channel table(standard)

insert into package_channel(p_id,c_id)
select 3,C.c_id from channel C inner join sports S
on C.c_name = S.c_name;

-- insert mockup data to package_channel table(music)

insert into package_channel(p_id,c_id)
select 4,C.c_id from channel C inner join Music M 
on C.c_name = M.c_name;

-- insert mockup data to package_channel table(premium)

insert into package_channel(p_id,c_id)
select 1,C.c_id from channel C inner join Music M
on C.c_name = M.c_name
limit 2;

insert into package_channel(p_id,c_id)
select 1,C.c_id from channel C inner join Sports S
on C.c_name = S.c_name
limit 4;

insert into package_channel(p_id,c_id)
select 1,C.c_id from channel C inner join Standard S
on C.c_name = S.c_name
limit 10;
