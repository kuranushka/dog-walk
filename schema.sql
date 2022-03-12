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

