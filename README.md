"# operation.management" 


###Table DDL

Title,Column 1,Column 2
,IncreaseH,
DataBase,PostgreSQL,
DDL,"CREATE TABLE public.limit_count_history (
uid serial4 NOT NULL,
grp_cd varchar(7) NULL,
status varchar(10) NOT NULL,
start_date varchar(8) NULL,
limit_price varchar(12) NULL,
sms_price float8 NULL,
lms_price float8 NULL,
mms_price float8 NULL,
rmk varchar(200) NULL,
create_dttm timestamptz NULL DEFAULT now(),
CONSTRAINT limit_count_history_pkey PRIMARY KEY (uid)
);",
,,
,,
,,





#### Local docker Db Environment
'''
docker run 
'''
