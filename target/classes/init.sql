CREATE TABLE CUSTOMER (user_id int, user_name VARCHAR2(255) );
CREATE TABLE TRANSACTION (trans_id int,user_id int ,trans_date DATE,trans_amount int);
INSERT INTO CUSTOMER(user_id,user_name) values (1,'Eswar');
INSERT INTO CUSTOMER(user_id,user_name) values (2,'Body');
INSERT INTO CUSTOMER(user_id,user_name) values (3,'Suresh');
INSERT INTO TRANSACTION(trans_id,user_id,trans_date,trans_amount) VALUES (111,1,'2022-10-10',60);
INSERT INTO TRANSACTION(trans_id,user_id,trans_date,trans_amount) VALUES (222,1,'2022-10-11',140);

INSERT INTO TRANSACTION(trans_id,user_id,trans_date,trans_amount) VALUES (333,2,'2022-11-06',200);
INSERT INTO TRANSACTION(trans_id,user_id,trans_date,trans_amount) VALUES (444,2,'2022-11-08',120);

INSERT INTO TRANSACTION(trans_id,user_id,trans_date,trans_amount) VALUES (555,3,'2021-10-10',89);
INSERT INTO TRANSACTION(trans_id,user_id,trans_date,trans_amount) VALUES (666,3,'2021-10-09',120);
COMMIT;
