SELECT * FROM ss14_security_blog.blog;
INSERT INTO `ss14_security_blog`.`blog` (`id`, `content`, `date_create`, `status`, `title`, `id_category`) VALUES ('1', 'ádasd', '2022-08-08', 0, 'Mu vô đối',b'1');
INSERT INTO `ss14_security_blog`.`blog` (`id`, `content`, `date_create`, `status`, `title`, `id_category`) VALUES ('2', 'ádasd', '2022-08-12', 0, 'Liv lữ đoàn đỏ', '1');
INSERT INTO `ss14_security_blog`.`blog` (`id`, `content`, `date_create`, `status`, `title`, `id_category`) VALUES ('3','rghfgh', '2022-02-08', 0, 'Chè xanh', '1');
INSERT INTO `ss14_security_blog`.`blog` (`id`, `content`, `date_create`, `status`, `title`, `id_category`) VALUES ('4', 'dfgdfg', '2022-06-07', 0, 'Vạn cổ tà đế', '2');
INSERT INTO `ss14_security_blog`.`blog` (`id`, `content`, `date_create`, `status`, `title`, `id_category`) VALUES ('5', 'ádasd', '2022-08-02', 0, 'Vạn cổ đệ nhất tông', '2');
INSERT INTO `ss14_security_blog`.`blog` (`id`, `content`, `date_create`, `status`, `title`, `id_category`) VALUES ('6', '123', '2022-04-07',0, 'Tiên nghịch', '2');
INSERT INTO `ss14_security_blog`.`blog` (`id`, `content`, `date_create`, `status`, `title`, `id_category`) VALUES ('7', '123123', '2022-07-14', 0, 'Hana Shirato', '3');
INSERT INTO `ss14_security_blog`.`blog` (`id`, `content`, `date_create`, `status`, `title`, `id_category`) VALUES ('8', '123123', '2022-05-02', 0, 'Karen Yuzuriha', '3');
INSERT INTO `ss14_security_blog`.`blog` (`id`, `content`, `date_create`, `status`, `title`, `id_category`) VALUES ('9', '123', '2022-08-10', 0, 'Vo','2');
INSERT INTO `ss14_security_blog`.`blog` (`id`, `content`, `date_create`, `status`, `title`, `id_category`) VALUES ('10', '123', '2022-08-10', 0, 'Vo', '2');

use ss14_security_blog;

create table APP_USER ( USER_ID BIGINT not null,
						USER_NAME VARCHAR(36) not null,
						ENCRYTED_PASSWORD VARCHAR(128) not null,
						ENABLED BIT not null ) ;
alter table APP_USER add constraint APP_USER_PK primary key (USER_ID);
alter table APP_USER add constraint APP_USER_UK unique (USER_NAME);


create table APP_ROLE ( ROLE_ID BIGINT not null,
						ROLE_NAME VARCHAR(30) not null ) ;
alter table APP_ROLE add constraint APP_ROLE_PK primary key (ROLE_ID);
alter table APP_ROLE add constraint APP_ROLE_UK unique (ROLE_NAME);


create table USER_ROLE ( ID BIGINT not null, 
						USER_ID BIGINT not null,
						ROLE_ID BIGINT not null );
alter table USER_ROLE add constraint USER_ROLE_PK primary key (ID);
alter table USER_ROLE add constraint USER_ROLE_UK unique (USER_ID, ROLE_ID);
alter table USER_ROLE add constraint USER_ROLE_FK1 foreign key (USER_ID) references APP_USER (USER_ID);
alter table USER_ROLE add constraint USER_ROLE_FK2 foreign key (ROLE_ID) references APP_ROLE (ROLE_ID);

CREATE TABLE Persistent_Logins (

username varchar(64) not null,
series varchar(64) not null,
token varchar(64) not null,
last_used timestamp not null,
PRIMARY KEY (series)
);

insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) values (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
insert into App_User (USER_ID, USER_NAME, ENCRYTED_PASSWORD, ENABLED) values (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
insert into app_role (ROLE_ID, ROLE_NAME) values (1, 'ROLE_ADMIN');
insert into app_role (ROLE_ID, ROLE_NAME) values (2, 'ROLE_USER');
insert into user_role (ID, USER_ID, ROLE_ID) values (1, 1, 1);
insert into user_role (ID, USER_ID, ROLE_ID) values (2, 1, 2);
insert into user_role (ID, USER_ID, ROLE_ID) values (3, 2, 2);
