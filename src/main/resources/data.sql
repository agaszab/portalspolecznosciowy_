insert into user (username, password, enabled, first_name, last_name, email, img) values ('admin', '$2a$10$Pu2BzhYFCasFG4ddvJUjS.CjsnZomjiIX5Hj6jMvTWErSgiYsqFS.', true, 'Jan', 'Kowalski', 'jan@kowalski.pl');
insert into user (username, password, enabled, first_name, last_name, email) values ('ania', '$2a$10$9SjNyDaTpPR7EhBf51ERH.m8pk.PNPouXQSMpNK28wS0F6wHg7vR6', true, 'Marysia', 'Zawada', 'jakis@mail.pl');
insert into user (username, password, enabled, first_name, last_name, email) values ('ola', '$2a$10$9SjNyDaTpPR7EhBf51ERH.m8pk.PNPouXQSMpNK28wS0F6wHg7vR6', true, 'Ola', 'Nowak', 'jakis@mail.pl');
insert into user (username, password, enabled, first_name, last_name, email) values ('kasia', '$2a$10$9SjNyDaTpPR7EhBf51ERH.m8pk.PNPouXQSMpNK28wS0F6wHg7vR6', true, 'Kasia', 'Kot', 'jakis@mail.pl');
insert into user (username, password, enabled, first_name, last_name, email) values ('basia','$2a$10$9SjNyDaTpPR7EhBf51ERH.m8pk.PNPouXQSMpNK28wS0F6wHg7vR6', false, 'Basia', 'Zając', 'jakis@mail.pl');
insert into user (username, password, enabled, first_name, last_name, email, img) values ('asia','$2a$10$9SjNyDaTpPR7EhBf51ERH.m8pk.PNPouXQSMpNK28wS0F6wHg7vR6', true, 'Asia', 'Słowik', 'jakis@mail.pl');

insert into user_role (username, role) values ('admin', 'ROLE_ADMIN');
insert into user_role (username, role) values ('ania', 'ROLE_USER');
insert into user_role (username, role) values ('ola', 'ROLE_USER');
insert into user_role (username, role) values ('kasia', 'ROLE_USER');
insert into user_role (username, role) values ('basia', 'ROLE_USER');
insert into user_role (username, role) values ('asia', 'ROLE_USER');

