SELECT * FROM 	useraccounts;
INSERT INTO useraccounts (Firstname, Lastname, Username, Password) VALUES ('Neo','Anderson', 'matrix', 'kungfu');
 INSERT INTO useraccounts (Firstname, Lastname, Username, Password) VALUES ('Obiwan', 'Kenobi', 'master','jedi');
SELECT count(1) FROM useraccounts WHERE username = 'matrix' AND password = 'kungfu';
