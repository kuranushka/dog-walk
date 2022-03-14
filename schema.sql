-- DROP SCHEMA if exists public cascade;
-- CREATE SCHEMA public;

CREATE TABLE city
(
    id        BIGSERIAL PRIMARY KEY,
    name      VARCHAR(255)
);

CREATE TABLE citizenship
(
    id          BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255)
);
insert into role (id, role) values (1,'OWNER'), (2,'WALKER');
insert into city (id, name) values (1, 'Москва'), (2, 'Санкт-Петербург'), (3, 'Нижний Новгород');


SELECT a.id, a.username, a.password, r.role_id
FROM (SELECT id, username, password FROM owner UNION SELECT id, username, password FROM walker) as a
         JOIN (SELECT owner_id as id, role_id FROM owner_role UNION SELECT walker_id, role_id FROM walker_role) as r ON a.id=r.id
WHERE a.username = 'owner';
