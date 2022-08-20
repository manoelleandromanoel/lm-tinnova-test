CREATE TABLE vehicle (
    id BIGSERIAL NOT NULL constraint pk_vehicle primary key,
    model VARCHAR(255) NOT NULL,
    brand INTEGER NOT NULL,
    year INTEGER NOT NULL,
    description VARCHAR NOT NULL,
    sold BOOLEAN NOT NULL DEFAULT FALSE,
    created TIMESTAMP NOT NULL DEFAULT Now(),
    updated TIMESTAMP NULL
);