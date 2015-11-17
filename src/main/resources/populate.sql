INSERT INTO credentials(username,password,enabled) VALUES ('anilkc','123456', 1);
INSERT INTO credentials(username,password,enabled) VALUES ('testuser','123456', 1);

INSERT INTO user_roles (username, role) VALUES (1, 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO user_roles (username, role) VALUES (2, 'ROLE_USER');

INSERT INTO tags VALUES (1,"Science");
INSERT INTO tags VALUES (2,"Technology");
INSERT INTO tags VALUES (3,"Programming");
INSERT INTO tags VALUES (4,"Gaming");
INSERT INTO tags VALUES (5,"Nature");
INSERT INTO tags VALUES (6,"Environment");
INSERT INTO tags VALUES (7,"Music");