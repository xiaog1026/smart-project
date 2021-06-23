
/* Drop Tables */

DROP TABLE IF EXISTS api_define;
DROP TABLE IF EXISTS code_value_master;
DROP TABLE IF EXISTS code_master;
DROP TABLE IF EXISTS column_master;
DROP TABLE IF EXISTS table_master;
DROP TABLE IF EXISTS word_dictionary;




/* Create Tables */

CREATE TABLE api_define
(
	api_id varchar(50) NOT NULL,
	url text UNIQUE,
	name varchar(50),
	note text,
	api_define jsonb,
	create_time timestamp,
	create_user varchar(30),
	update_time timestamp,
	update_user varchar(30),
	PRIMARY KEY (api_id)
) WITHOUT OIDS;


CREATE TABLE code_master
(
	code_id serial NOT NULL,
	word_id int NOT NULL,
	physical_code_name varchar(40),
	logic_code_name varchar(40),
	description text,
	create_time timestamp,
	create_user varchar(30),
	update_time timestamp,
	update_user varchar(30),
	PRIMARY KEY (code_id)
) WITHOUT OIDS;


CREATE TABLE code_value_master
(
	code_id int NOT NULL,
	code_no int,
	value_physical_name varchar(40),
	value_logic_name varchar(40),
	code_value varchar(40),
	description text,
	create_time timestamp,
	create_user varchar(30),
	update_time timestamp,
	update_user varchar(30),
	PRIMARY KEY (code_id)
) WITHOUT OIDS;


CREATE TABLE column_master
(
	column_id serial NOT NULL,
	table_id int NOT NULL,
	word_id int NOT NULL,
	seq_no int,
	description text,
	unique_key_name jsonb,
	column_constraint jsonb,
	foreign_key_flg boolean,
	not_null_flg boolean,
	primary_key_flg boolean,
	unique_key_flg boolean,
	create_time timestamp,
	create_user varchar(30),
	update_time timestamp,
	update_user varchar(30),
	PRIMARY KEY (column_id)
) WITHOUT OIDS;


CREATE TABLE table_master
(
	table_id serial NOT NULL,
	physical_name varchar(40),
	logic_name varchar(40),
	primary_key_name text,
	table_option text,
	indexes jsonb,
	complex_unique_key_list jsonb,
	create_time timestamp,
	create_user varchar(30),
	update_time timestamp,
	update_user varchar(30),
	PRIMARY KEY (table_id)
) WITHOUT OIDS;


CREATE TABLE word_dictionary
(
	word_id serial NOT NULL,
	word_length int,
	word_decimal int,
	array_flg boolean,
	array_dimension int,
	description text,
	logic_name varchar(40),
	physical_name varchar(40),
	word_type varchar(30),
	create_time timestamp,
	create_user varchar(30),
	update_time timestamp,
	update_user varchar(30),
	PRIMARY KEY (word_id)
) WITHOUT OIDS;



/* Create Foreign Keys */

ALTER TABLE code_value_master
	ADD FOREIGN KEY (code_id)
	REFERENCES code_master (code_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE column_master
	ADD FOREIGN KEY (table_id)
	REFERENCES table_master (table_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE code_master
	ADD FOREIGN KEY (word_id)
	REFERENCES word_dictionary (word_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE column_master
	ADD FOREIGN KEY (word_id)
	REFERENCES word_dictionary (word_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



