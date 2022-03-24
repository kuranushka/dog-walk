DROP TABLE IF EXISTS citizenship,
    city,dog, dog_aggression, dog_dog_documents,
    owner, owner_role, role, schedule, vet,
    walker, walker_role, walker_social_links, walking,
    owners_comment, walkers_comment CASCADE;

CREATE TABLE city
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE citizenship
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE owner
(
    id       BIGSERIAL PRIMARY KEY,
    mail     VARCHAR(255) NOT NULL,
    name     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone    VARCHAR(255) NOT NULL,
    surname  VARCHAR(255),
    username VARCHAR(255) NOT NULL
);

CREATE TABLE role
(
    id   BIGSERIAL PRIMARY KEY,
    role VARCHAR(255) NOT NULL
);

CREATE TABLE vet
(
    id      BIGSERIAL PRIMARY KEY,
    address VARCHAR(255),
    phone   VARCHAR(255)
);

CREATE TABLE owner_role
(
    owner_id BIGINT NOT NULL
        CONSTRAINT fk_owner_role_owner
            REFERENCES owner (id),
    role_id  BIGINT NOT NULL
        CONSTRAINT fk_owner_role_role
            REFERENCES role (id),
    PRIMARY KEY (owner_id, role_id)
);

CREATE TABLE walker
(
    id          BIGSERIAL PRIMARY KEY,
    birthday    DATE,
    citizenship VARCHAR(255),
    mail        VARCHAR(255) NOT NULL,
    name        VARCHAR(255),
    password    VARCHAR(255) NOT NULL,
    phone       VARCHAR(255) NOT NULL,
    surname     VARCHAR(255),
    username    VARCHAR(255) NOT NULL,
    city_id     BIGINT
        CONSTRAINT fk_walker_city
            REFERENCES city (id)
);

CREATE TABLE walker_role
(
    walker_id BIGINT NOT NULL
        CONSTRAINT fk_walker_role_walker
            REFERENCES walker (id),
    role_id   BIGINT NOT NULL
        CONSTRAINT fk_walker_role_role
            REFERENCES role (id),
    PRIMARY KEY (walker_id, role_id)
);

CREATE TABLE walker_social_links
(
    walker_id    BIGINT NOT NULL
        CONSTRAINT fk_walker_social_links_walker
            REFERENCES walker (id),
    social_links VARCHAR(255)
);

CREATE TABLE dog
(
    id                       BIGSERIAL PRIMARY KEY,
    addition_info            VARCHAR(1024),
    age                      VARCHAR(255),
    breed                    VARCHAR(255),
    fear                     VARCHAR(255),
    feed                     VARCHAR(255),
    gender                   VARCHAR(255),
    go_without_leash         VARCHAR(255),
    how_get_keys             VARCHAR(255),
    injury_id                VARCHAR(255),
    interact_with_other_dogs VARCHAR(255),
    meeting_to_walker        VARCHAR(255),
    name                     VARCHAR(255),
    pick_it_up               VARCHAR(255),
    pick_up_from_ground      VARCHAR(255),
    pulling_leash            VARCHAR(255),
    uuid                     VARCHAR(255),
    vet                      VARCHAR(255),
    wash_paws                VARCHAR(255),
    weight                   BIGINT,
    weight_group             VARCHAR(255),
    owner_id                 BIGINT
        CONSTRAINT fk_dog_owner_id
            REFERENCES owner (id)

);

CREATE TABLE schedule
(
    id     BIGSERIAL PRIMARY KEY,
    uuid   VARCHAR(255),
    dog_id BIGINT
        CONSTRAINT fk_schedule_dog
            REFERENCES dog (id)
);

ALTER TABLE dog
    ADD COLUMN schedule_id BIGINT
        CONSTRAINT fk_dog_schedule_id
            REFERENCES schedule (id);

CREATE TABLE dog_aggression
(
    dog_id     BIGINT
        CONSTRAINT fk_dog_aggression_dog
            REFERENCES dog (id),
    aggression VARCHAR(255)
);

CREATE TABLE dog_dog_documents
(
    dog_id    BIGINT
        CONSTRAINT fk_dog_dog_documents_dog
            REFERENCES dog (id),
    documents VARCHAR(255)
);

CREATE TABLE walking
(
    id               BIGSERIAL PRIMARY KEY,
    address          VARCHAR(255),
    location         VARCHAR(255),
    uuid             VARCHAR(255),
    walking_begin    TIME   NOT NULL,
    walking_date     DATE   NOT NULL,
    walking_duration BIGINT NOT NULL,
    walking_price    BIGINT NOT NULL,
    walking_status   VARCHAR(255),
    walker_id        BIGINT
        CONSTRAINT fk_waking_walker
            REFERENCES walker (id),
    city_id          BIGINT NOT NULL
        CONSTRAINT fk_walking_city
            REFERENCES city (id),
    dog_id           BIGINT NOT NULL
        CONSTRAINT fk_walking_dog
            REFERENCES dog (id),
    schedule_id      BIGINT
        CONSTRAINT fk_walking_schedule
            REFERENCES schedule (id),
    owner_id         BIGINT
        CONSTRAINT fk_walking_owner_id
            REFERENCES owner (id)
);

CREATE TABLE owners_comment
(
    id        BIGSERIAL PRIMARY KEY,
    owner_id  BIGINT NOT NULL
        CONSTRAINT fk_owners_comment_owners_id
            REFERENCES owner (id),
    walker_id BIGINT NOT NULL
        CONSTRAINT fk_owners_comment_walker_id
            REFERENCES walker (id),
    message   VARCHAR(2048)

);

CREATE TABLE walkers_comment
(
    id        BIGSERIAL PRIMARY KEY,
    walker_id BIGINT NOT NULL
        CONSTRAINT fk_walkers_comment_walker_id
            REFERENCES walker (id),
    owner_id  BIGINT NOT NULL
        CONSTRAINT fk_walkers_comment_owner_id
            REFERENCES owner (id),
    message   VARCHAR(2048)
);

insert into role (id, role)
values (1, 'OWNER'),
       (2, 'WALKER');
insert into city (id, name)
values (1, 'Москва'),
       (2, 'Санкт-Петербург'),
       (3, 'Новосибирск'),
       (4, 'Екатеринбург'),
       (5, 'Казань'),
       (6, 'Нижний Новгород'),
       (7, 'Челябинск'),
       (8, 'Самара'),
       (9, 'Омск'),
       (10, 'Ростов-на-Дону'),
       (11, 'Уфа'),
       (12, 'Красноярск'),
       (13, 'Воронеж'),
       (14, 'Пермь'),
       (15, 'Волгоград'),
       (16, 'Краснодар'),
       (17, 'Саратов'),
       (18, 'Тюмень'),
       (19, 'Тольятти'),
       (20, 'Ижевск'),
       (21, 'Барнаул'),
       (22, 'Ульяновск'),
       (23, 'Иркутск'),
       (24, 'Хабаровск'),
       (25, 'Махачкала'),
       (26, 'Ярославль'),
       (27, 'Владивосток'),
       (28, 'Оренбург'),
       (29, 'Томск'),
       (30, 'Кемерово'),
       (31, 'Новокузнецк'),
       (32, 'Рязань'),
       (33, 'Набережные Челны'),
       (34, 'Астрахань'),
       (35, 'Киров'),
       (36, 'Пенза'),
       (37, 'Севастополь'),
       (38, 'Балашиха'),
       (39, 'Липецк'),
       (40, 'Чебоксары'),
       (41, 'Калининград'),
       (42, 'Тула'),
       (43, 'Ставрополь'),
       (44, 'Курск'),
       (45, 'Улан-Удэ'),
       (46, 'Сочи'),
       (47, 'Тверь'),
       (48, 'Магнитогорск'),
       (49, 'Иваново'),
       (50, 'Брянск'),
       (51, 'Белгород'),
       (52, 'Сургут'),
       (53, 'Владимир'),
       (54, 'Чита'),
       (55, 'Архангельск'),
       (56, 'Нижний Тагил'),
       (57, 'Симферополь'),
       (58, 'Калуга'),
       (59, 'Якутск'),
       (60, 'Грозный'),
       (61, 'Волжский'),
       (62, 'Смоленск'),
       (63, 'Саранск'),
       (64, 'Череповец'),
       (65, 'Курган'),
       (66, 'Подольск'),
       (67, 'Вологда'),
       (68, 'Орёл'),
       (69, 'Владикавказ'),
       (70, 'Тамбов'),
       (71, 'Мурманск'),
       (72, 'Петрозаводск');


insert into owner (mail, name, password, phone, username)
values ('mail@mail.ru', 'Андрей', '$2a$12$yWRpJY12bNvkHUlW0Nx0r.FdyaWGm7AtNFS7LgfV6CVssGXby1Qbi', '495 09837 4765',
        'owner');
insert into owner_role (owner_id, role_id)
values (1, 1);


insert into walker (mail, name, password, phone, username, city_id)
values ('mail@mail.ru', 'Валентина', '$2a$12$yWRpJY12bNvkHUlW0Nx0r.FdyaWGm7AtNFS7LgfV6CVssGXby1Qbi', '92879237',
        'walker', 3);
insert into walker_role (walker_id, role_id)
values (1, 2);



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
