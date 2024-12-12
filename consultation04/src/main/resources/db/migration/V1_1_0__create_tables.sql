CREATE TABLE IF NOT EXISTS product
(
    "id"    bigint primary key not null,
    "name"  varchar,
    "price" bigint
);

CREATE TABLE IF NOT EXISTS product_cart(
    "cart_id" bigint,
    "product_id" bigint

);

CREATE TABLE IF NOT EXISTS cart
(
    "id"    bigint primary key not null,
    "owner"  varchar
);


ALTER TABLE product_cart ADD CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES product(id);
ALTER TABLE product_cart ADD CONSTRAINT fk_cart_id FOREIGN KEY (cart_id) REFERENCES cart(id);

