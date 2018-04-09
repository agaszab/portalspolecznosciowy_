insert into user (username, password, enabled) values ('admin', '$2a$10$Pu2BzhYFCasFG4ddvJUjS.CjsnZomjiIX5Hj6jMvTWErSgiYsqFS.', true);
insert into user (username, password, enabled) values ('user', '$2a$10$7gtEnMCl9mvLbOJfubAfqO1I807vYYOVqxziMONPOIlX6/Q5HPUoC', true);

insert into user_role (username, role) values ('admin', 'ROLE_ADMIN');
insert into user_role (username, role) values ('user', 'ROLE_USER');