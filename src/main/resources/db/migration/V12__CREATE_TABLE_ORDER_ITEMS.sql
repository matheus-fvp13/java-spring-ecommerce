CREATE TABLE order_items (
    product_id BIGINT NOT NULL,
    order_id BIGINT NOT NULL,
    quantity INTEGER NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    CONSTRAINT pk_order_itens PRIMARY KEY (product_id, order_id),
    CONSTRAINT oi_fk_product_id FOREIGN KEY (product_id) REFERENCES products(id),
    CONSTRAINT oi_fk_order_id FOREIGN KEY (order_id) REFERENCES orders(id)
);