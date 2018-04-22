insert into user (username, password, enabled, first_name, last_name, email, img) values ('admin', '$2a$10$Pu2BzhYFCasFG4ddvJUjS.CjsnZomjiIX5Hj6jMvTWErSgiYsqFS.', true, 'Jan', 'Kowalski', 'jan@kowalski.pl', 'https://banner.kisspng.com/20180402/bje/kisspng-computer-icons-avatar-login-user-avatar-5ac207e69ecd41.2588125315226654466505.jpg');
insert into user (username, password, enabled, first_name, last_name, email, img) values ('ania', '$2a$10$9SjNyDaTpPR7EhBf51ERH.m8pk.PNPouXQSMpNK28wS0F6wHg7vR6', true, 'Anna', 'Zawada', 'jakis@mail.pl', 'https://png.icons8.com/color/1600/circled-user-female-skin-type-1-2.png');
insert into user (username, password, enabled, first_name, last_name, email, img) values ('ola', '$2a$10$9SjNyDaTpPR7EhBf51ERH.m8pk.PNPouXQSMpNK28wS0F6wHg7vR6', true, 'Ola', 'Nowak', 'jakis@mail.pl','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4z_Qe_VuhpJP8Hw3VJatR62YnPREUrDB3DptSfi-a3e7WvIlW');
insert into user (username, password, enabled, first_name, last_name, email, img) values ('kasia', '$2a$10$9SjNyDaTpPR7EhBf51ERH.m8pk.PNPouXQSMpNK28wS0F6wHg7vR6', true, 'Kasia', 'Kot', 'jakis@mail.pl','');
insert into user (username, password, enabled, first_name, last_name, email, img) values ('basia','$2a$10$9SjNyDaTpPR7EhBf51ERH.m8pk.PNPouXQSMpNK28wS0F6wHg7vR6', false, 'Basia', 'Zając', 'jakis@mail.pl','');
insert into user (username, password, enabled, first_name, last_name, email, img) values ('asia','$2a$10$9SjNyDaTpPR7EhBf51ERH.m8pk.PNPouXQSMpNK28wS0F6wHg7vR6', true, 'Asia', 'Słowik', 'jakis@mail.pl','');
insert into user (username, password, enabled, first_name, last_name, email, img) values ('marysia','$2a$10$9SjNyDaTpPR7EhBf51ERH.m8pk.PNPouXQSMpNK28wS0F6wHg7vR6', false, 'Marysia', 'Kwiatek', 'jakis@mail.pl','');

insert into user_role (username, role) values ('admin', 'ROLE_ADMIN');
insert into user_role (username, role) values ('ania', 'ROLE_USER');
insert into user_role (username, role) values ('ola', 'ROLE_USER');
insert into user_role (username, role) values ('kasia', 'ROLE_USER');
insert into user_role (username, role) values ('basia', 'ROLE_USER');
insert into user_role (username, role) values ('asia', 'ROLE_USER');

INSERT INTO friends (fid, friend, friendname, uid,invitedname) VALUES (2,false,"ania",1,"admin");
INSERT INTO friends (fid, friend, friendname, uid,invitedname) VALUES (3,true,"ola",1,"admin");
INSERT INTO friends (fid, friend, friendname, uid,invitedname) VALUES (4,true,"kasia",1,"admin");
INSERT INTO friends (fid, friend, friendname, uid,invitedname) VALUES (4,true,"kasia",2,"ola");



