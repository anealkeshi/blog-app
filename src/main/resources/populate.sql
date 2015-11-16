INSERT INTO credentials(username,password,enabled) VALUES ('anilkc','123456', 1);
INSERT INTO credentials(username,password,enabled) VALUES ('testuser','123456', 1);

INSERT INTO user_roles (username, role) VALUES (1, 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO user_roles (username, role) VALUES (2, 'ROLE_USER');