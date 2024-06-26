CREATE TABLE orders
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    moment    TIMESTAMP WITHOUT TIME ZONE,
    client_id BIGINT,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

ALTER TABLE orders
    ADD CONSTRAINT FK_ORDERS_ON_CLIENT FOREIGN KEY (client_id) REFERENCES users (id);