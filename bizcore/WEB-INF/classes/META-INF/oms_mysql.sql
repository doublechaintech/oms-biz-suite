-- BUILD WITH MODEL TIME 190129T1230
drop database  if exists oms;
create database oms;
alter  database oms  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use oms;

drop table  if exists platform_data;
create table platform_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(92)                              comment 'Name',
	introduction        	varchar(288)                             comment 'Introduction',
	current_version     	varchar(16)                              comment 'Current Version',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists profile_data;
create table profile_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(72)                              comment 'Name',
	age                 	int                                      comment 'Age',
	gender              	varchar(24)                              comment 'Gender',
	last_update_time    	datetime                                 comment 'Last Update Time',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_order_data;
create table user_order_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(64)                              comment 'Title',
	total_adjustment    	numeric(7,2)                             comment 'Total Adjustment',
	total_amount        	numeric(9,2)                             comment 'Total Amount',
	user                	varchar(48)                              comment 'User',
	platform            	varchar(48)                              comment 'Platform',
	last_update_time    	datetime                                 comment 'Last Update Time',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists line_item_data;
create table line_item_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(52)                              comment 'Name',
	quantity            	int                                      comment 'Quantity',
	price               	numeric(7,2)                             comment 'Price',
	discount_price      	numeric(6,2)                             comment 'Discount Price',
	user_order          	varchar(48)                              comment 'User Order',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists order_promotion_data;
create table order_promotion_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(60)                              comment 'Name',
	amount              	int                                      comment 'Amount',
	thread_hold         	int                                      comment 'Thread Hold',
	type                	varchar(44)                              comment 'Type',
	user_order          	varchar(48)                              comment 'User Order',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists manual_adjustment_data;
create table manual_adjustment_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(60)                              comment 'Name',
	amount              	int                                      comment 'Amount',
	thread_hold         	int                                      comment 'Thread Hold',
	type                	varchar(36)                              comment 'Type',
	user_order          	varchar(48)                              comment 'User Order',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists shipping_group_data;
create table shipping_group_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(48)                              comment 'Name',
	line1               	varchar(100)                             comment 'Line1',
	line2               	varchar(48)                              comment 'Line2',
	city                	varchar(60)                              comment 'City',
	state               	varchar(8)                               comment 'State',
	zip_code            	int                                      comment 'Zip Code',
	country             	varchar(8)                               comment 'Country',
	user_order          	varchar(48)                              comment 'User Order',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists payment_group_data;
create table payment_group_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(52)                              comment 'Name',
	amount              	numeric(7,2)                             comment 'Amount',
	user_order          	varchar(48)                              comment 'User Order',
	status              	varchar(28)                              comment 'Status',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_domain_data;
create table user_domain_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(16)                              comment 'Name',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                  	varchar(64)          not null            comment 'Id',
	user_identity       	varchar(40)                              comment 'User Identity',
	user_special_functions	varchar(200)                             comment 'User Special Functions',
	domain              	varchar(48)                              comment 'Domain',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sec_user_data;
create table sec_user_data (
	id                  	varchar(64)          not null            comment 'Id',
	login               	varchar(20)                              comment 'Login',
	mobile              	varchar(11)                              comment 'Mobile',
	email               	varchar(76)                              comment 'Email',
	pwd                 	varchar(64)                              comment 'Pwd',
	verification_code   	int                                      comment 'Verification Code',
	verification_code_expire	datetime                                 comment 'Verification Code Expire',
	last_login_time     	datetime                                 comment 'Last Login Time',
	domain              	varchar(48)                              comment 'Domain',
	blocking            	varchar(48)                              comment 'Blocking',
	current_status      	varchar(28)                              comment 'Current Status',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
	id                  	varchar(64)          not null            comment 'Id',
	who                 	varchar(52)                              comment 'Who',
	block_time          	datetime                                 comment 'Block Time',
	comments            	varchar(96)                              comment 'Comments',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_app_data;
create table user_app_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(300)                             comment 'Title',
	sec_user            	varchar(48)                              comment 'Sec User',
	app_icon            	varchar(36)                              comment 'App Icon',
	full_access         	tinyint                                  comment 'Full Access',
	permission          	varchar(16)                              comment 'Permission',
	object_type         	varchar(108)                             comment 'Object Type',
	object_id           	varchar(40)                              comment 'Object Id',
	location            	varchar(48)                              comment 'Location',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists list_access_data;
create table list_access_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(200)                             comment 'Name',
	internal_name       	varchar(200)                             comment 'Internal Name',
	read_permission     	tinyint                                  comment 'Read Permission',
	create_permission   	tinyint                                  comment 'Create Permission',
	delete_permission   	tinyint                                  comment 'Delete Permission',
	update_permission   	tinyint                                  comment 'Update Permission',
	execution_permission	tinyint                                  comment 'Execution Permission',
	app                 	varchar(48)                              comment 'App',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists object_access_data;
create table object_access_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(28)                              comment 'Name',
	object_type         	varchar(112)                             comment 'Object Type',
	list1               	varchar(80)                              comment 'List1',
	list2               	varchar(80)                              comment 'List2',
	list3               	varchar(80)                              comment 'List3',
	list4               	varchar(80)                              comment 'List4',
	list5               	varchar(80)                              comment 'List5',
	list6               	varchar(80)                              comment 'List6',
	list7               	varchar(80)                              comment 'List7',
	list8               	varchar(80)                              comment 'List8',
	list9               	varchar(80)                              comment 'List9',
	app                 	varchar(48)                              comment 'App',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists login_history_data;
create table login_history_data (
	id                  	varchar(64)          not null            comment 'Id',
	login_time          	datetime                                 comment 'Login Time',
	from_ip             	varchar(44)                              comment 'From Ip',
	description         	varchar(16)                              comment 'Description',
	sec_user            	varchar(48)                              comment 'Sec User',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists generic_form_data;
create table generic_form_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(20)                              comment 'Title',
	description         	varchar(48)                              comment 'Description',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_message_data;
create table form_message_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(24)                              comment 'Title',
	form                	varchar(48)                              comment 'Form',
	level               	varchar(28)                              comment 'Level',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(16)                              comment 'Title',
	parameter_name      	varchar(16)                              comment 'Parameter Name',
	form                	varchar(48)                              comment 'Form',
	level               	varchar(28)                              comment 'Level',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_field_data;
create table form_field_data (
	id                  	varchar(64)          not null            comment 'Id',
	label               	varchar(12)                              comment 'Label',
	locale_key          	varchar(44)                              comment 'Locale Key',
	parameter_name      	varchar(16)                              comment 'Parameter Name',
	type                	varchar(36)                              comment 'Type',
	form                	varchar(48)                              comment 'Form',
	placeholder         	varchar(48)                              comment 'Placeholder',
	default_value       	varchar(12)                              comment 'Default Value',
	description         	varchar(48)                              comment 'Description',
	field_group         	varchar(16)                              comment 'Field Group',
	minimum_value       	varchar(60)                              comment 'Minimum Value',
	maximum_value       	varchar(72)                              comment 'Maximum Value',
	required            	tinyint                                  comment 'Required',
	disabled            	tinyint                                  comment 'Disabled',
	custom_rendering    	tinyint                                  comment 'Custom Rendering',
	candidate_values    	varchar(12)                              comment 'Candidate Values',
	suggest_values      	varchar(12)                              comment 'Suggest Values',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_action_data;
create table form_action_data (
	id                  	varchar(64)          not null            comment 'Id',
	label               	varchar(8)                               comment 'Label',
	locale_key          	varchar(16)                              comment 'Locale Key',
	action_key          	varchar(24)                              comment 'Action Key',
	level               	varchar(28)                              comment 'Level',
	url                 	varchar(168)                             comment 'Url',
	form                	varchar(48)                              comment 'Form',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;






	
insert into platform_data values ('P000001','Chain eComerce Platform','new generation of eCommerce platform based on opensource and modern tech','V1.0','1');

	
insert into profile_data values ('P000001','Philip Zhang','31','male','2019-02-14 16:39:02','P000001','1');
insert into profile_data values ('P000002','Naveen Kumar R ','35','female','2019-02-06 01:03:06','P000001','1');
insert into profile_data values ('P000003','VENKATESH GADUPUTI','31','male','2019-02-19 12:18:35','P000001','1');
insert into profile_data values ('P000004','Philip Zhang','39','female','2019-02-17 03:31:11','P000001','1');
insert into profile_data values ('P000005','Naveen Kumar R ','32','male','2019-02-06 09:07:26','P000001','1');

	
insert into user_order_data values ('UO000001','a consumer order','70.76','7112.92','P000001','P000001','2019-02-10 23:24:05','1');
insert into user_order_data values ('UO000002','a consumer order0002','79.92','9973.30','P000001','P000001','2019-02-13 13:50:58','1');
insert into user_order_data values ('UO000003','a consumer order0003','76.38','9490.77','P000001','P000001','2019-02-21 10:13:50','1');
insert into user_order_data values ('UO000004','a consumer order0004','97.32','8686.33','P000001','P000001','2019-02-10 20:11:40','1');
insert into user_order_data values ('UO000005','a consumer order0005','81.67','7945.81','P000001','P000001','2019-02-05 15:57:33','1');
insert into user_order_data values ('UO000006','a consumer order0006','87.65','7271.13','P000002','P000001','2019-02-07 10:10:54','1');
insert into user_order_data values ('UO000007','a consumer order0007','75.67','9977.56','P000002','P000001','2019-02-11 16:36:30','1');
insert into user_order_data values ('UO000008','a consumer order0008','74.09','9702.71','P000002','P000001','2019-02-13 02:09:49','1');
insert into user_order_data values ('UO000009','a consumer order0009','77.76','9401.90','P000002','P000001','2019-02-04 07:48:08','1');
insert into user_order_data values ('UO000010','a consumer order0010','81.43','9218.70','P000002','P000001','2019-02-16 16:56:41','1');
insert into user_order_data values ('UO000011','a consumer order0011','94.94','7702.15','P000003','P000001','2019-02-10 16:44:29','1');
insert into user_order_data values ('UO000012','a consumer order0012','84.17','9175.81','P000003','P000001','2019-02-03 16:29:41','1');
insert into user_order_data values ('UO000013','a consumer order0013','99.00','9494.20','P000003','P000001','2019-02-10 10:23:57','1');
insert into user_order_data values ('UO000014','a consumer order0014','83.27','9599.22','P000003','P000001','2019-02-08 06:43:20','1');
insert into user_order_data values ('UO000015','a consumer order0015','82.75','7231.88','P000003','P000001','2019-02-18 21:24:05','1');
insert into user_order_data values ('UO000016','a consumer order0016','90.72','7338.52','P000004','P000001','2019-02-11 08:27:28','1');
insert into user_order_data values ('UO000017','a consumer order0017','93.54','7117.69','P000004','P000001','2019-02-08 03:36:28','1');
insert into user_order_data values ('UO000018','a consumer order0018','73.59','9706.08','P000004','P000001','2019-02-06 23:21:18','1');
insert into user_order_data values ('UO000019','a consumer order0019','87.11','7596.88','P000004','P000001','2019-02-02 09:33:43','1');
insert into user_order_data values ('UO000020','a consumer order0020','94.40','9793.55','P000004','P000001','2019-02-06 20:27:27','1');
insert into user_order_data values ('UO000021','a consumer order0021','80.38','8155.43','P000005','P000001','2019-02-04 17:29:53','1');
insert into user_order_data values ('UO000022','a consumer order0022','93.86','9041.62','P000005','P000001','2019-02-03 18:21:22','1');
insert into user_order_data values ('UO000023','a consumer order0023','97.20','8033.31','P000005','P000001','2019-02-17 10:43:27','1');
insert into user_order_data values ('UO000024','a consumer order0024','83.54','9453.55','P000005','P000001','2019-02-07 07:47:43','1');
insert into user_order_data values ('UO000025','a consumer order0025','78.35','9299.60','P000005','P000001','2019-02-03 18:30:59','1');

	
insert into line_item_data values ('LI000001','Jeans - Large','10','81.24','9.43','UO000001','1');
insert into line_item_data values ('LI000002','Jeans - Large0002','10','76.00','9.32','UO000001','1');
insert into line_item_data values ('LI000003','Jeans - Large0003','10','99.75','8.62','UO000001','1');
insert into line_item_data values ('LI000004','Jeans - Large0004','10','99.10','8.27','UO000001','1');
insert into line_item_data values ('LI000005','Jeans - Large0005','10','93.47','10.13','UO000001','1');
insert into line_item_data values ('LI000006','Jeans - Large0006','10','80.96','7.94','UO000002','1');
insert into line_item_data values ('LI000007','Jeans - Large0007','12','94.12','7.78','UO000002','1');
insert into line_item_data values ('LI000008','Jeans - Large0008','9','89.62','7.74','UO000002','1');
insert into line_item_data values ('LI000009','Jeans - Large0009','12','85.16','9.03','UO000002','1');
insert into line_item_data values ('LI000010','Jeans - Large0010','12','87.76','10.35','UO000002','1');
insert into line_item_data values ('LI000011','Jeans - Large0011','11','88.47','10.65','UO000003','1');
insert into line_item_data values ('LI000012','Jeans - Large0012','12','81.93','8.12','UO000003','1');
insert into line_item_data values ('LI000013','Jeans - Large0013','11','88.34','10.75','UO000003','1');
insert into line_item_data values ('LI000014','Jeans - Large0014','12','100.90','8.92','UO000003','1');
insert into line_item_data values ('LI000015','Jeans - Large0015','12','99.97','9.99','UO000003','1');
insert into line_item_data values ('LI000016','Jeans - Large0016','11','92.75','8.14','UO000004','1');
insert into line_item_data values ('LI000017','Jeans - Large0017','11','73.97','9.10','UO000004','1');
insert into line_item_data values ('LI000018','Jeans - Large0018','10','90.33','7.77','UO000004','1');
insert into line_item_data values ('LI000019','Jeans - Large0019','9','74.02','10.18','UO000004','1');
insert into line_item_data values ('LI000020','Jeans - Large0020','10','82.95','7.89','UO000004','1');
insert into line_item_data values ('LI000021','Jeans - Large0021','11','83.73','7.75','UO000005','1');
insert into line_item_data values ('LI000022','Jeans - Large0022','12','85.41','8.77','UO000005','1');
insert into line_item_data values ('LI000023','Jeans - Large0023','11','86.62','8.44','UO000005','1');
insert into line_item_data values ('LI000024','Jeans - Large0024','10','90.94','8.06','UO000005','1');
insert into line_item_data values ('LI000025','Jeans - Large0025','12','102.96','10.25','UO000005','1');
insert into line_item_data values ('LI000026','Jeans - Large0026','10','86.14','10.46','UO000006','1');
insert into line_item_data values ('LI000027','Jeans - Large0027','11','91.59','9.53','UO000006','1');
insert into line_item_data values ('LI000028','Jeans - Large0028','9','93.70','10.58','UO000006','1');
insert into line_item_data values ('LI000029','Jeans - Large0029','11','86.84','9.12','UO000006','1');
insert into line_item_data values ('LI000030','Jeans - Large0030','11','84.44','10.03','UO000006','1');
insert into line_item_data values ('LI000031','Jeans - Large0031','10','75.98','9.50','UO000007','1');
insert into line_item_data values ('LI000032','Jeans - Large0032','9','98.72','9.22','UO000007','1');
insert into line_item_data values ('LI000033','Jeans - Large0033','11','86.78','9.47','UO000007','1');
insert into line_item_data values ('LI000034','Jeans - Large0034','10','96.34','7.88','UO000007','1');
insert into line_item_data values ('LI000035','Jeans - Large0035','10','91.36','8.07','UO000007','1');
insert into line_item_data values ('LI000036','Jeans - Large0036','10','76.34','8.32','UO000008','1');
insert into line_item_data values ('LI000037','Jeans - Large0037','12','99.49','9.32','UO000008','1');
insert into line_item_data values ('LI000038','Jeans - Large0038','10','93.37','8.63','UO000008','1');
insert into line_item_data values ('LI000039','Jeans - Large0039','10','88.68','8.57','UO000008','1');
insert into line_item_data values ('LI000040','Jeans - Large0040','11','79.18','9.75','UO000008','1');
insert into line_item_data values ('LI000041','Jeans - Large0041','10','95.71','9.12','UO000009','1');
insert into line_item_data values ('LI000042','Jeans - Large0042','12','87.83','8.81','UO000009','1');
insert into line_item_data values ('LI000043','Jeans - Large0043','9','99.38','10.85','UO000009','1');
insert into line_item_data values ('LI000044','Jeans - Large0044','11','80.48','8.09','UO000009','1');
insert into line_item_data values ('LI000045','Jeans - Large0045','9','84.87','7.74','UO000009','1');
insert into line_item_data values ('LI000046','Jeans - Large0046','9','75.46','9.04','UO000010','1');
insert into line_item_data values ('LI000047','Jeans - Large0047','9','98.77','9.80','UO000010','1');
insert into line_item_data values ('LI000048','Jeans - Large0048','9','96.00','8.45','UO000010','1');
insert into line_item_data values ('LI000049','Jeans - Large0049','12','74.29','8.69','UO000010','1');
insert into line_item_data values ('LI000050','Jeans - Large0050','11','77.60','8.68','UO000010','1');
insert into line_item_data values ('LI000051','Jeans - Large0051','10','91.46','10.81','UO000011','1');
insert into line_item_data values ('LI000052','Jeans - Large0052','12','78.52','9.82','UO000011','1');
insert into line_item_data values ('LI000053','Jeans - Large0053','11','78.53','9.78','UO000011','1');
insert into line_item_data values ('LI000054','Jeans - Large0054','9','83.34','9.09','UO000011','1');
insert into line_item_data values ('LI000055','Jeans - Large0055','11','94.11','9.58','UO000011','1');
insert into line_item_data values ('LI000056','Jeans - Large0056','12','93.25','10.22','UO000012','1');
insert into line_item_data values ('LI000057','Jeans - Large0057','12','91.92','10.95','UO000012','1');
insert into line_item_data values ('LI000058','Jeans - Large0058','12','93.91','7.89','UO000012','1');
insert into line_item_data values ('LI000059','Jeans - Large0059','12','92.96','10.17','UO000012','1');
insert into line_item_data values ('LI000060','Jeans - Large0060','11','100.72','8.66','UO000012','1');
insert into line_item_data values ('LI000061','Jeans - Large0061','10','81.53','10.17','UO000013','1');
insert into line_item_data values ('LI000062','Jeans - Large0062','9','78.25','8.73','UO000013','1');
insert into line_item_data values ('LI000063','Jeans - Large0063','10','86.93','10.55','UO000013','1');
insert into line_item_data values ('LI000064','Jeans - Large0064','9','81.14','9.88','UO000013','1');
insert into line_item_data values ('LI000065','Jeans - Large0065','9','95.19','10.36','UO000013','1');
insert into line_item_data values ('LI000066','Jeans - Large0066','11','98.69','7.83','UO000014','1');
insert into line_item_data values ('LI000067','Jeans - Large0067','11','82.62','9.53','UO000014','1');
insert into line_item_data values ('LI000068','Jeans - Large0068','9','100.56','9.76','UO000014','1');
insert into line_item_data values ('LI000069','Jeans - Large0069','12','76.83','10.66','UO000014','1');
insert into line_item_data values ('LI000070','Jeans - Large0070','9','87.95','10.17','UO000014','1');
insert into line_item_data values ('LI000071','Jeans - Large0071','9','97.05','9.37','UO000015','1');
insert into line_item_data values ('LI000072','Jeans - Large0072','10','77.39','10.00','UO000015','1');
insert into line_item_data values ('LI000073','Jeans - Large0073','10','101.66','10.52','UO000015','1');
insert into line_item_data values ('LI000074','Jeans - Large0074','10','91.42','9.32','UO000015','1');
insert into line_item_data values ('LI000075','Jeans - Large0075','9','74.23','8.88','UO000015','1');
insert into line_item_data values ('LI000076','Jeans - Large0076','11','85.37','10.08','UO000016','1');
insert into line_item_data values ('LI000077','Jeans - Large0077','11','100.44','10.41','UO000016','1');
insert into line_item_data values ('LI000078','Jeans - Large0078','12','101.14','9.17','UO000016','1');
insert into line_item_data values ('LI000079','Jeans - Large0079','11','91.33','10.01','UO000016','1');
insert into line_item_data values ('LI000080','Jeans - Large0080','10','72.34','8.77','UO000016','1');
insert into line_item_data values ('LI000081','Jeans - Large0081','11','98.40','10.18','UO000017','1');
insert into line_item_data values ('LI000082','Jeans - Large0082','11','81.83','7.97','UO000017','1');
insert into line_item_data values ('LI000083','Jeans - Large0083','12','93.31','10.38','UO000017','1');
insert into line_item_data values ('LI000084','Jeans - Large0084','10','81.78','9.84','UO000017','1');
insert into line_item_data values ('LI000085','Jeans - Large0085','12','74.81','9.76','UO000017','1');
insert into line_item_data values ('LI000086','Jeans - Large0086','10','76.93','9.28','UO000018','1');
insert into line_item_data values ('LI000087','Jeans - Large0087','12','102.69','10.89','UO000018','1');
insert into line_item_data values ('LI000088','Jeans - Large0088','9','93.67','8.44','UO000018','1');
insert into line_item_data values ('LI000089','Jeans - Large0089','11','75.16','9.60','UO000018','1');
insert into line_item_data values ('LI000090','Jeans - Large0090','11','74.38','9.60','UO000018','1');
insert into line_item_data values ('LI000091','Jeans - Large0091','11','98.24','8.90','UO000019','1');
insert into line_item_data values ('LI000092','Jeans - Large0092','12','84.73','9.84','UO000019','1');
insert into line_item_data values ('LI000093','Jeans - Large0093','12','93.22','10.25','UO000019','1');
insert into line_item_data values ('LI000094','Jeans - Large0094','11','100.35','11.02','UO000019','1');
insert into line_item_data values ('LI000095','Jeans - Large0095','9','95.05','9.21','UO000019','1');
insert into line_item_data values ('LI000096','Jeans - Large0096','10','98.18','8.42','UO000020','1');
insert into line_item_data values ('LI000097','Jeans - Large0097','10','88.93','8.35','UO000020','1');
insert into line_item_data values ('LI000098','Jeans - Large0098','10','76.22','8.83','UO000020','1');
insert into line_item_data values ('LI000099','Jeans - Large0099','9','72.83','8.51','UO000020','1');
insert into line_item_data values ('LI000100','Jeans - Large0100','9','100.22','9.31','UO000020','1');
insert into line_item_data values ('LI000101','Jeans - Large0101','11','74.56','10.27','UO000021','1');
insert into line_item_data values ('LI000102','Jeans - Large0102','11','89.36','9.33','UO000021','1');
insert into line_item_data values ('LI000103','Jeans - Large0103','10','91.10','9.02','UO000021','1');
insert into line_item_data values ('LI000104','Jeans - Large0104','12','90.76','8.96','UO000021','1');
insert into line_item_data values ('LI000105','Jeans - Large0105','9','94.51','8.07','UO000021','1');
insert into line_item_data values ('LI000106','Jeans - Large0106','9','101.86','8.74','UO000022','1');
insert into line_item_data values ('LI000107','Jeans - Large0107','9','76.99','9.28','UO000022','1');
insert into line_item_data values ('LI000108','Jeans - Large0108','11','75.45','8.44','UO000022','1');
insert into line_item_data values ('LI000109','Jeans - Large0109','12','79.86','10.67','UO000022','1');
insert into line_item_data values ('LI000110','Jeans - Large0110','12','88.38','9.11','UO000022','1');
insert into line_item_data values ('LI000111','Jeans - Large0111','10','83.04','8.43','UO000023','1');
insert into line_item_data values ('LI000112','Jeans - Large0112','12','90.12','10.82','UO000023','1');
insert into line_item_data values ('LI000113','Jeans - Large0113','9','102.12','9.63','UO000023','1');
insert into line_item_data values ('LI000114','Jeans - Large0114','11','77.82','9.68','UO000023','1');
insert into line_item_data values ('LI000115','Jeans - Large0115','11','96.50','11.02','UO000023','1');
insert into line_item_data values ('LI000116','Jeans - Large0116','11','88.96','8.82','UO000024','1');
insert into line_item_data values ('LI000117','Jeans - Large0117','12','101.83','8.07','UO000024','1');
insert into line_item_data values ('LI000118','Jeans - Large0118','12','74.88','8.05','UO000024','1');
insert into line_item_data values ('LI000119','Jeans - Large0119','12','73.05','10.37','UO000024','1');
insert into line_item_data values ('LI000120','Jeans - Large0120','10','78.54','8.84','UO000024','1');
insert into line_item_data values ('LI000121','Jeans - Large0121','10','72.37','9.95','UO000025','1');
insert into line_item_data values ('LI000122','Jeans - Large0122','10','99.64','10.41','UO000025','1');
insert into line_item_data values ('LI000123','Jeans - Large0123','12','80.89','9.68','UO000025','1');
insert into line_item_data values ('LI000124','Jeans - Large0124','12','84.59','10.89','UO000025','1');
insert into line_item_data values ('LI000125','Jeans - Large0125','12','78.00','8.63','UO000025','1');

	
insert into order_promotion_data values ('OP000001','Promo For Total','1034','986','PERCENT_OFF','UO000001','1');
insert into order_promotion_data values ('OP000002','Promo For Total0002','1220','933','FIX_PRICE','UO000001','1');
insert into order_promotion_data values ('OP000003','Promo For Total0003','1054','1227','PERCENT_OFF','UO000001','1');
insert into order_promotion_data values ('OP000004','Promo For Total0004','1194','1147','FIX_PRICE','UO000001','1');
insert into order_promotion_data values ('OP000005','Promo For Total0005','1048','1130','PERCENT_OFF','UO000001','1');
insert into order_promotion_data values ('OP000006','Promo For Total0006','1125','1037','FIX_PRICE','UO000002','1');
insert into order_promotion_data values ('OP000007','Promo For Total0007','1122','1132','PERCENT_OFF','UO000002','1');
insert into order_promotion_data values ('OP000008','Promo For Total0008','1213','930','FIX_PRICE','UO000002','1');
insert into order_promotion_data values ('OP000009','Promo For Total0009','1047','909','PERCENT_OFF','UO000002','1');
insert into order_promotion_data values ('OP000010','Promo For Total0010','971','1119','FIX_PRICE','UO000002','1');
insert into order_promotion_data values ('OP000011','Promo For Total0011','1120','994','PERCENT_OFF','UO000003','1');
insert into order_promotion_data values ('OP000012','Promo For Total0012','1165','932','FIX_PRICE','UO000003','1');
insert into order_promotion_data values ('OP000013','Promo For Total0013','867','919','PERCENT_OFF','UO000003','1');
insert into order_promotion_data values ('OP000014','Promo For Total0014','1090','870','FIX_PRICE','UO000003','1');
insert into order_promotion_data values ('OP000015','Promo For Total0015','1184','919','PERCENT_OFF','UO000003','1');
insert into order_promotion_data values ('OP000016','Promo For Total0016','965','899','FIX_PRICE','UO000004','1');
insert into order_promotion_data values ('OP000017','Promo For Total0017','945','1030','PERCENT_OFF','UO000004','1');
insert into order_promotion_data values ('OP000018','Promo For Total0018','1021','1073','FIX_PRICE','UO000004','1');
insert into order_promotion_data values ('OP000019','Promo For Total0019','1184','1201','PERCENT_OFF','UO000004','1');
insert into order_promotion_data values ('OP000020','Promo For Total0020','954','1075','FIX_PRICE','UO000004','1');
insert into order_promotion_data values ('OP000021','Promo For Total0021','1229','1018','PERCENT_OFF','UO000005','1');
insert into order_promotion_data values ('OP000022','Promo For Total0022','970','1075','FIX_PRICE','UO000005','1');
insert into order_promotion_data values ('OP000023','Promo For Total0023','937','1196','PERCENT_OFF','UO000005','1');
insert into order_promotion_data values ('OP000024','Promo For Total0024','1002','1212','FIX_PRICE','UO000005','1');
insert into order_promotion_data values ('OP000025','Promo For Total0025','915','1126','PERCENT_OFF','UO000005','1');
insert into order_promotion_data values ('OP000026','Promo For Total0026','1002','1025','FIX_PRICE','UO000006','1');
insert into order_promotion_data values ('OP000027','Promo For Total0027','885','1066','PERCENT_OFF','UO000006','1');
insert into order_promotion_data values ('OP000028','Promo For Total0028','1163','1053','FIX_PRICE','UO000006','1');
insert into order_promotion_data values ('OP000029','Promo For Total0029','943','930','PERCENT_OFF','UO000006','1');
insert into order_promotion_data values ('OP000030','Promo For Total0030','875','1092','FIX_PRICE','UO000006','1');
insert into order_promotion_data values ('OP000031','Promo For Total0031','1222','1230','PERCENT_OFF','UO000007','1');
insert into order_promotion_data values ('OP000032','Promo For Total0032','1016','907','FIX_PRICE','UO000007','1');
insert into order_promotion_data values ('OP000033','Promo For Total0033','1084','1107','PERCENT_OFF','UO000007','1');
insert into order_promotion_data values ('OP000034','Promo For Total0034','1097','1168','FIX_PRICE','UO000007','1');
insert into order_promotion_data values ('OP000035','Promo For Total0035','1061','915','PERCENT_OFF','UO000007','1');
insert into order_promotion_data values ('OP000036','Promo For Total0036','1004','1172','FIX_PRICE','UO000008','1');
insert into order_promotion_data values ('OP000037','Promo For Total0037','1096','1121','PERCENT_OFF','UO000008','1');
insert into order_promotion_data values ('OP000038','Promo For Total0038','928','1202','FIX_PRICE','UO000008','1');
insert into order_promotion_data values ('OP000039','Promo For Total0039','981','1152','PERCENT_OFF','UO000008','1');
insert into order_promotion_data values ('OP000040','Promo For Total0040','876','1072','FIX_PRICE','UO000008','1');
insert into order_promotion_data values ('OP000041','Promo For Total0041','943','914','PERCENT_OFF','UO000009','1');
insert into order_promotion_data values ('OP000042','Promo For Total0042','1086','1065','FIX_PRICE','UO000009','1');
insert into order_promotion_data values ('OP000043','Promo For Total0043','1111','881','PERCENT_OFF','UO000009','1');
insert into order_promotion_data values ('OP000044','Promo For Total0044','941','1206','FIX_PRICE','UO000009','1');
insert into order_promotion_data values ('OP000045','Promo For Total0045','867','928','PERCENT_OFF','UO000009','1');
insert into order_promotion_data values ('OP000046','Promo For Total0046','1174','993','FIX_PRICE','UO000010','1');
insert into order_promotion_data values ('OP000047','Promo For Total0047','876','937','PERCENT_OFF','UO000010','1');
insert into order_promotion_data values ('OP000048','Promo For Total0048','1061','1121','FIX_PRICE','UO000010','1');
insert into order_promotion_data values ('OP000049','Promo For Total0049','919','981','PERCENT_OFF','UO000010','1');
insert into order_promotion_data values ('OP000050','Promo For Total0050','875','990','FIX_PRICE','UO000010','1');
insert into order_promotion_data values ('OP000051','Promo For Total0051','871','1044','PERCENT_OFF','UO000011','1');
insert into order_promotion_data values ('OP000052','Promo For Total0052','1051','1109','FIX_PRICE','UO000011','1');
insert into order_promotion_data values ('OP000053','Promo For Total0053','935','984','PERCENT_OFF','UO000011','1');
insert into order_promotion_data values ('OP000054','Promo For Total0054','1021','1128','FIX_PRICE','UO000011','1');
insert into order_promotion_data values ('OP000055','Promo For Total0055','974','1113','PERCENT_OFF','UO000011','1');
insert into order_promotion_data values ('OP000056','Promo For Total0056','929','1122','FIX_PRICE','UO000012','1');
insert into order_promotion_data values ('OP000057','Promo For Total0057','1110','881','PERCENT_OFF','UO000012','1');
insert into order_promotion_data values ('OP000058','Promo For Total0058','1217','953','FIX_PRICE','UO000012','1');
insert into order_promotion_data values ('OP000059','Promo For Total0059','901','994','PERCENT_OFF','UO000012','1');
insert into order_promotion_data values ('OP000060','Promo For Total0060','1179','1018','FIX_PRICE','UO000012','1');
insert into order_promotion_data values ('OP000061','Promo For Total0061','1011','1158','PERCENT_OFF','UO000013','1');
insert into order_promotion_data values ('OP000062','Promo For Total0062','1009','868','FIX_PRICE','UO000013','1');
insert into order_promotion_data values ('OP000063','Promo For Total0063','1184','941','PERCENT_OFF','UO000013','1');
insert into order_promotion_data values ('OP000064','Promo For Total0064','904','1104','FIX_PRICE','UO000013','1');
insert into order_promotion_data values ('OP000065','Promo For Total0065','1072','1108','PERCENT_OFF','UO000013','1');
insert into order_promotion_data values ('OP000066','Promo For Total0066','1112','914','FIX_PRICE','UO000014','1');
insert into order_promotion_data values ('OP000067','Promo For Total0067','994','1198','PERCENT_OFF','UO000014','1');
insert into order_promotion_data values ('OP000068','Promo For Total0068','875','1121','FIX_PRICE','UO000014','1');
insert into order_promotion_data values ('OP000069','Promo For Total0069','899','1172','PERCENT_OFF','UO000014','1');
insert into order_promotion_data values ('OP000070','Promo For Total0070','1148','1125','FIX_PRICE','UO000014','1');
insert into order_promotion_data values ('OP000071','Promo For Total0071','940','904','PERCENT_OFF','UO000015','1');
insert into order_promotion_data values ('OP000072','Promo For Total0072','1034','872','FIX_PRICE','UO000015','1');
insert into order_promotion_data values ('OP000073','Promo For Total0073','1191','1201','PERCENT_OFF','UO000015','1');
insert into order_promotion_data values ('OP000074','Promo For Total0074','934','903','FIX_PRICE','UO000015','1');
insert into order_promotion_data values ('OP000075','Promo For Total0075','1169','1214','PERCENT_OFF','UO000015','1');
insert into order_promotion_data values ('OP000076','Promo For Total0076','1133','1188','FIX_PRICE','UO000016','1');
insert into order_promotion_data values ('OP000077','Promo For Total0077','1218','1149','PERCENT_OFF','UO000016','1');
insert into order_promotion_data values ('OP000078','Promo For Total0078','1219','1041','FIX_PRICE','UO000016','1');
insert into order_promotion_data values ('OP000079','Promo For Total0079','889','1198','PERCENT_OFF','UO000016','1');
insert into order_promotion_data values ('OP000080','Promo For Total0080','883','876','FIX_PRICE','UO000016','1');
insert into order_promotion_data values ('OP000081','Promo For Total0081','1046','1007','PERCENT_OFF','UO000017','1');
insert into order_promotion_data values ('OP000082','Promo For Total0082','1133','1220','FIX_PRICE','UO000017','1');
insert into order_promotion_data values ('OP000083','Promo For Total0083','877','1184','PERCENT_OFF','UO000017','1');
insert into order_promotion_data values ('OP000084','Promo For Total0084','1102','1068','FIX_PRICE','UO000017','1');
insert into order_promotion_data values ('OP000085','Promo For Total0085','1016','1157','PERCENT_OFF','UO000017','1');
insert into order_promotion_data values ('OP000086','Promo For Total0086','971','1218','FIX_PRICE','UO000018','1');
insert into order_promotion_data values ('OP000087','Promo For Total0087','879','1207','PERCENT_OFF','UO000018','1');
insert into order_promotion_data values ('OP000088','Promo For Total0088','951','996','FIX_PRICE','UO000018','1');
insert into order_promotion_data values ('OP000089','Promo For Total0089','1206','862','PERCENT_OFF','UO000018','1');
insert into order_promotion_data values ('OP000090','Promo For Total0090','1125','1068','FIX_PRICE','UO000018','1');
insert into order_promotion_data values ('OP000091','Promo For Total0091','1063','904','PERCENT_OFF','UO000019','1');
insert into order_promotion_data values ('OP000092','Promo For Total0092','1033','1221','FIX_PRICE','UO000019','1');
insert into order_promotion_data values ('OP000093','Promo For Total0093','944','1054','PERCENT_OFF','UO000019','1');
insert into order_promotion_data values ('OP000094','Promo For Total0094','1163','1202','FIX_PRICE','UO000019','1');
insert into order_promotion_data values ('OP000095','Promo For Total0095','1054','889','PERCENT_OFF','UO000019','1');
insert into order_promotion_data values ('OP000096','Promo For Total0096','1010','1115','FIX_PRICE','UO000020','1');
insert into order_promotion_data values ('OP000097','Promo For Total0097','913','1227','PERCENT_OFF','UO000020','1');
insert into order_promotion_data values ('OP000098','Promo For Total0098','1140','946','FIX_PRICE','UO000020','1');
insert into order_promotion_data values ('OP000099','Promo For Total0099','1125','1075','PERCENT_OFF','UO000020','1');
insert into order_promotion_data values ('OP000100','Promo For Total0100','939','892','FIX_PRICE','UO000020','1');
insert into order_promotion_data values ('OP000101','Promo For Total0101','1108','1168','PERCENT_OFF','UO000021','1');
insert into order_promotion_data values ('OP000102','Promo For Total0102','1191','1031','FIX_PRICE','UO000021','1');
insert into order_promotion_data values ('OP000103','Promo For Total0103','1093','927','PERCENT_OFF','UO000021','1');
insert into order_promotion_data values ('OP000104','Promo For Total0104','1076','1091','FIX_PRICE','UO000021','1');
insert into order_promotion_data values ('OP000105','Promo For Total0105','1038','873','PERCENT_OFF','UO000021','1');
insert into order_promotion_data values ('OP000106','Promo For Total0106','939','902','FIX_PRICE','UO000022','1');
insert into order_promotion_data values ('OP000107','Promo For Total0107','935','1021','PERCENT_OFF','UO000022','1');
insert into order_promotion_data values ('OP000108','Promo For Total0108','1057','1122','FIX_PRICE','UO000022','1');
insert into order_promotion_data values ('OP000109','Promo For Total0109','1163','1065','PERCENT_OFF','UO000022','1');
insert into order_promotion_data values ('OP000110','Promo For Total0110','872','1118','FIX_PRICE','UO000022','1');
insert into order_promotion_data values ('OP000111','Promo For Total0111','1089','1098','PERCENT_OFF','UO000023','1');
insert into order_promotion_data values ('OP000112','Promo For Total0112','1128','1041','FIX_PRICE','UO000023','1');
insert into order_promotion_data values ('OP000113','Promo For Total0113','1078','1161','PERCENT_OFF','UO000023','1');
insert into order_promotion_data values ('OP000114','Promo For Total0114','1113','1069','FIX_PRICE','UO000023','1');
insert into order_promotion_data values ('OP000115','Promo For Total0115','1083','1175','PERCENT_OFF','UO000023','1');
insert into order_promotion_data values ('OP000116','Promo For Total0116','980','970','FIX_PRICE','UO000024','1');
insert into order_promotion_data values ('OP000117','Promo For Total0117','986','1000','PERCENT_OFF','UO000024','1');
insert into order_promotion_data values ('OP000118','Promo For Total0118','1037','1005','FIX_PRICE','UO000024','1');
insert into order_promotion_data values ('OP000119','Promo For Total0119','932','1108','PERCENT_OFF','UO000024','1');
insert into order_promotion_data values ('OP000120','Promo For Total0120','895','1022','FIX_PRICE','UO000024','1');
insert into order_promotion_data values ('OP000121','Promo For Total0121','1065','1118','PERCENT_OFF','UO000025','1');
insert into order_promotion_data values ('OP000122','Promo For Total0122','885','1004','FIX_PRICE','UO000025','1');
insert into order_promotion_data values ('OP000123','Promo For Total0123','1168','913','PERCENT_OFF','UO000025','1');
insert into order_promotion_data values ('OP000124','Promo For Total0124','955','1154','FIX_PRICE','UO000025','1');
insert into order_promotion_data values ('OP000125','Promo For Total0125','1010','1087','PERCENT_OFF','UO000025','1');

	
insert into manual_adjustment_data values ('MA000001','Promo For Total','890','894','OFF','UO000001','1');
insert into manual_adjustment_data values ('MA000002','Promo For Total0002','966','1112','FIX_PRICE','UO000001','1');
insert into manual_adjustment_data values ('MA000003','Promo For Total0003','968','1019','OFF','UO000001','1');
insert into manual_adjustment_data values ('MA000004','Promo For Total0004','1198','1201','FIX_PRICE','UO000001','1');
insert into manual_adjustment_data values ('MA000005','Promo For Total0005','1084','955','OFF','UO000001','1');
insert into manual_adjustment_data values ('MA000006','Promo For Total0006','1114','1169','FIX_PRICE','UO000002','1');
insert into manual_adjustment_data values ('MA000007','Promo For Total0007','1120','907','OFF','UO000002','1');
insert into manual_adjustment_data values ('MA000008','Promo For Total0008','921','939','FIX_PRICE','UO000002','1');
insert into manual_adjustment_data values ('MA000009','Promo For Total0009','1197','947','OFF','UO000002','1');
insert into manual_adjustment_data values ('MA000010','Promo For Total0010','1150','1010','FIX_PRICE','UO000002','1');
insert into manual_adjustment_data values ('MA000011','Promo For Total0011','1024','1077','OFF','UO000003','1');
insert into manual_adjustment_data values ('MA000012','Promo For Total0012','1224','1167','FIX_PRICE','UO000003','1');
insert into manual_adjustment_data values ('MA000013','Promo For Total0013','1031','1180','OFF','UO000003','1');
insert into manual_adjustment_data values ('MA000014','Promo For Total0014','901','916','FIX_PRICE','UO000003','1');
insert into manual_adjustment_data values ('MA000015','Promo For Total0015','1055','1138','OFF','UO000003','1');
insert into manual_adjustment_data values ('MA000016','Promo For Total0016','970','1078','FIX_PRICE','UO000004','1');
insert into manual_adjustment_data values ('MA000017','Promo For Total0017','915','1132','OFF','UO000004','1');
insert into manual_adjustment_data values ('MA000018','Promo For Total0018','1124','910','FIX_PRICE','UO000004','1');
insert into manual_adjustment_data values ('MA000019','Promo For Total0019','1228','998','OFF','UO000004','1');
insert into manual_adjustment_data values ('MA000020','Promo For Total0020','863','1104','FIX_PRICE','UO000004','1');
insert into manual_adjustment_data values ('MA000021','Promo For Total0021','963','989','OFF','UO000005','1');
insert into manual_adjustment_data values ('MA000022','Promo For Total0022','1102','1012','FIX_PRICE','UO000005','1');
insert into manual_adjustment_data values ('MA000023','Promo For Total0023','965','1185','OFF','UO000005','1');
insert into manual_adjustment_data values ('MA000024','Promo For Total0024','912','1132','FIX_PRICE','UO000005','1');
insert into manual_adjustment_data values ('MA000025','Promo For Total0025','1126','1070','OFF','UO000005','1');
insert into manual_adjustment_data values ('MA000026','Promo For Total0026','995','1099','FIX_PRICE','UO000006','1');
insert into manual_adjustment_data values ('MA000027','Promo For Total0027','1106','917','OFF','UO000006','1');
insert into manual_adjustment_data values ('MA000028','Promo For Total0028','1090','996','FIX_PRICE','UO000006','1');
insert into manual_adjustment_data values ('MA000029','Promo For Total0029','964','1000','OFF','UO000006','1');
insert into manual_adjustment_data values ('MA000030','Promo For Total0030','1100','1175','FIX_PRICE','UO000006','1');
insert into manual_adjustment_data values ('MA000031','Promo For Total0031','966','1131','OFF','UO000007','1');
insert into manual_adjustment_data values ('MA000032','Promo For Total0032','1184','909','FIX_PRICE','UO000007','1');
insert into manual_adjustment_data values ('MA000033','Promo For Total0033','937','1156','OFF','UO000007','1');
insert into manual_adjustment_data values ('MA000034','Promo For Total0034','1178','972','FIX_PRICE','UO000007','1');
insert into manual_adjustment_data values ('MA000035','Promo For Total0035','867','1080','OFF','UO000007','1');
insert into manual_adjustment_data values ('MA000036','Promo For Total0036','921','1225','FIX_PRICE','UO000008','1');
insert into manual_adjustment_data values ('MA000037','Promo For Total0037','998','1057','OFF','UO000008','1');
insert into manual_adjustment_data values ('MA000038','Promo For Total0038','1067','996','FIX_PRICE','UO000008','1');
insert into manual_adjustment_data values ('MA000039','Promo For Total0039','887','1033','OFF','UO000008','1');
insert into manual_adjustment_data values ('MA000040','Promo For Total0040','977','1214','FIX_PRICE','UO000008','1');
insert into manual_adjustment_data values ('MA000041','Promo For Total0041','1056','1096','OFF','UO000009','1');
insert into manual_adjustment_data values ('MA000042','Promo For Total0042','1115','1154','FIX_PRICE','UO000009','1');
insert into manual_adjustment_data values ('MA000043','Promo For Total0043','929','1018','OFF','UO000009','1');
insert into manual_adjustment_data values ('MA000044','Promo For Total0044','969','881','FIX_PRICE','UO000009','1');
insert into manual_adjustment_data values ('MA000045','Promo For Total0045','1135','997','OFF','UO000009','1');
insert into manual_adjustment_data values ('MA000046','Promo For Total0046','882','1106','FIX_PRICE','UO000010','1');
insert into manual_adjustment_data values ('MA000047','Promo For Total0047','1139','914','OFF','UO000010','1');
insert into manual_adjustment_data values ('MA000048','Promo For Total0048','1133','885','FIX_PRICE','UO000010','1');
insert into manual_adjustment_data values ('MA000049','Promo For Total0049','1173','1204','OFF','UO000010','1');
insert into manual_adjustment_data values ('MA000050','Promo For Total0050','1112','892','FIX_PRICE','UO000010','1');
insert into manual_adjustment_data values ('MA000051','Promo For Total0051','947','883','OFF','UO000011','1');
insert into manual_adjustment_data values ('MA000052','Promo For Total0052','1020','1066','FIX_PRICE','UO000011','1');
insert into manual_adjustment_data values ('MA000053','Promo For Total0053','1045','1140','OFF','UO000011','1');
insert into manual_adjustment_data values ('MA000054','Promo For Total0054','961','984','FIX_PRICE','UO000011','1');
insert into manual_adjustment_data values ('MA000055','Promo For Total0055','1137','996','OFF','UO000011','1');
insert into manual_adjustment_data values ('MA000056','Promo For Total0056','977','969','FIX_PRICE','UO000012','1');
insert into manual_adjustment_data values ('MA000057','Promo For Total0057','961','1106','OFF','UO000012','1');
insert into manual_adjustment_data values ('MA000058','Promo For Total0058','1201','1229','FIX_PRICE','UO000012','1');
insert into manual_adjustment_data values ('MA000059','Promo For Total0059','1094','1068','OFF','UO000012','1');
insert into manual_adjustment_data values ('MA000060','Promo For Total0060','1057','1199','FIX_PRICE','UO000012','1');
insert into manual_adjustment_data values ('MA000061','Promo For Total0061','1151','1193','OFF','UO000013','1');
insert into manual_adjustment_data values ('MA000062','Promo For Total0062','1140','988','FIX_PRICE','UO000013','1');
insert into manual_adjustment_data values ('MA000063','Promo For Total0063','1010','1220','OFF','UO000013','1');
insert into manual_adjustment_data values ('MA000064','Promo For Total0064','1082','1055','FIX_PRICE','UO000013','1');
insert into manual_adjustment_data values ('MA000065','Promo For Total0065','1165','1209','OFF','UO000013','1');
insert into manual_adjustment_data values ('MA000066','Promo For Total0066','911','1220','FIX_PRICE','UO000014','1');
insert into manual_adjustment_data values ('MA000067','Promo For Total0067','1008','1036','OFF','UO000014','1');
insert into manual_adjustment_data values ('MA000068','Promo For Total0068','1113','1064','FIX_PRICE','UO000014','1');
insert into manual_adjustment_data values ('MA000069','Promo For Total0069','1214','1093','OFF','UO000014','1');
insert into manual_adjustment_data values ('MA000070','Promo For Total0070','1101','1028','FIX_PRICE','UO000014','1');
insert into manual_adjustment_data values ('MA000071','Promo For Total0071','866','992','OFF','UO000015','1');
insert into manual_adjustment_data values ('MA000072','Promo For Total0072','1085','888','FIX_PRICE','UO000015','1');
insert into manual_adjustment_data values ('MA000073','Promo For Total0073','908','1201','OFF','UO000015','1');
insert into manual_adjustment_data values ('MA000074','Promo For Total0074','1231','1050','FIX_PRICE','UO000015','1');
insert into manual_adjustment_data values ('MA000075','Promo For Total0075','993','862','OFF','UO000015','1');
insert into manual_adjustment_data values ('MA000076','Promo For Total0076','870','1023','FIX_PRICE','UO000016','1');
insert into manual_adjustment_data values ('MA000077','Promo For Total0077','937','1007','OFF','UO000016','1');
insert into manual_adjustment_data values ('MA000078','Promo For Total0078','1057','870','FIX_PRICE','UO000016','1');
insert into manual_adjustment_data values ('MA000079','Promo For Total0079','1121','1191','OFF','UO000016','1');
insert into manual_adjustment_data values ('MA000080','Promo For Total0080','1209','1173','FIX_PRICE','UO000016','1');
insert into manual_adjustment_data values ('MA000081','Promo For Total0081','1014','958','OFF','UO000017','1');
insert into manual_adjustment_data values ('MA000082','Promo For Total0082','1206','1146','FIX_PRICE','UO000017','1');
insert into manual_adjustment_data values ('MA000083','Promo For Total0083','879','881','OFF','UO000017','1');
insert into manual_adjustment_data values ('MA000084','Promo For Total0084','1037','956','FIX_PRICE','UO000017','1');
insert into manual_adjustment_data values ('MA000085','Promo For Total0085','955','1053','OFF','UO000017','1');
insert into manual_adjustment_data values ('MA000086','Promo For Total0086','1039','1154','FIX_PRICE','UO000018','1');
insert into manual_adjustment_data values ('MA000087','Promo For Total0087','1125','1219','OFF','UO000018','1');
insert into manual_adjustment_data values ('MA000088','Promo For Total0088','1059','1158','FIX_PRICE','UO000018','1');
insert into manual_adjustment_data values ('MA000089','Promo For Total0089','946','1059','OFF','UO000018','1');
insert into manual_adjustment_data values ('MA000090','Promo For Total0090','1150','1164','FIX_PRICE','UO000018','1');
insert into manual_adjustment_data values ('MA000091','Promo For Total0091','1138','1091','OFF','UO000019','1');
insert into manual_adjustment_data values ('MA000092','Promo For Total0092','1169','1061','FIX_PRICE','UO000019','1');
insert into manual_adjustment_data values ('MA000093','Promo For Total0093','1057','916','OFF','UO000019','1');
insert into manual_adjustment_data values ('MA000094','Promo For Total0094','1172','867','FIX_PRICE','UO000019','1');
insert into manual_adjustment_data values ('MA000095','Promo For Total0095','1076','903','OFF','UO000019','1');
insert into manual_adjustment_data values ('MA000096','Promo For Total0096','1017','940','FIX_PRICE','UO000020','1');
insert into manual_adjustment_data values ('MA000097','Promo For Total0097','1034','904','OFF','UO000020','1');
insert into manual_adjustment_data values ('MA000098','Promo For Total0098','870','897','FIX_PRICE','UO000020','1');
insert into manual_adjustment_data values ('MA000099','Promo For Total0099','926','882','OFF','UO000020','1');
insert into manual_adjustment_data values ('MA000100','Promo For Total0100','1093','1010','FIX_PRICE','UO000020','1');
insert into manual_adjustment_data values ('MA000101','Promo For Total0101','994','1031','OFF','UO000021','1');
insert into manual_adjustment_data values ('MA000102','Promo For Total0102','922','1064','FIX_PRICE','UO000021','1');
insert into manual_adjustment_data values ('MA000103','Promo For Total0103','1112','1132','OFF','UO000021','1');
insert into manual_adjustment_data values ('MA000104','Promo For Total0104','900','934','FIX_PRICE','UO000021','1');
insert into manual_adjustment_data values ('MA000105','Promo For Total0105','901','885','OFF','UO000021','1');
insert into manual_adjustment_data values ('MA000106','Promo For Total0106','1184','1041','FIX_PRICE','UO000022','1');
insert into manual_adjustment_data values ('MA000107','Promo For Total0107','959','1099','OFF','UO000022','1');
insert into manual_adjustment_data values ('MA000108','Promo For Total0108','996','965','FIX_PRICE','UO000022','1');
insert into manual_adjustment_data values ('MA000109','Promo For Total0109','1110','1076','OFF','UO000022','1');
insert into manual_adjustment_data values ('MA000110','Promo For Total0110','1184','995','FIX_PRICE','UO000022','1');
insert into manual_adjustment_data values ('MA000111','Promo For Total0111','1108','1219','OFF','UO000023','1');
insert into manual_adjustment_data values ('MA000112','Promo For Total0112','865','884','FIX_PRICE','UO000023','1');
insert into manual_adjustment_data values ('MA000113','Promo For Total0113','952','1035','OFF','UO000023','1');
insert into manual_adjustment_data values ('MA000114','Promo For Total0114','1174','1087','FIX_PRICE','UO000023','1');
insert into manual_adjustment_data values ('MA000115','Promo For Total0115','1099','892','OFF','UO000023','1');
insert into manual_adjustment_data values ('MA000116','Promo For Total0116','1065','949','FIX_PRICE','UO000024','1');
insert into manual_adjustment_data values ('MA000117','Promo For Total0117','1128','1141','OFF','UO000024','1');
insert into manual_adjustment_data values ('MA000118','Promo For Total0118','908','1208','FIX_PRICE','UO000024','1');
insert into manual_adjustment_data values ('MA000119','Promo For Total0119','982','910','OFF','UO000024','1');
insert into manual_adjustment_data values ('MA000120','Promo For Total0120','1042','1207','FIX_PRICE','UO000024','1');
insert into manual_adjustment_data values ('MA000121','Promo For Total0121','1187','1159','OFF','UO000025','1');
insert into manual_adjustment_data values ('MA000122','Promo For Total0122','966','1144','FIX_PRICE','UO000025','1');
insert into manual_adjustment_data values ('MA000123','Promo For Total0123','940','971','OFF','UO000025','1');
insert into manual_adjustment_data values ('MA000124','Promo For Total0124','887','973','FIX_PRICE','UO000025','1');
insert into manual_adjustment_data values ('MA000125','Promo For Total0125','975','947','OFF','UO000025','1');

	
insert into shipping_group_data values ('SG000001','Ship To Home','1900 AVE OF THE STARTS - ','Suite 555 - ','Century City - ','CA','789862','US','UO000001','1');
insert into shipping_group_data values ('SG000002','Ship To Home0002','1900 AVE OF THE STARTS - 0002','Suite 555 - 0002','Century City - 0002','VA','724756','US','UO000001','1');
insert into shipping_group_data values ('SG000003','Ship To Home0003','1900 AVE OF THE STARTS - 0003','Suite 555 - 0003','Century City - 0003','MA','763093','US','UO000001','1');
insert into shipping_group_data values ('SG000004','Ship To Home0004','1900 AVE OF THE STARTS - 0004','Suite 555 - 0004','Century City - 0004','PA','765581','US','UO000001','1');
insert into shipping_group_data values ('SG000005','Ship To Home0005','1900 AVE OF THE STARTS - 0005','Suite 555 - 0005','Century City - 0005','WA','952841','US','UO000001','1');
insert into shipping_group_data values ('SG000006','Ship To Home0006','1900 AVE OF THE STARTS - 0006','Suite 555 - 0006','Century City - 0006','LA','744155','US','UO000002','1');
insert into shipping_group_data values ('SG000007','Ship To Home0007','1900 AVE OF THE STARTS - 0007','Suite 555 - 0007','Century City - 0007','CA','970597','US','UO000002','1');
insert into shipping_group_data values ('SG000008','Ship To Home0008','1900 AVE OF THE STARTS - 0008','Suite 555 - 0008','Century City - 0008','VA','898948','US','UO000002','1');
insert into shipping_group_data values ('SG000009','Ship To Home0009','1900 AVE OF THE STARTS - 0009','Suite 555 - 0009','Century City - 0009','MA','778055','US','UO000002','1');
insert into shipping_group_data values ('SG000010','Ship To Home0010','1900 AVE OF THE STARTS - 0010','Suite 555 - 0010','Century City - 0010','PA','691341','US','UO000002','1');
insert into shipping_group_data values ('SG000011','Ship To Home0011','1900 AVE OF THE STARTS - 0011','Suite 555 - 0011','Century City - 0011','WA','789721','US','UO000003','1');
insert into shipping_group_data values ('SG000012','Ship To Home0012','1900 AVE OF THE STARTS - 0012','Suite 555 - 0012','Century City - 0012','LA','714334','US','UO000003','1');
insert into shipping_group_data values ('SG000013','Ship To Home0013','1900 AVE OF THE STARTS - 0013','Suite 555 - 0013','Century City - 0013','CA','790668','US','UO000003','1');
insert into shipping_group_data values ('SG000014','Ship To Home0014','1900 AVE OF THE STARTS - 0014','Suite 555 - 0014','Century City - 0014','VA','791032','US','UO000003','1');
insert into shipping_group_data values ('SG000015','Ship To Home0015','1900 AVE OF THE STARTS - 0015','Suite 555 - 0015','Century City - 0015','MA','692539','US','UO000003','1');
insert into shipping_group_data values ('SG000016','Ship To Home0016','1900 AVE OF THE STARTS - 0016','Suite 555 - 0016','Century City - 0016','PA','796913','US','UO000004','1');
insert into shipping_group_data values ('SG000017','Ship To Home0017','1900 AVE OF THE STARTS - 0017','Suite 555 - 0017','Century City - 0017','WA','694204','US','UO000004','1');
insert into shipping_group_data values ('SG000018','Ship To Home0018','1900 AVE OF THE STARTS - 0018','Suite 555 - 0018','Century City - 0018','LA','949868','US','UO000004','1');
insert into shipping_group_data values ('SG000019','Ship To Home0019','1900 AVE OF THE STARTS - 0019','Suite 555 - 0019','Century City - 0019','CA','693141','US','UO000004','1');
insert into shipping_group_data values ('SG000020','Ship To Home0020','1900 AVE OF THE STARTS - 0020','Suite 555 - 0020','Century City - 0020','VA','782210','US','UO000004','1');
insert into shipping_group_data values ('SG000021','Ship To Home0021','1900 AVE OF THE STARTS - 0021','Suite 555 - 0021','Century City - 0021','MA','779881','US','UO000005','1');
insert into shipping_group_data values ('SG000022','Ship To Home0022','1900 AVE OF THE STARTS - 0022','Suite 555 - 0022','Century City - 0022','PA','741061','US','UO000005','1');
insert into shipping_group_data values ('SG000023','Ship To Home0023','1900 AVE OF THE STARTS - 0023','Suite 555 - 0023','Century City - 0023','WA','750476','US','UO000005','1');
insert into shipping_group_data values ('SG000024','Ship To Home0024','1900 AVE OF THE STARTS - 0024','Suite 555 - 0024','Century City - 0024','LA','941306','US','UO000005','1');
insert into shipping_group_data values ('SG000025','Ship To Home0025','1900 AVE OF THE STARTS - 0025','Suite 555 - 0025','Century City - 0025','CA','914259','US','UO000005','1');
insert into shipping_group_data values ('SG000026','Ship To Home0026','1900 AVE OF THE STARTS - 0026','Suite 555 - 0026','Century City - 0026','VA','975744','US','UO000006','1');
insert into shipping_group_data values ('SG000027','Ship To Home0027','1900 AVE OF THE STARTS - 0027','Suite 555 - 0027','Century City - 0027','MA','776861','US','UO000006','1');
insert into shipping_group_data values ('SG000028','Ship To Home0028','1900 AVE OF THE STARTS - 0028','Suite 555 - 0028','Century City - 0028','PA','750960','US','UO000006','1');
insert into shipping_group_data values ('SG000029','Ship To Home0029','1900 AVE OF THE STARTS - 0029','Suite 555 - 0029','Century City - 0029','WA','956811','US','UO000006','1');
insert into shipping_group_data values ('SG000030','Ship To Home0030','1900 AVE OF THE STARTS - 0030','Suite 555 - 0030','Century City - 0030','LA','701878','US','UO000006','1');
insert into shipping_group_data values ('SG000031','Ship To Home0031','1900 AVE OF THE STARTS - 0031','Suite 555 - 0031','Century City - 0031','CA','687247','US','UO000007','1');
insert into shipping_group_data values ('SG000032','Ship To Home0032','1900 AVE OF THE STARTS - 0032','Suite 555 - 0032','Century City - 0032','VA','841164','US','UO000007','1');
insert into shipping_group_data values ('SG000033','Ship To Home0033','1900 AVE OF THE STARTS - 0033','Suite 555 - 0033','Century City - 0033','MA','717138','US','UO000007','1');
insert into shipping_group_data values ('SG000034','Ship To Home0034','1900 AVE OF THE STARTS - 0034','Suite 555 - 0034','Century City - 0034','PA','826836','US','UO000007','1');
insert into shipping_group_data values ('SG000035','Ship To Home0035','1900 AVE OF THE STARTS - 0035','Suite 555 - 0035','Century City - 0035','WA','709294','US','UO000007','1');
insert into shipping_group_data values ('SG000036','Ship To Home0036','1900 AVE OF THE STARTS - 0036','Suite 555 - 0036','Century City - 0036','LA','804690','US','UO000008','1');
insert into shipping_group_data values ('SG000037','Ship To Home0037','1900 AVE OF THE STARTS - 0037','Suite 555 - 0037','Century City - 0037','CA','741616','US','UO000008','1');
insert into shipping_group_data values ('SG000038','Ship To Home0038','1900 AVE OF THE STARTS - 0038','Suite 555 - 0038','Century City - 0038','VA','896941','US','UO000008','1');
insert into shipping_group_data values ('SG000039','Ship To Home0039','1900 AVE OF THE STARTS - 0039','Suite 555 - 0039','Century City - 0039','MA','737197','US','UO000008','1');
insert into shipping_group_data values ('SG000040','Ship To Home0040','1900 AVE OF THE STARTS - 0040','Suite 555 - 0040','Century City - 0040','PA','728395','US','UO000008','1');
insert into shipping_group_data values ('SG000041','Ship To Home0041','1900 AVE OF THE STARTS - 0041','Suite 555 - 0041','Century City - 0041','WA','855634','US','UO000009','1');
insert into shipping_group_data values ('SG000042','Ship To Home0042','1900 AVE OF THE STARTS - 0042','Suite 555 - 0042','Century City - 0042','LA','916316','US','UO000009','1');
insert into shipping_group_data values ('SG000043','Ship To Home0043','1900 AVE OF THE STARTS - 0043','Suite 555 - 0043','Century City - 0043','CA','733544','US','UO000009','1');
insert into shipping_group_data values ('SG000044','Ship To Home0044','1900 AVE OF THE STARTS - 0044','Suite 555 - 0044','Century City - 0044','VA','747258','US','UO000009','1');
insert into shipping_group_data values ('SG000045','Ship To Home0045','1900 AVE OF THE STARTS - 0045','Suite 555 - 0045','Century City - 0045','MA','886132','US','UO000009','1');
insert into shipping_group_data values ('SG000046','Ship To Home0046','1900 AVE OF THE STARTS - 0046','Suite 555 - 0046','Century City - 0046','PA','772185','US','UO000010','1');
insert into shipping_group_data values ('SG000047','Ship To Home0047','1900 AVE OF THE STARTS - 0047','Suite 555 - 0047','Century City - 0047','WA','890380','US','UO000010','1');
insert into shipping_group_data values ('SG000048','Ship To Home0048','1900 AVE OF THE STARTS - 0048','Suite 555 - 0048','Century City - 0048','LA','707796','US','UO000010','1');
insert into shipping_group_data values ('SG000049','Ship To Home0049','1900 AVE OF THE STARTS - 0049','Suite 555 - 0049','Century City - 0049','CA','887446','US','UO000010','1');
insert into shipping_group_data values ('SG000050','Ship To Home0050','1900 AVE OF THE STARTS - 0050','Suite 555 - 0050','Century City - 0050','VA','830693','US','UO000010','1');
insert into shipping_group_data values ('SG000051','Ship To Home0051','1900 AVE OF THE STARTS - 0051','Suite 555 - 0051','Century City - 0051','MA','743846','US','UO000011','1');
insert into shipping_group_data values ('SG000052','Ship To Home0052','1900 AVE OF THE STARTS - 0052','Suite 555 - 0052','Century City - 0052','PA','872903','US','UO000011','1');
insert into shipping_group_data values ('SG000053','Ship To Home0053','1900 AVE OF THE STARTS - 0053','Suite 555 - 0053','Century City - 0053','WA','895663','US','UO000011','1');
insert into shipping_group_data values ('SG000054','Ship To Home0054','1900 AVE OF THE STARTS - 0054','Suite 555 - 0054','Century City - 0054','LA','944348','US','UO000011','1');
insert into shipping_group_data values ('SG000055','Ship To Home0055','1900 AVE OF THE STARTS - 0055','Suite 555 - 0055','Century City - 0055','CA','696475','US','UO000011','1');
insert into shipping_group_data values ('SG000056','Ship To Home0056','1900 AVE OF THE STARTS - 0056','Suite 555 - 0056','Century City - 0056','VA','973979','US','UO000012','1');
insert into shipping_group_data values ('SG000057','Ship To Home0057','1900 AVE OF THE STARTS - 0057','Suite 555 - 0057','Century City - 0057','MA','687818','US','UO000012','1');
insert into shipping_group_data values ('SG000058','Ship To Home0058','1900 AVE OF THE STARTS - 0058','Suite 555 - 0058','Century City - 0058','PA','871807','US','UO000012','1');
insert into shipping_group_data values ('SG000059','Ship To Home0059','1900 AVE OF THE STARTS - 0059','Suite 555 - 0059','Century City - 0059','WA','971727','US','UO000012','1');
insert into shipping_group_data values ('SG000060','Ship To Home0060','1900 AVE OF THE STARTS - 0060','Suite 555 - 0060','Century City - 0060','LA','873356','US','UO000012','1');
insert into shipping_group_data values ('SG000061','Ship To Home0061','1900 AVE OF THE STARTS - 0061','Suite 555 - 0061','Century City - 0061','CA','868412','US','UO000013','1');
insert into shipping_group_data values ('SG000062','Ship To Home0062','1900 AVE OF THE STARTS - 0062','Suite 555 - 0062','Century City - 0062','VA','901057','US','UO000013','1');
insert into shipping_group_data values ('SG000063','Ship To Home0063','1900 AVE OF THE STARTS - 0063','Suite 555 - 0063','Century City - 0063','MA','721505','US','UO000013','1');
insert into shipping_group_data values ('SG000064','Ship To Home0064','1900 AVE OF THE STARTS - 0064','Suite 555 - 0064','Century City - 0064','PA','764807','US','UO000013','1');
insert into shipping_group_data values ('SG000065','Ship To Home0065','1900 AVE OF THE STARTS - 0065','Suite 555 - 0065','Century City - 0065','WA','790427','US','UO000013','1');
insert into shipping_group_data values ('SG000066','Ship To Home0066','1900 AVE OF THE STARTS - 0066','Suite 555 - 0066','Century City - 0066','LA','813231','US','UO000014','1');
insert into shipping_group_data values ('SG000067','Ship To Home0067','1900 AVE OF THE STARTS - 0067','Suite 555 - 0067','Century City - 0067','CA','894861','US','UO000014','1');
insert into shipping_group_data values ('SG000068','Ship To Home0068','1900 AVE OF THE STARTS - 0068','Suite 555 - 0068','Century City - 0068','VA','735859','US','UO000014','1');
insert into shipping_group_data values ('SG000069','Ship To Home0069','1900 AVE OF THE STARTS - 0069','Suite 555 - 0069','Century City - 0069','MA','745276','US','UO000014','1');
insert into shipping_group_data values ('SG000070','Ship To Home0070','1900 AVE OF THE STARTS - 0070','Suite 555 - 0070','Century City - 0070','PA','872600','US','UO000014','1');
insert into shipping_group_data values ('SG000071','Ship To Home0071','1900 AVE OF THE STARTS - 0071','Suite 555 - 0071','Century City - 0071','WA','910447','US','UO000015','1');
insert into shipping_group_data values ('SG000072','Ship To Home0072','1900 AVE OF THE STARTS - 0072','Suite 555 - 0072','Century City - 0072','LA','704087','US','UO000015','1');
insert into shipping_group_data values ('SG000073','Ship To Home0073','1900 AVE OF THE STARTS - 0073','Suite 555 - 0073','Century City - 0073','CA','834100','US','UO000015','1');
insert into shipping_group_data values ('SG000074','Ship To Home0074','1900 AVE OF THE STARTS - 0074','Suite 555 - 0074','Century City - 0074','VA','872987','US','UO000015','1');
insert into shipping_group_data values ('SG000075','Ship To Home0075','1900 AVE OF THE STARTS - 0075','Suite 555 - 0075','Century City - 0075','MA','846773','US','UO000015','1');
insert into shipping_group_data values ('SG000076','Ship To Home0076','1900 AVE OF THE STARTS - 0076','Suite 555 - 0076','Century City - 0076','PA','750393','US','UO000016','1');
insert into shipping_group_data values ('SG000077','Ship To Home0077','1900 AVE OF THE STARTS - 0077','Suite 555 - 0077','Century City - 0077','WA','768261','US','UO000016','1');
insert into shipping_group_data values ('SG000078','Ship To Home0078','1900 AVE OF THE STARTS - 0078','Suite 555 - 0078','Century City - 0078','LA','932474','US','UO000016','1');
insert into shipping_group_data values ('SG000079','Ship To Home0079','1900 AVE OF THE STARTS - 0079','Suite 555 - 0079','Century City - 0079','CA','738166','US','UO000016','1');
insert into shipping_group_data values ('SG000080','Ship To Home0080','1900 AVE OF THE STARTS - 0080','Suite 555 - 0080','Century City - 0080','VA','763633','US','UO000016','1');
insert into shipping_group_data values ('SG000081','Ship To Home0081','1900 AVE OF THE STARTS - 0081','Suite 555 - 0081','Century City - 0081','MA','905908','US','UO000017','1');
insert into shipping_group_data values ('SG000082','Ship To Home0082','1900 AVE OF THE STARTS - 0082','Suite 555 - 0082','Century City - 0082','PA','716130','US','UO000017','1');
insert into shipping_group_data values ('SG000083','Ship To Home0083','1900 AVE OF THE STARTS - 0083','Suite 555 - 0083','Century City - 0083','WA','735137','US','UO000017','1');
insert into shipping_group_data values ('SG000084','Ship To Home0084','1900 AVE OF THE STARTS - 0084','Suite 555 - 0084','Century City - 0084','LA','905227','US','UO000017','1');
insert into shipping_group_data values ('SG000085','Ship To Home0085','1900 AVE OF THE STARTS - 0085','Suite 555 - 0085','Century City - 0085','CA','697660','US','UO000017','1');
insert into shipping_group_data values ('SG000086','Ship To Home0086','1900 AVE OF THE STARTS - 0086','Suite 555 - 0086','Century City - 0086','VA','895214','US','UO000018','1');
insert into shipping_group_data values ('SG000087','Ship To Home0087','1900 AVE OF THE STARTS - 0087','Suite 555 - 0087','Century City - 0087','MA','959173','US','UO000018','1');
insert into shipping_group_data values ('SG000088','Ship To Home0088','1900 AVE OF THE STARTS - 0088','Suite 555 - 0088','Century City - 0088','PA','702654','US','UO000018','1');
insert into shipping_group_data values ('SG000089','Ship To Home0089','1900 AVE OF THE STARTS - 0089','Suite 555 - 0089','Century City - 0089','WA','794847','US','UO000018','1');
insert into shipping_group_data values ('SG000090','Ship To Home0090','1900 AVE OF THE STARTS - 0090','Suite 555 - 0090','Century City - 0090','LA','754039','US','UO000018','1');
insert into shipping_group_data values ('SG000091','Ship To Home0091','1900 AVE OF THE STARTS - 0091','Suite 555 - 0091','Century City - 0091','CA','787887','US','UO000019','1');
insert into shipping_group_data values ('SG000092','Ship To Home0092','1900 AVE OF THE STARTS - 0092','Suite 555 - 0092','Century City - 0092','VA','758443','US','UO000019','1');
insert into shipping_group_data values ('SG000093','Ship To Home0093','1900 AVE OF THE STARTS - 0093','Suite 555 - 0093','Century City - 0093','MA','851156','US','UO000019','1');
insert into shipping_group_data values ('SG000094','Ship To Home0094','1900 AVE OF THE STARTS - 0094','Suite 555 - 0094','Century City - 0094','PA','978202','US','UO000019','1');
insert into shipping_group_data values ('SG000095','Ship To Home0095','1900 AVE OF THE STARTS - 0095','Suite 555 - 0095','Century City - 0095','WA','812671','US','UO000019','1');
insert into shipping_group_data values ('SG000096','Ship To Home0096','1900 AVE OF THE STARTS - 0096','Suite 555 - 0096','Century City - 0096','LA','948080','US','UO000020','1');
insert into shipping_group_data values ('SG000097','Ship To Home0097','1900 AVE OF THE STARTS - 0097','Suite 555 - 0097','Century City - 0097','CA','917542','US','UO000020','1');
insert into shipping_group_data values ('SG000098','Ship To Home0098','1900 AVE OF THE STARTS - 0098','Suite 555 - 0098','Century City - 0098','VA','818921','US','UO000020','1');
insert into shipping_group_data values ('SG000099','Ship To Home0099','1900 AVE OF THE STARTS - 0099','Suite 555 - 0099','Century City - 0099','MA','940075','US','UO000020','1');
insert into shipping_group_data values ('SG000100','Ship To Home0100','1900 AVE OF THE STARTS - 0100','Suite 555 - 0100','Century City - 0100','PA','799604','US','UO000020','1');
insert into shipping_group_data values ('SG000101','Ship To Home0101','1900 AVE OF THE STARTS - 0101','Suite 555 - 0101','Century City - 0101','WA','897875','US','UO000021','1');
insert into shipping_group_data values ('SG000102','Ship To Home0102','1900 AVE OF THE STARTS - 0102','Suite 555 - 0102','Century City - 0102','LA','768422','US','UO000021','1');
insert into shipping_group_data values ('SG000103','Ship To Home0103','1900 AVE OF THE STARTS - 0103','Suite 555 - 0103','Century City - 0103','CA','931291','US','UO000021','1');
insert into shipping_group_data values ('SG000104','Ship To Home0104','1900 AVE OF THE STARTS - 0104','Suite 555 - 0104','Century City - 0104','VA','923893','US','UO000021','1');
insert into shipping_group_data values ('SG000105','Ship To Home0105','1900 AVE OF THE STARTS - 0105','Suite 555 - 0105','Century City - 0105','MA','959287','US','UO000021','1');
insert into shipping_group_data values ('SG000106','Ship To Home0106','1900 AVE OF THE STARTS - 0106','Suite 555 - 0106','Century City - 0106','PA','921384','US','UO000022','1');
insert into shipping_group_data values ('SG000107','Ship To Home0107','1900 AVE OF THE STARTS - 0107','Suite 555 - 0107','Century City - 0107','WA','693414','US','UO000022','1');
insert into shipping_group_data values ('SG000108','Ship To Home0108','1900 AVE OF THE STARTS - 0108','Suite 555 - 0108','Century City - 0108','LA','949740','US','UO000022','1');
insert into shipping_group_data values ('SG000109','Ship To Home0109','1900 AVE OF THE STARTS - 0109','Suite 555 - 0109','Century City - 0109','CA','793648','US','UO000022','1');
insert into shipping_group_data values ('SG000110','Ship To Home0110','1900 AVE OF THE STARTS - 0110','Suite 555 - 0110','Century City - 0110','VA','724247','US','UO000022','1');
insert into shipping_group_data values ('SG000111','Ship To Home0111','1900 AVE OF THE STARTS - 0111','Suite 555 - 0111','Century City - 0111','MA','958571','US','UO000023','1');
insert into shipping_group_data values ('SG000112','Ship To Home0112','1900 AVE OF THE STARTS - 0112','Suite 555 - 0112','Century City - 0112','PA','878826','US','UO000023','1');
insert into shipping_group_data values ('SG000113','Ship To Home0113','1900 AVE OF THE STARTS - 0113','Suite 555 - 0113','Century City - 0113','WA','726928','US','UO000023','1');
insert into shipping_group_data values ('SG000114','Ship To Home0114','1900 AVE OF THE STARTS - 0114','Suite 555 - 0114','Century City - 0114','LA','786737','US','UO000023','1');
insert into shipping_group_data values ('SG000115','Ship To Home0115','1900 AVE OF THE STARTS - 0115','Suite 555 - 0115','Century City - 0115','CA','912882','US','UO000023','1');
insert into shipping_group_data values ('SG000116','Ship To Home0116','1900 AVE OF THE STARTS - 0116','Suite 555 - 0116','Century City - 0116','VA','889154','US','UO000024','1');
insert into shipping_group_data values ('SG000117','Ship To Home0117','1900 AVE OF THE STARTS - 0117','Suite 555 - 0117','Century City - 0117','MA','819621','US','UO000024','1');
insert into shipping_group_data values ('SG000118','Ship To Home0118','1900 AVE OF THE STARTS - 0118','Suite 555 - 0118','Century City - 0118','PA','959974','US','UO000024','1');
insert into shipping_group_data values ('SG000119','Ship To Home0119','1900 AVE OF THE STARTS - 0119','Suite 555 - 0119','Century City - 0119','WA','800461','US','UO000024','1');
insert into shipping_group_data values ('SG000120','Ship To Home0120','1900 AVE OF THE STARTS - 0120','Suite 555 - 0120','Century City - 0120','LA','839173','US','UO000024','1');
insert into shipping_group_data values ('SG000121','Ship To Home0121','1900 AVE OF THE STARTS - 0121','Suite 555 - 0121','Century City - 0121','CA','874035','US','UO000025','1');
insert into shipping_group_data values ('SG000122','Ship To Home0122','1900 AVE OF THE STARTS - 0122','Suite 555 - 0122','Century City - 0122','VA','966709','US','UO000025','1');
insert into shipping_group_data values ('SG000123','Ship To Home0123','1900 AVE OF THE STARTS - 0123','Suite 555 - 0123','Century City - 0123','MA','718547','US','UO000025','1');
insert into shipping_group_data values ('SG000124','Ship To Home0124','1900 AVE OF THE STARTS - 0124','Suite 555 - 0124','Century City - 0124','PA','948490','US','UO000025','1');
insert into shipping_group_data values ('SG000125','Ship To Home0125','1900 AVE OF THE STARTS - 0125','Suite 555 - 0125','Century City - 0125','WA','847071','US','UO000025','1');

	
insert into payment_group_data values ('PG000001','Pay for order','101.42','UO000001','PAID','1');
insert into payment_group_data values ('PG000002','Pay for order0002','105.10','UO000001','PENDING','1');
insert into payment_group_data values ('PG000003','Pay for order0003','103.52','UO000001','FAIL','1');
insert into payment_group_data values ('PG000004','Pay for order0004','99.30','UO000001','PAID','1');
insert into payment_group_data values ('PG000005','Pay for order0005','112.84','UO000001','PENDING','1');
insert into payment_group_data values ('PG000006','Pay for order0006','98.75','UO000002','FAIL','1');
insert into payment_group_data values ('PG000007','Pay for order0007','94.74','UO000002','PAID','1');
insert into payment_group_data values ('PG000008','Pay for order0008','117.47','UO000002','PENDING','1');
insert into payment_group_data values ('PG000009','Pay for order0009','102.51','UO000002','FAIL','1');
insert into payment_group_data values ('PG000010','Pay for order0010','95.48','UO000002','PAID','1');
insert into payment_group_data values ('PG000011','Pay for order0011','101.31','UO000003','PENDING','1');
insert into payment_group_data values ('PG000012','Pay for order0012','110.19','UO000003','FAIL','1');
insert into payment_group_data values ('PG000013','Pay for order0013','122.44','UO000003','PAID','1');
insert into payment_group_data values ('PG000014','Pay for order0014','97.90','UO000003','PENDING','1');
insert into payment_group_data values ('PG000015','Pay for order0015','86.63','UO000003','FAIL','1');
insert into payment_group_data values ('PG000016','Pay for order0016','111.87','UO000004','PAID','1');
insert into payment_group_data values ('PG000017','Pay for order0017','103.84','UO000004','PENDING','1');
insert into payment_group_data values ('PG000018','Pay for order0018','92.79','UO000004','FAIL','1');
insert into payment_group_data values ('PG000019','Pay for order0019','109.28','UO000004','PAID','1');
insert into payment_group_data values ('PG000020','Pay for order0020','94.78','UO000004','PENDING','1');
insert into payment_group_data values ('PG000021','Pay for order0021','113.27','UO000005','FAIL','1');
insert into payment_group_data values ('PG000022','Pay for order0022','112.34','UO000005','PAID','1');
insert into payment_group_data values ('PG000023','Pay for order0023','107.21','UO000005','PENDING','1');
insert into payment_group_data values ('PG000024','Pay for order0024','92.49','UO000005','FAIL','1');
insert into payment_group_data values ('PG000025','Pay for order0025','117.38','UO000005','PAID','1');
insert into payment_group_data values ('PG000026','Pay for order0026','113.50','UO000006','PENDING','1');
insert into payment_group_data values ('PG000027','Pay for order0027','99.47','UO000006','FAIL','1');
insert into payment_group_data values ('PG000028','Pay for order0028','98.15','UO000006','PAID','1');
insert into payment_group_data values ('PG000029','Pay for order0029','122.29','UO000006','PENDING','1');
insert into payment_group_data values ('PG000030','Pay for order0030','86.55','UO000006','FAIL','1');
insert into payment_group_data values ('PG000031','Pay for order0031','121.98','UO000007','PAID','1');
insert into payment_group_data values ('PG000032','Pay for order0032','95.44','UO000007','PENDING','1');
insert into payment_group_data values ('PG000033','Pay for order0033','111.64','UO000007','FAIL','1');
insert into payment_group_data values ('PG000034','Pay for order0034','119.14','UO000007','PAID','1');
insert into payment_group_data values ('PG000035','Pay for order0035','103.66','UO000007','PENDING','1');
insert into payment_group_data values ('PG000036','Pay for order0036','117.37','UO000008','FAIL','1');
insert into payment_group_data values ('PG000037','Pay for order0037','94.12','UO000008','PAID','1');
insert into payment_group_data values ('PG000038','Pay for order0038','114.62','UO000008','PENDING','1');
insert into payment_group_data values ('PG000039','Pay for order0039','99.10','UO000008','FAIL','1');
insert into payment_group_data values ('PG000040','Pay for order0040','111.00','UO000008','PAID','1');
insert into payment_group_data values ('PG000041','Pay for order0041','96.13','UO000009','PENDING','1');
insert into payment_group_data values ('PG000042','Pay for order0042','122.41','UO000009','FAIL','1');
insert into payment_group_data values ('PG000043','Pay for order0043','87.21','UO000009','PAID','1');
insert into payment_group_data values ('PG000044','Pay for order0044','92.76','UO000009','PENDING','1');
insert into payment_group_data values ('PG000045','Pay for order0045','90.44','UO000009','FAIL','1');
insert into payment_group_data values ('PG000046','Pay for order0046','96.34','UO000010','PAID','1');
insert into payment_group_data values ('PG000047','Pay for order0047','90.95','UO000010','PENDING','1');
insert into payment_group_data values ('PG000048','Pay for order0048','101.62','UO000010','FAIL','1');
insert into payment_group_data values ('PG000049','Pay for order0049','121.52','UO000010','PAID','1');
insert into payment_group_data values ('PG000050','Pay for order0050','103.37','UO000010','PENDING','1');
insert into payment_group_data values ('PG000051','Pay for order0051','99.31','UO000011','FAIL','1');
insert into payment_group_data values ('PG000052','Pay for order0052','115.60','UO000011','PAID','1');
insert into payment_group_data values ('PG000053','Pay for order0053','91.36','UO000011','PENDING','1');
insert into payment_group_data values ('PG000054','Pay for order0054','110.34','UO000011','FAIL','1');
insert into payment_group_data values ('PG000055','Pay for order0055','87.17','UO000011','PAID','1');
insert into payment_group_data values ('PG000056','Pay for order0056','104.50','UO000012','PENDING','1');
insert into payment_group_data values ('PG000057','Pay for order0057','89.76','UO000012','FAIL','1');
insert into payment_group_data values ('PG000058','Pay for order0058','117.52','UO000012','PAID','1');
insert into payment_group_data values ('PG000059','Pay for order0059','121.37','UO000012','PENDING','1');
insert into payment_group_data values ('PG000060','Pay for order0060','115.84','UO000012','FAIL','1');
insert into payment_group_data values ('PG000061','Pay for order0061','108.60','UO000013','PAID','1');
insert into payment_group_data values ('PG000062','Pay for order0062','92.10','UO000013','PENDING','1');
insert into payment_group_data values ('PG000063','Pay for order0063','107.97','UO000013','FAIL','1');
insert into payment_group_data values ('PG000064','Pay for order0064','102.26','UO000013','PAID','1');
insert into payment_group_data values ('PG000065','Pay for order0065','108.18','UO000013','PENDING','1');
insert into payment_group_data values ('PG000066','Pay for order0066','120.08','UO000014','FAIL','1');
insert into payment_group_data values ('PG000067','Pay for order0067','95.71','UO000014','PAID','1');
insert into payment_group_data values ('PG000068','Pay for order0068','92.43','UO000014','PENDING','1');
insert into payment_group_data values ('PG000069','Pay for order0069','103.60','UO000014','FAIL','1');
insert into payment_group_data values ('PG000070','Pay for order0070','89.15','UO000014','PAID','1');
insert into payment_group_data values ('PG000071','Pay for order0071','111.39','UO000015','PENDING','1');
insert into payment_group_data values ('PG000072','Pay for order0072','110.44','UO000015','FAIL','1');
insert into payment_group_data values ('PG000073','Pay for order0073','119.38','UO000015','PAID','1');
insert into payment_group_data values ('PG000074','Pay for order0074','91.60','UO000015','PENDING','1');
insert into payment_group_data values ('PG000075','Pay for order0075','91.42','UO000015','FAIL','1');
insert into payment_group_data values ('PG000076','Pay for order0076','94.30','UO000016','PAID','1');
insert into payment_group_data values ('PG000077','Pay for order0077','116.92','UO000016','PENDING','1');
insert into payment_group_data values ('PG000078','Pay for order0078','105.80','UO000016','FAIL','1');
insert into payment_group_data values ('PG000079','Pay for order0079','90.90','UO000016','PAID','1');
insert into payment_group_data values ('PG000080','Pay for order0080','110.09','UO000016','PENDING','1');
insert into payment_group_data values ('PG000081','Pay for order0081','112.77','UO000017','FAIL','1');
insert into payment_group_data values ('PG000082','Pay for order0082','118.08','UO000017','PAID','1');
insert into payment_group_data values ('PG000083','Pay for order0083','111.85','UO000017','PENDING','1');
insert into payment_group_data values ('PG000084','Pay for order0084','110.57','UO000017','FAIL','1');
insert into payment_group_data values ('PG000085','Pay for order0085','120.40','UO000017','PAID','1');
insert into payment_group_data values ('PG000086','Pay for order0086','89.90','UO000018','PENDING','1');
insert into payment_group_data values ('PG000087','Pay for order0087','103.09','UO000018','FAIL','1');
insert into payment_group_data values ('PG000088','Pay for order0088','108.13','UO000018','PAID','1');
insert into payment_group_data values ('PG000089','Pay for order0089','111.02','UO000018','PENDING','1');
insert into payment_group_data values ('PG000090','Pay for order0090','106.80','UO000018','FAIL','1');
insert into payment_group_data values ('PG000091','Pay for order0091','109.20','UO000019','PAID','1');
insert into payment_group_data values ('PG000092','Pay for order0092','92.87','UO000019','PENDING','1');
insert into payment_group_data values ('PG000093','Pay for order0093','90.69','UO000019','FAIL','1');
insert into payment_group_data values ('PG000094','Pay for order0094','88.94','UO000019','PAID','1');
insert into payment_group_data values ('PG000095','Pay for order0095','103.87','UO000019','PENDING','1');
insert into payment_group_data values ('PG000096','Pay for order0096','119.75','UO000020','FAIL','1');
insert into payment_group_data values ('PG000097','Pay for order0097','111.65','UO000020','PAID','1');
insert into payment_group_data values ('PG000098','Pay for order0098','100.97','UO000020','PENDING','1');
insert into payment_group_data values ('PG000099','Pay for order0099','98.26','UO000020','FAIL','1');
insert into payment_group_data values ('PG000100','Pay for order0100','102.20','UO000020','PAID','1');
insert into payment_group_data values ('PG000101','Pay for order0101','92.33','UO000021','PENDING','1');
insert into payment_group_data values ('PG000102','Pay for order0102','113.18','UO000021','FAIL','1');
insert into payment_group_data values ('PG000103','Pay for order0103','89.08','UO000021','PAID','1');
insert into payment_group_data values ('PG000104','Pay for order0104','115.72','UO000021','PENDING','1');
insert into payment_group_data values ('PG000105','Pay for order0105','118.02','UO000021','FAIL','1');
insert into payment_group_data values ('PG000106','Pay for order0106','117.96','UO000022','PAID','1');
insert into payment_group_data values ('PG000107','Pay for order0107','104.59','UO000022','PENDING','1');
insert into payment_group_data values ('PG000108','Pay for order0108','120.59','UO000022','FAIL','1');
insert into payment_group_data values ('PG000109','Pay for order0109','112.65','UO000022','PAID','1');
insert into payment_group_data values ('PG000110','Pay for order0110','120.49','UO000022','PENDING','1');
insert into payment_group_data values ('PG000111','Pay for order0111','104.48','UO000023','FAIL','1');
insert into payment_group_data values ('PG000112','Pay for order0112','116.24','UO000023','PAID','1');
insert into payment_group_data values ('PG000113','Pay for order0113','89.57','UO000023','PENDING','1');
insert into payment_group_data values ('PG000114','Pay for order0114','86.74','UO000023','FAIL','1');
insert into payment_group_data values ('PG000115','Pay for order0115','115.77','UO000023','PAID','1');
insert into payment_group_data values ('PG000116','Pay for order0116','91.97','UO000024','PENDING','1');
insert into payment_group_data values ('PG000117','Pay for order0117','119.30','UO000024','FAIL','1');
insert into payment_group_data values ('PG000118','Pay for order0118','121.98','UO000024','PAID','1');
insert into payment_group_data values ('PG000119','Pay for order0119','122.93','UO000024','PENDING','1');
insert into payment_group_data values ('PG000120','Pay for order0120','86.95','UO000024','FAIL','1');
insert into payment_group_data values ('PG000121','Pay for order0121','111.34','UO000025','PAID','1');
insert into payment_group_data values ('PG000122','Pay for order0122','119.23','UO000025','PENDING','1');
insert into payment_group_data values ('PG000123','Pay for order0123','121.63','UO000025','FAIL','1');
insert into payment_group_data values ('PG000124','Pay for order0124','119.93','UO000025','PAID','1');
insert into payment_group_data values ('PG000125','Pay for order0125','100.93','UO000025','PENDING','1');

	
insert into user_domain_data values ('UD000001','用户区域','1');

	
insert into user_white_list_data values ('UWL000001','clariones','tester;ios-spokesperson','UD000001','1');
insert into user_white_list_data values ('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');
insert into user_white_list_data values ('UWL000003','clariones','tester;ios-spokesperson0003','UD000001','1');
insert into user_white_list_data values ('UWL000004','13808188512','tester;ios-spokesperson0004','UD000001','1');
insert into user_white_list_data values ('UWL000005','clariones','tester;ios-spokesperson0005','UD000001','1');

	
insert into sec_user_data values ('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','0','2019-02-12 18:26:45','2019-02-08 20:59:47','UD000001',NULL,'BLOCKED','1');
insert into sec_user_data values ('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','9999999','2019-02-17 14:03:54','2019-02-06 02:27:31','UD000001',NULL,'BLOCKED0002','1');
insert into sec_user_data values ('SU000003','login0003','13900000003','','1A39AE05E011CF4B6ADE19307698831F4303CEB3FF5A9E21EEC0B21FB19B1050','0','2019-02-22 23:12:53','2019-02-15 15:26:18','UD000001',NULL,'BLOCKED0003','1');
insert into sec_user_data values ('SU000004','login0004','13900000004','suddy_chang@163.com','331D0B81C261072AB3E01D2D09A3D1F9B03F1E5F095D6BF7284F32BF85135D59','9999999','2019-02-06 15:30:54','2019-02-14 05:20:44','UD000001',NULL,'BLOCKED0004','1');
insert into sec_user_data values ('SU000005','login0005','13900000005','','CBDC109937F570CA1D5F223EC59F5368AF9380F9DBF7E553124132BB402ED457','0','2019-02-07 16:40:07','2019-02-09 03:12:44','UD000001',NULL,'BLOCKED0005','1');

	
insert into sec_user_blocking_data values ('SUB000001','currentUser()','2019-02-11 06:44:46','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

	
insert into user_app_data values ('UA000001','审车平台','SU000001','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1');
insert into user_app_data values ('UA000002','账户管理','SU000001','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0002','1');
insert into user_app_data values ('UA000003','接车公司','SU000001','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1');
insert into user_app_data values ('UA000004','审车公司','SU000001','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1');
insert into user_app_data values ('UA000005','维修公司','SU000001','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1');
insert into user_app_data values ('UA000006','顾客','SU000002','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0006','1');
insert into user_app_data values ('UA000007','审车平台','SU000002','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0007','1');
insert into user_app_data values ('UA000008','账户管理','SU000002','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0008','1');
insert into user_app_data values ('UA000009','接车公司','SU000002','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0009','1');
insert into user_app_data values ('UA000010','审车公司','SU000002','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0010','1');
insert into user_app_data values ('UA000011','维修公司','SU000003','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0011','1');
insert into user_app_data values ('UA000012','顾客','SU000003','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0012','1');
insert into user_app_data values ('UA000013','审车平台','SU000003','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0013','1');
insert into user_app_data values ('UA000014','账户管理','SU000003','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0014','1');
insert into user_app_data values ('UA000015','接车公司','SU000003','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0015','1');
insert into user_app_data values ('UA000016','审车公司','SU000004','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0016','1');
insert into user_app_data values ('UA000017','维修公司','SU000004','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0017','1');
insert into user_app_data values ('UA000018','顾客','SU000004','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0018','1');
insert into user_app_data values ('UA000019','审车平台','SU000004','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0019','1');
insert into user_app_data values ('UA000020','账户管理','SU000004','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0020','1');
insert into user_app_data values ('UA000021','接车公司','SU000005','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0021','1');
insert into user_app_data values ('UA000022','审车公司','SU000005','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0022','1');
insert into user_app_data values ('UA000023','维修公司','SU000005','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0023','1');
insert into user_app_data values ('UA000024','顾客','SU000005','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0024','1');
insert into user_app_data values ('UA000025','审车平台','SU000005','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0025','1');

	
insert into list_access_data values ('LA000001','列表','levelOneCategoryList',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000002','列表0002','levelOneCategoryList0002',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000003','列表0003','levelOneCategoryList0003',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000004','列表0004','levelOneCategoryList0004',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000005','列表0005','levelOneCategoryList0005',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000006','列表0006','levelOneCategoryList0006',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000007','列表0007','levelOneCategoryList0007',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000008','列表0008','levelOneCategoryList0008',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000009','列表0009','levelOneCategoryList0009',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000010','列表0010','levelOneCategoryList0010',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000011','列表0011','levelOneCategoryList0011',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000012','列表0012','levelOneCategoryList0012',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000013','列表0013','levelOneCategoryList0013',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000014','列表0014','levelOneCategoryList0014',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000015','列表0015','levelOneCategoryList0015',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000016','列表0016','levelOneCategoryList0016',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000017','列表0017','levelOneCategoryList0017',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000018','列表0018','levelOneCategoryList0018',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000019','列表0019','levelOneCategoryList0019',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000020','列表0020','levelOneCategoryList0020',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000021','列表0021','levelOneCategoryList0021',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000022','列表0022','levelOneCategoryList0022',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000023','列表0023','levelOneCategoryList0023',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000024','列表0024','levelOneCategoryList0024',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000025','列表0025','levelOneCategoryList0025',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000026','列表0026','levelOneCategoryList0026',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000027','列表0027','levelOneCategoryList0027',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000028','列表0028','levelOneCategoryList0028',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000029','列表0029','levelOneCategoryList0029',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000030','列表0030','levelOneCategoryList0030',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000031','列表0031','levelOneCategoryList0031',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000032','列表0032','levelOneCategoryList0032',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000033','列表0033','levelOneCategoryList0033',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000034','列表0034','levelOneCategoryList0034',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000035','列表0035','levelOneCategoryList0035',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000036','列表0036','levelOneCategoryList0036',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000037','列表0037','levelOneCategoryList0037',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000038','列表0038','levelOneCategoryList0038',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000039','列表0039','levelOneCategoryList0039',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000040','列表0040','levelOneCategoryList0040',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000041','列表0041','levelOneCategoryList0041',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000042','列表0042','levelOneCategoryList0042',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000043','列表0043','levelOneCategoryList0043',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000044','列表0044','levelOneCategoryList0044',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000045','列表0045','levelOneCategoryList0045',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000046','列表0046','levelOneCategoryList0046',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000047','列表0047','levelOneCategoryList0047',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000048','列表0048','levelOneCategoryList0048',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000049','列表0049','levelOneCategoryList0049',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000050','列表0050','levelOneCategoryList0050',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000051','列表0051','levelOneCategoryList0051',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000052','列表0052','levelOneCategoryList0052',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000053','列表0053','levelOneCategoryList0053',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000054','列表0054','levelOneCategoryList0054',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000055','列表0055','levelOneCategoryList0055',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000056','列表0056','levelOneCategoryList0056',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000057','列表0057','levelOneCategoryList0057',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000058','列表0058','levelOneCategoryList0058',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000059','列表0059','levelOneCategoryList0059',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000060','列表0060','levelOneCategoryList0060',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000061','列表0061','levelOneCategoryList0061',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000062','列表0062','levelOneCategoryList0062',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000063','列表0063','levelOneCategoryList0063',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000064','列表0064','levelOneCategoryList0064',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000065','列表0065','levelOneCategoryList0065',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000066','列表0066','levelOneCategoryList0066',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000067','列表0067','levelOneCategoryList0067',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000068','列表0068','levelOneCategoryList0068',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000069','列表0069','levelOneCategoryList0069',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000070','列表0070','levelOneCategoryList0070',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000071','列表0071','levelOneCategoryList0071',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000072','列表0072','levelOneCategoryList0072',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000073','列表0073','levelOneCategoryList0073',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000074','列表0074','levelOneCategoryList0074',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000075','列表0075','levelOneCategoryList0075',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000076','列表0076','levelOneCategoryList0076',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000077','列表0077','levelOneCategoryList0077',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000078','列表0078','levelOneCategoryList0078',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000079','列表0079','levelOneCategoryList0079',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000080','列表0080','levelOneCategoryList0080',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000081','列表0081','levelOneCategoryList0081',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000082','列表0082','levelOneCategoryList0082',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000083','列表0083','levelOneCategoryList0083',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000084','列表0084','levelOneCategoryList0084',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000085','列表0085','levelOneCategoryList0085',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000086','列表0086','levelOneCategoryList0086',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000087','列表0087','levelOneCategoryList0087',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000088','列表0088','levelOneCategoryList0088',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000089','列表0089','levelOneCategoryList0089',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000090','列表0090','levelOneCategoryList0090',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000091','列表0091','levelOneCategoryList0091',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000092','列表0092','levelOneCategoryList0092',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000093','列表0093','levelOneCategoryList0093',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000094','列表0094','levelOneCategoryList0094',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000095','列表0095','levelOneCategoryList0095',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000096','列表0096','levelOneCategoryList0096',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000097','列表0097','levelOneCategoryList0097',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000098','列表0098','levelOneCategoryList0098',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000099','列表0099','levelOneCategoryList0099',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000100','列表0100','levelOneCategoryList0100',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000101','列表0101','levelOneCategoryList0101',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000102','列表0102','levelOneCategoryList0102',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000103','列表0103','levelOneCategoryList0103',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000104','列表0104','levelOneCategoryList0104',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000105','列表0105','levelOneCategoryList0105',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000106','列表0106','levelOneCategoryList0106',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000107','列表0107','levelOneCategoryList0107',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000108','列表0108','levelOneCategoryList0108',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000109','列表0109','levelOneCategoryList0109',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000110','列表0110','levelOneCategoryList0110',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000111','列表0111','levelOneCategoryList0111',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000112','列表0112','levelOneCategoryList0112',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000113','列表0113','levelOneCategoryList0113',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000114','列表0114','levelOneCategoryList0114',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000115','列表0115','levelOneCategoryList0115',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000116','列表0116','levelOneCategoryList0116',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000117','列表0117','levelOneCategoryList0117',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000118','列表0118','levelOneCategoryList0118',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000119','列表0119','levelOneCategoryList0119',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000120','列表0120','levelOneCategoryList0120',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000121','列表0121','levelOneCategoryList0121',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000122','列表0122','levelOneCategoryList0122',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000123','列表0123','levelOneCategoryList0123',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000124','列表0124','levelOneCategoryList0124',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000125','列表0125','levelOneCategoryList0125',1,1,1,1,1,'UA000025','1');

	
insert into object_access_data values ('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1');
insert into object_access_data values ('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1');
insert into object_access_data values ('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1');
insert into object_access_data values ('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1');
insert into object_access_data values ('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1');
insert into object_access_data values ('OA000009','控制访问列表10009','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1');
insert into object_access_data values ('OA000010','控制访问列表10010','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1');
insert into object_access_data values ('OA000011','控制访问列表10011','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1');
insert into object_access_data values ('OA000012','控制访问列表10012','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1');
insert into object_access_data values ('OA000013','控制访问列表10013','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1');
insert into object_access_data values ('OA000014','控制访问列表10014','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1');
insert into object_access_data values ('OA000015','控制访问列表10015','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1');
insert into object_access_data values ('OA000016','控制访问列表10016','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000017','控制访问列表10017','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1');
insert into object_access_data values ('OA000018','控制访问列表10018','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000019','控制访问列表10019','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1');
insert into object_access_data values ('OA000020','控制访问列表10020','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000021','控制访问列表10021','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000022','控制访问列表10022','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000005','1');
insert into object_access_data values ('OA000023','控制访问列表10023','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000024','控制访问列表10024','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000005','1');
insert into object_access_data values ('OA000025','控制访问列表10025','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000026','控制访问列表10026','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');
insert into object_access_data values ('OA000027','控制访问列表10027','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000006','1');
insert into object_access_data values ('OA000028','控制访问列表10028','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');
insert into object_access_data values ('OA000029','控制访问列表10029','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000006','1');
insert into object_access_data values ('OA000030','控制访问列表10030','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');
insert into object_access_data values ('OA000031','控制访问列表10031','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1');
insert into object_access_data values ('OA000032','控制访问列表10032','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000007','1');
insert into object_access_data values ('OA000033','控制访问列表10033','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1');
insert into object_access_data values ('OA000034','控制访问列表10034','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000007','1');
insert into object_access_data values ('OA000035','控制访问列表10035','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1');
insert into object_access_data values ('OA000036','控制访问列表10036','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1');
insert into object_access_data values ('OA000037','控制访问列表10037','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000008','1');
insert into object_access_data values ('OA000038','控制访问列表10038','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1');
insert into object_access_data values ('OA000039','控制访问列表10039','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000008','1');
insert into object_access_data values ('OA000040','控制访问列表10040','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1');
insert into object_access_data values ('OA000041','控制访问列表10041','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1');
insert into object_access_data values ('OA000042','控制访问列表10042','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000009','1');
insert into object_access_data values ('OA000043','控制访问列表10043','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1');
insert into object_access_data values ('OA000044','控制访问列表10044','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000009','1');
insert into object_access_data values ('OA000045','控制访问列表10045','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1');
insert into object_access_data values ('OA000046','控制访问列表10046','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000010','1');
insert into object_access_data values ('OA000047','控制访问列表10047','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000010','1');
insert into object_access_data values ('OA000048','控制访问列表10048','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000010','1');
insert into object_access_data values ('OA000049','控制访问列表10049','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000010','1');
insert into object_access_data values ('OA000050','控制访问列表10050','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000010','1');
insert into object_access_data values ('OA000051','控制访问列表10051','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000011','1');
insert into object_access_data values ('OA000052','控制访问列表10052','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000011','1');
insert into object_access_data values ('OA000053','控制访问列表10053','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000011','1');
insert into object_access_data values ('OA000054','控制访问列表10054','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000011','1');
insert into object_access_data values ('OA000055','控制访问列表10055','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000011','1');
insert into object_access_data values ('OA000056','控制访问列表10056','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000012','1');
insert into object_access_data values ('OA000057','控制访问列表10057','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000012','1');
insert into object_access_data values ('OA000058','控制访问列表10058','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000012','1');
insert into object_access_data values ('OA000059','控制访问列表10059','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000012','1');
insert into object_access_data values ('OA000060','控制访问列表10060','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000012','1');
insert into object_access_data values ('OA000061','控制访问列表10061','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000013','1');
insert into object_access_data values ('OA000062','控制访问列表10062','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000013','1');
insert into object_access_data values ('OA000063','控制访问列表10063','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000013','1');
insert into object_access_data values ('OA000064','控制访问列表10064','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000013','1');
insert into object_access_data values ('OA000065','控制访问列表10065','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000013','1');
insert into object_access_data values ('OA000066','控制访问列表10066','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000014','1');
insert into object_access_data values ('OA000067','控制访问列表10067','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000014','1');
insert into object_access_data values ('OA000068','控制访问列表10068','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000014','1');
insert into object_access_data values ('OA000069','控制访问列表10069','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000014','1');
insert into object_access_data values ('OA000070','控制访问列表10070','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000014','1');
insert into object_access_data values ('OA000071','控制访问列表10071','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000015','1');
insert into object_access_data values ('OA000072','控制访问列表10072','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000015','1');
insert into object_access_data values ('OA000073','控制访问列表10073','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000015','1');
insert into object_access_data values ('OA000074','控制访问列表10074','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000015','1');
insert into object_access_data values ('OA000075','控制访问列表10075','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000015','1');
insert into object_access_data values ('OA000076','控制访问列表10076','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000016','1');
insert into object_access_data values ('OA000077','控制访问列表10077','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000016','1');
insert into object_access_data values ('OA000078','控制访问列表10078','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000016','1');
insert into object_access_data values ('OA000079','控制访问列表10079','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000016','1');
insert into object_access_data values ('OA000080','控制访问列表10080','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000016','1');
insert into object_access_data values ('OA000081','控制访问列表10081','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000017','1');
insert into object_access_data values ('OA000082','控制访问列表10082','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000017','1');
insert into object_access_data values ('OA000083','控制访问列表10083','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000017','1');
insert into object_access_data values ('OA000084','控制访问列表10084','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000017','1');
insert into object_access_data values ('OA000085','控制访问列表10085','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000017','1');
insert into object_access_data values ('OA000086','控制访问列表10086','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000018','1');
insert into object_access_data values ('OA000087','控制访问列表10087','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000018','1');
insert into object_access_data values ('OA000088','控制访问列表10088','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000018','1');
insert into object_access_data values ('OA000089','控制访问列表10089','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000018','1');
insert into object_access_data values ('OA000090','控制访问列表10090','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000018','1');
insert into object_access_data values ('OA000091','控制访问列表10091','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000019','1');
insert into object_access_data values ('OA000092','控制访问列表10092','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000019','1');
insert into object_access_data values ('OA000093','控制访问列表10093','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000019','1');
insert into object_access_data values ('OA000094','控制访问列表10094','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000019','1');
insert into object_access_data values ('OA000095','控制访问列表10095','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000019','1');
insert into object_access_data values ('OA000096','控制访问列表10096','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000020','1');
insert into object_access_data values ('OA000097','控制访问列表10097','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000020','1');
insert into object_access_data values ('OA000098','控制访问列表10098','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000020','1');
insert into object_access_data values ('OA000099','控制访问列表10099','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000020','1');
insert into object_access_data values ('OA000100','控制访问列表10100','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000020','1');
insert into object_access_data values ('OA000101','控制访问列表10101','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000021','1');
insert into object_access_data values ('OA000102','控制访问列表10102','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000021','1');
insert into object_access_data values ('OA000103','控制访问列表10103','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000021','1');
insert into object_access_data values ('OA000104','控制访问列表10104','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000021','1');
insert into object_access_data values ('OA000105','控制访问列表10105','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000021','1');
insert into object_access_data values ('OA000106','控制访问列表10106','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000022','1');
insert into object_access_data values ('OA000107','控制访问列表10107','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000022','1');
insert into object_access_data values ('OA000108','控制访问列表10108','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000022','1');
insert into object_access_data values ('OA000109','控制访问列表10109','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000022','1');
insert into object_access_data values ('OA000110','控制访问列表10110','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000022','1');
insert into object_access_data values ('OA000111','控制访问列表10111','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000023','1');
insert into object_access_data values ('OA000112','控制访问列表10112','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000023','1');
insert into object_access_data values ('OA000113','控制访问列表10113','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000023','1');
insert into object_access_data values ('OA000114','控制访问列表10114','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000023','1');
insert into object_access_data values ('OA000115','控制访问列表10115','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000023','1');
insert into object_access_data values ('OA000116','控制访问列表10116','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000024','1');
insert into object_access_data values ('OA000117','控制访问列表10117','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000024','1');
insert into object_access_data values ('OA000118','控制访问列表10118','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000024','1');
insert into object_access_data values ('OA000119','控制访问列表10119','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000024','1');
insert into object_access_data values ('OA000120','控制访问列表10120','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000024','1');
insert into object_access_data values ('OA000121','控制访问列表10121','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000025','1');
insert into object_access_data values ('OA000122','控制访问列表10122','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000025','1');
insert into object_access_data values ('OA000123','控制访问列表10123','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000025','1');
insert into object_access_data values ('OA000124','控制访问列表10124','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000025','1');
insert into object_access_data values ('OA000125','控制访问列表10125','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000025','1');

	
insert into login_history_data values ('LH000001','2019-02-18 01:31:21','192.168.1.1','登陆成功','SU000001','1');
insert into login_history_data values ('LH000002','2019-02-05 09:31:18','192.168.1.2','登陆成功0002','SU000001','1');
insert into login_history_data values ('LH000003','2019-02-05 11:12:45','192.168.1.1','登陆成功0003','SU000001','1');
insert into login_history_data values ('LH000004','2019-02-02 21:11:49','192.168.1.2','登陆成功0004','SU000001','1');
insert into login_history_data values ('LH000005','2019-02-16 18:25:30','192.168.1.1','登陆成功0005','SU000001','1');
insert into login_history_data values ('LH000006','2019-02-07 21:55:53','192.168.1.2','登陆成功0006','SU000002','1');
insert into login_history_data values ('LH000007','2019-02-15 01:01:11','192.168.1.1','登陆成功0007','SU000002','1');
insert into login_history_data values ('LH000008','2019-02-06 12:36:52','192.168.1.2','登陆成功0008','SU000002','1');
insert into login_history_data values ('LH000009','2019-02-14 07:23:38','192.168.1.1','登陆成功0009','SU000002','1');
insert into login_history_data values ('LH000010','2019-02-03 15:50:19','192.168.1.2','登陆成功0010','SU000002','1');
insert into login_history_data values ('LH000011','2019-02-11 17:50:46','192.168.1.1','登陆成功0011','SU000003','1');
insert into login_history_data values ('LH000012','2019-02-16 07:54:17','192.168.1.2','登陆成功0012','SU000003','1');
insert into login_history_data values ('LH000013','2019-02-01 21:21:19','192.168.1.1','登陆成功0013','SU000003','1');
insert into login_history_data values ('LH000014','2019-02-01 18:00:22','192.168.1.2','登陆成功0014','SU000003','1');
insert into login_history_data values ('LH000015','2019-02-18 01:20:19','192.168.1.1','登陆成功0015','SU000003','1');
insert into login_history_data values ('LH000016','2019-02-01 03:26:41','192.168.1.2','登陆成功0016','SU000004','1');
insert into login_history_data values ('LH000017','2019-02-03 23:17:48','192.168.1.1','登陆成功0017','SU000004','1');
insert into login_history_data values ('LH000018','2019-02-22 14:05:03','192.168.1.2','登陆成功0018','SU000004','1');
insert into login_history_data values ('LH000019','2019-02-03 13:49:46','192.168.1.1','登陆成功0019','SU000004','1');
insert into login_history_data values ('LH000020','2019-02-18 22:52:38','192.168.1.2','登陆成功0020','SU000004','1');
insert into login_history_data values ('LH000021','2019-02-16 22:03:54','192.168.1.1','登陆成功0021','SU000005','1');
insert into login_history_data values ('LH000022','2019-02-05 19:02:11','192.168.1.2','登陆成功0022','SU000005','1');
insert into login_history_data values ('LH000023','2019-02-05 21:58:32','192.168.1.1','登陆成功0023','SU000005','1');
insert into login_history_data values ('LH000024','2019-02-17 15:09:36','192.168.1.2','登陆成功0024','SU000005','1');
insert into login_history_data values ('LH000025','2019-02-21 05:01:53','192.168.1.1','登陆成功0025','SU000005','1');

	
insert into generic_form_data values ('GF000001','登记输入单','姓名就是你身份证上的名字','1');

	
insert into form_message_data values ('FM000001','字段组合错误','GF000001','success','1');
insert into form_message_data values ('FM000002','字段组合错误0002','GF000001','info','1');
insert into form_message_data values ('FM000003','字段组合错误0003','GF000001','warning','1');
insert into form_message_data values ('FM000004','字段组合错误0004','GF000001','danger','1');
insert into form_message_data values ('FM000005','字段组合错误0005','GF000001','success','1');

	
insert into form_field_message_data values ('FFM000001','输入错误','name','GF000001','success','1');
insert into form_field_message_data values ('FFM000002','输入错误0002','name0002','GF000001','info','1');
insert into form_field_message_data values ('FFM000003','输入错误0003','name0003','GF000001','warning','1');
insert into form_field_message_data values ('FFM000004','输入错误0004','name0004','GF000001','danger','1');
insert into form_field_message_data values ('FFM000005','输入错误0005','name0005','GF000001','success','1');

	
insert into form_field_data values ('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression',true,true,0,'','','1');
insert into form_field_data values ('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002',false,false,0,'','','1');
insert into form_field_data values ('FF000003','出生地','birth_place','name0003','date','GF000001','姓名就是你身份证上的名字0003','李一一0003','姓名就是你身份证上的名字0003','基础信息','maybe any value0003','a value expression0003',true,true,0,'','','1');
insert into form_field_data values ('FF000004','国籍','country','name0004','date_time','GF000001','姓名就是你身份证上的名字0004','李一一0004','姓名就是你身份证上的名字0004','扩展信息','maybe any value0004','a value expression0004',false,false,0,'男,女','男,女','1');
insert into form_field_data values ('FF000005','姓名','name','name0005','money','GF000001','姓名就是你身份证上的名字0005','李一一0005','姓名就是你身份证上的名字0005','基础信息','maybe any value0005','a value expression0005',true,true,0,'高,矮','高,矮','1');

	
insert into form_action_data values ('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1');
insert into form_action_data values ('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1');
insert into form_action_data values ('FA000003','功能0003','name0003','remove','danger','genericFormManager/name/name0002/name0003/0003','GF000001','1');
insert into form_action_data values ('FA000004','功能0004','name0004','save','primary','genericFormManager/name/name0002/name0003/0004','GF000001','1');
insert into form_action_data values ('FA000005','功能0005','name0005','update','default','genericFormManager/name/name0002/name0003/0005','GF000001','1');

/*
Mysql innodb's foreign key has index automatically

*/

create unique index idx_platform_version on platform_data(id, version);

create unique index idx_profile_version on profile_data(id, version);

alter table profile_data add constraint profile4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_user_order_version on user_order_data(id, version);

alter table user_order_data add constraint user_order4user_fk
	foreign key(user) references profile_data(id) on delete cascade on update cascade;
alter table user_order_data add constraint user_order4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_line_item_version on line_item_data(id, version);

alter table line_item_data add constraint line_item4user_order_fk
	foreign key(user_order) references user_order_data(id) on delete cascade on update cascade;
create unique index idx_order_promotion_version on order_promotion_data(id, version);

alter table order_promotion_data add constraint order_promotion4user_order_fk
	foreign key(user_order) references user_order_data(id) on delete cascade on update cascade;
create unique index idx_manual_adjustment_version on manual_adjustment_data(id, version);

alter table manual_adjustment_data add constraint manual_adjustment4user_order_fk
	foreign key(user_order) references user_order_data(id) on delete cascade on update cascade;
create unique index idx_shipping_group_version on shipping_group_data(id, version);

alter table shipping_group_data add constraint shipping_group4user_order_fk
	foreign key(user_order) references user_order_data(id) on delete cascade on update cascade;
create unique index idx_payment_group_version on payment_group_data(id, version);

alter table payment_group_data add constraint payment_group4user_order_fk
	foreign key(user_order) references user_order_data(id) on delete cascade on update cascade;
create unique index idx_user_domain_version on user_domain_data(id, version);

create unique index idx_user_white_list_version on user_white_list_data(id, version);

alter table user_white_list_data add constraint user_white_list4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_version on sec_user_data(id, version);

alter table sec_user_data add constraint sec_user4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
alter table sec_user_data add constraint sec_user4blocking_fk
	foreign key(blocking) references sec_user_blocking_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_blocking_version on sec_user_blocking_data(id, version);

create unique index idx_user_app_version on user_app_data(id, version);

alter table user_app_data add constraint user_app4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_list_access_version on list_access_data(id, version);

alter table list_access_data add constraint list_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_object_access_version on object_access_data(id, version);

alter table object_access_data add constraint object_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_login_history_version on login_history_data(id, version);

alter table login_history_data add constraint login_history4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_generic_form_version on generic_form_data(id, version);

create unique index idx_form_message_version on form_message_data(id, version);

alter table form_message_data add constraint form_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_message_version on form_field_message_data(id, version);

alter table form_field_message_data add constraint form_field_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_version on form_field_data(id, version);

alter table form_field_data add constraint form_field4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_action_version on form_action_data(id, version);

alter table form_action_data add constraint form_action4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
-- create extra index for time, number and mobile phone

create index platform4version_idx on platform_data(version);
create index profile4age_idx on profile_data(age);
create index profile4last_update_time_idx on profile_data(last_update_time);
create index profile4version_idx on profile_data(version);
create index user_order4total_adjustment_idx on user_order_data(total_adjustment);
create index user_order4total_amount_idx on user_order_data(total_amount);
create index user_order4last_update_time_idx on user_order_data(last_update_time);
create index user_order4version_idx on user_order_data(version);
create index line_item4quantity_idx on line_item_data(quantity);
create index line_item4price_idx on line_item_data(price);
create index line_item4discount_price_idx on line_item_data(discount_price);
create index line_item4version_idx on line_item_data(version);
create index order_promotion4amount_idx on order_promotion_data(amount);
create index order_promotion4thread_hold_idx on order_promotion_data(thread_hold);
create index order_promotion4version_idx on order_promotion_data(version);
create index manual_adjustment4amount_idx on manual_adjustment_data(amount);
create index manual_adjustment4thread_hold_idx on manual_adjustment_data(thread_hold);
create index manual_adjustment4version_idx on manual_adjustment_data(version);
create index shipping_group4zip_code_idx on shipping_group_data(zip_code);
create index shipping_group4version_idx on shipping_group_data(version);
create index payment_group4amount_idx on payment_group_data(amount);
create index payment_group4version_idx on payment_group_data(version);
create index user_domain4version_idx on user_domain_data(version);
create index user_white_list4version_idx on user_white_list_data(version);
create index sec_user4mobile_idx on sec_user_data(mobile);
create index sec_user4verification_code_idx on sec_user_data(verification_code);
create index sec_user4verification_code_expire_idx on sec_user_data(verification_code_expire);
create index sec_user4last_login_time_idx on sec_user_data(last_login_time);
create index sec_user4version_idx on sec_user_data(version);
create index sec_user_blocking4block_time_idx on sec_user_blocking_data(block_time);
create index sec_user_blocking4version_idx on sec_user_blocking_data(version);
create index user_app4object_id_idx on user_app_data(object_id);
create index user_app4version_idx on user_app_data(version);
create index list_access4version_idx on list_access_data(version);
create index object_access4version_idx on object_access_data(version);
create index login_history4login_time_idx on login_history_data(login_time);
create index login_history4version_idx on login_history_data(version);
create index generic_form4version_idx on generic_form_data(version);
create index form_message4version_idx on form_message_data(version);
create index form_field_message4version_idx on form_field_message_data(version);
create index form_field4version_idx on form_field_data(version);
create index form_action4version_idx on form_action_data(version);










delete from sec_user_data;
delete from user_app_data;

/*
+--------------------------+-------------+------+-----+---------+-------+
| Field                    | Type        | Null | Key | Default | Extra |
+--------------------------+-------------+------+-----+---------+-------+
| id                       | varchar(64) | NO   | PRI | NULL    |       |
| login                    | varchar(20) | YES  |     | NULL    |       |
| mobile                   | varchar(11) | YES  | MUL | NULL    |       |
| email                    | varchar(76) | YES  |     | NULL    |       |
| pwd                      | varchar(64) | YES  |     | NULL    |       |
| verification_code        | int(11)     | YES  | MUL | NULL    |       |
| verification_code_expire | datetime    | YES  | MUL | NULL    |       |
| last_login_time          | datetime    | YES  | MUL | NULL    |       |
| domain                   | varchar(48) | YES  | MUL | NULL    |       |
| blocking                 | varchar(48) | YES  | MUL | NULL    |       |
| current_status           | varchar(28) | YES  |     | NULL    |       |
| version                  | int(11)     | YES  | MUL | NULL    |       |
+--------------------------+-------------+------+-----+---------+-------+


*/

insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','258D9BB89BBC1F2A6CDDD3A4CB300E6CD9B83F3FC9984619DF1A59F6051F1F44','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000001','Platform','SU000001','at',1,'MXWR','Platform','P000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000002','My Account','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','7FEABCC19D638787655F9FFC2C22755D5771184D85D000147D643D22F6617F7B','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','User Order','SU000002','user',1,'MXWR','UserOrder','UO000001','/link/to/app','1'); -- REFER COUNT: 5
insert into user_app_data values('UA000004','My Account','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1'); -- REFER COUNT: 5
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','8169C17063461B0B0CC210CE5EF682E9517A19170F7DCA3C76170229D765DE7A','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','User Domain','SU000003','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000006','My Account','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000004','User000004','13900000004','1000004@qq.com','025745F4A4EA0C11059911E40714470F323C42836B1137D66AD3F85210A725CF','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000007','Sec User Blocking','SU000004','user',1,'MXWR','SecUserBlocking','SUB000001','/link/to/app','1'); -- REFER COUNT: 1
insert into user_app_data values('UA000008','My Account','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1'); -- REFER COUNT: 1




/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|Platform|13900000001|DoubleChain!y1|
|User Order|13900000002|DoubleChain!y1|
|User Domain|13900000003|DoubleChain!y1|
|Sec User Blocking|13900000004|DoubleChain!y1|


*/



/* start with data patch */
/* The sql file is not found from: /Users/Philip/githome/web-code-generator/sky/data-patch/oms.sql */


/*

+----------+---------------------------------+---------------------+--------+
| Charset  | Description                     | Default collation   | Maxlen |
+----------+---------------------------------+---------------------+--------+
| gb2312   | GB2312 Simplified Chinese       | gb2312_chinese_ci   |      2 |
| gbk      | GBK Simplified Chinese          | gbk_chinese_ci      |      2 |
| utf8mb4  | UTF-8 Unicode                   | utf8mb4_general_ci  |      4 |
| utf32    | UTF-32 Unicode                  | utf32_general_ci    |      4 |
| gb18030  | China National Standard GB18030 | gb18030_chinese_ci  |      4 |
+----------+---------------------------------+---------------------+--------+

*/

