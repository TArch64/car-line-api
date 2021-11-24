INSERT INTO users (id, name)
VALUES ('f10c5132-51e2-4f16-94ed-707c36c5719d', 'TArch64');

INSERT INTO cars (id, name, color, mileage, user_id)
VALUES ('0e31ba9b-b313-4d93-b7b9-beb133ed0b38', 'Peugeot 207', '#fff', 15600, 'f10c5132-51e2-4f16-94ed-707c36c5719d');

INSERT INTO tasks (id, name, repeat, status, car_id)
VALUES ('6bcf3fc8-f10a-466c-af73-09c5bad5bffe', 'First Input', null, 'DONE', '0e31ba9b-b313-4d93-b7b9-beb133ed0b38')
