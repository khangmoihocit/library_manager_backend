CREATE TABLE user_catalogues
(
    id        BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    name      VARCHAR(50)                    NOT NULL,
    create_at timestamp DEFAULT NOW()        NULL,
    update_at timestamp DEFAULT NOW()        NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE users
(
    id                BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    user_catalogue_id BIGINT UNSIGNED                NULL,
    name              VARCHAR(50)                    NOT NULL,
    email             VARCHAR(100)                   NOT NULL,
    password          VARCHAR(200)                   NOT NULL,
    phone             VARCHAR(20)                    NOT NULL,
    address           VARCHAR(255)                   NULL,
    image             VARCHAR(255)                   NULL,
    create_at         timestamp DEFAULT NOW()        NULL,
    update_at         timestamp DEFAULT NOW()        NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT phone UNIQUE (phone);

ALTER TABLE users
    ADD CONSTRAINT fk_user_catalogue_id FOREIGN KEY (user_catalogue_id) REFERENCES user_catalogues (id) ON DELETE CASCADE;

CREATE INDEX fk_user_catalogue_id ON users (user_catalogue_id);
CREATE TABLE user_catalogues
(
    id        BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    name      VARCHAR(50)                    NOT NULL,
    create_at timestamp DEFAULT NOW()        NULL,
    update_at timestamp DEFAULT NOW()        NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE users
(
    id                BIGINT UNSIGNED AUTO_INCREMENT NOT NULL,
    user_catalogue_id BIGINT UNSIGNED                NULL,
    name              VARCHAR(50)                    NOT NULL,
    email             VARCHAR(100)                   NOT NULL,
    password          VARCHAR(200)                   NOT NULL,
    phone             VARCHAR(20)                    NOT NULL,
    address           VARCHAR(255)                   NULL,
    image             VARCHAR(255)                   NULL,
    create_at         timestamp DEFAULT NOW()        NULL,
    update_at         timestamp DEFAULT NOW()        NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT email UNIQUE (email);

ALTER TABLE users
    ADD CONSTRAINT phone UNIQUE (phone);

ALTER TABLE users
    ADD CONSTRAINT fk_user_catalogue_id FOREIGN KEY (user_catalogue_id) REFERENCES user_catalogues (id) ON DELETE CASCADE;

CREATE INDEX fk_user_catalogue_id ON users (user_catalogue_id);