CREATE SEQUENCE user_id_seq START 1000000;
CREATE TABLE "user"
(
    id       BIGINT PRIMARY KEY DEFAULT nextval('user_id_seq'),
    email    TEXT UNIQUE,
    phone    TEXT UNIQUE,
    password TEXT NOT NULL
);

CREATE SEQUENCE role_id_seq START 1000000;
CREATE TABLE role
(
    id    BIGINT PRIMARY KEY DEFAULT nextval('role_id_seq'),
    name TEXT NOT NULL UNIQUE
);

CREATE TABLE user_role
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES "user" (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
);