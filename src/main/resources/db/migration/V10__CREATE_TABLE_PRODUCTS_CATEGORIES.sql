CREATE TABLE products_categories (
    product_id  BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    CONSTRAINT pk_preducts_categories PRIMARY KEY (product_id, category_id)
);

ALTER TABLE products_categories
ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES products(id) ON UPDATE CASCADE;

ALTER TABLE products_categories
ADD CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES categories(id) ON UPDATE CASCADE;