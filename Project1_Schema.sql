
-------- CREATES THE TABLES FOR TRMS PROJECT---------------------------

--STEPS TO CREATE YOUR DABATASE:
1. RUN PART 1 TO CREATE ALL TABLES and sequences 
2. RUN PART II TO SEED VALUES INTO REFERENCE TABLES 

--******************************* PART I ******************************

CREATE TABLE "MEDALISTRELLES"."BANKCUST" 
   (    "C_ID" NUMBER, 
    "FNAME" VARCHAR2(255 BYTE), 
    "LNAME" VARCHAR2(255 BYTE), 
    "BD" VARCHAR2(255 BYTE), 
    "SAVINGS" NUMBER, 
    "CHECKING" NUMBER, 
    "ACCT" NUMBER, 
    "USERNAME" VARCHAR2(255 BYTE), 
    "PWD" VARCHAR2(255 BYTE), 
     CONSTRAINT "PK_CUST" PRIMARY KEY ("C_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

CREATE TABLE "MEDALISTRELLES"."EMPLOYEE" 
   (    "EMPLOYEEID" NUMBER(*,0) NOT NULL ENABLE, 
    "DEPARTMENTHEAD" VARCHAR2(120 BYTE) NOT NULL ENABLE, 
    "DIRECTSUPERVISOR" VARCHAR2(120 BYTE), 
    "USERID" NUMBER(*,0) NOT NULL ENABLE, 
     CONSTRAINT "EMPLOYEE_PK" PRIMARY KEY ("EMPLOYEEID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
     CONSTRAINT "EMPLOYEE_FK1" FOREIGN KEY ("USERID")
      REFERENCES "MEDALISTRELLES"."USERS" ("USERID") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;


CREATE TABLE "MEDALISTRELLES"."TUITIONREIMBURSEMENTFORM" 
   (    "FORMID" NUMBER(*,0) NOT NULL ENABLE, 
    "EVENTDATE" DATE NOT NULL ENABLE, 
    "LOCATION" VARCHAR2(120 BYTE) NOT NULL ENABLE, 
    "DESCRIPTION" VARCHAR2(300 BYTE) NOT NULL ENABLE, 
    "COST" NUMBER NOT NULL ENABLE, 
    "GRADINGFORMAT" VARCHAR2(120 BYTE) NOT NULL ENABLE, 
    "EVENTYPE" VARCHAR2(120 BYTE) NOT NULL ENABLE, 
    "JUSTIFICATION" VARCHAR2(120 BYTE) NOT NULL ENABLE, 
    "FILEEXTENSION" VARCHAR2(120 BYTE) NOT NULL ENABLE, 
    "FILEBYTE" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
    "APPROVALATTACHMENT" VARCHAR2(20 BYTE), 
    "EMAILBYTE" VARCHAR2(20 BYTE), 
    "WORKTIMEMISSED" NUMBER NOT NULL ENABLE, 
    "USERID" NUMBER(*,0) NOT NULL ENABLE, 
     CONSTRAINT "TUITIONREIMBURSEMENTFORM_PK" PRIMARY KEY ("FORMID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
     CONSTRAINT "TUITIONREIMBURSEMENTFORM_FK1" FOREIGN KEY ("USERID")
      REFERENCES "MEDALISTRELLES"."USERS" ("USERID") ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

CREATE TABLE "MEDALISTRELLES"."USERS" 
   (    "USERID" NUMBER(*,0) NOT NULL ENABLE, 
    "USERNAME" VARCHAR2(120 BYTE) NOT NULL ENABLE, 
    "PASSWORD" VARCHAR2(120 BYTE) NOT NULL ENABLE, 
    "FIRSTNAME" VARCHAR2(120 BYTE) NOT NULL ENABLE, 
    "LASTNAME" VARCHAR2(120 BYTE) NOT NULL ENABLE, 
    "ROLE" VARCHAR2(120 BYTE) NOT NULL ENABLE, 
    "HIREDDATE" DATE NOT NULL ENABLE, 
    "AVAILABLEREIMBURSEMENT" NUMBER NOT NULL ENABLE, 
     CONSTRAINT "USERS_PK" PRIMARY KEY ("USERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
   
--PKs Sequences to auto-increment   
--1) EVENT_ID AUTO INCREMENT 
CREATE SEQUENCE PK_EVENTID START WITH 1 INCREMENT BY 1;
--2) EVENT_STATUS_ID INCREMENT 
CREATE SEQUENCE PK_EVENT_STATUS_ID START WITH 1 INCREMENT BY 1;
--3) EVENT_TYPEID INCREMENT
CREATE SEQUENCE PK_EVENT_TYPEID START WITH 1 INCREMENT BY 1;
--4) GRADEFORMAT_ID INCREMENT
CREATE SEQUENCE PK_GRADEFORMAT_ID START WITH 1 INCREMENT BY 1;
--5) ROLE_ID INCREMENT 
CREATE SEQUENCE PK_EVENTID START WITH 1 INCREMENT BY 1;
--6) USER_ID INCREMENT
CREATE SEQUENCE PK_USER_ID START WITH 1 INCREMENT BY 1;
--******************************* PART II ******************************  
INSERT INTO event_status  

INSERT INTO suppliers
(supplier_id, supplier_name)
VALUES
(5000, 'Apple');  
  
COMMIT;  

------------------  WORK LEFT TO BE DONE BY MEDALIS----------------------------  
--  3. Auto-increment Pks
--  4.Add values to Event_status lookup table

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  