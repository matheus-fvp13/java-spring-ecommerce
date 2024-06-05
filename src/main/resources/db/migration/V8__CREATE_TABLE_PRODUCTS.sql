CREATE TABLE products (
    id          BIGINT           GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    name        VARCHAR(100)     NOT NULL,
    description TEXT             NOT NULL,
    price       DECIMAL(10, 2) NOT NULL,
    img_url     VARCHAR(255)     NOT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
); 

ALTER TABLE products
    ADD CONSTRAINT uc_products_name UNIQUE (name);