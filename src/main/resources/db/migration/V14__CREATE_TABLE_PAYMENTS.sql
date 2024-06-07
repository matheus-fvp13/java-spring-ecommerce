CREATE TABLE payments (
    order_id BIGINT NOT NULL,
    moment   TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_payments PRIMARY KEY (order_id),
    CONSTRAINT fk_payments_orders FOREIGN KEY (order_id) REFERENCES orders (id)
);
)