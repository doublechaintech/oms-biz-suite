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

	
insert into profile_data values ('P000001','Philip Zhang','39','male','2019-02-01 07:32:21','P000001','1');
insert into profile_data values ('P000002','Naveen Kumar R ','32','female','2019-02-15 18:12:37','P000001','1');
insert into profile_data values ('P000003','VENKATESH GADUPUTI','40','male','2019-02-07 04:03:37','P000001','1');
insert into profile_data values ('P000004','Philip Zhang','36','female','2019-02-08 01:19:59','P000001','1');
insert into profile_data values ('P000005','Naveen Kumar R ','37','male','2019-02-06 12:15:33','P000001','1');

	
insert into user_order_data values ('UO000001','a consumer order','98.89','7586.06','P000001','P000001','2019-02-07 14:37:55','1');
insert into user_order_data values ('UO000002','a consumer order0002','96.84','8154.77','P000001','P000001','2019-02-11 10:44:44','1');
insert into user_order_data values ('UO000003','a consumer order0003','91.09','7492.78','P000001','P000001','2019-02-07 22:41:06','1');
insert into user_order_data values ('UO000004','a consumer order0004','79.73','8010.07','P000001','P000001','2019-02-21 15:05:52','1');
insert into user_order_data values ('UO000005','a consumer order0005','78.34','9616.60','P000001','P000001','2019-02-21 03:01:11','1');
insert into user_order_data values ('UO000006','a consumer order0006','81.25','9511.45','P000002','P000001','2019-02-20 05:42:31','1');
insert into user_order_data values ('UO000007','a consumer order0007','90.21','9905.00','P000002','P000001','2019-02-20 01:26:08','1');
insert into user_order_data values ('UO000008','a consumer order0008','82.88','9372.50','P000002','P000001','2019-02-16 05:10:30','1');
insert into user_order_data values ('UO000009','a consumer order0009','70.61','9107.87','P000002','P000001','2019-02-04 21:40:06','1');
insert into user_order_data values ('UO000010','a consumer order0010','87.29','7699.48','P000002','P000001','2019-02-03 20:11:24','1');
insert into user_order_data values ('UO000011','a consumer order0011','71.14','8681.07','P000003','P000001','2019-02-02 20:16:15','1');
insert into user_order_data values ('UO000012','a consumer order0012','81.15','9678.67','P000003','P000001','2019-02-04 16:46:02','1');
insert into user_order_data values ('UO000013','a consumer order0013','81.21','8195.19','P000003','P000001','2019-02-08 07:33:50','1');
insert into user_order_data values ('UO000014','a consumer order0014','83.18','7553.54','P000003','P000001','2019-02-01 10:55:52','1');
insert into user_order_data values ('UO000015','a consumer order0015','91.19','8600.73','P000003','P000001','2019-02-16 23:18:11','1');
insert into user_order_data values ('UO000016','a consumer order0016','72.44','8293.65','P000004','P000001','2019-02-12 10:22:36','1');
insert into user_order_data values ('UO000017','a consumer order0017','97.02','7755.01','P000004','P000001','2019-02-15 11:52:50','1');
insert into user_order_data values ('UO000018','a consumer order0018','82.00','8434.58','P000004','P000001','2019-02-02 23:36:37','1');
insert into user_order_data values ('UO000019','a consumer order0019','92.47','7565.21','P000004','P000001','2019-02-15 03:28:16','1');
insert into user_order_data values ('UO000020','a consumer order0020','94.38','8687.68','P000004','P000001','2019-02-04 06:50:33','1');
insert into user_order_data values ('UO000021','a consumer order0021','79.80','9465.27','P000005','P000001','2019-02-05 04:01:19','1');
insert into user_order_data values ('UO000022','a consumer order0022','78.08','8257.15','P000005','P000001','2019-02-01 16:41:27','1');
insert into user_order_data values ('UO000023','a consumer order0023','96.28','7972.74','P000005','P000001','2019-02-02 16:50:06','1');
insert into user_order_data values ('UO000024','a consumer order0024','85.79','7910.44','P000005','P000001','2019-02-02 14:29:35','1');
insert into user_order_data values ('UO000025','a consumer order0025','75.22','8948.71','P000005','P000001','2019-02-19 10:09:50','1');

	
insert into line_item_data values ('LI000001','Jeans - Large','11','86.34','8.79','UO000001','1');
insert into line_item_data values ('LI000002','Jeans - Large0002','11','79.81','10.76','UO000001','1');
insert into line_item_data values ('LI000003','Jeans - Large0003','10','81.57','8.84','UO000001','1');
insert into line_item_data values ('LI000004','Jeans - Large0004','12','87.57','7.91','UO000001','1');
insert into line_item_data values ('LI000005','Jeans - Large0005','10','73.71','10.99','UO000001','1');
insert into line_item_data values ('LI000006','Jeans - Large0006','12','90.48','8.12','UO000002','1');
insert into line_item_data values ('LI000007','Jeans - Large0007','9','88.82','10.42','UO000002','1');
insert into line_item_data values ('LI000008','Jeans - Large0008','11','92.47','8.67','UO000002','1');
insert into line_item_data values ('LI000009','Jeans - Large0009','9','82.34','8.18','UO000002','1');
insert into line_item_data values ('LI000010','Jeans - Large0010','10','92.21','10.59','UO000002','1');
insert into line_item_data values ('LI000011','Jeans - Large0011','9','84.05','10.75','UO000003','1');
insert into line_item_data values ('LI000012','Jeans - Large0012','11','72.93','8.37','UO000003','1');
insert into line_item_data values ('LI000013','Jeans - Large0013','12','82.83','7.93','UO000003','1');
insert into line_item_data values ('LI000014','Jeans - Large0014','12','79.59','9.40','UO000003','1');
insert into line_item_data values ('LI000015','Jeans - Large0015','11','81.20','8.66','UO000003','1');
insert into line_item_data values ('LI000016','Jeans - Large0016','12','89.05','10.43','UO000004','1');
insert into line_item_data values ('LI000017','Jeans - Large0017','11','76.70','8.26','UO000004','1');
insert into line_item_data values ('LI000018','Jeans - Large0018','12','96.92','7.92','UO000004','1');
insert into line_item_data values ('LI000019','Jeans - Large0019','10','72.61','9.97','UO000004','1');
insert into line_item_data values ('LI000020','Jeans - Large0020','10','76.98','10.24','UO000004','1');
insert into line_item_data values ('LI000021','Jeans - Large0021','12','76.20','10.19','UO000005','1');
insert into line_item_data values ('LI000022','Jeans - Large0022','12','74.14','10.86','UO000005','1');
insert into line_item_data values ('LI000023','Jeans - Large0023','12','73.94','9.35','UO000005','1');
insert into line_item_data values ('LI000024','Jeans - Large0024','11','93.94','9.89','UO000005','1');
insert into line_item_data values ('LI000025','Jeans - Large0025','10','100.74','9.27','UO000005','1');
insert into line_item_data values ('LI000026','Jeans - Large0026','9','77.22','7.95','UO000006','1');
insert into line_item_data values ('LI000027','Jeans - Large0027','11','74.00','9.07','UO000006','1');
insert into line_item_data values ('LI000028','Jeans - Large0028','12','95.14','10.26','UO000006','1');
insert into line_item_data values ('LI000029','Jeans - Large0029','10','74.29','10.54','UO000006','1');
insert into line_item_data values ('LI000030','Jeans - Large0030','11','76.84','9.61','UO000006','1');
insert into line_item_data values ('LI000031','Jeans - Large0031','11','85.02','10.07','UO000007','1');
insert into line_item_data values ('LI000032','Jeans - Large0032','11','94.41','10.63','UO000007','1');
insert into line_item_data values ('LI000033','Jeans - Large0033','11','95.35','7.84','UO000007','1');
insert into line_item_data values ('LI000034','Jeans - Large0034','12','99.92','8.55','UO000007','1');
insert into line_item_data values ('LI000035','Jeans - Large0035','9','91.00','8.40','UO000007','1');
insert into line_item_data values ('LI000036','Jeans - Large0036','10','77.80','9.37','UO000008','1');
insert into line_item_data values ('LI000037','Jeans - Large0037','12','99.91','8.17','UO000008','1');
insert into line_item_data values ('LI000038','Jeans - Large0038','9','76.16','10.13','UO000008','1');
insert into line_item_data values ('LI000039','Jeans - Large0039','11','84.11','8.39','UO000008','1');
insert into line_item_data values ('LI000040','Jeans - Large0040','12','97.67','10.97','UO000008','1');
insert into line_item_data values ('LI000041','Jeans - Large0041','10','102.67','10.44','UO000009','1');
insert into line_item_data values ('LI000042','Jeans - Large0042','10','98.86','11.02','UO000009','1');
insert into line_item_data values ('LI000043','Jeans - Large0043','9','75.94','7.88','UO000009','1');
insert into line_item_data values ('LI000044','Jeans - Large0044','12','96.80','8.50','UO000009','1');
insert into line_item_data values ('LI000045','Jeans - Large0045','12','72.88','9.24','UO000009','1');
insert into line_item_data values ('LI000046','Jeans - Large0046','11','99.28','9.29','UO000010','1');
insert into line_item_data values ('LI000047','Jeans - Large0047','9','86.20','9.90','UO000010','1');
insert into line_item_data values ('LI000048','Jeans - Large0048','12','87.77','8.34','UO000010','1');
insert into line_item_data values ('LI000049','Jeans - Large0049','12','80.83','8.02','UO000010','1');
insert into line_item_data values ('LI000050','Jeans - Large0050','10','99.35','10.94','UO000010','1');
insert into line_item_data values ('LI000051','Jeans - Large0051','10','88.76','8.42','UO000011','1');
insert into line_item_data values ('LI000052','Jeans - Large0052','11','81.23','9.06','UO000011','1');
insert into line_item_data values ('LI000053','Jeans - Large0053','9','89.20','9.99','UO000011','1');
insert into line_item_data values ('LI000054','Jeans - Large0054','12','72.69','10.12','UO000011','1');
insert into line_item_data values ('LI000055','Jeans - Large0055','10','74.08','9.66','UO000011','1');
insert into line_item_data values ('LI000056','Jeans - Large0056','11','95.57','10.32','UO000012','1');
insert into line_item_data values ('LI000057','Jeans - Large0057','9','97.89','9.88','UO000012','1');
insert into line_item_data values ('LI000058','Jeans - Large0058','11','101.56','10.83','UO000012','1');
insert into line_item_data values ('LI000059','Jeans - Large0059','11','88.45','9.22','UO000012','1');
insert into line_item_data values ('LI000060','Jeans - Large0060','10','76.69','9.40','UO000012','1');
insert into line_item_data values ('LI000061','Jeans - Large0061','12','91.17','8.84','UO000013','1');
insert into line_item_data values ('LI000062','Jeans - Large0062','12','79.40','7.98','UO000013','1');
insert into line_item_data values ('LI000063','Jeans - Large0063','10','75.15','10.78','UO000013','1');
insert into line_item_data values ('LI000064','Jeans - Large0064','10','80.48','8.08','UO000013','1');
insert into line_item_data values ('LI000065','Jeans - Large0065','10','77.64','8.87','UO000013','1');
insert into line_item_data values ('LI000066','Jeans - Large0066','11','100.08','9.45','UO000014','1');
insert into line_item_data values ('LI000067','Jeans - Large0067','9','96.55','9.39','UO000014','1');
insert into line_item_data values ('LI000068','Jeans - Large0068','11','89.53','10.23','UO000014','1');
insert into line_item_data values ('LI000069','Jeans - Large0069','12','90.33','10.17','UO000014','1');
insert into line_item_data values ('LI000070','Jeans - Large0070','12','80.43','7.88','UO000014','1');
insert into line_item_data values ('LI000071','Jeans - Large0071','9','92.32','10.12','UO000015','1');
insert into line_item_data values ('LI000072','Jeans - Large0072','10','87.78','9.68','UO000015','1');
insert into line_item_data values ('LI000073','Jeans - Large0073','11','85.12','10.95','UO000015','1');
insert into line_item_data values ('LI000074','Jeans - Large0074','10','90.90','7.80','UO000015','1');
insert into line_item_data values ('LI000075','Jeans - Large0075','10','73.48','8.21','UO000015','1');
insert into line_item_data values ('LI000076','Jeans - Large0076','9','84.02','8.78','UO000016','1');
insert into line_item_data values ('LI000077','Jeans - Large0077','11','88.63','8.24','UO000016','1');
insert into line_item_data values ('LI000078','Jeans - Large0078','11','75.64','8.26','UO000016','1');
insert into line_item_data values ('LI000079','Jeans - Large0079','11','75.68','9.96','UO000016','1');
insert into line_item_data values ('LI000080','Jeans - Large0080','12','86.64','7.82','UO000016','1');
insert into line_item_data values ('LI000081','Jeans - Large0081','9','92.82','9.33','UO000017','1');
insert into line_item_data values ('LI000082','Jeans - Large0082','10','95.05','8.07','UO000017','1');
insert into line_item_data values ('LI000083','Jeans - Large0083','10','76.45','7.76','UO000017','1');
insert into line_item_data values ('LI000084','Jeans - Large0084','12','74.62','9.76','UO000017','1');
insert into line_item_data values ('LI000085','Jeans - Large0085','12','102.63','8.41','UO000017','1');
insert into line_item_data values ('LI000086','Jeans - Large0086','12','95.87','8.19','UO000018','1');
insert into line_item_data values ('LI000087','Jeans - Large0087','11','82.49','10.51','UO000018','1');
insert into line_item_data values ('LI000088','Jeans - Large0088','10','91.61','7.78','UO000018','1');
insert into line_item_data values ('LI000089','Jeans - Large0089','11','76.34','8.02','UO000018','1');
insert into line_item_data values ('LI000090','Jeans - Large0090','12','96.60','10.87','UO000018','1');
insert into line_item_data values ('LI000091','Jeans - Large0091','12','85.94','10.52','UO000019','1');
insert into line_item_data values ('LI000092','Jeans - Large0092','11','93.25','7.76','UO000019','1');
insert into line_item_data values ('LI000093','Jeans - Large0093','9','100.62','9.46','UO000019','1');
insert into line_item_data values ('LI000094','Jeans - Large0094','10','90.22','8.21','UO000019','1');
insert into line_item_data values ('LI000095','Jeans - Large0095','10','86.19','10.64','UO000019','1');
insert into line_item_data values ('LI000096','Jeans - Large0096','10','81.02','8.18','UO000020','1');
insert into line_item_data values ('LI000097','Jeans - Large0097','12','75.61','9.86','UO000020','1');
insert into line_item_data values ('LI000098','Jeans - Large0098','12','94.06','8.68','UO000020','1');
insert into line_item_data values ('LI000099','Jeans - Large0099','12','85.08','10.59','UO000020','1');
insert into line_item_data values ('LI000100','Jeans - Large0100','9','81.97','10.72','UO000020','1');
insert into line_item_data values ('LI000101','Jeans - Large0101','12','87.38','9.08','UO000021','1');
insert into line_item_data values ('LI000102','Jeans - Large0102','12','73.50','10.40','UO000021','1');
insert into line_item_data values ('LI000103','Jeans - Large0103','11','91.79','9.71','UO000021','1');
insert into line_item_data values ('LI000104','Jeans - Large0104','11','83.20','9.05','UO000021','1');
insert into line_item_data values ('LI000105','Jeans - Large0105','9','97.36','9.39','UO000021','1');
insert into line_item_data values ('LI000106','Jeans - Large0106','12','85.69','8.73','UO000022','1');
insert into line_item_data values ('LI000107','Jeans - Large0107','9','72.46','9.38','UO000022','1');
insert into line_item_data values ('LI000108','Jeans - Large0108','11','93.59','7.77','UO000022','1');
insert into line_item_data values ('LI000109','Jeans - Large0109','12','100.18','7.90','UO000022','1');
insert into line_item_data values ('LI000110','Jeans - Large0110','11','88.04','9.43','UO000022','1');
insert into line_item_data values ('LI000111','Jeans - Large0111','11','95.54','9.80','UO000023','1');
insert into line_item_data values ('LI000112','Jeans - Large0112','11','82.94','7.77','UO000023','1');
insert into line_item_data values ('LI000113','Jeans - Large0113','11','97.23','9.74','UO000023','1');
insert into line_item_data values ('LI000114','Jeans - Large0114','10','79.65','8.85','UO000023','1');
insert into line_item_data values ('LI000115','Jeans - Large0115','12','82.71','9.52','UO000023','1');
insert into line_item_data values ('LI000116','Jeans - Large0116','9','93.36','9.02','UO000024','1');
insert into line_item_data values ('LI000117','Jeans - Large0117','9','88.12','9.27','UO000024','1');
insert into line_item_data values ('LI000118','Jeans - Large0118','11','82.08','8.31','UO000024','1');
insert into line_item_data values ('LI000119','Jeans - Large0119','12','98.25','9.56','UO000024','1');
insert into line_item_data values ('LI000120','Jeans - Large0120','12','72.92','9.25','UO000024','1');
insert into line_item_data values ('LI000121','Jeans - Large0121','11','87.31','9.58','UO000025','1');
insert into line_item_data values ('LI000122','Jeans - Large0122','12','88.46','10.98','UO000025','1');
insert into line_item_data values ('LI000123','Jeans - Large0123','12','96.40','9.79','UO000025','1');
insert into line_item_data values ('LI000124','Jeans - Large0124','12','99.77','9.25','UO000025','1');
insert into line_item_data values ('LI000125','Jeans - Large0125','12','102.63','8.52','UO000025','1');

	
insert into order_promotion_data values ('OP000001','Promo For Total','975','931','PERCENT_OFF','UO000001','1');
insert into order_promotion_data values ('OP000002','Promo For Total0002','1032','1152','FIX_PRICE','UO000001','1');
insert into order_promotion_data values ('OP000003','Promo For Total0003','1153','1166','PERCENT_OFF','UO000001','1');
insert into order_promotion_data values ('OP000004','Promo For Total0004','1082','865','FIX_PRICE','UO000001','1');
insert into order_promotion_data values ('OP000005','Promo For Total0005','1048','1170','PERCENT_OFF','UO000001','1');
insert into order_promotion_data values ('OP000006','Promo For Total0006','1167','1223','FIX_PRICE','UO000002','1');
insert into order_promotion_data values ('OP000007','Promo For Total0007','1053','1084','PERCENT_OFF','UO000002','1');
insert into order_promotion_data values ('OP000008','Promo For Total0008','1182','914','FIX_PRICE','UO000002','1');
insert into order_promotion_data values ('OP000009','Promo For Total0009','999','1037','PERCENT_OFF','UO000002','1');
insert into order_promotion_data values ('OP000010','Promo For Total0010','1042','1155','FIX_PRICE','UO000002','1');
insert into order_promotion_data values ('OP000011','Promo For Total0011','895','1054','PERCENT_OFF','UO000003','1');
insert into order_promotion_data values ('OP000012','Promo For Total0012','911','1152','FIX_PRICE','UO000003','1');
insert into order_promotion_data values ('OP000013','Promo For Total0013','1223','1174','PERCENT_OFF','UO000003','1');
insert into order_promotion_data values ('OP000014','Promo For Total0014','923','1160','FIX_PRICE','UO000003','1');
insert into order_promotion_data values ('OP000015','Promo For Total0015','1081','950','PERCENT_OFF','UO000003','1');
insert into order_promotion_data values ('OP000016','Promo For Total0016','1078','986','FIX_PRICE','UO000004','1');
insert into order_promotion_data values ('OP000017','Promo For Total0017','1056','1195','PERCENT_OFF','UO000004','1');
insert into order_promotion_data values ('OP000018','Promo For Total0018','998','963','FIX_PRICE','UO000004','1');
insert into order_promotion_data values ('OP000019','Promo For Total0019','1129','1065','PERCENT_OFF','UO000004','1');
insert into order_promotion_data values ('OP000020','Promo For Total0020','955','965','FIX_PRICE','UO000004','1');
insert into order_promotion_data values ('OP000021','Promo For Total0021','926','993','PERCENT_OFF','UO000005','1');
insert into order_promotion_data values ('OP000022','Promo For Total0022','1201','1187','FIX_PRICE','UO000005','1');
insert into order_promotion_data values ('OP000023','Promo For Total0023','1049','864','PERCENT_OFF','UO000005','1');
insert into order_promotion_data values ('OP000024','Promo For Total0024','1144','1105','FIX_PRICE','UO000005','1');
insert into order_promotion_data values ('OP000025','Promo For Total0025','1151','1024','PERCENT_OFF','UO000005','1');
insert into order_promotion_data values ('OP000026','Promo For Total0026','967','880','FIX_PRICE','UO000006','1');
insert into order_promotion_data values ('OP000027','Promo For Total0027','964','1160','PERCENT_OFF','UO000006','1');
insert into order_promotion_data values ('OP000028','Promo For Total0028','908','1123','FIX_PRICE','UO000006','1');
insert into order_promotion_data values ('OP000029','Promo For Total0029','1009','1138','PERCENT_OFF','UO000006','1');
insert into order_promotion_data values ('OP000030','Promo For Total0030','948','1153','FIX_PRICE','UO000006','1');
insert into order_promotion_data values ('OP000031','Promo For Total0031','894','938','PERCENT_OFF','UO000007','1');
insert into order_promotion_data values ('OP000032','Promo For Total0032','992','910','FIX_PRICE','UO000007','1');
insert into order_promotion_data values ('OP000033','Promo For Total0033','904','1121','PERCENT_OFF','UO000007','1');
insert into order_promotion_data values ('OP000034','Promo For Total0034','911','1197','FIX_PRICE','UO000007','1');
insert into order_promotion_data values ('OP000035','Promo For Total0035','1079','1000','PERCENT_OFF','UO000007','1');
insert into order_promotion_data values ('OP000036','Promo For Total0036','1109','904','FIX_PRICE','UO000008','1');
insert into order_promotion_data values ('OP000037','Promo For Total0037','1104','1215','PERCENT_OFF','UO000008','1');
insert into order_promotion_data values ('OP000038','Promo For Total0038','1201','880','FIX_PRICE','UO000008','1');
insert into order_promotion_data values ('OP000039','Promo For Total0039','896','1005','PERCENT_OFF','UO000008','1');
insert into order_promotion_data values ('OP000040','Promo For Total0040','1126','1211','FIX_PRICE','UO000008','1');
insert into order_promotion_data values ('OP000041','Promo For Total0041','1144','1182','PERCENT_OFF','UO000009','1');
insert into order_promotion_data values ('OP000042','Promo For Total0042','1057','1169','FIX_PRICE','UO000009','1');
insert into order_promotion_data values ('OP000043','Promo For Total0043','965','1176','PERCENT_OFF','UO000009','1');
insert into order_promotion_data values ('OP000044','Promo For Total0044','1174','1210','FIX_PRICE','UO000009','1');
insert into order_promotion_data values ('OP000045','Promo For Total0045','970','1154','PERCENT_OFF','UO000009','1');
insert into order_promotion_data values ('OP000046','Promo For Total0046','995','906','FIX_PRICE','UO000010','1');
insert into order_promotion_data values ('OP000047','Promo For Total0047','1154','968','PERCENT_OFF','UO000010','1');
insert into order_promotion_data values ('OP000048','Promo For Total0048','1061','1229','FIX_PRICE','UO000010','1');
insert into order_promotion_data values ('OP000049','Promo For Total0049','1071','1165','PERCENT_OFF','UO000010','1');
insert into order_promotion_data values ('OP000050','Promo For Total0050','869','918','FIX_PRICE','UO000010','1');
insert into order_promotion_data values ('OP000051','Promo For Total0051','1123','970','PERCENT_OFF','UO000011','1');
insert into order_promotion_data values ('OP000052','Promo For Total0052','1055','1199','FIX_PRICE','UO000011','1');
insert into order_promotion_data values ('OP000053','Promo For Total0053','1005','964','PERCENT_OFF','UO000011','1');
insert into order_promotion_data values ('OP000054','Promo For Total0054','1016','888','FIX_PRICE','UO000011','1');
insert into order_promotion_data values ('OP000055','Promo For Total0055','1092','912','PERCENT_OFF','UO000011','1');
insert into order_promotion_data values ('OP000056','Promo For Total0056','877','1029','FIX_PRICE','UO000012','1');
insert into order_promotion_data values ('OP000057','Promo For Total0057','1156','870','PERCENT_OFF','UO000012','1');
insert into order_promotion_data values ('OP000058','Promo For Total0058','867','901','FIX_PRICE','UO000012','1');
insert into order_promotion_data values ('OP000059','Promo For Total0059','1152','951','PERCENT_OFF','UO000012','1');
insert into order_promotion_data values ('OP000060','Promo For Total0060','1027','1104','FIX_PRICE','UO000012','1');
insert into order_promotion_data values ('OP000061','Promo For Total0061','1014','1024','PERCENT_OFF','UO000013','1');
insert into order_promotion_data values ('OP000062','Promo For Total0062','1134','1015','FIX_PRICE','UO000013','1');
insert into order_promotion_data values ('OP000063','Promo For Total0063','1070','1157','PERCENT_OFF','UO000013','1');
insert into order_promotion_data values ('OP000064','Promo For Total0064','873','1187','FIX_PRICE','UO000013','1');
insert into order_promotion_data values ('OP000065','Promo For Total0065','865','1088','PERCENT_OFF','UO000013','1');
insert into order_promotion_data values ('OP000066','Promo For Total0066','1188','989','FIX_PRICE','UO000014','1');
insert into order_promotion_data values ('OP000067','Promo For Total0067','934','1001','PERCENT_OFF','UO000014','1');
insert into order_promotion_data values ('OP000068','Promo For Total0068','1137','1114','FIX_PRICE','UO000014','1');
insert into order_promotion_data values ('OP000069','Promo For Total0069','1097','895','PERCENT_OFF','UO000014','1');
insert into order_promotion_data values ('OP000070','Promo For Total0070','872','1097','FIX_PRICE','UO000014','1');
insert into order_promotion_data values ('OP000071','Promo For Total0071','1071','977','PERCENT_OFF','UO000015','1');
insert into order_promotion_data values ('OP000072','Promo For Total0072','960','1011','FIX_PRICE','UO000015','1');
insert into order_promotion_data values ('OP000073','Promo For Total0073','1014','953','PERCENT_OFF','UO000015','1');
insert into order_promotion_data values ('OP000074','Promo For Total0074','1146','1167','FIX_PRICE','UO000015','1');
insert into order_promotion_data values ('OP000075','Promo For Total0075','1041','961','PERCENT_OFF','UO000015','1');
insert into order_promotion_data values ('OP000076','Promo For Total0076','1057','910','FIX_PRICE','UO000016','1');
insert into order_promotion_data values ('OP000077','Promo For Total0077','1169','898','PERCENT_OFF','UO000016','1');
insert into order_promotion_data values ('OP000078','Promo For Total0078','1153','1177','FIX_PRICE','UO000016','1');
insert into order_promotion_data values ('OP000079','Promo For Total0079','1115','943','PERCENT_OFF','UO000016','1');
insert into order_promotion_data values ('OP000080','Promo For Total0080','1109','1010','FIX_PRICE','UO000016','1');
insert into order_promotion_data values ('OP000081','Promo For Total0081','946','921','PERCENT_OFF','UO000017','1');
insert into order_promotion_data values ('OP000082','Promo For Total0082','1086','1098','FIX_PRICE','UO000017','1');
insert into order_promotion_data values ('OP000083','Promo For Total0083','1068','1132','PERCENT_OFF','UO000017','1');
insert into order_promotion_data values ('OP000084','Promo For Total0084','886','1154','FIX_PRICE','UO000017','1');
insert into order_promotion_data values ('OP000085','Promo For Total0085','1117','1091','PERCENT_OFF','UO000017','1');
insert into order_promotion_data values ('OP000086','Promo For Total0086','1225','922','FIX_PRICE','UO000018','1');
insert into order_promotion_data values ('OP000087','Promo For Total0087','975','981','PERCENT_OFF','UO000018','1');
insert into order_promotion_data values ('OP000088','Promo For Total0088','1169','959','FIX_PRICE','UO000018','1');
insert into order_promotion_data values ('OP000089','Promo For Total0089','1079','1217','PERCENT_OFF','UO000018','1');
insert into order_promotion_data values ('OP000090','Promo For Total0090','1170','955','FIX_PRICE','UO000018','1');
insert into order_promotion_data values ('OP000091','Promo For Total0091','877','968','PERCENT_OFF','UO000019','1');
insert into order_promotion_data values ('OP000092','Promo For Total0092','869','1210','FIX_PRICE','UO000019','1');
insert into order_promotion_data values ('OP000093','Promo For Total0093','1060','1166','PERCENT_OFF','UO000019','1');
insert into order_promotion_data values ('OP000094','Promo For Total0094','920','922','FIX_PRICE','UO000019','1');
insert into order_promotion_data values ('OP000095','Promo For Total0095','871','948','PERCENT_OFF','UO000019','1');
insert into order_promotion_data values ('OP000096','Promo For Total0096','996','1110','FIX_PRICE','UO000020','1');
insert into order_promotion_data values ('OP000097','Promo For Total0097','1017','1107','PERCENT_OFF','UO000020','1');
insert into order_promotion_data values ('OP000098','Promo For Total0098','970','1106','FIX_PRICE','UO000020','1');
insert into order_promotion_data values ('OP000099','Promo For Total0099','879','947','PERCENT_OFF','UO000020','1');
insert into order_promotion_data values ('OP000100','Promo For Total0100','965','1041','FIX_PRICE','UO000020','1');
insert into order_promotion_data values ('OP000101','Promo For Total0101','1157','1083','PERCENT_OFF','UO000021','1');
insert into order_promotion_data values ('OP000102','Promo For Total0102','1054','911','FIX_PRICE','UO000021','1');
insert into order_promotion_data values ('OP000103','Promo For Total0103','1110','980','PERCENT_OFF','UO000021','1');
insert into order_promotion_data values ('OP000104','Promo For Total0104','1068','1208','FIX_PRICE','UO000021','1');
insert into order_promotion_data values ('OP000105','Promo For Total0105','1182','1022','PERCENT_OFF','UO000021','1');
insert into order_promotion_data values ('OP000106','Promo For Total0106','1173','1226','FIX_PRICE','UO000022','1');
insert into order_promotion_data values ('OP000107','Promo For Total0107','1166','1158','PERCENT_OFF','UO000022','1');
insert into order_promotion_data values ('OP000108','Promo For Total0108','1173','1172','FIX_PRICE','UO000022','1');
insert into order_promotion_data values ('OP000109','Promo For Total0109','1131','1135','PERCENT_OFF','UO000022','1');
insert into order_promotion_data values ('OP000110','Promo For Total0110','1029','999','FIX_PRICE','UO000022','1');
insert into order_promotion_data values ('OP000111','Promo For Total0111','1214','1046','PERCENT_OFF','UO000023','1');
insert into order_promotion_data values ('OP000112','Promo For Total0112','1193','1185','FIX_PRICE','UO000023','1');
insert into order_promotion_data values ('OP000113','Promo For Total0113','1120','1074','PERCENT_OFF','UO000023','1');
insert into order_promotion_data values ('OP000114','Promo For Total0114','927','1211','FIX_PRICE','UO000023','1');
insert into order_promotion_data values ('OP000115','Promo For Total0115','1147','1220','PERCENT_OFF','UO000023','1');
insert into order_promotion_data values ('OP000116','Promo For Total0116','966','924','FIX_PRICE','UO000024','1');
insert into order_promotion_data values ('OP000117','Promo For Total0117','1191','899','PERCENT_OFF','UO000024','1');
insert into order_promotion_data values ('OP000118','Promo For Total0118','1227','946','FIX_PRICE','UO000024','1');
insert into order_promotion_data values ('OP000119','Promo For Total0119','953','996','PERCENT_OFF','UO000024','1');
insert into order_promotion_data values ('OP000120','Promo For Total0120','1178','1130','FIX_PRICE','UO000024','1');
insert into order_promotion_data values ('OP000121','Promo For Total0121','956','956','PERCENT_OFF','UO000025','1');
insert into order_promotion_data values ('OP000122','Promo For Total0122','979','1152','FIX_PRICE','UO000025','1');
insert into order_promotion_data values ('OP000123','Promo For Total0123','1005','979','PERCENT_OFF','UO000025','1');
insert into order_promotion_data values ('OP000124','Promo For Total0124','973','1002','FIX_PRICE','UO000025','1');
insert into order_promotion_data values ('OP000125','Promo For Total0125','1199','953','PERCENT_OFF','UO000025','1');

	
insert into manual_adjustment_data values ('MA000001','Promo For Total','1134','965','OFF','UO000001','1');
insert into manual_adjustment_data values ('MA000002','Promo For Total0002','869','934','FIX_PRICE','UO000001','1');
insert into manual_adjustment_data values ('MA000003','Promo For Total0003','1065','1088','OFF','UO000001','1');
insert into manual_adjustment_data values ('MA000004','Promo For Total0004','1000','1029','FIX_PRICE','UO000001','1');
insert into manual_adjustment_data values ('MA000005','Promo For Total0005','984','901','OFF','UO000001','1');
insert into manual_adjustment_data values ('MA000006','Promo For Total0006','1063','1053','FIX_PRICE','UO000002','1');
insert into manual_adjustment_data values ('MA000007','Promo For Total0007','1169','1014','OFF','UO000002','1');
insert into manual_adjustment_data values ('MA000008','Promo For Total0008','863','892','FIX_PRICE','UO000002','1');
insert into manual_adjustment_data values ('MA000009','Promo For Total0009','1134','930','OFF','UO000002','1');
insert into manual_adjustment_data values ('MA000010','Promo For Total0010','1009','981','FIX_PRICE','UO000002','1');
insert into manual_adjustment_data values ('MA000011','Promo For Total0011','1120','877','OFF','UO000003','1');
insert into manual_adjustment_data values ('MA000012','Promo For Total0012','1178','1091','FIX_PRICE','UO000003','1');
insert into manual_adjustment_data values ('MA000013','Promo For Total0013','1131','901','OFF','UO000003','1');
insert into manual_adjustment_data values ('MA000014','Promo For Total0014','1123','1209','FIX_PRICE','UO000003','1');
insert into manual_adjustment_data values ('MA000015','Promo For Total0015','952','986','OFF','UO000003','1');
insert into manual_adjustment_data values ('MA000016','Promo For Total0016','1126','1211','FIX_PRICE','UO000004','1');
insert into manual_adjustment_data values ('MA000017','Promo For Total0017','1154','1121','OFF','UO000004','1');
insert into manual_adjustment_data values ('MA000018','Promo For Total0018','995','977','FIX_PRICE','UO000004','1');
insert into manual_adjustment_data values ('MA000019','Promo For Total0019','1016','1217','OFF','UO000004','1');
insert into manual_adjustment_data values ('MA000020','Promo For Total0020','1208','1089','FIX_PRICE','UO000004','1');
insert into manual_adjustment_data values ('MA000021','Promo For Total0021','891','1142','OFF','UO000005','1');
insert into manual_adjustment_data values ('MA000022','Promo For Total0022','1043','1177','FIX_PRICE','UO000005','1');
insert into manual_adjustment_data values ('MA000023','Promo For Total0023','896','1130','OFF','UO000005','1');
insert into manual_adjustment_data values ('MA000024','Promo For Total0024','1043','1125','FIX_PRICE','UO000005','1');
insert into manual_adjustment_data values ('MA000025','Promo For Total0025','1127','1007','OFF','UO000005','1');
insert into manual_adjustment_data values ('MA000026','Promo For Total0026','889','1065','FIX_PRICE','UO000006','1');
insert into manual_adjustment_data values ('MA000027','Promo For Total0027','983','1175','OFF','UO000006','1');
insert into manual_adjustment_data values ('MA000028','Promo For Total0028','956','978','FIX_PRICE','UO000006','1');
insert into manual_adjustment_data values ('MA000029','Promo For Total0029','974','1007','OFF','UO000006','1');
insert into manual_adjustment_data values ('MA000030','Promo For Total0030','916','1127','FIX_PRICE','UO000006','1');
insert into manual_adjustment_data values ('MA000031','Promo For Total0031','1218','1171','OFF','UO000007','1');
insert into manual_adjustment_data values ('MA000032','Promo For Total0032','1030','990','FIX_PRICE','UO000007','1');
insert into manual_adjustment_data values ('MA000033','Promo For Total0033','894','1033','OFF','UO000007','1');
insert into manual_adjustment_data values ('MA000034','Promo For Total0034','1182','1105','FIX_PRICE','UO000007','1');
insert into manual_adjustment_data values ('MA000035','Promo For Total0035','1047','985','OFF','UO000007','1');
insert into manual_adjustment_data values ('MA000036','Promo For Total0036','1174','1048','FIX_PRICE','UO000008','1');
insert into manual_adjustment_data values ('MA000037','Promo For Total0037','932','936','OFF','UO000008','1');
insert into manual_adjustment_data values ('MA000038','Promo For Total0038','1009','904','FIX_PRICE','UO000008','1');
insert into manual_adjustment_data values ('MA000039','Promo For Total0039','1192','890','OFF','UO000008','1');
insert into manual_adjustment_data values ('MA000040','Promo For Total0040','1221','1028','FIX_PRICE','UO000008','1');
insert into manual_adjustment_data values ('MA000041','Promo For Total0041','1182','968','OFF','UO000009','1');
insert into manual_adjustment_data values ('MA000042','Promo For Total0042','987','963','FIX_PRICE','UO000009','1');
insert into manual_adjustment_data values ('MA000043','Promo For Total0043','1127','1188','OFF','UO000009','1');
insert into manual_adjustment_data values ('MA000044','Promo For Total0044','1101','1034','FIX_PRICE','UO000009','1');
insert into manual_adjustment_data values ('MA000045','Promo For Total0045','1079','918','OFF','UO000009','1');
insert into manual_adjustment_data values ('MA000046','Promo For Total0046','934','1136','FIX_PRICE','UO000010','1');
insert into manual_adjustment_data values ('MA000047','Promo For Total0047','1173','957','OFF','UO000010','1');
insert into manual_adjustment_data values ('MA000048','Promo For Total0048','1036','970','FIX_PRICE','UO000010','1');
insert into manual_adjustment_data values ('MA000049','Promo For Total0049','1064','906','OFF','UO000010','1');
insert into manual_adjustment_data values ('MA000050','Promo For Total0050','901','1111','FIX_PRICE','UO000010','1');
insert into manual_adjustment_data values ('MA000051','Promo For Total0051','1066','872','OFF','UO000011','1');
insert into manual_adjustment_data values ('MA000052','Promo For Total0052','868','1163','FIX_PRICE','UO000011','1');
insert into manual_adjustment_data values ('MA000053','Promo For Total0053','1162','1170','OFF','UO000011','1');
insert into manual_adjustment_data values ('MA000054','Promo For Total0054','1168','883','FIX_PRICE','UO000011','1');
insert into manual_adjustment_data values ('MA000055','Promo For Total0055','1146','920','OFF','UO000011','1');
insert into manual_adjustment_data values ('MA000056','Promo For Total0056','871','1168','FIX_PRICE','UO000012','1');
insert into manual_adjustment_data values ('MA000057','Promo For Total0057','940','1021','OFF','UO000012','1');
insert into manual_adjustment_data values ('MA000058','Promo For Total0058','1113','1147','FIX_PRICE','UO000012','1');
insert into manual_adjustment_data values ('MA000059','Promo For Total0059','1155','1084','OFF','UO000012','1');
insert into manual_adjustment_data values ('MA000060','Promo For Total0060','1136','883','FIX_PRICE','UO000012','1');
insert into manual_adjustment_data values ('MA000061','Promo For Total0061','1137','1130','OFF','UO000013','1');
insert into manual_adjustment_data values ('MA000062','Promo For Total0062','1212','1226','FIX_PRICE','UO000013','1');
insert into manual_adjustment_data values ('MA000063','Promo For Total0063','1142','1179','OFF','UO000013','1');
insert into manual_adjustment_data values ('MA000064','Promo For Total0064','934','922','FIX_PRICE','UO000013','1');
insert into manual_adjustment_data values ('MA000065','Promo For Total0065','875','1032','OFF','UO000013','1');
insert into manual_adjustment_data values ('MA000066','Promo For Total0066','1226','1214','FIX_PRICE','UO000014','1');
insert into manual_adjustment_data values ('MA000067','Promo For Total0067','1108','1076','OFF','UO000014','1');
insert into manual_adjustment_data values ('MA000068','Promo For Total0068','897','1002','FIX_PRICE','UO000014','1');
insert into manual_adjustment_data values ('MA000069','Promo For Total0069','914','989','OFF','UO000014','1');
insert into manual_adjustment_data values ('MA000070','Promo For Total0070','1219','964','FIX_PRICE','UO000014','1');
insert into manual_adjustment_data values ('MA000071','Promo For Total0071','1132','1011','OFF','UO000015','1');
insert into manual_adjustment_data values ('MA000072','Promo For Total0072','1097','879','FIX_PRICE','UO000015','1');
insert into manual_adjustment_data values ('MA000073','Promo For Total0073','1142','1007','OFF','UO000015','1');
insert into manual_adjustment_data values ('MA000074','Promo For Total0074','873','964','FIX_PRICE','UO000015','1');
insert into manual_adjustment_data values ('MA000075','Promo For Total0075','1008','1191','OFF','UO000015','1');
insert into manual_adjustment_data values ('MA000076','Promo For Total0076','1000','926','FIX_PRICE','UO000016','1');
insert into manual_adjustment_data values ('MA000077','Promo For Total0077','1090','1180','OFF','UO000016','1');
insert into manual_adjustment_data values ('MA000078','Promo For Total0078','985','1200','FIX_PRICE','UO000016','1');
insert into manual_adjustment_data values ('MA000079','Promo For Total0079','948','935','OFF','UO000016','1');
insert into manual_adjustment_data values ('MA000080','Promo For Total0080','1220','1158','FIX_PRICE','UO000016','1');
insert into manual_adjustment_data values ('MA000081','Promo For Total0081','1083','1135','OFF','UO000017','1');
insert into manual_adjustment_data values ('MA000082','Promo For Total0082','926','1055','FIX_PRICE','UO000017','1');
insert into manual_adjustment_data values ('MA000083','Promo For Total0083','1084','1173','OFF','UO000017','1');
insert into manual_adjustment_data values ('MA000084','Promo For Total0084','1034','1152','FIX_PRICE','UO000017','1');
insert into manual_adjustment_data values ('MA000085','Promo For Total0085','1182','1086','OFF','UO000017','1');
insert into manual_adjustment_data values ('MA000086','Promo For Total0086','945','932','FIX_PRICE','UO000018','1');
insert into manual_adjustment_data values ('MA000087','Promo For Total0087','1153','1145','OFF','UO000018','1');
insert into manual_adjustment_data values ('MA000088','Promo For Total0088','1011','963','FIX_PRICE','UO000018','1');
insert into manual_adjustment_data values ('MA000089','Promo For Total0089','899','993','OFF','UO000018','1');
insert into manual_adjustment_data values ('MA000090','Promo For Total0090','1075','1090','FIX_PRICE','UO000018','1');
insert into manual_adjustment_data values ('MA000091','Promo For Total0091','1228','1055','OFF','UO000019','1');
insert into manual_adjustment_data values ('MA000092','Promo For Total0092','1200','864','FIX_PRICE','UO000019','1');
insert into manual_adjustment_data values ('MA000093','Promo For Total0093','1062','863','OFF','UO000019','1');
insert into manual_adjustment_data values ('MA000094','Promo For Total0094','895','1165','FIX_PRICE','UO000019','1');
insert into manual_adjustment_data values ('MA000095','Promo For Total0095','987','954','OFF','UO000019','1');
insert into manual_adjustment_data values ('MA000096','Promo For Total0096','1094','944','FIX_PRICE','UO000020','1');
insert into manual_adjustment_data values ('MA000097','Promo For Total0097','1034','1105','OFF','UO000020','1');
insert into manual_adjustment_data values ('MA000098','Promo For Total0098','958','1188','FIX_PRICE','UO000020','1');
insert into manual_adjustment_data values ('MA000099','Promo For Total0099','1192','1160','OFF','UO000020','1');
insert into manual_adjustment_data values ('MA000100','Promo For Total0100','866','1145','FIX_PRICE','UO000020','1');
insert into manual_adjustment_data values ('MA000101','Promo For Total0101','993','1007','OFF','UO000021','1');
insert into manual_adjustment_data values ('MA000102','Promo For Total0102','1085','1134','FIX_PRICE','UO000021','1');
insert into manual_adjustment_data values ('MA000103','Promo For Total0103','950','946','OFF','UO000021','1');
insert into manual_adjustment_data values ('MA000104','Promo For Total0104','1037','1128','FIX_PRICE','UO000021','1');
insert into manual_adjustment_data values ('MA000105','Promo For Total0105','1155','1040','OFF','UO000021','1');
insert into manual_adjustment_data values ('MA000106','Promo For Total0106','972','1106','FIX_PRICE','UO000022','1');
insert into manual_adjustment_data values ('MA000107','Promo For Total0107','910','993','OFF','UO000022','1');
insert into manual_adjustment_data values ('MA000108','Promo For Total0108','1004','1085','FIX_PRICE','UO000022','1');
insert into manual_adjustment_data values ('MA000109','Promo For Total0109','1191','986','OFF','UO000022','1');
insert into manual_adjustment_data values ('MA000110','Promo For Total0110','1047','1202','FIX_PRICE','UO000022','1');
insert into manual_adjustment_data values ('MA000111','Promo For Total0111','990','979','OFF','UO000023','1');
insert into manual_adjustment_data values ('MA000112','Promo For Total0112','1163','873','FIX_PRICE','UO000023','1');
insert into manual_adjustment_data values ('MA000113','Promo For Total0113','1156','905','OFF','UO000023','1');
insert into manual_adjustment_data values ('MA000114','Promo For Total0114','1110','1155','FIX_PRICE','UO000023','1');
insert into manual_adjustment_data values ('MA000115','Promo For Total0115','1111','933','OFF','UO000023','1');
insert into manual_adjustment_data values ('MA000116','Promo For Total0116','1091','979','FIX_PRICE','UO000024','1');
insert into manual_adjustment_data values ('MA000117','Promo For Total0117','1074','1144','OFF','UO000024','1');
insert into manual_adjustment_data values ('MA000118','Promo For Total0118','1154','1187','FIX_PRICE','UO000024','1');
insert into manual_adjustment_data values ('MA000119','Promo For Total0119','1111','887','OFF','UO000024','1');
insert into manual_adjustment_data values ('MA000120','Promo For Total0120','955','1026','FIX_PRICE','UO000024','1');
insert into manual_adjustment_data values ('MA000121','Promo For Total0121','1034','869','OFF','UO000025','1');
insert into manual_adjustment_data values ('MA000122','Promo For Total0122','952','1027','FIX_PRICE','UO000025','1');
insert into manual_adjustment_data values ('MA000123','Promo For Total0123','1111','972','OFF','UO000025','1');
insert into manual_adjustment_data values ('MA000124','Promo For Total0124','995','1003','FIX_PRICE','UO000025','1');
insert into manual_adjustment_data values ('MA000125','Promo For Total0125','1007','1084','OFF','UO000025','1');

	
insert into shipping_group_data values ('SG000001','Ship To Home','1900 AVE OF THE STARTS - ','Suite 555 - ','Century City - ','CA','941134','US','UO000001','1');
insert into shipping_group_data values ('SG000002','Ship To Home0002','1900 AVE OF THE STARTS - 0002','Suite 555 - 0002','Century City - 0002','VA','749359','US','UO000001','1');
insert into shipping_group_data values ('SG000003','Ship To Home0003','1900 AVE OF THE STARTS - 0003','Suite 555 - 0003','Century City - 0003','MA','722020','US','UO000001','1');
insert into shipping_group_data values ('SG000004','Ship To Home0004','1900 AVE OF THE STARTS - 0004','Suite 555 - 0004','Century City - 0004','PA','881122','US','UO000001','1');
insert into shipping_group_data values ('SG000005','Ship To Home0005','1900 AVE OF THE STARTS - 0005','Suite 555 - 0005','Century City - 0005','WA','702059','US','UO000001','1');
insert into shipping_group_data values ('SG000006','Ship To Home0006','1900 AVE OF THE STARTS - 0006','Suite 555 - 0006','Century City - 0006','LA','871901','US','UO000002','1');
insert into shipping_group_data values ('SG000007','Ship To Home0007','1900 AVE OF THE STARTS - 0007','Suite 555 - 0007','Century City - 0007','CA','735774','US','UO000002','1');
insert into shipping_group_data values ('SG000008','Ship To Home0008','1900 AVE OF THE STARTS - 0008','Suite 555 - 0008','Century City - 0008','VA','886145','US','UO000002','1');
insert into shipping_group_data values ('SG000009','Ship To Home0009','1900 AVE OF THE STARTS - 0009','Suite 555 - 0009','Century City - 0009','MA','790402','US','UO000002','1');
insert into shipping_group_data values ('SG000010','Ship To Home0010','1900 AVE OF THE STARTS - 0010','Suite 555 - 0010','Century City - 0010','PA','922704','US','UO000002','1');
insert into shipping_group_data values ('SG000011','Ship To Home0011','1900 AVE OF THE STARTS - 0011','Suite 555 - 0011','Century City - 0011','WA','764901','US','UO000003','1');
insert into shipping_group_data values ('SG000012','Ship To Home0012','1900 AVE OF THE STARTS - 0012','Suite 555 - 0012','Century City - 0012','LA','913299','US','UO000003','1');
insert into shipping_group_data values ('SG000013','Ship To Home0013','1900 AVE OF THE STARTS - 0013','Suite 555 - 0013','Century City - 0013','CA','819605','US','UO000003','1');
insert into shipping_group_data values ('SG000014','Ship To Home0014','1900 AVE OF THE STARTS - 0014','Suite 555 - 0014','Century City - 0014','VA','856111','US','UO000003','1');
insert into shipping_group_data values ('SG000015','Ship To Home0015','1900 AVE OF THE STARTS - 0015','Suite 555 - 0015','Century City - 0015','MA','914279','US','UO000003','1');
insert into shipping_group_data values ('SG000016','Ship To Home0016','1900 AVE OF THE STARTS - 0016','Suite 555 - 0016','Century City - 0016','PA','765517','US','UO000004','1');
insert into shipping_group_data values ('SG000017','Ship To Home0017','1900 AVE OF THE STARTS - 0017','Suite 555 - 0017','Century City - 0017','WA','688766','US','UO000004','1');
insert into shipping_group_data values ('SG000018','Ship To Home0018','1900 AVE OF THE STARTS - 0018','Suite 555 - 0018','Century City - 0018','LA','921076','US','UO000004','1');
insert into shipping_group_data values ('SG000019','Ship To Home0019','1900 AVE OF THE STARTS - 0019','Suite 555 - 0019','Century City - 0019','CA','914471','US','UO000004','1');
insert into shipping_group_data values ('SG000020','Ship To Home0020','1900 AVE OF THE STARTS - 0020','Suite 555 - 0020','Century City - 0020','VA','947116','US','UO000004','1');
insert into shipping_group_data values ('SG000021','Ship To Home0021','1900 AVE OF THE STARTS - 0021','Suite 555 - 0021','Century City - 0021','MA','935421','US','UO000005','1');
insert into shipping_group_data values ('SG000022','Ship To Home0022','1900 AVE OF THE STARTS - 0022','Suite 555 - 0022','Century City - 0022','PA','959698','US','UO000005','1');
insert into shipping_group_data values ('SG000023','Ship To Home0023','1900 AVE OF THE STARTS - 0023','Suite 555 - 0023','Century City - 0023','WA','894173','US','UO000005','1');
insert into shipping_group_data values ('SG000024','Ship To Home0024','1900 AVE OF THE STARTS - 0024','Suite 555 - 0024','Century City - 0024','LA','735697','US','UO000005','1');
insert into shipping_group_data values ('SG000025','Ship To Home0025','1900 AVE OF THE STARTS - 0025','Suite 555 - 0025','Century City - 0025','CA','861060','US','UO000005','1');
insert into shipping_group_data values ('SG000026','Ship To Home0026','1900 AVE OF THE STARTS - 0026','Suite 555 - 0026','Century City - 0026','VA','716458','US','UO000006','1');
insert into shipping_group_data values ('SG000027','Ship To Home0027','1900 AVE OF THE STARTS - 0027','Suite 555 - 0027','Century City - 0027','MA','906625','US','UO000006','1');
insert into shipping_group_data values ('SG000028','Ship To Home0028','1900 AVE OF THE STARTS - 0028','Suite 555 - 0028','Century City - 0028','PA','689734','US','UO000006','1');
insert into shipping_group_data values ('SG000029','Ship To Home0029','1900 AVE OF THE STARTS - 0029','Suite 555 - 0029','Century City - 0029','WA','859850','US','UO000006','1');
insert into shipping_group_data values ('SG000030','Ship To Home0030','1900 AVE OF THE STARTS - 0030','Suite 555 - 0030','Century City - 0030','LA','792643','US','UO000006','1');
insert into shipping_group_data values ('SG000031','Ship To Home0031','1900 AVE OF THE STARTS - 0031','Suite 555 - 0031','Century City - 0031','CA','742376','US','UO000007','1');
insert into shipping_group_data values ('SG000032','Ship To Home0032','1900 AVE OF THE STARTS - 0032','Suite 555 - 0032','Century City - 0032','VA','872316','US','UO000007','1');
insert into shipping_group_data values ('SG000033','Ship To Home0033','1900 AVE OF THE STARTS - 0033','Suite 555 - 0033','Century City - 0033','MA','905742','US','UO000007','1');
insert into shipping_group_data values ('SG000034','Ship To Home0034','1900 AVE OF THE STARTS - 0034','Suite 555 - 0034','Century City - 0034','PA','704492','US','UO000007','1');
insert into shipping_group_data values ('SG000035','Ship To Home0035','1900 AVE OF THE STARTS - 0035','Suite 555 - 0035','Century City - 0035','WA','771448','US','UO000007','1');
insert into shipping_group_data values ('SG000036','Ship To Home0036','1900 AVE OF THE STARTS - 0036','Suite 555 - 0036','Century City - 0036','LA','955130','US','UO000008','1');
insert into shipping_group_data values ('SG000037','Ship To Home0037','1900 AVE OF THE STARTS - 0037','Suite 555 - 0037','Century City - 0037','CA','858322','US','UO000008','1');
insert into shipping_group_data values ('SG000038','Ship To Home0038','1900 AVE OF THE STARTS - 0038','Suite 555 - 0038','Century City - 0038','VA','733291','US','UO000008','1');
insert into shipping_group_data values ('SG000039','Ship To Home0039','1900 AVE OF THE STARTS - 0039','Suite 555 - 0039','Century City - 0039','MA','929461','US','UO000008','1');
insert into shipping_group_data values ('SG000040','Ship To Home0040','1900 AVE OF THE STARTS - 0040','Suite 555 - 0040','Century City - 0040','PA','931995','US','UO000008','1');
insert into shipping_group_data values ('SG000041','Ship To Home0041','1900 AVE OF THE STARTS - 0041','Suite 555 - 0041','Century City - 0041','WA','737226','US','UO000009','1');
insert into shipping_group_data values ('SG000042','Ship To Home0042','1900 AVE OF THE STARTS - 0042','Suite 555 - 0042','Century City - 0042','LA','843919','US','UO000009','1');
insert into shipping_group_data values ('SG000043','Ship To Home0043','1900 AVE OF THE STARTS - 0043','Suite 555 - 0043','Century City - 0043','CA','843619','US','UO000009','1');
insert into shipping_group_data values ('SG000044','Ship To Home0044','1900 AVE OF THE STARTS - 0044','Suite 555 - 0044','Century City - 0044','VA','820675','US','UO000009','1');
insert into shipping_group_data values ('SG000045','Ship To Home0045','1900 AVE OF THE STARTS - 0045','Suite 555 - 0045','Century City - 0045','MA','967231','US','UO000009','1');
insert into shipping_group_data values ('SG000046','Ship To Home0046','1900 AVE OF THE STARTS - 0046','Suite 555 - 0046','Century City - 0046','PA','821244','US','UO000010','1');
insert into shipping_group_data values ('SG000047','Ship To Home0047','1900 AVE OF THE STARTS - 0047','Suite 555 - 0047','Century City - 0047','WA','962128','US','UO000010','1');
insert into shipping_group_data values ('SG000048','Ship To Home0048','1900 AVE OF THE STARTS - 0048','Suite 555 - 0048','Century City - 0048','LA','936972','US','UO000010','1');
insert into shipping_group_data values ('SG000049','Ship To Home0049','1900 AVE OF THE STARTS - 0049','Suite 555 - 0049','Century City - 0049','CA','874161','US','UO000010','1');
insert into shipping_group_data values ('SG000050','Ship To Home0050','1900 AVE OF THE STARTS - 0050','Suite 555 - 0050','Century City - 0050','VA','943893','US','UO000010','1');
insert into shipping_group_data values ('SG000051','Ship To Home0051','1900 AVE OF THE STARTS - 0051','Suite 555 - 0051','Century City - 0051','MA','931285','US','UO000011','1');
insert into shipping_group_data values ('SG000052','Ship To Home0052','1900 AVE OF THE STARTS - 0052','Suite 555 - 0052','Century City - 0052','PA','795355','US','UO000011','1');
insert into shipping_group_data values ('SG000053','Ship To Home0053','1900 AVE OF THE STARTS - 0053','Suite 555 - 0053','Century City - 0053','WA','764690','US','UO000011','1');
insert into shipping_group_data values ('SG000054','Ship To Home0054','1900 AVE OF THE STARTS - 0054','Suite 555 - 0054','Century City - 0054','LA','799850','US','UO000011','1');
insert into shipping_group_data values ('SG000055','Ship To Home0055','1900 AVE OF THE STARTS - 0055','Suite 555 - 0055','Century City - 0055','CA','883345','US','UO000011','1');
insert into shipping_group_data values ('SG000056','Ship To Home0056','1900 AVE OF THE STARTS - 0056','Suite 555 - 0056','Century City - 0056','VA','891063','US','UO000012','1');
insert into shipping_group_data values ('SG000057','Ship To Home0057','1900 AVE OF THE STARTS - 0057','Suite 555 - 0057','Century City - 0057','MA','818329','US','UO000012','1');
insert into shipping_group_data values ('SG000058','Ship To Home0058','1900 AVE OF THE STARTS - 0058','Suite 555 - 0058','Century City - 0058','PA','834631','US','UO000012','1');
insert into shipping_group_data values ('SG000059','Ship To Home0059','1900 AVE OF THE STARTS - 0059','Suite 555 - 0059','Century City - 0059','WA','824466','US','UO000012','1');
insert into shipping_group_data values ('SG000060','Ship To Home0060','1900 AVE OF THE STARTS - 0060','Suite 555 - 0060','Century City - 0060','LA','793349','US','UO000012','1');
insert into shipping_group_data values ('SG000061','Ship To Home0061','1900 AVE OF THE STARTS - 0061','Suite 555 - 0061','Century City - 0061','CA','803272','US','UO000013','1');
insert into shipping_group_data values ('SG000062','Ship To Home0062','1900 AVE OF THE STARTS - 0062','Suite 555 - 0062','Century City - 0062','VA','742055','US','UO000013','1');
insert into shipping_group_data values ('SG000063','Ship To Home0063','1900 AVE OF THE STARTS - 0063','Suite 555 - 0063','Century City - 0063','MA','874876','US','UO000013','1');
insert into shipping_group_data values ('SG000064','Ship To Home0064','1900 AVE OF THE STARTS - 0064','Suite 555 - 0064','Century City - 0064','PA','880001','US','UO000013','1');
insert into shipping_group_data values ('SG000065','Ship To Home0065','1900 AVE OF THE STARTS - 0065','Suite 555 - 0065','Century City - 0065','WA','957884','US','UO000013','1');
insert into shipping_group_data values ('SG000066','Ship To Home0066','1900 AVE OF THE STARTS - 0066','Suite 555 - 0066','Century City - 0066','LA','847503','US','UO000014','1');
insert into shipping_group_data values ('SG000067','Ship To Home0067','1900 AVE OF THE STARTS - 0067','Suite 555 - 0067','Century City - 0067','CA','722254','US','UO000014','1');
insert into shipping_group_data values ('SG000068','Ship To Home0068','1900 AVE OF THE STARTS - 0068','Suite 555 - 0068','Century City - 0068','VA','744853','US','UO000014','1');
insert into shipping_group_data values ('SG000069','Ship To Home0069','1900 AVE OF THE STARTS - 0069','Suite 555 - 0069','Century City - 0069','MA','957832','US','UO000014','1');
insert into shipping_group_data values ('SG000070','Ship To Home0070','1900 AVE OF THE STARTS - 0070','Suite 555 - 0070','Century City - 0070','PA','737819','US','UO000014','1');
insert into shipping_group_data values ('SG000071','Ship To Home0071','1900 AVE OF THE STARTS - 0071','Suite 555 - 0071','Century City - 0071','WA','885981','US','UO000015','1');
insert into shipping_group_data values ('SG000072','Ship To Home0072','1900 AVE OF THE STARTS - 0072','Suite 555 - 0072','Century City - 0072','LA','971553','US','UO000015','1');
insert into shipping_group_data values ('SG000073','Ship To Home0073','1900 AVE OF THE STARTS - 0073','Suite 555 - 0073','Century City - 0073','CA','712054','US','UO000015','1');
insert into shipping_group_data values ('SG000074','Ship To Home0074','1900 AVE OF THE STARTS - 0074','Suite 555 - 0074','Century City - 0074','VA','898983','US','UO000015','1');
insert into shipping_group_data values ('SG000075','Ship To Home0075','1900 AVE OF THE STARTS - 0075','Suite 555 - 0075','Century City - 0075','MA','966640','US','UO000015','1');
insert into shipping_group_data values ('SG000076','Ship To Home0076','1900 AVE OF THE STARTS - 0076','Suite 555 - 0076','Century City - 0076','PA','723562','US','UO000016','1');
insert into shipping_group_data values ('SG000077','Ship To Home0077','1900 AVE OF THE STARTS - 0077','Suite 555 - 0077','Century City - 0077','WA','864871','US','UO000016','1');
insert into shipping_group_data values ('SG000078','Ship To Home0078','1900 AVE OF THE STARTS - 0078','Suite 555 - 0078','Century City - 0078','LA','693986','US','UO000016','1');
insert into shipping_group_data values ('SG000079','Ship To Home0079','1900 AVE OF THE STARTS - 0079','Suite 555 - 0079','Century City - 0079','CA','962506','US','UO000016','1');
insert into shipping_group_data values ('SG000080','Ship To Home0080','1900 AVE OF THE STARTS - 0080','Suite 555 - 0080','Century City - 0080','VA','845359','US','UO000016','1');
insert into shipping_group_data values ('SG000081','Ship To Home0081','1900 AVE OF THE STARTS - 0081','Suite 555 - 0081','Century City - 0081','MA','850257','US','UO000017','1');
insert into shipping_group_data values ('SG000082','Ship To Home0082','1900 AVE OF THE STARTS - 0082','Suite 555 - 0082','Century City - 0082','PA','809763','US','UO000017','1');
insert into shipping_group_data values ('SG000083','Ship To Home0083','1900 AVE OF THE STARTS - 0083','Suite 555 - 0083','Century City - 0083','WA','691312','US','UO000017','1');
insert into shipping_group_data values ('SG000084','Ship To Home0084','1900 AVE OF THE STARTS - 0084','Suite 555 - 0084','Century City - 0084','LA','925044','US','UO000017','1');
insert into shipping_group_data values ('SG000085','Ship To Home0085','1900 AVE OF THE STARTS - 0085','Suite 555 - 0085','Century City - 0085','CA','793801','US','UO000017','1');
insert into shipping_group_data values ('SG000086','Ship To Home0086','1900 AVE OF THE STARTS - 0086','Suite 555 - 0086','Century City - 0086','VA','930013','US','UO000018','1');
insert into shipping_group_data values ('SG000087','Ship To Home0087','1900 AVE OF THE STARTS - 0087','Suite 555 - 0087','Century City - 0087','MA','818837','US','UO000018','1');
insert into shipping_group_data values ('SG000088','Ship To Home0088','1900 AVE OF THE STARTS - 0088','Suite 555 - 0088','Century City - 0088','PA','773067','US','UO000018','1');
insert into shipping_group_data values ('SG000089','Ship To Home0089','1900 AVE OF THE STARTS - 0089','Suite 555 - 0089','Century City - 0089','WA','791583','US','UO000018','1');
insert into shipping_group_data values ('SG000090','Ship To Home0090','1900 AVE OF THE STARTS - 0090','Suite 555 - 0090','Century City - 0090','LA','888520','US','UO000018','1');
insert into shipping_group_data values ('SG000091','Ship To Home0091','1900 AVE OF THE STARTS - 0091','Suite 555 - 0091','Century City - 0091','CA','800778','US','UO000019','1');
insert into shipping_group_data values ('SG000092','Ship To Home0092','1900 AVE OF THE STARTS - 0092','Suite 555 - 0092','Century City - 0092','VA','874635','US','UO000019','1');
insert into shipping_group_data values ('SG000093','Ship To Home0093','1900 AVE OF THE STARTS - 0093','Suite 555 - 0093','Century City - 0093','MA','922954','US','UO000019','1');
insert into shipping_group_data values ('SG000094','Ship To Home0094','1900 AVE OF THE STARTS - 0094','Suite 555 - 0094','Century City - 0094','PA','945130','US','UO000019','1');
insert into shipping_group_data values ('SG000095','Ship To Home0095','1900 AVE OF THE STARTS - 0095','Suite 555 - 0095','Century City - 0095','WA','944079','US','UO000019','1');
insert into shipping_group_data values ('SG000096','Ship To Home0096','1900 AVE OF THE STARTS - 0096','Suite 555 - 0096','Century City - 0096','LA','791447','US','UO000020','1');
insert into shipping_group_data values ('SG000097','Ship To Home0097','1900 AVE OF THE STARTS - 0097','Suite 555 - 0097','Century City - 0097','CA','728771','US','UO000020','1');
insert into shipping_group_data values ('SG000098','Ship To Home0098','1900 AVE OF THE STARTS - 0098','Suite 555 - 0098','Century City - 0098','VA','854224','US','UO000020','1');
insert into shipping_group_data values ('SG000099','Ship To Home0099','1900 AVE OF THE STARTS - 0099','Suite 555 - 0099','Century City - 0099','MA','744288','US','UO000020','1');
insert into shipping_group_data values ('SG000100','Ship To Home0100','1900 AVE OF THE STARTS - 0100','Suite 555 - 0100','Century City - 0100','PA','698317','US','UO000020','1');
insert into shipping_group_data values ('SG000101','Ship To Home0101','1900 AVE OF THE STARTS - 0101','Suite 555 - 0101','Century City - 0101','WA','741969','US','UO000021','1');
insert into shipping_group_data values ('SG000102','Ship To Home0102','1900 AVE OF THE STARTS - 0102','Suite 555 - 0102','Century City - 0102','LA','715640','US','UO000021','1');
insert into shipping_group_data values ('SG000103','Ship To Home0103','1900 AVE OF THE STARTS - 0103','Suite 555 - 0103','Century City - 0103','CA','697680','US','UO000021','1');
insert into shipping_group_data values ('SG000104','Ship To Home0104','1900 AVE OF THE STARTS - 0104','Suite 555 - 0104','Century City - 0104','VA','718152','US','UO000021','1');
insert into shipping_group_data values ('SG000105','Ship To Home0105','1900 AVE OF THE STARTS - 0105','Suite 555 - 0105','Century City - 0105','MA','705740','US','UO000021','1');
insert into shipping_group_data values ('SG000106','Ship To Home0106','1900 AVE OF THE STARTS - 0106','Suite 555 - 0106','Century City - 0106','PA','977916','US','UO000022','1');
insert into shipping_group_data values ('SG000107','Ship To Home0107','1900 AVE OF THE STARTS - 0107','Suite 555 - 0107','Century City - 0107','WA','821447','US','UO000022','1');
insert into shipping_group_data values ('SG000108','Ship To Home0108','1900 AVE OF THE STARTS - 0108','Suite 555 - 0108','Century City - 0108','LA','747928','US','UO000022','1');
insert into shipping_group_data values ('SG000109','Ship To Home0109','1900 AVE OF THE STARTS - 0109','Suite 555 - 0109','Century City - 0109','CA','816791','US','UO000022','1');
insert into shipping_group_data values ('SG000110','Ship To Home0110','1900 AVE OF THE STARTS - 0110','Suite 555 - 0110','Century City - 0110','VA','868867','US','UO000022','1');
insert into shipping_group_data values ('SG000111','Ship To Home0111','1900 AVE OF THE STARTS - 0111','Suite 555 - 0111','Century City - 0111','MA','831288','US','UO000023','1');
insert into shipping_group_data values ('SG000112','Ship To Home0112','1900 AVE OF THE STARTS - 0112','Suite 555 - 0112','Century City - 0112','PA','940070','US','UO000023','1');
insert into shipping_group_data values ('SG000113','Ship To Home0113','1900 AVE OF THE STARTS - 0113','Suite 555 - 0113','Century City - 0113','WA','759287','US','UO000023','1');
insert into shipping_group_data values ('SG000114','Ship To Home0114','1900 AVE OF THE STARTS - 0114','Suite 555 - 0114','Century City - 0114','LA','724595','US','UO000023','1');
insert into shipping_group_data values ('SG000115','Ship To Home0115','1900 AVE OF THE STARTS - 0115','Suite 555 - 0115','Century City - 0115','CA','807110','US','UO000023','1');
insert into shipping_group_data values ('SG000116','Ship To Home0116','1900 AVE OF THE STARTS - 0116','Suite 555 - 0116','Century City - 0116','VA','797021','US','UO000024','1');
insert into shipping_group_data values ('SG000117','Ship To Home0117','1900 AVE OF THE STARTS - 0117','Suite 555 - 0117','Century City - 0117','MA','847234','US','UO000024','1');
insert into shipping_group_data values ('SG000118','Ship To Home0118','1900 AVE OF THE STARTS - 0118','Suite 555 - 0118','Century City - 0118','PA','946980','US','UO000024','1');
insert into shipping_group_data values ('SG000119','Ship To Home0119','1900 AVE OF THE STARTS - 0119','Suite 555 - 0119','Century City - 0119','WA','746620','US','UO000024','1');
insert into shipping_group_data values ('SG000120','Ship To Home0120','1900 AVE OF THE STARTS - 0120','Suite 555 - 0120','Century City - 0120','LA','890438','US','UO000024','1');
insert into shipping_group_data values ('SG000121','Ship To Home0121','1900 AVE OF THE STARTS - 0121','Suite 555 - 0121','Century City - 0121','CA','869617','US','UO000025','1');
insert into shipping_group_data values ('SG000122','Ship To Home0122','1900 AVE OF THE STARTS - 0122','Suite 555 - 0122','Century City - 0122','VA','687305','US','UO000025','1');
insert into shipping_group_data values ('SG000123','Ship To Home0123','1900 AVE OF THE STARTS - 0123','Suite 555 - 0123','Century City - 0123','MA','898960','US','UO000025','1');
insert into shipping_group_data values ('SG000124','Ship To Home0124','1900 AVE OF THE STARTS - 0124','Suite 555 - 0124','Century City - 0124','PA','832237','US','UO000025','1');
insert into shipping_group_data values ('SG000125','Ship To Home0125','1900 AVE OF THE STARTS - 0125','Suite 555 - 0125','Century City - 0125','WA','810718','US','UO000025','1');

	
insert into payment_group_data values ('PG000001','Pay for order','98.01','UO000001','PAID','1');
insert into payment_group_data values ('PG000002','Pay for order0002','90.28','UO000001','PENDING','1');
insert into payment_group_data values ('PG000003','Pay for order0003','110.21','UO000001','FAIL','1');
insert into payment_group_data values ('PG000004','Pay for order0004','108.05','UO000001','PAID','1');
insert into payment_group_data values ('PG000005','Pay for order0005','111.55','UO000001','PENDING','1');
insert into payment_group_data values ('PG000006','Pay for order0006','115.56','UO000002','FAIL','1');
insert into payment_group_data values ('PG000007','Pay for order0007','86.24','UO000002','PAID','1');
insert into payment_group_data values ('PG000008','Pay for order0008','92.78','UO000002','PENDING','1');
insert into payment_group_data values ('PG000009','Pay for order0009','101.25','UO000002','FAIL','1');
insert into payment_group_data values ('PG000010','Pay for order0010','90.63','UO000002','PAID','1');
insert into payment_group_data values ('PG000011','Pay for order0011','100.93','UO000003','PENDING','1');
insert into payment_group_data values ('PG000012','Pay for order0012','113.97','UO000003','FAIL','1');
insert into payment_group_data values ('PG000013','Pay for order0013','100.70','UO000003','PAID','1');
insert into payment_group_data values ('PG000014','Pay for order0014','87.56','UO000003','PENDING','1');
insert into payment_group_data values ('PG000015','Pay for order0015','86.66','UO000003','FAIL','1');
insert into payment_group_data values ('PG000016','Pay for order0016','97.66','UO000004','PAID','1');
insert into payment_group_data values ('PG000017','Pay for order0017','113.49','UO000004','PENDING','1');
insert into payment_group_data values ('PG000018','Pay for order0018','116.80','UO000004','FAIL','1');
insert into payment_group_data values ('PG000019','Pay for order0019','87.04','UO000004','PAID','1');
insert into payment_group_data values ('PG000020','Pay for order0020','110.30','UO000004','PENDING','1');
insert into payment_group_data values ('PG000021','Pay for order0021','98.05','UO000005','FAIL','1');
insert into payment_group_data values ('PG000022','Pay for order0022','115.11','UO000005','PAID','1');
insert into payment_group_data values ('PG000023','Pay for order0023','90.69','UO000005','PENDING','1');
insert into payment_group_data values ('PG000024','Pay for order0024','93.88','UO000005','FAIL','1');
insert into payment_group_data values ('PG000025','Pay for order0025','99.72','UO000005','PAID','1');
insert into payment_group_data values ('PG000026','Pay for order0026','86.89','UO000006','PENDING','1');
insert into payment_group_data values ('PG000027','Pay for order0027','105.50','UO000006','FAIL','1');
insert into payment_group_data values ('PG000028','Pay for order0028','98.63','UO000006','PAID','1');
insert into payment_group_data values ('PG000029','Pay for order0029','87.17','UO000006','PENDING','1');
insert into payment_group_data values ('PG000030','Pay for order0030','97.60','UO000006','FAIL','1');
insert into payment_group_data values ('PG000031','Pay for order0031','110.62','UO000007','PAID','1');
insert into payment_group_data values ('PG000032','Pay for order0032','89.41','UO000007','PENDING','1');
insert into payment_group_data values ('PG000033','Pay for order0033','105.67','UO000007','FAIL','1');
insert into payment_group_data values ('PG000034','Pay for order0034','112.15','UO000007','PAID','1');
insert into payment_group_data values ('PG000035','Pay for order0035','95.84','UO000007','PENDING','1');
insert into payment_group_data values ('PG000036','Pay for order0036','90.81','UO000008','FAIL','1');
insert into payment_group_data values ('PG000037','Pay for order0037','112.63','UO000008','PAID','1');
insert into payment_group_data values ('PG000038','Pay for order0038','88.46','UO000008','PENDING','1');
insert into payment_group_data values ('PG000039','Pay for order0039','89.15','UO000008','FAIL','1');
insert into payment_group_data values ('PG000040','Pay for order0040','93.31','UO000008','PAID','1');
insert into payment_group_data values ('PG000041','Pay for order0041','107.39','UO000009','PENDING','1');
insert into payment_group_data values ('PG000042','Pay for order0042','96.91','UO000009','FAIL','1');
insert into payment_group_data values ('PG000043','Pay for order0043','99.51','UO000009','PAID','1');
insert into payment_group_data values ('PG000044','Pay for order0044','119.03','UO000009','PENDING','1');
insert into payment_group_data values ('PG000045','Pay for order0045','111.86','UO000009','FAIL','1');
insert into payment_group_data values ('PG000046','Pay for order0046','88.44','UO000010','PAID','1');
insert into payment_group_data values ('PG000047','Pay for order0047','116.05','UO000010','PENDING','1');
insert into payment_group_data values ('PG000048','Pay for order0048','118.78','UO000010','FAIL','1');
insert into payment_group_data values ('PG000049','Pay for order0049','110.85','UO000010','PAID','1');
insert into payment_group_data values ('PG000050','Pay for order0050','91.16','UO000010','PENDING','1');
insert into payment_group_data values ('PG000051','Pay for order0051','116.91','UO000011','FAIL','1');
insert into payment_group_data values ('PG000052','Pay for order0052','115.20','UO000011','PAID','1');
insert into payment_group_data values ('PG000053','Pay for order0053','119.40','UO000011','PENDING','1');
insert into payment_group_data values ('PG000054','Pay for order0054','90.75','UO000011','FAIL','1');
insert into payment_group_data values ('PG000055','Pay for order0055','114.67','UO000011','PAID','1');
insert into payment_group_data values ('PG000056','Pay for order0056','121.01','UO000012','PENDING','1');
insert into payment_group_data values ('PG000057','Pay for order0057','107.51','UO000012','FAIL','1');
insert into payment_group_data values ('PG000058','Pay for order0058','105.89','UO000012','PAID','1');
insert into payment_group_data values ('PG000059','Pay for order0059','120.51','UO000012','PENDING','1');
insert into payment_group_data values ('PG000060','Pay for order0060','92.79','UO000012','FAIL','1');
insert into payment_group_data values ('PG000061','Pay for order0061','94.39','UO000013','PAID','1');
insert into payment_group_data values ('PG000062','Pay for order0062','98.28','UO000013','PENDING','1');
insert into payment_group_data values ('PG000063','Pay for order0063','101.19','UO000013','FAIL','1');
insert into payment_group_data values ('PG000064','Pay for order0064','95.30','UO000013','PAID','1');
insert into payment_group_data values ('PG000065','Pay for order0065','110.02','UO000013','PENDING','1');
insert into payment_group_data values ('PG000066','Pay for order0066','121.52','UO000014','FAIL','1');
insert into payment_group_data values ('PG000067','Pay for order0067','86.31','UO000014','PAID','1');
insert into payment_group_data values ('PG000068','Pay for order0068','95.22','UO000014','PENDING','1');
insert into payment_group_data values ('PG000069','Pay for order0069','89.05','UO000014','FAIL','1');
insert into payment_group_data values ('PG000070','Pay for order0070','119.06','UO000014','PAID','1');
insert into payment_group_data values ('PG000071','Pay for order0071','117.54','UO000015','PENDING','1');
insert into payment_group_data values ('PG000072','Pay for order0072','108.44','UO000015','FAIL','1');
insert into payment_group_data values ('PG000073','Pay for order0073','113.97','UO000015','PAID','1');
insert into payment_group_data values ('PG000074','Pay for order0074','88.17','UO000015','PENDING','1');
insert into payment_group_data values ('PG000075','Pay for order0075','117.79','UO000015','FAIL','1');
insert into payment_group_data values ('PG000076','Pay for order0076','103.77','UO000016','PAID','1');
insert into payment_group_data values ('PG000077','Pay for order0077','101.26','UO000016','PENDING','1');
insert into payment_group_data values ('PG000078','Pay for order0078','100.12','UO000016','FAIL','1');
insert into payment_group_data values ('PG000079','Pay for order0079','110.53','UO000016','PAID','1');
insert into payment_group_data values ('PG000080','Pay for order0080','101.48','UO000016','PENDING','1');
insert into payment_group_data values ('PG000081','Pay for order0081','117.53','UO000017','FAIL','1');
insert into payment_group_data values ('PG000082','Pay for order0082','112.87','UO000017','PAID','1');
insert into payment_group_data values ('PG000083','Pay for order0083','100.03','UO000017','PENDING','1');
insert into payment_group_data values ('PG000084','Pay for order0084','88.92','UO000017','FAIL','1');
insert into payment_group_data values ('PG000085','Pay for order0085','89.01','UO000017','PAID','1');
insert into payment_group_data values ('PG000086','Pay for order0086','119.52','UO000018','PENDING','1');
insert into payment_group_data values ('PG000087','Pay for order0087','94.46','UO000018','FAIL','1');
insert into payment_group_data values ('PG000088','Pay for order0088','104.08','UO000018','PAID','1');
insert into payment_group_data values ('PG000089','Pay for order0089','100.37','UO000018','PENDING','1');
insert into payment_group_data values ('PG000090','Pay for order0090','97.54','UO000018','FAIL','1');
insert into payment_group_data values ('PG000091','Pay for order0091','120.58','UO000019','PAID','1');
insert into payment_group_data values ('PG000092','Pay for order0092','121.24','UO000019','PENDING','1');
insert into payment_group_data values ('PG000093','Pay for order0093','98.90','UO000019','FAIL','1');
insert into payment_group_data values ('PG000094','Pay for order0094','114.04','UO000019','PAID','1');
insert into payment_group_data values ('PG000095','Pay for order0095','113.22','UO000019','PENDING','1');
insert into payment_group_data values ('PG000096','Pay for order0096','89.60','UO000020','FAIL','1');
insert into payment_group_data values ('PG000097','Pay for order0097','112.04','UO000020','PAID','1');
insert into payment_group_data values ('PG000098','Pay for order0098','111.41','UO000020','PENDING','1');
insert into payment_group_data values ('PG000099','Pay for order0099','117.08','UO000020','FAIL','1');
insert into payment_group_data values ('PG000100','Pay for order0100','116.89','UO000020','PAID','1');
insert into payment_group_data values ('PG000101','Pay for order0101','119.12','UO000021','PENDING','1');
insert into payment_group_data values ('PG000102','Pay for order0102','108.00','UO000021','FAIL','1');
insert into payment_group_data values ('PG000103','Pay for order0103','99.22','UO000021','PAID','1');
insert into payment_group_data values ('PG000104','Pay for order0104','92.74','UO000021','PENDING','1');
insert into payment_group_data values ('PG000105','Pay for order0105','94.45','UO000021','FAIL','1');
insert into payment_group_data values ('PG000106','Pay for order0106','115.81','UO000022','PAID','1');
insert into payment_group_data values ('PG000107','Pay for order0107','117.11','UO000022','PENDING','1');
insert into payment_group_data values ('PG000108','Pay for order0108','111.63','UO000022','FAIL','1');
insert into payment_group_data values ('PG000109','Pay for order0109','107.29','UO000022','PAID','1');
insert into payment_group_data values ('PG000110','Pay for order0110','91.67','UO000022','PENDING','1');
insert into payment_group_data values ('PG000111','Pay for order0111','86.18','UO000023','FAIL','1');
insert into payment_group_data values ('PG000112','Pay for order0112','95.60','UO000023','PAID','1');
insert into payment_group_data values ('PG000113','Pay for order0113','86.83','UO000023','PENDING','1');
insert into payment_group_data values ('PG000114','Pay for order0114','122.21','UO000023','FAIL','1');
insert into payment_group_data values ('PG000115','Pay for order0115','102.33','UO000023','PAID','1');
insert into payment_group_data values ('PG000116','Pay for order0116','103.52','UO000024','PENDING','1');
insert into payment_group_data values ('PG000117','Pay for order0117','117.33','UO000024','FAIL','1');
insert into payment_group_data values ('PG000118','Pay for order0118','90.40','UO000024','PAID','1');
insert into payment_group_data values ('PG000119','Pay for order0119','116.72','UO000024','PENDING','1');
insert into payment_group_data values ('PG000120','Pay for order0120','101.15','UO000024','FAIL','1');
insert into payment_group_data values ('PG000121','Pay for order0121','87.27','UO000025','PAID','1');
insert into payment_group_data values ('PG000122','Pay for order0122','120.91','UO000025','PENDING','1');
insert into payment_group_data values ('PG000123','Pay for order0123','106.01','UO000025','FAIL','1');
insert into payment_group_data values ('PG000124','Pay for order0124','118.28','UO000025','PAID','1');
insert into payment_group_data values ('PG000125','Pay for order0125','108.42','UO000025','PENDING','1');

	
insert into user_domain_data values ('UD000001','用户区域','1');

	
insert into user_white_list_data values ('UWL000001','clariones','tester;ios-spokesperson','UD000001','1');
insert into user_white_list_data values ('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');
insert into user_white_list_data values ('UWL000003','clariones','tester;ios-spokesperson0003','UD000001','1');
insert into user_white_list_data values ('UWL000004','13808188512','tester;ios-spokesperson0004','UD000001','1');
insert into user_white_list_data values ('UWL000005','clariones','tester;ios-spokesperson0005','UD000001','1');

	
insert into sec_user_data values ('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','0','2019-02-09 17:50:09','2019-02-15 02:28:27','UD000001',NULL,'BLOCKED','1');
insert into sec_user_data values ('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','9999999','2019-02-12 17:16:46','2019-02-20 06:11:03','UD000001',NULL,'BLOCKED0002','1');
insert into sec_user_data values ('SU000003','login0003','13900000003','','1A39AE05E011CF4B6ADE19307698831F4303CEB3FF5A9E21EEC0B21FB19B1050','0','2019-02-11 11:21:44','2019-02-07 20:36:37','UD000001',NULL,'BLOCKED0003','1');
insert into sec_user_data values ('SU000004','login0004','13900000004','suddy_chang@163.com','331D0B81C261072AB3E01D2D09A3D1F9B03F1E5F095D6BF7284F32BF85135D59','9999999','2019-02-08 20:02:49','2019-02-04 08:20:21','UD000001',NULL,'BLOCKED0004','1');
insert into sec_user_data values ('SU000005','login0005','13900000005','','CBDC109937F570CA1D5F223EC59F5368AF9380F9DBF7E553124132BB402ED457','0','2019-02-16 09:09:52','2019-02-06 03:43:51','UD000001',NULL,'BLOCKED0005','1');

	
insert into sec_user_blocking_data values ('SUB000001','currentUser()','2019-02-19 02:54:14','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

	
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

	
insert into login_history_data values ('LH000001','2019-02-09 17:50:09','192.168.1.1','登陆成功','SU000001','1');
insert into login_history_data values ('LH000002','2019-02-15 16:06:41','192.168.1.2','登陆成功0002','SU000001','1');
insert into login_history_data values ('LH000003','2019-02-04 06:36:18','192.168.1.1','登陆成功0003','SU000001','1');
insert into login_history_data values ('LH000004','2019-02-10 11:01:45','192.168.1.2','登陆成功0004','SU000001','1');
insert into login_history_data values ('LH000005','2019-02-16 03:50:44','192.168.1.1','登陆成功0005','SU000001','1');
insert into login_history_data values ('LH000006','2019-02-12 21:32:42','192.168.1.2','登陆成功0006','SU000002','1');
insert into login_history_data values ('LH000007','2019-02-01 07:11:28','192.168.1.1','登陆成功0007','SU000002','1');
insert into login_history_data values ('LH000008','2019-02-20 02:20:46','192.168.1.2','登陆成功0008','SU000002','1');
insert into login_history_data values ('LH000009','2019-02-20 21:28:09','192.168.1.1','登陆成功0009','SU000002','1');
insert into login_history_data values ('LH000010','2019-02-22 00:01:05','192.168.1.2','登陆成功0010','SU000002','1');
insert into login_history_data values ('LH000011','2019-02-07 13:29:37','192.168.1.1','登陆成功0011','SU000003','1');
insert into login_history_data values ('LH000012','2019-02-15 20:11:13','192.168.1.2','登陆成功0012','SU000003','1');
insert into login_history_data values ('LH000013','2019-02-18 04:59:55','192.168.1.1','登陆成功0013','SU000003','1');
insert into login_history_data values ('LH000014','2019-02-21 16:02:38','192.168.1.2','登陆成功0014','SU000003','1');
insert into login_history_data values ('LH000015','2019-02-13 20:19:25','192.168.1.1','登陆成功0015','SU000003','1');
insert into login_history_data values ('LH000016','2019-02-10 03:13:43','192.168.1.2','登陆成功0016','SU000004','1');
insert into login_history_data values ('LH000017','2019-02-07 05:58:41','192.168.1.1','登陆成功0017','SU000004','1');
insert into login_history_data values ('LH000018','2019-02-01 19:46:01','192.168.1.2','登陆成功0018','SU000004','1');
insert into login_history_data values ('LH000019','2019-02-09 08:04:55','192.168.1.1','登陆成功0019','SU000004','1');
insert into login_history_data values ('LH000020','2019-02-09 00:19:20','192.168.1.2','登陆成功0020','SU000004','1');
insert into login_history_data values ('LH000021','2019-02-10 02:35:41','192.168.1.1','登陆成功0021','SU000005','1');
insert into login_history_data values ('LH000022','2019-02-05 06:24:37','192.168.1.2','登陆成功0022','SU000005','1');
insert into login_history_data values ('LH000023','2019-02-15 08:17:14','192.168.1.1','登陆成功0023','SU000005','1');
insert into login_history_data values ('LH000024','2019-02-13 15:44:48','192.168.1.2','登陆成功0024','SU000005','1');
insert into login_history_data values ('LH000025','2019-02-02 16:24:32','192.168.1.1','登陆成功0025','SU000005','1');

	
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

