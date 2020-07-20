CREATE SEQUENCE user_seq START 1000000;
CREATE TABLE "user"
(
    id       BIGINT PRIMARY KEY DEFAULT nextval('user_seq'),
    email    VARCHAR(200) UNIQUE,
    phone    VARCHAR(200) UNIQUE,
    password VARCHAR(200) NOT NULL
);

CREATE SEQUENCE role_seq START 1000000;
CREATE TABLE role
(
    id    BIGINT PRIMARY KEY DEFAULT nextval('role_seq'),
    value VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE user_role
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES "user" (id),
    FOREIGN KEY (role_id) REFERENCES role (id)
);