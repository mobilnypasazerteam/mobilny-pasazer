INSERT INTO roles (id, role_name)
VALUES(1, 'ROLE_USER');

INSERT INTO roles (id, role_name)
VALUES(2, 'ROLE_ADMIN');

INSERT INTO passengers (id, username, password_hash)
VALUES(3, 'test@test.pl' , '/SYYcj80ELvw/L/9sei');$2a$10$GC8Ws8oKCPlFDuFEzOe90e9zCNp49vIeY7


INSERT INTO public.passengers (id, first_name, last_name, password_hash, phone, sex, username)
VALUES (1, 'test', 'user', '$2a$10$jGhgY09ndXO/YyVTucF2MurS4DIcLCuKaRYHH6f/GWy4hrXTst8eS', '12345678912', 0, 'Test@test.pl');