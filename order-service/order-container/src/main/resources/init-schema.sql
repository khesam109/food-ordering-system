DROP SCHEMA IF EXISTS "food_order" CASCADE;
CREATE SCHEMA "food_order";

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TYPE IF EXISTS "food_order".order_status;
CREATE TYPE "food_order".order_status AS ENUM ('PENDING', 'PAID', 'APPROVED', 'CANCELLED', 'CANCELLING');

DROP TABLE IF EXISTS "food_order".orders CASCADE;
CREATE TABLE "food_order".orders
(
    id uuid NOT NULL,
    customer_id uuid NOT NULL,
    restaurant_id uuid NOT NULL,
    tracking_id uuid NOT NULL,
    price numeric(10, 2) NOT NULL,
    order_status "food_order".order_status NOT NULL,
    failure_messages character varying COLLATE pg_catalog."default",
    CONSTRAINT orders_pkey PRIMARY KEY (id)
);

DROP TABLE IF EXISTS "food_order".order_items CASCADE;
CREATE TABLE "food_order".order_items
(
    id bigint NOT NULL,
    order_id uuid NOT NULL,
    product_id uuid NOT NULL,
    price numeric(10, 2) NOT NULL,
    quantity integer NOT NULL,
    sub_total numeric(10, 2) NOT NULL,
    CONSTRAINT order_items_pkey PRIMARY KEY (id, order_id)
);
ALTER TABLE "food_order".order_items
    ADD CONSTRAINT "FK_ORDER_ID" FOREIGN KEY (order_id)
    REFERENCES "food_order".orders (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE
    NOT VALID;

DROP TABLE IF EXISTS "food_order".order_address CASCADE;
CREATE TABLE "food_order".order_address
(
    id uuid NOT NULL,
    order_id uuid NOT NULL,
    street character varying COLLATE pg_catalog."default",
    postal_code character varying COLLATE pg_catalog."default",
    city character varying COLLATE pg_catalog."default",
    CONSTRAINT order_address_pkey PRIMARY KEY (id, order_id)
);
ALTER TABLE "food_order".order_address
    ADD CONSTRAINT "FK_ORDER_ID" FOREIGN KEY (order_id)
    REFERENCES "food_order".orders (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE
    NOT VALID;















