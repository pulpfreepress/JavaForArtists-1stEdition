#  run this script to create the tables required to support the employee
#  training tracking system example described in chapter 21 of
#  Java For Artists.
create table employees
(
 	EMPLOYEE_ID	INT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FIRST_NAME	VARCHAR(50),
	MIDDLE_NAME	VARCHAR(50),
        LAST_NAME	VARCHAR(50),
	SSN		VARCHAR(11) ,
	DATE_OF_BIRTH	DATE,
        Unique(SSN)
);

create table employee_training 
(
	EMPLOYEE_TRAINING_ID		INT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
	EMPLOYEE_ID			INT	NOT NULL REFERENCES employees(EMPLOYEE_ID),
	DATE				DATE,
	TOPIC				VARCHAR(200),
	RESULT				VARCHAR(20)
);