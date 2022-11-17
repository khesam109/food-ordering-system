INSERT INTO restaurant.restaurants(id, name, active)
    VALUES ('99a32d81-492a-49dc-8f14-d6668a592954', 'restaurant_1', TRUE);
INSERT INTO restaurant.restaurants(id, name, active)
    VALUES ('97426d14-ea1c-4a3c-b26b-dc3db03385cf', 'restaurant_2', FALSE);


INSERT INTO restaurant.products(id, name, price, available)
    VALUES ('159d27ad-4f18-4b33-8a53-a0618f4b0980', 'product_1', '25.00', FALSE);
INSERT INTO restaurant.products(id, name, price, available)
    VALUES ('311384b0-5a61-4b2b-b48a-754fc70f47b3', 'product_2', '50.00', TRUE);
INSERT INTO restaurant.products(id, name, price, available)
    VALUES ('e8c6bca0-60e3-419d-a180-e3e6eff1365e', 'product_3', '20.00', FALSE);
INSERT INTO restaurant.products(id, name, price, available)
    VALUES ('9fe9a690-cb74-4f70-935f-5642deb1248a', 'product_4', '40.00', TRUE);



INSERT INTO restaurant.restaurant_products(id, restaurant_id, product_id)
    VALUES ('60ccc8fc-d204-4de4-88fa-6dd331ea7379', '99a32d81-492a-49dc-8f14-d6668a592954', '159d27ad-4f18-4b33-8a53-a0618f4b0980');
INSERT INTO restaurant.restaurant_products(id, restaurant_id, product_id)
    VALUES ('7432a7f3-134d-4823-a84f-7634eddd6c25', '99a32d81-492a-49dc-8f14-d6668a592954', '311384b0-5a61-4b2b-b48a-754fc70f47b3');
INSERT INTO restaurant.restaurant_products(id, restaurant_id, product_id)
    VALUES ('b0bf67c9-ab45-481d-a7de-54ea42689431', '97426d14-ea1c-4a3c-b26b-dc3db03385cf', 'e8c6bca0-60e3-419d-a180-e3e6eff1365e');
INSERT INTO restaurant.restaurant_products(id, restaurant_id, product_id)
    VALUES ('e0d95883-cae4-42a5-875f-cd0058b3be4b', '97426d14-ea1c-4a3c-b26b-dc3db03385cf', '9fe9a690-cb74-4f70-935f-5642deb1248a');