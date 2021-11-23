CREATE TABLE cars
(
    id      UUID         NOT NULL,
    name    VARCHAR(100) NOT NULL,
    color   VARCHAR(25)  NOT NULL,
    mileage INTEGER      NOT NULL,
    CONSTRAINT pk_cars PRIMARY KEY (id)
);

CREATE TABLE tasks
(
    id     UUID         NOT NULL,
    name   VARCHAR(100) NOT NULL,
    repeat INTEGER,
    status INTEGER      NOT NULL,
    car_id UUID         NOT NULL,
    CONSTRAINT pk_tasks PRIMARY KEY (id)
);

CREATE TABLE users
(
    id   UUID         NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE tasks
    ADD CONSTRAINT FK_TASKS_ON_CAR FOREIGN KEY (car_id) REFERENCES cars (id);
