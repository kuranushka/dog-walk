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

