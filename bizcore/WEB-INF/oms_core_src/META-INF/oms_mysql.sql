-- BUILD WITH MODEL TIME 190128T1215
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
	last_update_time    	varchar(64)                              comment 'Last Update Time',
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

	
insert into profile_data values ('P000001','Philip Zhang','36','male','2019-01-09 11:26:18','P000001','1');
insert into profile_data values ('P000002','Naveen Kumar R ','31','female','2019-01-26 00:38:48','P000001','1');
insert into profile_data values ('P000003','VENKATESH GADUPUTI','35','male','2019-01-28 03:25:52','P000001','1');
insert into profile_data values ('P000004','Philip Zhang','33','female','2019-01-28 05:55:20','P000001','1');
insert into profile_data values ('P000005','Naveen Kumar R ','40','male','2019-01-23 17:49:29','P000001','1');
insert into profile_data values ('P000006','VENKATESH GADUPUTI','38','female','2019-01-14 00:27:11','P000001','1');

	
insert into user_order_data values ('UO000001','a consumer order','81.76','7570.95','P000001','P000001','lastUpdateTime()','1');
insert into user_order_data values ('UO000002','a consumer order0002','98.12','7463.21','P000001','P000001','lastUpdateTime()0002','1');
insert into user_order_data values ('UO000003','a consumer order0003','94.18','7382.64','P000001','P000001','lastUpdateTime()0003','1');
insert into user_order_data values ('UO000004','a consumer order0004','93.73','9227.91','P000001','P000001','lastUpdateTime()0004','1');
insert into user_order_data values ('UO000005','a consumer order0005','70.35','8404.55','P000001','P000001','lastUpdateTime()0005','1');
insert into user_order_data values ('UO000006','a consumer order0006','74.18','8522.38','P000001','P000001','lastUpdateTime()0006','1');
insert into user_order_data values ('UO000007','a consumer order0007','72.61','7338.61','P000002','P000001','lastUpdateTime()0007','1');
insert into user_order_data values ('UO000008','a consumer order0008','86.05','8617.71','P000002','P000001','lastUpdateTime()0008','1');
insert into user_order_data values ('UO000009','a consumer order0009','78.46','8257.61','P000002','P000001','lastUpdateTime()0009','1');
insert into user_order_data values ('UO000010','a consumer order0010','80.97','8726.97','P000002','P000001','lastUpdateTime()0010','1');
insert into user_order_data values ('UO000011','a consumer order0011','93.35','7461.22','P000002','P000001','lastUpdateTime()0011','1');
insert into user_order_data values ('UO000012','a consumer order0012','76.59','7679.87','P000002','P000001','lastUpdateTime()0012','1');
insert into user_order_data values ('UO000013','a consumer order0013','94.46','9705.75','P000003','P000001','lastUpdateTime()0013','1');
insert into user_order_data values ('UO000014','a consumer order0014','92.84','9602.33','P000003','P000001','lastUpdateTime()0014','1');
insert into user_order_data values ('UO000015','a consumer order0015','75.86','9354.35','P000003','P000001','lastUpdateTime()0015','1');
insert into user_order_data values ('UO000016','a consumer order0016','91.14','9825.34','P000003','P000001','lastUpdateTime()0016','1');
insert into user_order_data values ('UO000017','a consumer order0017','72.61','7235.24','P000003','P000001','lastUpdateTime()0017','1');
insert into user_order_data values ('UO000018','a consumer order0018','93.83','9557.68','P000003','P000001','lastUpdateTime()0018','1');
insert into user_order_data values ('UO000019','a consumer order0019','84.32','7363.61','P000004','P000001','lastUpdateTime()0019','1');
insert into user_order_data values ('UO000020','a consumer order0020','98.29','8983.97','P000004','P000001','lastUpdateTime()0020','1');
insert into user_order_data values ('UO000021','a consumer order0021','85.28','7100.58','P000004','P000001','lastUpdateTime()0021','1');
insert into user_order_data values ('UO000022','a consumer order0022','98.40','9092.49','P000004','P000001','lastUpdateTime()0022','1');
insert into user_order_data values ('UO000023','a consumer order0023','78.37','7283.03','P000004','P000001','lastUpdateTime()0023','1');
insert into user_order_data values ('UO000024','a consumer order0024','81.83','9088.01','P000004','P000001','lastUpdateTime()0024','1');
insert into user_order_data values ('UO000025','a consumer order0025','84.78','7325.45','P000005','P000001','lastUpdateTime()0025','1');
insert into user_order_data values ('UO000026','a consumer order0026','86.97','8082.48','P000005','P000001','lastUpdateTime()0026','1');
insert into user_order_data values ('UO000027','a consumer order0027','90.03','9661.40','P000005','P000001','lastUpdateTime()0027','1');
insert into user_order_data values ('UO000028','a consumer order0028','77.82','7682.51','P000005','P000001','lastUpdateTime()0028','1');
insert into user_order_data values ('UO000029','a consumer order0029','79.92','9698.36','P000005','P000001','lastUpdateTime()0029','1');
insert into user_order_data values ('UO000030','a consumer order0030','88.98','8190.93','P000005','P000001','lastUpdateTime()0030','1');
insert into user_order_data values ('UO000031','a consumer order0031','96.30','8141.54','P000006','P000001','lastUpdateTime()0031','1');
insert into user_order_data values ('UO000032','a consumer order0032','74.60','7435.49','P000006','P000001','lastUpdateTime()0032','1');
insert into user_order_data values ('UO000033','a consumer order0033','83.42','8609.37','P000006','P000001','lastUpdateTime()0033','1');
insert into user_order_data values ('UO000034','a consumer order0034','97.95','8651.26','P000006','P000001','lastUpdateTime()0034','1');
insert into user_order_data values ('UO000035','a consumer order0035','81.20','7423.73','P000006','P000001','lastUpdateTime()0035','1');
insert into user_order_data values ('UO000036','a consumer order0036','87.38','7345.25','P000006','P000001','lastUpdateTime()0036','1');

	
insert into line_item_data values ('LI000001','Jeans - Large','10','92.91','10.60','UO000001','1');
insert into line_item_data values ('LI000002','Jeans - Large0002','12','84.67','8.34','UO000001','1');
insert into line_item_data values ('LI000003','Jeans - Large0003','10','91.07','8.19','UO000001','1');
insert into line_item_data values ('LI000004','Jeans - Large0004','10','102.08','10.22','UO000001','1');
insert into line_item_data values ('LI000005','Jeans - Large0005','12','91.47','10.42','UO000001','1');
insert into line_item_data values ('LI000006','Jeans - Large0006','10','73.14','9.33','UO000001','1');
insert into line_item_data values ('LI000007','Jeans - Large0007','11','97.10','10.93','UO000002','1');
insert into line_item_data values ('LI000008','Jeans - Large0008','12','87.07','9.83','UO000002','1');
insert into line_item_data values ('LI000009','Jeans - Large0009','10','72.61','8.74','UO000002','1');
insert into line_item_data values ('LI000010','Jeans - Large0010','11','91.62','10.75','UO000002','1');
insert into line_item_data values ('LI000011','Jeans - Large0011','11','88.14','8.90','UO000002','1');
insert into line_item_data values ('LI000012','Jeans - Large0012','11','90.59','9.71','UO000002','1');
insert into line_item_data values ('LI000013','Jeans - Large0013','9','81.91','10.66','UO000003','1');
insert into line_item_data values ('LI000014','Jeans - Large0014','10','88.21','8.71','UO000003','1');
insert into line_item_data values ('LI000015','Jeans - Large0015','9','99.11','8.16','UO000003','1');
insert into line_item_data values ('LI000016','Jeans - Large0016','10','99.56','9.46','UO000003','1');
insert into line_item_data values ('LI000017','Jeans - Large0017','12','86.34','10.37','UO000003','1');
insert into line_item_data values ('LI000018','Jeans - Large0018','10','97.53','10.52','UO000003','1');
insert into line_item_data values ('LI000019','Jeans - Large0019','10','100.61','9.02','UO000004','1');
insert into line_item_data values ('LI000020','Jeans - Large0020','11','93.04','7.90','UO000004','1');
insert into line_item_data values ('LI000021','Jeans - Large0021','10','95.46','7.83','UO000004','1');
insert into line_item_data values ('LI000022','Jeans - Large0022','9','84.15','9.41','UO000004','1');
insert into line_item_data values ('LI000023','Jeans - Large0023','10','102.21','8.32','UO000004','1');
insert into line_item_data values ('LI000024','Jeans - Large0024','12','73.41','9.64','UO000004','1');
insert into line_item_data values ('LI000025','Jeans - Large0025','10','88.36','10.46','UO000005','1');
insert into line_item_data values ('LI000026','Jeans - Large0026','10','74.36','8.62','UO000005','1');
insert into line_item_data values ('LI000027','Jeans - Large0027','11','84.86','10.85','UO000005','1');
insert into line_item_data values ('LI000028','Jeans - Large0028','11','76.62','10.30','UO000005','1');
insert into line_item_data values ('LI000029','Jeans - Large0029','11','81.12','9.79','UO000005','1');
insert into line_item_data values ('LI000030','Jeans - Large0030','10','88.54','8.83','UO000005','1');
insert into line_item_data values ('LI000031','Jeans - Large0031','10','72.41','8.73','UO000006','1');
insert into line_item_data values ('LI000032','Jeans - Large0032','12','94.40','9.19','UO000006','1');
insert into line_item_data values ('LI000033','Jeans - Large0033','9','80.47','8.50','UO000006','1');
insert into line_item_data values ('LI000034','Jeans - Large0034','12','80.04','9.63','UO000006','1');
insert into line_item_data values ('LI000035','Jeans - Large0035','10','92.61','9.69','UO000006','1');
insert into line_item_data values ('LI000036','Jeans - Large0036','10','81.32','7.75','UO000006','1');
insert into line_item_data values ('LI000037','Jeans - Large0037','9','89.56','9.88','UO000007','1');
insert into line_item_data values ('LI000038','Jeans - Large0038','10','81.73','8.28','UO000007','1');
insert into line_item_data values ('LI000039','Jeans - Large0039','11','88.56','10.89','UO000007','1');
insert into line_item_data values ('LI000040','Jeans - Large0040','11','86.39','10.54','UO000007','1');
insert into line_item_data values ('LI000041','Jeans - Large0041','10','91.89','10.29','UO000007','1');
insert into line_item_data values ('LI000042','Jeans - Large0042','9','89.86','7.73','UO000007','1');
insert into line_item_data values ('LI000043','Jeans - Large0043','10','94.79','9.32','UO000008','1');
insert into line_item_data values ('LI000044','Jeans - Large0044','12','72.31','9.28','UO000008','1');
insert into line_item_data values ('LI000045','Jeans - Large0045','10','91.38','9.81','UO000008','1');
insert into line_item_data values ('LI000046','Jeans - Large0046','10','100.03','9.19','UO000008','1');
insert into line_item_data values ('LI000047','Jeans - Large0047','9','76.39','7.87','UO000008','1');
insert into line_item_data values ('LI000048','Jeans - Large0048','9','82.11','9.88','UO000008','1');
insert into line_item_data values ('LI000049','Jeans - Large0049','11','87.37','8.87','UO000009','1');
insert into line_item_data values ('LI000050','Jeans - Large0050','9','94.67','10.71','UO000009','1');
insert into line_item_data values ('LI000051','Jeans - Large0051','11','81.46','10.90','UO000009','1');
insert into line_item_data values ('LI000052','Jeans - Large0052','9','96.82','10.86','UO000009','1');
insert into line_item_data values ('LI000053','Jeans - Large0053','12','86.49','8.88','UO000009','1');
insert into line_item_data values ('LI000054','Jeans - Large0054','12','74.07','7.87','UO000009','1');
insert into line_item_data values ('LI000055','Jeans - Large0055','9','80.07','9.93','UO000010','1');
insert into line_item_data values ('LI000056','Jeans - Large0056','11','80.21','8.72','UO000010','1');
insert into line_item_data values ('LI000057','Jeans - Large0057','10','94.83','9.82','UO000010','1');
insert into line_item_data values ('LI000058','Jeans - Large0058','10','95.60','9.54','UO000010','1');
insert into line_item_data values ('LI000059','Jeans - Large0059','11','93.58','10.39','UO000010','1');
insert into line_item_data values ('LI000060','Jeans - Large0060','10','95.07','7.75','UO000010','1');
insert into line_item_data values ('LI000061','Jeans - Large0061','11','81.34','7.84','UO000011','1');
insert into line_item_data values ('LI000062','Jeans - Large0062','9','78.66','8.34','UO000011','1');
insert into line_item_data values ('LI000063','Jeans - Large0063','12','74.41','10.91','UO000011','1');
insert into line_item_data values ('LI000064','Jeans - Large0064','11','101.44','8.12','UO000011','1');
insert into line_item_data values ('LI000065','Jeans - Large0065','10','94.30','9.80','UO000011','1');
insert into line_item_data values ('LI000066','Jeans - Large0066','12','81.05','8.51','UO000011','1');
insert into line_item_data values ('LI000067','Jeans - Large0067','11','82.01','9.34','UO000012','1');
insert into line_item_data values ('LI000068','Jeans - Large0068','12','97.91','7.97','UO000012','1');
insert into line_item_data values ('LI000069','Jeans - Large0069','11','89.99','8.57','UO000012','1');
insert into line_item_data values ('LI000070','Jeans - Large0070','11','87.22','9.18','UO000012','1');
insert into line_item_data values ('LI000071','Jeans - Large0071','11','74.28','8.67','UO000012','1');
insert into line_item_data values ('LI000072','Jeans - Large0072','12','91.06','9.21','UO000012','1');
insert into line_item_data values ('LI000073','Jeans - Large0073','12','98.72','8.36','UO000013','1');
insert into line_item_data values ('LI000074','Jeans - Large0074','11','94.65','8.86','UO000013','1');
insert into line_item_data values ('LI000075','Jeans - Large0075','10','99.34','9.55','UO000013','1');
insert into line_item_data values ('LI000076','Jeans - Large0076','11','83.77','10.66','UO000013','1');
insert into line_item_data values ('LI000077','Jeans - Large0077','9','91.15','9.90','UO000013','1');
insert into line_item_data values ('LI000078','Jeans - Large0078','10','77.19','8.79','UO000013','1');
insert into line_item_data values ('LI000079','Jeans - Large0079','9','85.33','10.27','UO000014','1');
insert into line_item_data values ('LI000080','Jeans - Large0080','10','79.40','9.61','UO000014','1');
insert into line_item_data values ('LI000081','Jeans - Large0081','11','76.41','9.96','UO000014','1');
insert into line_item_data values ('LI000082','Jeans - Large0082','10','93.40','9.41','UO000014','1');
insert into line_item_data values ('LI000083','Jeans - Large0083','10','86.52','7.82','UO000014','1');
insert into line_item_data values ('LI000084','Jeans - Large0084','11','88.25','7.91','UO000014','1');
insert into line_item_data values ('LI000085','Jeans - Large0085','10','81.69','8.92','UO000015','1');
insert into line_item_data values ('LI000086','Jeans - Large0086','12','89.21','9.86','UO000015','1');
insert into line_item_data values ('LI000087','Jeans - Large0087','9','80.79','7.81','UO000015','1');
insert into line_item_data values ('LI000088','Jeans - Large0088','11','77.95','7.82','UO000015','1');
insert into line_item_data values ('LI000089','Jeans - Large0089','10','99.41','8.51','UO000015','1');
insert into line_item_data values ('LI000090','Jeans - Large0090','12','91.20','8.12','UO000015','1');
insert into line_item_data values ('LI000091','Jeans - Large0091','12','84.27','9.59','UO000016','1');
insert into line_item_data values ('LI000092','Jeans - Large0092','12','101.59','8.38','UO000016','1');
insert into line_item_data values ('LI000093','Jeans - Large0093','11','81.59','9.74','UO000016','1');
insert into line_item_data values ('LI000094','Jeans - Large0094','10','82.34','9.51','UO000016','1');
insert into line_item_data values ('LI000095','Jeans - Large0095','10','89.18','9.45','UO000016','1');
insert into line_item_data values ('LI000096','Jeans - Large0096','12','76.48','9.87','UO000016','1');
insert into line_item_data values ('LI000097','Jeans - Large0097','9','74.02','9.01','UO000017','1');
insert into line_item_data values ('LI000098','Jeans - Large0098','9','86.06','10.32','UO000017','1');
insert into line_item_data values ('LI000099','Jeans - Large0099','12','84.91','9.67','UO000017','1');
insert into line_item_data values ('LI000100','Jeans - Large0100','12','84.98','10.74','UO000017','1');
insert into line_item_data values ('LI000101','Jeans - Large0101','12','91.75','10.93','UO000017','1');
insert into line_item_data values ('LI000102','Jeans - Large0102','9','99.52','10.39','UO000017','1');
insert into line_item_data values ('LI000103','Jeans - Large0103','12','98.85','10.57','UO000018','1');
insert into line_item_data values ('LI000104','Jeans - Large0104','12','97.36','9.22','UO000018','1');
insert into line_item_data values ('LI000105','Jeans - Large0105','11','101.98','10.72','UO000018','1');
insert into line_item_data values ('LI000106','Jeans - Large0106','11','96.16','9.17','UO000018','1');
insert into line_item_data values ('LI000107','Jeans - Large0107','10','91.97','10.17','UO000018','1');
insert into line_item_data values ('LI000108','Jeans - Large0108','12','88.70','9.59','UO000018','1');
insert into line_item_data values ('LI000109','Jeans - Large0109','12','91.20','8.45','UO000019','1');
insert into line_item_data values ('LI000110','Jeans - Large0110','12','75.88','7.94','UO000019','1');
insert into line_item_data values ('LI000111','Jeans - Large0111','10','95.86','7.85','UO000019','1');
insert into line_item_data values ('LI000112','Jeans - Large0112','9','101.15','8.62','UO000019','1');
insert into line_item_data values ('LI000113','Jeans - Large0113','9','102.67','8.10','UO000019','1');
insert into line_item_data values ('LI000114','Jeans - Large0114','10','96.71','8.79','UO000019','1');
insert into line_item_data values ('LI000115','Jeans - Large0115','10','82.10','9.01','UO000020','1');
insert into line_item_data values ('LI000116','Jeans - Large0116','12','77.02','9.84','UO000020','1');
insert into line_item_data values ('LI000117','Jeans - Large0117','12','90.90','10.06','UO000020','1');
insert into line_item_data values ('LI000118','Jeans - Large0118','10','97.50','10.57','UO000020','1');
insert into line_item_data values ('LI000119','Jeans - Large0119','10','80.21','9.07','UO000020','1');
insert into line_item_data values ('LI000120','Jeans - Large0120','10','85.81','9.97','UO000020','1');
insert into line_item_data values ('LI000121','Jeans - Large0121','12','99.84','8.49','UO000021','1');
insert into line_item_data values ('LI000122','Jeans - Large0122','12','74.65','10.77','UO000021','1');
insert into line_item_data values ('LI000123','Jeans - Large0123','11','81.34','10.77','UO000021','1');
insert into line_item_data values ('LI000124','Jeans - Large0124','12','76.39','8.14','UO000021','1');
insert into line_item_data values ('LI000125','Jeans - Large0125','10','98.70','10.29','UO000021','1');
insert into line_item_data values ('LI000126','Jeans - Large0126','11','87.88','9.71','UO000021','1');
insert into line_item_data values ('LI000127','Jeans - Large0127','9','83.36','10.66','UO000022','1');
insert into line_item_data values ('LI000128','Jeans - Large0128','12','96.15','9.84','UO000022','1');
insert into line_item_data values ('LI000129','Jeans - Large0129','10','96.99','8.46','UO000022','1');
insert into line_item_data values ('LI000130','Jeans - Large0130','12','101.13','9.80','UO000022','1');
insert into line_item_data values ('LI000131','Jeans - Large0131','10','96.72','8.35','UO000022','1');
insert into line_item_data values ('LI000132','Jeans - Large0132','12','81.72','8.29','UO000022','1');
insert into line_item_data values ('LI000133','Jeans - Large0133','12','89.87','9.73','UO000023','1');
insert into line_item_data values ('LI000134','Jeans - Large0134','11','85.23','8.06','UO000023','1');
insert into line_item_data values ('LI000135','Jeans - Large0135','11','78.35','9.98','UO000023','1');
insert into line_item_data values ('LI000136','Jeans - Large0136','10','100.00','10.87','UO000023','1');
insert into line_item_data values ('LI000137','Jeans - Large0137','12','95.19','9.00','UO000023','1');
insert into line_item_data values ('LI000138','Jeans - Large0138','11','98.20','10.13','UO000023','1');
insert into line_item_data values ('LI000139','Jeans - Large0139','10','99.55','8.55','UO000024','1');
insert into line_item_data values ('LI000140','Jeans - Large0140','10','74.77','7.86','UO000024','1');
insert into line_item_data values ('LI000141','Jeans - Large0141','11','100.66','9.54','UO000024','1');
insert into line_item_data values ('LI000142','Jeans - Large0142','10','72.14','8.01','UO000024','1');
insert into line_item_data values ('LI000143','Jeans - Large0143','12','99.10','9.47','UO000024','1');
insert into line_item_data values ('LI000144','Jeans - Large0144','11','80.92','8.94','UO000024','1');
insert into line_item_data values ('LI000145','Jeans - Large0145','12','88.89','9.77','UO000025','1');
insert into line_item_data values ('LI000146','Jeans - Large0146','12','80.30','10.87','UO000025','1');
insert into line_item_data values ('LI000147','Jeans - Large0147','11','95.15','8.76','UO000025','1');
insert into line_item_data values ('LI000148','Jeans - Large0148','12','99.17','7.89','UO000025','1');
insert into line_item_data values ('LI000149','Jeans - Large0149','11','90.95','10.17','UO000025','1');
insert into line_item_data values ('LI000150','Jeans - Large0150','11','72.97','10.41','UO000025','1');
insert into line_item_data values ('LI000151','Jeans - Large0151','11','73.97','8.51','UO000026','1');
insert into line_item_data values ('LI000152','Jeans - Large0152','11','72.09','11.00','UO000026','1');
insert into line_item_data values ('LI000153','Jeans - Large0153','9','83.66','7.97','UO000026','1');
insert into line_item_data values ('LI000154','Jeans - Large0154','10','98.84','10.06','UO000026','1');
insert into line_item_data values ('LI000155','Jeans - Large0155','10','89.04','9.46','UO000026','1');
insert into line_item_data values ('LI000156','Jeans - Large0156','11','81.94','7.77','UO000026','1');
insert into line_item_data values ('LI000157','Jeans - Large0157','11','79.92','9.91','UO000027','1');
insert into line_item_data values ('LI000158','Jeans - Large0158','12','82.80','10.48','UO000027','1');
insert into line_item_data values ('LI000159','Jeans - Large0159','12','76.23','7.93','UO000027','1');
insert into line_item_data values ('LI000160','Jeans - Large0160','9','95.23','8.75','UO000027','1');
insert into line_item_data values ('LI000161','Jeans - Large0161','10','79.69','9.96','UO000027','1');
insert into line_item_data values ('LI000162','Jeans - Large0162','10','98.94','10.16','UO000027','1');
insert into line_item_data values ('LI000163','Jeans - Large0163','11','92.42','10.93','UO000028','1');
insert into line_item_data values ('LI000164','Jeans - Large0164','10','102.91','9.14','UO000028','1');
insert into line_item_data values ('LI000165','Jeans - Large0165','11','92.58','10.69','UO000028','1');
insert into line_item_data values ('LI000166','Jeans - Large0166','12','95.43','9.28','UO000028','1');
insert into line_item_data values ('LI000167','Jeans - Large0167','11','79.55','8.22','UO000028','1');
insert into line_item_data values ('LI000168','Jeans - Large0168','12','84.34','7.84','UO000028','1');
insert into line_item_data values ('LI000169','Jeans - Large0169','10','80.32','9.88','UO000029','1');
insert into line_item_data values ('LI000170','Jeans - Large0170','12','75.14','10.35','UO000029','1');
insert into line_item_data values ('LI000171','Jeans - Large0171','10','85.36','7.96','UO000029','1');
insert into line_item_data values ('LI000172','Jeans - Large0172','12','75.72','8.92','UO000029','1');
insert into line_item_data values ('LI000173','Jeans - Large0173','11','96.55','8.48','UO000029','1');
insert into line_item_data values ('LI000174','Jeans - Large0174','11','87.75','9.30','UO000029','1');
insert into line_item_data values ('LI000175','Jeans - Large0175','11','91.11','8.05','UO000030','1');
insert into line_item_data values ('LI000176','Jeans - Large0176','11','82.61','9.36','UO000030','1');
insert into line_item_data values ('LI000177','Jeans - Large0177','11','84.91','8.12','UO000030','1');
insert into line_item_data values ('LI000178','Jeans - Large0178','10','102.02','9.65','UO000030','1');
insert into line_item_data values ('LI000179','Jeans - Large0179','10','95.59','8.62','UO000030','1');
insert into line_item_data values ('LI000180','Jeans - Large0180','10','82.79','10.44','UO000030','1');
insert into line_item_data values ('LI000181','Jeans - Large0181','10','100.57','10.54','UO000031','1');
insert into line_item_data values ('LI000182','Jeans - Large0182','12','88.84','7.96','UO000031','1');
insert into line_item_data values ('LI000183','Jeans - Large0183','11','74.73','9.04','UO000031','1');
insert into line_item_data values ('LI000184','Jeans - Large0184','12','97.09','8.82','UO000031','1');
insert into line_item_data values ('LI000185','Jeans - Large0185','10','79.00','8.97','UO000031','1');
insert into line_item_data values ('LI000186','Jeans - Large0186','12','85.55','8.08','UO000031','1');
insert into line_item_data values ('LI000187','Jeans - Large0187','11','79.93','9.68','UO000032','1');
insert into line_item_data values ('LI000188','Jeans - Large0188','10','95.95','7.98','UO000032','1');
insert into line_item_data values ('LI000189','Jeans - Large0189','11','84.12','8.84','UO000032','1');
insert into line_item_data values ('LI000190','Jeans - Large0190','10','83.17','8.56','UO000032','1');
insert into line_item_data values ('LI000191','Jeans - Large0191','10','88.68','8.56','UO000032','1');
insert into line_item_data values ('LI000192','Jeans - Large0192','10','100.18','10.19','UO000032','1');
insert into line_item_data values ('LI000193','Jeans - Large0193','12','89.16','8.85','UO000033','1');
insert into line_item_data values ('LI000194','Jeans - Large0194','9','93.49','8.10','UO000033','1');
insert into line_item_data values ('LI000195','Jeans - Large0195','12','90.49','9.54','UO000033','1');
insert into line_item_data values ('LI000196','Jeans - Large0196','10','93.45','8.21','UO000033','1');
insert into line_item_data values ('LI000197','Jeans - Large0197','10','99.62','9.89','UO000033','1');
insert into line_item_data values ('LI000198','Jeans - Large0198','12','76.88','7.87','UO000033','1');
insert into line_item_data values ('LI000199','Jeans - Large0199','9','97.03','8.05','UO000034','1');
insert into line_item_data values ('LI000200','Jeans - Large0200','12','72.58','9.36','UO000034','1');
insert into line_item_data values ('LI000201','Jeans - Large0201','12','83.85','9.07','UO000034','1');
insert into line_item_data values ('LI000202','Jeans - Large0202','11','75.64','8.62','UO000034','1');
insert into line_item_data values ('LI000203','Jeans - Large0203','12','88.27','9.40','UO000034','1');
insert into line_item_data values ('LI000204','Jeans - Large0204','9','93.07','9.29','UO000034','1');
insert into line_item_data values ('LI000205','Jeans - Large0205','11','77.56','8.77','UO000035','1');
insert into line_item_data values ('LI000206','Jeans - Large0206','11','92.12','8.26','UO000035','1');
insert into line_item_data values ('LI000207','Jeans - Large0207','12','79.78','10.26','UO000035','1');
insert into line_item_data values ('LI000208','Jeans - Large0208','9','97.63','9.16','UO000035','1');
insert into line_item_data values ('LI000209','Jeans - Large0209','10','81.04','9.78','UO000035','1');
insert into line_item_data values ('LI000210','Jeans - Large0210','12','94.73','8.88','UO000035','1');
insert into line_item_data values ('LI000211','Jeans - Large0211','10','87.22','8.95','UO000036','1');
insert into line_item_data values ('LI000212','Jeans - Large0212','12','76.75','9.47','UO000036','1');
insert into line_item_data values ('LI000213','Jeans - Large0213','10','93.21','9.43','UO000036','1');
insert into line_item_data values ('LI000214','Jeans - Large0214','11','93.90','8.44','UO000036','1');
insert into line_item_data values ('LI000215','Jeans - Large0215','12','101.72','8.15','UO000036','1');
insert into line_item_data values ('LI000216','Jeans - Large0216','9','77.33','8.64','UO000036','1');

	
insert into order_promotion_data values ('OP000001','Promo For Total','959','886','PERCENT_OFF','UO000001','1');
insert into order_promotion_data values ('OP000002','Promo For Total0002','1201','1104','FIX_PRICE','UO000001','1');
insert into order_promotion_data values ('OP000003','Promo For Total0003','954','1024','PERCENT_OFF','UO000001','1');
insert into order_promotion_data values ('OP000004','Promo For Total0004','1211','1187','FIX_PRICE','UO000001','1');
insert into order_promotion_data values ('OP000005','Promo For Total0005','976','1229','PERCENT_OFF','UO000001','1');
insert into order_promotion_data values ('OP000006','Promo For Total0006','1000','1155','FIX_PRICE','UO000001','1');
insert into order_promotion_data values ('OP000007','Promo For Total0007','982','1009','PERCENT_OFF','UO000002','1');
insert into order_promotion_data values ('OP000008','Promo For Total0008','1165','1041','FIX_PRICE','UO000002','1');
insert into order_promotion_data values ('OP000009','Promo For Total0009','1117','1017','PERCENT_OFF','UO000002','1');
insert into order_promotion_data values ('OP000010','Promo For Total0010','989','1010','FIX_PRICE','UO000002','1');
insert into order_promotion_data values ('OP000011','Promo For Total0011','1130','873','PERCENT_OFF','UO000002','1');
insert into order_promotion_data values ('OP000012','Promo For Total0012','1007','1191','FIX_PRICE','UO000002','1');
insert into order_promotion_data values ('OP000013','Promo For Total0013','981','1085','PERCENT_OFF','UO000003','1');
insert into order_promotion_data values ('OP000014','Promo For Total0014','1169','916','FIX_PRICE','UO000003','1');
insert into order_promotion_data values ('OP000015','Promo For Total0015','1000','875','PERCENT_OFF','UO000003','1');
insert into order_promotion_data values ('OP000016','Promo For Total0016','1197','1021','FIX_PRICE','UO000003','1');
insert into order_promotion_data values ('OP000017','Promo For Total0017','1168','1155','PERCENT_OFF','UO000003','1');
insert into order_promotion_data values ('OP000018','Promo For Total0018','1094','1010','FIX_PRICE','UO000003','1');
insert into order_promotion_data values ('OP000019','Promo For Total0019','870','872','PERCENT_OFF','UO000004','1');
insert into order_promotion_data values ('OP000020','Promo For Total0020','1129','1104','FIX_PRICE','UO000004','1');
insert into order_promotion_data values ('OP000021','Promo For Total0021','922','1019','PERCENT_OFF','UO000004','1');
insert into order_promotion_data values ('OP000022','Promo For Total0022','1202','1202','FIX_PRICE','UO000004','1');
insert into order_promotion_data values ('OP000023','Promo For Total0023','1084','912','PERCENT_OFF','UO000004','1');
insert into order_promotion_data values ('OP000024','Promo For Total0024','1202','959','FIX_PRICE','UO000004','1');
insert into order_promotion_data values ('OP000025','Promo For Total0025','1135','866','PERCENT_OFF','UO000005','1');
insert into order_promotion_data values ('OP000026','Promo For Total0026','1214','936','FIX_PRICE','UO000005','1');
insert into order_promotion_data values ('OP000027','Promo For Total0027','1223','1060','PERCENT_OFF','UO000005','1');
insert into order_promotion_data values ('OP000028','Promo For Total0028','987','910','FIX_PRICE','UO000005','1');
insert into order_promotion_data values ('OP000029','Promo For Total0029','1013','918','PERCENT_OFF','UO000005','1');
insert into order_promotion_data values ('OP000030','Promo For Total0030','1229','1009','FIX_PRICE','UO000005','1');
insert into order_promotion_data values ('OP000031','Promo For Total0031','1005','946','PERCENT_OFF','UO000006','1');
insert into order_promotion_data values ('OP000032','Promo For Total0032','943','956','FIX_PRICE','UO000006','1');
insert into order_promotion_data values ('OP000033','Promo For Total0033','980','1153','PERCENT_OFF','UO000006','1');
insert into order_promotion_data values ('OP000034','Promo For Total0034','1090','1004','FIX_PRICE','UO000006','1');
insert into order_promotion_data values ('OP000035','Promo For Total0035','1025','1228','PERCENT_OFF','UO000006','1');
insert into order_promotion_data values ('OP000036','Promo For Total0036','975','1226','FIX_PRICE','UO000006','1');
insert into order_promotion_data values ('OP000037','Promo For Total0037','1037','1095','PERCENT_OFF','UO000007','1');
insert into order_promotion_data values ('OP000038','Promo For Total0038','872','953','FIX_PRICE','UO000007','1');
insert into order_promotion_data values ('OP000039','Promo For Total0039','1003','1020','PERCENT_OFF','UO000007','1');
insert into order_promotion_data values ('OP000040','Promo For Total0040','871','1174','FIX_PRICE','UO000007','1');
insert into order_promotion_data values ('OP000041','Promo For Total0041','1070','1003','PERCENT_OFF','UO000007','1');
insert into order_promotion_data values ('OP000042','Promo For Total0042','1207','1000','FIX_PRICE','UO000007','1');
insert into order_promotion_data values ('OP000043','Promo For Total0043','881','1045','PERCENT_OFF','UO000008','1');
insert into order_promotion_data values ('OP000044','Promo For Total0044','907','1165','FIX_PRICE','UO000008','1');
insert into order_promotion_data values ('OP000045','Promo For Total0045','991','925','PERCENT_OFF','UO000008','1');
insert into order_promotion_data values ('OP000046','Promo For Total0046','947','1204','FIX_PRICE','UO000008','1');
insert into order_promotion_data values ('OP000047','Promo For Total0047','1127','1188','PERCENT_OFF','UO000008','1');
insert into order_promotion_data values ('OP000048','Promo For Total0048','1177','1202','FIX_PRICE','UO000008','1');
insert into order_promotion_data values ('OP000049','Promo For Total0049','1115','1003','PERCENT_OFF','UO000009','1');
insert into order_promotion_data values ('OP000050','Promo For Total0050','1021','975','FIX_PRICE','UO000009','1');
insert into order_promotion_data values ('OP000051','Promo For Total0051','1133','950','PERCENT_OFF','UO000009','1');
insert into order_promotion_data values ('OP000052','Promo For Total0052','1100','1006','FIX_PRICE','UO000009','1');
insert into order_promotion_data values ('OP000053','Promo For Total0053','1218','1129','PERCENT_OFF','UO000009','1');
insert into order_promotion_data values ('OP000054','Promo For Total0054','1114','1213','FIX_PRICE','UO000009','1');
insert into order_promotion_data values ('OP000055','Promo For Total0055','1110','865','PERCENT_OFF','UO000010','1');
insert into order_promotion_data values ('OP000056','Promo For Total0056','1160','1177','FIX_PRICE','UO000010','1');
insert into order_promotion_data values ('OP000057','Promo For Total0057','1071','946','PERCENT_OFF','UO000010','1');
insert into order_promotion_data values ('OP000058','Promo For Total0058','1152','1067','FIX_PRICE','UO000010','1');
insert into order_promotion_data values ('OP000059','Promo For Total0059','1012','1028','PERCENT_OFF','UO000010','1');
insert into order_promotion_data values ('OP000060','Promo For Total0060','1110','980','FIX_PRICE','UO000010','1');
insert into order_promotion_data values ('OP000061','Promo For Total0061','1086','1072','PERCENT_OFF','UO000011','1');
insert into order_promotion_data values ('OP000062','Promo For Total0062','1044','1060','FIX_PRICE','UO000011','1');
insert into order_promotion_data values ('OP000063','Promo For Total0063','971','881','PERCENT_OFF','UO000011','1');
insert into order_promotion_data values ('OP000064','Promo For Total0064','977','1149','FIX_PRICE','UO000011','1');
insert into order_promotion_data values ('OP000065','Promo For Total0065','878','1185','PERCENT_OFF','UO000011','1');
insert into order_promotion_data values ('OP000066','Promo For Total0066','895','998','FIX_PRICE','UO000011','1');
insert into order_promotion_data values ('OP000067','Promo For Total0067','1013','1020','PERCENT_OFF','UO000012','1');
insert into order_promotion_data values ('OP000068','Promo For Total0068','1106','1167','FIX_PRICE','UO000012','1');
insert into order_promotion_data values ('OP000069','Promo For Total0069','1217','1188','PERCENT_OFF','UO000012','1');
insert into order_promotion_data values ('OP000070','Promo For Total0070','1226','898','FIX_PRICE','UO000012','1');
insert into order_promotion_data values ('OP000071','Promo For Total0071','1048','1029','PERCENT_OFF','UO000012','1');
insert into order_promotion_data values ('OP000072','Promo For Total0072','1125','1086','FIX_PRICE','UO000012','1');
insert into order_promotion_data values ('OP000073','Promo For Total0073','1069','923','PERCENT_OFF','UO000013','1');
insert into order_promotion_data values ('OP000074','Promo For Total0074','1172','909','FIX_PRICE','UO000013','1');
insert into order_promotion_data values ('OP000075','Promo For Total0075','913','908','PERCENT_OFF','UO000013','1');
insert into order_promotion_data values ('OP000076','Promo For Total0076','903','1202','FIX_PRICE','UO000013','1');
insert into order_promotion_data values ('OP000077','Promo For Total0077','942','1141','PERCENT_OFF','UO000013','1');
insert into order_promotion_data values ('OP000078','Promo For Total0078','1017','914','FIX_PRICE','UO000013','1');
insert into order_promotion_data values ('OP000079','Promo For Total0079','918','1054','PERCENT_OFF','UO000014','1');
insert into order_promotion_data values ('OP000080','Promo For Total0080','976','981','FIX_PRICE','UO000014','1');
insert into order_promotion_data values ('OP000081','Promo For Total0081','1088','1002','PERCENT_OFF','UO000014','1');
insert into order_promotion_data values ('OP000082','Promo For Total0082','954','1128','FIX_PRICE','UO000014','1');
insert into order_promotion_data values ('OP000083','Promo For Total0083','1013','1147','PERCENT_OFF','UO000014','1');
insert into order_promotion_data values ('OP000084','Promo For Total0084','902','1089','FIX_PRICE','UO000014','1');
insert into order_promotion_data values ('OP000085','Promo For Total0085','1149','918','PERCENT_OFF','UO000015','1');
insert into order_promotion_data values ('OP000086','Promo For Total0086','1133','867','FIX_PRICE','UO000015','1');
insert into order_promotion_data values ('OP000087','Promo For Total0087','1059','1200','PERCENT_OFF','UO000015','1');
insert into order_promotion_data values ('OP000088','Promo For Total0088','962','1220','FIX_PRICE','UO000015','1');
insert into order_promotion_data values ('OP000089','Promo For Total0089','1079','1028','PERCENT_OFF','UO000015','1');
insert into order_promotion_data values ('OP000090','Promo For Total0090','975','1065','FIX_PRICE','UO000015','1');
insert into order_promotion_data values ('OP000091','Promo For Total0091','867','899','PERCENT_OFF','UO000016','1');
insert into order_promotion_data values ('OP000092','Promo For Total0092','1046','1096','FIX_PRICE','UO000016','1');
insert into order_promotion_data values ('OP000093','Promo For Total0093','880','967','PERCENT_OFF','UO000016','1');
insert into order_promotion_data values ('OP000094','Promo For Total0094','1162','870','FIX_PRICE','UO000016','1');
insert into order_promotion_data values ('OP000095','Promo For Total0095','1194','1026','PERCENT_OFF','UO000016','1');
insert into order_promotion_data values ('OP000096','Promo For Total0096','1219','1208','FIX_PRICE','UO000016','1');
insert into order_promotion_data values ('OP000097','Promo For Total0097','1008','1009','PERCENT_OFF','UO000017','1');
insert into order_promotion_data values ('OP000098','Promo For Total0098','909','1101','FIX_PRICE','UO000017','1');
insert into order_promotion_data values ('OP000099','Promo For Total0099','868','1076','PERCENT_OFF','UO000017','1');
insert into order_promotion_data values ('OP000100','Promo For Total0100','949','897','FIX_PRICE','UO000017','1');
insert into order_promotion_data values ('OP000101','Promo For Total0101','1169','1210','PERCENT_OFF','UO000017','1');
insert into order_promotion_data values ('OP000102','Promo For Total0102','1153','1021','FIX_PRICE','UO000017','1');
insert into order_promotion_data values ('OP000103','Promo For Total0103','1003','1100','PERCENT_OFF','UO000018','1');
insert into order_promotion_data values ('OP000104','Promo For Total0104','932','1215','FIX_PRICE','UO000018','1');
insert into order_promotion_data values ('OP000105','Promo For Total0105','1037','1016','PERCENT_OFF','UO000018','1');
insert into order_promotion_data values ('OP000106','Promo For Total0106','891','1019','FIX_PRICE','UO000018','1');
insert into order_promotion_data values ('OP000107','Promo For Total0107','952','954','PERCENT_OFF','UO000018','1');
insert into order_promotion_data values ('OP000108','Promo For Total0108','996','1130','FIX_PRICE','UO000018','1');
insert into order_promotion_data values ('OP000109','Promo For Total0109','1154','952','PERCENT_OFF','UO000019','1');
insert into order_promotion_data values ('OP000110','Promo For Total0110','1183','1168','FIX_PRICE','UO000019','1');
insert into order_promotion_data values ('OP000111','Promo For Total0111','1209','1124','PERCENT_OFF','UO000019','1');
insert into order_promotion_data values ('OP000112','Promo For Total0112','1150','994','FIX_PRICE','UO000019','1');
insert into order_promotion_data values ('OP000113','Promo For Total0113','1089','921','PERCENT_OFF','UO000019','1');
insert into order_promotion_data values ('OP000114','Promo For Total0114','926','1056','FIX_PRICE','UO000019','1');
insert into order_promotion_data values ('OP000115','Promo For Total0115','1049','1074','PERCENT_OFF','UO000020','1');
insert into order_promotion_data values ('OP000116','Promo For Total0116','922','877','FIX_PRICE','UO000020','1');
insert into order_promotion_data values ('OP000117','Promo For Total0117','1055','978','PERCENT_OFF','UO000020','1');
insert into order_promotion_data values ('OP000118','Promo For Total0118','930','995','FIX_PRICE','UO000020','1');
insert into order_promotion_data values ('OP000119','Promo For Total0119','1130','935','PERCENT_OFF','UO000020','1');
insert into order_promotion_data values ('OP000120','Promo For Total0120','923','889','FIX_PRICE','UO000020','1');
insert into order_promotion_data values ('OP000121','Promo For Total0121','914','1123','PERCENT_OFF','UO000021','1');
insert into order_promotion_data values ('OP000122','Promo For Total0122','960','979','FIX_PRICE','UO000021','1');
insert into order_promotion_data values ('OP000123','Promo For Total0123','870','1196','PERCENT_OFF','UO000021','1');
insert into order_promotion_data values ('OP000124','Promo For Total0124','1214','870','FIX_PRICE','UO000021','1');
insert into order_promotion_data values ('OP000125','Promo For Total0125','1124','1016','PERCENT_OFF','UO000021','1');
insert into order_promotion_data values ('OP000126','Promo For Total0126','926','988','FIX_PRICE','UO000021','1');
insert into order_promotion_data values ('OP000127','Promo For Total0127','1023','881','PERCENT_OFF','UO000022','1');
insert into order_promotion_data values ('OP000128','Promo For Total0128','971','1191','FIX_PRICE','UO000022','1');
insert into order_promotion_data values ('OP000129','Promo For Total0129','1199','1124','PERCENT_OFF','UO000022','1');
insert into order_promotion_data values ('OP000130','Promo For Total0130','1042','1046','FIX_PRICE','UO000022','1');
insert into order_promotion_data values ('OP000131','Promo For Total0131','1069','1209','PERCENT_OFF','UO000022','1');
insert into order_promotion_data values ('OP000132','Promo For Total0132','872','1164','FIX_PRICE','UO000022','1');
insert into order_promotion_data values ('OP000133','Promo For Total0133','1178','1230','PERCENT_OFF','UO000023','1');
insert into order_promotion_data values ('OP000134','Promo For Total0134','1226','1130','FIX_PRICE','UO000023','1');
insert into order_promotion_data values ('OP000135','Promo For Total0135','913','1025','PERCENT_OFF','UO000023','1');
insert into order_promotion_data values ('OP000136','Promo For Total0136','1037','1023','FIX_PRICE','UO000023','1');
insert into order_promotion_data values ('OP000137','Promo For Total0137','1112','946','PERCENT_OFF','UO000023','1');
insert into order_promotion_data values ('OP000138','Promo For Total0138','1046','980','FIX_PRICE','UO000023','1');
insert into order_promotion_data values ('OP000139','Promo For Total0139','1157','1157','PERCENT_OFF','UO000024','1');
insert into order_promotion_data values ('OP000140','Promo For Total0140','959','1201','FIX_PRICE','UO000024','1');
insert into order_promotion_data values ('OP000141','Promo For Total0141','914','927','PERCENT_OFF','UO000024','1');
insert into order_promotion_data values ('OP000142','Promo For Total0142','1019','1220','FIX_PRICE','UO000024','1');
insert into order_promotion_data values ('OP000143','Promo For Total0143','873','1197','PERCENT_OFF','UO000024','1');
insert into order_promotion_data values ('OP000144','Promo For Total0144','1081','1014','FIX_PRICE','UO000024','1');
insert into order_promotion_data values ('OP000145','Promo For Total0145','962','1135','PERCENT_OFF','UO000025','1');
insert into order_promotion_data values ('OP000146','Promo For Total0146','1227','1209','FIX_PRICE','UO000025','1');
insert into order_promotion_data values ('OP000147','Promo For Total0147','1012','906','PERCENT_OFF','UO000025','1');
insert into order_promotion_data values ('OP000148','Promo For Total0148','1182','978','FIX_PRICE','UO000025','1');
insert into order_promotion_data values ('OP000149','Promo For Total0149','1164','923','PERCENT_OFF','UO000025','1');
insert into order_promotion_data values ('OP000150','Promo For Total0150','1193','1136','FIX_PRICE','UO000025','1');
insert into order_promotion_data values ('OP000151','Promo For Total0151','1119','974','PERCENT_OFF','UO000026','1');
insert into order_promotion_data values ('OP000152','Promo For Total0152','967','1083','FIX_PRICE','UO000026','1');
insert into order_promotion_data values ('OP000153','Promo For Total0153','912','1175','PERCENT_OFF','UO000026','1');
insert into order_promotion_data values ('OP000154','Promo For Total0154','1220','1003','FIX_PRICE','UO000026','1');
insert into order_promotion_data values ('OP000155','Promo For Total0155','978','1133','PERCENT_OFF','UO000026','1');
insert into order_promotion_data values ('OP000156','Promo For Total0156','1153','932','FIX_PRICE','UO000026','1');
insert into order_promotion_data values ('OP000157','Promo For Total0157','1138','907','PERCENT_OFF','UO000027','1');
insert into order_promotion_data values ('OP000158','Promo For Total0158','1201','870','FIX_PRICE','UO000027','1');
insert into order_promotion_data values ('OP000159','Promo For Total0159','975','884','PERCENT_OFF','UO000027','1');
insert into order_promotion_data values ('OP000160','Promo For Total0160','1031','887','FIX_PRICE','UO000027','1');
insert into order_promotion_data values ('OP000161','Promo For Total0161','1122','923','PERCENT_OFF','UO000027','1');
insert into order_promotion_data values ('OP000162','Promo For Total0162','988','1098','FIX_PRICE','UO000027','1');
insert into order_promotion_data values ('OP000163','Promo For Total0163','1135','1004','PERCENT_OFF','UO000028','1');
insert into order_promotion_data values ('OP000164','Promo For Total0164','960','1076','FIX_PRICE','UO000028','1');
insert into order_promotion_data values ('OP000165','Promo For Total0165','1044','1212','PERCENT_OFF','UO000028','1');
insert into order_promotion_data values ('OP000166','Promo For Total0166','1090','882','FIX_PRICE','UO000028','1');
insert into order_promotion_data values ('OP000167','Promo For Total0167','972','954','PERCENT_OFF','UO000028','1');
insert into order_promotion_data values ('OP000168','Promo For Total0168','1139','926','FIX_PRICE','UO000028','1');
insert into order_promotion_data values ('OP000169','Promo For Total0169','900','1185','PERCENT_OFF','UO000029','1');
insert into order_promotion_data values ('OP000170','Promo For Total0170','949','999','FIX_PRICE','UO000029','1');
insert into order_promotion_data values ('OP000171','Promo For Total0171','1003','868','PERCENT_OFF','UO000029','1');
insert into order_promotion_data values ('OP000172','Promo For Total0172','879','1057','FIX_PRICE','UO000029','1');
insert into order_promotion_data values ('OP000173','Promo For Total0173','1052','1045','PERCENT_OFF','UO000029','1');
insert into order_promotion_data values ('OP000174','Promo For Total0174','1153','1119','FIX_PRICE','UO000029','1');
insert into order_promotion_data values ('OP000175','Promo For Total0175','865','1220','PERCENT_OFF','UO000030','1');
insert into order_promotion_data values ('OP000176','Promo For Total0176','995','1145','FIX_PRICE','UO000030','1');
insert into order_promotion_data values ('OP000177','Promo For Total0177','1121','1039','PERCENT_OFF','UO000030','1');
insert into order_promotion_data values ('OP000178','Promo For Total0178','1095','1137','FIX_PRICE','UO000030','1');
insert into order_promotion_data values ('OP000179','Promo For Total0179','999','907','PERCENT_OFF','UO000030','1');
insert into order_promotion_data values ('OP000180','Promo For Total0180','1137','957','FIX_PRICE','UO000030','1');
insert into order_promotion_data values ('OP000181','Promo For Total0181','1212','1130','PERCENT_OFF','UO000031','1');
insert into order_promotion_data values ('OP000182','Promo For Total0182','1214','1088','FIX_PRICE','UO000031','1');
insert into order_promotion_data values ('OP000183','Promo For Total0183','1150','1057','PERCENT_OFF','UO000031','1');
insert into order_promotion_data values ('OP000184','Promo For Total0184','1166','925','FIX_PRICE','UO000031','1');
insert into order_promotion_data values ('OP000185','Promo For Total0185','866','955','PERCENT_OFF','UO000031','1');
insert into order_promotion_data values ('OP000186','Promo For Total0186','1142','1190','FIX_PRICE','UO000031','1');
insert into order_promotion_data values ('OP000187','Promo For Total0187','1012','1096','PERCENT_OFF','UO000032','1');
insert into order_promotion_data values ('OP000188','Promo For Total0188','1174','1163','FIX_PRICE','UO000032','1');
insert into order_promotion_data values ('OP000189','Promo For Total0189','1042','975','PERCENT_OFF','UO000032','1');
insert into order_promotion_data values ('OP000190','Promo For Total0190','1223','1178','FIX_PRICE','UO000032','1');
insert into order_promotion_data values ('OP000191','Promo For Total0191','869','1203','PERCENT_OFF','UO000032','1');
insert into order_promotion_data values ('OP000192','Promo For Total0192','913','1008','FIX_PRICE','UO000032','1');
insert into order_promotion_data values ('OP000193','Promo For Total0193','1012','1167','PERCENT_OFF','UO000033','1');
insert into order_promotion_data values ('OP000194','Promo For Total0194','1146','1032','FIX_PRICE','UO000033','1');
insert into order_promotion_data values ('OP000195','Promo For Total0195','1094','1193','PERCENT_OFF','UO000033','1');
insert into order_promotion_data values ('OP000196','Promo For Total0196','1191','1133','FIX_PRICE','UO000033','1');
insert into order_promotion_data values ('OP000197','Promo For Total0197','1174','908','PERCENT_OFF','UO000033','1');
insert into order_promotion_data values ('OP000198','Promo For Total0198','1112','977','FIX_PRICE','UO000033','1');
insert into order_promotion_data values ('OP000199','Promo For Total0199','1137','924','PERCENT_OFF','UO000034','1');
insert into order_promotion_data values ('OP000200','Promo For Total0200','1173','900','FIX_PRICE','UO000034','1');
insert into order_promotion_data values ('OP000201','Promo For Total0201','935','1055','PERCENT_OFF','UO000034','1');
insert into order_promotion_data values ('OP000202','Promo For Total0202','934','1176','FIX_PRICE','UO000034','1');
insert into order_promotion_data values ('OP000203','Promo For Total0203','1114','929','PERCENT_OFF','UO000034','1');
insert into order_promotion_data values ('OP000204','Promo For Total0204','967','927','FIX_PRICE','UO000034','1');
insert into order_promotion_data values ('OP000205','Promo For Total0205','972','954','PERCENT_OFF','UO000035','1');
insert into order_promotion_data values ('OP000206','Promo For Total0206','1225','1053','FIX_PRICE','UO000035','1');
insert into order_promotion_data values ('OP000207','Promo For Total0207','887','1186','PERCENT_OFF','UO000035','1');
insert into order_promotion_data values ('OP000208','Promo For Total0208','1031','1159','FIX_PRICE','UO000035','1');
insert into order_promotion_data values ('OP000209','Promo For Total0209','1065','1167','PERCENT_OFF','UO000035','1');
insert into order_promotion_data values ('OP000210','Promo For Total0210','1112','1043','FIX_PRICE','UO000035','1');
insert into order_promotion_data values ('OP000211','Promo For Total0211','1054','958','PERCENT_OFF','UO000036','1');
insert into order_promotion_data values ('OP000212','Promo For Total0212','959','887','FIX_PRICE','UO000036','1');
insert into order_promotion_data values ('OP000213','Promo For Total0213','1168','1162','PERCENT_OFF','UO000036','1');
insert into order_promotion_data values ('OP000214','Promo For Total0214','908','994','FIX_PRICE','UO000036','1');
insert into order_promotion_data values ('OP000215','Promo For Total0215','922','1124','PERCENT_OFF','UO000036','1');
insert into order_promotion_data values ('OP000216','Promo For Total0216','1178','1168','FIX_PRICE','UO000036','1');

	
insert into manual_adjustment_data values ('MA000001','Promo For Total','1127','1065','OFF','UO000001','1');
insert into manual_adjustment_data values ('MA000002','Promo For Total0002','1033','1157','FIX_PRICE','UO000001','1');
insert into manual_adjustment_data values ('MA000003','Promo For Total0003','1012','1063','OFF','UO000001','1');
insert into manual_adjustment_data values ('MA000004','Promo For Total0004','1058','1141','FIX_PRICE','UO000001','1');
insert into manual_adjustment_data values ('MA000005','Promo For Total0005','1001','987','OFF','UO000001','1');
insert into manual_adjustment_data values ('MA000006','Promo For Total0006','985','907','FIX_PRICE','UO000001','1');
insert into manual_adjustment_data values ('MA000007','Promo For Total0007','934','892','OFF','UO000002','1');
insert into manual_adjustment_data values ('MA000008','Promo For Total0008','867','1054','FIX_PRICE','UO000002','1');
insert into manual_adjustment_data values ('MA000009','Promo For Total0009','917','931','OFF','UO000002','1');
insert into manual_adjustment_data values ('MA000010','Promo For Total0010','938','949','FIX_PRICE','UO000002','1');
insert into manual_adjustment_data values ('MA000011','Promo For Total0011','1097','967','OFF','UO000002','1');
insert into manual_adjustment_data values ('MA000012','Promo For Total0012','869','1096','FIX_PRICE','UO000002','1');
insert into manual_adjustment_data values ('MA000013','Promo For Total0013','1098','864','OFF','UO000003','1');
insert into manual_adjustment_data values ('MA000014','Promo For Total0014','1075','1019','FIX_PRICE','UO000003','1');
insert into manual_adjustment_data values ('MA000015','Promo For Total0015','1124','1123','OFF','UO000003','1');
insert into manual_adjustment_data values ('MA000016','Promo For Total0016','1117','925','FIX_PRICE','UO000003','1');
insert into manual_adjustment_data values ('MA000017','Promo For Total0017','1196','1215','OFF','UO000003','1');
insert into manual_adjustment_data values ('MA000018','Promo For Total0018','1052','1222','FIX_PRICE','UO000003','1');
insert into manual_adjustment_data values ('MA000019','Promo For Total0019','1037','980','OFF','UO000004','1');
insert into manual_adjustment_data values ('MA000020','Promo For Total0020','983','963','FIX_PRICE','UO000004','1');
insert into manual_adjustment_data values ('MA000021','Promo For Total0021','1228','978','OFF','UO000004','1');
insert into manual_adjustment_data values ('MA000022','Promo For Total0022','1166','1058','FIX_PRICE','UO000004','1');
insert into manual_adjustment_data values ('MA000023','Promo For Total0023','1225','1028','OFF','UO000004','1');
insert into manual_adjustment_data values ('MA000024','Promo For Total0024','1040','948','FIX_PRICE','UO000004','1');
insert into manual_adjustment_data values ('MA000025','Promo For Total0025','1206','866','OFF','UO000005','1');
insert into manual_adjustment_data values ('MA000026','Promo For Total0026','1157','1131','FIX_PRICE','UO000005','1');
insert into manual_adjustment_data values ('MA000027','Promo For Total0027','1158','1191','OFF','UO000005','1');
insert into manual_adjustment_data values ('MA000028','Promo For Total0028','974','1066','FIX_PRICE','UO000005','1');
insert into manual_adjustment_data values ('MA000029','Promo For Total0029','1227','1137','OFF','UO000005','1');
insert into manual_adjustment_data values ('MA000030','Promo For Total0030','987','1050','FIX_PRICE','UO000005','1');
insert into manual_adjustment_data values ('MA000031','Promo For Total0031','1178','1217','OFF','UO000006','1');
insert into manual_adjustment_data values ('MA000032','Promo For Total0032','1155','952','FIX_PRICE','UO000006','1');
insert into manual_adjustment_data values ('MA000033','Promo For Total0033','1113','992','OFF','UO000006','1');
insert into manual_adjustment_data values ('MA000034','Promo For Total0034','1191','913','FIX_PRICE','UO000006','1');
insert into manual_adjustment_data values ('MA000035','Promo For Total0035','1229','866','OFF','UO000006','1');
insert into manual_adjustment_data values ('MA000036','Promo For Total0036','961','968','FIX_PRICE','UO000006','1');
insert into manual_adjustment_data values ('MA000037','Promo For Total0037','1216','1151','OFF','UO000007','1');
insert into manual_adjustment_data values ('MA000038','Promo For Total0038','1046','1155','FIX_PRICE','UO000007','1');
insert into manual_adjustment_data values ('MA000039','Promo For Total0039','1050','1109','OFF','UO000007','1');
insert into manual_adjustment_data values ('MA000040','Promo For Total0040','943','868','FIX_PRICE','UO000007','1');
insert into manual_adjustment_data values ('MA000041','Promo For Total0041','1060','1194','OFF','UO000007','1');
insert into manual_adjustment_data values ('MA000042','Promo For Total0042','1204','988','FIX_PRICE','UO000007','1');
insert into manual_adjustment_data values ('MA000043','Promo For Total0043','1042','1190','OFF','UO000008','1');
insert into manual_adjustment_data values ('MA000044','Promo For Total0044','1011','1173','FIX_PRICE','UO000008','1');
insert into manual_adjustment_data values ('MA000045','Promo For Total0045','931','1205','OFF','UO000008','1');
insert into manual_adjustment_data values ('MA000046','Promo For Total0046','1093','1078','FIX_PRICE','UO000008','1');
insert into manual_adjustment_data values ('MA000047','Promo For Total0047','1127','1052','OFF','UO000008','1');
insert into manual_adjustment_data values ('MA000048','Promo For Total0048','1158','1072','FIX_PRICE','UO000008','1');
insert into manual_adjustment_data values ('MA000049','Promo For Total0049','1091','967','OFF','UO000009','1');
insert into manual_adjustment_data values ('MA000050','Promo For Total0050','871','909','FIX_PRICE','UO000009','1');
insert into manual_adjustment_data values ('MA000051','Promo For Total0051','1077','1206','OFF','UO000009','1');
insert into manual_adjustment_data values ('MA000052','Promo For Total0052','1156','955','FIX_PRICE','UO000009','1');
insert into manual_adjustment_data values ('MA000053','Promo For Total0053','927','905','OFF','UO000009','1');
insert into manual_adjustment_data values ('MA000054','Promo For Total0054','1003','1101','FIX_PRICE','UO000009','1');
insert into manual_adjustment_data values ('MA000055','Promo For Total0055','889','888','OFF','UO000010','1');
insert into manual_adjustment_data values ('MA000056','Promo For Total0056','1128','974','FIX_PRICE','UO000010','1');
insert into manual_adjustment_data values ('MA000057','Promo For Total0057','1019','1150','OFF','UO000010','1');
insert into manual_adjustment_data values ('MA000058','Promo For Total0058','950','943','FIX_PRICE','UO000010','1');
insert into manual_adjustment_data values ('MA000059','Promo For Total0059','1214','1150','OFF','UO000010','1');
insert into manual_adjustment_data values ('MA000060','Promo For Total0060','1091','986','FIX_PRICE','UO000010','1');
insert into manual_adjustment_data values ('MA000061','Promo For Total0061','1053','889','OFF','UO000011','1');
insert into manual_adjustment_data values ('MA000062','Promo For Total0062','918','1219','FIX_PRICE','UO000011','1');
insert into manual_adjustment_data values ('MA000063','Promo For Total0063','1102','1006','OFF','UO000011','1');
insert into manual_adjustment_data values ('MA000064','Promo For Total0064','1182','1204','FIX_PRICE','UO000011','1');
insert into manual_adjustment_data values ('MA000065','Promo For Total0065','1145','1214','OFF','UO000011','1');
insert into manual_adjustment_data values ('MA000066','Promo For Total0066','964','933','FIX_PRICE','UO000011','1');
insert into manual_adjustment_data values ('MA000067','Promo For Total0067','1003','1199','OFF','UO000012','1');
insert into manual_adjustment_data values ('MA000068','Promo For Total0068','1225','973','FIX_PRICE','UO000012','1');
insert into manual_adjustment_data values ('MA000069','Promo For Total0069','1173','900','OFF','UO000012','1');
insert into manual_adjustment_data values ('MA000070','Promo For Total0070','1221','1148','FIX_PRICE','UO000012','1');
insert into manual_adjustment_data values ('MA000071','Promo For Total0071','1108','951','OFF','UO000012','1');
insert into manual_adjustment_data values ('MA000072','Promo For Total0072','1164','1090','FIX_PRICE','UO000012','1');
insert into manual_adjustment_data values ('MA000073','Promo For Total0073','1084','1042','OFF','UO000013','1');
insert into manual_adjustment_data values ('MA000074','Promo For Total0074','1048','1040','FIX_PRICE','UO000013','1');
insert into manual_adjustment_data values ('MA000075','Promo For Total0075','927','979','OFF','UO000013','1');
insert into manual_adjustment_data values ('MA000076','Promo For Total0076','1201','991','FIX_PRICE','UO000013','1');
insert into manual_adjustment_data values ('MA000077','Promo For Total0077','994','1169','OFF','UO000013','1');
insert into manual_adjustment_data values ('MA000078','Promo For Total0078','1045','1030','FIX_PRICE','UO000013','1');
insert into manual_adjustment_data values ('MA000079','Promo For Total0079','1076','893','OFF','UO000014','1');
insert into manual_adjustment_data values ('MA000080','Promo For Total0080','1134','1211','FIX_PRICE','UO000014','1');
insert into manual_adjustment_data values ('MA000081','Promo For Total0081','928','1110','OFF','UO000014','1');
insert into manual_adjustment_data values ('MA000082','Promo For Total0082','1132','882','FIX_PRICE','UO000014','1');
insert into manual_adjustment_data values ('MA000083','Promo For Total0083','1175','1123','OFF','UO000014','1');
insert into manual_adjustment_data values ('MA000084','Promo For Total0084','875','1149','FIX_PRICE','UO000014','1');
insert into manual_adjustment_data values ('MA000085','Promo For Total0085','1040','989','OFF','UO000015','1');
insert into manual_adjustment_data values ('MA000086','Promo For Total0086','1032','1162','FIX_PRICE','UO000015','1');
insert into manual_adjustment_data values ('MA000087','Promo For Total0087','928','1009','OFF','UO000015','1');
insert into manual_adjustment_data values ('MA000088','Promo For Total0088','1096','875','FIX_PRICE','UO000015','1');
insert into manual_adjustment_data values ('MA000089','Promo For Total0089','870','902','OFF','UO000015','1');
insert into manual_adjustment_data values ('MA000090','Promo For Total0090','961','921','FIX_PRICE','UO000015','1');
insert into manual_adjustment_data values ('MA000091','Promo For Total0091','1038','1159','OFF','UO000016','1');
insert into manual_adjustment_data values ('MA000092','Promo For Total0092','978','893','FIX_PRICE','UO000016','1');
insert into manual_adjustment_data values ('MA000093','Promo For Total0093','883','967','OFF','UO000016','1');
insert into manual_adjustment_data values ('MA000094','Promo For Total0094','940','941','FIX_PRICE','UO000016','1');
insert into manual_adjustment_data values ('MA000095','Promo For Total0095','901','1159','OFF','UO000016','1');
insert into manual_adjustment_data values ('MA000096','Promo For Total0096','1076','1034','FIX_PRICE','UO000016','1');
insert into manual_adjustment_data values ('MA000097','Promo For Total0097','957','887','OFF','UO000017','1');
insert into manual_adjustment_data values ('MA000098','Promo For Total0098','1141','1133','FIX_PRICE','UO000017','1');
insert into manual_adjustment_data values ('MA000099','Promo For Total0099','967','929','OFF','UO000017','1');
insert into manual_adjustment_data values ('MA000100','Promo For Total0100','1070','1061','FIX_PRICE','UO000017','1');
insert into manual_adjustment_data values ('MA000101','Promo For Total0101','1110','1007','OFF','UO000017','1');
insert into manual_adjustment_data values ('MA000102','Promo For Total0102','1130','901','FIX_PRICE','UO000017','1');
insert into manual_adjustment_data values ('MA000103','Promo For Total0103','1001','1045','OFF','UO000018','1');
insert into manual_adjustment_data values ('MA000104','Promo For Total0104','965','1020','FIX_PRICE','UO000018','1');
insert into manual_adjustment_data values ('MA000105','Promo For Total0105','1154','883','OFF','UO000018','1');
insert into manual_adjustment_data values ('MA000106','Promo For Total0106','967','1194','FIX_PRICE','UO000018','1');
insert into manual_adjustment_data values ('MA000107','Promo For Total0107','1213','918','OFF','UO000018','1');
insert into manual_adjustment_data values ('MA000108','Promo For Total0108','868','1156','FIX_PRICE','UO000018','1');
insert into manual_adjustment_data values ('MA000109','Promo For Total0109','1066','1211','OFF','UO000019','1');
insert into manual_adjustment_data values ('MA000110','Promo For Total0110','1114','1008','FIX_PRICE','UO000019','1');
insert into manual_adjustment_data values ('MA000111','Promo For Total0111','987','1036','OFF','UO000019','1');
insert into manual_adjustment_data values ('MA000112','Promo For Total0112','1071','1093','FIX_PRICE','UO000019','1');
insert into manual_adjustment_data values ('MA000113','Promo For Total0113','1158','881','OFF','UO000019','1');
insert into manual_adjustment_data values ('MA000114','Promo For Total0114','965','903','FIX_PRICE','UO000019','1');
insert into manual_adjustment_data values ('MA000115','Promo For Total0115','903','951','OFF','UO000020','1');
insert into manual_adjustment_data values ('MA000116','Promo For Total0116','1081','1221','FIX_PRICE','UO000020','1');
insert into manual_adjustment_data values ('MA000117','Promo For Total0117','1067','1108','OFF','UO000020','1');
insert into manual_adjustment_data values ('MA000118','Promo For Total0118','883','941','FIX_PRICE','UO000020','1');
insert into manual_adjustment_data values ('MA000119','Promo For Total0119','1090','897','OFF','UO000020','1');
insert into manual_adjustment_data values ('MA000120','Promo For Total0120','976','1018','FIX_PRICE','UO000020','1');
insert into manual_adjustment_data values ('MA000121','Promo For Total0121','899','1202','OFF','UO000021','1');
insert into manual_adjustment_data values ('MA000122','Promo For Total0122','1110','1008','FIX_PRICE','UO000021','1');
insert into manual_adjustment_data values ('MA000123','Promo For Total0123','1084','1114','OFF','UO000021','1');
insert into manual_adjustment_data values ('MA000124','Promo For Total0124','976','1127','FIX_PRICE','UO000021','1');
insert into manual_adjustment_data values ('MA000125','Promo For Total0125','1140','1062','OFF','UO000021','1');
insert into manual_adjustment_data values ('MA000126','Promo For Total0126','1133','1059','FIX_PRICE','UO000021','1');
insert into manual_adjustment_data values ('MA000127','Promo For Total0127','1047','1026','OFF','UO000022','1');
insert into manual_adjustment_data values ('MA000128','Promo For Total0128','933','1131','FIX_PRICE','UO000022','1');
insert into manual_adjustment_data values ('MA000129','Promo For Total0129','1164','1057','OFF','UO000022','1');
insert into manual_adjustment_data values ('MA000130','Promo For Total0130','1175','953','FIX_PRICE','UO000022','1');
insert into manual_adjustment_data values ('MA000131','Promo For Total0131','1194','1050','OFF','UO000022','1');
insert into manual_adjustment_data values ('MA000132','Promo For Total0132','984','1159','FIX_PRICE','UO000022','1');
insert into manual_adjustment_data values ('MA000133','Promo For Total0133','895','893','OFF','UO000023','1');
insert into manual_adjustment_data values ('MA000134','Promo For Total0134','1103','927','FIX_PRICE','UO000023','1');
insert into manual_adjustment_data values ('MA000135','Promo For Total0135','979','1225','OFF','UO000023','1');
insert into manual_adjustment_data values ('MA000136','Promo For Total0136','1204','914','FIX_PRICE','UO000023','1');
insert into manual_adjustment_data values ('MA000137','Promo For Total0137','1200','873','OFF','UO000023','1');
insert into manual_adjustment_data values ('MA000138','Promo For Total0138','1177','1083','FIX_PRICE','UO000023','1');
insert into manual_adjustment_data values ('MA000139','Promo For Total0139','961','1111','OFF','UO000024','1');
insert into manual_adjustment_data values ('MA000140','Promo For Total0140','935','1119','FIX_PRICE','UO000024','1');
insert into manual_adjustment_data values ('MA000141','Promo For Total0141','1104','1058','OFF','UO000024','1');
insert into manual_adjustment_data values ('MA000142','Promo For Total0142','1225','1110','FIX_PRICE','UO000024','1');
insert into manual_adjustment_data values ('MA000143','Promo For Total0143','956','872','OFF','UO000024','1');
insert into manual_adjustment_data values ('MA000144','Promo For Total0144','992','1168','FIX_PRICE','UO000024','1');
insert into manual_adjustment_data values ('MA000145','Promo For Total0145','892','1174','OFF','UO000025','1');
insert into manual_adjustment_data values ('MA000146','Promo For Total0146','1015','1032','FIX_PRICE','UO000025','1');
insert into manual_adjustment_data values ('MA000147','Promo For Total0147','919','1141','OFF','UO000025','1');
insert into manual_adjustment_data values ('MA000148','Promo For Total0148','1113','1093','FIX_PRICE','UO000025','1');
insert into manual_adjustment_data values ('MA000149','Promo For Total0149','875','1034','OFF','UO000025','1');
insert into manual_adjustment_data values ('MA000150','Promo For Total0150','1170','1050','FIX_PRICE','UO000025','1');
insert into manual_adjustment_data values ('MA000151','Promo For Total0151','923','1059','OFF','UO000026','1');
insert into manual_adjustment_data values ('MA000152','Promo For Total0152','1207','1107','FIX_PRICE','UO000026','1');
insert into manual_adjustment_data values ('MA000153','Promo For Total0153','1012','1161','OFF','UO000026','1');
insert into manual_adjustment_data values ('MA000154','Promo For Total0154','938','1100','FIX_PRICE','UO000026','1');
insert into manual_adjustment_data values ('MA000155','Promo For Total0155','958','1115','OFF','UO000026','1');
insert into manual_adjustment_data values ('MA000156','Promo For Total0156','1158','1098','FIX_PRICE','UO000026','1');
insert into manual_adjustment_data values ('MA000157','Promo For Total0157','947','1003','OFF','UO000027','1');
insert into manual_adjustment_data values ('MA000158','Promo For Total0158','1218','951','FIX_PRICE','UO000027','1');
insert into manual_adjustment_data values ('MA000159','Promo For Total0159','1162','1119','OFF','UO000027','1');
insert into manual_adjustment_data values ('MA000160','Promo For Total0160','927','896','FIX_PRICE','UO000027','1');
insert into manual_adjustment_data values ('MA000161','Promo For Total0161','1030','870','OFF','UO000027','1');
insert into manual_adjustment_data values ('MA000162','Promo For Total0162','1194','912','FIX_PRICE','UO000027','1');
insert into manual_adjustment_data values ('MA000163','Promo For Total0163','1177','891','OFF','UO000028','1');
insert into manual_adjustment_data values ('MA000164','Promo For Total0164','1049','930','FIX_PRICE','UO000028','1');
insert into manual_adjustment_data values ('MA000165','Promo For Total0165','1125','1112','OFF','UO000028','1');
insert into manual_adjustment_data values ('MA000166','Promo For Total0166','880','1219','FIX_PRICE','UO000028','1');
insert into manual_adjustment_data values ('MA000167','Promo For Total0167','900','1169','OFF','UO000028','1');
insert into manual_adjustment_data values ('MA000168','Promo For Total0168','1021','958','FIX_PRICE','UO000028','1');
insert into manual_adjustment_data values ('MA000169','Promo For Total0169','912','1177','OFF','UO000029','1');
insert into manual_adjustment_data values ('MA000170','Promo For Total0170','1048','1070','FIX_PRICE','UO000029','1');
insert into manual_adjustment_data values ('MA000171','Promo For Total0171','1149','1077','OFF','UO000029','1');
insert into manual_adjustment_data values ('MA000172','Promo For Total0172','1042','1101','FIX_PRICE','UO000029','1');
insert into manual_adjustment_data values ('MA000173','Promo For Total0173','872','1079','OFF','UO000029','1');
insert into manual_adjustment_data values ('MA000174','Promo For Total0174','1218','1118','FIX_PRICE','UO000029','1');
insert into manual_adjustment_data values ('MA000175','Promo For Total0175','1145','901','OFF','UO000030','1');
insert into manual_adjustment_data values ('MA000176','Promo For Total0176','1084','1190','FIX_PRICE','UO000030','1');
insert into manual_adjustment_data values ('MA000177','Promo For Total0177','1210','1114','OFF','UO000030','1');
insert into manual_adjustment_data values ('MA000178','Promo For Total0178','1035','974','FIX_PRICE','UO000030','1');
insert into manual_adjustment_data values ('MA000179','Promo For Total0179','1121','1166','OFF','UO000030','1');
insert into manual_adjustment_data values ('MA000180','Promo For Total0180','1102','1018','FIX_PRICE','UO000030','1');
insert into manual_adjustment_data values ('MA000181','Promo For Total0181','1049','1060','OFF','UO000031','1');
insert into manual_adjustment_data values ('MA000182','Promo For Total0182','1079','879','FIX_PRICE','UO000031','1');
insert into manual_adjustment_data values ('MA000183','Promo For Total0183','871','1058','OFF','UO000031','1');
insert into manual_adjustment_data values ('MA000184','Promo For Total0184','961','999','FIX_PRICE','UO000031','1');
insert into manual_adjustment_data values ('MA000185','Promo For Total0185','863','1142','OFF','UO000031','1');
insert into manual_adjustment_data values ('MA000186','Promo For Total0186','888','1124','FIX_PRICE','UO000031','1');
insert into manual_adjustment_data values ('MA000187','Promo For Total0187','882','997','OFF','UO000032','1');
insert into manual_adjustment_data values ('MA000188','Promo For Total0188','1141','1212','FIX_PRICE','UO000032','1');
insert into manual_adjustment_data values ('MA000189','Promo For Total0189','1071','1027','OFF','UO000032','1');
insert into manual_adjustment_data values ('MA000190','Promo For Total0190','1102','1188','FIX_PRICE','UO000032','1');
insert into manual_adjustment_data values ('MA000191','Promo For Total0191','1116','1162','OFF','UO000032','1');
insert into manual_adjustment_data values ('MA000192','Promo For Total0192','1119','1102','FIX_PRICE','UO000032','1');
insert into manual_adjustment_data values ('MA000193','Promo For Total0193','1048','1156','OFF','UO000033','1');
insert into manual_adjustment_data values ('MA000194','Promo For Total0194','1077','1213','FIX_PRICE','UO000033','1');
insert into manual_adjustment_data values ('MA000195','Promo For Total0195','932','963','OFF','UO000033','1');
insert into manual_adjustment_data values ('MA000196','Promo For Total0196','1116','959','FIX_PRICE','UO000033','1');
insert into manual_adjustment_data values ('MA000197','Promo For Total0197','898','1029','OFF','UO000033','1');
insert into manual_adjustment_data values ('MA000198','Promo For Total0198','892','953','FIX_PRICE','UO000033','1');
insert into manual_adjustment_data values ('MA000199','Promo For Total0199','957','1036','OFF','UO000034','1');
insert into manual_adjustment_data values ('MA000200','Promo For Total0200','957','980','FIX_PRICE','UO000034','1');
insert into manual_adjustment_data values ('MA000201','Promo For Total0201','1201','1127','OFF','UO000034','1');
insert into manual_adjustment_data values ('MA000202','Promo For Total0202','1123','1221','FIX_PRICE','UO000034','1');
insert into manual_adjustment_data values ('MA000203','Promo For Total0203','963','1123','OFF','UO000034','1');
insert into manual_adjustment_data values ('MA000204','Promo For Total0204','1191','1064','FIX_PRICE','UO000034','1');
insert into manual_adjustment_data values ('MA000205','Promo For Total0205','1028','1075','OFF','UO000035','1');
insert into manual_adjustment_data values ('MA000206','Promo For Total0206','1017','939','FIX_PRICE','UO000035','1');
insert into manual_adjustment_data values ('MA000207','Promo For Total0207','1033','1151','OFF','UO000035','1');
insert into manual_adjustment_data values ('MA000208','Promo For Total0208','1137','1036','FIX_PRICE','UO000035','1');
insert into manual_adjustment_data values ('MA000209','Promo For Total0209','1088','904','OFF','UO000035','1');
insert into manual_adjustment_data values ('MA000210','Promo For Total0210','1159','897','FIX_PRICE','UO000035','1');
insert into manual_adjustment_data values ('MA000211','Promo For Total0211','995','890','OFF','UO000036','1');
insert into manual_adjustment_data values ('MA000212','Promo For Total0212','1029','920','FIX_PRICE','UO000036','1');
insert into manual_adjustment_data values ('MA000213','Promo For Total0213','1041','1165','OFF','UO000036','1');
insert into manual_adjustment_data values ('MA000214','Promo For Total0214','1128','889','FIX_PRICE','UO000036','1');
insert into manual_adjustment_data values ('MA000215','Promo For Total0215','1149','880','OFF','UO000036','1');
insert into manual_adjustment_data values ('MA000216','Promo For Total0216','902','1158','FIX_PRICE','UO000036','1');

	
insert into shipping_group_data values ('SG000001','Ship To Home','1900 AVE OF THE STARTS - ','Suite 555 - ','Century City - ','CA','760272','US','UO000001','1');
insert into shipping_group_data values ('SG000002','Ship To Home0002','1900 AVE OF THE STARTS - 0002','Suite 555 - 0002','Century City - 0002','VA','936741','US','UO000001','1');
insert into shipping_group_data values ('SG000003','Ship To Home0003','1900 AVE OF THE STARTS - 0003','Suite 555 - 0003','Century City - 0003','MA','794976','US','UO000001','1');
insert into shipping_group_data values ('SG000004','Ship To Home0004','1900 AVE OF THE STARTS - 0004','Suite 555 - 0004','Century City - 0004','PA','894343','US','UO000001','1');
insert into shipping_group_data values ('SG000005','Ship To Home0005','1900 AVE OF THE STARTS - 0005','Suite 555 - 0005','Century City - 0005','WA','749560','US','UO000001','1');
insert into shipping_group_data values ('SG000006','Ship To Home0006','1900 AVE OF THE STARTS - 0006','Suite 555 - 0006','Century City - 0006','LA','764284','US','UO000001','1');
insert into shipping_group_data values ('SG000007','Ship To Home0007','1900 AVE OF THE STARTS - 0007','Suite 555 - 0007','Century City - 0007','CA','786892','US','UO000002','1');
insert into shipping_group_data values ('SG000008','Ship To Home0008','1900 AVE OF THE STARTS - 0008','Suite 555 - 0008','Century City - 0008','VA','878845','US','UO000002','1');
insert into shipping_group_data values ('SG000009','Ship To Home0009','1900 AVE OF THE STARTS - 0009','Suite 555 - 0009','Century City - 0009','MA','758698','US','UO000002','1');
insert into shipping_group_data values ('SG000010','Ship To Home0010','1900 AVE OF THE STARTS - 0010','Suite 555 - 0010','Century City - 0010','PA','743982','US','UO000002','1');
insert into shipping_group_data values ('SG000011','Ship To Home0011','1900 AVE OF THE STARTS - 0011','Suite 555 - 0011','Century City - 0011','WA','835891','US','UO000002','1');
insert into shipping_group_data values ('SG000012','Ship To Home0012','1900 AVE OF THE STARTS - 0012','Suite 555 - 0012','Century City - 0012','LA','825555','US','UO000002','1');
insert into shipping_group_data values ('SG000013','Ship To Home0013','1900 AVE OF THE STARTS - 0013','Suite 555 - 0013','Century City - 0013','CA','802319','US','UO000003','1');
insert into shipping_group_data values ('SG000014','Ship To Home0014','1900 AVE OF THE STARTS - 0014','Suite 555 - 0014','Century City - 0014','VA','871111','US','UO000003','1');
insert into shipping_group_data values ('SG000015','Ship To Home0015','1900 AVE OF THE STARTS - 0015','Suite 555 - 0015','Century City - 0015','MA','706293','US','UO000003','1');
insert into shipping_group_data values ('SG000016','Ship To Home0016','1900 AVE OF THE STARTS - 0016','Suite 555 - 0016','Century City - 0016','PA','818897','US','UO000003','1');
insert into shipping_group_data values ('SG000017','Ship To Home0017','1900 AVE OF THE STARTS - 0017','Suite 555 - 0017','Century City - 0017','WA','856240','US','UO000003','1');
insert into shipping_group_data values ('SG000018','Ship To Home0018','1900 AVE OF THE STARTS - 0018','Suite 555 - 0018','Century City - 0018','LA','801596','US','UO000003','1');
insert into shipping_group_data values ('SG000019','Ship To Home0019','1900 AVE OF THE STARTS - 0019','Suite 555 - 0019','Century City - 0019','CA','783777','US','UO000004','1');
insert into shipping_group_data values ('SG000020','Ship To Home0020','1900 AVE OF THE STARTS - 0020','Suite 555 - 0020','Century City - 0020','VA','863783','US','UO000004','1');
insert into shipping_group_data values ('SG000021','Ship To Home0021','1900 AVE OF THE STARTS - 0021','Suite 555 - 0021','Century City - 0021','MA','784475','US','UO000004','1');
insert into shipping_group_data values ('SG000022','Ship To Home0022','1900 AVE OF THE STARTS - 0022','Suite 555 - 0022','Century City - 0022','PA','806934','US','UO000004','1');
insert into shipping_group_data values ('SG000023','Ship To Home0023','1900 AVE OF THE STARTS - 0023','Suite 555 - 0023','Century City - 0023','WA','774375','US','UO000004','1');
insert into shipping_group_data values ('SG000024','Ship To Home0024','1900 AVE OF THE STARTS - 0024','Suite 555 - 0024','Century City - 0024','LA','790015','US','UO000004','1');
insert into shipping_group_data values ('SG000025','Ship To Home0025','1900 AVE OF THE STARTS - 0025','Suite 555 - 0025','Century City - 0025','CA','894919','US','UO000005','1');
insert into shipping_group_data values ('SG000026','Ship To Home0026','1900 AVE OF THE STARTS - 0026','Suite 555 - 0026','Century City - 0026','VA','740448','US','UO000005','1');
insert into shipping_group_data values ('SG000027','Ship To Home0027','1900 AVE OF THE STARTS - 0027','Suite 555 - 0027','Century City - 0027','MA','760143','US','UO000005','1');
insert into shipping_group_data values ('SG000028','Ship To Home0028','1900 AVE OF THE STARTS - 0028','Suite 555 - 0028','Century City - 0028','PA','921499','US','UO000005','1');
insert into shipping_group_data values ('SG000029','Ship To Home0029','1900 AVE OF THE STARTS - 0029','Suite 555 - 0029','Century City - 0029','WA','737622','US','UO000005','1');
insert into shipping_group_data values ('SG000030','Ship To Home0030','1900 AVE OF THE STARTS - 0030','Suite 555 - 0030','Century City - 0030','LA','783997','US','UO000005','1');
insert into shipping_group_data values ('SG000031','Ship To Home0031','1900 AVE OF THE STARTS - 0031','Suite 555 - 0031','Century City - 0031','CA','729885','US','UO000006','1');
insert into shipping_group_data values ('SG000032','Ship To Home0032','1900 AVE OF THE STARTS - 0032','Suite 555 - 0032','Century City - 0032','VA','715348','US','UO000006','1');
insert into shipping_group_data values ('SG000033','Ship To Home0033','1900 AVE OF THE STARTS - 0033','Suite 555 - 0033','Century City - 0033','MA','689537','US','UO000006','1');
insert into shipping_group_data values ('SG000034','Ship To Home0034','1900 AVE OF THE STARTS - 0034','Suite 555 - 0034','Century City - 0034','PA','770079','US','UO000006','1');
insert into shipping_group_data values ('SG000035','Ship To Home0035','1900 AVE OF THE STARTS - 0035','Suite 555 - 0035','Century City - 0035','WA','856873','US','UO000006','1');
insert into shipping_group_data values ('SG000036','Ship To Home0036','1900 AVE OF THE STARTS - 0036','Suite 555 - 0036','Century City - 0036','LA','813007','US','UO000006','1');
insert into shipping_group_data values ('SG000037','Ship To Home0037','1900 AVE OF THE STARTS - 0037','Suite 555 - 0037','Century City - 0037','CA','883958','US','UO000007','1');
insert into shipping_group_data values ('SG000038','Ship To Home0038','1900 AVE OF THE STARTS - 0038','Suite 555 - 0038','Century City - 0038','VA','901481','US','UO000007','1');
insert into shipping_group_data values ('SG000039','Ship To Home0039','1900 AVE OF THE STARTS - 0039','Suite 555 - 0039','Century City - 0039','MA','943007','US','UO000007','1');
insert into shipping_group_data values ('SG000040','Ship To Home0040','1900 AVE OF THE STARTS - 0040','Suite 555 - 0040','Century City - 0040','PA','929998','US','UO000007','1');
insert into shipping_group_data values ('SG000041','Ship To Home0041','1900 AVE OF THE STARTS - 0041','Suite 555 - 0041','Century City - 0041','WA','718644','US','UO000007','1');
insert into shipping_group_data values ('SG000042','Ship To Home0042','1900 AVE OF THE STARTS - 0042','Suite 555 - 0042','Century City - 0042','LA','727150','US','UO000007','1');
insert into shipping_group_data values ('SG000043','Ship To Home0043','1900 AVE OF THE STARTS - 0043','Suite 555 - 0043','Century City - 0043','CA','937863','US','UO000008','1');
insert into shipping_group_data values ('SG000044','Ship To Home0044','1900 AVE OF THE STARTS - 0044','Suite 555 - 0044','Century City - 0044','VA','845124','US','UO000008','1');
insert into shipping_group_data values ('SG000045','Ship To Home0045','1900 AVE OF THE STARTS - 0045','Suite 555 - 0045','Century City - 0045','MA','699304','US','UO000008','1');
insert into shipping_group_data values ('SG000046','Ship To Home0046','1900 AVE OF THE STARTS - 0046','Suite 555 - 0046','Century City - 0046','PA','858953','US','UO000008','1');
insert into shipping_group_data values ('SG000047','Ship To Home0047','1900 AVE OF THE STARTS - 0047','Suite 555 - 0047','Century City - 0047','WA','864219','US','UO000008','1');
insert into shipping_group_data values ('SG000048','Ship To Home0048','1900 AVE OF THE STARTS - 0048','Suite 555 - 0048','Century City - 0048','LA','921252','US','UO000008','1');
insert into shipping_group_data values ('SG000049','Ship To Home0049','1900 AVE OF THE STARTS - 0049','Suite 555 - 0049','Century City - 0049','CA','861097','US','UO000009','1');
insert into shipping_group_data values ('SG000050','Ship To Home0050','1900 AVE OF THE STARTS - 0050','Suite 555 - 0050','Century City - 0050','VA','786679','US','UO000009','1');
insert into shipping_group_data values ('SG000051','Ship To Home0051','1900 AVE OF THE STARTS - 0051','Suite 555 - 0051','Century City - 0051','MA','776142','US','UO000009','1');
insert into shipping_group_data values ('SG000052','Ship To Home0052','1900 AVE OF THE STARTS - 0052','Suite 555 - 0052','Century City - 0052','PA','909575','US','UO000009','1');
insert into shipping_group_data values ('SG000053','Ship To Home0053','1900 AVE OF THE STARTS - 0053','Suite 555 - 0053','Century City - 0053','WA','864205','US','UO000009','1');
insert into shipping_group_data values ('SG000054','Ship To Home0054','1900 AVE OF THE STARTS - 0054','Suite 555 - 0054','Century City - 0054','LA','959892','US','UO000009','1');
insert into shipping_group_data values ('SG000055','Ship To Home0055','1900 AVE OF THE STARTS - 0055','Suite 555 - 0055','Century City - 0055','CA','720774','US','UO000010','1');
insert into shipping_group_data values ('SG000056','Ship To Home0056','1900 AVE OF THE STARTS - 0056','Suite 555 - 0056','Century City - 0056','VA','966559','US','UO000010','1');
insert into shipping_group_data values ('SG000057','Ship To Home0057','1900 AVE OF THE STARTS - 0057','Suite 555 - 0057','Century City - 0057','MA','797268','US','UO000010','1');
insert into shipping_group_data values ('SG000058','Ship To Home0058','1900 AVE OF THE STARTS - 0058','Suite 555 - 0058','Century City - 0058','PA','720062','US','UO000010','1');
insert into shipping_group_data values ('SG000059','Ship To Home0059','1900 AVE OF THE STARTS - 0059','Suite 555 - 0059','Century City - 0059','WA','892890','US','UO000010','1');
insert into shipping_group_data values ('SG000060','Ship To Home0060','1900 AVE OF THE STARTS - 0060','Suite 555 - 0060','Century City - 0060','LA','970275','US','UO000010','1');
insert into shipping_group_data values ('SG000061','Ship To Home0061','1900 AVE OF THE STARTS - 0061','Suite 555 - 0061','Century City - 0061','CA','796436','US','UO000011','1');
insert into shipping_group_data values ('SG000062','Ship To Home0062','1900 AVE OF THE STARTS - 0062','Suite 555 - 0062','Century City - 0062','VA','958522','US','UO000011','1');
insert into shipping_group_data values ('SG000063','Ship To Home0063','1900 AVE OF THE STARTS - 0063','Suite 555 - 0063','Century City - 0063','MA','909904','US','UO000011','1');
insert into shipping_group_data values ('SG000064','Ship To Home0064','1900 AVE OF THE STARTS - 0064','Suite 555 - 0064','Century City - 0064','PA','704900','US','UO000011','1');
insert into shipping_group_data values ('SG000065','Ship To Home0065','1900 AVE OF THE STARTS - 0065','Suite 555 - 0065','Century City - 0065','WA','916021','US','UO000011','1');
insert into shipping_group_data values ('SG000066','Ship To Home0066','1900 AVE OF THE STARTS - 0066','Suite 555 - 0066','Century City - 0066','LA','978966','US','UO000011','1');
insert into shipping_group_data values ('SG000067','Ship To Home0067','1900 AVE OF THE STARTS - 0067','Suite 555 - 0067','Century City - 0067','CA','862895','US','UO000012','1');
insert into shipping_group_data values ('SG000068','Ship To Home0068','1900 AVE OF THE STARTS - 0068','Suite 555 - 0068','Century City - 0068','VA','766709','US','UO000012','1');
insert into shipping_group_data values ('SG000069','Ship To Home0069','1900 AVE OF THE STARTS - 0069','Suite 555 - 0069','Century City - 0069','MA','860199','US','UO000012','1');
insert into shipping_group_data values ('SG000070','Ship To Home0070','1900 AVE OF THE STARTS - 0070','Suite 555 - 0070','Century City - 0070','PA','874370','US','UO000012','1');
insert into shipping_group_data values ('SG000071','Ship To Home0071','1900 AVE OF THE STARTS - 0071','Suite 555 - 0071','Century City - 0071','WA','815015','US','UO000012','1');
insert into shipping_group_data values ('SG000072','Ship To Home0072','1900 AVE OF THE STARTS - 0072','Suite 555 - 0072','Century City - 0072','LA','952750','US','UO000012','1');
insert into shipping_group_data values ('SG000073','Ship To Home0073','1900 AVE OF THE STARTS - 0073','Suite 555 - 0073','Century City - 0073','CA','730926','US','UO000013','1');
insert into shipping_group_data values ('SG000074','Ship To Home0074','1900 AVE OF THE STARTS - 0074','Suite 555 - 0074','Century City - 0074','VA','871970','US','UO000013','1');
insert into shipping_group_data values ('SG000075','Ship To Home0075','1900 AVE OF THE STARTS - 0075','Suite 555 - 0075','Century City - 0075','MA','892330','US','UO000013','1');
insert into shipping_group_data values ('SG000076','Ship To Home0076','1900 AVE OF THE STARTS - 0076','Suite 555 - 0076','Century City - 0076','PA','891523','US','UO000013','1');
insert into shipping_group_data values ('SG000077','Ship To Home0077','1900 AVE OF THE STARTS - 0077','Suite 555 - 0077','Century City - 0077','WA','926248','US','UO000013','1');
insert into shipping_group_data values ('SG000078','Ship To Home0078','1900 AVE OF THE STARTS - 0078','Suite 555 - 0078','Century City - 0078','LA','768808','US','UO000013','1');
insert into shipping_group_data values ('SG000079','Ship To Home0079','1900 AVE OF THE STARTS - 0079','Suite 555 - 0079','Century City - 0079','CA','755792','US','UO000014','1');
insert into shipping_group_data values ('SG000080','Ship To Home0080','1900 AVE OF THE STARTS - 0080','Suite 555 - 0080','Century City - 0080','VA','889121','US','UO000014','1');
insert into shipping_group_data values ('SG000081','Ship To Home0081','1900 AVE OF THE STARTS - 0081','Suite 555 - 0081','Century City - 0081','MA','850454','US','UO000014','1');
insert into shipping_group_data values ('SG000082','Ship To Home0082','1900 AVE OF THE STARTS - 0082','Suite 555 - 0082','Century City - 0082','PA','788349','US','UO000014','1');
insert into shipping_group_data values ('SG000083','Ship To Home0083','1900 AVE OF THE STARTS - 0083','Suite 555 - 0083','Century City - 0083','WA','934181','US','UO000014','1');
insert into shipping_group_data values ('SG000084','Ship To Home0084','1900 AVE OF THE STARTS - 0084','Suite 555 - 0084','Century City - 0084','LA','858356','US','UO000014','1');
insert into shipping_group_data values ('SG000085','Ship To Home0085','1900 AVE OF THE STARTS - 0085','Suite 555 - 0085','Century City - 0085','CA','702904','US','UO000015','1');
insert into shipping_group_data values ('SG000086','Ship To Home0086','1900 AVE OF THE STARTS - 0086','Suite 555 - 0086','Century City - 0086','VA','814744','US','UO000015','1');
insert into shipping_group_data values ('SG000087','Ship To Home0087','1900 AVE OF THE STARTS - 0087','Suite 555 - 0087','Century City - 0087','MA','712760','US','UO000015','1');
insert into shipping_group_data values ('SG000088','Ship To Home0088','1900 AVE OF THE STARTS - 0088','Suite 555 - 0088','Century City - 0088','PA','890248','US','UO000015','1');
insert into shipping_group_data values ('SG000089','Ship To Home0089','1900 AVE OF THE STARTS - 0089','Suite 555 - 0089','Century City - 0089','WA','948235','US','UO000015','1');
insert into shipping_group_data values ('SG000090','Ship To Home0090','1900 AVE OF THE STARTS - 0090','Suite 555 - 0090','Century City - 0090','LA','942627','US','UO000015','1');
insert into shipping_group_data values ('SG000091','Ship To Home0091','1900 AVE OF THE STARTS - 0091','Suite 555 - 0091','Century City - 0091','CA','942009','US','UO000016','1');
insert into shipping_group_data values ('SG000092','Ship To Home0092','1900 AVE OF THE STARTS - 0092','Suite 555 - 0092','Century City - 0092','VA','875405','US','UO000016','1');
insert into shipping_group_data values ('SG000093','Ship To Home0093','1900 AVE OF THE STARTS - 0093','Suite 555 - 0093','Century City - 0093','MA','715829','US','UO000016','1');
insert into shipping_group_data values ('SG000094','Ship To Home0094','1900 AVE OF THE STARTS - 0094','Suite 555 - 0094','Century City - 0094','PA','858927','US','UO000016','1');
insert into shipping_group_data values ('SG000095','Ship To Home0095','1900 AVE OF THE STARTS - 0095','Suite 555 - 0095','Century City - 0095','WA','860345','US','UO000016','1');
insert into shipping_group_data values ('SG000096','Ship To Home0096','1900 AVE OF THE STARTS - 0096','Suite 555 - 0096','Century City - 0096','LA','933191','US','UO000016','1');
insert into shipping_group_data values ('SG000097','Ship To Home0097','1900 AVE OF THE STARTS - 0097','Suite 555 - 0097','Century City - 0097','CA','807210','US','UO000017','1');
insert into shipping_group_data values ('SG000098','Ship To Home0098','1900 AVE OF THE STARTS - 0098','Suite 555 - 0098','Century City - 0098','VA','801060','US','UO000017','1');
insert into shipping_group_data values ('SG000099','Ship To Home0099','1900 AVE OF THE STARTS - 0099','Suite 555 - 0099','Century City - 0099','MA','790758','US','UO000017','1');
insert into shipping_group_data values ('SG000100','Ship To Home0100','1900 AVE OF THE STARTS - 0100','Suite 555 - 0100','Century City - 0100','PA','735572','US','UO000017','1');
insert into shipping_group_data values ('SG000101','Ship To Home0101','1900 AVE OF THE STARTS - 0101','Suite 555 - 0101','Century City - 0101','WA','976779','US','UO000017','1');
insert into shipping_group_data values ('SG000102','Ship To Home0102','1900 AVE OF THE STARTS - 0102','Suite 555 - 0102','Century City - 0102','LA','955037','US','UO000017','1');
insert into shipping_group_data values ('SG000103','Ship To Home0103','1900 AVE OF THE STARTS - 0103','Suite 555 - 0103','Century City - 0103','CA','930274','US','UO000018','1');
insert into shipping_group_data values ('SG000104','Ship To Home0104','1900 AVE OF THE STARTS - 0104','Suite 555 - 0104','Century City - 0104','VA','879584','US','UO000018','1');
insert into shipping_group_data values ('SG000105','Ship To Home0105','1900 AVE OF THE STARTS - 0105','Suite 555 - 0105','Century City - 0105','MA','853106','US','UO000018','1');
insert into shipping_group_data values ('SG000106','Ship To Home0106','1900 AVE OF THE STARTS - 0106','Suite 555 - 0106','Century City - 0106','PA','925486','US','UO000018','1');
insert into shipping_group_data values ('SG000107','Ship To Home0107','1900 AVE OF THE STARTS - 0107','Suite 555 - 0107','Century City - 0107','WA','966063','US','UO000018','1');
insert into shipping_group_data values ('SG000108','Ship To Home0108','1900 AVE OF THE STARTS - 0108','Suite 555 - 0108','Century City - 0108','LA','921554','US','UO000018','1');
insert into shipping_group_data values ('SG000109','Ship To Home0109','1900 AVE OF THE STARTS - 0109','Suite 555 - 0109','Century City - 0109','CA','776614','US','UO000019','1');
insert into shipping_group_data values ('SG000110','Ship To Home0110','1900 AVE OF THE STARTS - 0110','Suite 555 - 0110','Century City - 0110','VA','743910','US','UO000019','1');
insert into shipping_group_data values ('SG000111','Ship To Home0111','1900 AVE OF THE STARTS - 0111','Suite 555 - 0111','Century City - 0111','MA','940140','US','UO000019','1');
insert into shipping_group_data values ('SG000112','Ship To Home0112','1900 AVE OF THE STARTS - 0112','Suite 555 - 0112','Century City - 0112','PA','938531','US','UO000019','1');
insert into shipping_group_data values ('SG000113','Ship To Home0113','1900 AVE OF THE STARTS - 0113','Suite 555 - 0113','Century City - 0113','WA','871324','US','UO000019','1');
insert into shipping_group_data values ('SG000114','Ship To Home0114','1900 AVE OF THE STARTS - 0114','Suite 555 - 0114','Century City - 0114','LA','957782','US','UO000019','1');
insert into shipping_group_data values ('SG000115','Ship To Home0115','1900 AVE OF THE STARTS - 0115','Suite 555 - 0115','Century City - 0115','CA','933632','US','UO000020','1');
insert into shipping_group_data values ('SG000116','Ship To Home0116','1900 AVE OF THE STARTS - 0116','Suite 555 - 0116','Century City - 0116','VA','953832','US','UO000020','1');
insert into shipping_group_data values ('SG000117','Ship To Home0117','1900 AVE OF THE STARTS - 0117','Suite 555 - 0117','Century City - 0117','MA','906163','US','UO000020','1');
insert into shipping_group_data values ('SG000118','Ship To Home0118','1900 AVE OF THE STARTS - 0118','Suite 555 - 0118','Century City - 0118','PA','776216','US','UO000020','1');
insert into shipping_group_data values ('SG000119','Ship To Home0119','1900 AVE OF THE STARTS - 0119','Suite 555 - 0119','Century City - 0119','WA','750003','US','UO000020','1');
insert into shipping_group_data values ('SG000120','Ship To Home0120','1900 AVE OF THE STARTS - 0120','Suite 555 - 0120','Century City - 0120','LA','828193','US','UO000020','1');
insert into shipping_group_data values ('SG000121','Ship To Home0121','1900 AVE OF THE STARTS - 0121','Suite 555 - 0121','Century City - 0121','CA','820332','US','UO000021','1');
insert into shipping_group_data values ('SG000122','Ship To Home0122','1900 AVE OF THE STARTS - 0122','Suite 555 - 0122','Century City - 0122','VA','919845','US','UO000021','1');
insert into shipping_group_data values ('SG000123','Ship To Home0123','1900 AVE OF THE STARTS - 0123','Suite 555 - 0123','Century City - 0123','MA','847560','US','UO000021','1');
insert into shipping_group_data values ('SG000124','Ship To Home0124','1900 AVE OF THE STARTS - 0124','Suite 555 - 0124','Century City - 0124','PA','815023','US','UO000021','1');
insert into shipping_group_data values ('SG000125','Ship To Home0125','1900 AVE OF THE STARTS - 0125','Suite 555 - 0125','Century City - 0125','WA','714238','US','UO000021','1');
insert into shipping_group_data values ('SG000126','Ship To Home0126','1900 AVE OF THE STARTS - 0126','Suite 555 - 0126','Century City - 0126','LA','860685','US','UO000021','1');
insert into shipping_group_data values ('SG000127','Ship To Home0127','1900 AVE OF THE STARTS - 0127','Suite 555 - 0127','Century City - 0127','CA','834854','US','UO000022','1');
insert into shipping_group_data values ('SG000128','Ship To Home0128','1900 AVE OF THE STARTS - 0128','Suite 555 - 0128','Century City - 0128','VA','786506','US','UO000022','1');
insert into shipping_group_data values ('SG000129','Ship To Home0129','1900 AVE OF THE STARTS - 0129','Suite 555 - 0129','Century City - 0129','MA','818515','US','UO000022','1');
insert into shipping_group_data values ('SG000130','Ship To Home0130','1900 AVE OF THE STARTS - 0130','Suite 555 - 0130','Century City - 0130','PA','875451','US','UO000022','1');
insert into shipping_group_data values ('SG000131','Ship To Home0131','1900 AVE OF THE STARTS - 0131','Suite 555 - 0131','Century City - 0131','WA','715902','US','UO000022','1');
insert into shipping_group_data values ('SG000132','Ship To Home0132','1900 AVE OF THE STARTS - 0132','Suite 555 - 0132','Century City - 0132','LA','919578','US','UO000022','1');
insert into shipping_group_data values ('SG000133','Ship To Home0133','1900 AVE OF THE STARTS - 0133','Suite 555 - 0133','Century City - 0133','CA','862245','US','UO000023','1');
insert into shipping_group_data values ('SG000134','Ship To Home0134','1900 AVE OF THE STARTS - 0134','Suite 555 - 0134','Century City - 0134','VA','738394','US','UO000023','1');
insert into shipping_group_data values ('SG000135','Ship To Home0135','1900 AVE OF THE STARTS - 0135','Suite 555 - 0135','Century City - 0135','MA','706713','US','UO000023','1');
insert into shipping_group_data values ('SG000136','Ship To Home0136','1900 AVE OF THE STARTS - 0136','Suite 555 - 0136','Century City - 0136','PA','745363','US','UO000023','1');
insert into shipping_group_data values ('SG000137','Ship To Home0137','1900 AVE OF THE STARTS - 0137','Suite 555 - 0137','Century City - 0137','WA','836274','US','UO000023','1');
insert into shipping_group_data values ('SG000138','Ship To Home0138','1900 AVE OF THE STARTS - 0138','Suite 555 - 0138','Century City - 0138','LA','689440','US','UO000023','1');
insert into shipping_group_data values ('SG000139','Ship To Home0139','1900 AVE OF THE STARTS - 0139','Suite 555 - 0139','Century City - 0139','CA','771188','US','UO000024','1');
insert into shipping_group_data values ('SG000140','Ship To Home0140','1900 AVE OF THE STARTS - 0140','Suite 555 - 0140','Century City - 0140','VA','728759','US','UO000024','1');
insert into shipping_group_data values ('SG000141','Ship To Home0141','1900 AVE OF THE STARTS - 0141','Suite 555 - 0141','Century City - 0141','MA','803390','US','UO000024','1');
insert into shipping_group_data values ('SG000142','Ship To Home0142','1900 AVE OF THE STARTS - 0142','Suite 555 - 0142','Century City - 0142','PA','959470','US','UO000024','1');
insert into shipping_group_data values ('SG000143','Ship To Home0143','1900 AVE OF THE STARTS - 0143','Suite 555 - 0143','Century City - 0143','WA','755481','US','UO000024','1');
insert into shipping_group_data values ('SG000144','Ship To Home0144','1900 AVE OF THE STARTS - 0144','Suite 555 - 0144','Century City - 0144','LA','965725','US','UO000024','1');
insert into shipping_group_data values ('SG000145','Ship To Home0145','1900 AVE OF THE STARTS - 0145','Suite 555 - 0145','Century City - 0145','CA','845644','US','UO000025','1');
insert into shipping_group_data values ('SG000146','Ship To Home0146','1900 AVE OF THE STARTS - 0146','Suite 555 - 0146','Century City - 0146','VA','958097','US','UO000025','1');
insert into shipping_group_data values ('SG000147','Ship To Home0147','1900 AVE OF THE STARTS - 0147','Suite 555 - 0147','Century City - 0147','MA','839537','US','UO000025','1');
insert into shipping_group_data values ('SG000148','Ship To Home0148','1900 AVE OF THE STARTS - 0148','Suite 555 - 0148','Century City - 0148','PA','741735','US','UO000025','1');
insert into shipping_group_data values ('SG000149','Ship To Home0149','1900 AVE OF THE STARTS - 0149','Suite 555 - 0149','Century City - 0149','WA','816833','US','UO000025','1');
insert into shipping_group_data values ('SG000150','Ship To Home0150','1900 AVE OF THE STARTS - 0150','Suite 555 - 0150','Century City - 0150','LA','882968','US','UO000025','1');
insert into shipping_group_data values ('SG000151','Ship To Home0151','1900 AVE OF THE STARTS - 0151','Suite 555 - 0151','Century City - 0151','CA','855060','US','UO000026','1');
insert into shipping_group_data values ('SG000152','Ship To Home0152','1900 AVE OF THE STARTS - 0152','Suite 555 - 0152','Century City - 0152','VA','889025','US','UO000026','1');
insert into shipping_group_data values ('SG000153','Ship To Home0153','1900 AVE OF THE STARTS - 0153','Suite 555 - 0153','Century City - 0153','MA','930135','US','UO000026','1');
insert into shipping_group_data values ('SG000154','Ship To Home0154','1900 AVE OF THE STARTS - 0154','Suite 555 - 0154','Century City - 0154','PA','818656','US','UO000026','1');
insert into shipping_group_data values ('SG000155','Ship To Home0155','1900 AVE OF THE STARTS - 0155','Suite 555 - 0155','Century City - 0155','WA','838914','US','UO000026','1');
insert into shipping_group_data values ('SG000156','Ship To Home0156','1900 AVE OF THE STARTS - 0156','Suite 555 - 0156','Century City - 0156','LA','759074','US','UO000026','1');
insert into shipping_group_data values ('SG000157','Ship To Home0157','1900 AVE OF THE STARTS - 0157','Suite 555 - 0157','Century City - 0157','CA','712061','US','UO000027','1');
insert into shipping_group_data values ('SG000158','Ship To Home0158','1900 AVE OF THE STARTS - 0158','Suite 555 - 0158','Century City - 0158','VA','938102','US','UO000027','1');
insert into shipping_group_data values ('SG000159','Ship To Home0159','1900 AVE OF THE STARTS - 0159','Suite 555 - 0159','Century City - 0159','MA','768778','US','UO000027','1');
insert into shipping_group_data values ('SG000160','Ship To Home0160','1900 AVE OF THE STARTS - 0160','Suite 555 - 0160','Century City - 0160','PA','825457','US','UO000027','1');
insert into shipping_group_data values ('SG000161','Ship To Home0161','1900 AVE OF THE STARTS - 0161','Suite 555 - 0161','Century City - 0161','WA','783959','US','UO000027','1');
insert into shipping_group_data values ('SG000162','Ship To Home0162','1900 AVE OF THE STARTS - 0162','Suite 555 - 0162','Century City - 0162','LA','915435','US','UO000027','1');
insert into shipping_group_data values ('SG000163','Ship To Home0163','1900 AVE OF THE STARTS - 0163','Suite 555 - 0163','Century City - 0163','CA','935245','US','UO000028','1');
insert into shipping_group_data values ('SG000164','Ship To Home0164','1900 AVE OF THE STARTS - 0164','Suite 555 - 0164','Century City - 0164','VA','766608','US','UO000028','1');
insert into shipping_group_data values ('SG000165','Ship To Home0165','1900 AVE OF THE STARTS - 0165','Suite 555 - 0165','Century City - 0165','MA','770461','US','UO000028','1');
insert into shipping_group_data values ('SG000166','Ship To Home0166','1900 AVE OF THE STARTS - 0166','Suite 555 - 0166','Century City - 0166','PA','922131','US','UO000028','1');
insert into shipping_group_data values ('SG000167','Ship To Home0167','1900 AVE OF THE STARTS - 0167','Suite 555 - 0167','Century City - 0167','WA','846101','US','UO000028','1');
insert into shipping_group_data values ('SG000168','Ship To Home0168','1900 AVE OF THE STARTS - 0168','Suite 555 - 0168','Century City - 0168','LA','735284','US','UO000028','1');
insert into shipping_group_data values ('SG000169','Ship To Home0169','1900 AVE OF THE STARTS - 0169','Suite 555 - 0169','Century City - 0169','CA','896576','US','UO000029','1');
insert into shipping_group_data values ('SG000170','Ship To Home0170','1900 AVE OF THE STARTS - 0170','Suite 555 - 0170','Century City - 0170','VA','908954','US','UO000029','1');
insert into shipping_group_data values ('SG000171','Ship To Home0171','1900 AVE OF THE STARTS - 0171','Suite 555 - 0171','Century City - 0171','MA','693687','US','UO000029','1');
insert into shipping_group_data values ('SG000172','Ship To Home0172','1900 AVE OF THE STARTS - 0172','Suite 555 - 0172','Century City - 0172','PA','717257','US','UO000029','1');
insert into shipping_group_data values ('SG000173','Ship To Home0173','1900 AVE OF THE STARTS - 0173','Suite 555 - 0173','Century City - 0173','WA','714680','US','UO000029','1');
insert into shipping_group_data values ('SG000174','Ship To Home0174','1900 AVE OF THE STARTS - 0174','Suite 555 - 0174','Century City - 0174','LA','738017','US','UO000029','1');
insert into shipping_group_data values ('SG000175','Ship To Home0175','1900 AVE OF THE STARTS - 0175','Suite 555 - 0175','Century City - 0175','CA','841034','US','UO000030','1');
insert into shipping_group_data values ('SG000176','Ship To Home0176','1900 AVE OF THE STARTS - 0176','Suite 555 - 0176','Century City - 0176','VA','870768','US','UO000030','1');
insert into shipping_group_data values ('SG000177','Ship To Home0177','1900 AVE OF THE STARTS - 0177','Suite 555 - 0177','Century City - 0177','MA','882389','US','UO000030','1');
insert into shipping_group_data values ('SG000178','Ship To Home0178','1900 AVE OF THE STARTS - 0178','Suite 555 - 0178','Century City - 0178','PA','834659','US','UO000030','1');
insert into shipping_group_data values ('SG000179','Ship To Home0179','1900 AVE OF THE STARTS - 0179','Suite 555 - 0179','Century City - 0179','WA','899226','US','UO000030','1');
insert into shipping_group_data values ('SG000180','Ship To Home0180','1900 AVE OF THE STARTS - 0180','Suite 555 - 0180','Century City - 0180','LA','707357','US','UO000030','1');
insert into shipping_group_data values ('SG000181','Ship To Home0181','1900 AVE OF THE STARTS - 0181','Suite 555 - 0181','Century City - 0181','CA','949643','US','UO000031','1');
insert into shipping_group_data values ('SG000182','Ship To Home0182','1900 AVE OF THE STARTS - 0182','Suite 555 - 0182','Century City - 0182','VA','786639','US','UO000031','1');
insert into shipping_group_data values ('SG000183','Ship To Home0183','1900 AVE OF THE STARTS - 0183','Suite 555 - 0183','Century City - 0183','MA','783660','US','UO000031','1');
insert into shipping_group_data values ('SG000184','Ship To Home0184','1900 AVE OF THE STARTS - 0184','Suite 555 - 0184','Century City - 0184','PA','740062','US','UO000031','1');
insert into shipping_group_data values ('SG000185','Ship To Home0185','1900 AVE OF THE STARTS - 0185','Suite 555 - 0185','Century City - 0185','WA','926831','US','UO000031','1');
insert into shipping_group_data values ('SG000186','Ship To Home0186','1900 AVE OF THE STARTS - 0186','Suite 555 - 0186','Century City - 0186','LA','843041','US','UO000031','1');
insert into shipping_group_data values ('SG000187','Ship To Home0187','1900 AVE OF THE STARTS - 0187','Suite 555 - 0187','Century City - 0187','CA','768319','US','UO000032','1');
insert into shipping_group_data values ('SG000188','Ship To Home0188','1900 AVE OF THE STARTS - 0188','Suite 555 - 0188','Century City - 0188','VA','912358','US','UO000032','1');
insert into shipping_group_data values ('SG000189','Ship To Home0189','1900 AVE OF THE STARTS - 0189','Suite 555 - 0189','Century City - 0189','MA','836729','US','UO000032','1');
insert into shipping_group_data values ('SG000190','Ship To Home0190','1900 AVE OF THE STARTS - 0190','Suite 555 - 0190','Century City - 0190','PA','919009','US','UO000032','1');
insert into shipping_group_data values ('SG000191','Ship To Home0191','1900 AVE OF THE STARTS - 0191','Suite 555 - 0191','Century City - 0191','WA','706135','US','UO000032','1');
insert into shipping_group_data values ('SG000192','Ship To Home0192','1900 AVE OF THE STARTS - 0192','Suite 555 - 0192','Century City - 0192','LA','719619','US','UO000032','1');
insert into shipping_group_data values ('SG000193','Ship To Home0193','1900 AVE OF THE STARTS - 0193','Suite 555 - 0193','Century City - 0193','CA','779592','US','UO000033','1');
insert into shipping_group_data values ('SG000194','Ship To Home0194','1900 AVE OF THE STARTS - 0194','Suite 555 - 0194','Century City - 0194','VA','836088','US','UO000033','1');
insert into shipping_group_data values ('SG000195','Ship To Home0195','1900 AVE OF THE STARTS - 0195','Suite 555 - 0195','Century City - 0195','MA','841329','US','UO000033','1');
insert into shipping_group_data values ('SG000196','Ship To Home0196','1900 AVE OF THE STARTS - 0196','Suite 555 - 0196','Century City - 0196','PA','867251','US','UO000033','1');
insert into shipping_group_data values ('SG000197','Ship To Home0197','1900 AVE OF THE STARTS - 0197','Suite 555 - 0197','Century City - 0197','WA','744180','US','UO000033','1');
insert into shipping_group_data values ('SG000198','Ship To Home0198','1900 AVE OF THE STARTS - 0198','Suite 555 - 0198','Century City - 0198','LA','896790','US','UO000033','1');
insert into shipping_group_data values ('SG000199','Ship To Home0199','1900 AVE OF THE STARTS - 0199','Suite 555 - 0199','Century City - 0199','CA','949396','US','UO000034','1');
insert into shipping_group_data values ('SG000200','Ship To Home0200','1900 AVE OF THE STARTS - 0200','Suite 555 - 0200','Century City - 0200','VA','865292','US','UO000034','1');
insert into shipping_group_data values ('SG000201','Ship To Home0201','1900 AVE OF THE STARTS - 0201','Suite 555 - 0201','Century City - 0201','MA','943116','US','UO000034','1');
insert into shipping_group_data values ('SG000202','Ship To Home0202','1900 AVE OF THE STARTS - 0202','Suite 555 - 0202','Century City - 0202','PA','853420','US','UO000034','1');
insert into shipping_group_data values ('SG000203','Ship To Home0203','1900 AVE OF THE STARTS - 0203','Suite 555 - 0203','Century City - 0203','WA','896176','US','UO000034','1');
insert into shipping_group_data values ('SG000204','Ship To Home0204','1900 AVE OF THE STARTS - 0204','Suite 555 - 0204','Century City - 0204','LA','837904','US','UO000034','1');
insert into shipping_group_data values ('SG000205','Ship To Home0205','1900 AVE OF THE STARTS - 0205','Suite 555 - 0205','Century City - 0205','CA','724092','US','UO000035','1');
insert into shipping_group_data values ('SG000206','Ship To Home0206','1900 AVE OF THE STARTS - 0206','Suite 555 - 0206','Century City - 0206','VA','825513','US','UO000035','1');
insert into shipping_group_data values ('SG000207','Ship To Home0207','1900 AVE OF THE STARTS - 0207','Suite 555 - 0207','Century City - 0207','MA','880996','US','UO000035','1');
insert into shipping_group_data values ('SG000208','Ship To Home0208','1900 AVE OF THE STARTS - 0208','Suite 555 - 0208','Century City - 0208','PA','807643','US','UO000035','1');
insert into shipping_group_data values ('SG000209','Ship To Home0209','1900 AVE OF THE STARTS - 0209','Suite 555 - 0209','Century City - 0209','WA','928135','US','UO000035','1');
insert into shipping_group_data values ('SG000210','Ship To Home0210','1900 AVE OF THE STARTS - 0210','Suite 555 - 0210','Century City - 0210','LA','929802','US','UO000035','1');
insert into shipping_group_data values ('SG000211','Ship To Home0211','1900 AVE OF THE STARTS - 0211','Suite 555 - 0211','Century City - 0211','CA','967755','US','UO000036','1');
insert into shipping_group_data values ('SG000212','Ship To Home0212','1900 AVE OF THE STARTS - 0212','Suite 555 - 0212','Century City - 0212','VA','899311','US','UO000036','1');
insert into shipping_group_data values ('SG000213','Ship To Home0213','1900 AVE OF THE STARTS - 0213','Suite 555 - 0213','Century City - 0213','MA','941917','US','UO000036','1');
insert into shipping_group_data values ('SG000214','Ship To Home0214','1900 AVE OF THE STARTS - 0214','Suite 555 - 0214','Century City - 0214','PA','833481','US','UO000036','1');
insert into shipping_group_data values ('SG000215','Ship To Home0215','1900 AVE OF THE STARTS - 0215','Suite 555 - 0215','Century City - 0215','WA','837580','US','UO000036','1');
insert into shipping_group_data values ('SG000216','Ship To Home0216','1900 AVE OF THE STARTS - 0216','Suite 555 - 0216','Century City - 0216','LA','721113','US','UO000036','1');

	
insert into payment_group_data values ('PG000001','Pay for order','105.61','UO000001','PAID','1');
insert into payment_group_data values ('PG000002','Pay for order0002','104.96','UO000001','PENDING','1');
insert into payment_group_data values ('PG000003','Pay for order0003','105.55','UO000001','FAIL','1');
insert into payment_group_data values ('PG000004','Pay for order0004','113.95','UO000001','PAID','1');
insert into payment_group_data values ('PG000005','Pay for order0005','122.01','UO000001','PENDING','1');
insert into payment_group_data values ('PG000006','Pay for order0006','120.48','UO000001','FAIL','1');
insert into payment_group_data values ('PG000007','Pay for order0007','107.81','UO000002','PAID','1');
insert into payment_group_data values ('PG000008','Pay for order0008','116.84','UO000002','PENDING','1');
insert into payment_group_data values ('PG000009','Pay for order0009','92.53','UO000002','FAIL','1');
insert into payment_group_data values ('PG000010','Pay for order0010','116.25','UO000002','PAID','1');
insert into payment_group_data values ('PG000011','Pay for order0011','120.13','UO000002','PENDING','1');
insert into payment_group_data values ('PG000012','Pay for order0012','119.70','UO000002','FAIL','1');
insert into payment_group_data values ('PG000013','Pay for order0013','110.59','UO000003','PAID','1');
insert into payment_group_data values ('PG000014','Pay for order0014','121.33','UO000003','PENDING','1');
insert into payment_group_data values ('PG000015','Pay for order0015','110.55','UO000003','FAIL','1');
insert into payment_group_data values ('PG000016','Pay for order0016','110.82','UO000003','PAID','1');
insert into payment_group_data values ('PG000017','Pay for order0017','114.01','UO000003','PENDING','1');
insert into payment_group_data values ('PG000018','Pay for order0018','103.20','UO000003','FAIL','1');
insert into payment_group_data values ('PG000019','Pay for order0019','104.82','UO000004','PAID','1');
insert into payment_group_data values ('PG000020','Pay for order0020','115.60','UO000004','PENDING','1');
insert into payment_group_data values ('PG000021','Pay for order0021','96.57','UO000004','FAIL','1');
insert into payment_group_data values ('PG000022','Pay for order0022','111.64','UO000004','PAID','1');
insert into payment_group_data values ('PG000023','Pay for order0023','100.82','UO000004','PENDING','1');
insert into payment_group_data values ('PG000024','Pay for order0024','96.98','UO000004','FAIL','1');
insert into payment_group_data values ('PG000025','Pay for order0025','116.98','UO000005','PAID','1');
insert into payment_group_data values ('PG000026','Pay for order0026','105.67','UO000005','PENDING','1');
insert into payment_group_data values ('PG000027','Pay for order0027','93.11','UO000005','FAIL','1');
insert into payment_group_data values ('PG000028','Pay for order0028','119.21','UO000005','PAID','1');
insert into payment_group_data values ('PG000029','Pay for order0029','120.37','UO000005','PENDING','1');
insert into payment_group_data values ('PG000030','Pay for order0030','90.39','UO000005','FAIL','1');
insert into payment_group_data values ('PG000031','Pay for order0031','105.40','UO000006','PAID','1');
insert into payment_group_data values ('PG000032','Pay for order0032','103.73','UO000006','PENDING','1');
insert into payment_group_data values ('PG000033','Pay for order0033','99.52','UO000006','FAIL','1');
insert into payment_group_data values ('PG000034','Pay for order0034','86.86','UO000006','PAID','1');
insert into payment_group_data values ('PG000035','Pay for order0035','100.66','UO000006','PENDING','1');
insert into payment_group_data values ('PG000036','Pay for order0036','86.77','UO000006','FAIL','1');
insert into payment_group_data values ('PG000037','Pay for order0037','103.28','UO000007','PAID','1');
insert into payment_group_data values ('PG000038','Pay for order0038','96.87','UO000007','PENDING','1');
insert into payment_group_data values ('PG000039','Pay for order0039','89.31','UO000007','FAIL','1');
insert into payment_group_data values ('PG000040','Pay for order0040','99.86','UO000007','PAID','1');
insert into payment_group_data values ('PG000041','Pay for order0041','108.83','UO000007','PENDING','1');
insert into payment_group_data values ('PG000042','Pay for order0042','96.76','UO000007','FAIL','1');
insert into payment_group_data values ('PG000043','Pay for order0043','98.10','UO000008','PAID','1');
insert into payment_group_data values ('PG000044','Pay for order0044','96.10','UO000008','PENDING','1');
insert into payment_group_data values ('PG000045','Pay for order0045','117.86','UO000008','FAIL','1');
insert into payment_group_data values ('PG000046','Pay for order0046','121.66','UO000008','PAID','1');
insert into payment_group_data values ('PG000047','Pay for order0047','110.81','UO000008','PENDING','1');
insert into payment_group_data values ('PG000048','Pay for order0048','122.65','UO000008','FAIL','1');
insert into payment_group_data values ('PG000049','Pay for order0049','89.29','UO000009','PAID','1');
insert into payment_group_data values ('PG000050','Pay for order0050','94.78','UO000009','PENDING','1');
insert into payment_group_data values ('PG000051','Pay for order0051','95.81','UO000009','FAIL','1');
insert into payment_group_data values ('PG000052','Pay for order0052','117.47','UO000009','PAID','1');
insert into payment_group_data values ('PG000053','Pay for order0053','104.68','UO000009','PENDING','1');
insert into payment_group_data values ('PG000054','Pay for order0054','96.18','UO000009','FAIL','1');
insert into payment_group_data values ('PG000055','Pay for order0055','91.48','UO000010','PAID','1');
insert into payment_group_data values ('PG000056','Pay for order0056','88.87','UO000010','PENDING','1');
insert into payment_group_data values ('PG000057','Pay for order0057','117.72','UO000010','FAIL','1');
insert into payment_group_data values ('PG000058','Pay for order0058','120.17','UO000010','PAID','1');
insert into payment_group_data values ('PG000059','Pay for order0059','100.76','UO000010','PENDING','1');
insert into payment_group_data values ('PG000060','Pay for order0060','113.47','UO000010','FAIL','1');
insert into payment_group_data values ('PG000061','Pay for order0061','121.56','UO000011','PAID','1');
insert into payment_group_data values ('PG000062','Pay for order0062','90.74','UO000011','PENDING','1');
insert into payment_group_data values ('PG000063','Pay for order0063','100.48','UO000011','FAIL','1');
insert into payment_group_data values ('PG000064','Pay for order0064','99.16','UO000011','PAID','1');
insert into payment_group_data values ('PG000065','Pay for order0065','114.68','UO000011','PENDING','1');
insert into payment_group_data values ('PG000066','Pay for order0066','86.80','UO000011','FAIL','1');
insert into payment_group_data values ('PG000067','Pay for order0067','102.04','UO000012','PAID','1');
insert into payment_group_data values ('PG000068','Pay for order0068','93.25','UO000012','PENDING','1');
insert into payment_group_data values ('PG000069','Pay for order0069','98.72','UO000012','FAIL','1');
insert into payment_group_data values ('PG000070','Pay for order0070','104.19','UO000012','PAID','1');
insert into payment_group_data values ('PG000071','Pay for order0071','87.40','UO000012','PENDING','1');
insert into payment_group_data values ('PG000072','Pay for order0072','118.28','UO000012','FAIL','1');
insert into payment_group_data values ('PG000073','Pay for order0073','104.19','UO000013','PAID','1');
insert into payment_group_data values ('PG000074','Pay for order0074','93.69','UO000013','PENDING','1');
insert into payment_group_data values ('PG000075','Pay for order0075','121.84','UO000013','FAIL','1');
insert into payment_group_data values ('PG000076','Pay for order0076','105.73','UO000013','PAID','1');
insert into payment_group_data values ('PG000077','Pay for order0077','93.89','UO000013','PENDING','1');
insert into payment_group_data values ('PG000078','Pay for order0078','110.32','UO000013','FAIL','1');
insert into payment_group_data values ('PG000079','Pay for order0079','92.19','UO000014','PAID','1');
insert into payment_group_data values ('PG000080','Pay for order0080','118.48','UO000014','PENDING','1');
insert into payment_group_data values ('PG000081','Pay for order0081','92.26','UO000014','FAIL','1');
insert into payment_group_data values ('PG000082','Pay for order0082','103.72','UO000014','PAID','1');
insert into payment_group_data values ('PG000083','Pay for order0083','101.09','UO000014','PENDING','1');
insert into payment_group_data values ('PG000084','Pay for order0084','110.74','UO000014','FAIL','1');
insert into payment_group_data values ('PG000085','Pay for order0085','113.04','UO000015','PAID','1');
insert into payment_group_data values ('PG000086','Pay for order0086','94.41','UO000015','PENDING','1');
insert into payment_group_data values ('PG000087','Pay for order0087','106.34','UO000015','FAIL','1');
insert into payment_group_data values ('PG000088','Pay for order0088','103.52','UO000015','PAID','1');
insert into payment_group_data values ('PG000089','Pay for order0089','101.36','UO000015','PENDING','1');
insert into payment_group_data values ('PG000090','Pay for order0090','121.61','UO000015','FAIL','1');
insert into payment_group_data values ('PG000091','Pay for order0091','117.83','UO000016','PAID','1');
insert into payment_group_data values ('PG000092','Pay for order0092','100.28','UO000016','PENDING','1');
insert into payment_group_data values ('PG000093','Pay for order0093','103.18','UO000016','FAIL','1');
insert into payment_group_data values ('PG000094','Pay for order0094','99.62','UO000016','PAID','1');
insert into payment_group_data values ('PG000095','Pay for order0095','115.66','UO000016','PENDING','1');
insert into payment_group_data values ('PG000096','Pay for order0096','122.75','UO000016','FAIL','1');
insert into payment_group_data values ('PG000097','Pay for order0097','114.07','UO000017','PAID','1');
insert into payment_group_data values ('PG000098','Pay for order0098','111.13','UO000017','PENDING','1');
insert into payment_group_data values ('PG000099','Pay for order0099','98.66','UO000017','FAIL','1');
insert into payment_group_data values ('PG000100','Pay for order0100','95.01','UO000017','PAID','1');
insert into payment_group_data values ('PG000101','Pay for order0101','87.22','UO000017','PENDING','1');
insert into payment_group_data values ('PG000102','Pay for order0102','108.64','UO000017','FAIL','1');
insert into payment_group_data values ('PG000103','Pay for order0103','107.62','UO000018','PAID','1');
insert into payment_group_data values ('PG000104','Pay for order0104','117.13','UO000018','PENDING','1');
insert into payment_group_data values ('PG000105','Pay for order0105','112.44','UO000018','FAIL','1');
insert into payment_group_data values ('PG000106','Pay for order0106','99.87','UO000018','PAID','1');
insert into payment_group_data values ('PG000107','Pay for order0107','93.19','UO000018','PENDING','1');
insert into payment_group_data values ('PG000108','Pay for order0108','111.58','UO000018','FAIL','1');
insert into payment_group_data values ('PG000109','Pay for order0109','106.09','UO000019','PAID','1');
insert into payment_group_data values ('PG000110','Pay for order0110','94.00','UO000019','PENDING','1');
insert into payment_group_data values ('PG000111','Pay for order0111','112.40','UO000019','FAIL','1');
insert into payment_group_data values ('PG000112','Pay for order0112','93.97','UO000019','PAID','1');
insert into payment_group_data values ('PG000113','Pay for order0113','95.38','UO000019','PENDING','1');
insert into payment_group_data values ('PG000114','Pay for order0114','99.14','UO000019','FAIL','1');
insert into payment_group_data values ('PG000115','Pay for order0115','105.84','UO000020','PAID','1');
insert into payment_group_data values ('PG000116','Pay for order0116','113.31','UO000020','PENDING','1');
insert into payment_group_data values ('PG000117','Pay for order0117','104.34','UO000020','FAIL','1');
insert into payment_group_data values ('PG000118','Pay for order0118','117.93','UO000020','PAID','1');
insert into payment_group_data values ('PG000119','Pay for order0119','116.07','UO000020','PENDING','1');
insert into payment_group_data values ('PG000120','Pay for order0120','121.88','UO000020','FAIL','1');
insert into payment_group_data values ('PG000121','Pay for order0121','94.63','UO000021','PAID','1');
insert into payment_group_data values ('PG000122','Pay for order0122','121.20','UO000021','PENDING','1');
insert into payment_group_data values ('PG000123','Pay for order0123','93.74','UO000021','FAIL','1');
insert into payment_group_data values ('PG000124','Pay for order0124','95.06','UO000021','PAID','1');
insert into payment_group_data values ('PG000125','Pay for order0125','107.04','UO000021','PENDING','1');
insert into payment_group_data values ('PG000126','Pay for order0126','95.44','UO000021','FAIL','1');
insert into payment_group_data values ('PG000127','Pay for order0127','117.78','UO000022','PAID','1');
insert into payment_group_data values ('PG000128','Pay for order0128','107.54','UO000022','PENDING','1');
insert into payment_group_data values ('PG000129','Pay for order0129','90.02','UO000022','FAIL','1');
insert into payment_group_data values ('PG000130','Pay for order0130','87.36','UO000022','PAID','1');
insert into payment_group_data values ('PG000131','Pay for order0131','102.89','UO000022','PENDING','1');
insert into payment_group_data values ('PG000132','Pay for order0132','112.08','UO000022','FAIL','1');
insert into payment_group_data values ('PG000133','Pay for order0133','104.58','UO000023','PAID','1');
insert into payment_group_data values ('PG000134','Pay for order0134','116.36','UO000023','PENDING','1');
insert into payment_group_data values ('PG000135','Pay for order0135','114.15','UO000023','FAIL','1');
insert into payment_group_data values ('PG000136','Pay for order0136','118.82','UO000023','PAID','1');
insert into payment_group_data values ('PG000137','Pay for order0137','121.49','UO000023','PENDING','1');
insert into payment_group_data values ('PG000138','Pay for order0138','112.25','UO000023','FAIL','1');
insert into payment_group_data values ('PG000139','Pay for order0139','99.54','UO000024','PAID','1');
insert into payment_group_data values ('PG000140','Pay for order0140','89.90','UO000024','PENDING','1');
insert into payment_group_data values ('PG000141','Pay for order0141','122.52','UO000024','FAIL','1');
insert into payment_group_data values ('PG000142','Pay for order0142','109.76','UO000024','PAID','1');
insert into payment_group_data values ('PG000143','Pay for order0143','116.75','UO000024','PENDING','1');
insert into payment_group_data values ('PG000144','Pay for order0144','90.54','UO000024','FAIL','1');
insert into payment_group_data values ('PG000145','Pay for order0145','110.83','UO000025','PAID','1');
insert into payment_group_data values ('PG000146','Pay for order0146','90.54','UO000025','PENDING','1');
insert into payment_group_data values ('PG000147','Pay for order0147','114.89','UO000025','FAIL','1');
insert into payment_group_data values ('PG000148','Pay for order0148','92.05','UO000025','PAID','1');
insert into payment_group_data values ('PG000149','Pay for order0149','95.73','UO000025','PENDING','1');
insert into payment_group_data values ('PG000150','Pay for order0150','97.02','UO000025','FAIL','1');
insert into payment_group_data values ('PG000151','Pay for order0151','114.86','UO000026','PAID','1');
insert into payment_group_data values ('PG000152','Pay for order0152','101.53','UO000026','PENDING','1');
insert into payment_group_data values ('PG000153','Pay for order0153','115.21','UO000026','FAIL','1');
insert into payment_group_data values ('PG000154','Pay for order0154','86.24','UO000026','PAID','1');
insert into payment_group_data values ('PG000155','Pay for order0155','94.00','UO000026','PENDING','1');
insert into payment_group_data values ('PG000156','Pay for order0156','89.67','UO000026','FAIL','1');
insert into payment_group_data values ('PG000157','Pay for order0157','116.53','UO000027','PAID','1');
insert into payment_group_data values ('PG000158','Pay for order0158','93.70','UO000027','PENDING','1');
insert into payment_group_data values ('PG000159','Pay for order0159','108.01','UO000027','FAIL','1');
insert into payment_group_data values ('PG000160','Pay for order0160','114.88','UO000027','PAID','1');
insert into payment_group_data values ('PG000161','Pay for order0161','101.06','UO000027','PENDING','1');
insert into payment_group_data values ('PG000162','Pay for order0162','100.23','UO000027','FAIL','1');
insert into payment_group_data values ('PG000163','Pay for order0163','122.22','UO000028','PAID','1');
insert into payment_group_data values ('PG000164','Pay for order0164','112.47','UO000028','PENDING','1');
insert into payment_group_data values ('PG000165','Pay for order0165','104.01','UO000028','FAIL','1');
insert into payment_group_data values ('PG000166','Pay for order0166','113.18','UO000028','PAID','1');
insert into payment_group_data values ('PG000167','Pay for order0167','101.93','UO000028','PENDING','1');
insert into payment_group_data values ('PG000168','Pay for order0168','93.14','UO000028','FAIL','1');
insert into payment_group_data values ('PG000169','Pay for order0169','89.42','UO000029','PAID','1');
insert into payment_group_data values ('PG000170','Pay for order0170','107.31','UO000029','PENDING','1');
insert into payment_group_data values ('PG000171','Pay for order0171','106.48','UO000029','FAIL','1');
insert into payment_group_data values ('PG000172','Pay for order0172','101.86','UO000029','PAID','1');
insert into payment_group_data values ('PG000173','Pay for order0173','109.90','UO000029','PENDING','1');
insert into payment_group_data values ('PG000174','Pay for order0174','88.65','UO000029','FAIL','1');
insert into payment_group_data values ('PG000175','Pay for order0175','100.14','UO000030','PAID','1');
insert into payment_group_data values ('PG000176','Pay for order0176','99.89','UO000030','PENDING','1');
insert into payment_group_data values ('PG000177','Pay for order0177','112.02','UO000030','FAIL','1');
insert into payment_group_data values ('PG000178','Pay for order0178','100.88','UO000030','PAID','1');
insert into payment_group_data values ('PG000179','Pay for order0179','119.79','UO000030','PENDING','1');
insert into payment_group_data values ('PG000180','Pay for order0180','106.10','UO000030','FAIL','1');
insert into payment_group_data values ('PG000181','Pay for order0181','105.29','UO000031','PAID','1');
insert into payment_group_data values ('PG000182','Pay for order0182','111.02','UO000031','PENDING','1');
insert into payment_group_data values ('PG000183','Pay for order0183','114.06','UO000031','FAIL','1');
insert into payment_group_data values ('PG000184','Pay for order0184','100.31','UO000031','PAID','1');
insert into payment_group_data values ('PG000185','Pay for order0185','109.46','UO000031','PENDING','1');
insert into payment_group_data values ('PG000186','Pay for order0186','95.46','UO000031','FAIL','1');
insert into payment_group_data values ('PG000187','Pay for order0187','98.89','UO000032','PAID','1');
insert into payment_group_data values ('PG000188','Pay for order0188','119.57','UO000032','PENDING','1');
insert into payment_group_data values ('PG000189','Pay for order0189','113.11','UO000032','FAIL','1');
insert into payment_group_data values ('PG000190','Pay for order0190','116.74','UO000032','PAID','1');
insert into payment_group_data values ('PG000191','Pay for order0191','94.73','UO000032','PENDING','1');
insert into payment_group_data values ('PG000192','Pay for order0192','86.78','UO000032','FAIL','1');
insert into payment_group_data values ('PG000193','Pay for order0193','115.05','UO000033','PAID','1');
insert into payment_group_data values ('PG000194','Pay for order0194','101.93','UO000033','PENDING','1');
insert into payment_group_data values ('PG000195','Pay for order0195','121.76','UO000033','FAIL','1');
insert into payment_group_data values ('PG000196','Pay for order0196','113.85','UO000033','PAID','1');
insert into payment_group_data values ('PG000197','Pay for order0197','102.47','UO000033','PENDING','1');
insert into payment_group_data values ('PG000198','Pay for order0198','105.79','UO000033','FAIL','1');
insert into payment_group_data values ('PG000199','Pay for order0199','122.51','UO000034','PAID','1');
insert into payment_group_data values ('PG000200','Pay for order0200','113.11','UO000034','PENDING','1');
insert into payment_group_data values ('PG000201','Pay for order0201','99.03','UO000034','FAIL','1');
insert into payment_group_data values ('PG000202','Pay for order0202','118.05','UO000034','PAID','1');
insert into payment_group_data values ('PG000203','Pay for order0203','120.97','UO000034','PENDING','1');
insert into payment_group_data values ('PG000204','Pay for order0204','97.82','UO000034','FAIL','1');
insert into payment_group_data values ('PG000205','Pay for order0205','122.36','UO000035','PAID','1');
insert into payment_group_data values ('PG000206','Pay for order0206','115.95','UO000035','PENDING','1');
insert into payment_group_data values ('PG000207','Pay for order0207','112.21','UO000035','FAIL','1');
insert into payment_group_data values ('PG000208','Pay for order0208','106.95','UO000035','PAID','1');
insert into payment_group_data values ('PG000209','Pay for order0209','93.55','UO000035','PENDING','1');
insert into payment_group_data values ('PG000210','Pay for order0210','93.66','UO000035','FAIL','1');
insert into payment_group_data values ('PG000211','Pay for order0211','93.63','UO000036','PAID','1');
insert into payment_group_data values ('PG000212','Pay for order0212','108.69','UO000036','PENDING','1');
insert into payment_group_data values ('PG000213','Pay for order0213','109.38','UO000036','FAIL','1');
insert into payment_group_data values ('PG000214','Pay for order0214','92.72','UO000036','PAID','1');
insert into payment_group_data values ('PG000215','Pay for order0215','89.67','UO000036','PENDING','1');
insert into payment_group_data values ('PG000216','Pay for order0216','95.54','UO000036','FAIL','1');

	
insert into user_domain_data values ('UD000001','用户区域','1');

	
insert into user_white_list_data values ('UWL000001','clariones','tester;ios-spokesperson','UD000001','1');
insert into user_white_list_data values ('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');
insert into user_white_list_data values ('UWL000003','clariones','tester;ios-spokesperson0003','UD000001','1');
insert into user_white_list_data values ('UWL000004','13808188512','tester;ios-spokesperson0004','UD000001','1');
insert into user_white_list_data values ('UWL000005','clariones','tester;ios-spokesperson0005','UD000001','1');
insert into user_white_list_data values ('UWL000006','13808188512','tester;ios-spokesperson0006','UD000001','1');

	
insert into sec_user_data values ('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','0','2019-01-18 21:49:03','2019-01-10 16:40:00','UD000001',NULL,'BLOCKED','1');
insert into sec_user_data values ('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','9999999','2019-01-27 05:41:09','2019-01-20 02:41:16','UD000001',NULL,'BLOCKED0002','1');
insert into sec_user_data values ('SU000003','login0003','13900000003','','1A39AE05E011CF4B6ADE19307698831F4303CEB3FF5A9E21EEC0B21FB19B1050','0','2019-01-28 04:21:20','2019-01-10 00:25:33','UD000001',NULL,'BLOCKED0003','1');
insert into sec_user_data values ('SU000004','login0004','13900000004','suddy_chang@163.com','331D0B81C261072AB3E01D2D09A3D1F9B03F1E5F095D6BF7284F32BF85135D59','9999999','2019-01-23 19:14:06','2019-01-16 22:15:12','UD000001',NULL,'BLOCKED0004','1');
insert into sec_user_data values ('SU000005','login0005','13900000005','','CBDC109937F570CA1D5F223EC59F5368AF9380F9DBF7E553124132BB402ED457','0','2019-01-19 10:08:58','2019-01-24 12:26:08','UD000001',NULL,'BLOCKED0005','1');
insert into sec_user_data values ('SU000006','login0006','13900000006','suddy_chang@163.com','69A610F10CE3333E0767CAEEB075A88B6B63E286F8BEBB9271C3EA6DF0CB2F7B','9999999','2019-01-27 06:36:56','2019-01-25 05:57:02','UD000001',NULL,'BLOCKED0006','1');

	
insert into sec_user_blocking_data values ('SUB000001','currentUser()','2019-01-22 08:08:25','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

	
insert into user_app_data values ('UA000001','审车平台','SU000001','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1');
insert into user_app_data values ('UA000002','账户管理','SU000001','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0002','1');
insert into user_app_data values ('UA000003','接车公司','SU000001','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1');
insert into user_app_data values ('UA000004','审车公司','SU000001','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1');
insert into user_app_data values ('UA000005','维修公司','SU000001','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1');
insert into user_app_data values ('UA000006','顾客','SU000001','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0006','1');
insert into user_app_data values ('UA000007','审车平台','SU000002','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0007','1');
insert into user_app_data values ('UA000008','账户管理','SU000002','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0008','1');
insert into user_app_data values ('UA000009','接车公司','SU000002','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0009','1');
insert into user_app_data values ('UA000010','审车公司','SU000002','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0010','1');
insert into user_app_data values ('UA000011','维修公司','SU000002','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0011','1');
insert into user_app_data values ('UA000012','顾客','SU000002','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0012','1');
insert into user_app_data values ('UA000013','审车平台','SU000003','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0013','1');
insert into user_app_data values ('UA000014','账户管理','SU000003','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0014','1');
insert into user_app_data values ('UA000015','接车公司','SU000003','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0015','1');
insert into user_app_data values ('UA000016','审车公司','SU000003','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0016','1');
insert into user_app_data values ('UA000017','维修公司','SU000003','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0017','1');
insert into user_app_data values ('UA000018','顾客','SU000003','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0018','1');
insert into user_app_data values ('UA000019','审车平台','SU000004','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0019','1');
insert into user_app_data values ('UA000020','账户管理','SU000004','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0020','1');
insert into user_app_data values ('UA000021','接车公司','SU000004','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0021','1');
insert into user_app_data values ('UA000022','审车公司','SU000004','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0022','1');
insert into user_app_data values ('UA000023','维修公司','SU000004','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0023','1');
insert into user_app_data values ('UA000024','顾客','SU000004','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0024','1');
insert into user_app_data values ('UA000025','审车平台','SU000005','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0025','1');
insert into user_app_data values ('UA000026','账户管理','SU000005','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0026','1');
insert into user_app_data values ('UA000027','接车公司','SU000005','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0027','1');
insert into user_app_data values ('UA000028','审车公司','SU000005','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0028','1');
insert into user_app_data values ('UA000029','维修公司','SU000005','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0029','1');
insert into user_app_data values ('UA000030','顾客','SU000005','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0030','1');
insert into user_app_data values ('UA000031','审车平台','SU000006','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app0031','1');
insert into user_app_data values ('UA000032','账户管理','SU000006','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0032','1');
insert into user_app_data values ('UA000033','接车公司','SU000006','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0033','1');
insert into user_app_data values ('UA000034','审车公司','SU000006','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0034','1');
insert into user_app_data values ('UA000035','维修公司','SU000006','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0035','1');
insert into user_app_data values ('UA000036','顾客','SU000006','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0036','1');

	
insert into list_access_data values ('LA000001','列表','levelOneCategoryList',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000002','列表0002','levelOneCategoryList0002',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000003','列表0003','levelOneCategoryList0003',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000004','列表0004','levelOneCategoryList0004',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000005','列表0005','levelOneCategoryList0005',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000006','列表0006','levelOneCategoryList0006',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000007','列表0007','levelOneCategoryList0007',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000008','列表0008','levelOneCategoryList0008',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000009','列表0009','levelOneCategoryList0009',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000010','列表0010','levelOneCategoryList0010',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000011','列表0011','levelOneCategoryList0011',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000012','列表0012','levelOneCategoryList0012',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000013','列表0013','levelOneCategoryList0013',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000014','列表0014','levelOneCategoryList0014',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000015','列表0015','levelOneCategoryList0015',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000016','列表0016','levelOneCategoryList0016',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000017','列表0017','levelOneCategoryList0017',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000018','列表0018','levelOneCategoryList0018',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000019','列表0019','levelOneCategoryList0019',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000020','列表0020','levelOneCategoryList0020',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000021','列表0021','levelOneCategoryList0021',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000022','列表0022','levelOneCategoryList0022',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000023','列表0023','levelOneCategoryList0023',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000024','列表0024','levelOneCategoryList0024',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000025','列表0025','levelOneCategoryList0025',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000026','列表0026','levelOneCategoryList0026',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000027','列表0027','levelOneCategoryList0027',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000028','列表0028','levelOneCategoryList0028',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000029','列表0029','levelOneCategoryList0029',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000030','列表0030','levelOneCategoryList0030',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000031','列表0031','levelOneCategoryList0031',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000032','列表0032','levelOneCategoryList0032',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000033','列表0033','levelOneCategoryList0033',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000034','列表0034','levelOneCategoryList0034',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000035','列表0035','levelOneCategoryList0035',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000036','列表0036','levelOneCategoryList0036',1,1,1,1,1,'UA000006','1');
insert into list_access_data values ('LA000037','列表0037','levelOneCategoryList0037',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000038','列表0038','levelOneCategoryList0038',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000039','列表0039','levelOneCategoryList0039',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000040','列表0040','levelOneCategoryList0040',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000041','列表0041','levelOneCategoryList0041',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000042','列表0042','levelOneCategoryList0042',1,1,1,1,1,'UA000007','1');
insert into list_access_data values ('LA000043','列表0043','levelOneCategoryList0043',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000044','列表0044','levelOneCategoryList0044',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000045','列表0045','levelOneCategoryList0045',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000046','列表0046','levelOneCategoryList0046',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000047','列表0047','levelOneCategoryList0047',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000048','列表0048','levelOneCategoryList0048',1,1,1,1,1,'UA000008','1');
insert into list_access_data values ('LA000049','列表0049','levelOneCategoryList0049',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000050','列表0050','levelOneCategoryList0050',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000051','列表0051','levelOneCategoryList0051',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000052','列表0052','levelOneCategoryList0052',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000053','列表0053','levelOneCategoryList0053',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000054','列表0054','levelOneCategoryList0054',1,1,1,1,1,'UA000009','1');
insert into list_access_data values ('LA000055','列表0055','levelOneCategoryList0055',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000056','列表0056','levelOneCategoryList0056',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000057','列表0057','levelOneCategoryList0057',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000058','列表0058','levelOneCategoryList0058',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000059','列表0059','levelOneCategoryList0059',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000060','列表0060','levelOneCategoryList0060',1,1,1,1,1,'UA000010','1');
insert into list_access_data values ('LA000061','列表0061','levelOneCategoryList0061',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000062','列表0062','levelOneCategoryList0062',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000063','列表0063','levelOneCategoryList0063',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000064','列表0064','levelOneCategoryList0064',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000065','列表0065','levelOneCategoryList0065',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000066','列表0066','levelOneCategoryList0066',1,1,1,1,1,'UA000011','1');
insert into list_access_data values ('LA000067','列表0067','levelOneCategoryList0067',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000068','列表0068','levelOneCategoryList0068',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000069','列表0069','levelOneCategoryList0069',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000070','列表0070','levelOneCategoryList0070',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000071','列表0071','levelOneCategoryList0071',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000072','列表0072','levelOneCategoryList0072',1,1,1,1,1,'UA000012','1');
insert into list_access_data values ('LA000073','列表0073','levelOneCategoryList0073',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000074','列表0074','levelOneCategoryList0074',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000075','列表0075','levelOneCategoryList0075',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000076','列表0076','levelOneCategoryList0076',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000077','列表0077','levelOneCategoryList0077',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000078','列表0078','levelOneCategoryList0078',1,1,1,1,1,'UA000013','1');
insert into list_access_data values ('LA000079','列表0079','levelOneCategoryList0079',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000080','列表0080','levelOneCategoryList0080',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000081','列表0081','levelOneCategoryList0081',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000082','列表0082','levelOneCategoryList0082',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000083','列表0083','levelOneCategoryList0083',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000084','列表0084','levelOneCategoryList0084',1,1,1,1,1,'UA000014','1');
insert into list_access_data values ('LA000085','列表0085','levelOneCategoryList0085',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000086','列表0086','levelOneCategoryList0086',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000087','列表0087','levelOneCategoryList0087',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000088','列表0088','levelOneCategoryList0088',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000089','列表0089','levelOneCategoryList0089',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000090','列表0090','levelOneCategoryList0090',1,1,1,1,1,'UA000015','1');
insert into list_access_data values ('LA000091','列表0091','levelOneCategoryList0091',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000092','列表0092','levelOneCategoryList0092',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000093','列表0093','levelOneCategoryList0093',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000094','列表0094','levelOneCategoryList0094',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000095','列表0095','levelOneCategoryList0095',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000096','列表0096','levelOneCategoryList0096',1,1,1,1,1,'UA000016','1');
insert into list_access_data values ('LA000097','列表0097','levelOneCategoryList0097',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000098','列表0098','levelOneCategoryList0098',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000099','列表0099','levelOneCategoryList0099',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000100','列表0100','levelOneCategoryList0100',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000101','列表0101','levelOneCategoryList0101',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000102','列表0102','levelOneCategoryList0102',1,1,1,1,1,'UA000017','1');
insert into list_access_data values ('LA000103','列表0103','levelOneCategoryList0103',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000104','列表0104','levelOneCategoryList0104',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000105','列表0105','levelOneCategoryList0105',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000106','列表0106','levelOneCategoryList0106',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000107','列表0107','levelOneCategoryList0107',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000108','列表0108','levelOneCategoryList0108',1,1,1,1,1,'UA000018','1');
insert into list_access_data values ('LA000109','列表0109','levelOneCategoryList0109',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000110','列表0110','levelOneCategoryList0110',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000111','列表0111','levelOneCategoryList0111',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000112','列表0112','levelOneCategoryList0112',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000113','列表0113','levelOneCategoryList0113',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000114','列表0114','levelOneCategoryList0114',1,1,1,1,1,'UA000019','1');
insert into list_access_data values ('LA000115','列表0115','levelOneCategoryList0115',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000116','列表0116','levelOneCategoryList0116',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000117','列表0117','levelOneCategoryList0117',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000118','列表0118','levelOneCategoryList0118',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000119','列表0119','levelOneCategoryList0119',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000120','列表0120','levelOneCategoryList0120',1,1,1,1,1,'UA000020','1');
insert into list_access_data values ('LA000121','列表0121','levelOneCategoryList0121',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000122','列表0122','levelOneCategoryList0122',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000123','列表0123','levelOneCategoryList0123',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000124','列表0124','levelOneCategoryList0124',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000125','列表0125','levelOneCategoryList0125',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000126','列表0126','levelOneCategoryList0126',1,1,1,1,1,'UA000021','1');
insert into list_access_data values ('LA000127','列表0127','levelOneCategoryList0127',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000128','列表0128','levelOneCategoryList0128',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000129','列表0129','levelOneCategoryList0129',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000130','列表0130','levelOneCategoryList0130',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000131','列表0131','levelOneCategoryList0131',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000132','列表0132','levelOneCategoryList0132',1,1,1,1,1,'UA000022','1');
insert into list_access_data values ('LA000133','列表0133','levelOneCategoryList0133',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000134','列表0134','levelOneCategoryList0134',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000135','列表0135','levelOneCategoryList0135',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000136','列表0136','levelOneCategoryList0136',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000137','列表0137','levelOneCategoryList0137',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000138','列表0138','levelOneCategoryList0138',1,1,1,1,1,'UA000023','1');
insert into list_access_data values ('LA000139','列表0139','levelOneCategoryList0139',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000140','列表0140','levelOneCategoryList0140',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000141','列表0141','levelOneCategoryList0141',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000142','列表0142','levelOneCategoryList0142',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000143','列表0143','levelOneCategoryList0143',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000144','列表0144','levelOneCategoryList0144',1,1,1,1,1,'UA000024','1');
insert into list_access_data values ('LA000145','列表0145','levelOneCategoryList0145',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000146','列表0146','levelOneCategoryList0146',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000147','列表0147','levelOneCategoryList0147',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000148','列表0148','levelOneCategoryList0148',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000149','列表0149','levelOneCategoryList0149',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000150','列表0150','levelOneCategoryList0150',1,1,1,1,1,'UA000025','1');
insert into list_access_data values ('LA000151','列表0151','levelOneCategoryList0151',1,1,1,1,1,'UA000026','1');
insert into list_access_data values ('LA000152','列表0152','levelOneCategoryList0152',1,1,1,1,1,'UA000026','1');
insert into list_access_data values ('LA000153','列表0153','levelOneCategoryList0153',1,1,1,1,1,'UA000026','1');
insert into list_access_data values ('LA000154','列表0154','levelOneCategoryList0154',1,1,1,1,1,'UA000026','1');
insert into list_access_data values ('LA000155','列表0155','levelOneCategoryList0155',1,1,1,1,1,'UA000026','1');
insert into list_access_data values ('LA000156','列表0156','levelOneCategoryList0156',1,1,1,1,1,'UA000026','1');
insert into list_access_data values ('LA000157','列表0157','levelOneCategoryList0157',1,1,1,1,1,'UA000027','1');
insert into list_access_data values ('LA000158','列表0158','levelOneCategoryList0158',1,1,1,1,1,'UA000027','1');
insert into list_access_data values ('LA000159','列表0159','levelOneCategoryList0159',1,1,1,1,1,'UA000027','1');
insert into list_access_data values ('LA000160','列表0160','levelOneCategoryList0160',1,1,1,1,1,'UA000027','1');
insert into list_access_data values ('LA000161','列表0161','levelOneCategoryList0161',1,1,1,1,1,'UA000027','1');
insert into list_access_data values ('LA000162','列表0162','levelOneCategoryList0162',1,1,1,1,1,'UA000027','1');
insert into list_access_data values ('LA000163','列表0163','levelOneCategoryList0163',1,1,1,1,1,'UA000028','1');
insert into list_access_data values ('LA000164','列表0164','levelOneCategoryList0164',1,1,1,1,1,'UA000028','1');
insert into list_access_data values ('LA000165','列表0165','levelOneCategoryList0165',1,1,1,1,1,'UA000028','1');
insert into list_access_data values ('LA000166','列表0166','levelOneCategoryList0166',1,1,1,1,1,'UA000028','1');
insert into list_access_data values ('LA000167','列表0167','levelOneCategoryList0167',1,1,1,1,1,'UA000028','1');
insert into list_access_data values ('LA000168','列表0168','levelOneCategoryList0168',1,1,1,1,1,'UA000028','1');
insert into list_access_data values ('LA000169','列表0169','levelOneCategoryList0169',1,1,1,1,1,'UA000029','1');
insert into list_access_data values ('LA000170','列表0170','levelOneCategoryList0170',1,1,1,1,1,'UA000029','1');
insert into list_access_data values ('LA000171','列表0171','levelOneCategoryList0171',1,1,1,1,1,'UA000029','1');
insert into list_access_data values ('LA000172','列表0172','levelOneCategoryList0172',1,1,1,1,1,'UA000029','1');
insert into list_access_data values ('LA000173','列表0173','levelOneCategoryList0173',1,1,1,1,1,'UA000029','1');
insert into list_access_data values ('LA000174','列表0174','levelOneCategoryList0174',1,1,1,1,1,'UA000029','1');
insert into list_access_data values ('LA000175','列表0175','levelOneCategoryList0175',1,1,1,1,1,'UA000030','1');
insert into list_access_data values ('LA000176','列表0176','levelOneCategoryList0176',1,1,1,1,1,'UA000030','1');
insert into list_access_data values ('LA000177','列表0177','levelOneCategoryList0177',1,1,1,1,1,'UA000030','1');
insert into list_access_data values ('LA000178','列表0178','levelOneCategoryList0178',1,1,1,1,1,'UA000030','1');
insert into list_access_data values ('LA000179','列表0179','levelOneCategoryList0179',1,1,1,1,1,'UA000030','1');
insert into list_access_data values ('LA000180','列表0180','levelOneCategoryList0180',1,1,1,1,1,'UA000030','1');
insert into list_access_data values ('LA000181','列表0181','levelOneCategoryList0181',1,1,1,1,1,'UA000031','1');
insert into list_access_data values ('LA000182','列表0182','levelOneCategoryList0182',1,1,1,1,1,'UA000031','1');
insert into list_access_data values ('LA000183','列表0183','levelOneCategoryList0183',1,1,1,1,1,'UA000031','1');
insert into list_access_data values ('LA000184','列表0184','levelOneCategoryList0184',1,1,1,1,1,'UA000031','1');
insert into list_access_data values ('LA000185','列表0185','levelOneCategoryList0185',1,1,1,1,1,'UA000031','1');
insert into list_access_data values ('LA000186','列表0186','levelOneCategoryList0186',1,1,1,1,1,'UA000031','1');
insert into list_access_data values ('LA000187','列表0187','levelOneCategoryList0187',1,1,1,1,1,'UA000032','1');
insert into list_access_data values ('LA000188','列表0188','levelOneCategoryList0188',1,1,1,1,1,'UA000032','1');
insert into list_access_data values ('LA000189','列表0189','levelOneCategoryList0189',1,1,1,1,1,'UA000032','1');
insert into list_access_data values ('LA000190','列表0190','levelOneCategoryList0190',1,1,1,1,1,'UA000032','1');
insert into list_access_data values ('LA000191','列表0191','levelOneCategoryList0191',1,1,1,1,1,'UA000032','1');
insert into list_access_data values ('LA000192','列表0192','levelOneCategoryList0192',1,1,1,1,1,'UA000032','1');
insert into list_access_data values ('LA000193','列表0193','levelOneCategoryList0193',1,1,1,1,1,'UA000033','1');
insert into list_access_data values ('LA000194','列表0194','levelOneCategoryList0194',1,1,1,1,1,'UA000033','1');
insert into list_access_data values ('LA000195','列表0195','levelOneCategoryList0195',1,1,1,1,1,'UA000033','1');
insert into list_access_data values ('LA000196','列表0196','levelOneCategoryList0196',1,1,1,1,1,'UA000033','1');
insert into list_access_data values ('LA000197','列表0197','levelOneCategoryList0197',1,1,1,1,1,'UA000033','1');
insert into list_access_data values ('LA000198','列表0198','levelOneCategoryList0198',1,1,1,1,1,'UA000033','1');
insert into list_access_data values ('LA000199','列表0199','levelOneCategoryList0199',1,1,1,1,1,'UA000034','1');
insert into list_access_data values ('LA000200','列表0200','levelOneCategoryList0200',1,1,1,1,1,'UA000034','1');
insert into list_access_data values ('LA000201','列表0201','levelOneCategoryList0201',1,1,1,1,1,'UA000034','1');
insert into list_access_data values ('LA000202','列表0202','levelOneCategoryList0202',1,1,1,1,1,'UA000034','1');
insert into list_access_data values ('LA000203','列表0203','levelOneCategoryList0203',1,1,1,1,1,'UA000034','1');
insert into list_access_data values ('LA000204','列表0204','levelOneCategoryList0204',1,1,1,1,1,'UA000034','1');
insert into list_access_data values ('LA000205','列表0205','levelOneCategoryList0205',1,1,1,1,1,'UA000035','1');
insert into list_access_data values ('LA000206','列表0206','levelOneCategoryList0206',1,1,1,1,1,'UA000035','1');
insert into list_access_data values ('LA000207','列表0207','levelOneCategoryList0207',1,1,1,1,1,'UA000035','1');
insert into list_access_data values ('LA000208','列表0208','levelOneCategoryList0208',1,1,1,1,1,'UA000035','1');
insert into list_access_data values ('LA000209','列表0209','levelOneCategoryList0209',1,1,1,1,1,'UA000035','1');
insert into list_access_data values ('LA000210','列表0210','levelOneCategoryList0210',1,1,1,1,1,'UA000035','1');
insert into list_access_data values ('LA000211','列表0211','levelOneCategoryList0211',1,1,1,1,1,'UA000036','1');
insert into list_access_data values ('LA000212','列表0212','levelOneCategoryList0212',1,1,1,1,1,'UA000036','1');
insert into list_access_data values ('LA000213','列表0213','levelOneCategoryList0213',1,1,1,1,1,'UA000036','1');
insert into list_access_data values ('LA000214','列表0214','levelOneCategoryList0214',1,1,1,1,1,'UA000036','1');
insert into list_access_data values ('LA000215','列表0215','levelOneCategoryList0215',1,1,1,1,1,'UA000036','1');
insert into list_access_data values ('LA000216','列表0216','levelOneCategoryList0216',1,1,1,1,1,'UA000036','1');

	
insert into object_access_data values ('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1');
insert into object_access_data values ('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1');
insert into object_access_data values ('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1');
insert into object_access_data values ('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1');
insert into object_access_data values ('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1');
insert into object_access_data values ('OA000009','控制访问列表10009','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1');
insert into object_access_data values ('OA000010','控制访问列表10010','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1');
insert into object_access_data values ('OA000011','控制访问列表10011','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1');
insert into object_access_data values ('OA000012','控制访问列表10012','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000002','1');
insert into object_access_data values ('OA000013','控制访问列表10013','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1');
insert into object_access_data values ('OA000014','控制访问列表10014','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1');
insert into object_access_data values ('OA000015','控制访问列表10015','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1');
insert into object_access_data values ('OA000016','控制访问列表10016','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1');
insert into object_access_data values ('OA000017','控制访问列表10017','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000003','1');
insert into object_access_data values ('OA000018','控制访问列表10018','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1');
insert into object_access_data values ('OA000019','控制访问列表10019','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1');
insert into object_access_data values ('OA000020','控制访问列表10020','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000021','控制访问列表10021','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1');
insert into object_access_data values ('OA000022','控制访问列表10022','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000023','控制访问列表10023','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1');
insert into object_access_data values ('OA000024','控制访问列表10024','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000025','控制访问列表10025','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000026','控制访问列表10026','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000005','1');
insert into object_access_data values ('OA000027','控制访问列表10027','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000028','控制访问列表10028','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000005','1');
insert into object_access_data values ('OA000029','控制访问列表10029','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000030','控制访问列表10030','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000005','1');
insert into object_access_data values ('OA000031','控制访问列表10031','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000006','1');
insert into object_access_data values ('OA000032','控制访问列表10032','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');
insert into object_access_data values ('OA000033','控制访问列表10033','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000006','1');
insert into object_access_data values ('OA000034','控制访问列表10034','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');
insert into object_access_data values ('OA000035','控制访问列表10035','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000006','1');
insert into object_access_data values ('OA000036','控制访问列表10036','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');
insert into object_access_data values ('OA000037','控制访问列表10037','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1');
insert into object_access_data values ('OA000038','控制访问列表10038','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000007','1');
insert into object_access_data values ('OA000039','控制访问列表10039','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1');
insert into object_access_data values ('OA000040','控制访问列表10040','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000007','1');
insert into object_access_data values ('OA000041','控制访问列表10041','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000007','1');
insert into object_access_data values ('OA000042','控制访问列表10042','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000007','1');
insert into object_access_data values ('OA000043','控制访问列表10043','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000008','1');
insert into object_access_data values ('OA000044','控制访问列表10044','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1');
insert into object_access_data values ('OA000045','控制访问列表10045','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000008','1');
insert into object_access_data values ('OA000046','控制访问列表10046','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1');
insert into object_access_data values ('OA000047','控制访问列表10047','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000008','1');
insert into object_access_data values ('OA000048','控制访问列表10048','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000008','1');
insert into object_access_data values ('OA000049','控制访问列表10049','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1');
insert into object_access_data values ('OA000050','控制访问列表10050','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000009','1');
insert into object_access_data values ('OA000051','控制访问列表10051','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1');
insert into object_access_data values ('OA000052','控制访问列表10052','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000009','1');
insert into object_access_data values ('OA000053','控制访问列表10053','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000009','1');
insert into object_access_data values ('OA000054','控制访问列表10054','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000009','1');
insert into object_access_data values ('OA000055','控制访问列表10055','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000010','1');
insert into object_access_data values ('OA000056','控制访问列表10056','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000010','1');
insert into object_access_data values ('OA000057','控制访问列表10057','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000010','1');
insert into object_access_data values ('OA000058','控制访问列表10058','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000010','1');
insert into object_access_data values ('OA000059','控制访问列表10059','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000010','1');
insert into object_access_data values ('OA000060','控制访问列表10060','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000010','1');
insert into object_access_data values ('OA000061','控制访问列表10061','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000011','1');
insert into object_access_data values ('OA000062','控制访问列表10062','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000011','1');
insert into object_access_data values ('OA000063','控制访问列表10063','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000011','1');
insert into object_access_data values ('OA000064','控制访问列表10064','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000011','1');
insert into object_access_data values ('OA000065','控制访问列表10065','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000011','1');
insert into object_access_data values ('OA000066','控制访问列表10066','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000011','1');
insert into object_access_data values ('OA000067','控制访问列表10067','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000012','1');
insert into object_access_data values ('OA000068','控制访问列表10068','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000012','1');
insert into object_access_data values ('OA000069','控制访问列表10069','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000012','1');
insert into object_access_data values ('OA000070','控制访问列表10070','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000012','1');
insert into object_access_data values ('OA000071','控制访问列表10071','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000012','1');
insert into object_access_data values ('OA000072','控制访问列表10072','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000012','1');
insert into object_access_data values ('OA000073','控制访问列表10073','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000013','1');
insert into object_access_data values ('OA000074','控制访问列表10074','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000013','1');
insert into object_access_data values ('OA000075','控制访问列表10075','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000013','1');
insert into object_access_data values ('OA000076','控制访问列表10076','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000013','1');
insert into object_access_data values ('OA000077','控制访问列表10077','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000013','1');
insert into object_access_data values ('OA000078','控制访问列表10078','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000013','1');
insert into object_access_data values ('OA000079','控制访问列表10079','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000014','1');
insert into object_access_data values ('OA000080','控制访问列表10080','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000014','1');
insert into object_access_data values ('OA000081','控制访问列表10081','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000014','1');
insert into object_access_data values ('OA000082','控制访问列表10082','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000014','1');
insert into object_access_data values ('OA000083','控制访问列表10083','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000014','1');
insert into object_access_data values ('OA000084','控制访问列表10084','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000014','1');
insert into object_access_data values ('OA000085','控制访问列表10085','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000015','1');
insert into object_access_data values ('OA000086','控制访问列表10086','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000015','1');
insert into object_access_data values ('OA000087','控制访问列表10087','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000015','1');
insert into object_access_data values ('OA000088','控制访问列表10088','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000015','1');
insert into object_access_data values ('OA000089','控制访问列表10089','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000015','1');
insert into object_access_data values ('OA000090','控制访问列表10090','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000015','1');
insert into object_access_data values ('OA000091','控制访问列表10091','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000016','1');
insert into object_access_data values ('OA000092','控制访问列表10092','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000016','1');
insert into object_access_data values ('OA000093','控制访问列表10093','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000016','1');
insert into object_access_data values ('OA000094','控制访问列表10094','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000016','1');
insert into object_access_data values ('OA000095','控制访问列表10095','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000016','1');
insert into object_access_data values ('OA000096','控制访问列表10096','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000016','1');
insert into object_access_data values ('OA000097','控制访问列表10097','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000017','1');
insert into object_access_data values ('OA000098','控制访问列表10098','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000017','1');
insert into object_access_data values ('OA000099','控制访问列表10099','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000017','1');
insert into object_access_data values ('OA000100','控制访问列表10100','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000017','1');
insert into object_access_data values ('OA000101','控制访问列表10101','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000017','1');
insert into object_access_data values ('OA000102','控制访问列表10102','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000017','1');
insert into object_access_data values ('OA000103','控制访问列表10103','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000018','1');
insert into object_access_data values ('OA000104','控制访问列表10104','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000018','1');
insert into object_access_data values ('OA000105','控制访问列表10105','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000018','1');
insert into object_access_data values ('OA000106','控制访问列表10106','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000018','1');
insert into object_access_data values ('OA000107','控制访问列表10107','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000018','1');
insert into object_access_data values ('OA000108','控制访问列表10108','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000018','1');
insert into object_access_data values ('OA000109','控制访问列表10109','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000019','1');
insert into object_access_data values ('OA000110','控制访问列表10110','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000019','1');
insert into object_access_data values ('OA000111','控制访问列表10111','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000019','1');
insert into object_access_data values ('OA000112','控制访问列表10112','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000019','1');
insert into object_access_data values ('OA000113','控制访问列表10113','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000019','1');
insert into object_access_data values ('OA000114','控制访问列表10114','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000019','1');
insert into object_access_data values ('OA000115','控制访问列表10115','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000020','1');
insert into object_access_data values ('OA000116','控制访问列表10116','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000020','1');
insert into object_access_data values ('OA000117','控制访问列表10117','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000020','1');
insert into object_access_data values ('OA000118','控制访问列表10118','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000020','1');
insert into object_access_data values ('OA000119','控制访问列表10119','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000020','1');
insert into object_access_data values ('OA000120','控制访问列表10120','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000020','1');
insert into object_access_data values ('OA000121','控制访问列表10121','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000021','1');
insert into object_access_data values ('OA000122','控制访问列表10122','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000021','1');
insert into object_access_data values ('OA000123','控制访问列表10123','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000021','1');
insert into object_access_data values ('OA000124','控制访问列表10124','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000021','1');
insert into object_access_data values ('OA000125','控制访问列表10125','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000021','1');
insert into object_access_data values ('OA000126','控制访问列表10126','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000021','1');
insert into object_access_data values ('OA000127','控制访问列表10127','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000022','1');
insert into object_access_data values ('OA000128','控制访问列表10128','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000022','1');
insert into object_access_data values ('OA000129','控制访问列表10129','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000022','1');
insert into object_access_data values ('OA000130','控制访问列表10130','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000022','1');
insert into object_access_data values ('OA000131','控制访问列表10131','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000022','1');
insert into object_access_data values ('OA000132','控制访问列表10132','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000022','1');
insert into object_access_data values ('OA000133','控制访问列表10133','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000023','1');
insert into object_access_data values ('OA000134','控制访问列表10134','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000023','1');
insert into object_access_data values ('OA000135','控制访问列表10135','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000023','1');
insert into object_access_data values ('OA000136','控制访问列表10136','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000023','1');
insert into object_access_data values ('OA000137','控制访问列表10137','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000023','1');
insert into object_access_data values ('OA000138','控制访问列表10138','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000023','1');
insert into object_access_data values ('OA000139','控制访问列表10139','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000024','1');
insert into object_access_data values ('OA000140','控制访问列表10140','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000024','1');
insert into object_access_data values ('OA000141','控制访问列表10141','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000024','1');
insert into object_access_data values ('OA000142','控制访问列表10142','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000024','1');
insert into object_access_data values ('OA000143','控制访问列表10143','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000024','1');
insert into object_access_data values ('OA000144','控制访问列表10144','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000024','1');
insert into object_access_data values ('OA000145','控制访问列表10145','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000025','1');
insert into object_access_data values ('OA000146','控制访问列表10146','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000025','1');
insert into object_access_data values ('OA000147','控制访问列表10147','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000025','1');
insert into object_access_data values ('OA000148','控制访问列表10148','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000025','1');
insert into object_access_data values ('OA000149','控制访问列表10149','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000025','1');
insert into object_access_data values ('OA000150','控制访问列表10150','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000025','1');
insert into object_access_data values ('OA000151','控制访问列表10151','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000026','1');
insert into object_access_data values ('OA000152','控制访问列表10152','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000026','1');
insert into object_access_data values ('OA000153','控制访问列表10153','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000026','1');
insert into object_access_data values ('OA000154','控制访问列表10154','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000026','1');
insert into object_access_data values ('OA000155','控制访问列表10155','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000026','1');
insert into object_access_data values ('OA000156','控制访问列表10156','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000026','1');
insert into object_access_data values ('OA000157','控制访问列表10157','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000027','1');
insert into object_access_data values ('OA000158','控制访问列表10158','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000027','1');
insert into object_access_data values ('OA000159','控制访问列表10159','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000027','1');
insert into object_access_data values ('OA000160','控制访问列表10160','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000027','1');
insert into object_access_data values ('OA000161','控制访问列表10161','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000027','1');
insert into object_access_data values ('OA000162','控制访问列表10162','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000027','1');
insert into object_access_data values ('OA000163','控制访问列表10163','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000028','1');
insert into object_access_data values ('OA000164','控制访问列表10164','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000028','1');
insert into object_access_data values ('OA000165','控制访问列表10165','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000028','1');
insert into object_access_data values ('OA000166','控制访问列表10166','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000028','1');
insert into object_access_data values ('OA000167','控制访问列表10167','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000028','1');
insert into object_access_data values ('OA000168','控制访问列表10168','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000028','1');
insert into object_access_data values ('OA000169','控制访问列表10169','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000029','1');
insert into object_access_data values ('OA000170','控制访问列表10170','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000029','1');
insert into object_access_data values ('OA000171','控制访问列表10171','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000029','1');
insert into object_access_data values ('OA000172','控制访问列表10172','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000029','1');
insert into object_access_data values ('OA000173','控制访问列表10173','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000029','1');
insert into object_access_data values ('OA000174','控制访问列表10174','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000029','1');
insert into object_access_data values ('OA000175','控制访问列表10175','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000030','1');
insert into object_access_data values ('OA000176','控制访问列表10176','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000030','1');
insert into object_access_data values ('OA000177','控制访问列表10177','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000030','1');
insert into object_access_data values ('OA000178','控制访问列表10178','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000030','1');
insert into object_access_data values ('OA000179','控制访问列表10179','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000030','1');
insert into object_access_data values ('OA000180','控制访问列表10180','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000030','1');
insert into object_access_data values ('OA000181','控制访问列表10181','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000031','1');
insert into object_access_data values ('OA000182','控制访问列表10182','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000031','1');
insert into object_access_data values ('OA000183','控制访问列表10183','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000031','1');
insert into object_access_data values ('OA000184','控制访问列表10184','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000031','1');
insert into object_access_data values ('OA000185','控制访问列表10185','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000031','1');
insert into object_access_data values ('OA000186','控制访问列表10186','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000031','1');
insert into object_access_data values ('OA000187','控制访问列表10187','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000032','1');
insert into object_access_data values ('OA000188','控制访问列表10188','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000032','1');
insert into object_access_data values ('OA000189','控制访问列表10189','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000032','1');
insert into object_access_data values ('OA000190','控制访问列表10190','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000032','1');
insert into object_access_data values ('OA000191','控制访问列表10191','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000032','1');
insert into object_access_data values ('OA000192','控制访问列表10192','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000032','1');
insert into object_access_data values ('OA000193','控制访问列表10193','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000033','1');
insert into object_access_data values ('OA000194','控制访问列表10194','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000033','1');
insert into object_access_data values ('OA000195','控制访问列表10195','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000033','1');
insert into object_access_data values ('OA000196','控制访问列表10196','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000033','1');
insert into object_access_data values ('OA000197','控制访问列表10197','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000033','1');
insert into object_access_data values ('OA000198','控制访问列表10198','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000033','1');
insert into object_access_data values ('OA000199','控制访问列表10199','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000034','1');
insert into object_access_data values ('OA000200','控制访问列表10200','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000034','1');
insert into object_access_data values ('OA000201','控制访问列表10201','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000034','1');
insert into object_access_data values ('OA000202','控制访问列表10202','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000034','1');
insert into object_access_data values ('OA000203','控制访问列表10203','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000034','1');
insert into object_access_data values ('OA000204','控制访问列表10204','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000034','1');
insert into object_access_data values ('OA000205','控制访问列表10205','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000035','1');
insert into object_access_data values ('OA000206','控制访问列表10206','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000035','1');
insert into object_access_data values ('OA000207','控制访问列表10207','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000035','1');
insert into object_access_data values ('OA000208','控制访问列表10208','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000035','1');
insert into object_access_data values ('OA000209','控制访问列表10209','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000035','1');
insert into object_access_data values ('OA000210','控制访问列表10210','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000035','1');
insert into object_access_data values ('OA000211','控制访问列表10211','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000036','1');
insert into object_access_data values ('OA000212','控制访问列表10212','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000036','1');
insert into object_access_data values ('OA000213','控制访问列表10213','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000036','1');
insert into object_access_data values ('OA000214','控制访问列表10214','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000036','1');
insert into object_access_data values ('OA000215','控制访问列表10215','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000036','1');
insert into object_access_data values ('OA000216','控制访问列表10216','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000036','1');

	
insert into login_history_data values ('LH000001','2019-01-10 07:08:01','192.168.1.1','登陆成功','SU000001','1');
insert into login_history_data values ('LH000002','2019-01-10 14:56:09','192.168.1.2','登陆成功0002','SU000001','1');
insert into login_history_data values ('LH000003','2019-01-22 17:21:25','192.168.1.1','登陆成功0003','SU000001','1');
insert into login_history_data values ('LH000004','2019-01-21 23:14:18','192.168.1.2','登陆成功0004','SU000001','1');
insert into login_history_data values ('LH000005','2019-01-10 01:57:55','192.168.1.1','登陆成功0005','SU000001','1');
insert into login_history_data values ('LH000006','2019-01-28 00:46:37','192.168.1.2','登陆成功0006','SU000001','1');
insert into login_history_data values ('LH000007','2019-01-09 10:31:05','192.168.1.1','登陆成功0007','SU000002','1');
insert into login_history_data values ('LH000008','2019-01-06 19:03:19','192.168.1.2','登陆成功0008','SU000002','1');
insert into login_history_data values ('LH000009','2019-01-25 02:19:53','192.168.1.1','登陆成功0009','SU000002','1');
insert into login_history_data values ('LH000010','2019-01-16 21:03:36','192.168.1.2','登陆成功0010','SU000002','1');
insert into login_history_data values ('LH000011','2019-01-28 04:42:31','192.168.1.1','登陆成功0011','SU000002','1');
insert into login_history_data values ('LH000012','2019-01-07 06:37:48','192.168.1.2','登陆成功0012','SU000002','1');
insert into login_history_data values ('LH000013','2019-01-13 02:01:20','192.168.1.1','登陆成功0013','SU000003','1');
insert into login_history_data values ('LH000014','2019-01-27 19:41:19','192.168.1.2','登陆成功0014','SU000003','1');
insert into login_history_data values ('LH000015','2019-01-14 23:07:53','192.168.1.1','登陆成功0015','SU000003','1');
insert into login_history_data values ('LH000016','2019-01-19 10:44:14','192.168.1.2','登陆成功0016','SU000003','1');
insert into login_history_data values ('LH000017','2019-01-11 21:25:19','192.168.1.1','登陆成功0017','SU000003','1');
insert into login_history_data values ('LH000018','2019-01-17 05:32:06','192.168.1.2','登陆成功0018','SU000003','1');
insert into login_history_data values ('LH000019','2019-01-26 16:15:21','192.168.1.1','登陆成功0019','SU000004','1');
insert into login_history_data values ('LH000020','2019-01-10 13:37:40','192.168.1.2','登陆成功0020','SU000004','1');
insert into login_history_data values ('LH000021','2019-01-17 20:21:34','192.168.1.1','登陆成功0021','SU000004','1');
insert into login_history_data values ('LH000022','2019-01-10 05:30:20','192.168.1.2','登陆成功0022','SU000004','1');
insert into login_history_data values ('LH000023','2019-01-21 19:05:58','192.168.1.1','登陆成功0023','SU000004','1');
insert into login_history_data values ('LH000024','2019-01-14 02:43:58','192.168.1.2','登陆成功0024','SU000004','1');
insert into login_history_data values ('LH000025','2019-01-11 21:17:31','192.168.1.1','登陆成功0025','SU000005','1');
insert into login_history_data values ('LH000026','2019-01-07 17:49:07','192.168.1.2','登陆成功0026','SU000005','1');
insert into login_history_data values ('LH000027','2019-01-25 12:58:42','192.168.1.1','登陆成功0027','SU000005','1');
insert into login_history_data values ('LH000028','2019-01-11 21:10:20','192.168.1.2','登陆成功0028','SU000005','1');
insert into login_history_data values ('LH000029','2019-01-15 05:32:51','192.168.1.1','登陆成功0029','SU000005','1');
insert into login_history_data values ('LH000030','2019-01-07 14:02:49','192.168.1.2','登陆成功0030','SU000005','1');
insert into login_history_data values ('LH000031','2019-01-20 20:54:33','192.168.1.1','登陆成功0031','SU000006','1');
insert into login_history_data values ('LH000032','2019-01-10 13:02:12','192.168.1.2','登陆成功0032','SU000006','1');
insert into login_history_data values ('LH000033','2019-01-22 04:36:46','192.168.1.1','登陆成功0033','SU000006','1');
insert into login_history_data values ('LH000034','2019-01-17 17:31:14','192.168.1.2','登陆成功0034','SU000006','1');
insert into login_history_data values ('LH000035','2019-01-27 14:42:53','192.168.1.1','登陆成功0035','SU000006','1');
insert into login_history_data values ('LH000036','2019-01-17 15:46:09','192.168.1.2','登陆成功0036','SU000006','1');

	
insert into generic_form_data values ('GF000001','登记输入单','姓名就是你身份证上的名字','1');

	
insert into form_message_data values ('FM000001','字段组合错误','GF000001','success','1');
insert into form_message_data values ('FM000002','字段组合错误0002','GF000001','info','1');
insert into form_message_data values ('FM000003','字段组合错误0003','GF000001','warning','1');
insert into form_message_data values ('FM000004','字段组合错误0004','GF000001','danger','1');
insert into form_message_data values ('FM000005','字段组合错误0005','GF000001','success','1');
insert into form_message_data values ('FM000006','字段组合错误0006','GF000001','info','1');

	
insert into form_field_message_data values ('FFM000001','输入错误','name','GF000001','success','1');
insert into form_field_message_data values ('FFM000002','输入错误0002','name0002','GF000001','info','1');
insert into form_field_message_data values ('FFM000003','输入错误0003','name0003','GF000001','warning','1');
insert into form_field_message_data values ('FFM000004','输入错误0004','name0004','GF000001','danger','1');
insert into form_field_message_data values ('FFM000005','输入错误0005','name0005','GF000001','success','1');
insert into form_field_message_data values ('FFM000006','输入错误0006','name0006','GF000001','info','1');

	
insert into form_field_data values ('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression',true,true,0,'','','1');
insert into form_field_data values ('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002',false,false,0,'','','1');
insert into form_field_data values ('FF000003','出生地','birth_place','name0003','date','GF000001','姓名就是你身份证上的名字0003','李一一0003','姓名就是你身份证上的名字0003','基础信息','maybe any value0003','a value expression0003',true,true,0,'','','1');
insert into form_field_data values ('FF000004','国籍','country','name0004','date_time','GF000001','姓名就是你身份证上的名字0004','李一一0004','姓名就是你身份证上的名字0004','扩展信息','maybe any value0004','a value expression0004',false,false,0,'男,女','男,女','1');
insert into form_field_data values ('FF000005','姓名','name','name0005','money','GF000001','姓名就是你身份证上的名字0005','李一一0005','姓名就是你身份证上的名字0005','基础信息','maybe any value0005','a value expression0005',true,true,0,'高,矮','高,矮','1');
insert into form_field_data values ('FF000006','年龄','age','name0006','url','GF000001','姓名就是你身份证上的名字0006','李一一0006','姓名就是你身份证上的名字0006','扩展信息','maybe any value0006','a value expression0006',false,false,0,'','','1');

	
insert into form_action_data values ('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1');
insert into form_action_data values ('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1');
insert into form_action_data values ('FA000003','功能0003','name0003','remove','danger','genericFormManager/name/name0002/name0003/0003','GF000001','1');
insert into form_action_data values ('FA000004','功能0004','name0004','save','primary','genericFormManager/name/name0002/name0003/0004','GF000001','1');
insert into form_action_data values ('FA000005','功能0005','name0005','update','default','genericFormManager/name/name0002/name0003/0005','GF000001','1');
insert into form_action_data values ('FA000006','功能0006','name0006','remove','warning','genericFormManager/name/name0002/name0003/0006','GF000001','1');

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

