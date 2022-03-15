-- DROP SCHEMA if exists public cascade;
-- CREATE SCHEMA public;

CREATE TABLE city
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE citizenship
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);
insert into role (id, role)
values (1, 'OWNER'),
       (2, 'WALKER');
insert into city (id, name)
values (1, 'Москва'),
       (2, 'Санкт-Петербург'),
       (3, 'Нижний Новгород');


insert into owner (id, name, password, username)
values (1, 'Андрей', '$2a$12$yWRpJY12bNvkHUlW0Nx0r.FdyaWGm7AtNFS7LgfV6CVssGXby1Qbi', 'owner');
insert into owner_role (owner_id, role_id)
values (1, 1);

insert into walker (id, name, password, username)
values (3, 'Валентина', '$2a$12$yWRpJY12bNvkHUlW0Nx0r.FdyaWGm7AtNFS7LgfV6CVssGXby1Qbi', 'walker');
insert into walker_role (walker_id, role_id)
values (3, 2);



SELECT CASE
           WHEN EXISTS(SELECT a.username
                       FROM (SELECT username FROM walker UNION SELECT username FROM owner) as a
                       WHERE username = 'owner1') THEN CAST(1 AS INT)
           ELSE CAST(0 AS INT) END;


SELECT a.id, a.username, a.password, r.role_id as role
FROM (SELECT id, username, password FROM owner UNION SELECT id, username, password FROM walker) as a
         JOIN (SELECT owner_id as id, role_id
               FROM owner_role
               UNION
               SELECT walker_id, role_id
               FROM walker_role) as r ON a.id = r.id
WHERE a.username = 'TimurRudnev';

SELECT *
FROM (SELECT username FROM owner UNION SELECT username FROM walker) as a
WHERE username = 'walker';