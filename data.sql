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


insert into owner (name, password, username)
values ('Андрей', '$2a$12$yWRpJY12bNvkHUlW0Nx0r.FdyaWGm7AtNFS7LgfV6CVssGXby1Qbi', 'owner');
insert into owner_role (owner_id, role_id)
values (1, 1);

insert into walker ( name, password, username)
values ('Валентина', '$2a$12$yWRpJY12bNvkHUlW0Nx0r.FdyaWGm7AtNFS7LgfV6CVssGXby1Qbi', 'walker');
insert into walker_role (walker_id, role_id)
values (2, 2);



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

Москва
Санкт-Петербург
Новосибирск
Екатеринбург
Казань
Нижний Новгород
Челябинск
Самара
Омск
Ростов-на-Дону
Уфа
Красноярск
Воронеж
Пермь
Волгоград
Краснодар
Саратов
Тюмень
Тольятти
Ижевск
Барнаул
Ульяновск
Иркутск
Хабаровск
Махачкала
Ярославль
Владивосток
Оренбург
Томск
Кемерово
Новокузнецк
Рязань
Набережные Челны
Астрахань
Киров
Пенза
Севастополь
Балашиха
Липецк
Чебоксары
Калининград
Тула
Ставрополь
Курск
Улан-Удэ
Сочи
Тверь
Магнитогорск
Иваново
Брянск
Белгород
Сургут
Владимир
Чита
Архангельск
Нижний Тагил
Симферополь
Калуга
Якутск
Грозный
Волжский
Смоленск
Саранск
Череповец
Курган
Подольск
Вологда
Орёл
Владикавказ
Тамбов
Мурманск
Петрозаводск
Нижневартовск
Кострома
Йошкар-Ола
Новороссийск
Стерлитамак
Химки
Таганрог
Мытищи
Сыктывкар
Комсомольск-на-Амуре
Нижнекамск
Нальчик
Шахты
Дзержинск
Энгельс
Благовещенск
Королёв
Братск
Великий Новгород
Орск
Старый Оскол
Ангарск
Псков
Люберцы
Южно-Сахалинск
Бийск
Прокопьевск
Абакан
Армавир
Балаково
Норильск
Рыбинск
Северодвинск
Петропавловск-Камчатский
Красногорск
Уссурийск
Волгодонск
Новочеркасск
Сызрань
Каменск — Уральский
Златоуст
Альметьевск
Электросталь
Керчь
Миасс
Салават
Хасавюрт
Пятигорск
Копейск
Находка
Рубцовск
Майкоп
Коломна
Березники
Одинцово
Домодедово
Ковров
Нефтекамск
Каспийск
Нефтеюганск
Кисловодск
Новочебоксарск
Батайск
Щёлково
Дербент
Серпухов
Назрань
Раменское
Черкесск
Новомосковск
Кызыл
Первоуральск
Новый Уренгой
Орехово-Зуево
Долгопрудный
Обнинск
Невинномысск
Ессентуки
Октябрьский
Димитровград
Пушкино
Камышин
Ноябрьск
Евпатория
Реутов
Жуковский
Северск
Муром
Новошахтинск
Артем
Ачинск
Бердск
Элиста
Арзамас
Ханты-Мансийск
Ногинск
Елец
Железногорск
Сергиев Посад
Зеленодольск