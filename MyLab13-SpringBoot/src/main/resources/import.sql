INSERT INTO Car VALUES(NULL, 'Silver', 'Volvo', 'S80', 1999);
INSERT INTO Car VALUES(NULL, 'Red', 'Honda', 'Accord', 1997);

INSERT INTO Book VALUES(NULL, 'Book1', '123-456',100, 'John');
INSERT INTO Book VALUES(NULL, 'Book2', '456-456',200, 'Rafa');
INSERT INTO Book VALUES(NULL, 'Book3', '789-456',300, 'Federer');

INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_ADMIN', 1);
INSERT INTO `authority`(`name`, `id`) VALUES ('ROLE_USER', 2);


INSERT INTO `user` (`id`, `username`, `password`, `date_Created`) VALUES (1,'admin','$2a$10$ZNkwte139xDVivH6FEmhHeu54V8js6nxXulxfjNh7UDQ57McBIez2','2019-01-15 22:14:54');
INSERT INTO `user` (`id`, `username`, `password`, `date_Created`) VALUES (2,'user','$2a$10$40YaG7OfjVpLITEc3kAbwukHz4Qxuvo8abaBPssLJEQOGuPE6vM1O','2019-05-15 22:14:54');

INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (1, 1);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 1);
INSERT INTO `user_authority`(`authority_id`, `user_id`) VALUES (2, 2);
