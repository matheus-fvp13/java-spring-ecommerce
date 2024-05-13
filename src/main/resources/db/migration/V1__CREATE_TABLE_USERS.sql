CREATE TABLE users
(
    id       BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name     VARCHAR(100)   NOT NULL,
    email    VARCHAR(100)   NOT NULL,
    phone    VARCHAR(15),
    password VARCHAR(255)   NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);