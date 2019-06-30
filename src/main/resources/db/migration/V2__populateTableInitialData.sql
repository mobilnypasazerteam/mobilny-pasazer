INSERT INTO roles (id, role_name)
VALUES((SELECT nextval('hibernate_sequence')), 'ROLE_USER');

INSERT INTO roles (id, role_name)
VALUES((SELECT nextval('hibernate_sequence')), 'ROLE_ADMIN');

INSERT INTO public.passengers (id, first_name, last_name, password_hash, phone, sex, username)
VALUES ((SELECT nextval('hibernate_sequence')), 'test', 'user', '$2a$10$jGhgY09ndXO/YyVTucF2MurS4DIcLCuKaRYHH6f/GWy4hrXTst8eS', '12345678912', 0, 'Test@test.pl');

INSERT INTO PUBLIC.PASSENGERS_ROLES (PASSENGER_ID, ROLES_ID)
VALUES ((SELECT id
          FROM public.passengers
          WHERE username='Test@test.pl'),
        (SELECT id
          FROM roles
          WHERE role_name='ROLE_USER'));